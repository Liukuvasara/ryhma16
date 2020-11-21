package Lukuvinkisto;

public class Book implements Comparable<Book> {
    private final String title;
    private final String author;
    private final int pages;

    public Book(String title, String author, int pages) {
        this.title = title;
        this.author = author;
        this.pages = pages;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public int getPages() {
        return pages;
    }

    @Override
    public int compareTo(Book t) {
        return this.title.compareTo(t.getTitle());
    }

    @Override
    public String toString() {
        return author + " : "  + title + ". sivumäärä: " + pages;
    }
}
