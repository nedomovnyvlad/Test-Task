package com.vnedomovnyi.testtask.model;

import com.vnedomovnyi.testtask.util.observer.Observable;
import com.vnedomovnyi.testtask.util.observer.Subject;

import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import timber.log.Timber;

import static com.vnedomovnyi.testtask.Constants.UPDATE_INTERVAL_SECONDS;

public class UpdateDataModel {

    private final Set<UpdatableModel> models;

    private final ExecutorService workerExecutorService;

    private final ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();

    private final Executor mainExecutor;

    private final Subject<Boolean> loadingStatusSubject = new Subject<>(false);

    public UpdateDataModel(Set<UpdatableModel> models,
                           ExecutorService workerExecutorService,
                           Executor mainExecutor) {
        this.models = models;
        this.workerExecutorService = workerExecutorService;
        this.mainExecutor = mainExecutor;
    }

    public void startUpdating() {
        scheduleTask(0);
    }

    private void scheduleTask() {
        scheduleTask(UPDATE_INTERVAL_SECONDS);
    }

    private void scheduleTask(long delaySeconds) {
        scheduledExecutorService.schedule(this::runAndReschedule, delaySeconds, TimeUnit.SECONDS);
    }

    private void runAndReschedule() {
        mainExecutor.execute(() -> loadingStatusSubject.onUpdate(true));

        CountDownLatch countDownLatch = new CountDownLatch(models.size());

        for (UpdatableModel updatableModel : models) {
            workerExecutorService.execute(() -> {
                updatableModel.update();
                countDownLatch.countDown();
            });
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            Timber.e(e, "Failed to await.");
        }

        mainExecutor.execute(() -> loadingStatusSubject.onUpdate(false));
        scheduleTask();
    }

    public Observable<Boolean> getLoadingStatusObservable() {
        return loadingStatusSubject;
    }

}
