public class PrintedBook extends Book {
    private double weightGram;
    private int pageCount;

    public PrintedBook(String title, String author, double price, int stock, double weightGram, int pageCount) {
        super(title, author, price, stock);
        this.weightGram = weightGram;
        this.pageCount = pageCount;
    }

    public double getWeightGram() { return weightGram; }
    public void setWeightGram(double weightGram) { this.weightGram = weightGram; }

    public int getPageCount() { return pageCount; }
    public void setPageCount(int pageCount) { this.pageCount = pageCount; }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Jenis: Buku Cetak");
        System.out.println("Berat: " + weightGram + " gram");
        System.out.println("Jumlah halaman: " + pageCount);
    }
}