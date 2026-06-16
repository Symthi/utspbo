public class Ebook extends Book {
    private double fileSizeMB;
    private String format;

    public Ebook(String title, String author, double price, int stock, double fileSizeMB, String format) {
        super(title, author, price, stock);
        this.fileSizeMB = fileSizeMB;
        this.format = format;
    }

    public double getFileSizeMB() { return fileSizeMB; }
    public void setFileSizeMB(double fileSizeMB) { this.fileSizeMB = fileSizeMB; }

    public String getFormat() { return format; }
    public void setFormat(String format) { this.format = format; }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Jenis: E-book");
        System.out.println("Ukuran file: " + fileSizeMB + " MB");
        System.out.println("Format: " + format);
    }
}