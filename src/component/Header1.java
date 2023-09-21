/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package component;

import Encapsulation.Log;
import Windows.AdminDashboard;
import Windows.Login;
import Windows.UserDashboard;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;

/**
 *
 * @author PC
 */
public class Header1 extends javax.swing.JPanel {

    /**
     * Creates new form Header
     */
    public Header1(UserDashboard userDashboard) {
        initComponents();
        this.userDashboard = userDashboard;
        lblAccess.setText(String.valueOf(Log.Access));
        lblUsername.setText(String.valueOf(Log.Username));
    }
    
    public void addMenuEvent(ActionListener event) {
        cmdMenu.addActionListener(event);
    }

    private UserDashboard userDashboard;
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmdMenu = new swing.Button1();
        imageAvatar1 = new swing.ImageAvatar();
        lblAccess = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();

        setBackground(new java.awt.Color(255, 255, 255));

        cmdMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/menu.png"))); // NOI18N

        imageAvatar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/User.png"))); // NOI18N
        imageAvatar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imageAvatar1MouseClicked(evt);
            }
        });

        lblAccess.setText("Access");

        lblUsername.setText("Username");

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(cmdMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 786, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblAccess, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                    .addComponent(lblUsername, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(3, 3, 3)
                .addComponent(imageAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imageAvatar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 12, Short.MAX_VALUE)
                        .addComponent(lblAccess)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cmdMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void imageAvatar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imageAvatar1MouseClicked
        String uName = lblUsername.getText();
        
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
            String sql = "SELECT * from librarian where Username = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            
            pst.setString(1, uName);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                int LibrarianID = rs.getInt("LibrarianID");
                String Username = rs.getString("Username");
                Log.LibrarianID = LibrarianID;
                Log.Username = Username;
                
                Date currentDate = GregorianCalendar.getInstance().getTime();
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                String dateString = df.format(currentDate);
                
                Date d = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                String timeString = sdf.format(d);
                
                String time = timeString;
                String date = dateString;
                
                String dateTimeString = date + " " + time;
                
                int ID = LibrarianID;
                String name = Username;
                
                
                String insertSql = "INSERT INTO librarianlog (LibrarianID, Username, DateAndTime, Status) VALUES (?, ?, ?, 'Logged Out')";
                PreparedStatement insertPst = con.prepareStatement(insertSql);
                insertPst.setInt(1, ID);
                insertPst.setString(2, name);
                insertPst.setString(3, dateTimeString);
                insertPst.executeUpdate();
                Log.LibrarianID = 0;
                Log.Username = null;
                Log.Access = null;
                userDashboard.dispose();
                Login lg = new Login();
                lg.setVisible(true);
                
            
            } else {
                JOptionPane.showMessageDialog(this, "Login Failed");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_imageAvatar1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.Button1 cmdMenu;
    private swing.ImageAvatar imageAvatar1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblAccess;
    private javax.swing.JLabel lblUsername;
    // End of variables declaration//GEN-END:variables
}
