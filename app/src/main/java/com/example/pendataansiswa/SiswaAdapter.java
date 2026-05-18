package com.example.pendataansiswa;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SiswaAdapter extends RecyclerView.Adapter<SiswaAdapter.ViewHolder> {

    private Context context;
    private List<Siswa> listSiswa;
    private DatabaseHelper dbHelper;
    private Runnable onDataChanged;

    public SiswaAdapter(Context context, List<Siswa> listSiswa, DatabaseHelper dbHelper, Runnable onDataChanged) {
        this.context = context;
        this.listSiswa = listSiswa;
        this.dbHelper = dbHelper;
        this.onDataChanged = onDataChanged;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_siswa, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Siswa siswa = listSiswa.get(position);
        holder.tvNis.setText("NIS : " + siswa.getNis());
        holder.tvNama.setText("NAMA : " + siswa.getNama());
        holder.tvKelas.setText("KELAS : " + siswa.getKelas());
        holder.tvJk.setText("JENIS KELAMIN : " + siswa.getJenisKelamin());
        holder.tvAlamat.setText("ALAMAT : " + siswa.getAlamat());

        holder.btnEdit.setOnClickListener(v -> {
            Intent intent = new Intent(context, TambahDataActivity.class);
            intent.putExtra("siswa_id", siswa.getId());
            intent.putExtra("siswa_nis", siswa.getNis());
            intent.putExtra("siswa_nama", siswa.getNama());
            intent.putExtra("siswa_kelas", siswa.getKelas());
            intent.putExtra("siswa_jk", siswa.getJenisKelamin());
            intent.putExtra("siswa_alamat", siswa.getAlamat());
            context.startActivity(intent);
        });

        holder.btnHapus.setOnClickListener(v -> {
            new AlertDialog.Builder(context)
                    .setTitle("Hapus Data")
                    .setMessage("Yakin ingin menghapus data " + siswa.getNama() + "?")
                    .setPositiveButton("Hapus", (dialog, which) -> {
                        int result = dbHelper.deleteSiswa(siswa.getId());
                        if (result > 0) {
                            listSiswa.remove(position);
                            notifyItemRemoved(position);
                            notifyItemRangeChanged(position, listSiswa.size());
                            Toast.makeText(context, "Data berhasil dihapus", Toast.LENGTH_SHORT).show();
                            if (onDataChanged != null) onDataChanged.run();
                        } else {
                            Toast.makeText(context, "Gagal menghapus data", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .setNegativeButton("Batal", null)
                    .show();
        });
    }

    @Override
    public int getItemCount() {
        return listSiswa.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNis, tvNama, tvKelas, tvJk, tvAlamat;
        Button btnEdit, btnHapus;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNis = itemView.findViewById(R.id.tvNis);
            tvNama = itemView.findViewById(R.id.tvNama);
            tvKelas = itemView.findViewById(R.id.tvKelas);
            tvJk = itemView.findViewById(R.id.tvJk);
            tvAlamat = itemView.findViewById(R.id.tvAlamat);
            btnEdit = itemView.findViewById(R.id.btnEdit);
            btnHapus = itemView.findViewById(R.id.btnHapus);
        }
    }
}
