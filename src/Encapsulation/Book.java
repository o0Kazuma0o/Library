package Encapsulation;

public class Book {

    public int getBookID() {
        return BookID;
    }

    public String getTitle() {
        return Title;
    }

    public String getAuthor() {
        return Author;
    }

    public String getGenre() {
        return Genre;
    }

    public int getQuantity() {
        return Quantity;
    }

    public Book(int BookID, String Title, String Author, String Genre, int Quantity) {
        this.BookID = BookID;
        this.Title = Title;
        this.Author = Author;
        this.Genre = Genre;
        this.Quantity = Quantity;
    }
    
    
    
    private final int BookID;
    private final String Title;
    private final String Author;
    private final String Genre;
    private final int Quantity;
    
}
