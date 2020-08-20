package com.vnedomovnyi.testtask.network;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NewsService {

    @GET("rss/RSSLifestyle.xml")
    Call<NewsResponse> getLifestyleNews();

    @GET("rss/RSSWSJD.xml")
    Call<NewsResponse> getWsjdNews();

    @GET("rss/RSSWorldNews.xml")
    Call<NewsResponse> getWorldNews();

}
