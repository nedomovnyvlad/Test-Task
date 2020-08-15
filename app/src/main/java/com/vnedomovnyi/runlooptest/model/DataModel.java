package com.vnedomovnyi.runlooptest.model;

import com.vnedomovnyi.runlooptest.util.observer.Observable;

public interface DataModel<T> {

    Observable<T> getDataObservable();

}
