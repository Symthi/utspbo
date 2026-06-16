public class Book {
    private String title;
    private String author;
    private double price;
    private int stock;

    public Book(String title, String author, double price, int stock) {
        this.title = title;
        this.author = author;
        setPrice(price);
        setStock(stock);
    }

    // Getter dan Setter dengan validasi (Encapsulation)
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public double getPrice() { return price; }
    public void setPrice(double price) {
        if (price < 0) {
            System.out.println("Harga tidak boleh negatif, diatur ke 0.");
            this.price = 0;
        } else {
            this.price = price;
        }
    }

    public int getStock() { return stock; }
    public void setStock(int stock) {
        if (stock < 0) {
            System.out.println("Stok tidak boleh negatif, diatur ke 0.");
            this.stock = 0;
        } else {
            this.stock = stock;
        }
    }

    // Method yang akan di-override oleh subclass (Polymorphism Dinamis)
    public void displayInfo() {
        System.out.println("Judul: " + title);
        System.out.println("Penulis: " + author);
        System.out.println("Harga: Rp" + price);
        System.out.println("Stok: " + stock);
    }

    // Overloading method applyDiscount (Polymorphism Statis)
    public void applyDiscount(double percentage) {
        if (percentage < 0 || percentage > 100) {
            System.out.println("Persentase diskon harus antara 0-100.");
            return;
        }
        double discount = price * (percentage / 100);
        setPrice(price - discount);
        System.out.println("Diskon " + percentage + "% diterapkan. Harga baru: Rp" + price);
    }

    // Overloading dengan parameter berbeda
    public void applyDiscount(double fixedAmount, boolean isFixed) {
        if (isFixed) {
            if (fixedAmount < 0) {
                System.out.println("Diskon tetap tidak boleh negatif.");
                return;
            }
            if (fixedAmount > price) {
                System.out.println("Diskon melebihi harga, diatur ke 0.");
                setPrice(0);
            } else {
                setPrice(price - fixedAmount);
            }
            System.out.println("Diskon tetap Rp" + fixedAmount + " diterapkan. Harga baru: Rp" + price);
        } else {
            applyDiscount(fixedAmount); // panggil method persentase
        }
    }
}