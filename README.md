# 📚 Sistem Manajemen Toko Buku (BookStore Management System)

Aplikasi berbasis Java untuk mengelola inventaris toko buku, mendukung dua jenis buku: **E-book** dan **Buku Cetak**. Dibangun menggunakan prinsip-prinsip Object-Oriented Programming (OOP) seperti Enkapsulasi, Pewarisan, dan Polimorfisme.

---

## 📁 Struktur Proyek

```
BookStore/
├── Main.java          # Entry point aplikasi & antarmuka menu utama
├── Book.java          # Kelas induk (parent class) untuk semua jenis buku
├── Ebook.java         # Subkelas untuk buku digital (E-book)
├── PrintedBook.java   # Subkelas untuk buku cetak
└── BookStore.java     # Kelas manajemen koleksi buku
```

---

## 🧩 Deskripsi Kelas

### `Book.java` — Kelas Induk
Kelas dasar yang merepresentasikan buku secara umum.

| Field       | Tipe     | Keterangan                        |
|-------------|----------|-----------------------------------|
| `title`     | `String` | Judul buku                        |
| `author`    | `String` | Nama penulis                      |
| `price`     | `double` | Harga buku (tidak boleh negatif)  |
| `stock`     | `int`    | Jumlah stok (tidak boleh negatif) |

**Method utama:**
- `displayInfo()` — Menampilkan informasi buku
- `applyDiscount(double percentage)` — Menerapkan diskon persentase
- `applyDiscount(double fixedAmount, boolean isFixed)` — Menerapkan diskon tetap (overloading)

---

### `Ebook.java` — Subkelas E-book
Mewarisi `Book` dan menambahkan atribut khusus buku digital.

| Field        | Tipe     | Keterangan              |
|--------------|----------|-------------------------|
| `fileSizeMB` | `double` | Ukuran file dalam MB    |
| `format`     | `String` | Format file (PDF, EPUB) |

---

### `PrintedBook.java` — Subkelas Buku Cetak
Mewarisi `Book` dan menambahkan atribut khusus buku fisik.

| Field        | Tipe     | Keterangan                  |
|--------------|----------|-----------------------------|
| `weightGram` | `double` | Berat buku dalam gram       |
| `pageCount`  | `int`    | Jumlah halaman buku         |

---

### `BookStore.java` — Manajemen Toko
Mengelola koleksi buku menggunakan `ArrayList<Book>`.

**Method tersedia:**
| Method                                  | Keterangan                              |
|-----------------------------------------|-----------------------------------------|
| `addBook(Book book)`                    | Menambahkan buku ke koleksi             |
| `displayAllBooks()`                     | Menampilkan semua buku                  |
| `searchBookByTitle(String title)`       | Mencari buku berdasarkan judul          |
| `updateStock(String title, int stock)`  | Memperbarui stok buku                   |
| `removeBook(String title)`              | Menghapus buku dari koleksi             |
| `applyDiscountToAll(double percent)`    | Menerapkan diskon % ke semua buku       |
| `applyDiscountToAll(double amt, bool)`  | Menerapkan diskon tetap ke semua buku   |
| `getTotalValue()`                       | Menghitung total nilai inventaris       |
| `displayTotalValue()`                   | Menampilkan total nilai inventaris      |

---

### `Main.java` — Entry Point
Menyediakan antarmuka menu berbasis teks (CLI) menggunakan `Scanner`.

---

## 🖥️ Fitur Aplikasi

Saat dijalankan, aplikasi menampilkan menu interaktif dengan 9 pilihan:

```
=== SISTEM MANAJEMEN TOKO BUKU ===
1. Tambah Buku
2. Tampilkan Semua Buku
3. Cari Buku
4. Update Stok
5. Hapus Buku
6. Terapkan Diskon (persentase)
7. Terapkan Diskon (tetap)
8. Tampilkan Total Nilai Toko
9. Keluar
```

---

## 🔑 Konsep OOP yang Diterapkan

### 1. Enkapsulasi
Semua field pada kelas `Book`, `Ebook`, dan `PrintedBook` bersifat `private`. Akses hanya melalui getter dan setter yang dilengkapi validasi:
```java
public void setPrice(double price) {
    if (price < 0) {
        System.out.println("Harga tidak boleh negatif, diatur ke 0.");
        this.price = 0;
    } else {
        this.price = price;
    }
}
```

### 2. Pewarisan (Inheritance)
`Ebook` dan `PrintedBook` mewarisi kelas `Book`, sehingga tidak perlu mendefinisikan ulang field dan method dasar seperti `title`, `author`, `price`, dan `stock`.

```
Book
├── Ebook
└── PrintedBook
```

### 3. Polimorfisme Dinamis (Method Overriding)
Metode `displayInfo()` di-*override* pada masing-masing subkelas untuk menampilkan informasi tambahan yang relevan:
```java
// Di Ebook.java
@Override
public void displayInfo() {
    super.displayInfo();
    System.out.println("Jenis: E-book");
    System.out.println("Ukuran file: " + fileSizeMB + " MB");
    System.out.println("Format: " + format);
}
```

### 4. Polimorfisme Statis (Method Overloading)
Metode `applyDiscount` didefinisikan dengan dua versi berbeda dalam kelas `Book`:
```java
public void applyDiscount(double percentage)                    // Diskon persentase
public void applyDiscount(double fixedAmount, boolean isFixed)  // Diskon tetap
```
Pola yang sama diterapkan pada `applyDiscountToAll` di kelas `BookStore`.

---

## 🚀 Cara Menjalankan

### Prasyarat
- Java Development Kit (JDK) versi 8 atau lebih baru
- Terminal / Command Prompt

### Langkah Kompilasi

```bash
# Kompilasi semua file Java
javac Book.java Ebook.java PrintedBook.java BookStore.java Main.java
```

### Langkah Menjalankan

```bash
java Main
```

---

## 📋 Contoh Penggunaan

**Menambahkan E-book:**
```
Pilih menu (1-9): 1
Masukkan judul: Pemrograman Java Dasar
Masukkan penulis: Budi Santoso
Masukkan harga: 75000
Masukkan stok: 50
Pilih jenis buku (1: E-book, 2: Buku Cetak): 1
Masukkan ukuran file (MB): 12.5
Masukkan format (misal PDF, EPUB): PDF
Buku berhasil ditambahkan.
```

**Menerapkan Diskon Persentase:**
```
Pilih menu (1-9): 6
Masukkan persentase diskon (0-100): 10
Diskon 10.0% diterapkan. Harga baru: Rp67500.0
Diskon 10.0% diterapkan ke semua buku.
```

---

## ✅ Validasi & Penanganan Error

| Kondisi                        | Perilaku Sistem                              |
|--------------------------------|----------------------------------------------|
| Harga negatif                  | Diatur otomatis ke 0, tampil peringatan      |
| Stok negatif                   | Diatur otomatis ke 0, tampil peringatan      |
| Diskon melebihi harga          | Harga diatur ke 0, tampil peringatan         |
| Persentase diskon di luar 0–100| Operasi dibatalkan, tampil pesan error       |
| Buku tidak ditemukan           | Tampil pesan "Buku tidak ditemukan"          |
| Jenis buku tidak valid (selain 1/2) | Buku tidak ditambahkan, tampil pesan error |

---

## 👤 Informasi Proyek

| Atribut     | Detail                              |
|-------------|-------------------------------------|
| Bahasa      | Java                                |
| Paradigma   | Object-Oriented Programming (OOP)   |
| Platform    | Cross-platform (JVM)                |
| Antarmuka   | Command Line Interface (CLI)        |
