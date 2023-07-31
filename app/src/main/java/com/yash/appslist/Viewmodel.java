package com.yash.appslist;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.yash.appslist.Resource;
//import androidx.lifecycle.ViewModel;
//import androidx.lifecycle.viewModelScope;

import com.yash.appslist.model.Input;

import java.io.IOException;

import kotlinx.coroutines.Dispatchers;
import retrofit2.Response;

public class Viewmodel extends ViewModel {
    private MutableLiveData<Resource<Input>> productAdd = new MutableLiveData<>();
    private Repository repository;

    public Viewmodel(Repository repository) {
        this.repository = repository;
    }

    public MutableLiveData<Resource<Input>> getProductAdd() {
        return productAdd;
    }

//    public void addProduct(Input product) {
//        viewModelScope.launch(Dispatchers.IO, () -> {
//            addSafeProduct(product);
//        });
//    }

    public void addSafeProduct(Input product) {

        productAdd.postValue(new Resource.Loading());
        try {
            Response<Input> response = repository.addProduct(product);
            Log.d("response", response.toString());
            if (response.isSuccessful()) {
                Input data = response.body();
                if (data != null) {
                    productAdd.postValue(new Resource.Success(data));
                }
            } else {
                productAdd.postValue(new Resource.Error(response.message()));
            }
        } catch (Throwable t) {
            productAdd.postValue(new Resource.Error(t.getMessage()));
        }
    }
}

