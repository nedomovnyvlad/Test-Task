package com.vnedomovnyi.runlooptest.ui.screen.general;

import com.vnedomovnyi.runlooptest.R;
import com.vnedomovnyi.runlooptest.ui.fragment.BaseFragment;

public class GeneralFragment extends BaseFragment {

    public static GeneralFragment newInstance() {
        return new GeneralFragment();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_general;
    }

}
