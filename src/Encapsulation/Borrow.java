
package Encapsulation;


public class Borrow {

    public int getBorrowID() {
        return BorrowID;
    }

    public int getBookID() {
        return BookID;
    }

    public String getTitle() {
        return Title;
    }

    public int getPatronID() {
        return PatronID;
    }

    public String getName() {
        return Name;
    }

    public String getBorrowDate() {
        return BorrowDate;
    }

    public String getReturnDate() {
        return ReturnDate;
    }

    public String getStatus() {
        return Status;
    }

    public Borrow(int BorrowID, int BookID, String Title, int PatronID, String Name, String BorrowDate, String ReturnDate, String Status) {
        this.BorrowID = BorrowID;
        this.BookID = BookID;
        this.Title = Title;
        this.PatronID = PatronID;
        this.Name = Name;
        this.BorrowDate = BorrowDate;
        this.ReturnDate = ReturnDate;
        this.Status = Status;
    }
    
    
    
    private final int BorrowID;
    private final int BookID;
    private final String Title;
    private final int PatronID;
    private final String Name;
    private final String BorrowDate;
    private final String ReturnDate;
    private final String Status;
    
}
