package com.vnedomovnyi.testtask.ui.screen.news.lifestyle_news;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.vnedomovnyi.testtask.ui.screen.news.news_tab.NewsTabFragment;

import javax.inject.Inject;

public class LifestyleNewsFragment extends NewsTabFragment<LifestyleNewsPresenter> {

    @Inject
    @InjectPresenter
    LifestyleNewsPresenter presenter;

    public static LifestyleNewsFragment newInstance() {
        return new LifestyleNewsFragment();
    }

    @Override
    @ProvidePresenter
    protected LifestyleNewsPresenter getPresenter() {
        return presenter;
    }

}