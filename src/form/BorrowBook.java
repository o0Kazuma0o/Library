/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package form;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.event.ItemEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PC
 */
public class BorrowBook extends javax.swing.JPanel {

    /**
     * Creates new form MainForm
     */
    public BorrowBook() {
        initComponents();
        FillBook();
        txtPatronID.addActionListener(this::txtPatronIDActionPerformed);
    }

    private void limit() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } 
                catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                final JDialog dialog = new JDialog((Frame)null, "Boo");

                JOptionPane op = new JOptionPane("Maximum limit of 3 books reached.", JOptionPane.WARNING_MESSAGE);
                op.addPropertyChangeListener(new PropertyChangeListener() {
                    @Override
                    public void propertyChange(PropertyChangeEvent evt) {
                        String name = evt.getPropertyName();
                        if ("value".equals(name)) {

                            dialog.dispose();

                        }
                    }
                });

                dialog.setUndecorated(true);
                dialog.setLayout(new BorderLayout());
                dialog.add(op);
                dialog.pack();
                dialog.setLocationRelativeTo(null);
                dialog.setVisible(true);
            }
        });
    }
    private void duplicate() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } 
                catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                final JDialog dialog = new JDialog((Frame)null, "Boo");

                JOptionPane op = new JOptionPane("This book is already added to the table.", JOptionPane.WARNING_MESSAGE);
                op.addPropertyChangeListener(new PropertyChangeListener() {
                    @Override
                    public void propertyChange(PropertyChangeEvent evt) {
                        String name = evt.getPropertyName();
                        if ("value".equals(name)) {

                            dialog.dispose();

                        }
                    }
                });

                dialog.setUndecorated(true);
                dialog.setLayout(new BorderLayout());
                dialog.add(op);
                dialog.pack();
                dialog.setLocationRelativeTo(null);
                dialog.setVisible(true);
            }
        });
    }
    private void quantity0() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } 
                catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                final JDialog dialog = new JDialog((Frame)null, "Boo");

                JOptionPane op = new JOptionPane("The selected book has a quantity of 0.", JOptionPane.WARNING_MESSAGE);
                op.addPropertyChangeListener(new PropertyChangeListener() {
                    @Override
                    public void propertyChange(PropertyChangeEvent evt) {
                        String name = evt.getPropertyName();
                        if ("value".equals(name)) {

                            dialog.dispose();

                        }
                    }
                });

                dialog.setUndecorated(true);
                dialog.setLayout(new BorderLayout());
                dialog.add(op);
                dialog.pack();
                dialog.setLocationRelativeTo(null);
                dialog.setVisible(true);
            }
        });
    }
    private void duplicateborrow(String bookTitle) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } 
                catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                final JDialog dialog = new JDialog((Frame)null, "Boo");

                JOptionPane op = new JOptionPane("The book \"" + bookTitle + "\" is already borrowed by the patron.", JOptionPane.WARNING_MESSAGE);
                op.addPropertyChangeListener(new PropertyChangeListener() {
                    @Override
                    public void propertyChange(PropertyChangeEvent evt) {
                        String name = evt.getPropertyName();
                        if ("value".equals(name)) {

                            dialog.dispose();

                        }
                    }
                });

                dialog.setUndecorated(true);
                dialog.setLayout(new BorderLayout());
                dialog.add(op);
                dialog.pack();
                dialog.setLocationRelativeTo(null);
                dialog.setVisible(true);
            }
        });
    }
    
    public class BorrowedBookInfo {
        private boolean alreadyBorrowed;
        private String bookTitle;

        public BorrowedBookInfo(boolean alreadyBorrowed, String bookTitle) {
            this.alreadyBorrowed = alreadyBorrowed;
            this.bookTitle = bookTitle;
        }

        public boolean isAlreadyBorrowed() {
            return alreadyBorrowed;
        }

        public String getBookTitle() {
            return bookTitle;
        }
    }
    public BorrowedBookInfo alreadyBorrowed(int bookID, int patronID) {
        boolean alreadyBorrowed = false;
        String borrowedBookTitle = null;

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");
            String sql = "SELECT * FROM borrowbook WHERE BookID = ? AND PatronID = ? AND Status = ?";
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setInt(1, bookID);
            pst.setInt(2, patronID);
            pst.setString(3, "Borrowing");

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                alreadyBorrowed = true;
                borrowedBookTitle = rs.getString("Title");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new BorrowedBookInfo(alreadyBorrowed, borrowedBookTitle);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BorrowDate = new com.raven.datechooser.DateChooser();
        ReturnDate = new com.raven.datechooser.DateChooser();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtPatronID = new swing.Textfield();
        jLabel10 = new javax.swing.JLabel();
        txtName = new swing.Textfield();
        jLabel11 = new javax.swing.JLabel();
        txtBorrow = new swing.Textfield();
        jLabel12 = new javax.swing.JLabel();
        txtReturn = new swing.Textfield();
        cbBook = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        BorrowTable = new javax.swing.JTable();
        btnSave = new swing.Button1();
        btnDelete = new swing.Button1();
        btnBorrow = new swing.Button1();
        btnReturn = new swing.Button1();

        BorrowDate.setDateFormat("yyyy-MM-dd");
        BorrowDate.setTextRefernce(txtBorrow);

        ReturnDate.setDateFormat("yyyy-MM-dd");
        ReturnDate.setTextRefernce(txtReturn);

        jPanel2.setBackground(new java.awt.Color(0, 102, 204));

        jLabel1.setFont(new java.awt.Font("Rockwell", 1, 24)); // NOI18N
        jLabel1.setText("Borrow Book");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(435, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(435, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(0, 51, 204));

        jLabel9.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Patron ID");

        txtPatronID.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        txtPatronID.setHint("Enter Patron ID");
        txtPatronID.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPatronIDFocusLost(evt);
            }
        });
        txtPatronID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPatronIDActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Name");

        txtName.setEnabled(false);
        txtName.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        txtName.setHint("Name");

        jLabel11.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Borrow Date");

        txtBorrow.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        txtBorrow.setHint("Borrow Date");

        jLabel12.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Return Date");

        txtReturn.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        txtReturn.setHint("Return Date");

        cbBook.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        cbBook.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        cbBook.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbBookItemStateChanged(evt);
            }
        });

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        BorrowTable.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        BorrowTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Book ID", "Title", "Author", "Genre"
            }
        ));
        BorrowTable.setRowHeight(55);
        BorrowTable.setShowGrid(true);
        BorrowTable.setShowVerticalLines(false);
        jScrollPane1.setViewportView(BorrowTable);

        btnSave.setBackground(new java.awt.Color(51, 153, 0));
        btnSave.setForeground(new java.awt.Color(255, 255, 255));
        btnSave.setText("Save");
        btnSave.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(204, 0, 51));
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("Delete");
        btnDelete.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnBorrow.setBackground(new java.awt.Color(0, 0, 0));
        btnBorrow.setForeground(new java.awt.Color(255, 255, 255));
        btnBorrow.setText("...");
        btnBorrow.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        btnBorrow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrowActionPerformed(evt);
            }
        });

        btnReturn.setBackground(new java.awt.Color(0, 0, 0));
        btnReturn.setForeground(new java.awt.Color(255, 255, 255));
        btnReturn.setText("...");
        btnReturn.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        btnReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReturnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbBook, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 643, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(223, 223, 223)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPatronID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtReturn, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtBorrow, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnBorrow, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnReturn, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(26, 26, 26))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPatronID, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtBorrow, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBorrow, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtReturn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnReturn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(cbBook, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(77, 77, 77)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(299, 299, 299))))
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

    
    
    private boolean  validDetails(){ 
        String PatronID = txtPatronID.getText();
        String Name = txtName.getText();
        String BorrowD = txtBorrow.getText();
        String ReturnD = txtReturn.getText();
        
        
        if (PatronID.equals("")) {
            JOptionPane.showMessageDialog(this, "Please Input Patron ID");
            return  false;
        }
        if (Name.equals("")) {
            JOptionPane.showMessageDialog(this, "Please Input Name");
            return  false;
        }
        
        if (BorrowD.equals("")) {
            JOptionPane.showMessageDialog(this, "Please Select Borrow Date");
            return  false;
        }
        if (ReturnD.equals("")) {
            JOptionPane.showMessageDialog(this, "Please Select Return Date.");
            return  false;
        }
           
        return true;
    }
    
    private void FillBook(){
        try {
            String fillq = "SELECT * FROM book";
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
            PreparedStatement fillpst = con.prepareStatement(fillq);
            ResultSet fillrs = fillpst.executeQuery();
            while(fillrs.next()) {
                String comboBook = fillrs.getString("Title");
                cbBook.addItem(comboBook);
            }
            
        } catch (Exception e) {
        }
    }
    
    private int count = 0;
    
    private void cbBookItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbBookItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED && cbBook.getSelectedIndex() != 0) {
            DefaultTableModel model = (DefaultTableModel) BorrowTable.getModel();

            try {
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");
                String selectBook = (String) cbBook.getSelectedItem();
                String sql = "SELECT * FROM book WHERE Title = ?";
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setString(1, selectBook);
                ResultSet cbrs = pst.executeQuery();

                while (cbrs.next()) {
                    int BookID = cbrs.getInt("BookID");
                    String Title = cbrs.getString("Title");
                    String Author = cbrs.getString("Author");
                    String Genre = cbrs.getString("Genre");
                    int Quantity = cbrs.getInt("Quantity");

                    // Check if the book is already added in the table
                    boolean found = false;
                    for (int i = 0; i < model.getRowCount(); i++) {
                        int tableBookID = (int) model.getValueAt(i, 0);

                        if (tableBookID == BookID) {
                            found = true;

                        }
                    }

                    if (found) {
                        duplicate();
                    } else if (Quantity == 0) {
                        quantity0();
                    } else if (count >= 3) {
                        limit();
                    } else {
                        Object[] rowData = { BookID, Title, Author, Genre };
                        model.addRow(rowData);
                        count++;
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_cbBookItemStateChanged

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int selectedRow = BorrowTable.getSelectedRow();
        if (selectedRow == 0||selectedRow == 1||selectedRow == 2||selectedRow == 3) {// Check if a row is selected
            DefaultTableModel model = (DefaultTableModel) BorrowTable.getModel();
            model.removeRow(selectedRow);
            count--;
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnBorrowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrowActionPerformed
        BorrowDate.showPopup();
    }//GEN-LAST:event_btnBorrowActionPerformed

    private void btnReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReturnActionPerformed
        ReturnDate.showPopup();
    }//GEN-LAST:event_btnReturnActionPerformed

    public void updateBookCount(){
        DefaultTableModel model = (DefaultTableModel) BorrowTable.getModel();
        int rowCount = model.getRowCount();
        
        for (int i = 0; i < rowCount; i++){
        int BookID = (int) model.getValueAt(i, 0);
            try {
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");
                String sql = "UPDATE book SET Quantity = Quantity - 1 WHERE BookID = ?";
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setInt(1, BookID);
                pst.executeUpdate();
                
                
            } catch (Exception e) {
            }
        }
    }
    public void updatePatronBorrowingCount(){
        int patronID = Integer.parseInt(txtPatronID.getText());
        int borrowingCount = BorrowTable.getRowCount();

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");
            String sql = "UPDATE patron SET BorrowingBook = BorrowingBook + ? WHERE PatronID = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, borrowingCount);
            pst.setInt(2, patronID);
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private int getCurrentBorrowingCount(int patronID) {
        int currentBorrowingCount = 0;
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");
            String sql = "SELECT BorrowingBook FROM patron WHERE PatronID = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, patronID);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                currentBorrowingCount = rs.getInt("BorrowingBook");
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return currentBorrowingCount;
    }
    
    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if (validDetails() == true) {
            DefaultTableModel model = (DefaultTableModel) BorrowTable.getModel();
            int rowCount = model.getRowCount();
            int patronID = Integer.parseInt(txtPatronID.getText());
            String name = txtName.getText();
            String borrowDate = txtBorrow.getText();
            String returnDate = txtReturn.getText();

            boolean hasDuplicate = false;
            String duplicateBookTitle = "";

            int currentBorrowingCount = getCurrentBorrowingCount(patronID);

            if (currentBorrowingCount + rowCount > 3) {
                int remainingCount = 3 - currentBorrowingCount;
                String message = "Exceeded maximum borrowing limit (3 books). Current borrowing count: " + currentBorrowingCount + ". Remaining count: " + remainingCount;
                JOptionPane.showMessageDialog(this, message);
                return;
            }

            for (int i = 0; i < rowCount; i++) {
                int bookID = (int) model.getValueAt(i, 0);

                BorrowedBookInfo borrowedBookInfo = alreadyBorrowed(bookID, patronID);

                if (borrowedBookInfo.isAlreadyBorrowed()) {
                    hasDuplicate = true;
                    duplicateBookTitle = borrowedBookInfo.getBookTitle();
                    break;
                }
            }

            if (!hasDuplicate) {
                try {
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");
                    String sql = "INSERT INTO borrowbook (BookID, Title, PatronID, Name, BorrowDate, ReturnDate, Status) VALUES (?, ?, ?, ?, ?, ?, ?)";
                    PreparedStatement pst = con.prepareStatement(sql);

                    for (int i = 0; i < rowCount; i++) {
                        int bookID = (int) model.getValueAt(i, 0);
                        String title = (String) model.getValueAt(i, 1);

                        pst.setInt(1, bookID);
                        pst.setString(2, title);
                        pst.setInt(3, patronID);
                        pst.setString(4, name);
                        pst.setString(5, borrowDate);
                        pst.setString(6, returnDate);
                        pst.setString(7, "Borrowing");

                        pst.addBatch(); // Add the query to the batch instead of executing it immediately
                    }

                    int[] updatedRowCount = pst.executeBatch(); // Execute the batch of update queries

                    if (updatedRowCount.length > 0) {  // Check if any rows were successfully inserted
                        JOptionPane.showMessageDialog(this, "Added Successfully");
                        updateBookCount();
                        updatePatronBorrowingCount();
                        txtPatronID.setText("");
                        txtName.setText("");
                        cbBook.setSelectedIndex(0);
                        txtBorrow.setText("");
                        txtReturn.setText("");
                        model.setRowCount(0);
                        count = 0;
                    } else {
                        JOptionPane.showMessageDialog(this, "Add Failed");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else {
                duplicateborrow(duplicateBookTitle);
            }
        } 
    }//GEN-LAST:event_btnSaveActionPerformed

    private void txtPatronIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPatronIDActionPerformed
        String patronID = txtPatronID.getText();
    
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");
            String sql = "SELECT Name FROM patron WHERE PatronID = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, patronID);
            ResultSet rs = pst.executeQuery();
        
            if (rs.next()) {
                String name = rs.getString("Name");
                txtName.setText(name);
            } else {
                txtName.setText("No Patron Found");
            }
        
        } catch (SQLException e) {
        e.printStackTrace();
        }
    }//GEN-LAST:event_txtPatronIDActionPerformed

    private void txtPatronIDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPatronIDFocusLost
        String patronID = txtPatronID.getText();
    
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");
            String sql = "SELECT Name FROM patron WHERE PatronID = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, patronID);
            ResultSet rs = pst.executeQuery();
        
            if (rs.next()) {
                String name = rs.getString("Name");
                txtName.setText(name);
            } else {
                txtName.setText("No Patron Found");
            }
        
        } catch (SQLException e) {
        e.printStackTrace();
        }
    }//GEN-LAST:event_txtPatronIDFocusLost
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.datechooser.DateChooser BorrowDate;
    private javax.swing.JTable BorrowTable;
    private com.raven.datechooser.DateChooser ReturnDate;
    private swing.Button1 btnBorrow;
    private swing.Button1 btnDelete;
    private swing.Button1 btnReturn;
    private swing.Button1 btnSave;
    private javax.swing.JComboBox<String> cbBook;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private swing.Textfield txtBorrow;
    private swing.Textfield txtName;
    private swing.Textfield txtPatronID;
    private swing.Textfield txtReturn;
    // End of variables declaration//GEN-END:variables
}
