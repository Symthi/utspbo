import java.util.ArrayList;
import java.util.List;

public class BookStore {
    private List<Book> books;

    public BookStore() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Buku berhasil ditambahkan.");
    }

    public void displayAllBooks() {
        if (books.isEmpty()) {
            System.out.println("Tidak ada buku dalam toko.");
            return;
        }
        System.out.println("=== Daftar Buku ===");
        for (int i = 0; i < books.size(); i++) {
            System.out.println("Buku ke-" + (i+1));
            books.get(i).displayInfo();
            System.out.println("-------------------");
        }
    }

    public Book searchBookByTitle(String title) {
        for (Book b : books) {
            if (b.getTitle().equalsIgnoreCase(title)) {
                return b;
            }
        }
        return null;
    }

    public boolean updateStock(String title, int newStock) {
        Book book = searchBookByTitle(title);
        if (book != null) {
            book.setStock(newStock);
            System.out.println("Stok berhasil diperbarui.");
            return true;
        } else {
            System.out.println("Buku tidak ditemukan.");
            return false;
        }
    }

    public boolean removeBook(String title) {
        Book book = searchBookByTitle(title);
        if (book != null) {
            books.remove(book);
            System.out.println("Buku berhasil dihapus.");
            return true;
        } else {
            System.out.println("Buku tidak ditemukan.");
            return false;
        }
    }

    // Overloading method untuk diskon persentase
    public void applyDiscountToAll(double percentage) {
        if (books.isEmpty()) {
            System.out.println("Tidak ada buku untuk didiskon.");
            return;
        }
        for (Book b : books) {
            b.applyDiscount(percentage);
        }
        System.out.println("Diskon " + percentage + "% diterapkan ke semua buku.");
    }

    // Overloading method untuk diskon tetap
    public void applyDiscountToAll(double fixedAmount, boolean isFixed) {
        if (books.isEmpty()) {
            System.out.println("Tidak ada buku untuk didiskon.");
            return;
        }
        for (Book b : books) {
            b.applyDiscount(fixedAmount, isFixed);
        }
        System.out.println("Diskon tetap Rp" + fixedAmount + " diterapkan ke semua buku.");
    }

    public double getTotalValue() {
        double total = 0;
        for (Book b : books) {
            total += b.getPrice() * b.getStock();
        }
        return total;
    }

    public void displayTotalValue() {
        System.out.println("Total nilai semua buku: Rp" + getTotalValue());
    }
}