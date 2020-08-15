package com.vnedomovnyi.runlooptest.model;

import androidx.annotation.WorkerThread;

public interface UpdatableModel {

    @WorkerThread
    void update();

}
