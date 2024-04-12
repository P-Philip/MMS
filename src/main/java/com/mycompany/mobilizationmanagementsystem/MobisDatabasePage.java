
package com.mycompany.mobilizationmanagementsystem;

import com.mycompany.mobilizationmanagementsystem.DatabaseConnection.DatabaseConnection;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JWindow;
import javax.swing.table.DefaultTableModel;


public class MobisDatabasePage extends javax.swing.JPanel {
    
    CustomersDatabasePage customerDatabase;
    public DatabaseConnection connect;
    public Connection con;
    PreparedStatement statement;
    ResultSet result;
    ResultSetMetaData metadata;
    int columnCount;
    DefaultTableModel tableModel;
    
    //method to fetch customer database
    public void FetchCustomerDatabase() throws SQLException, ClassNotFoundException{
        try {
            //establish database connection
            connect = new DatabaseConnection();
            con = connect.getConnection();
            String mobiAccountNum = mobiAccNoText.getText();
            
            String selectQuery="SELECT * FROM `customers_database`"
             + " WHERE `Mobi Account_Number`=?";
             statement=con.prepareStatement(selectQuery);
             statement.setString(1,mobiAccountNum);
             result=statement.executeQuery();
             metadata=result.getMetaData();
             columnCount=metadata.getColumnCount();
             
             tableModel= (DefaultTableModel) customerDatabaseTable.getModel();
             tableModel.setRowCount(0);
             
             
             while(result.next()){
                 //getting data from database table
               SimpleDateFormat dateFormat = new SimpleDateFormat();
               String customerName = result.getString("Customer Name");
               String customerAccNo = result.getString("Customer Account_Number");
               String telephone = result.getString("Telephone");
               String location = result.getString("Location");
               String date    =  String.valueOf(result.getDate("Date"));
               
         
            //get row count from table
               int rowCount=customerDatabaseTable.getRowCount();
               
                //storing data into a string array variable
               Object[] rowData={customerName,customerAccNo,telephone,location,date};
               
               //adding values into jtable
               tableModel.addRow(rowData);
               mobiAccNoText.setText(""); 
               mobiAccNoText.requestFocus();
            
            }  
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MobisDatabasePage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public MobisDatabasePage() {
        initComponents();
        
        customerDatabaseTable.getTableHeader().setFont(new Font("Tahoma",Font.BOLD,14));
        customerDatabaseTable.getTableHeader().setBackground(Color.BLACK);
        customerDatabaseTable.getTableHeader().setForeground(new Color(0,100,34));
//        productTable.getTableHeader().setOpaque(false);
        customerDatabaseTable.setRowHeight(20);
        customerDatabaseTable.setFont(new Font("Tahoma",Font.BOLD,14));
        customerDatabaseTable.setRowMargin(1);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        formPanel = new javax.swing.JPanel();
        mobiAccNoLabel = new javax.swing.JLabel();
        mobiAccNoText = new javax.swing.JTextField();
        mobiNameLabel = new javax.swing.JLabel();
        mobiNameText = new javax.swing.JTextField();
        printtButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        customerDatabaseTable = new javax.swing.JTable();
        fetchDataByDate = new javax.swing.JButton();
        fetchDatabaseButton1 = new javax.swing.JButton();
        addNewCustomerButton = new javax.swing.JButton();

        mainPanel.setBackground(new java.awt.Color(255, 179, 61));
        mainPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titleLabel.setFont(new java.awt.Font("Segoe UI Semilight", 1, 28)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(0, 100, 34));
        titleLabel.setText("MOBIS CUSTOMER DATABASE");
        mainPanel.add(titleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, -1, -1));

        formPanel.setBackground(new java.awt.Color(255, 179, 61));
        formPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 100, 34)));
        formPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mobiAccNoLabel.setFont(new java.awt.Font("Segoe UI Semilight", 1, 15)); // NOI18N
        mobiAccNoLabel.setForeground(new java.awt.Color(0, 100, 34));
        mobiAccNoLabel.setText("Mobi Acc. No");
        formPanel.add(mobiAccNoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        mobiAccNoText.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        mobiAccNoText.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 100, 34)));
        mobiAccNoText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                mobiAccNoTextKeyPressed(evt);
            }
        });
        formPanel.add(mobiAccNoText, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 220, 30));

        mobiNameLabel.setFont(new java.awt.Font("Segoe UI Semilight", 1, 15)); // NOI18N
        mobiNameLabel.setForeground(new java.awt.Color(0, 100, 34));
        mobiNameLabel.setText(" Mobi Name ");
        formPanel.add(mobiNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 20, -1, -1));

        mobiNameText.setEditable(false);
        mobiNameText.setBackground(new java.awt.Color(255, 253, 184));
        mobiNameText.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        mobiNameText.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        mobiNameText.setDisabledTextColor(new java.awt.Color(255, 253, 184));
        formPanel.add(mobiNameText, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 20, 220, 30));

        printtButton.setBackground(new java.awt.Color(0, 100, 34));
        printtButton.setFont(new java.awt.Font("Segoe UI Semilight", 1, 18)); // NOI18N
        printtButton.setForeground(new java.awt.Color(255, 179, 61));
        printtButton.setText("PRINT");
        printtButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        printtButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                printtButtonMouseClicked(evt);
            }
        });
        formPanel.add(printtButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 410, 220, 30));

        customerDatabaseTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 100, 34)));
        customerDatabaseTable.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        customerDatabaseTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Customer Name", "Account Number", "Telephone", "Location", "Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Long.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(customerDatabaseTable);

        formPanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 660, 240));

        fetchDataByDate.setBackground(new java.awt.Color(0, 100, 34));
        fetchDataByDate.setFont(new java.awt.Font("Segoe UI Semilight", 1, 18)); // NOI18N
        fetchDataByDate.setForeground(new java.awt.Color(255, 179, 61));
        fetchDataByDate.setText("FETCH BY DATE");
        fetchDataByDate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        fetchDataByDate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fetchDataByDateMouseClicked(evt);
            }
        });
        fetchDataByDate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fetchDataByDateKeyPressed(evt);
            }
        });
        formPanel.add(fetchDataByDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 80, 220, 30));

        fetchDatabaseButton1.setBackground(new java.awt.Color(0, 100, 34));
        fetchDatabaseButton1.setFont(new java.awt.Font("Segoe UI Semilight", 1, 18)); // NOI18N
        fetchDatabaseButton1.setForeground(new java.awt.Color(255, 179, 61));
        fetchDatabaseButton1.setText("FETCH");
        fetchDatabaseButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        fetchDatabaseButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fetchDatabaseButton1MouseClicked(evt);
            }
        });
        fetchDatabaseButton1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fetchDatabaseButton1KeyPressed(evt);
            }
        });
        formPanel.add(fetchDatabaseButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 220, 30));

        mainPanel.add(formPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 680, 450));

        addNewCustomerButton.setBackground(new java.awt.Color(0, 100, 34));
        addNewCustomerButton.setFont(new java.awt.Font("Segoe UI Semilight", 1, 18)); // NOI18N
        addNewCustomerButton.setForeground(new java.awt.Color(255, 179, 61));
        addNewCustomerButton.setText("NEW CUSTOMER");
        addNewCustomerButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addNewCustomerButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addNewCustomerButtonMouseClicked(evt);
            }
        });
        addNewCustomerButton.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                addNewCustomerButtonKeyPressed(evt);
            }
        });
        mainPanel.add(addNewCustomerButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 180, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addNewCustomerButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addNewCustomerButtonMouseClicked
        customerDatabase = new CustomersDatabasePage();
        customerDatabase.setVisible(true);
    }//GEN-LAST:event_addNewCustomerButtonMouseClicked

    private void mobiAccNoTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mobiAccNoTextKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            //establish database connection
            connect = new DatabaseConnection();
             String accountNumber =mobiAccNoText.getText();
            try {
                con = connect.getConnection();
                String retrieveQuery = "SELECT * FROM `mobis account number table`WHERE "
            + "`Mobi Account Number`= ?";
            
            statement = con.prepareStatement(retrieveQuery);
            statement.setString(1, accountNumber);
            result=statement.executeQuery();
            
            if(result.next()){
                String mobiName = result.getString("Mobi Name");
                mobiNameText.setText(mobiName);
                fetchDataByDate.requestFocus();
            }
            
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MobisDatabasePage.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(MobisDatabasePage.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }//GEN-LAST:event_mobiAccNoTextKeyPressed

    private void addNewCustomerButtonKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_addNewCustomerButtonKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            customerDatabase = new CustomersDatabasePage();
            customerDatabase.setVisible(true);
        }
    }//GEN-LAST:event_addNewCustomerButtonKeyPressed

    private void fetchDataByDateKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fetchDataByDateKeyPressed
        try {
            FetchCustomerDatabase();
        } catch (SQLException ex) {
            Logger.getLogger(MobisDatabasePage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MobisDatabasePage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_fetchDataByDateKeyPressed

    private void fetchDataByDateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fetchDataByDateMouseClicked
        try {
            FetchCustomerDatabase();
        } catch (SQLException ex) {
            Logger.getLogger(MobisDatabasePage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MobisDatabasePage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_fetchDataByDateMouseClicked

    private void printtButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_printtButtonMouseClicked
        try {
            customerDatabaseTable.print();
        } catch (PrinterException ex) {
            Logger.getLogger(MobisDatabasePage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_printtButtonMouseClicked

    private void fetchDatabaseButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fetchDatabaseButton1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_fetchDatabaseButton1MouseClicked

    private void fetchDatabaseButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fetchDatabaseButton1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_fetchDatabaseButton1KeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addNewCustomerButton;
    private javax.swing.JTable customerDatabaseTable;
    private javax.swing.JButton fetchDataByDate;
    private javax.swing.JButton fetchDatabaseButton1;
    private javax.swing.JPanel formPanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel mobiAccNoLabel;
    private javax.swing.JTextField mobiAccNoText;
    private javax.swing.JLabel mobiNameLabel;
    private javax.swing.JTextField mobiNameText;
    private javax.swing.JButton printtButton;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
