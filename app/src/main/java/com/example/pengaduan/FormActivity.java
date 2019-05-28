package com.example.pengaduan;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class FormActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText et_nama, et_nim, et_mail, et_text;
    Spinner kategori;
    Button kirim;

    ProgressDialog progressDialog;

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
        kategori = findViewById(R.id.kategori);
        kirim = findViewById(R.id.kirim);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Sedang diproses...");

        kirim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveForm();
            }
        });

    }

    private void saveForm() {

        progressDialog.show();

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
