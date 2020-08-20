package com.vnedomovnyi.testtask.util.observer;

import androidx.annotation.Nullable;

public class Subject<T> extends Observable<T> implements Observer<T> {

    @Nullable
    private T currentValue;

    public Subject() {
    }

    public Subject(@Nullable T currentValue) {
        this.currentValue = currentValue;
    }

    @Override
    public void addObserver(Observer<T> observer) {
        super.addObserver(observer);

        if (currentValue != null) {
            observer.onUpdate(currentValue);
        }
    }

    @Override
    public void removeObserver(Observer<T> observer) {
        super.removeObserver(observer);
    }

    @Override
    public void onUpdate(T value) {
        currentValue = value;

        for (Observer<T> observer : observers) {
            observer.onUpdate(value);
        }
    }

}
