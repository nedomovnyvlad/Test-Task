package com.vnedomovnyi.runlooptest.ui.screen.news;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import com.vnedomovnyi.runlooptest.entity.Article;
import com.vnedomovnyi.runlooptest.util.recycler_view.BaseAdapter;

import java.util.List;

public class ArticleAdapter extends BaseAdapter<Article, ArticleViewHolder> {

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
        holder.bind(getItem(position));
    }

}
