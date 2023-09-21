
package form;

import Encapsulation.Patron;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.swing.JDialog;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class ManagePatron extends javax.swing.JPanel {

    
    public ManagePatron() {
        initComponents();
        Show_Patron();
    }

    public ArrayList<Patron> patronTable(){
        ArrayList<Patron> patronTable = new ArrayList<>();
        String query = "SELECT PatronID, Name, Age, Gender, Address, Email, ContactNumber FROM patron";
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
            java.sql.Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            Patron call;
            while(rs.next()){
                call = new Patron(rs.getInt("PatronID"), rs.getString("Name"), rs.getInt("Age"), rs.getString("Gender"), rs.getString("Address"), rs.getString("Email"), rs.getString("ContactNumber"));
                patronTable.add(call);
            }
                    
                    
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
        }
        
        return patronTable;
    }
    
    private void Show_Patron() {
        Clear_Table();
        ArrayList<Patron> list = patronTable();
        DefaultTableModel model = (DefaultTableModel)TablePatron.getModel();
        Object[] row = new Object[10];
        for (int i = 0; i < list.size(); i++) {
            row[0]=list.get(i).getPatronID();
            row[1]=list.get(i).getName();
            row[2]=list.get(i).getAge();
            row[3]=list.get(i).getGender();
            row[4]=list.get(i).getAddress();
            row[5]=list.get(i).getEmail();
            row[6]=list.get(i).getContactNumber();
            model.addRow(row);
        }
    }
    
    private void Clear_Table() {
        DefaultTableModel dm = (DefaultTableModel)TablePatron.getModel();
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
    
    private boolean  validDetails(){ 
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
        rbMale = new javax.swing.JRadioButton();
        rbFemale = new javax.swing.JRadioButton();
        tgbEdit = new javax.swing.JToggleButton();
        tgbDelete = new javax.swing.JToggleButton();
        jPanel3 = new javax.swing.JPanel();
        sp = new javax.swing.JScrollPane();
        TablePatron = new javax.swing.JTable();
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
        jLabel1.setText("Manage Patron");

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
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtContact, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtAge, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtAddress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(rbMale, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addComponent(rbFemale, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 36, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(tgbEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tgbDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbFemale, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbMale, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtContact, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tgbEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tgbDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(79, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        TablePatron.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Patron ID", "Name", "Age", "Gender", "Address", "Email", "Contact"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablePatron.setEnabled(false);
        TablePatron.setGridColor(new java.awt.Color(153, 153, 153));
        TablePatron.setRowHeight(40);
        TablePatron.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablePatronMouseClicked(evt);
            }
        });
        sp.setViewportView(TablePatron);
        if (TablePatron.getColumnModel().getColumnCount() > 0) {
            TablePatron.getColumnModel().getColumn(0).setMinWidth(75);
            TablePatron.getColumnModel().getColumn(0).setPreferredWidth(75);
            TablePatron.getColumnModel().getColumn(0).setMaxWidth(75);
            TablePatron.getColumnModel().getColumn(1).setMinWidth(125);
            TablePatron.getColumnModel().getColumn(1).setPreferredWidth(125);
            TablePatron.getColumnModel().getColumn(1).setMaxWidth(125);
            TablePatron.getColumnModel().getColumn(2).setMinWidth(50);
            TablePatron.getColumnModel().getColumn(2).setPreferredWidth(50);
            TablePatron.getColumnModel().getColumn(2).setMaxWidth(50);
            TablePatron.getColumnModel().getColumn(3).setMinWidth(60);
            TablePatron.getColumnModel().getColumn(3).setPreferredWidth(60);
            TablePatron.getColumnModel().getColumn(3).setMaxWidth(60);
            TablePatron.getColumnModel().getColumn(4).setMinWidth(150);
            TablePatron.getColumnModel().getColumn(4).setPreferredWidth(200);
            TablePatron.getColumnModel().getColumn(4).setMaxWidth(250);
            TablePatron.getColumnModel().getColumn(5).setMinWidth(100);
            TablePatron.getColumnModel().getColumn(5).setPreferredWidth(150);
            TablePatron.getColumnModel().getColumn(5).setMaxWidth(200);
            TablePatron.getColumnModel().getColumn(6).setMinWidth(125);
            TablePatron.getColumnModel().getColumn(6).setPreferredWidth(125);
            TablePatron.getColumnModel().getColumn(6).setMaxWidth(200);
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

        Filter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Patron ID", "Name", "Address", "Email", "Contact" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sp, javax.swing.GroupLayout.DEFAULT_SIZE, 693, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Filter, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
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
                .addContainerGap(66, Short.MAX_VALUE))
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
        if(validDetails()==true){
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

            DefaultTableModel model = (DefaultTableModel)TablePatron.getModel();
            int SelectRowIndex = TablePatron.getSelectedRow();
            String hold = model.getValueAt(SelectRowIndex, 0).toString();

            try {
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
                    String sql = "UPDATE Patron SET" +
                            "(Name=?, Age=?, Gender=?, Address=?, Email=?, ContactNumber=?)" +
                            "WHERE LibrarianID = '"+hold+"' ";
                    PreparedStatement pst = con.prepareStatement(sql);

                    pst.setString(1, Name);
                    pst.setInt(2, Age);
                    pst.setString(3, Gender);
                    pst.setString(4, Address);
                    pst.setString(5, Email);
                    pst.setString(6, Contact);

                    int input = JOptionPane.showConfirmDialog(null, "Are you sure you want to save?", "ALERT!", JOptionPane.YES_NO_OPTION); {
                    if (input == JOptionPane.YES_OPTION) {
                        pst.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Update successfully.");
                        txtName.setText("");
                        txtAge.setText("");
                        rbFemale.setSelected(false);
                        rbMale.setSelected(false);
                        txtAddress.setText("");
                        txtEmail.setText("");
                        txtContact.setText("");
                        Show_Patron();
                    }
                }
            } catch (Exception e){

            }
        }
       
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed

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
            String sql = "INSERT INTO patron" +
                    "(Name, Age, Gender, Address, Email, ContactNumber)" +
                    "VALUES (?,?,?,?,?,?)";
                    PreparedStatement pst = con.prepareStatement(sql);
                
                    pst.setString(1, Name);
                    pst.setInt(2, Age);
                    pst.setString(3, Gender);
                    pst.setString(4, Address);
                    pst.setString(5, Email);
                    pst.setString(6, Contact);
                
                    int updatedRowCount = pst.executeUpdate();
                
                    if (updatedRowCount >= 0) {
                        JOptionPane.showMessageDialog(this, "Patron Added");
                        txtName.setText("");
                        txtAge.setText("");
                        rbMale.setSelected(false);
                        rbFemale.setSelected(false);
                        txtAddress.setText("");
                        txtEmail.setText("");
                        txtContact.setText("");
                        Show_Patron();
                    } else {
                        JOptionPane.showMessageDialog(this, "Patron Add Failed");
                    }
        } catch (Exception e) {
            e.printStackTrace();
        }
 
    }//GEN-LAST:event_btnSaveActionPerformed

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        String search = txtSearch.getText();
        String filter = null;
        filter = Filter.getSelectedItem().toString();
        String sql = "SELECT * FROM patron WHERE " +filter+ " LIKE ?";
        
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");
            if (!Filter.getSelectedItem().toString().equals("PatronID")){
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setString(1, "%" +search+ "%");
                
                ResultSet rs = pst.executeQuery();
                
                DefaultTableModel model = (DefaultTableModel)TablePatron.getModel();
                model.setRowCount(0);
            
                while (rs.next()) {
                    Object[] row = new Object[10];
                    row[0] = rs.getString("PatronID");
                    row[1] = rs.getString("Name");
                    row[2] = rs.getString("Age");
                    row[3] = rs.getString("Gender");
                    row[4] = rs.getString("Address");
                    row[5] = rs.getString("Email");
                    row[6] = rs.getString("ContactNumber");
                    // Add more columns as needed
                    model.addRow(row);
            }
            } else {
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setString(1, "%" +search+ "%");
                ResultSet rs = pst.executeQuery();
                
                DefaultTableModel model = (DefaultTableModel)TablePatron.getModel();
                model.setRowCount(0);
            
                while (rs.next()) {
                    Object[] row = new Object[10];
                    row[0] = rs.getString("PatronID");
                    row[1] = rs.getString("Name");
                    row[2] = rs.getString("Age");
                    row[3] = rs.getString("Gender");
                    row[4] = rs.getString("Address");
                    row[5] = rs.getString("Email");
                    row[6] = rs.getString("ContactNumber");
                    // Add more columns as needed
                    model.addRow(row);
            }
            }            
                      
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_txtSearchActionPerformed

    private void tgbEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tgbEditActionPerformed
        if (tgbEdit.isSelected()){
            btnEdit.setEnabled(true);
            TablePatron.setEnabled(true);
            btnDelete.setEnabled(false);
        } else {
            btnEdit.setEnabled(false);
            TablePatron.setEnabled(false);
        }
    }//GEN-LAST:event_tgbEditActionPerformed

    private void tgbDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tgbDeleteActionPerformed
        if (tgbDelete.isSelected()){
            btnDelete.setEnabled(true);
            TablePatron.setEnabled(true);
            btnEdit.setEnabled(false);
        } else {
            btnDelete.setEnabled(false);
            TablePatron.setEnabled(false);
        }
    }//GEN-LAST:event_tgbDeleteActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        DefaultTableModel model = (DefaultTableModel)TablePatron.getModel();
        int SelectRowIndex = TablePatron.getSelectedRow();
        String hold = model.getValueAt(SelectRowIndex, 0).toString();
        
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
                String sql = "DELETE FROM patron WHERE PatronID = '"+hold+"'";
                PreparedStatement pst = con.prepareStatement(sql);
                
  
                int input = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete?", "ALERT!", JOptionPane.YES_NO_OPTION); {
		if (input == JOptionPane.YES_OPTION) {
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Deleted successfully.");
                    Show_Patron();
                    }
                }
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

    private void TablePatronMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablePatronMouseClicked
        DefaultTableModel model = (DefaultTableModel)TablePatron.getModel();
        int SelectedRowIndex = TablePatron.getSelectedRow();
        try {
            txtName.setText(model.getValueAt(SelectedRowIndex, 1).toString());
            txtAge.setText(model.getValueAt(SelectedRowIndex, 2).toString());
            if(model.getValueAt(SelectedRowIndex, 3).toString().equals("Male")) {
                    rbMale.setSelected(true);
                    rbFemale.setSelected(false);
            }else if(model.getValueAt(SelectedRowIndex, 3).toString().equals("Female")) {
                    rbMale.setSelected(false);
                    rbFemale.setSelected(true);
            }
            txtAddress.setText(model.getValueAt((SelectedRowIndex), 4).toString());
            txtEmail.setText(model.getValueAt((SelectedRowIndex),5).toString());
            txtContact.setText(model.getValueAt((SelectedRowIndex), 6).toString());
            }
        catch (ArrayIndexOutOfBoundsException e ) {
            arrayoob();
        }
    }//GEN-LAST:event_TablePatronMouseClicked

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Filter;
    private javax.swing.ButtonGroup Gender;
    private javax.swing.ButtonGroup Switch;
    private javax.swing.JTable TablePatron;
    private swing.Button1 btnDelete;
    private swing.Button1 btnEdit;
    private swing.Button1 btnSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
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
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
