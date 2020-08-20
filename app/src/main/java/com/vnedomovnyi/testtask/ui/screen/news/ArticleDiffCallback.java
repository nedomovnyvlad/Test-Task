package com.vnedomovnyi.testtask.ui.screen.news;

import com.vnedomovnyi.testtask.entity.Article;
import com.vnedomovnyi.testtask.util.recycler_view.BaseDiffCallback;

import java.util.List;

public class ArticleDiffCallback extends BaseDiffCallback<Article> {

    public ArticleDiffCallback(List<Article> oldList, List<Article> newList) {
        super(oldList, newList);
    }

    @Override
    protected boolean areItemsTheSame(Article oldItem, Article newItem) {
        return oldItem.getTitle().equals(newItem.getTitle());
    }

}
