package com.vnedomovnyi.runlooptest.ui.screen.news;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.vnedomovnyi.runlooptest.R;
import com.vnedomovnyi.runlooptest.entity.Article;
import com.vnedomovnyi.runlooptest.ui.fragment.BaseFragment;

import java.util.List;

import butterknife.BindView;

public abstract class NewsTabFragment<Presenter extends NewsTabPresenter>
        extends BaseFragment implements NewsTabView {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    private ArticleAdapter adapter = new ArticleAdapter();

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_news_tab;
    }

    protected abstract Presenter getPresenter();

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(requireContext(), layoutManager.getOrientation()));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void setData(List<Article> articles) {
        adapter.setData(articles);
    }

}
