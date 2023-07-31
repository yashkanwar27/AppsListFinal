package com.yash.appslist;

import com.yash.appslist.model.Input;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.POST;

    public interface Api {
        @POST("saveUser")
        Call<Response<Input>> addProduct(
                @Body Input product
        );
    }

