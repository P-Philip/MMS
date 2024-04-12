
package com.mycompany.mobilizationmanagementsystem;

import com.mycompany.mobilizationmanagementsystem.DatabaseConnection.DatabaseConnection;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class CustomersDatabasePage extends javax.swing.JFrame {
    public DatabaseConnection connect;
    public Connection con;
    PreparedStatement statement;
    ResultSet result;
    
    //method to add customers to database
    public void AddNewCustomer() throws SQLException{
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
        //get customer details from form
        String mobiAccountNumber = mobiAccNoText.getText();
        String mobiName = mobiNameText.getText();
        String customerName = customerNameText.getText();
        String customerAccountNumber = accountNoText.getText();
        String customerTelephoneNumber = telephoneText.getText();
        String customerLocation = locationText.getText();
        String date = dateFormat.format(DateChooser.getDate());
        
        //establish database connection
        connect = new DatabaseConnection();
        try {
            con = connect.getConnection();
            String insertCustomerQuery ="INSERT INTO `customers_database`( `Mobi Account_Number`,"
        + " `Customer Name`, `Customer Account_Number`, `Telephone`, `Location`,`Date`) VALUES (?,?,?,?,?,?)";
        statement=con.prepareStatement(insertCustomerQuery);
        statement.setString(1, mobiAccountNumber);
        statement.setString(2, customerName);
        statement.setString(3, customerAccountNumber);
        statement.setString(4, customerTelephoneNumber);
        statement.setString(5, customerLocation);
        statement.setString(6, date);
        statement.executeUpdate();
        JOptionPane.showMessageDialog(null, "New Customer Added successfully !!");
        
//        mobiAccNoText.setText("");
        mobiNameText.setText("");
        customerNameText.setText("");
        accountNoText.setText("");
        telephoneText.setText("");
        locationText.setText("");
        mobiAccNoText.requestFocus();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CustomersDatabasePage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    public CustomersDatabasePage() {
        initComponents();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        framePanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        formPanel = new javax.swing.JPanel();
        dateLabel = new javax.swing.JLabel();
        mobiAccNoText = new javax.swing.JTextField();
        mobiNameLabel = new javax.swing.JLabel();
        mobiNameText = new javax.swing.JTextField();
        customerNameLabel = new javax.swing.JLabel();
        customerNameText = new javax.swing.JTextField();
        telephoneLabel = new javax.swing.JLabel();
        telephoneText = new javax.swing.JTextField();
        accountNoLabel = new javax.swing.JLabel();
        accountNoText = new javax.swing.JTextField();
        locationLabel = new javax.swing.JLabel();
        locationText = new javax.swing.JTextField();
        insertButton = new javax.swing.JButton();
        mobiAccNoLabel1 = new javax.swing.JLabel();
        DateChooser = new com.toedter.calendar.JDateChooser();
        closeLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        framePanel.setBackground(new java.awt.Color(255, 179, 61));
        framePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI Semilight", 1, 25)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 100, 34));
        jLabel1.setText("CUSTOMERS DATABASE");
        framePanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 0, -1, -1));

        formPanel.setBackground(new java.awt.Color(255, 179, 61));
        formPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 100, 34)));
        formPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        dateLabel.setFont(new java.awt.Font("Segoe UI Semilight", 1, 15)); // NOI18N
        dateLabel.setForeground(new java.awt.Color(0, 100, 34));
        dateLabel.setText("Date");
        formPanel.add(dateLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        mobiAccNoText.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        mobiAccNoText.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 100, 34)));
        mobiAccNoText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                mobiAccNoTextKeyPressed(evt);
            }
        });
        formPanel.add(mobiAccNoText, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 220, 30));

        mobiNameLabel.setFont(new java.awt.Font("Segoe UI Semilight", 1, 15)); // NOI18N
        mobiNameLabel.setForeground(new java.awt.Color(0, 100, 34));
        mobiNameLabel.setText("Mobi Name");
        formPanel.add(mobiNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 70, -1, -1));

        mobiNameText.setBackground(new java.awt.Color(255, 253, 184));
        mobiNameText.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        mobiNameText.setForeground(new java.awt.Color(255, 0, 0));
        mobiNameText.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        formPanel.add(mobiNameText, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 70, 210, 30));

        customerNameLabel.setFont(new java.awt.Font("Segoe UI Semilight", 1, 15)); // NOI18N
        customerNameLabel.setForeground(new java.awt.Color(0, 100, 34));
        customerNameLabel.setText("Customer Name");
        formPanel.add(customerNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        customerNameText.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        customerNameText.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 100, 34)));
        customerNameText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                customerNameTextKeyPressed(evt);
            }
        });
        formPanel.add(customerNameText, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, 220, 30));

        telephoneLabel.setFont(new java.awt.Font("Segoe UI Semilight", 1, 15)); // NOI18N
        telephoneLabel.setForeground(new java.awt.Color(0, 100, 34));
        telephoneLabel.setText("Telephone");
        formPanel.add(telephoneLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 150, -1, -1));

        telephoneText.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        telephoneText.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 100, 34)));
        telephoneText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telephoneTextActionPerformed(evt);
            }
        });
        telephoneText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                telephoneTextKeyPressed(evt);
            }
        });
        formPanel.add(telephoneText, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 150, 210, 30));

        accountNoLabel.setFont(new java.awt.Font("Segoe UI Semilight", 1, 15)); // NOI18N
        accountNoLabel.setForeground(new java.awt.Color(0, 100, 34));
        accountNoLabel.setText("Account Number");
        formPanel.add(accountNoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, -1, -1));

        accountNoText.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        accountNoText.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 100, 34)));
        accountNoText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                accountNoTextKeyPressed(evt);
            }
        });
        formPanel.add(accountNoText, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 220, 220, 30));

        locationLabel.setFont(new java.awt.Font("Segoe UI Semilight", 1, 15)); // NOI18N
        locationLabel.setForeground(new java.awt.Color(0, 100, 34));
        locationLabel.setText("Location");
        formPanel.add(locationLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 230, -1, -1));

        locationText.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        locationText.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 100, 34)));
        locationText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                locationTextKeyPressed(evt);
            }
        });
        formPanel.add(locationText, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 220, 210, 30));

        insertButton.setBackground(new java.awt.Color(0, 100, 34));
        insertButton.setFont(new java.awt.Font("Segoe UI Semilight", 1, 16)); // NOI18N
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
        formPanel.add(insertButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 300, 110, 30));

        mobiAccNoLabel1.setFont(new java.awt.Font("Segoe UI Semilight", 1, 15)); // NOI18N
        mobiAccNoLabel1.setForeground(new java.awt.Color(0, 100, 34));
        mobiAccNoLabel1.setText("Mobi Acc.No ");
        formPanel.add(mobiAccNoLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        DateChooser.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 100, 34)));
        DateChooser.setForeground(new java.awt.Color(0, 100, 34));
        DateChooser.setToolTipText("");
        DateChooser.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        formPanel.add(DateChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 220, 30));

        framePanel.add(formPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 690, 340));

        closeLabel.setFont(new java.awt.Font("Segoe UI Semilight", 1, 12)); // NOI18N
        closeLabel.setForeground(new java.awt.Color(0, 100, 34));
        closeLabel.setText("Close");
        closeLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        closeLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeLabelMouseClicked(evt);
            }
        });
        framePanel.add(closeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 10, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(framePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 724, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(framePanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void closeLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeLabelMouseClicked
        this.setVisible(false);
    }//GEN-LAST:event_closeLabelMouseClicked

    private void mobiAccNoTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mobiAccNoTextKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            String MobiaccountNumber =mobiAccNoText.getText();
            //establish database connection
            connect = new DatabaseConnection();
            try {
                con = connect.getConnection();
                String retrieveAccountNumber = "SELECT * FROM `mobis account number table`WHERE "
            + "`Mobi Account Number`= ?";
            
            statement = con.prepareStatement(retrieveAccountNumber);
            statement.setString(1, MobiaccountNumber);
            result=statement.executeQuery();
            
            if(result.next()){
                String mobiName = result.getString("Mobi Name");
                mobiNameText.setText(mobiName);
                customerNameText.requestFocus();
            }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(CustomersDatabasePage.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(CustomersDatabasePage.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }//GEN-LAST:event_mobiAccNoTextKeyPressed

    private void customerNameTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_customerNameTextKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            telephoneText.requestFocus();
        }
    }//GEN-LAST:event_customerNameTextKeyPressed

    private void telephoneTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_telephoneTextKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            accountNoText.requestFocus();
        }
    }//GEN-LAST:event_telephoneTextKeyPressed

    private void accountNoTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_accountNoTextKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            locationText.requestFocus();
        }
    }//GEN-LAST:event_accountNoTextKeyPressed

    private void locationTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_locationTextKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            insertButton.requestFocus();
        }
    }//GEN-LAST:event_locationTextKeyPressed

    private void insertButtonKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_insertButtonKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            if(mobiAccNoText.getText().isEmpty() || accountNoText.getText().isEmpty()){
           JOptionPane.showMessageDialog(null, "All Fields must not be empty");
           
        }else{
                try {
                    AddNewCustomer();
                } catch (SQLException ex) {
                    Logger.getLogger(CustomersDatabasePage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }    }
    }//GEN-LAST:event_insertButtonKeyPressed

    private void insertButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_insertButtonMouseClicked
        try {
            AddNewCustomer();
        } catch (SQLException ex) {
            Logger.getLogger(CustomersDatabasePage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_insertButtonMouseClicked

    private void telephoneTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telephoneTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_telephoneTextActionPerformed

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
            java.util.logging.Logger.getLogger(CustomersDatabasePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustomersDatabasePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustomersDatabasePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomersDatabasePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CustomersDatabasePage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser DateChooser;
    private javax.swing.JLabel accountNoLabel;
    private javax.swing.JTextField accountNoText;
    private javax.swing.JLabel closeLabel;
    private javax.swing.JLabel customerNameLabel;
    private javax.swing.JTextField customerNameText;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JPanel formPanel;
    private javax.swing.JPanel framePanel;
    private javax.swing.JButton insertButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel locationLabel;
    private javax.swing.JTextField locationText;
    private javax.swing.JLabel mobiAccNoLabel1;
    private javax.swing.JTextField mobiAccNoText;
    private javax.swing.JLabel mobiNameLabel;
    private javax.swing.JTextField mobiNameText;
    private javax.swing.JLabel telephoneLabel;
    private javax.swing.JTextField telephoneText;
    // End of variables declaration//GEN-END:variables
}
