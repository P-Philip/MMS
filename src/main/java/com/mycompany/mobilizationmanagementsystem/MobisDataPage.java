
package com.mycompany.mobilizationmanagementsystem;

import com.mycompany.mobilizationmanagementsystem.DatabaseConnection.DatabaseConnection;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class MobisDataPage extends javax.swing.JFrame {
    public DatabaseConnection connect;
    public Connection con;
    PreparedStatement statement;
    ResultSet result;
    ResultSetMetaData metadata;
    int columnCount;
    DefaultTableModel tableModel;
    
    //method to load mobi officers data
    public void LoadMobiOfficersData() throws ClassNotFoundException, SQLException{
        //establish database connection
        connect = new DatabaseConnection();
        try {
            con = connect.getConnection();
            String selectQuery="SELECT * FROM `new officer_info`";
             statement=con.prepareStatement(selectQuery);
             result=statement.executeQuery();
             metadata=result.getMetaData();
             columnCount=metadata.getColumnCount();

             tableModel= (DefaultTableModel) mobisDataTable.getModel();
             tableModel.setRowCount(0);
             
             while(result.next()){
                 //getting data from database table
               String officerId =result.getString("ID");
               String firstName =result.getString("First Name");
               String lastName = result.getString("Last Name");
               String dateOfBirth = result.getString("DOB");
               String gender = result.getString("Gender");
               String phone = result.getString("Phone");
         
            //get row count from table
               int rowCount=mobisDataTable.getRowCount();
               
                //storing data into a string array variable
               Object[] rowData={officerId,firstName,lastName,dateOfBirth,gender,phone};
               
               //adding values into jtable
               tableModel.addRow(rowData);
            }   
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MobisDataPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //method to delete mobi data from table and database
    public void DeleteMobiData() throws SQLException{
        tableModel = (DefaultTableModel)mobisDataTable.getModel();
        int selectedTableRow = mobisDataTable.getSelectedRow();
        int selectedRowId=0;
        selectedRowId =Integer.parseInt(tableModel.getValueAt(selectedRowId, 0).toString());
        int comfirmOption = JOptionPane.showConfirmDialog(null, ""
        + "Do you want to delete this Data ?","Warning",JOptionPane.YES_NO_OPTION);
        if(comfirmOption == JOptionPane.YES_OPTION){
        try {
            //establish database connection
            connect = new DatabaseConnection();
            con = connect.getConnection();
            String deleteQuery="DELETE FROM `new officer_info` WHERE `ID`=?";
                statement=con.prepareStatement(deleteQuery);
                statement.setInt(1, selectedRowId);
                statement.executeUpdate();
                JOptionPane.showMessageDialog(null , "Mobi Data deleted sucessfully");
                
                tableModel.removeRow(selectedTableRow);
                
             String selectQuery="SELECT * FROM `mobis account number table`";
             statement=con.prepareStatement(selectQuery);
            
             result=statement.executeQuery();
             while(result.next()){
                 String mobiAccNum = result.getString("Mobi Account Number");
                 if(mobiAccNum.endsWith(String.valueOf(selectedRowId))){
                     
                String deleteAccQuery="DELETE FROM `mobis account number table` WHERE `ID`=?";
                statement=con.prepareStatement(deleteAccQuery);
                statement.setInt(1, selectedRowId);
                statement.executeUpdate();
               
                }
             }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MobisDataPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }
   
    public MobisDataPage() throws ClassNotFoundException, SQLException {
        initComponents();
        LoadMobiOfficersData();
        mobisDataTable.getTableHeader().setFont(new Font("Tahoma",Font.BOLD,14));
        mobisDataTable.getTableHeader().setBackground(Color.BLACK);
        mobisDataTable.getTableHeader().setForeground(new Color(0,100,34));
//        productTable.getTableHeader().setOpaque(false);
        mobisDataTable.setRowHeight(20);
        mobisDataTable.setFont(new Font("Tahoma",Font.BOLD,14));
        mobisDataTable.setRowMargin(1);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        framePanel = new javax.swing.JPanel();
        formPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        mobisDataTable = new javax.swing.JTable();
        deleteButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        titleLabel = new javax.swing.JLabel();
        closeLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        framePanel.setBackground(new java.awt.Color(255, 179, 61));
        framePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        formPanel.setBackground(new java.awt.Color(255, 179, 61));
        formPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 100, 34)));

        mobisDataTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Officer Id", "First Name", "Last Name", "Date Of Birth", "Gender", "Phone"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(mobisDataTable);

        deleteButton.setBackground(new java.awt.Color(0, 100, 34));
        deleteButton.setFont(new java.awt.Font("Segoe UI Semilight", 1, 15)); // NOI18N
        deleteButton.setForeground(new java.awt.Color(255, 179, 61));
        deleteButton.setText("DELETE");
        deleteButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteButtonMouseClicked(evt);
            }
        });

        updateButton.setBackground(new java.awt.Color(0, 100, 34));
        updateButton.setFont(new java.awt.Font("Segoe UI Semilight", 1, 15)); // NOI18N
        updateButton.setForeground(new java.awt.Color(255, 179, 61));
        updateButton.setText("UPDATE");

        javax.swing.GroupLayout formPanelLayout = new javax.swing.GroupLayout(formPanel);
        formPanel.setLayout(formPanelLayout);
        formPanelLayout.setHorizontalGroup(
            formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(formPanelLayout.createSequentialGroup()
                .addGap(151, 151, 151)
                .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(181, Short.MAX_VALUE))
        );
        formPanelLayout.setVerticalGroup(
            formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        framePanel.add(formPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 690, 340));

        titleLabel.setFont(new java.awt.Font("Segoe UI Semilight", 1, 20)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(0, 100, 34));
        titleLabel.setText("MOBIS DATA LIST");
        framePanel.add(titleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, -1, -1));

        closeLabel.setFont(new java.awt.Font("Segoe UI Semilight", 1, 13)); // NOI18N
        closeLabel.setForeground(new java.awt.Color(0, 100, 34));
        closeLabel.setText("Close");
        closeLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        closeLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeLabelMouseClicked(evt);
            }
        });
        framePanel.add(closeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 10, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(framePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(framePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void closeLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeLabelMouseClicked
        this.setVisible(false);
    }//GEN-LAST:event_closeLabelMouseClicked

    private void deleteButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteButtonMouseClicked
        try {
            DeleteMobiData();
        } catch (SQLException ex) {
            Logger.getLogger(MobisDataPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_deleteButtonMouseClicked

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
            java.util.logging.Logger.getLogger(MobisDataPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MobisDataPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MobisDataPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MobisDataPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new MobisDataPage().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(MobisDataPage.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(MobisDataPage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel closeLabel;
    private javax.swing.JButton deleteButton;
    private javax.swing.JPanel formPanel;
    private javax.swing.JPanel framePanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable mobisDataTable;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
