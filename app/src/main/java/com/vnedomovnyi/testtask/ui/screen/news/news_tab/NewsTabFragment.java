package com.vnedomovnyi.testtask.ui.screen.news.news_tab;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.vnedomovnyi.testtask.R;
import com.vnedomovnyi.testtask.entity.Article;
import com.vnedomovnyi.testtask.ui.activity.main.MainActivity;
import com.vnedomovnyi.testtask.ui.fragment.BaseFragment;
import com.vnedomovnyi.testtask.ui.screen.description.DescriptionFragment;
import com.vnedomovnyi.testtask.ui.screen.news.ArticleAdapter;
import com.vnedomovnyi.testtask.ui.screen.news.ArticleViewHolder;

import java.util.List;

import butterknife.BindView;

import static com.vnedomovnyi.testtask.ui.activity.main.MainActivity.FULLSCREEN_FRAGMENT_CONTAINER_ID;

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
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter.setOnArticleClickListener(onArticleClickListener);
    }

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

    @Override
    public void openDescriptionScreen(String description) {
        ((MainActivity) requireActivity())
                .getSupportFragmentManager()
                .beginTransaction()
                .replace(FULLSCREEN_FRAGMENT_CONTAINER_ID, DescriptionFragment.newInstance(description))
                .addToBackStack(null)
                .commit();
    }

    private final ArticleViewHolder.OnArticleClickListener onArticleClickListener =
            (article) -> getPresenter().handleArticleClick(article);

}
