package com.example.data.net.ApiServices;


import com.example.data.entity.PostsEntity;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.POST;


public interface ApiService {


    @POST("CreditCardService/rest/financing/list")
    Call<List<PostsEntity>> listQuotes();

}
