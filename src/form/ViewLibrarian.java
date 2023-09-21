package form;

import Encapsulation.CLibrarian;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import swing.scrollbar.ScrollBarCustom;

public class ViewLibrarian extends javax.swing.JPanel {

    public ViewLibrarian() {
        initComponents();
        Show_CLibrarian();
        sp.getViewport().setOpaque(false);
        sp.setVerticalScrollBar(new ScrollBarCustom());
    }
    
   public ArrayList<CLibrarian> clibrarianTable(){
        ArrayList<CLibrarian> clibrarianTable = new ArrayList<>();
        String query = "SELECT * FROM librarian";
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
            java.sql.Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            CLibrarian call;
            while(rs.next()){
                call = new CLibrarian(rs.getInt("LibrarianID"), rs.getString("Username"), rs.getString("Password"),rs.getString("Access"), rs.getString("Name"), rs.getInt("Age"), rs.getString("Gender"), rs.getString("Address"), rs.getString("Email"), rs.getString("ContactNumber"));
                clibrarianTable.add(call);
            }
                    
                    
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
        }
        
        return clibrarianTable;
    }
    
    private void Show_CLibrarian() {
        Clear_Table();
        ArrayList<CLibrarian> list = clibrarianTable();
        DefaultTableModel model = (DefaultTableModel)TableLibrarian.getModel();
        Object[] row = new Object[10];
        for (int i = 0; i < list.size(); i++) {
            row[0]=list.get(i).getLibrarianID();
            row[1]=list.get(i).getUsername();
            row[2]=list.get(i).getPassword();
            row[3]=list.get(i).getAccess();
            row[4]=list.get(i).getName();
            row[5]=list.get(i).getAge();
            row[6]=list.get(i).getGender();
            row[7]=list.get(i).getAddress();
            row[8]=list.get(i).getEmail();
            row[9]=list.get(i).getContactNumber();
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        sp = new javax.swing.JScrollPane();
        TableLibrarian = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        Filter = new javax.swing.JComboBox<>();

        jPanel2.setBackground(new java.awt.Color(0, 102, 204));

        jLabel1.setFont(new java.awt.Font("Rockwell", 1, 24)); // NOI18N
        jLabel1.setText("View Librarian");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(422, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(422, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        TableLibrarian.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Librarian ID", "Username", "Password", "Access", "Name", "Age", "Gender", "Address", "Email", "Contact"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TableLibrarian.setRowHeight(40);
        sp.setViewportView(TableLibrarian);
        if (TableLibrarian.getColumnModel().getColumnCount() > 0) {
            TableLibrarian.getColumnModel().getColumn(0).setMinWidth(75);
            TableLibrarian.getColumnModel().getColumn(0).setPreferredWidth(75);
            TableLibrarian.getColumnModel().getColumn(0).setMaxWidth(75);
            TableLibrarian.getColumnModel().getColumn(1).setMinWidth(100);
            TableLibrarian.getColumnModel().getColumn(1).setPreferredWidth(100);
            TableLibrarian.getColumnModel().getColumn(1).setMaxWidth(125);
            TableLibrarian.getColumnModel().getColumn(2).setMinWidth(100);
            TableLibrarian.getColumnModel().getColumn(2).setPreferredWidth(100);
            TableLibrarian.getColumnModel().getColumn(2).setMaxWidth(125);
            TableLibrarian.getColumnModel().getColumn(3).setMinWidth(75);
            TableLibrarian.getColumnModel().getColumn(3).setPreferredWidth(75);
            TableLibrarian.getColumnModel().getColumn(3).setMaxWidth(100);
            TableLibrarian.getColumnModel().getColumn(4).setMinWidth(125);
            TableLibrarian.getColumnModel().getColumn(4).setPreferredWidth(125);
            TableLibrarian.getColumnModel().getColumn(4).setMaxWidth(150);
            TableLibrarian.getColumnModel().getColumn(5).setMinWidth(50);
            TableLibrarian.getColumnModel().getColumn(5).setPreferredWidth(50);
            TableLibrarian.getColumnModel().getColumn(5).setMaxWidth(75);
            TableLibrarian.getColumnModel().getColumn(6).setMinWidth(75);
            TableLibrarian.getColumnModel().getColumn(6).setPreferredWidth(75);
            TableLibrarian.getColumnModel().getColumn(6).setMaxWidth(100);
            TableLibrarian.getColumnModel().getColumn(7).setMinWidth(100);
            TableLibrarian.getColumnModel().getColumn(7).setPreferredWidth(100);
            TableLibrarian.getColumnModel().getColumn(7).setMaxWidth(125);
            TableLibrarian.getColumnModel().getColumn(8).setMinWidth(100);
            TableLibrarian.getColumnModel().getColumn(8).setPreferredWidth(100);
            TableLibrarian.getColumnModel().getColumn(8).setMaxWidth(125);
            TableLibrarian.getColumnModel().getColumn(9).setMinWidth(100);
            TableLibrarian.getColumnModel().getColumn(9).setPreferredWidth(100);
            TableLibrarian.getColumnModel().getColumn(9).setMaxWidth(125);
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

        Filter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "LibrarianID", "Username", "Name", "Address", "Email", "ContactNumber" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sp, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Filter, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
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
                .addComponent(sp, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Filter;
    private javax.swing.JTable TableLibrarian;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane sp;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
