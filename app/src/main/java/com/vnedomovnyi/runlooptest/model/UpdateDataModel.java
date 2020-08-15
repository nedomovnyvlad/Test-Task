package com.vnedomovnyi.runlooptest.model;

import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import timber.log.Timber;

import static com.vnedomovnyi.runlooptest.Constants.UPDATE_INTERVAL_SECONDS;

public class UpdateDataModel {

    private final Set<UpdatableModel> models;

    private final ExecutorService workerExecutorService;

    private final ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();

    public UpdateDataModel(Set<UpdatableModel> models, ExecutorService workerExecutorService) {
        this.models = models;
        this.workerExecutorService = workerExecutorService;
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

        scheduleTask();
    }

}
