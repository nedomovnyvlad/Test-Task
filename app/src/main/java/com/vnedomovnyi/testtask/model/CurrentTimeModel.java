package com.vnedomovnyi.testtask.model;

import com.vnedomovnyi.testtask.util.observer.Observable;
import com.vnedomovnyi.testtask.util.observer.Subject;

import org.threeten.bp.Duration;
import org.threeten.bp.LocalDateTime;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static org.threeten.bp.temporal.ChronoUnit.SECONDS;

public class CurrentTimeModel {

    private static final int SECONDS_INTERVAL = 1;

    private final ScheduledExecutorService workerExecutorService = Executors.newSingleThreadScheduledExecutor();

    private final Executor mainExecutor;

    private final Subject<LocalDateTime> currentDateTimeSubject = new Subject<>(getNowTimeTruncatedToSeconds());

    public CurrentTimeModel(Executor mainExecutor) {
        this.mainExecutor = mainExecutor;
        init();
    }

    private void init() {
        scheduleTask();
    }

    private void scheduleTask() {
        long delayMilli = Duration.between(
                LocalDateTime.now(),
                getNowTimeTruncatedToSeconds().plusSeconds(SECONDS_INTERVAL)
        )
                .toMillis();

        workerExecutorService.schedule(this::runAndReschedule, delayMilli, TimeUnit.MILLISECONDS);
    }

    private void runAndReschedule() {
        mainExecutor.execute(
                () -> currentDateTimeSubject.onUpdate(getNowTimeTruncatedToSeconds())
        );

        scheduleTask();
    }

    private LocalDateTime getNowTimeTruncatedToSeconds() {
        return LocalDateTime.now().truncatedTo(SECONDS);
    }

    public Observable<LocalDateTime> getCurrentTimeObservable() {
        return currentDateTimeSubject;
    }

}
