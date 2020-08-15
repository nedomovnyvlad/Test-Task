package com.vnedomovnyi.runlooptest.ui.screen.news.other_news;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.vnedomovnyi.runlooptest.R;
import com.vnedomovnyi.runlooptest.ui.fragment.BaseFragment;

import javax.inject.Inject;

public class OtherNewsFragment extends BaseFragment implements OtherNewsView {

    @Inject
    @InjectPresenter
    OtherNewsPresenter presenter;

    public static OtherNewsFragment newInstance() {
        return new OtherNewsFragment();
    }

    @ProvidePresenter
    OtherNewsPresenter providePresenter() {
        return presenter;
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_other_news;
    }

}