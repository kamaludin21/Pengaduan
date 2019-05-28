package com.example.pengaduan.main;

import android.support.annotation.NonNull;

import com.example.pengaduan.ApiClient;
import com.example.pengaduan.ApiInterface;
import com.example.pengaduan.FormModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter {

    private MainView view;

    public MainPresenter(MainView view) {

        this.view = view;

    }

    public void getData() {
        view.showLoading();
        // request server
        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

        Call<List<FormModel>> call = apiInterface.getForm();

        call.enqueue(new Callback<List<FormModel>>() {
            @Override
            public void onResponse(@NonNull Call<List<FormModel>> call,@NonNull Response<List<FormModel>> response) {
                view.hideLoading();
                if(response.isSuccessful() && response.body() != null) {
                    view.onGetResult(response.body());
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<FormModel>> call,@NonNull Throwable t) {
                view.hideLoading();
                view.onErrorLoading(t.getLocalizedMessage());
            }
        });


    }

}
