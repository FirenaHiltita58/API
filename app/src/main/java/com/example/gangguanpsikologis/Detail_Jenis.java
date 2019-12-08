package com.example.gangguanpsikologis;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Detail_Jenis extends AppCompatActivity {

    public static String EXTRA_JENIS = "extra_jenis";
    TextView tvNama, tvPenjelasan;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail__jenis);

        tvNama = findViewById(R.id.tvNama);
        tvPenjelasan = findViewById(R.id.tvPenjelasan);


        JenisItem jenisItem =  getIntent().getParcelableExtra(EXTRA_JENIS);

        String nama = jenisItem.getNama();
        String penjelasan = jenisItem.getPenjelasan();

        tvNama.setText(nama);
        tvPenjelasan.setText(penjelasan);


    }
}
