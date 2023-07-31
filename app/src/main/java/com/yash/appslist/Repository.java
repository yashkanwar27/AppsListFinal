package com.yash.appslist;

import android.util.Log;

import com.yash.appslist.model.Input;

import retrofit2.Call;
        import retrofit2.Callback;
        import retrofit2.Response;

public class Repository {


    public Response<Input> addProduct(Input product) {
        Call<Response<Input>> call = RetrofitInstance.getApi().addProduct(product);
        call.enqueue(new Callback<Response<Input>>() {
            @Override
            public void onResponse(Call<Response<Input>> call, Response<Response<Input>> response) {
                if (response.isSuccessful()) {
                    Response<Input> result = response.body();
                    if (result != null) {
                        Log.d("Success", result.body().toString());
//                        callback.onSuccess(result.body());
                    } else {
                        Log.d("Error", response.message().toString());
//                        callback.onError("Response body is null.");
                    }
                } else {
                    Log.d("Error", String.valueOf(response.code()));
                }
            }

            @Override
            public void onFailure(Call<Response<Input>> call, Throwable t) {
//                callback.onError("Failed to make the API call: " + t.getMessage());
            }
        });
        return null;
    }
//
//    public interface ProductCallback {
//        void onSuccess(Input product);
//        void onError(String errorMessage);
//    }
}

