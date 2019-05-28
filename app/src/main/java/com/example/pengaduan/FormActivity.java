package com.example.pengaduan;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FormActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText et_nama, et_nim, et_mail, et_text;
    Spinner sp_kategori;
    Button kirim;

    ProgressDialog progressDialog;
    ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        Spinner spinner = findViewById(R.id.kategori);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.numbers, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        et_nama = findViewById(R.id.nama);
        et_nim = findViewById(R.id.nim);
        et_mail = findViewById(R.id.email);
        et_text = findViewById(R.id.et_text);
        sp_kategori = findViewById(R.id.kategori);
        kirim = findViewById(R.id.kirim);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Sedang diproses...");

        kirim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nama = et_nama.getText().toString().trim();
                String nim = et_nim.getText().toString().trim();
                String email = et_mail.getText().toString().trim();
                String kategori = sp_kategori.getSelectedItem().toString();
                String text = et_text.getText().toString().trim();

                if(nama.isEmpty()) {
                    et_nama.setError("Tidak boleh kosong");
                } else if (nim.isEmpty()) {
                    et_nim.setError("Tidak boleh kosong");
                } else if (email.isEmpty()) {
                    et_mail.setError("Tidak boleh kosong");
                } else if (text.isEmpty()) {
                    et_text.setError("Tidak boleh kosong");
                } else {
                    saveForm(nama, nim, email, kategori, text);
                }
            }
        });

    }

    private void saveForm(final String nama, final String nim, final String email, final String kategori, final String text) {

        progressDialog.show();

        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<FormModel> call = apiInterface.saveForm(nama, nim, email, kategori, text);

        call.enqueue(new Callback<FormModel>() {
            @Override
            public void onResponse(@NonNull Call<FormModel> call,@NonNull Response<FormModel> response) {
                progressDialog.dismiss();

                if (response.isSuccessful() && response.body() != null) {

                    Boolean success = response.body().getSuccess();
                    if(success) {
                        Toast.makeText(FormActivity.this, "Aduan diterima, cek email anda",Toast.LENGTH_SHORT).show();
                        finish();
//                      // back to main activity
                    } else {
                        Toast.makeText(FormActivity.this, response.body().getMessage(),Toast.LENGTH_SHORT).show();
                        // Still in this activity
                    }

                }

            }

            @Override
            public void onFailure(@NonNull Call<FormModel> call,@NonNull Throwable t) {

                progressDialog.dismiss();
                Toast.makeText(FormActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
