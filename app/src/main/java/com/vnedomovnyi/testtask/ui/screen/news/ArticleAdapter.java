package com.vnedomovnyi.testtask.ui.screen.news;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DiffUtil;

import com.vnedomovnyi.testtask.entity.Article;
import com.vnedomovnyi.testtask.util.recycler_view.BaseAdapter;

import java.util.List;

import lombok.Setter;

public class ArticleAdapter extends BaseAdapter<Article, ArticleViewHolder> {

    @Nullable
    @Setter
    private ArticleViewHolder.OnArticleClickListener onArticleClickListener;

    @Override
    protected DiffUtil.Callback getDiffCallback(List<Article> oldList, List<Article> newList) {
        return new ArticleDiffCallback(oldList, newList);
    }

    @NonNull
    @Override
    public ArticleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return ArticleViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleViewHolder holder, int position) {
        holder.bind(getItem(position), onArticleClickListener);
    }

}
