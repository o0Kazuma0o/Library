/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Windows;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class SignUp extends javax.swing.JFrame {

    public SignUp() {
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Gender = new javax.swing.ButtonGroup();
        bGSignUp = new Icons.BGSignUp();
        BG = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtUname = new swing.Textfield();
        jLabel5 = new javax.swing.JLabel();
        txtPass = new swing.PasswordField();
        jLabel7 = new javax.swing.JLabel();
        txtEmail = new swing.Textfield();
        jLabel9 = new javax.swing.JLabel();
        txtContact = new swing.Textfield();
        btnSignup = new swing.Button();
        btnCancel = new swing.Button();
        txtName = new swing.Textfield();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtAddress = new swing.Textfield();
        jLabel11 = new javax.swing.JLabel();
        rbFemale = new javax.swing.JRadioButton();
        rbMale = new javax.swing.JRadioButton();
        jLabel12 = new javax.swing.JLabel();
        txtAge = new swing.Textfield();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        bGSignUp.setBlur(BG);

        BG.setOpaque(false);
        BG.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Papyrus", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Welcome to LandoGodz Library");
        BG.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, -1));

        jLabel3.setFont(new java.awt.Font("Papyrus", 1, 30)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Sign Up");
        BG.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 80, -1, -1));

        jLabel2.setFont(new java.awt.Font("NSimSun", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Username");
        BG.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, 20));

        txtUname.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        txtUname.setHint("Enter Username");
        txtUname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtUnameFocusLost(evt);
            }
        });
        BG.add(txtUname, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 260, 45));

        jLabel5.setFont(new java.awt.Font("NSimSun", 1, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Password");
        BG.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, -1, 20));

        txtPass.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        txtPass.setHint("Enter Password");
        BG.add(txtPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 260, 45));

        jLabel7.setFont(new java.awt.Font("NSimSun", 1, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("E-mail");
        BG.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 330, -1, 20));

        txtEmail.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        txtEmail.setHint("Enter E-mail");
        BG.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 350, 260, 45));

        jLabel9.setFont(new java.awt.Font("NSimSun", 1, 20)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Contact Number");
        BG.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 420, -1, 20));

        txtContact.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        txtContact.setHint("Enter Contact Number");
        txtContact.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtContactKeyTyped(evt);
            }
        });
        BG.add(txtContact, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 440, 260, 45));

        btnSignup.setBackground(new java.awt.Color(255, 255, 255));
        btnSignup.setForeground(new java.awt.Color(255, 255, 255));
        btnSignup.setText("Sign Up");
        btnSignup.setFont(new java.awt.Font("NSimSun", 1, 12)); // NOI18N
        btnSignup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignupActionPerformed(evt);
            }
        });
        BG.add(btnSignup, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 530, 110, 50));

        btnCancel.setBackground(new java.awt.Color(255, 255, 255));
        btnCancel.setForeground(new java.awt.Color(255, 255, 255));
        btnCancel.setText("Cancel");
        btnCancel.setFont(new java.awt.Font("NSimSun", 1, 12)); // NOI18N
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        BG.add(btnCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 530, 110, 50));

        txtName.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        txtName.setHint("Enter Name");
        BG.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 260, 45));

        jLabel8.setFont(new java.awt.Font("NSimSun", 1, 20)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Name");
        BG.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, -1, 20));

        jLabel10.setFont(new java.awt.Font("NSimSun", 1, 20)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Gender");
        BG.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 150, -1, 20));

        txtAddress.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        txtAddress.setHint("Enter Address");
        BG.add(txtAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 260, 260, 45));

        jLabel11.setFont(new java.awt.Font("NSimSun", 1, 20)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Address");
        BG.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 240, -1, 20));

        rbFemale.setBackground(new java.awt.Color(0, 0, 0));
        Gender.add(rbFemale);
        rbFemale.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        rbFemale.setForeground(new java.awt.Color(255, 255, 255));
        rbFemale.setText("Female");
        BG.add(rbFemale, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 180, 90, 30));

        rbMale.setBackground(new java.awt.Color(0, 0, 0));
        Gender.add(rbMale);
        rbMale.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        rbMale.setForeground(new java.awt.Color(255, 255, 255));
        rbMale.setText("Male");
        BG.add(rbMale, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 180, 90, 30));

        jLabel12.setFont(new java.awt.Font("NSimSun", 1, 20)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Age");
        BG.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, -1, 20));

        txtAge.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        txtAge.setHint("Enter Age");
        txtAge.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAgeKeyTyped(evt);
            }
        });
        BG.add(txtAge, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, 260, 45));

        javax.swing.GroupLayout bGSignUpLayout = new javax.swing.GroupLayout(bGSignUp);
        bGSignUp.setLayout(bGSignUpLayout);
        bGSignUpLayout.setHorizontalGroup(
            bGSignUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bGSignUpLayout.createSequentialGroup()
                .addContainerGap(240, Short.MAX_VALUE)
                .addComponent(BG, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(240, Short.MAX_VALUE))
        );
        bGSignUpLayout.setVerticalGroup(
            bGSignUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bGSignUpLayout.createSequentialGroup()
                .addContainerGap(56, Short.MAX_VALUE)
                .addComponent(BG, javax.swing.GroupLayout.PREFERRED_SIZE, 608, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        getContentPane().add(bGSignUp, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private static final Pattern AdminPattern = Pattern.compile("\\badmin.*\\b", Pattern.CASE_INSENSITIVE);
    
    // Method to validate user input
    private boolean  validDetails(){ 
        String uName = txtUname.getText();
        String Pass = txtPass.getText();
        String Name = txtName.getText();
        Integer Age = null;
        String Gender = null;
        if(rbMale.isSelected())
        {
            Gender = "Male";
        } else if(rbFemale.isSelected())
        {
            Gender = "Female";
        }
        String Address = txtAddress.getText();
        String Email = txtEmail.getText();
        String Contact = txtContact.getText();
        
        if (uName.equals("")) {
            JOptionPane.showMessageDialog(this, "Please Input Username");
            return  false;
        }
        if (Pass.equals("")) {
            JOptionPane.showMessageDialog(this, "Please Input Password");
            return  false;
        }
        if (Name.equals("")) {
            JOptionPane.showMessageDialog(this, "Please Input Name");
            return  false;
        }
        try {
            Age = Integer.valueOf(txtAge.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please Input Age");
            return  false;
        }
        if (Gender == null) {
            JOptionPane.showMessageDialog(this, "Please Select Gender");
            return  false;
        }
        if (Address.equals("")) {
            JOptionPane.showMessageDialog(this, "Please Input Address");
            return  false;
        }
        if (Email.equals("")||!Email.matches("^.+@.+\\..+$")) {
            JOptionPane.showMessageDialog(this, "Please Input Valid Email");
            return  false;
        }
        if (Contact.equals("")) {
            JOptionPane.showMessageDialog(this, "Please Input Contact Number");
            return  false;
        }   
        return true;
    }
    
    // Method to check for duplicate username in the database
    private boolean Duplicate(){
        String uName = txtUname.getText();
        boolean isExist = false;
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
            PreparedStatement pst = con.prepareStatement("SELECT * FROM librarian WHERE Username = ?");
            pst.setString(1, uName);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                isExist = true;
            } else {
                isExist = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }   
        return isExist;
    }
    
    // Event handler for the cancel button
    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        Login lg = new Login();
        this.setVisible(false);
        lg.setVisible(true);
    }//GEN-LAST:event_btnCancelActionPerformed

    // Event handler for the sign-up button
    private void btnSignupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignupActionPerformed
        if (validDetails()==true){
            if (Duplicate() == false) {
                String uName = txtUname.getText();
                String Pass = txtPass.getText();
                String Access = "Admin";
                String Name = txtName.getText();
                int Age = Integer.parseInt(txtAge.getText());
                String Gender = null;
                if(rbMale.isSelected())
                {
                    Gender = "Male";
                } else if(rbFemale.isSelected())
                {
                    Gender = "Female";
                }
                String Address = txtAddress.getText();
                String Email = txtEmail.getText();
                String Contact = txtContact.getText();
        
            
                // Check if the username matches a specific pattern (AdminPattern) Line 211
                if (AdminPattern.matcher(uName).matches()) {
                    try {
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root",""); // Connect to the database
                        String sql = "INSERT INTO librarian" +
                                "(Username, Password, Access, Name, Age, Gender, Address, Email, ContactNumber)" +   // Define the SQL query to insert 
                                "VALUES (?,?,?,?,?,?,?,?,?)";                                                       //data into the "librarian" table
                        PreparedStatement pst = con.prepareStatement(sql); // Prepare the SQL statement
                
                        pst.setString(1, uName);
                        pst.setString(2, Pass);
                        pst.setString(3, Access);
                        pst.setString(4, Name);
                        pst.setInt(5, Age);
                        pst.setString(6, Gender);
                        pst.setString(7, Address);
                        pst.setString(8, Email);
                        pst.setString(9, Contact);
                
                        int updatedRowCount = pst.executeUpdate(); // Execute the SQL statement and get the number of rows affected
                
                        if (updatedRowCount > 0) {  // Check if the data was successfully inserted
                            JOptionPane.showMessageDialog(this, "Sign Up Success");
                            this.setVisible(false);
                            Login lg = new Login();
                            lg.setVisible(true);
                        } else {
                            JOptionPane.showMessageDialog(this, "Sign Up Failed");
                        }
                
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                             
                } else {
                    try {
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
                        String sql = "INSERT INTO librarian" +
                                "(Username, Password, Name, Age, Gender, Address, Email, ContactNumber)" +
                                "VALUES (?,?,?,?,?,?,?,?)";
                        PreparedStatement pst = con.prepareStatement(sql);
                
                        pst.setString(1, uName);
                        pst.setString(2, Pass);
                        pst.setString(3, Name);
                        pst.setInt(4, Age);
                        pst.setString(5, Gender);
                        pst.setString(6, Address);
                        pst.setString(7, Email);
                        pst.setString(8, Contact);
                
                        int updatedRowCount = pst.executeUpdate();
                
                        if (updatedRowCount >= 0) {
                            JOptionPane.showMessageDialog(this, "Sign Up Success");
                            this.setVisible(false);
                            Login lg = new Login();
                            lg.setVisible(true);
                        } else {
                            JOptionPane.showMessageDialog(this, "Sign Up Failed");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }               
                }
            } else {
                JOptionPane.showMessageDialog(this, "Username Already Exist");
            }
        }       
    }//GEN-LAST:event_btnSignupActionPerformed

    private void txtAgeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAgeKeyTyped
        char c =  evt.getKeyChar();
        
        if(!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtAgeKeyTyped

    private void txtContactKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContactKeyTyped
        char c =  evt.getKeyChar();
        
        if(!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtContactKeyTyped

    private void txtUnameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUnameFocusLost
        if (Duplicate() == true) {
            JOptionPane.showMessageDialog(this, "Username already exist");
        }
    }//GEN-LAST:event_txtUnameFocusLost

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SignUp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BG;
    private javax.swing.ButtonGroup Gender;
    private Icons.BGSignUp bGSignUp;
    private swing.Button btnCancel;
    private swing.Button btnSignup;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JRadioButton rbFemale;
    private javax.swing.JRadioButton rbMale;
    private swing.Textfield txtAddress;
    private swing.Textfield txtAge;
    private swing.Textfield txtContact;
    private swing.Textfield txtEmail;
    private swing.Textfield txtName;
    private swing.PasswordField txtPass;
    private swing.Textfield txtUname;
    // End of variables declaration//GEN-END:variables
}
