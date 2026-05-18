package com.example.pendataansiswa;

public class Siswa {
    private int id;
    private String nis;
    private String nama;
    private String kelas;
    private String jenisKelamin;
    private String alamat;

    public Siswa() {}

    public Siswa(int id, String nis, String nama, String kelas, String jenisKelamin, String alamat) {
        this.id = id;
        this.nis = nis;
        this.nama = nama;
        this.kelas = kelas;
        this.jenisKelamin = jenisKelamin;
        this.alamat = alamat;
    }

    public Siswa(String nis, String nama, String kelas, String jenisKelamin, String alamat) {
        this.nis = nis;
        this.nama = nama;
        this.kelas = kelas;
        this.jenisKelamin = jenisKelamin;
        this.alamat = alamat;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNis() { return nis; }
    public void setNis(String nis) { this.nis = nis; }

    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }

    public String getKelas() { return kelas; }
    public void setKelas(String kelas) { this.kelas = kelas; }

    public String getJenisKelamin() { return jenisKelamin; }
    public void setJenisKelamin(String jenisKelamin) { this.jenisKelamin = jenisKelamin; }

    public String getAlamat() { return alamat; }
    public void setAlamat(String alamat) { this.alamat = alamat; }
}
