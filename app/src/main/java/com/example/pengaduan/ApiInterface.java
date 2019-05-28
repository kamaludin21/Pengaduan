package com.example.pengaduan;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {

    @FormUrlEncoded
    @POST("save.php")
    Call<FormModel> saveForm(
            @Field("nama") String nama,
            @Field("nim") String nim,
            @Field("email") String email,
            @Field("kategori") String kategori,
            @Field("text") String text
    );

    @POST("view.php")
    Call<List<FormModel>> getForm();
}
