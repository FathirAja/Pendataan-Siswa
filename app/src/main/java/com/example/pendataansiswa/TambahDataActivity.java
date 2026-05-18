package com.example.pendataansiswa;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class TambahDataActivity extends AppCompatActivity {

    private EditText etNis, etNama, etKelas, etAlamat;
    private Spinner spinnerJenisKelamin;
    private Button btnSimpan;
    private DatabaseHelper dbHelper;

    // Edit mode
    private boolean isEditMode = false;
    private int editId = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_data);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Pendataan siswa");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        dbHelper = new DatabaseHelper(this);

        etNis = findViewById(R.id.etNis);
        etNama = findViewById(R.id.etNama);
        etKelas = findViewById(R.id.etKelas);
        spinnerJenisKelamin = findViewById(R.id.spinnerJenisKelamin);
        etAlamat = findViewById(R.id.etAlamat);
        btnSimpan = findViewById(R.id.btnSimpan);

        // Setup spinner jenis kelamin
        ArrayAdapter<CharSequence> adapter = new ArrayAdapter<CharSequence>(
                this,
                android.R.layout.simple_spinner_item,
                getResources().getStringArray(R.array.jenis_kelamin_array)
        ) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TextView tv = (TextView) view;
                tv.setTextColor(android.graphics.Color.parseColor("#333333")); // warna teks utama
                tv.setTextSize(14);
                return view;
            }

            @Override
            public View getDropDownView(int position, View convertView, ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                tv.setTextColor(android.graphics.Color.parseColor("#FFFFFF")); // warna teks dropdown
                tv.setTextSize(14);
                return view;
            }
        };
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerJenisKelamin.setAdapter(adapter);

        // Check if edit mode
        if (getIntent().hasExtra("siswa_id")) {
            isEditMode = true;
            editId = getIntent().getIntExtra("siswa_id", -1);
            etNis.setText(getIntent().getStringExtra("siswa_nis"));
            etNama.setText(getIntent().getStringExtra("siswa_nama"));
            etKelas.setText(getIntent().getStringExtra("siswa_kelas"));
            etAlamat.setText(getIntent().getStringExtra("siswa_alamat"));
            String jk = getIntent().getStringExtra("siswa_jk");
            if ("Perempuan".equals(jk)) {
                spinnerJenisKelamin.setSelection(1);
            } else {
                spinnerJenisKelamin.setSelection(0);
            }
            btnSimpan.setText("UPDATE");
        }

        btnSimpan.setOnClickListener(v -> simpanData());
    }

    private void simpanData() {
        String nis = etNis.getText().toString().trim();
        String nama = etNama.getText().toString().trim();
        String kelas = etKelas.getText().toString().trim();
        String jk = spinnerJenisKelamin.getSelectedItem().toString();
        String alamat = etAlamat.getText().toString().trim();

        if (TextUtils.isEmpty(nis)) {
            etNis.setError("NIS tidak boleh kosong");
            etNis.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(nama)) {
            etNama.setError("Nama tidak boleh kosong");
            etNama.requestFocus();
            return;
        }

        Siswa siswa = new Siswa(nis, nama, kelas, jk, alamat);

        if (isEditMode) {
            siswa.setId(editId);
            int result = dbHelper.updateSiswa(siswa);
            if (result > 0) {
                Toast.makeText(this, "Data berhasil diupdate", Toast.LENGTH_SHORT).show();
                finish();
            } else {
                Toast.makeText(this, "Gagal mengupdate data", Toast.LENGTH_SHORT).show();
            }
        } else {
            long id = dbHelper.insertSiswa(siswa);
            if (id > 0) {
                Toast.makeText(this, "Data berhasil disimpan", Toast.LENGTH_SHORT).show();
                finish();
            } else {
                Toast.makeText(this, "Gagal menyimpan data", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
