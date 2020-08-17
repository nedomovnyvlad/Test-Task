package com.vnedomovnyi.runlooptest.ui.screen.news;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.vnedomovnyi.runlooptest.R;
import com.vnedomovnyi.runlooptest.ui.fragment.BaseFragment;

import javax.inject.Inject;

import butterknife.BindView;

public class NewsFragment extends BaseFragment implements NewsView {

    @Inject
    @InjectPresenter
    NewsPresenter presenter;

    @BindView(R.id.view_pager)
    ViewPager viewPager;

    @BindView(R.id.view_loading)
    View loadingView;

    public static NewsFragment newInstance() {
        return new NewsFragment();
    }

    @ProvidePresenter
    NewsPresenter providePresenter() {
        return presenter;
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_news;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewPager.setAdapter(new NewsPagerAdapter(getChildFragmentManager(), getResources()));
    }

    @Override
    public void setLoadingVisibility(boolean isVisible) {
        loadingView.setVisibility(isVisible ? View.VISIBLE : View.GONE);
    }

}