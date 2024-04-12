
package com.mycompany.mobilizationmanagementsystem;

import com.mycompany.mobilizationmanagementsystem.DatabaseConnection.DatabaseConnection;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class SalesEntryPage extends javax.swing.JPanel {
    public DatabaseConnection connect;
    public Connection con;
    PreparedStatement statement;
    ResultSet result;
    
    //method to insert daily sales
    public void InsertDailySales() throws SQLException{
        
        //get sales details from form
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
        String accountNumber = mobiAccNoText.getText();
        String mobiName = mobiNameText.getText();
        String date = dateFormat.format(dateChooser.getDate());
        int   sales =Integer.parseInt(enterSalesText.getText()) ;
        int   customersVisited =Integer.parseInt(customerVisitedText.getText());
//        NumberFormat numberFormat = NumberFormat.getInstance();
//        int salesFormat =Integer.parseInt(numberFormat.format(sales));
        
        
        try {
            //establish database connection
        connect = new DatabaseConnection();
        con = connect.getConnection();
        String insertQuery ="INSERT INTO `daily sales table`( `Date`,"
        + " `Mobi Name`, `Mobi Account Number`, `Daily Sales`, `Customers_Visited`) VALUES (?,?,?,?,?)";
        statement=con.prepareStatement(insertQuery);
        statement.setString(1, date);
        statement.setString(2, mobiName);
        statement.setString(3, accountNumber);
        statement.setInt(4, sales);
        statement.setInt(5, customersVisited);
        statement.executeUpdate();
        JOptionPane.showMessageDialog(null, "Sales Entered successfully !!");
        mobiAccNoText.setText("");
        mobiNameText.setText("");
        enterSalesText.setText("");
        accruedSalesText.setText("");
        accruedVisitsText.setText("");
        customerVisitedText.setText("");
        mobiAccNoText.requestFocus();
        
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SalesEntryPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    public SalesEntryPage() {
        initComponents();
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
        dateLabel = new javax.swing.JLabel();
        enterSalesText = new javax.swing.JTextField();
        dateChooser = new com.toedter.calendar.JDateChooser();
        enterSalesLabel = new javax.swing.JLabel();
        accruedSalesLabel = new javax.swing.JLabel();
        insertButton = new javax.swing.JButton();
        accruedSalesText = new javax.swing.JTextField();
        accruedVisitsLabel = new javax.swing.JLabel();
        accruedVisitsText = new javax.swing.JTextField();
        customersVisitedLabel = new javax.swing.JLabel();
        customerVisitedText = new javax.swing.JTextField();

        mainPanel.setBackground(new java.awt.Color(255, 179, 61));
        mainPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titleLabel.setFont(new java.awt.Font("Segoe UI Semilight", 1, 28)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(0, 100, 34));
        titleLabel.setText("DAILY SALES ENTRY");
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
        formPanel.add(mobiNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        mobiNameText.setEditable(false);
        mobiNameText.setBackground(new java.awt.Color(255, 253, 184));
        mobiNameText.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        mobiNameText.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        mobiNameText.setDisabledTextColor(new java.awt.Color(255, 253, 184));
        formPanel.add(mobiNameText, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 220, 30));

        dateLabel.setFont(new java.awt.Font("Segoe UI Semilight", 1, 15)); // NOI18N
        dateLabel.setForeground(new java.awt.Color(0, 100, 34));
        dateLabel.setText("Date");
        formPanel.add(dateLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, -1, -1));

        enterSalesText.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        enterSalesText.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 100, 34)));
        enterSalesText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                enterSalesTextKeyPressed(evt);
            }
        });
        formPanel.add(enterSalesText, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, 220, 30));

        dateChooser.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 100, 34)));
        dateChooser.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        formPanel.add(dateChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 170, 220, 30));

        enterSalesLabel.setFont(new java.awt.Font("Segoe UI Semilight", 1, 15)); // NOI18N
        enterSalesLabel.setForeground(new java.awt.Color(0, 100, 34));
        enterSalesLabel.setText("Enter Sales");
        formPanel.add(enterSalesLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, -1));

        accruedSalesLabel.setFont(new java.awt.Font("Segoe UI Semilight", 1, 15)); // NOI18N
        accruedSalesLabel.setForeground(new java.awt.Color(0, 100, 34));
        accruedSalesLabel.setText("Accrued Sales");
        formPanel.add(accruedSalesLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, -1, -1));

        insertButton.setBackground(new java.awt.Color(0, 100, 34));
        insertButton.setFont(new java.awt.Font("Segoe UI Semilight", 1, 18)); // NOI18N
        insertButton.setForeground(new java.awt.Color(255, 179, 61));
        insertButton.setText("INSERT");
        insertButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        insertButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                insertButtonMouseClicked(evt);
            }
        });
        insertButton.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                insertButtonKeyPressed(evt);
            }
        });
        formPanel.add(insertButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 340, 220, 30));

        accruedSalesText.setEditable(false);
        accruedSalesText.setBackground(new java.awt.Color(255, 253, 184));
        accruedSalesText.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        accruedSalesText.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        accruedSalesText.setDisabledTextColor(new java.awt.Color(255, 253, 184));
        formPanel.add(accruedSalesText, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 20, 220, 30));

        accruedVisitsLabel.setFont(new java.awt.Font("Segoe UI Semilight", 1, 15)); // NOI18N
        accruedVisitsLabel.setForeground(new java.awt.Color(0, 100, 34));
        accruedVisitsLabel.setText("Accrued Visits");
        formPanel.add(accruedVisitsLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 80, -1, -1));

        accruedVisitsText.setEditable(false);
        accruedVisitsText.setBackground(new java.awt.Color(255, 253, 184));
        accruedVisitsText.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        accruedVisitsText.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        formPanel.add(accruedVisitsText, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 80, 220, 30));

        customersVisitedLabel.setFont(new java.awt.Font("Segoe UI Semilight", 1, 15)); // NOI18N
        customersVisitedLabel.setForeground(new java.awt.Color(0, 100, 34));
        customersVisitedLabel.setText("Customers Visited");
        formPanel.add(customersVisitedLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 250, -1, -1));

        customerVisitedText.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        customerVisitedText.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 100, 34)));
        customerVisitedText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                customerVisitedTextKeyPressed(evt);
            }
        });
        formPanel.add(customerVisitedText, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 250, 210, 30));

        mainPanel.add(formPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 680, 450));

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

    private void insertButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_insertButtonMouseClicked
        if(mobiAccNoText.getText().isEmpty() || customerVisitedText.getText().isEmpty()){
              JOptionPane.showMessageDialog(null, "All Fields must not be empty !!");
          }else{
            try {
            InsertDailySales();
        } catch (SQLException ex) {
            Logger.getLogger(SalesEntryPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        
    }//GEN-LAST:event_insertButtonMouseClicked

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
                dateChooser.requestFocus();
            }
            
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(SalesEntryPage.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(SalesEntryPage.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
         

    }//GEN-LAST:event_mobiAccNoTextKeyPressed

    private void enterSalesTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_enterSalesTextKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){

            connect = new DatabaseConnection();
            String accountNumber =mobiAccNoText.getText();
            try {
                con = connect.getConnection();
                String retrieveQuery = "SELECT * FROM `daily sales table`WHERE "
            + "`Mobi Account Number`= ?";
            
            statement = con.prepareStatement(retrieveQuery);
            statement.setString(1, accountNumber);
            result=statement.executeQuery();
            
            if(result.next()){
                String dailySales = result.getString("Daily Sales");
//                NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
//                int sales =Integer.parseInt(numberFormat.format(dailySales));
                int totalSales  = Integer.parseInt(dailySales)  +Integer.parseInt(enterSalesText.getText().toString());
                accruedSalesText.setText(String.valueOf(totalSales));
                customerVisitedText.requestFocus();
                
            }else{
                accruedSalesText.setText(enterSalesText.getText());
                customerVisitedText.requestFocus();
            }
            
                
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(SalesEntryPage.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(SalesEntryPage.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
    }//GEN-LAST:event_enterSalesTextKeyPressed

    private void customerVisitedTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_customerVisitedTextKeyPressed
       if(evt.getKeyCode() == KeyEvent.VK_ENTER){
//           int customerVisited =Integer.parseInt(customerVisitedText.getText()) ;
//           accruedVisitsText.setText(String.valueOf(customerVisited));
//           insertButton.requestFocus();
            connect = new DatabaseConnection();
           try {
               con = connect.getConnection();
               String accountNumber =mobiAccNoText.getText();
               
               String retrieveQuery = "SELECT * FROM `daily sales table`WHERE "
            + "`Mobi Account Number`= ?";
            
            statement = con.prepareStatement(retrieveQuery);
            statement.setString(1, accountNumber);
            result=statement.executeQuery();
            
            if(result.next()){
                int customersVisited = result.getInt("Customers_Visited");
                int totalVisits = customersVisited+Integer.parseInt(customerVisitedText.getText()); 
                accruedVisitsText.setText(String.valueOf(totalVisits));
                insertButton.requestFocus();
                
            }else{
                accruedVisitsText.setText(customerVisitedText.getText());
                insertButton.requestFocus();
            }
               
           } catch (ClassNotFoundException ex) {
               Logger.getLogger(SalesEntryPage.class.getName()).log(Level.SEVERE, null, ex);
           } catch (SQLException ex) {
               Logger.getLogger(SalesEntryPage.class.getName()).log(Level.SEVERE, null, ex);
           }
        }
    }//GEN-LAST:event_customerVisitedTextKeyPressed

    private void insertButtonKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_insertButtonKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            try {
                InsertDailySales();
            } catch (SQLException ex) {
                Logger.getLogger(SalesEntryPage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_insertButtonKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel accruedSalesLabel;
    private javax.swing.JTextField accruedSalesText;
    private javax.swing.JLabel accruedVisitsLabel;
    private javax.swing.JTextField accruedVisitsText;
    private javax.swing.JTextField customerVisitedText;
    private javax.swing.JLabel customersVisitedLabel;
    private com.toedter.calendar.JDateChooser dateChooser;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JLabel enterSalesLabel;
    private javax.swing.JTextField enterSalesText;
    private javax.swing.JPanel formPanel;
    private javax.swing.JButton insertButton;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel mobiAccNoLabel;
    private javax.swing.JTextField mobiAccNoText;
    private javax.swing.JLabel mobiNameLabel;
    private javax.swing.JTextField mobiNameText;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
