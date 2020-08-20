package com.vnedomovnyi.testtask.ui.screen.news.news_tab;

import com.arellomobile.mvp.MvpPresenter;
import com.vnedomovnyi.testtask.entity.Article;
import com.vnedomovnyi.testtask.model.ChosenArticleModel;

import java.util.List;

public abstract class NewsTabPresenter extends MvpPresenter<NewsTabView> {

    private final ChosenArticleModel chosenArticleModel;

    public NewsTabPresenter(ChosenArticleModel chosenArticleModel) {
        this.chosenArticleModel = chosenArticleModel;
    }

    protected void setData(List<Article> articles) {
        getViewState().setData(articles);
    }

    void handleArticleClick(Article article) {
        chosenArticleModel.chooseArticle(article);
        getViewState().openDescriptionScreen(article.getDescription());
    }

}
