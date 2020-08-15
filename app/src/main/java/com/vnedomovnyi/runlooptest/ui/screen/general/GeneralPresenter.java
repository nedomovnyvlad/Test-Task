package com.vnedomovnyi.runlooptest.ui.screen.general;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.vnedomovnyi.runlooptest.model.DataModel;
import com.vnedomovnyi.runlooptest.util.observer.Observer;

import org.threeten.bp.LocalDateTime;

@InjectViewState
public class GeneralPresenter extends MvpPresenter<GeneralView> {

    private final DataModel<LocalDateTime> dataModel;

    private final Observer<LocalDateTime> currentTimeObserver = (time) ->
            getViewState().setTimeText(time.toString());

    public GeneralPresenter(DataModel<LocalDateTime> dataModel) {
        this.dataModel = dataModel;
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        dataModel.getDataObservable().addObserver(currentTimeObserver);
    }

    @Override
    public void onDestroy() {
        dataModel.getDataObservable().removeObserver(currentTimeObserver);
        super.onDestroy();
    }

}
