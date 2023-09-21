/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package form;

import Encapsulation.Librarian;
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

public class ManageLibrarian extends javax.swing.JPanel {

    public ManageLibrarian() {
        initComponents();
        Show_Librarian();
        sp.getViewport().setOpaque(false);
        sp.setVerticalScrollBar(new ScrollBarCustom());
    }

    public ArrayList<Librarian> librarianTable(){
        ArrayList<Librarian> librarianTable = new ArrayList<>();
        String query = "SELECT LibrarianID, Username, Password, Name, Age, Gender, Address, Email, ContactNumber FROM librarian";
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
            java.sql.Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            Librarian call;
            while(rs.next()){
                call = new Librarian(rs.getInt("LibrarianID"), rs.getString("Username"), rs.getString("Password"), rs.getString("Name"), rs.getInt("Age"), rs.getString("Gender"), rs.getString("Address"), rs.getString("Email"), rs.getString("ContactNumber"));
                librarianTable.add(call);
            }
                    
                    
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
        }
        
        return librarianTable;
    }
    
    private void Show_Librarian() {
        Clear_Table();
        ArrayList<Librarian> list = librarianTable();
        DefaultTableModel model = (DefaultTableModel)TableLibrarian.getModel();
        Object[] row = new Object[9];
        for (int i = 0; i < list.size(); i++) {
            row[0]=list.get(i).getLibrarianID();
            row[1]=list.get(i).getUsername();
            row[2]=list.get(i).getPassword();
            row[3]=list.get(i).getName();
            row[4]=list.get(i).getAge();
            row[5]=list.get(i).getGender();
            row[6]=list.get(i).getAddress();
            row[7]=list.get(i).getEmail();
            row[8]=list.get(i).getContactNumber();
            model.addRow(row);
        }
    }
    
    private void Clear_Table() {
        DefaultTableModel dm = (DefaultTableModel)TableLibrarian.getModel();
        int rowCount = dm.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            dm.removeRow(i);
        }
    }
    
    private boolean  validDetails(){ 
        String uName = txtUname.getText();
        String Pass = txtPass.getText();
        String Name = txtName.getText();
        Integer age = null;
        String gender = null;
        if(rbMale.isSelected())
        {
            gender = "Male";
        } else if(rbFemale.isSelected())
        {
            gender = "Female";
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
            age = Integer.valueOf(txtAge.getText());
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

        Gender = new javax.swing.ButtonGroup();
        Switch = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtName = new swing.Textfield();
        txtAge = new swing.Textfield();
        txtAddress = new swing.Textfield();
        txtEmail = new swing.Textfield();
        txtContact = new swing.Textfield();
        btnSave = new swing.Button1();
        jLabel9 = new javax.swing.JLabel();
        txtUname = new swing.Textfield();
        jLabel10 = new javax.swing.JLabel();
        txtPass = new swing.Textfield();
        rbMale = new javax.swing.JRadioButton();
        rbFemale = new javax.swing.JRadioButton();
        tgbEdit = new javax.swing.JToggleButton();
        tgbDelete = new javax.swing.JToggleButton();
        jPanel3 = new javax.swing.JPanel();
        sp = new javax.swing.JScrollPane();
        TableLibrarian = new javax.swing.JTable();
        btnDelete = new swing.Button1();
        btnEdit = new swing.Button1();
        jLabel11 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        Filter = new javax.swing.JComboBox<>();

        setPreferredSize(new java.awt.Dimension(1020, 745));

        jPanel2.setBackground(new java.awt.Color(0, 102, 204));

        jLabel1.setFont(new java.awt.Font("Rockwell", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Manage Librarian");

        jLabel2.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Name");

        jLabel3.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Age");

        jLabel4.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Gender");

        jLabel5.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Address");

        jLabel6.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Email");

        jLabel7.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Contact");

        txtName.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        txtName.setHint("Enter Name");

        txtAge.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        txtAge.setHint("Enter Age");

        txtAddress.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        txtAddress.setHint("Enter Address");

        txtEmail.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        txtEmail.setHint("Enter Email");

        txtContact.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        txtContact.setHint("Enter Contact Number");

        btnSave.setBackground(new java.awt.Color(51, 153, 0));
        btnSave.setForeground(new java.awt.Color(255, 255, 255));
        btnSave.setText("Save");
        btnSave.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Username");

        txtUname.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        txtUname.setHint("Enter Username");

        jLabel10.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Password");

        txtPass.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        txtPass.setHint("Enter Password");

        rbMale.setBackground(new java.awt.Color(0, 0, 0));
        Gender.add(rbMale);
        rbMale.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        rbMale.setForeground(new java.awt.Color(255, 255, 255));
        rbMale.setText("Male");

        rbFemale.setBackground(new java.awt.Color(0, 0, 0));
        Gender.add(rbFemale);
        rbFemale.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        rbFemale.setForeground(new java.awt.Color(255, 255, 255));
        rbFemale.setText("Female");

        tgbEdit.setBackground(new java.awt.Color(0, 153, 153));
        tgbEdit.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        tgbEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Edit.png"))); // NOI18N
        tgbEdit.setText("Edit");
        tgbEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tgbEditActionPerformed(evt);
            }
        });

        tgbDelete.setBackground(new java.awt.Color(204, 0, 51));
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
                .addGap(37, 37, 37)
                .addComponent(rbMale, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(rbFemale, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                            .addComponent(txtContact, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtAge, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtAddress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtUname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtPass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(tgbEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tgbDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUname, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbMale, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbFemale, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtContact, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tgbEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tgbDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        TableLibrarian.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Username", "Password", "Name", "Age", "Gender", "Address", "Email", "Contact"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TableLibrarian.setEnabled(false);
        TableLibrarian.setGridColor(new java.awt.Color(153, 153, 153));
        TableLibrarian.setMinimumSize(new java.awt.Dimension(1200, 1600));
        TableLibrarian.setPreferredSize(new java.awt.Dimension(1200, 1600));
        TableLibrarian.setRowHeight(40);
        TableLibrarian.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableLibrarianMouseClicked(evt);
            }
        });
        sp.setViewportView(TableLibrarian);
        if (TableLibrarian.getColumnModel().getColumnCount() > 0) {
            TableLibrarian.getColumnModel().getColumn(0).setMinWidth(50);
            TableLibrarian.getColumnModel().getColumn(0).setPreferredWidth(50);
            TableLibrarian.getColumnModel().getColumn(0).setMaxWidth(50);
            TableLibrarian.getColumnModel().getColumn(1).setMinWidth(80);
            TableLibrarian.getColumnModel().getColumn(1).setPreferredWidth(80);
            TableLibrarian.getColumnModel().getColumn(1).setMaxWidth(200);
            TableLibrarian.getColumnModel().getColumn(2).setMinWidth(80);
            TableLibrarian.getColumnModel().getColumn(2).setPreferredWidth(80);
            TableLibrarian.getColumnModel().getColumn(2).setMaxWidth(200);
            TableLibrarian.getColumnModel().getColumn(3).setMinWidth(100);
            TableLibrarian.getColumnModel().getColumn(3).setPreferredWidth(100);
            TableLibrarian.getColumnModel().getColumn(3).setMaxWidth(100);
            TableLibrarian.getColumnModel().getColumn(4).setMinWidth(40);
            TableLibrarian.getColumnModel().getColumn(4).setPreferredWidth(40);
            TableLibrarian.getColumnModel().getColumn(4).setMaxWidth(40);
            TableLibrarian.getColumnModel().getColumn(5).setMinWidth(60);
            TableLibrarian.getColumnModel().getColumn(5).setPreferredWidth(60);
            TableLibrarian.getColumnModel().getColumn(5).setMaxWidth(60);
            TableLibrarian.getColumnModel().getColumn(6).setMinWidth(100);
            TableLibrarian.getColumnModel().getColumn(6).setPreferredWidth(200);
            TableLibrarian.getColumnModel().getColumn(6).setMaxWidth(200);
            TableLibrarian.getColumnModel().getColumn(7).setMinWidth(100);
            TableLibrarian.getColumnModel().getColumn(7).setPreferredWidth(150);
            TableLibrarian.getColumnModel().getColumn(7).setMaxWidth(150);
            TableLibrarian.getColumnModel().getColumn(8).setMinWidth(125);
            TableLibrarian.getColumnModel().getColumn(8).setPreferredWidth(125);
            TableLibrarian.getColumnModel().getColumn(8).setMaxWidth(200);
        }

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

        jLabel11.setBackground(new java.awt.Color(0, 0, 0));
        jLabel11.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        jLabel11.setText("Search:");

        txtSearch.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });

        Filter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "LibrarianID", "Username", "Name", "Address", "Email", "ContactNumber" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sp, javax.swing.GroupLayout.DEFAULT_SIZE, 693, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(120, 120, 120)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Filter, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Filter, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(sp, javax.swing.GroupLayout.PREFERRED_SIZE, 517, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(58, Short.MAX_VALUE))
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

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if(validDetails()==true){
            String uName = txtUname.getText();
            String Pass = txtPass.getText();
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
                    } else {
                        JOptionPane.showMessageDialog(this, "Sign Up Failed");
                     }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        String search = txtSearch.getText();
        String filter = null;
        filter = Filter.getSelectedItem().toString();
        String sql = "SELECT * FROM librarian WHERE " +filter+ " LIKE ?";
        
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");
            if (!Filter.getSelectedItem().toString().equals("LibrarianID")){
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setString(1, "%" +search+ "%");
                
                ResultSet rs = pst.executeQuery();
                
                DefaultTableModel model = (DefaultTableModel)TableLibrarian.getModel();
                model.setRowCount(0);
            
                while (rs.next()) {
                    Object[] row = new Object[10];
                    row[0] = rs.getString("LibrarianID");
                    row[1] = rs.getString("Username");
                    row[2] = rs.getString("Password");
                    row[3] = rs.getString("Name");
                    row[4] = rs.getString("Age");
                    row[5] = rs.getString("Gender");
                    row[6] = rs.getString("Address");
                    row[7] = rs.getString("Email");
                    row[8] = rs.getString("ContactNumber");
                    // Add more columns as needed
                    model.addRow(row);
            }
            } else {
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setString(1, "%" +search+ "%");
                ResultSet rs = pst.executeQuery();
                
                DefaultTableModel model = (DefaultTableModel)TableLibrarian.getModel();
                model.setRowCount(0);
            
                while (rs.next()) {
                    Object[] row = new Object[10];
                    row[0] = rs.getString("LibrarianID");
                    row[1] = rs.getString("Username");
                    row[2] = rs.getString("Password");
                    row[3] = rs.getString("Access");
                    row[4] = rs.getString("Name");
                    row[5] = rs.getString("Age");
                    row[6] = rs.getString("Gender");
                    row[7] = rs.getString("Address");
                    row[8] = rs.getString("Email");
                    row[9] = rs.getString("ContactNumber");
                    // Add more columns as needed
                    model.addRow(row);
            }
            }            
                      
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_txtSearchActionPerformed

    private void TableLibrarianMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableLibrarianMouseClicked
        DefaultTableModel model = (DefaultTableModel)TableLibrarian.getModel();
        int SelectedRowIndex = TableLibrarian.getSelectedRow();
        try {
            txtUname.setText(model.getValueAt(SelectedRowIndex, 1).toString());
            txtPass.setText(model.getValueAt(SelectedRowIndex, 2).toString());
            txtName.setText(model.getValueAt(SelectedRowIndex, 3).toString());
            txtAge.setText(model.getValueAt((SelectedRowIndex), 4).toString());
            if(model.getValueAt(SelectedRowIndex, 5).toString().equals("Male")) {
                    rbMale.setSelected(true);
                    rbFemale.setSelected(false);
            }else if(model.getValueAt(SelectedRowIndex, 5).toString().equals("Female")) {
                    rbMale.setSelected(false);
                    rbFemale.setSelected(true);
            }
            txtAddress.setText(model.getValueAt((SelectedRowIndex), 6).toString());
            txtEmail.setText(model.getValueAt((SelectedRowIndex), 7).toString());
            txtContact.setText(model.getValueAt((SelectedRowIndex), 8).toString());
            }
        catch (ArrayIndexOutOfBoundsException e ) {
            arrayoob();
        }
    }//GEN-LAST:event_TableLibrarianMouseClicked

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        String uName = txtUname.getText();
        String Pass = txtPass.getText();
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
        
        DefaultTableModel model = (DefaultTableModel)TableLibrarian.getModel();
        int SelectRowIndex = TableLibrarian.getSelectedRow();
        String hold = model.getValueAt(SelectRowIndex, 0).toString();
        
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
                String sql = "UPDATE librarian SET Username=?, Password=?, Name=?, Age=?, Gender=?, Address=?, Email=?, ContactNumber=? WHERE LibrarianID = '"+hold+"'";
                PreparedStatement pst = con.prepareStatement(sql);
                
                pst.setString(1, uName);
                pst.setString(2, Pass);
                pst.setString(3, Name);
                pst.setInt(4, Age);
                pst.setString(5, Gender);
                pst.setString(6, Address);
                pst.setString(7, Email);
                pst.setString(8, Contact);
                
                int input = JOptionPane.showConfirmDialog(null, "Are you sure you want to save?", "ALERT!", JOptionPane.YES_NO_OPTION); {
                if (input == JOptionPane.YES_OPTION) {
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Update successfully.");
                    txtUname.setText("");
                    txtPass.setText("");
                    txtName.setText("");
                    txtAge.setText("");
                    rbFemale.setSelected(false);
                    rbMale.setSelected(false);
                    txtAddress.setText("");
                    txtEmail.setText("");
                    txtContact.setText("");
                    Show_Librarian();
                }
            }
        } catch (Exception e){
           e.printStackTrace();
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        DefaultTableModel model = (DefaultTableModel)TableLibrarian.getModel();
        int SelectRowIndex = TableLibrarian.getSelectedRow();
        String hold = model.getValueAt(SelectRowIndex, 0).toString();
        
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
                String sql = "DELETE FROM librarian WHERE LibrarianID = '"+hold+"'";
                PreparedStatement pst = con.prepareStatement(sql);
                
  
                int input = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete?", "ALERT!", JOptionPane.YES_NO_OPTION); {
		if (input == JOptionPane.YES_OPTION) {
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Deleted successfully.");
                    Show_Librarian();
                }
            }
                txtUname.setText("");
                    txtPass.setText("");
                    txtName.setText("");
                    txtAge.setText("");
                    rbFemale.setSelected(false);
                    rbMale.setSelected(false);
                    txtAddress.setText("");
                    txtEmail.setText("");
                    txtContact.setText("");
        } catch (Exception e){
            
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void tgbEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tgbEditActionPerformed
        if (tgbEdit.isSelected()){
            btnEdit.setEnabled(true);
            TableLibrarian.setEnabled(true);
            btnDelete.setEnabled(false);
        } else {
            btnEdit.setEnabled(false);
            TableLibrarian.setEnabled(false);
        }
    }//GEN-LAST:event_tgbEditActionPerformed

    private void tgbDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tgbDeleteActionPerformed
        if (tgbDelete.isSelected()){
            btnDelete.setEnabled(true);
            TableLibrarian.setEnabled(true);
            btnEdit.setEnabled(false);
        } else {
            btnDelete.setEnabled(false);
            TableLibrarian.setEnabled(false);
        }
    }//GEN-LAST:event_tgbDeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Filter;
    private javax.swing.ButtonGroup Gender;
    private javax.swing.ButtonGroup Switch;
    private javax.swing.JTable TableLibrarian;
    private swing.Button1 btnDelete;
    private swing.Button1 btnEdit;
    private swing.Button1 btnSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton rbFemale;
    private javax.swing.JRadioButton rbMale;
    private javax.swing.JScrollPane sp;
    private javax.swing.JToggleButton tgbDelete;
    private javax.swing.JToggleButton tgbEdit;
    private swing.Textfield txtAddress;
    private swing.Textfield txtAge;
    private swing.Textfield txtContact;
    private swing.Textfield txtEmail;
    private swing.Textfield txtName;
    private swing.Textfield txtPass;
    private javax.swing.JTextField txtSearch;
    private swing.Textfield txtUname;
    // End of variables declaration//GEN-END:variables
}
