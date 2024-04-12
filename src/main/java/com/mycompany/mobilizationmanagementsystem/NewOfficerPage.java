
package com.mycompany.mobilizationmanagementsystem;

import com.mycompany.mobilizationmanagementsystem.DatabaseConnection.DatabaseConnection;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;


@SuppressWarnings("serial")
public class NewOfficerPage extends javax.swing.JPanel {

   public DatabaseConnection connect;
    public Connection con;
    PreparedStatement statement;
    ResultSet result;
    MobisDataPage mobisPage;
    
    //method to upload new officer photo
    public void UploadPhoto(){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showOpenDialog(this);
        File file = fileChooser.getSelectedFile();
        String filePath =file + "";
        String filename = file.getAbsolutePath();
        ImageIcon image = new ImageIcon(filename);
        image.getImage().getScaledInstance(220, 200,Image.SCALE_DEFAULT);
        photoLabel.setIcon(image);
        
    }
    
    //method to add  new mobi officer into the system
    public void RegisterNewMobiOfficer() throws SQLException, ClassNotFoundException{
        //get user details from form
        
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
        String firstname= firstnameText.getText();
        String lastname= lastnameText.getText();
        String dateOfBirth=dateFormat.format(dateChooser.getDate()) ;
        String gender= genderComboBox.getSelectedItem().toString();
        String phone = phoneText.getText();
        
        
        //establish database connection
        connect = new DatabaseConnection();
        con = connect.getConnection();
        String insertQuery ="INSERT INTO `new officer_info`( `First Name`,"
        + " `Last Name`, `DOB`, `Gender`, `Phone`) VALUES ( ?,?,?,?,?)";
        statement=con.prepareStatement(insertQuery);
        statement.setString(1, firstname);
        statement.setString(2, lastname);
        statement.setString(3, dateOfBirth);
        statement.setString(4, gender);
        statement.setString(5, phone);
        statement.executeUpdate();
        JOptionPane.showMessageDialog(null, "New Mobi Registered successfull !!");
        firstnameText.setText("");
        lastnameText.setText("");
       phoneText.setText("");
    }
//        dateOfBirthChooser.setDateFormatString("");
//        genderComboBox.setSelectedIndex(-1);
//        usernameText.setText("");
//        PasswordField.setText("");
//        firstnameText1.requestFocus();
        
       
    public NewOfficerPage() {
        initComponents();
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        formPanel = new javax.swing.JPanel();
        firstnameLabel = new javax.swing.JLabel();
        firstnameText = new javax.swing.JTextField();
        lastnameLabel = new javax.swing.JLabel();
        lastnameText = new javax.swing.JTextField();
        dateOfBirthLabel = new javax.swing.JLabel();
        phoneText = new javax.swing.JTextField();
        dateChooser = new com.toedter.calendar.JDateChooser();
        genderLabel = new javax.swing.JLabel();
        genderComboBox = new javax.swing.JComboBox<>();
        phoneLabel = new javax.swing.JLabel();
        registerButton = new javax.swing.JButton();
        photoPanel = new javax.swing.JPanel();
        photoLabel = new javax.swing.JLabel();
        photoButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        mobiListPanel = new javax.swing.JPanel();
        mobiListLabel = new javax.swing.JLabel();

        mainPanel.setBackground(new java.awt.Color(255, 179, 61));
        mainPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titleLabel.setFont(new java.awt.Font("Segoe UI Semilight", 1, 28)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(0, 100, 34));
        titleLabel.setText("REGISTER NEW OFFICER");
        mainPanel.add(titleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, -1, -1));

        formPanel.setBackground(new java.awt.Color(255, 179, 61));
        formPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 100, 34)));
        formPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        firstnameLabel.setFont(new java.awt.Font("Segoe UI Semilight", 1, 18)); // NOI18N
        firstnameLabel.setForeground(new java.awt.Color(0, 100, 34));
        firstnameLabel.setText("FIRST NAME");
        formPanel.add(firstnameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        firstnameText.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        firstnameText.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 100, 34)));
        firstnameText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                firstnameTextKeyPressed(evt);
            }
        });
        formPanel.add(firstnameText, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 220, 30));

        lastnameLabel.setFont(new java.awt.Font("Segoe UI Semilight", 1, 18)); // NOI18N
        lastnameLabel.setForeground(new java.awt.Color(0, 100, 34));
        lastnameLabel.setText("LAST NAME");
        formPanel.add(lastnameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        lastnameText.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lastnameText.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 100, 34)));
        lastnameText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                lastnameTextKeyPressed(evt);
            }
        });
        formPanel.add(lastnameText, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 220, 30));

        dateOfBirthLabel.setFont(new java.awt.Font("Segoe UI Semilight", 1, 18)); // NOI18N
        dateOfBirthLabel.setForeground(new java.awt.Color(0, 100, 34));
        dateOfBirthLabel.setText("DATE OF BIRTH");
        formPanel.add(dateOfBirthLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));

        phoneText.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        phoneText.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 100, 34)));
        phoneText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                phoneTextKeyPressed(evt);
            }
        });
        formPanel.add(phoneText, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 330, 220, 30));

        dateChooser.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 100, 34)));
        dateChooser.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        dateChooser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                dateChooserKeyPressed(evt);
            }
        });
        formPanel.add(dateChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 190, 220, 30));

        genderLabel.setFont(new java.awt.Font("Segoe UI Semilight", 1, 18)); // NOI18N
        genderLabel.setForeground(new java.awt.Color(0, 100, 34));
        genderLabel.setText("GENDER");
        formPanel.add(genderLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, -1, -1));

        genderComboBox.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        genderComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));
        genderComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                genderComboBoxItemStateChanged(evt);
            }
        });
        formPanel.add(genderComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 260, 220, 30));

        phoneLabel.setFont(new java.awt.Font("Segoe UI Semilight", 1, 18)); // NOI18N
        phoneLabel.setForeground(new java.awt.Color(0, 100, 34));
        phoneLabel.setText("PHONE");
        formPanel.add(phoneLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, -1, -1));

        registerButton.setBackground(new java.awt.Color(0, 100, 34));
        registerButton.setFont(new java.awt.Font("Segoe UI Semilight", 1, 18)); // NOI18N
        registerButton.setForeground(new java.awt.Color(255, 179, 61));
        registerButton.setText("REGISTER");
        registerButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        formPanel.add(registerButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 400, 220, 30));

        photoPanel.setBackground(new java.awt.Color(255, 179, 61));
        photoPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 100, 34)));
        photoPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        photoPanel.add(photoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 220, 200));

        formPanel.add(photoPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 50, 220, 200));

        photoButton.setBackground(new java.awt.Color(0, 100, 34));
        photoButton.setFont(new java.awt.Font("Segoe UI Semilight", 1, 16)); // NOI18N
        photoButton.setForeground(new java.awt.Color(255, 179, 61));
        photoButton.setText("UPLOAD PHOTO");
        photoButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        photoButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                photoButtonMouseClicked(evt);
            }
        });
        photoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                photoButtonActionPerformed(evt);
            }
        });
        formPanel.add(photoButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 260, -1, 30));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        formPanel.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 330, 150, -1));

        mobiListPanel.setBackground(new java.awt.Color(255, 179, 61));
        mobiListPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 100, 34)));
        mobiListPanel.setForeground(new java.awt.Color(0, 100, 34));
        mobiListPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        mobiListLabel.setFont(new java.awt.Font("Segoe UI Semilight", 1, 15)); // NOI18N
        mobiListLabel.setForeground(new java.awt.Color(0, 100, 34));
        mobiListLabel.setText("MOBIS LIST");
        mobiListLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mobiListLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mobiListLabelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout mobiListPanelLayout = new javax.swing.GroupLayout(mobiListPanel);
        mobiListPanel.setLayout(mobiListPanelLayout);
        mobiListPanelLayout.setHorizontalGroup(
            mobiListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mobiListPanelLayout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(mobiListLabel)
                .addContainerGap(76, Short.MAX_VALUE))
        );
        mobiListPanelLayout.setVerticalGroup(
            mobiListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mobiListPanelLayout.createSequentialGroup()
                .addComponent(mobiListLabel)
                .addGap(0, 7, Short.MAX_VALUE))
        );

        formPanel.add(mobiListPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 10, 220, 30));

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

    private void photoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_photoButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_photoButtonActionPerformed

    private void registerButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerButtonMouseClicked
       
           if(firstnameText.getText().isEmpty() ||phoneText.getText().isEmpty()){
               JOptionPane.showMessageDialog(null, "All Fields must not be empty !!");
           }else{
               try {
                   RegisterNewMobiOfficer();
               } catch (SQLException ex) {
                   Logger.getLogger(NewOfficerPage.class.getName()).log(Level.SEVERE, null, ex);
               } catch (ClassNotFoundException ex) {
                   Logger.getLogger(NewOfficerPage.class.getName()).log(Level.SEVERE, null, ex);
               }
             }     
    }//GEN-LAST:event_registerButtonMouseClicked

    private void firstnameTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_firstnameTextKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            lastnameText.requestFocus();
        }
    }//GEN-LAST:event_firstnameTextKeyPressed

    private void lastnameTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lastnameTextKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            dateChooser.requestFocus();
        }
    }//GEN-LAST:event_lastnameTextKeyPressed

    private void dateChooserKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dateChooserKeyPressed
         if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            genderComboBox.requestFocus();
        }
    }//GEN-LAST:event_dateChooserKeyPressed

    private void genderComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_genderComboBoxItemStateChanged
        if(evt.getStateChange() == ItemEvent.SELECTED){
            phoneText.requestFocus();
        }
    }//GEN-LAST:event_genderComboBoxItemStateChanged

    private void phoneTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_phoneTextKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            registerButton.requestFocus();
        }
    }//GEN-LAST:event_phoneTextKeyPressed

    private void registerButtonKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_registerButtonKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            try {
                RegisterNewMobiOfficer();
            } catch (SQLException ex) {
                Logger.getLogger(NewOfficerPage.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(NewOfficerPage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_registerButtonKeyPressed

    private void mobiListLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mobiListLabelMouseClicked
       try {
           mobisPage = new MobisDataPage();
       } catch (ClassNotFoundException ex) {
           Logger.getLogger(NewOfficerPage.class.getName()).log(Level.SEVERE, null, ex);
       } catch (SQLException ex) {
           Logger.getLogger(NewOfficerPage.class.getName()).log(Level.SEVERE, null, ex);
       }
        mobisPage.setVisible(true);
    }//GEN-LAST:event_mobiListLabelMouseClicked

    private void photoButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_photoButtonMouseClicked
        UploadPhoto();
    }//GEN-LAST:event_photoButtonMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser dateChooser;
    private javax.swing.JLabel dateOfBirthLabel;
    private javax.swing.JLabel firstnameLabel;
    private javax.swing.JTextField firstnameText;
    private javax.swing.JPanel formPanel;
    private javax.swing.JComboBox<String> genderComboBox;
    private javax.swing.JLabel genderLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lastnameLabel;
    private javax.swing.JTextField lastnameText;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel mobiListLabel;
    private javax.swing.JPanel mobiListPanel;
    private javax.swing.JLabel phoneLabel;
    private javax.swing.JTextField phoneText;
    private javax.swing.JButton photoButton;
    private javax.swing.JLabel photoLabel;
    private javax.swing.JPanel photoPanel;
    private javax.swing.JButton registerButton;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
