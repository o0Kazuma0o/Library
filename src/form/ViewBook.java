/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package form;

import Encapsulation.Book;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PC
 */
public class ViewBook extends javax.swing.JPanel {

    /**
     * Creates new form MainForm
     */
    public ViewBook() {
        initComponents();
        Show_Book();
    }
    
    public ArrayList<Book> bookTable(){
        ArrayList<Book> bookTable = new ArrayList<>();
        String query = "SELECT * FROM book";
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
            java.sql.Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            Book call;
            while(rs.next()){
                call = new Book(rs.getInt("BookID"), rs.getString("Title"), rs.getString("Author"), rs.getString("Genre"), rs.getInt("Quantity"));
                bookTable.add(call);
            }
                    
                    
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
        }
        
        return bookTable;
    }
    
    private void Show_Book() {
        Clear_Table();
        ArrayList<Book> list = bookTable();
        DefaultTableModel model = (DefaultTableModel)TableBook.getModel();
        Object[] row = new Object[10];
        for (int i = 0; i < list.size(); i++) {
            row[0]=list.get(i).getBookID();
            row[1]=list.get(i).getTitle();
            row[2]=list.get(i).getAuthor();
            row[3]=list.get(i).getGenre();
            row[4]=list.get(i).getQuantity();
            model.addRow(row);
        }
    }
    
    private void Clear_Table() {
        DefaultTableModel dm = (DefaultTableModel)TableBook.getModel();
        int rowCount = dm.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            dm.removeRow(i);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableBook = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        Filter = new javax.swing.JComboBox<>();

        jPanel2.setBackground(new java.awt.Color(0, 102, 204));

        jLabel1.setFont(new java.awt.Font("Rockwell", 1, 24)); // NOI18N
        jLabel1.setText("View Book");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        TableBook.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Book ID", "Title", "Author", "Genre", "Quantity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TableBook.setRowHeight(40);
        jScrollPane2.setViewportView(TableBook);
        if (TableBook.getColumnModel().getColumnCount() > 0) {
            TableBook.getColumnModel().getColumn(0).setMinWidth(75);
            TableBook.getColumnModel().getColumn(0).setPreferredWidth(75);
            TableBook.getColumnModel().getColumn(0).setMaxWidth(100);
            TableBook.getColumnModel().getColumn(1).setMinWidth(300);
            TableBook.getColumnModel().getColumn(1).setPreferredWidth(300);
            TableBook.getColumnModel().getColumn(1).setMaxWidth(400);
            TableBook.getColumnModel().getColumn(3).setMinWidth(150);
            TableBook.getColumnModel().getColumn(3).setPreferredWidth(150);
            TableBook.getColumnModel().getColumn(3).setMaxWidth(200);
            TableBook.getColumnModel().getColumn(4).setMinWidth(75);
            TableBook.getColumnModel().getColumn(4).setPreferredWidth(75);
            TableBook.getColumnModel().getColumn(4).setMaxWidth(100);
        }

        jLabel8.setBackground(new java.awt.Color(0, 0, 0));
        jLabel8.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        jLabel8.setText("Search:");

        txtSearch.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });

        Filter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Book ID", "Title", "Author", "Genre" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Filter, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 461, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Filter, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        String search = txtSearch.getText();
        String filter = null;
        filter = Filter.getSelectedItem().toString();
        String sql = "SELECT * FROM book WHERE " +filter+ " LIKE ?";
        
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");
            if (!Filter.getSelectedItem().toString().equals("BookID")){
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setString(1, "%" +search+ "%");
                
                ResultSet rs = pst.executeQuery();
                
                DefaultTableModel model = (DefaultTableModel)TableBook.getModel();
                model.setRowCount(0);
            
                while (rs.next()) {
                    Object[] row = new Object[10];
                    row[0] = rs.getString("BookID");
                    row[1] = rs.getString("Title");
                    row[2] = rs.getString("Author");
                    row[3] = rs.getString("Genre");
                    row[4] = rs.getString("Quantity");
                    // Add more columns as needed
                    model.addRow(row);
            }
            } else {
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setString(1, "%" +search+ "%");
                ResultSet rs = pst.executeQuery();
                
                DefaultTableModel model = (DefaultTableModel)TableBook.getModel();
                model.setRowCount(0);
            
                while (rs.next()) {
                    Object[] row = new Object[10];
                    row[0] = rs.getString("BookID");
                    row[1] = rs.getString("Title");
                    row[2] = rs.getString("Author");
                    row[3] = rs.getString("Genre");
                    row[4] = rs.getString("Quantity");
                    // Add more columns as needed
                    // Add more columns as needed
                    model.addRow(row);
            }
            }            
                      
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_txtSearchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Filter;
    private javax.swing.JTable TableBook;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
