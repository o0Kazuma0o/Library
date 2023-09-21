/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package form;

import Encapsulation.Book;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import swing.scrollbar.ScrollBarCustom;


public class ManageBook extends javax.swing.JPanel {

    
    public ManageBook() {
        initComponents();
        Show_Book();
        sp.getViewport().setOpaque(false);
        sp.setVerticalScrollBar(new ScrollBarCustom());
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
    
    private void arrayoob() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } 
                catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                final JDialog dialog = new JDialog((Frame)null, "Boo");

                JOptionPane op = new JOptionPane("You can only view this table \n If you want to edit select \n Edit/Delete on left side", JOptionPane.WARNING_MESSAGE);
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
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Switch = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtTitle = new swing.Textfield();
        txtAuthor = new swing.Textfield();
        txtQty = new swing.Textfield();
        btnSave = new swing.Button1();
        cbGenre = new javax.swing.JComboBox<>();
        tgbEdit = new javax.swing.JToggleButton();
        tgbDelete = new javax.swing.JToggleButton();
        jPanel3 = new javax.swing.JPanel();
        sp = new javax.swing.JScrollPane();
        TableBook = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        btnDelete = new swing.Button1();
        btnEdit = new swing.Button1();
        Filter = new javax.swing.JComboBox<>();

        setPreferredSize(new java.awt.Dimension(1020, 745));

        jPanel2.setBackground(new java.awt.Color(0, 102, 204));

        jLabel1.setFont(new java.awt.Font("Rockwell", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Manage Book");

        jLabel2.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Title");

        jLabel3.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Author");

        jLabel4.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Genre");

        jLabel5.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Quantity");

        txtTitle.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        txtTitle.setHint("Enter Title");

        txtAuthor.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        txtAuthor.setHint("Enter Author");

        txtQty.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        txtQty.setHint("Enter Quantity");

        btnSave.setBackground(new java.awt.Color(51, 153, 0));
        btnSave.setForeground(new java.awt.Color(255, 255, 255));
        btnSave.setText("Save");
        btnSave.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        cbGenre.setBackground(new java.awt.Color(255, 255, 255));
        cbGenre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Action", "Biography", "Comedy", "Contemporary", "Drama", "Education", "Fantasy", "History", "Horror", "Literature", "Mystery", "Non Fiction", "Novel", "Romance", "Sci-fi", "Self Help Book", " " }));
        cbGenre.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        tgbEdit.setBackground(new java.awt.Color(0, 153, 153));
        Switch.add(tgbEdit);
        tgbEdit.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        tgbEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Edit.png"))); // NOI18N
        tgbEdit.setText("Edit");
        tgbEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tgbEditActionPerformed(evt);
            }
        });

        tgbDelete.setBackground(new java.awt.Color(204, 0, 51));
        Switch.add(tgbDelete);
        tgbDelete.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        tgbDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Edit.png"))); // NOI18N
        tgbDelete.setText("Delete");
        tgbDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tgbDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
                    .addComponent(txtTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtAuthor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtQty, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(tgbEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tgbDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(cbGenre, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbGenre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtQty, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tgbEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tgbDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94))
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
        TableBook.setEnabled(false);
        TableBook.setGridColor(new java.awt.Color(153, 153, 153));
        TableBook.setRowHeight(40);
        TableBook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableBookMouseClicked(evt);
            }
        });
        sp.setViewportView(TableBook);
        if (TableBook.getColumnModel().getColumnCount() > 0) {
            TableBook.getColumnModel().getColumn(0).setMinWidth(75);
            TableBook.getColumnModel().getColumn(0).setPreferredWidth(75);
            TableBook.getColumnModel().getColumn(0).setMaxWidth(75);
            TableBook.getColumnModel().getColumn(1).setMinWidth(275);
            TableBook.getColumnModel().getColumn(1).setPreferredWidth(275);
            TableBook.getColumnModel().getColumn(1).setMaxWidth(400);
            TableBook.getColumnModel().getColumn(2).setMinWidth(150);
            TableBook.getColumnModel().getColumn(2).setPreferredWidth(150);
            TableBook.getColumnModel().getColumn(2).setMaxWidth(200);
            TableBook.getColumnModel().getColumn(3).setMinWidth(100);
            TableBook.getColumnModel().getColumn(3).setPreferredWidth(100);
            TableBook.getColumnModel().getColumn(3).setMaxWidth(100);
            TableBook.getColumnModel().getColumn(4).setMinWidth(75);
            TableBook.getColumnModel().getColumn(4).setPreferredWidth(75);
            TableBook.getColumnModel().getColumn(4).setMaxWidth(75);
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

        btnDelete.setBackground(new java.awt.Color(204, 0, 51));
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("Delete");
        btnDelete.setEnabled(false);
        btnDelete.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnEdit.setBackground(new java.awt.Color(0, 153, 153));
        btnEdit.setForeground(new java.awt.Color(255, 255, 255));
        btnEdit.setText("Edit");
        btnEdit.setEnabled(false);
        btnEdit.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
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
                    .addComponent(sp, javax.swing.GroupLayout.DEFAULT_SIZE, 687, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(2, 2, 2)
                        .addComponent(Filter, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(120, 120, 120)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Filter, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(sp, javax.swing.GroupLayout.PREFERRED_SIZE, 517, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        String Title = txtTitle.getText();
        String Author = txtAuthor.getText();
        String Genre = (String) cbGenre.getSelectedItem();
        int Qty = Integer.parseInt(txtQty.getText());
        
        DefaultTableModel model = (DefaultTableModel)TableBook.getModel();
        int SelectRowIndex = TableBook.getSelectedRow();
        String hold = model.getValueAt(SelectRowIndex, 0).toString();
        
        String sql = "UPDATE book SET Title = ?, Author = ?, Genre = ?, Quantity = ? WHERE BookID = '"+hold+"'";
        
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, Title);
            pst.setString(2, Author);
            pst.setString(3, Genre);
            pst.setInt(4, Qty);
            
            int input = JOptionPane.showConfirmDialog(null, "Are you sure you want to save?", "ALERT!", JOptionPane.YES_NO_OPTION); {
                if (input == JOptionPane.YES_OPTION) {
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Update successfully.");
                    txtTitle.setText("");
                    txtAuthor.setText("");
                    cbGenre.setSelectedIndex(0);
                    txtQty.setText("");
                    Show_Book();
                }
            }
            
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        String Title = txtTitle.getText();
        String Author = txtAuthor.getText();
        String Genre = (String) cbGenre.getSelectedItem();
        int Qty = Integer.parseInt(txtQty.getText());
        
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root",""); // Connect to the database
            String sql = "INSERT INTO book" +
                                "(Title, Author, Genre, Quantity)" +                                        // Define the SQL query to insert 
                                "VALUES (?,?,?,?)";                                                         //data into the "book" table
            PreparedStatement pst = con.prepareStatement(sql); // Prepare the SQL statement
            
            pst.setString(1, Title);
            pst.setString(2, Author);
            pst.setString(3, Genre);
            pst.setInt(4, Qty);
            
            int updatedRowCount = pst.executeUpdate(); // Execute the SQL statement and get the number of rows affected
                
                if (updatedRowCount > 0) {  // Check if the data was successfully inserted
                JOptionPane.showMessageDialog(this, "Added Successfully");
                txtTitle.setText("");
                txtAuthor.setText("");
                cbGenre.setSelectedIndex(0);
                txtQty.setText("");
                Show_Book();
            } else {
                JOptionPane.showMessageDialog(this, "Add Failed");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnSaveActionPerformed

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

    private void TableBookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableBookMouseClicked
        DefaultTableModel model = (DefaultTableModel)TableBook.getModel();
        int SelectedRowIndex = TableBook.getSelectedRow();
        try{
        txtTitle.setText(model.getValueAt(SelectedRowIndex, 1).toString());
        txtAuthor.setText(model.getValueAt(SelectedRowIndex, 2).toString());
        cbGenre.setSelectedItem(model.getValueAt(SelectedRowIndex, 3).toString());
        txtQty.setText(model.getValueAt((SelectedRowIndex), 4).toString());
        }
        catch (ArrayIndexOutOfBoundsException e ) {
            arrayoob();
        }
        
    }//GEN-LAST:event_TableBookMouseClicked

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        DefaultTableModel model = (DefaultTableModel)TableBook.getModel();
        int SelectRowIndex = TableBook.getSelectedRow();
        String hold = model.getValueAt(SelectRowIndex, 0).toString();
        
        String sql = "DELETE FROM book WHERE BookID = '"+hold+"'";
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
            PreparedStatement pst = con.prepareStatement(sql);
            int input = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete?", "ALERT!", JOptionPane.YES_NO_OPTION); {
		if (input == JOptionPane.YES_OPTION) {
		pst.executeUpdate();
		JOptionPane.showMessageDialog(null, "Deleted successfully.");
		Show_Book();
		}
            }
            txtTitle.setText("");
            txtAuthor.setText("");
            cbGenre.setSelectedIndex(0);
            txtQty.setText("");
            
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void tgbEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tgbEditActionPerformed
        if (tgbEdit.isSelected()){
            btnEdit.setEnabled(true);
            TableBook.setEnabled(true);
            btnDelete.setEnabled(false);
        } else {
            btnEdit.setEnabled(false);
            TableBook.setEnabled(false);
        }
    }//GEN-LAST:event_tgbEditActionPerformed

    private void tgbDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tgbDeleteActionPerformed
        if (tgbDelete.isSelected()){
            btnDelete.setEnabled(true);
            TableBook.setEnabled(true);
            btnEdit.setEnabled(false);
        } else {
            btnDelete.setEnabled(false);
            TableBook.setEnabled(false);
        }
    }//GEN-LAST:event_tgbDeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Filter;
    private javax.swing.ButtonGroup Switch;
    private javax.swing.JTable TableBook;
    private swing.Button1 btnDelete;
    private swing.Button1 btnEdit;
    private swing.Button1 btnSave;
    private javax.swing.JComboBox<String> cbGenre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane sp;
    private javax.swing.JToggleButton tgbDelete;
    private javax.swing.JToggleButton tgbEdit;
    private swing.Textfield txtAuthor;
    private swing.Textfield txtQty;
    private javax.swing.JTextField txtSearch;
    private swing.Textfield txtTitle;
    // End of variables declaration//GEN-END:variables
}
