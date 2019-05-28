package com.example.pengaduan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        String get_kategori = getIntent().getStringExtra("kategori");
        String get_tanggal = getIntent().getStringExtra("tanggal");
        String get_masalah = getIntent().getStringExtra("masalah");
        String get_tanggapan = getIntent().getStringExtra("tanggapan");


        TextView data_1 = findViewById(R.id.view_kategori);
        data_1.setText(get_kategori);

        TextView data_2 = findViewById(R.id.view_tanggal);
        data_2.setText(get_tanggal);

        TextView data_3 = findViewById(R.id.view_tanya);
        data_3.setText(get_masalah);

        TextView data_4 = findViewById(R.id.view_tanggap);
        data_4.setText(get_tanggapan);

        Button back = findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



    }

}
