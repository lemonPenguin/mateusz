package sample;

public class Backpack {

    private String book;
    private String purpose;

    public Backpack(String book, String purpose) {
        this.book = book;
        this.purpose = purpose;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }
}
