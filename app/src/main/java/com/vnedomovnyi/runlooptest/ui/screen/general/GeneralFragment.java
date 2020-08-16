package com.vnedomovnyi.runlooptest.ui.screen.general;

import android.widget.TextView;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.vnedomovnyi.runlooptest.R;
import com.vnedomovnyi.runlooptest.ui.fragment.BaseFragment;

import javax.inject.Inject;

import butterknife.BindView;

public class GeneralFragment extends BaseFragment implements GeneralView {

    @Inject
    @InjectPresenter
    GeneralPresenter presenter;

    @BindView(R.id.text_time)
    TextView timeTextView;

    @BindView(R.id.text_article)
    TextView articleTextView;

    public static GeneralFragment newInstance() {
        return new GeneralFragment();
    }

    @ProvidePresenter
    GeneralPresenter providePresenter() {
        return presenter;
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_general;
    }

    @Override
    public void setTimeText(String text) {
        timeTextView.setText(text);
    }

    @Override
    public void setArticleText(String text) {
        articleTextView.setText(text);
    }

}
