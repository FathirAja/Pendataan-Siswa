<div align="center">

# 📚 Pendataan Siswa

![Android](https://img.shields.io/badge/Android-3DDC84?style=for-the-badge&logo=android&logoColor=white)
![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![SQLite](https://img.shields.io/badge/SQLite-07405E?style=for-the-badge&logo=sqlite&logoColor=white)
![Android Studio](https://img.shields.io/badge/Android_Studio-3DDC84?style=for-the-badge&logo=android-studio&logoColor=white)

**Aplikasi Android untuk manajemen data siswa berbasis SQLite**

Kelola data siswa dengan mudah — tambah, edit, hapus, dan lihat data tersimpan secara lokal di perangkat.

---

## ⬇️ Download Aplikasi

<a href="https://drive.google.com/drive/folders/1O4dwLgIcVEQU5gwuG1Jxk8Cp-2NLSeMx?usp=sharing">
  <img src="https://img.shields.io/badge/⬇️%20Download%20APK-5B6FD4?style=for-the-badge&logoColor=white" alt="Download APK"/>
</a>

</div>

## 📱 Tampilan Aplikasi

| Splash Screen | Menu Utama | Tambah Data | Lihat Data |
|:---:|:---:|:---:|:---:|
| ![Splash](screenshots/splash.png) | ![Menu](screenshots/menu.png) | ![Form](screenshots/form.png) | ![List](screenshots/list.png) |

---

## ✨ Fitur Aplikasi

- 🔵 **Splash Screen** — Animasi pembuka otomatis 2.5 detik
- 🏠 **Menu Utama** — Navigasi ke Lihat Data & Tambah Data
- ➕ **Tambah Data** — Form input siswa baru dengan validasi
- 📋 **Lihat Data** — Daftar semua siswa menggunakan RecyclerView
- ✏️ **Edit Data** — Klik tombol Edit, form terisi otomatis
- 🗑️ **Hapus Data** — Dialog konfirmasi sebelum menghapus
- 💾 **SQLite** — Data tersimpan permanen di perangkat tanpa internet

---

## 🗄️ Struktur Database

**Nama Database:** `pendataan_siswa.db` &nbsp;|&nbsp; **Tabel:** `siswa`

| Kolom | Tipe | Keterangan |
|-------|------|------------|
| `id` | INTEGER | Primary Key, Autoincrement |
| `nis` | TEXT | Nomor Induk Siswa |
| `nama` | TEXT | Nama lengkap siswa |
| `kelas` | TEXT | Kelas siswa |
| `jenis_kelamin` | TEXT | Laki-laki / Perempuan |
| `alamat` | TEXT | Alamat lengkap siswa |

---

## 🚀 Cara Menjalankan Project

### Prasyarat
- ✅ Android Studio **Hedgehog** atau lebih baru
- ✅ JDK 8+
- ✅ Android SDK minimum **API 21 (Android 5.0 Lollipop)**

### 1. Clone Repository
```bash
git clone https://github.com/FathirAja/Pendataan-Siswa.git
cd PendataanSiswa
```

### 2. Buka di Android Studio
```
1. Buka Android Studio
2. Pilih File → Open
3. Arahkan ke folder hasil clone
4. Tunggu Gradle Sync selesai
5. Klik Run atau tekan Shift + F10
```

### 3. Jalankan di Emulator / HP
- **Emulator:** Buat AVD di Device Manager, pilih API 21+
- **HP langsung:** Aktifkan Developer Options + USB Debugging, lalu colok ke PC
- 
---

## 📁 Struktur Project

```
PendataanSiswa/
├── app/
│   └── src/main/
│       ├── java/com/example/pendataansiswa/
│       │   ├── 📄 DatabaseHelper.java      ← SQLite CRUD
│       │   ├── 📄 Siswa.java               ← Model data
│       │   ├── 📄 SplashActivity.java      ← Halaman splash
│       │   ├── 📄 MainActivity.java        ← Menu utama
│       │   ├── 📄 TambahDataActivity.java  ← Form tambah/edit
│       │   ├── 📄 LihatDataActivity.java   ← Daftar siswa
│       │   └── 📄 SiswaAdapter.java        ← RecyclerView Adapter
│       ├── res/
│       │   ├── layout/
│       │   │   ├── activity_splash.xml
│       │   │   ├── activity_main.xml
│       │   │   ├── activity_tambah_data.xml
│       │   │   ├── activity_lihat_data.xml
│       │   │   └── item_siswa.xml
│       │   ├── drawable/
│       │   │   └── bg_*.xml
│       │   └── values/
│       │       ├── strings.xml
│       │       ├── colors.xml
│       │       └── themes.xml
│       └── AndroidManifest.xml
├── screenshots/
└── README.md
```

---

## 🛠️ Teknologi yang Digunakan

| Teknologi | Versi | Keterangan |
|-----------|-------|------------|
| Java | 8+ | Bahasa pemrograman utama |
| SQLite | built-in | Database lokal perangkat |
| RecyclerView | 1.3.2 | Tampilan daftar data |
| Material Components | 1.11.0 | Komponen UI modern |
| AlertDialog | built-in | Dialog konfirmasi hapus |

---

<div align="center">

Dibuat dengan ❤️ menggunakan **Android Studio** & **Java**

⭐ JEONGMAL GOMAWOYO

</div>
