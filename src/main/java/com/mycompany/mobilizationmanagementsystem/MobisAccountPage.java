
package com.mycompany.mobilizationmanagementsystem;

import com.mycompany.mobilizationmanagementsystem.DatabaseConnection.DatabaseConnection;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class MobisAccountPage extends javax.swing.JFrame {

    public DatabaseConnection connect;
    public Connection con;
    PreparedStatement statement;
    PreparedStatement statement1;
    PreparedStatement statement2;
    PreparedStatement statement3;
    ResultSet result;
    ResultSet result1;
    ResultSet result2;
    ResultSet result3;
    private  String mobisAccountNumber = ("1230070002500");
    private String generatedMobisAccountNumber;
    
    //method to generate Mobis account numbers
    public void GenerateMobisAccountNumber() throws SQLException, ClassNotFoundException{
        
        String mobiTelephone = mobiTelephoneTextField.getText();
        //establish database connection
        connect = new DatabaseConnection();
            con = connect.getConnection();
           
            String retrieveMobiTelephone = "SELECT * FROM `new officer_info`WHERE "
            + "`Phone`= ? ";
            String insertMobiAccNumber = "INSERT INTO `mobis account number table`(`Mobi Name`,"
         + "`Mobi Account Number`) VALUES (?,?)";
            statement = con.prepareStatement(retrieveMobiTelephone);
            statement1 = con.prepareStatement(insertMobiAccNumber);
            statement.setString(1, mobiTelephone);
            result=statement.executeQuery();
            
            
            if(result.next()){
                long mobiId = result.getLong("ID");
                String firstname = result.getString("First Name");
                String lastname = result.getString("Last Name");
                String fullname = firstname.concat(" "+lastname);

                
                String retrieveMobiAccountNumber = "SELECT * FROM `mobis account number table`WHERE "
            + "`Mobi Account Number`= ? ";
                
                generatedMobisAccountNumber = mobisAccountNumber.concat(String.valueOf(mobiId)) ;
                JOptionPane.showMessageDialog(null, " Mobi Account Number  "+generatedMobisAccountNumber+"  generated successfully");
                mobiAccountNumberText.setText(generatedMobisAccountNumber);
                
                mobiTelephoneTextField.setText(""); 
                
                statement3 = con.prepareStatement(retrieveMobiAccountNumber);
                statement3.setString(1,generatedMobisAccountNumber);
                result3=statement3.executeQuery();
                statement1 = con.prepareStatement(insertMobiAccNumber);
                statement1.setString(1,fullname);
                statement1.setString(2,generatedMobisAccountNumber);
                 
                statement1.executeUpdate();       
        }else{
   
              JOptionPane.showMessageDialog(null,"There is no Field officer with this phone number  "+
                mobiTelephone);
                mobiTelephoneTextField.setText("");    
            }
            
           
    }
    
        
    
    //method to verify Mobi account number
    public void VerifyMobiAccountNumber(String mobiAccNo) throws ClassNotFoundException{
        connect = new DatabaseConnection();
        con = connect.getConnection();
        String retrieveMobiAccNumber = "SELECT * FROM `mobis account number table`WHERE "
        + "`Mobi Account Number`= ? ";
        String insertMobiAccNumber = "INSERT INTO `mobis account number table`(`Mobi Name`,"
         + "`Mobi Account Number`) VALUES (?,?)";
        try {
            statement2 = con.prepareStatement(retrieveMobiAccNumber);
            statement2.setString(1, mobiAccNo);
            result2 = statement.executeQuery();
            if(result2.next()){
               JOptionPane.showMessageDialog(null, "Mobi Account Number exist already "); 
            }else{
                long mobiId = result.getLong("ID");
                String firstname = result.getString("First Name");
                String lastname = result.getString("Last Name");
                String fullname = firstname.concat(" "+lastname);
                generatedMobisAccountNumber = mobisAccountNumber.concat(String.valueOf(mobiId)) ;
                JOptionPane.showMessageDialog(null, " Mobi Account Number  "+generatedMobisAccountNumber+"  generated successfully");
                mobiAccountNumberText.setText(generatedMobisAccountNumber);
                statement2 = con.prepareStatement(insertMobiAccNumber);
                statement2.setString(1,fullname);
                statement2.setString(2,generatedMobisAccountNumber);
                statement2.executeUpdate();
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(MobisAccountPage.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }
    public MobisAccountPage() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        framePanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        formPanel = new javax.swing.JPanel();
        mobiTelephoneTextField = new javax.swing.JTextField();
        mobiTelephoneLabel = new javax.swing.JLabel();
        mobiAccountNumberText = new javax.swing.JTextField();
        generateButton = new javax.swing.JButton();
        mobiAccNoLabel = new javax.swing.JLabel();
        closeLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        framePanel.setBackground(new java.awt.Color(255, 179, 61));
        framePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI Semilight", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 100, 34));
        jLabel1.setText("GENERATE MOBIS ACCOUNT NUMBER");
        framePanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 0, -1, -1));

        formPanel.setBackground(new java.awt.Color(255, 179, 61));
        formPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 100, 34)));
        formPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mobiTelephoneTextField.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        mobiTelephoneTextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 100, 34)));
        mobiTelephoneTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                mobiTelephoneTextFieldKeyPressed(evt);
            }
        });
        formPanel.add(mobiTelephoneTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, 330, 30));

        mobiTelephoneLabel.setFont(new java.awt.Font("Segoe UI Semilight", 1, 15)); // NOI18N
        mobiTelephoneLabel.setForeground(new java.awt.Color(0, 100, 34));
        mobiTelephoneLabel.setText("Mobi Telephone");
        formPanel.add(mobiTelephoneLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        mobiAccountNumberText.setEditable(false);
        mobiAccountNumberText.setBackground(new java.awt.Color(255, 253, 184));
        mobiAccountNumberText.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        mobiAccountNumberText.setForeground(new java.awt.Color(255, 0, 0));
        mobiAccountNumberText.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        formPanel.add(mobiAccountNumberText, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, 210, 30));

        generateButton.setBackground(new java.awt.Color(0, 100, 34));
        generateButton.setFont(new java.awt.Font("Segoe UI Semilight", 1, 16)); // NOI18N
        generateButton.setForeground(new java.awt.Color(255, 179, 61));
        generateButton.setText("GENERATE");
        generateButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        generateButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                generateButtonMouseClicked(evt);
            }
        });
        generateButton.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                generateButtonKeyPressed(evt);
            }
        });
        formPanel.add(generateButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 250, 210, 30));

        mobiAccNoLabel.setFont(new java.awt.Font("Segoe UI Semilight", 1, 15)); // NOI18N
        mobiAccNoLabel.setForeground(new java.awt.Color(0, 100, 34));
        mobiAccNoLabel.setText("Mobi Account Number");
        formPanel.add(mobiAccNoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        framePanel.add(formPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 630, 350));

        closeLabel.setFont(new java.awt.Font("Segoe UI Semilight", 1, 12)); // NOI18N
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
            .addComponent(framePanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 698, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(framePanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void closeLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeLabelMouseClicked
        this.setVisible(false);
    }//GEN-LAST:event_closeLabelMouseClicked

    private void generateButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_generateButtonMouseClicked
        try {
            GenerateMobisAccountNumber();
        } catch (SQLException ex) {
            Logger.getLogger(MobisAccountPage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MobisAccountPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_generateButtonMouseClicked

    private void mobiTelephoneTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mobiTelephoneTextFieldKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            generateButton.requestFocus();
        }
    }//GEN-LAST:event_mobiTelephoneTextFieldKeyPressed

    private void generateButtonKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_generateButtonKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            try {
                GenerateMobisAccountNumber();
            } catch (SQLException ex) {
                Logger.getLogger(MobisAccountPage.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MobisAccountPage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_generateButtonKeyPressed

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
            java.util.logging.Logger.getLogger(MobisAccountPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MobisAccountPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MobisAccountPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MobisAccountPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MobisAccountPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel closeLabel;
    private javax.swing.JPanel formPanel;
    private javax.swing.JPanel framePanel;
    private javax.swing.JButton generateButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel mobiAccNoLabel;
    private javax.swing.JTextField mobiAccountNumberText;
    private javax.swing.JLabel mobiTelephoneLabel;
    private javax.swing.JTextField mobiTelephoneTextField;
    // End of variables declaration//GEN-END:variables
}
