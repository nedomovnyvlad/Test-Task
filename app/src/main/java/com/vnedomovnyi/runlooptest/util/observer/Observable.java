package com.vnedomovnyi.runlooptest.util.observer;

import java.util.HashSet;
import java.util.Set;

public class Observable<T> {

    protected final Set<Observer<T>> observers = new HashSet<>();

    public void addObserver(Observer<T> observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer<T> observer) {
        observers.remove(observer);
    }

}
