package com.example.pendataansiswa;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "pendataan_siswa.db";
    private static final int DATABASE_VERSION = 1;

    // Table
    public static final String TABLE_SISWA = "siswa";
    public static final String COL_ID = "id";
    public static final String COL_NIS = "nis";
    public static final String COL_NAMA = "nama";
    public static final String COL_KELAS = "kelas";
    public static final String COL_JENIS_KELAMIN = "jenis_kelamin";
    public static final String COL_ALAMAT = "alamat";

    private static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_SISWA + " (" +
                    COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COL_NIS + " TEXT NOT NULL, " +
                    COL_NAMA + " TEXT NOT NULL, " +
                    COL_KELAS + " TEXT, " +
                    COL_JENIS_KELAMIN + " TEXT, " +
                    COL_ALAMAT + " TEXT" +
                    ")";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SISWA);
        onCreate(db);
    }

    // INSERT
    public long insertSiswa(Siswa siswa) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_NIS, siswa.getNis());
        values.put(COL_NAMA, siswa.getNama());
        values.put(COL_KELAS, siswa.getKelas());
        values.put(COL_JENIS_KELAMIN, siswa.getJenisKelamin());
        values.put(COL_ALAMAT, siswa.getAlamat());
        long id = db.insert(TABLE_SISWA, null, values);
        db.close();
        return id;
    }

    // READ ALL
    public List<Siswa> getAllSiswa() {
        List<Siswa> list = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_SISWA, null, null, null, null, null, COL_ID + " DESC");
        if (cursor.moveToFirst()) {
            do {
                Siswa s = new Siswa(
                        cursor.getInt(cursor.getColumnIndexOrThrow(COL_ID)),
                        cursor.getString(cursor.getColumnIndexOrThrow(COL_NIS)),
                        cursor.getString(cursor.getColumnIndexOrThrow(COL_NAMA)),
                        cursor.getString(cursor.getColumnIndexOrThrow(COL_KELAS)),
                        cursor.getString(cursor.getColumnIndexOrThrow(COL_JENIS_KELAMIN)),
                        cursor.getString(cursor.getColumnIndexOrThrow(COL_ALAMAT))
                );
                list.add(s);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return list;
    }

    // UPDATE
    public int updateSiswa(Siswa siswa) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_NIS, siswa.getNis());
        values.put(COL_NAMA, siswa.getNama());
        values.put(COL_KELAS, siswa.getKelas());
        values.put(COL_JENIS_KELAMIN, siswa.getJenisKelamin());
        values.put(COL_ALAMAT, siswa.getAlamat());
        int rows = db.update(TABLE_SISWA, values, COL_ID + "=?", new String[]{String.valueOf(siswa.getId())});
        db.close();
        return rows;
    }

    // DELETE
    public int deleteSiswa(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        int rows = db.delete(TABLE_SISWA, COL_ID + "=?", new String[]{String.valueOf(id)});
        db.close();
        return rows;
    }
}
