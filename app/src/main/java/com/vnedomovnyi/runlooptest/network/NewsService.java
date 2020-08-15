package com.vnedomovnyi.runlooptest.network;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NewsService {

    @GET("rss/RSSLifestyle.xml")
    Call<NewsResponse> getLifestyleNews();

}
