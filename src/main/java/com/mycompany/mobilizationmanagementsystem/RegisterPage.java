
package com.mycompany.mobilizationmanagementsystem;

import com.mycompany.mobilizationmanagementsystem.DatabaseConnection.DatabaseConnection;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class RegisterPage extends javax.swing.JFrame {
    
    
    public DatabaseConnection connect;
    public Connection con;
    PreparedStatement statement;
    ResultSet result;
    ResultSetMetaData metadata;
    
    //method to register new user into the system
    public void RegisterNewUser() throws SQLException, ClassNotFoundException{
        //get user details from form
        
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
        String firstname= firstnameText1.getText();
        String lastname= lastnameText.getText();
        String dateOfBirth=dateFormat.format(dateOfBirthChooser.getDate()) ;
        String gender= genderComboBox.getSelectedItem().toString();
        String username= usernameText.getText();
        String password= PasswordField.getText();
        
        //establish database connection
        connect = new DatabaseConnection();
        con = connect.getConnection();
        String insertQuery ="INSERT INTO `registeration_info`( `First Name`,"
        + " `Last Name`, `DOB`, `Gender`, `Username`, `Password`) VALUES ( ?,?,?,?,?,?)";
        statement=con.prepareStatement(insertQuery);
        statement.setString(1, firstname);
        statement.setString(2, lastname);
        statement.setString(3, dateOfBirth);
        statement.setString(4, gender);
        statement.setString(5, username);
        statement.setString(6, password);
        statement.executeUpdate();
        
        JOptionPane.showMessageDialog(null, "Registration successfull !!");
        firstnameText1.setText("");
        lastnameText.setText("");
//        dateOfBirthChooser.setDateFormatString("");
//        genderComboBox.setSelectedIndex(-1);
        usernameText.setText("");
        PasswordField.setText("");
        firstnameText1.requestFocus();
        
        
    }

    LoginPage login;
    public RegisterPage() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        framePanel = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        formPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        dateOfBirthLabel = new javax.swing.JLabel();
        lastnameText = new javax.swing.JTextField();
        firstnameLabel1 = new javax.swing.JLabel();
        firstnameText1 = new javax.swing.JTextField();
        lastnameLabel1 = new javax.swing.JLabel();
        dateOfBirthChooser = new com.toedter.calendar.JDateChooser();
        genderLabel = new javax.swing.JLabel();
        genderComboBox = new javax.swing.JComboBox<>();
        passwordLabel = new javax.swing.JLabel();
        usernameText = new javax.swing.JTextField();
        usernameLabel1 = new javax.swing.JLabel();
        PasswordField = new javax.swing.JPasswordField();
        registerButton = new javax.swing.JButton();
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

        jLabel1.setFont(new java.awt.Font("Segoe UI Semilight", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 179, 61));
        jLabel1.setText("REGISTER NEW USER");

        dateOfBirthLabel.setFont(new java.awt.Font("Segoe UI Semilight", 1, 16)); // NOI18N
        dateOfBirthLabel.setForeground(new java.awt.Color(255, 253, 184));
        dateOfBirthLabel.setText("DOB");

        lastnameText.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lastnameText.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 179, 61)));
        lastnameText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                lastnameTextKeyPressed(evt);
            }
        });

        firstnameLabel1.setFont(new java.awt.Font("Segoe UI Semilight", 1, 16)); // NOI18N
        firstnameLabel1.setForeground(new java.awt.Color(255, 253, 184));
        firstnameLabel1.setText("FIRST NAME");

        firstnameText1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        firstnameText1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 179, 61)));
        firstnameText1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                firstnameText1KeyPressed(evt);
            }
        });

        lastnameLabel1.setFont(new java.awt.Font("Segoe UI Semilight", 1, 16)); // NOI18N
        lastnameLabel1.setForeground(new java.awt.Color(255, 253, 184));
        lastnameLabel1.setText("LAST NAME");

        dateOfBirthChooser.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 179, 61)));
        dateOfBirthChooser.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        dateOfBirthChooser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                dateOfBirthChooserKeyPressed(evt);
            }
        });

        genderLabel.setFont(new java.awt.Font("Segoe UI Semilight", 1, 16)); // NOI18N
        genderLabel.setForeground(new java.awt.Color(255, 253, 184));
        genderLabel.setText("GENDER");

        genderComboBox.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        genderComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));
        genderComboBox.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 179, 61)));
        genderComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                genderComboBoxItemStateChanged(evt);
            }
        });

        passwordLabel.setFont(new java.awt.Font("Segoe UI Semilight", 1, 16)); // NOI18N
        passwordLabel.setForeground(new java.awt.Color(255, 253, 184));
        passwordLabel.setText("PASSWORD");

        usernameText.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        usernameText.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 179, 61)));
        usernameText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                usernameTextKeyPressed(evt);
            }
        });

        usernameLabel1.setFont(new java.awt.Font("Segoe UI Semilight", 1, 16)); // NOI18N
        usernameLabel1.setForeground(new java.awt.Color(255, 253, 184));
        usernameLabel1.setText("USERNAME");

        PasswordField.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        PasswordField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 179, 61)));
        PasswordField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                PasswordFieldKeyPressed(evt);
            }
        });

        registerButton.setBackground(new java.awt.Color(255, 253, 184));
        registerButton.setFont(new java.awt.Font("Segoe UI Semilight", 1, 18)); // NOI18N
        registerButton.setForeground(new java.awt.Color(0, 100, 34));
        registerButton.setText("REGISTER");
        registerButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                registerButtonMouseClicked(evt);
            }
        });
        registerButton.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                registerButtonKeyPressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 179, 61));
        jLabel2.setText("Admin User ?");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 179, 61));
        jLabel3.setText("Login Here..");
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout formPanelLayout = new javax.swing.GroupLayout(formPanel);
        formPanel.setLayout(formPanelLayout);
        formPanelLayout.setHorizontalGroup(
            formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(formPanelLayout.createSequentialGroup()
                        .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(firstnameLabel1)
                            .addComponent(dateOfBirthLabel))
                        .addGap(30, 30, 30)
                        .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(formPanelLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lastnameText, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(firstnameText1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dateOfBirthChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(genderComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(usernameText, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(PasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(registerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)))))
                    .addComponent(lastnameLabel1)
                    .addComponent(genderLabel)
                    .addComponent(usernameLabel1)
                    .addComponent(passwordLabel)
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        formPanelLayout.setVerticalGroup(
            formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(7, 7, 7)
                .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(firstnameLabel1)
                    .addComponent(firstnameText1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lastnameLabel1)
                    .addComponent(lastnameText, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dateOfBirthChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateOfBirthLabel))
                .addGap(28, 28, 28)
                .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(genderLabel)
                    .addComponent(genderComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usernameLabel1)
                    .addComponent(usernameText, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordLabel)
                    .addComponent(PasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(registerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addContainerGap())
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(formPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(framePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 540));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        login = new LoginPage();
        login.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void registerButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerButtonMouseClicked
       
        try {
            RegisterNewUser();
        } catch (SQLException ex) {
            Logger.getLogger(RegisterPage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RegisterPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_registerButtonMouseClicked

    private void firstnameText1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_firstnameText1KeyPressed
        if(evt.getKeyCode()== KeyEvent.VK_ENTER){
            lastnameText.requestFocus();
        }
    }//GEN-LAST:event_firstnameText1KeyPressed

    private void lastnameTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lastnameTextKeyPressed
        if(evt.getKeyCode()== KeyEvent.VK_ENTER){
            dateOfBirthChooser.requestFocus();
        }
    }//GEN-LAST:event_lastnameTextKeyPressed

    private void dateOfBirthChooserKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dateOfBirthChooserKeyPressed
        if(evt.getKeyCode()== KeyEvent.VK_ENTER){
            genderComboBox.requestFocus();
        }
    }//GEN-LAST:event_dateOfBirthChooserKeyPressed

    private void genderComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_genderComboBoxItemStateChanged
        if(evt.getStateChange() ==ItemEvent.SELECTED){
            usernameText.requestFocus();
        }
    }//GEN-LAST:event_genderComboBoxItemStateChanged

    private void usernameTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usernameTextKeyPressed
        if(evt.getKeyCode()== KeyEvent.VK_ENTER){
            PasswordField.requestFocus();
        }
    }//GEN-LAST:event_usernameTextKeyPressed

    private void PasswordFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PasswordFieldKeyPressed
        if(evt.getKeyCode()== KeyEvent.VK_ENTER){
            registerButton.requestFocus();
        }
    }//GEN-LAST:event_PasswordFieldKeyPressed

    private void registerButtonKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_registerButtonKeyPressed
        if(evt.getKeyCode()== KeyEvent.VK_ENTER){
            try {
            RegisterNewUser();
        } catch (SQLException ex) {
            Logger.getLogger(RegisterPage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RegisterPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }//GEN-LAST:event_registerButtonKeyPressed

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
            java.util.logging.Logger.getLogger(RegisterPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisterPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisterPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegisterPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField PasswordField;
    private com.toedter.calendar.JDateChooser dateOfBirthChooser;
    private javax.swing.JLabel dateOfBirthLabel;
    private javax.swing.JLabel firstnameLabel1;
    private javax.swing.JTextField firstnameText1;
    private javax.swing.JPanel formPanel;
    private javax.swing.JPanel framePanel;
    private javax.swing.JComboBox<String> genderComboBox;
    private javax.swing.JLabel genderLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lastnameLabel1;
    private javax.swing.JTextField lastnameText;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JButton registerButton;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JLabel usernameLabel1;
    private javax.swing.JTextField usernameText;
    // End of variables declaration//GEN-END:variables
}
