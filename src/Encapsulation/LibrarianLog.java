
package Encapsulation;


public class LibrarianLog {

    public int getLogID() {
        return LogID;
    }

    public int getLibrarianID() {
        return LibrarianID;
    }

    public String getUesrname() {
        return Uesrname;
    }

    public String getDateAndTime() {
        return DateAndTime;
    }

    public String getStatus() {
        return Status;
    }

    public LibrarianLog(int LogID, int LibrarianID, String Uesrname, String DateAndTime, String Status) {
        this.LogID = LogID;
        this.LibrarianID = LibrarianID;
        this.Uesrname = Uesrname;
        this.DateAndTime = DateAndTime;
        this.Status = Status;
    }
    
    
    
    private final int LogID;
    private final int LibrarianID;
    private final String Uesrname;
    private final String DateAndTime;
    private final String Status;
}
