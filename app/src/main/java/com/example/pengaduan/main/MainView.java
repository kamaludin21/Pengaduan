package com.example.pengaduan.main;

import com.example.pengaduan.FormModel;

import java.util.List;

public interface MainView {

    void showLoading();
    void hideLoading();
    void onGetResult(List<FormModel> forms);
    void onErrorLoading(String message);
}
