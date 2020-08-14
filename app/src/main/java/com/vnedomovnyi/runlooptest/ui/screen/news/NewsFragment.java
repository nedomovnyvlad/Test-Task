package com.vnedomovnyi.runlooptest.ui.screen.news;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

import com.vnedomovnyi.runlooptest.R;
import com.vnedomovnyi.runlooptest.ui.fragment.BaseFragment;

import butterknife.BindView;

public class NewsFragment extends BaseFragment {

    @BindView(R.id.view_pager)
    ViewPager viewPager;

    public static NewsFragment newInstance() {
        return new NewsFragment();
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

}