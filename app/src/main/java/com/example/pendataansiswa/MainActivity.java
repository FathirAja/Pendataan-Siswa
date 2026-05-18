package com.example.pendataansiswa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private LinearLayout btnLihatData;
    private LinearLayout btnTambahData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Pendataan siswa");
        }

        btnLihatData = findViewById(R.id.btnLihatData);
        btnTambahData = findViewById(R.id.btnTambahData);

        btnLihatData.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, LihatDataActivity.class));
        });

        btnTambahData.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, TambahDataActivity.class));
        });
    }
}
