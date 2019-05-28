package com.example.pengaduan;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FormModel {

    @Expose
    @SerializedName("id") private int id;

    @Expose
    @SerializedName("name") private String nama;

    @Expose
    @SerializedName("nim") private String nim;

    @Expose
    @SerializedName("email") private String email;

    @Expose
    @SerializedName("kategori") private String kategori;

    @Expose
    @SerializedName("text") private String text;

    @Expose
    @SerializedName("masalah") private String masalah;

    @Expose
    @SerializedName("tanggapan") private String tanggapan;

    @Expose
    @SerializedName("tanggal") private String tanggal;

    @Expose
    @SerializedName("success") private Boolean success;

    @Expose
    @SerializedName("message") private String message;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getText() {
        return text;
    }

    public String getMasalah() {
        return masalah;
    }

    public void setMasalah(String masalah) {
        this.masalah = masalah;
    }

    public String getTanggapan() {
        return tanggapan;
    }

    public void setTanggapan(String tanggapan) {
        this.tanggapan = tanggapan;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
