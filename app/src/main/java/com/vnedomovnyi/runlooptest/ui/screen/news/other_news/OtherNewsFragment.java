package com.vnedomovnyi.runlooptest.ui.screen.news.other_news;

import com.vnedomovnyi.runlooptest.R;
import com.vnedomovnyi.runlooptest.ui.fragment.BaseFragment;

public class OtherNewsFragment extends BaseFragment {

    public static OtherNewsFragment newInstance() {
        return new OtherNewsFragment();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_other_news;
    }

}