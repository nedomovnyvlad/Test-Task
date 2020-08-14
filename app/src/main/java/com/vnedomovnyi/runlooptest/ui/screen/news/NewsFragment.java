package com.vnedomovnyi.runlooptest.ui.screen.news;

import com.vnedomovnyi.runlooptest.R;
import com.vnedomovnyi.runlooptest.ui.fragment.BaseFragment;

public class NewsFragment extends BaseFragment {

    public static NewsFragment newInstance() {
        return new NewsFragment();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_news;
    }

}