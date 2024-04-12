
package com.mycompany.mobilizationmanagementsystem;

import java.awt.Color;
import javax.swing.JOptionPane;


public class BonusGeneratorPage extends javax.swing.JPanel {

  // method tpo generate check for bonus
    public void GenerateBonus(){
        //get ation command names from each radio buttons
        String accountOpenOption =accOpenRadioButton.getActionCommand() ;
        String mobilizationOption =mobilizationRadioButton.getActionCommand() ;
        String customerVisitOption =customerVisitRadioButton.getActionCommand() ;
        String loansOption =loanRadioButton.getActionCommand() ;
        String[]  bonusOptions ={accountOpenOption,mobilizationOption,customerVisitOption,
        loansOption};
       
       
       
       if(mobilizationRadioButton.isSelected()){
           int numOfMobilization =Integer.parseInt(JOptionPane.showInputDialog(null, "Enter Total Amount mobilized ",
       "Total Amount Mobilized",JOptionPane.QUESTION_MESSAGE));
           int numOfCustVisited =Integer.parseInt(JOptionPane.showInputDialog(null, "Enter Total Customers Visited ",
       "Total Customers Visited",JOptionPane.QUESTION_MESSAGE));
           if(numOfMobilization >=7200 && numOfCustVisited >= 1260){
               JOptionPane.showMessageDialog(null, "You have earned a bonus of GHS 100.00");
           }else{
               JOptionPane.showMessageDialog(null, "You did not earn any bonus");
           }
       }else if(accOpenRadioButton.isSelected()){
           int numOfAccOpened =Integer.parseInt(JOptionPane.showInputDialog(null, "Enter Total Account Opened ",
       "Total Account Opened",JOptionPane.QUESTION_MESSAGE));
           if(numOfAccOpened >= 6){
              JOptionPane.showMessageDialog(null, "You have earned a bonus of GHS 30.00");
           }else{
               JOptionPane.showMessageDialog(null, "You did not not open enough account to "
            + "earn you a bonus");
           }
       }
       
       else if(customerVisitRadioButton.isSelected()){
           int numOfCusVisited =Integer.parseInt(JOptionPane.showInputDialog(null, "Enter Total Customers Visited ",
       "Total Customers Visited",JOptionPane.QUESTION_MESSAGE));
           if(numOfCusVisited >=1260){
               JOptionPane.showMessageDialog(null, "You have earned a bonus of GHS 100.00");
           }else{
               JOptionPane.showMessageDialog(null, "You did not earn any bonus");
           }
       }else if(loanRadioButton.isSelected()){
           int numOfLoansGranted =Integer.parseInt(JOptionPane.showInputDialog(null, "Enter Total Loans Granted",
       "Total Loans Granted",JOptionPane.QUESTION_MESSAGE));
           if(numOfLoansGranted >=4){
              JOptionPane.showMessageDialog(null, "You have earned a bonus of GHS 200.00"); 
           }else{
               JOptionPane.showMessageDialog(null, "You did not earn any bonus");
           }
       } 
       else{
           JOptionPane.showMessageDialog(null, "Select one option at a time");
       }
    }
    public BonusGeneratorPage() {
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        buttonGroup5 = new javax.swing.ButtonGroup();
        mainPanel = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        formPanel = new javax.swing.JPanel();
        generateButton = new javax.swing.JButton();
        targetParameterPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        customerVisitPanel = new javax.swing.JPanel();
        customerVisitLabel = new javax.swing.JLabel();
        loanPanel = new javax.swing.JPanel();
        loansLabel = new javax.swing.JLabel();
        mobilizationPanel = new javax.swing.JPanel();
        mobilizationLabel = new javax.swing.JLabel();
        accountOpenPanel = new javax.swing.JPanel();
        accountOpenLabel = new javax.swing.JLabel();
        bonusGeneratorPanel = new javax.swing.JPanel();
        accOpenRadioButton = new javax.swing.JRadioButton();
        mobilizationRadioButton = new javax.swing.JRadioButton();
        customerVisitRadioButton = new javax.swing.JRadioButton();
        loanRadioButton = new javax.swing.JRadioButton();

        mainPanel.setBackground(new java.awt.Color(255, 179, 61));
        mainPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titleLabel.setFont(new java.awt.Font("Segoe UI Semilight", 1, 20)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(0, 100, 34));
        titleLabel.setText("BONUS GENERATOR AND MONTHLY TARGET ");
        mainPanel.add(titleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, -1, -1));

        formPanel.setBackground(new java.awt.Color(255, 179, 61));
        formPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 100, 34)));
        formPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        generateButton.setBackground(new java.awt.Color(0, 100, 34));
        generateButton.setFont(new java.awt.Font("Segoe UI Semilight", 1, 18)); // NOI18N
        generateButton.setForeground(new java.awt.Color(255, 179, 61));
        generateButton.setText("GENERATE");
        generateButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        generateButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                generateButtonMouseClicked(evt);
            }
        });
        formPanel.add(generateButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, 220, 30));

        targetParameterPanel.setBackground(new java.awt.Color(255, 179, 61));
        targetParameterPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "TARGET PARAMETERS INFO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 15), new java.awt.Color(0, 100, 34))); // NOI18N

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        customerVisitPanel.setBackground(new java.awt.Color(0, 100, 34));
        customerVisitPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                customerVisitPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                customerVisitPanelMouseExited(evt);
            }
        });

        customerVisitLabel.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        customerVisitLabel.setForeground(new java.awt.Color(255, 179, 61));
        customerVisitLabel.setText("CUSTOMER VISITATION");
        customerVisitLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        customerVisitLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                customerVisitLabelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout customerVisitPanelLayout = new javax.swing.GroupLayout(customerVisitPanel);
        customerVisitPanel.setLayout(customerVisitPanelLayout);
        customerVisitPanelLayout.setHorizontalGroup(
            customerVisitPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, customerVisitPanelLayout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addComponent(customerVisitLabel)
                .addGap(33, 33, 33))
        );
        customerVisitPanelLayout.setVerticalGroup(
            customerVisitPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customerVisitPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(customerVisitLabel)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        loanPanel.setBackground(new java.awt.Color(0, 100, 34));
        loanPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loanPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                loanPanelMouseExited(evt);
            }
        });

        loansLabel.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        loansLabel.setForeground(new java.awt.Color(255, 179, 61));
        loansLabel.setText("LOANS");
        loansLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        loansLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        loansLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loansLabelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout loanPanelLayout = new javax.swing.GroupLayout(loanPanel);
        loanPanel.setLayout(loanPanelLayout);
        loanPanelLayout.setHorizontalGroup(
            loanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loanPanelLayout.createSequentialGroup()
                .addContainerGap(94, Short.MAX_VALUE)
                .addComponent(loansLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63))
        );
        loanPanelLayout.setVerticalGroup(
            loanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loanPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(loansLabel)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        mobilizationPanel.setBackground(new java.awt.Color(0, 100, 34));
        mobilizationPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                mobilizationPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                mobilizationPanelMouseExited(evt);
            }
        });

        mobilizationLabel.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        mobilizationLabel.setForeground(new java.awt.Color(255, 179, 61));
        mobilizationLabel.setText("MOBILZATION");
        mobilizationLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mobilizationLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mobilizationLabelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout mobilizationPanelLayout = new javax.swing.GroupLayout(mobilizationPanel);
        mobilizationPanel.setLayout(mobilizationPanelLayout);
        mobilizationPanelLayout.setHorizontalGroup(
            mobilizationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mobilizationPanelLayout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(mobilizationLabel)
                .addContainerGap(76, Short.MAX_VALUE))
        );
        mobilizationPanelLayout.setVerticalGroup(
            mobilizationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mobilizationPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mobilizationLabel)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        accountOpenPanel.setBackground(new java.awt.Color(0, 100, 34));
        accountOpenPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                accountOpenPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                accountOpenPanelMouseExited(evt);
            }
        });

        accountOpenLabel.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        accountOpenLabel.setForeground(new java.awt.Color(255, 179, 61));
        accountOpenLabel.setText("ACCOUNT OPENINIG");
        accountOpenLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        accountOpenLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                accountOpenLabelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout accountOpenPanelLayout = new javax.swing.GroupLayout(accountOpenPanel);
        accountOpenPanel.setLayout(accountOpenPanelLayout);
        accountOpenPanelLayout.setHorizontalGroup(
            accountOpenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, accountOpenPanelLayout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addComponent(accountOpenLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );
        accountOpenPanelLayout.setVerticalGroup(
            accountOpenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(accountOpenPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(accountOpenLabel)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout targetParameterPanelLayout = new javax.swing.GroupLayout(targetParameterPanel);
        targetParameterPanel.setLayout(targetParameterPanelLayout);
        targetParameterPanelLayout.setHorizontalGroup(
            targetParameterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, targetParameterPanelLayout.createSequentialGroup()
                .addGap(260, 260, 260)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(241, 241, 241))
            .addGroup(targetParameterPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(targetParameterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(loanPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(customerVisitPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mobilizationPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(accountOpenPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        targetParameterPanelLayout.setVerticalGroup(
            targetParameterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(targetParameterPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(accountOpenPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(mobilizationPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(customerVisitPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(loanPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(326, 326, 326))
        );

        formPanel.add(targetParameterPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 30, 300, 300));

        bonusGeneratorPanel.setBackground(new java.awt.Color(255, 179, 61));
        bonusGeneratorPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "BONUS GENERATOR", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 3, 16), new java.awt.Color(0, 100, 34))); // NOI18N
        bonusGeneratorPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        accOpenRadioButton.setBackground(new java.awt.Color(255, 179, 61));
        accOpenRadioButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        accOpenRadioButton.setForeground(new java.awt.Color(0, 100, 34));
        accOpenRadioButton.setText("ACCOUNT OPENING TARGET");
        accOpenRadioButton.setBorder(null);
        accOpenRadioButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        accOpenRadioButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                accOpenRadioButtonMouseClicked(evt);
            }
        });
        bonusGeneratorPanel.add(accOpenRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 230, 30));

        mobilizationRadioButton.setBackground(new java.awt.Color(255, 179, 61));
        mobilizationRadioButton.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        mobilizationRadioButton.setForeground(new java.awt.Color(0, 100, 34));
        mobilizationRadioButton.setText("MOBILIZATION TARGET");
        mobilizationRadioButton.setBorder(null);
        mobilizationRadioButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bonusGeneratorPanel.add(mobilizationRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 220, 30));

        customerVisitRadioButton.setBackground(new java.awt.Color(255, 179, 61));
        customerVisitRadioButton.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        customerVisitRadioButton.setForeground(new java.awt.Color(0, 100, 34));
        customerVisitRadioButton.setText("CUSTOMER VISITATION");
        customerVisitRadioButton.setBorder(null);
        customerVisitRadioButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bonusGeneratorPanel.add(customerVisitRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 220, 30));

        loanRadioButton.setBackground(new java.awt.Color(255, 179, 61));
        loanRadioButton.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        loanRadioButton.setForeground(new java.awt.Color(0, 100, 34));
        loanRadioButton.setText("LOANS GRANTED TARGET");
        loanRadioButton.setBorder(null);
        bonusGeneratorPanel.add(loanRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 253, 230, 30));

        formPanel.add(bonusGeneratorPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 280, 300));

        mainPanel.add(formPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 650, 500));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 805, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void accountOpenPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accountOpenPanelMouseEntered
        accountOpenPanel.setBackground(new Color(0,120,30));
    }//GEN-LAST:event_accountOpenPanelMouseEntered

    private void accountOpenPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accountOpenPanelMouseExited
        accountOpenPanel.setBackground(new Color(0,100,34));
    }//GEN-LAST:event_accountOpenPanelMouseExited

    private void mobilizationPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mobilizationPanelMouseEntered
        mobilizationPanel.setBackground(new Color(0,120,30));
    }//GEN-LAST:event_mobilizationPanelMouseEntered

    private void mobilizationPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mobilizationPanelMouseExited
        mobilizationPanel.setBackground(new Color(0,100,34));
    }//GEN-LAST:event_mobilizationPanelMouseExited

    private void customerVisitPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customerVisitPanelMouseEntered
        customerVisitPanel.setBackground(new Color(0,120,30));
    }//GEN-LAST:event_customerVisitPanelMouseEntered

    private void customerVisitPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customerVisitPanelMouseExited
        customerVisitPanel.setBackground(new Color(0,100,34));
    }//GEN-LAST:event_customerVisitPanelMouseExited

    private void loanPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loanPanelMouseEntered
        loanPanel.setBackground(new Color(0,120,30));
    }//GEN-LAST:event_loanPanelMouseEntered

    private void loanPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loanPanelMouseExited
        loanPanel.setBackground(new Color(0,100,34));
    }//GEN-LAST:event_loanPanelMouseExited

    private void accOpenRadioButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accOpenRadioButtonMouseClicked
        
        
//        jLabel1.setText(accountOption);
        
    }//GEN-LAST:event_accOpenRadioButtonMouseClicked

    private void generateButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_generateButtonMouseClicked
        GenerateBonus();
    }//GEN-LAST:event_generateButtonMouseClicked

    private void accountOpenLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accountOpenLabelMouseClicked
        JOptionPane.showMessageDialog(null, "To Achieve a bonus on Account opening,\n  an officer"
         + "must open atleast 6 new account including dormant account reactivation", "Bonus Parameters info"
         ,JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_accountOpenLabelMouseClicked

    private void mobilizationLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mobilizationLabelMouseClicked
        JOptionPane.showMessageDialog(null, "To Achieve a bonus on Mobiliztion,\n  an officer"
         + " must achieve 60% of the mobilization target set for the month", "Bonus Parameters info"
         ,JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_mobilizationLabelMouseClicked

    private void customerVisitLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customerVisitLabelMouseClicked
       JOptionPane.showMessageDialog(null, "To Achieve a bonus on Customer Visitation,\n  an officer"
         + " must achieve 60% of the Customer Visitation target set for the month", "Bonus Parameters info"
         ,JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_customerVisitLabelMouseClicked

    private void loansLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loansLabelMouseClicked
        JOptionPane.showMessageDialog(null, "To Achieve a bonus on Loans,\n an officer "
         + " must have atleat 4 of his or her customers granted for loan", "Bonus Parameters info"
         ,JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_loansLabelMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton accOpenRadioButton;
    private javax.swing.JLabel accountOpenLabel;
    private javax.swing.JPanel accountOpenPanel;
    private javax.swing.JPanel bonusGeneratorPanel;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private javax.swing.JLabel customerVisitLabel;
    private javax.swing.JPanel customerVisitPanel;
    private javax.swing.JRadioButton customerVisitRadioButton;
    private javax.swing.JPanel formPanel;
    private javax.swing.JButton generateButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel loanPanel;
    private javax.swing.JRadioButton loanRadioButton;
    private javax.swing.JLabel loansLabel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel mobilizationLabel;
    private javax.swing.JPanel mobilizationPanel;
    private javax.swing.JRadioButton mobilizationRadioButton;
    private javax.swing.JPanel targetParameterPanel;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
