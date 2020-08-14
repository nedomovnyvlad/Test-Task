package com.vnedomovnyi.runlooptest.ui.screen.general;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.vnedomovnyi.runlooptest.model.CurrentTimeModel;
import com.vnedomovnyi.runlooptest.util.observer.Observer;

import org.threeten.bp.LocalDateTime;

@InjectViewState
public class GeneralPresenter extends MvpPresenter<GeneralView> {

    private final CurrentTimeModel currentTimeModel;

    private final Observer<LocalDateTime> currentTimeObserver = (time) ->
            getViewState().setTimeText(time.toString());

    public GeneralPresenter(CurrentTimeModel currentTimeModel) {
        this.currentTimeModel = currentTimeModel;
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        currentTimeModel.getCurrentTimeObservable().addObserver(currentTimeObserver);
    }

    @Override
    public void onDestroy() {
        currentTimeModel.getCurrentTimeObservable().removeObserver(currentTimeObserver);
        super.onDestroy();
    }

}
