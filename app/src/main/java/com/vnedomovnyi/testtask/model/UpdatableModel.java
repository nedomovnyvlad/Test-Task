package com.vnedomovnyi.testtask.model;

import androidx.annotation.WorkerThread;

public interface UpdatableModel {

    @WorkerThread
    void update();

}
