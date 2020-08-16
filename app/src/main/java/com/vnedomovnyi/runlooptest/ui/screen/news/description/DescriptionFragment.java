package com.vnedomovnyi.runlooptest.ui.screen.news.description;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.vnedomovnyi.runlooptest.R;
import com.vnedomovnyi.runlooptest.ui.fragment.BaseFragment;

import butterknife.BindView;

public class DescriptionFragment extends BaseFragment {

    private static final String KEY_DESCRIPTION = "KEY_DESCRIPTION";

    @BindView(R.id.text_description)
    TextView descriptionTextView;

    public static DescriptionFragment newInstance(String description) {
        Bundle args = new Bundle();
        args.putString(KEY_DESCRIPTION, description);

        DescriptionFragment fragment = new DescriptionFragment();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_description;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        descriptionTextView.setText(requireArguments().getString(KEY_DESCRIPTION, ""));
    }

}
