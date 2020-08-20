package com.vnedomovnyi.testtask.di.module;

import com.vnedomovnyi.testtask.network.NewsService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

import static com.vnedomovnyi.testtask.Constants.BASE_URL;

@Module
public class RetrofitModule {

    @SuppressWarnings("deprecation")
    @Provides
    @Singleton
    Retrofit provideRetrofit(OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    NewsService provideNewsService(Retrofit retrofit) {
        return retrofit.create(NewsService.class);
    }

}
