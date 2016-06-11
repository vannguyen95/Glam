package com.example.annie.glam;

import android.util.Base64;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Nam Nguyen on 11/06/2016.
 */
public class BasicAuthInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {

        Request.Builder requestBuilder = chain.request().newBuilder();

        String username = "ck_638f9429c2f63e8a1b6961578cf85e488e15c148";
        String password = "cs_1e19e58504bcb899fd3617631b6c462c1e20cb44";
        String credentials = username + ":" + password;
        final String basic = "Basic " + Base64.encodeToString(credentials.getBytes(), Base64.NO_WRAP);
        requestBuilder.addHeader("Authorization", basic);
        return chain.proceed(requestBuilder.build());
    }
}
