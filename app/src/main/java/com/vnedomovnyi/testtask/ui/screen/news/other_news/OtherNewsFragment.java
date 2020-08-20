package com.vnedomovnyi.testtask.ui.screen.news.other_news;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.vnedomovnyi.testtask.ui.screen.news.news_tab.NewsTabFragment;

import javax.inject.Inject;

public class OtherNewsFragment extends NewsTabFragment<OtherNewsPresenter> {

    @Inject
    @InjectPresenter
    OtherNewsPresenter presenter;

    public static OtherNewsFragment newInstance() {
        return new OtherNewsFragment();
    }

    @Override
    @ProvidePresenter
    protected OtherNewsPresenter getPresenter() {
        return presenter;
    }

}