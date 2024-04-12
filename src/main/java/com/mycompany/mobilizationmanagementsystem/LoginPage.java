
package com.mycompany.mobilizationmanagementsystem;

import com.mycompany.mobilizationmanagementsystem.DatabaseConnection.DatabaseConnection;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


@SuppressWarnings("serial")
public class LoginPage extends javax.swing.JFrame {

    RegisterPage register;
    AdminDashboardPanel dashboardPanel;
    DatabaseConnection connect;
    public Connection con;
    PreparedStatement statement;
    ResultSet result;
    ResultSetMetaData metadata;
    public String firstName;
    public String lastName;
    int counter = 3;
    
    //method to login a new user
    public void UserLogin() throws SQLException{
        //get user details
        String username = usernameText.getText();
        String password = PasswordField.getText();
        
        try {
            //establish database connection
            connect = new DatabaseConnection();
            con = connect.getConnection();
            String retrieveDetails = "SELECT * FROM `registeration_info`WHERE "
            + "`Username`= ? AND `Password`= ?";
            
            statement = con.prepareStatement(retrieveDetails);
            statement.setString(1, username);
            statement.setString(2, password);
            result=statement.executeQuery();
             
             if(result.next()){
                firstName = result.getString("First Name");
                lastName = result.getString("Last Name");
                
                String fname = firstName.toUpperCase();
                String lname = lastName.toUpperCase();
                
                dashboardPanel = new AdminDashboardPanel();
                dashboardPanel.getAdminName(fname.concat(" "+lname));
                dashboardPanel.setVisible(true);
                
                this.setVisible(false);
             }else{
                 counter --;
                 
                 JOptionPane.showMessageDialog(null, "Username or Password is incorrect");
                 usernameText.setText("");
                  PasswordField.setText(""); 
                  usernameText.requestFocus();
                 if(counter == 1){
                     
                  JOptionPane.showMessageDialog(null, "You have "+counter+"  attempt left");
                  usernameText.setText("");
                  PasswordField.setText(""); 
                  usernameText.requestFocus();
                 }else if(counter == 0){
                  JOptionPane.showMessageDialog(null, "Your account is blocked temporarily");
                  usernameText.setEditable(false);
                  PasswordField.setEditable(false);
                  usernameText.setText("");
                  PasswordField.setText(""); 
                 }
                  
                 
             }
             
             
             
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public LoginPage() {
        initComponents();
        
        
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        framePanel = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        formPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        usernameText = new javax.swing.JTextField();
        usernameLabel1 = new javax.swing.JLabel();
        PasswordField = new javax.swing.JPasswordField();
        loginButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        framePanel.setBackground(new java.awt.Color(0, 100, 34));

        titleLabel.setFont(new java.awt.Font("Segoe UI Light", 1, 25)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(255, 179, 61));
        titleLabel.setText("MOBILIZATION MANAGEMENT SYSTEM");

        formPanel.setBackground(new java.awt.Color(0, 100, 34));
        formPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 179, 61)));

        jLabel1.setFont(new java.awt.Font("Segoe UI Semilight", 1, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 179, 61));
        jLabel1.setText("LOGIN");

        passwordLabel.setFont(new java.awt.Font("Segoe UI Semilight", 1, 16)); // NOI18N
        passwordLabel.setForeground(new java.awt.Color(255, 253, 184));
        passwordLabel.setText("PASSWORD");

        usernameText.setBackground(new java.awt.Color(255, 244, 233));
        usernameText.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        usernameText.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 179, 61)));
        usernameText.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        usernameText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                usernameTextKeyPressed(evt);
            }
        });

        usernameLabel1.setFont(new java.awt.Font("Segoe UI Semilight", 1, 16)); // NOI18N
        usernameLabel1.setForeground(new java.awt.Color(255, 253, 184));
        usernameLabel1.setText("USERNAME");

        PasswordField.setBackground(new java.awt.Color(255, 244, 233));
        PasswordField.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        PasswordField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 179, 61)));
        PasswordField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                PasswordFieldKeyPressed(evt);
            }
        });

        loginButton.setBackground(new java.awt.Color(255, 253, 184));
        loginButton.setFont(new java.awt.Font("Segoe UI Semilight", 1, 18)); // NOI18N
        loginButton.setForeground(new java.awt.Color(0, 100, 34));
        loginButton.setText("LOGIN");
        loginButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginButtonMouseClicked(evt);
            }
        });
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });
        loginButton.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                loginButtonKeyPressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 179, 61));
        jLabel2.setText("Register Here..");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 179, 61));
        jLabel3.setText("New User ?");

        javax.swing.GroupLayout formPanelLayout = new javax.swing.GroupLayout(formPanel);
        formPanel.setLayout(formPanelLayout);
        formPanelLayout.setHorizontalGroup(
            formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, formPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(126, 126, 126))
            .addGroup(formPanelLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(usernameLabel1)
                    .addComponent(passwordLabel)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usernameText, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
        );
        formPanelLayout.setVerticalGroup(
            formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(51, 51, 51)
                .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usernameLabel1)
                    .addComponent(usernameText, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(73, 73, 73)
                .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(passwordLabel)
                    .addComponent(PasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout framePanelLayout = new javax.swing.GroupLayout(framePanel);
        framePanel.setLayout(framePanelLayout);
        framePanelLayout.setHorizontalGroup(
            framePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(framePanelLayout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addGroup(framePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(titleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(formPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(99, Short.MAX_VALUE))
        );
        framePanelLayout.setVerticalGroup(
            framePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(framePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLabel)
                .addGap(18, 18, 18)
                .addComponent(formPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        getContentPane().add(framePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 530));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
      register = new RegisterPage();
      register.setVisible(true);
      this.setVisible(false);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
       
    }//GEN-LAST:event_loginButtonActionPerformed

    private void loginButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginButtonMouseClicked
       if(usernameText.getText().isEmpty() || PasswordField.getText().isEmpty()){
           JOptionPane.showMessageDialog(null, "Form must not be empty");
           usernameText.requestFocus();
           
       }else{
            try {
            UserLogin();
        } catch (SQLException ex) {
            Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
        }
       }
        
       
    }//GEN-LAST:event_loginButtonMouseClicked

    private void usernameTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usernameTextKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            PasswordField.requestFocus();
        }
    }//GEN-LAST:event_usernameTextKeyPressed

    private void PasswordFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PasswordFieldKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            loginButton.requestFocus();
        }
    }//GEN-LAST:event_PasswordFieldKeyPressed

    private void loginButtonKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_loginButtonKeyPressed
       if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            if(usernameText.getText().isEmpty() || PasswordField.getText().isEmpty()){
           JOptionPane.showMessageDialog(null, "Form must not be empty");
           usernameText.requestFocus();
           
       }else{
            try {
            UserLogin();
        } catch (SQLException ex) {
            Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
        }
       }
        }
    }//GEN-LAST:event_loginButtonKeyPressed


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
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField PasswordField;
    private javax.swing.JPanel formPanel;
    private javax.swing.JPanel framePanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton loginButton;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JLabel usernameLabel1;
    private javax.swing.JTextField usernameText;
    // End of variables declaration//GEN-END:variables
}
