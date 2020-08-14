package com.vnedomovnyi.runlooptest.ui.screen.news.lifestyle_news;

import com.vnedomovnyi.runlooptest.R;
import com.vnedomovnyi.runlooptest.ui.fragment.BaseFragment;

public class LifestyleNewsFragment extends BaseFragment {

    public static LifestyleNewsFragment newInstance() {
        return new LifestyleNewsFragment();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_lifestyle_news;
    }

}