package com.example.data.net;

import com.example.data.net.ApiServices.ApiService;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by VictorGarcia on 11/2/16.
 */

public class ApiClient {

    private static final String API_BASE_URL = "https://jsonplaceholder.typicode.com/";

    private static OkHttpClient.Builder httpClient =
            new OkHttpClient.Builder().readTimeout(1, TimeUnit.MINUTES).connectTimeout(1, TimeUnit.MINUTES);

    private static HttpLoggingInterceptor logging =
            new HttpLoggingInterceptor()
                    .setLevel(HttpLoggingInterceptor.Level.BODY);

    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient.addInterceptor(logging).build())
                    .baseUrl(API_BASE_URL);

    public static ApiService getService() {
        return builder.build().create(ApiService.class);
    }
}
