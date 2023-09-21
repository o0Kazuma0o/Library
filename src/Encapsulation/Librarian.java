package Encapsulation;

public class Librarian {

    public int getLibrarianID() {
        return LibrarianID;
    }

    public String getUsername() {
        return Username;
    }

    public String getPassword() {
        return Password;
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

    public Librarian(int LibrarianID, String Username, String Password, String Name, int Age, String Gender, String Address, String Email, String ContactNumber) {
        this.LibrarianID = LibrarianID;
        this.Username = Username;
        this.Password = Password;
        this.Name = Name;
        this.Age = Age;
        this.Gender = Gender;
        this.Address = Address;
        this.Email = Email;
        this.ContactNumber = ContactNumber;
    }
    
    
    
    private final int LibrarianID;
    private final String Username;
    private final String Password;
    private final String Name;
    private final int Age;
    private final String Gender;
    private final String Address;
    private final String Email;
    private final String ContactNumber;
               
}
