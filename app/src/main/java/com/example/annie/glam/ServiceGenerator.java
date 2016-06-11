package com.example.annie.glam;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Nam Nguyen on 11/06/2016.
 */
public class ServiceGenerator {

    private static  String BASE_URL = "http://54.169.197.249/wc-api/v3/";

    private static OkHttpClient.Builder okHttpBuilder = new OkHttpClient.Builder()
            .addInterceptor(new BasicAuthInterceptor());
    private static Retrofit.Builder retrofitBuilder = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create());

    public static <S> S createService (Class<S> serviceClass){
        Retrofit retrofit = retrofitBuilder.client(okHttpBuilder.build()).build();
        return retrofit.create(serviceClass);
    }
}
