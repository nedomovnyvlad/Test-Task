package com.vnedomovnyi.runlooptest.ui.screen.news.lifestyle_news;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.vnedomovnyi.runlooptest.R;
import com.vnedomovnyi.runlooptest.ui.fragment.BaseFragment;

import javax.inject.Inject;

public class LifestyleNewsFragment extends BaseFragment implements LifestyleNewsView {

    @Inject
    @InjectPresenter
    LifestyleNewsPresenter presenter;

    public static LifestyleNewsFragment newInstance() {
        return new LifestyleNewsFragment();
    }

    @ProvidePresenter
    LifestyleNewsPresenter providePresenter() {
        return presenter;
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_lifestyle_news;
    }

}