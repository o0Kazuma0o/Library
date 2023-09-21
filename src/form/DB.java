package form;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class DB {
    Connection con=null;

    public static void main (String [] args){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");

        }catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, e);
            System.out.print(e);

        }
    
    }
}