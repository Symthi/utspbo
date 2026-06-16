import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BookStore store = new BookStore();
        int pilihan;

        do {
            System.out.println("\n=== SISTEM MANAJEMEN TOKO BUKU ===");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Tampilkan Semua Buku");
            System.out.println("3. Cari Buku");
            System.out.println("4. Update Stok");
            System.out.println("5. Hapus Buku");
            System.out.println("6. Terapkan Diskon (persentase)");
            System.out.println("7. Terapkan Diskon (tetap)");
            System.out.println("8. Tampilkan Total Nilai Toko");
            System.out.println("9. Keluar");
            System.out.print("Pilih menu (1-9): ");
            pilihan = scanner.nextInt();
            scanner.nextLine();

            // Percabangan 1: switch-case untuk menu
            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan judul: ");
                    String title = scanner.nextLine();
                    System.out.print("Masukkan penulis: ");
                    String author = scanner.nextLine();
                    System.out.print("Masukkan harga: ");
                    double price = scanner.nextDouble();
                    System.out.print("Masukkan stok: ");
                    int stock = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Pilih jenis buku (1: E-book, 2: Buku Cetak): ");
                    int type = scanner.nextInt();
                    scanner.nextLine();

                    // Percabangan 2: if-else untuk validasi jenis buku
                    if (type == 1) {
                        System.out.print("Masukkan ukuran file (MB): ");
                        double fileSize = scanner.nextDouble();
                        scanner.nextLine();
                        System.out.print("Masukkan format (misal PDF, EPUB): ");
                        String format = scanner.nextLine();
                        Ebook ebook = new Ebook(title, author, price, stock, fileSize, format);
                        store.addBook(ebook);
                    } else if (type == 2) {
                        System.out.print("Masukkan berat (gram): ");
                        double weight = scanner.nextDouble();
                        System.out.print("Masukkan jumlah halaman: ");
                        int pages = scanner.nextInt();
                        scanner.nextLine();
                        PrintedBook pbook = new PrintedBook(title, author, price, stock, weight, pages);
                        store.addBook(pbook);
                    } else {
                        System.out.println("Jenis tidak valid, buku tidak ditambahkan.");
                    }
                    break;

                case 2:
                    store.displayAllBooks();
                    break;

                case 3:
                    System.out.print("Masukkan judul buku yang dicari: ");
                    String searchTitle = scanner.nextLine();
                    Book found = store.searchBookByTitle(searchTitle);
                    if (found != null) {
                        System.out.println("Buku ditemukan:");
                        found.displayInfo();
                    } else {
                        System.out.println("Buku tidak ditemukan.");
                    }
                    break;

                case 4:
                    System.out.print("Masukkan judul buku yang akan diupdate stok: ");
                    String updateTitle = scanner.nextLine();
                    System.out.print("Masukkan stok baru: ");
                    int newStock = scanner.nextInt();
                    scanner.nextLine();
                    store.updateStock(updateTitle, newStock);
                    break;

                case 5:
                    System.out.print("Masukkan judul buku yang akan dihapus: ");
                    String removeTitle = scanner.nextLine();
                    store.removeBook(removeTitle);
                    break;

                case 6:
                    System.out.print("Masukkan persentase diskon (0-100): ");
                    double percent = scanner.nextDouble();
                    scanner.nextLine();
                    if (percent < 0 || percent > 100) {
                        System.out.println("Persentase tidak valid.");
                    } else {
                        store.applyDiscountToAll(percent);
                    }
                    break;

                case 7:
                    System.out.print("Masukkan jumlah diskon tetap (misal 5000): ");
                    double fixed = scanner.nextDouble();
                    scanner.nextLine();
                    if (fixed < 0) {
                        System.out.println("Diskon tidak boleh negatif.");
                    } else {
                        store.applyDiscountToAll(fixed, true);
                    }
                    break;

                case 8:
                    store.displayTotalValue();
                    break;

                case 9:
                    System.out.println("Terima kasih telah menggunakan sistem.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (pilihan != 9);

        scanner.close();
    }
}