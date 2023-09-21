
package Encapsulation;


public class CPatron {

    public int getBorrowingBook() {
        return BorrowingBook;
    }

    public int getTotalBorrowedBooks() {
        return TotalBorrowedBooks;
    }

    public int getPatronID() {
        return PatronID;
    }

    public String getName() {
        return Name;
    }

    public int getAge() {
        return Age;
    }

    public String getGender() {
        return Gender;
    }

    public String getAddress() {
        return Address;
    }

    public String getEmail() {
        return Email;
    }

    public String getContactNumber() {
        return ContactNumber;
    }

    public CPatron(int PatronID, String Name, int Age, String Gender, String Address, String Email, String ContactNumber, int BorrowingBook, int TotalBorrowedBooks) {
        this.PatronID = PatronID;
        this.Name = Name;
        this.Age = Age;
        this.Gender = Gender;
        this.Address = Address;
        this.Email = Email;
        this.ContactNumber = ContactNumber;
        this.BorrowingBook = BorrowingBook;
        this.TotalBorrowedBooks = TotalBorrowedBooks;
    }
    
    private final int PatronID;
    private final String Name;
    private final int Age;
    private final String Gender;
    private final String Address;
    private final String Email;
    private final String ContactNumber;
    private final int BorrowingBook;
    private final int TotalBorrowedBooks;
    
}
