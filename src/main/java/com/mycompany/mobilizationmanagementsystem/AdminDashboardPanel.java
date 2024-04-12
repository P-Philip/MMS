
package com.mycompany.mobilizationmanagementsystem;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class AdminDashboardPanel extends javax.swing.JFrame {

    NewOfficerPage officerPage;
    SalesEntryPage salesPage;
    ReportsGeneratorPage report;
    BonusGeneratorPage bonusGenerator;
    MobisDatabasePage databasePage;
    MobisAccountPage accountPage;
    SusuWeeklyReportPage weeklyReport;
    GridBagLayout gridLayout = new GridBagLayout();
    
    
    //get Admin login name
    public void getAdminName(String name){
   
        userLabel.setText("WELCOME : "+ name);
    }
    public AdminDashboardPanel() {
        
//        officerPage = new NewOfficerPage();
        
       
        initComponents();
        officerPage = new NewOfficerPage();
        salesPage = new SalesEntryPage();
        report = new ReportsGeneratorPage();
        bonusGenerator = new BonusGeneratorPage();
        databasePage = new MobisDatabasePage();
        weeklyReport = new SusuWeeklyReportPage();
        
        
        frame.setLayout(gridLayout);
        GridBagConstraints c = new GridBagConstraints();
         //New Officer Page
        c.gridx= 0;
        c.gridy= 0;
        frame.add(officerPage,c);
        officerPage.setVisible(false);
        
          //Sales Entry Page
        c.gridx= 0;
        c.gridy= 0;
        frame.add(salesPage,c);
        salesPage.setVisible(false);
        
        //Reports Generattor Page
        c.gridx= 0;
        c.gridy= 0;
        frame.add(report,c);
        report.setVisible(false);
        
        //Bonus Generattor Page
        c.gridx= 0;
        c.gridy= 0;
        frame.add(bonusGenerator,c);
        bonusGenerator.setVisible(false);
        
        //Mobis database Page
        c.gridx= 0;
        c.gridy= 0;
        frame.add(databasePage,c);
        databasePage.setVisible(false);
        
        
        //Mobis weekly report Page
        c.gridx= 0;
        c.gridy= 0;
        frame.add(weeklyReport,c);
        weeklyReport.setVisible(false);
        
       
        
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        framePanel = new javax.swing.JPanel();
        topPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        userLabel = new javax.swing.JLabel();
        logoutLabel = new javax.swing.JLabel();
        searchText = new javax.swing.JTextField();
        sidePanel = new javax.swing.JPanel();
        dashboardLabel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        databaseLabel = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        newOfficerLabel1 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        entryLabel1 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        reportLabel = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        bonusReporterLabel = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        mobisWeeklyLabel = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        mobisAccLabel1 = new javax.swing.JLabel();
        frame = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        framePanel.setBackground(new java.awt.Color(0, 100, 34));
        framePanel.setPreferredSize(new java.awt.Dimension(1001, 600));

        topPanel.setBackground(new java.awt.Color(0, 100, 34));
        topPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 179, 61)));
        topPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI Semilight", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 179, 61));
        jLabel1.setText("ADMINISTRATOR");
        topPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 12, -1, -1));

        userLabel.setFont(new java.awt.Font("Serif", 1, 15)); // NOI18N
        userLabel.setForeground(new java.awt.Color(255, 179, 61));
        topPanel.add(userLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 20, 230, 20));

        logoutLabel.setFont(new java.awt.Font("Segoe UI Semilight", 3, 14)); // NOI18N
        logoutLabel.setForeground(new java.awt.Color(255, 253, 184));
        logoutLabel.setText("LOGOUT");
        logoutLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logoutLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutLabelMouseClicked(evt);
            }
        });
        topPanel.add(logoutLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 20, -1, -1));

        searchText.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        searchText.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 179, 61)));
        searchText.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        topPanel.add(searchText, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, 243, 25));

        sidePanel.setBackground(new java.awt.Color(0, 100, 34));
        sidePanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 179, 61)));

        dashboardLabel.setFont(new java.awt.Font("Segoe UI Semilight", 1, 18)); // NOI18N
        dashboardLabel.setForeground(new java.awt.Color(255, 253, 184));
        dashboardLabel.setText("DASHBOARD");

        jSeparator1.setBackground(new java.awt.Color(255, 179, 61));
        jSeparator1.setForeground(new java.awt.Color(255, 179, 61));

        databaseLabel.setFont(new java.awt.Font("Segoe UI Semilight", 1, 18)); // NOI18N
        databaseLabel.setForeground(new java.awt.Color(255, 253, 184));
        databaseLabel.setText("MOBI CUSTOMER DATABASE");
        databaseLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        databaseLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                databaseLabelMouseClicked(evt);
            }
        });

        jSeparator2.setBackground(new java.awt.Color(255, 179, 61));
        jSeparator2.setForeground(new java.awt.Color(255, 179, 61));

        newOfficerLabel1.setFont(new java.awt.Font("Segoe UI Semilight", 1, 18)); // NOI18N
        newOfficerLabel1.setForeground(new java.awt.Color(255, 253, 184));
        newOfficerLabel1.setText("NEW MOBI OFFICER");
        newOfficerLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        newOfficerLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                newOfficerLabel1MouseClicked(evt);
            }
        });

        jSeparator3.setBackground(new java.awt.Color(255, 179, 61));
        jSeparator3.setForeground(new java.awt.Color(255, 179, 61));

        entryLabel1.setFont(new java.awt.Font("Segoe UI Semilight", 1, 18)); // NOI18N
        entryLabel1.setForeground(new java.awt.Color(255, 253, 184));
        entryLabel1.setText("DAILY SALES ENTRY ");
        entryLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        entryLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                entryLabel1MouseClicked(evt);
            }
        });

        jSeparator4.setBackground(new java.awt.Color(255, 179, 61));
        jSeparator4.setForeground(new java.awt.Color(255, 179, 61));

        reportLabel.setFont(new java.awt.Font("Segoe UI Semilight", 1, 18)); // NOI18N
        reportLabel.setForeground(new java.awt.Color(255, 253, 184));
        reportLabel.setText("MOBIS REPORTS");
        reportLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        reportLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                reportLabelMouseClicked(evt);
            }
        });

        jSeparator5.setBackground(new java.awt.Color(255, 179, 61));
        jSeparator5.setForeground(new java.awt.Color(255, 179, 61));

        bonusReporterLabel.setFont(new java.awt.Font("Segoe UI Semilight", 1, 18)); // NOI18N
        bonusReporterLabel.setForeground(new java.awt.Color(255, 253, 184));
        bonusReporterLabel.setText("BONUS CHECKER");
        bonusReporterLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bonusReporterLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bonusReporterLabelMouseClicked(evt);
            }
        });

        jSeparator6.setBackground(new java.awt.Color(255, 179, 61));
        jSeparator6.setForeground(new java.awt.Color(255, 179, 61));

        mobisWeeklyLabel.setFont(new java.awt.Font("Segoe UI Semilight", 1, 18)); // NOI18N
        mobisWeeklyLabel.setForeground(new java.awt.Color(255, 253, 184));
        mobisWeeklyLabel.setText("SUSU WEEKLY REPORT");
        mobisWeeklyLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mobisWeeklyLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mobisWeeklyLabelMouseClicked(evt);
            }
        });

        jSeparator7.setBackground(new java.awt.Color(255, 179, 61));
        jSeparator7.setForeground(new java.awt.Color(255, 179, 61));

        mobisAccLabel1.setFont(new java.awt.Font("Segoe UI Semilight", 1, 18)); // NOI18N
        mobisAccLabel1.setForeground(new java.awt.Color(255, 253, 184));
        mobisAccLabel1.setText("MOBIS ACCOUNT");
        mobisAccLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mobisAccLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mobisAccLabel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout sidePanelLayout = new javax.swing.GroupLayout(sidePanel);
        sidePanel.setLayout(sidePanelLayout);
        sidePanelLayout.setHorizontalGroup(
            sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jSeparator2)
            .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jSeparator4)
            .addComponent(jSeparator5)
            .addComponent(jSeparator6)
            .addComponent(jSeparator7, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(sidePanelLayout.createSequentialGroup()
                .addGroup(sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sidePanelLayout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(dashboardLabel))
                    .addGroup(sidePanelLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(newOfficerLabel1))
                    .addGroup(sidePanelLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(entryLabel1))
                    .addGroup(sidePanelLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(databaseLabel))
                    .addGroup(sidePanelLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(reportLabel))
                    .addGroup(sidePanelLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(bonusReporterLabel))
                    .addGroup(sidePanelLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(mobisAccLabel1))
                    .addGroup(sidePanelLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(mobisWeeklyLabel)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        sidePanelLayout.setVerticalGroup(
            sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dashboardLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(newOfficerLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(entryLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(databaseLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(reportLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bonusReporterLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mobisAccLabel1)
                .addGap(11, 11, 11)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(mobisWeeklyLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        frame.setBackground(new java.awt.Color(0, 100, 34));
        frame.setPreferredSize(new java.awt.Dimension(690, 538));
        frame.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout framePanelLayout = new javax.swing.GroupLayout(framePanel);
        framePanel.setLayout(framePanelLayout);
        framePanelLayout.setHorizontalGroup(
            framePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(framePanelLayout.createSequentialGroup()
                .addComponent(sidePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(frame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(278, 278, 278))
            .addComponent(topPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        framePanelLayout.setVerticalGroup(
            framePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(framePanelLayout.createSequentialGroup()
                .addComponent(topPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(framePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sidePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(frame, javax.swing.GroupLayout.DEFAULT_SIZE, 599, Short.MAX_VALUE)))
        );

        getContentPane().add(framePanel, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void newOfficerLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newOfficerLabel1MouseClicked
        officerPage.setVisible(true);
        salesPage.setVisible(false);
        report.setVisible(false);
        bonusGenerator.setVisible(false);
        databasePage.setVisible(false);
        weeklyReport.setVisible(false);
        
    }//GEN-LAST:event_newOfficerLabel1MouseClicked

    private void entryLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_entryLabel1MouseClicked
        salesPage.setVisible(true);
        officerPage.setVisible(false);
        report.setVisible(false);
        bonusGenerator.setVisible(false);
        databasePage.setVisible(false);
        weeklyReport.setVisible(false);
       
    }//GEN-LAST:event_entryLabel1MouseClicked

    private void reportLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reportLabelMouseClicked
        report.setVisible(true);
        officerPage.setVisible(false);
        salesPage.setVisible(false);
        bonusGenerator.setVisible(false);
        databasePage.setVisible(false);
        weeklyReport.setVisible(false);
        
    }//GEN-LAST:event_reportLabelMouseClicked

    private void bonusReporterLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bonusReporterLabelMouseClicked
        bonusGenerator.setVisible(true);
        report.setVisible(false);
        officerPage.setVisible(false);
        salesPage.setVisible(false);
        databasePage.setVisible(false);
        weeklyReport.setVisible(false);
        
    }//GEN-LAST:event_bonusReporterLabelMouseClicked

    private void databaseLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_databaseLabelMouseClicked
        databasePage.setVisible(true);
        bonusGenerator.setVisible(false);
        report.setVisible(false);
        officerPage.setVisible(false);
        salesPage.setVisible(false);
        weeklyReport.setVisible(false);
    }//GEN-LAST:event_databaseLabelMouseClicked

    private void logoutLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutLabelMouseClicked
        int comfirmLogout = JOptionPane.showConfirmDialog(null, "Are You Sure You want to Logout !!","Warning",JOptionPane.YES_NO_OPTION);
        if(comfirmLogout == JOptionPane.YES_OPTION){
            this.setVisible(false);
        }
    }//GEN-LAST:event_logoutLabelMouseClicked

    private void mobisWeeklyLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mobisWeeklyLabelMouseClicked
        weeklyReport.setVisible(true);
        officerPage.setVisible(false);
        salesPage.setVisible(false);
        report.setVisible(false);
        bonusGenerator.setVisible(false);
        databasePage.setVisible(false);
    }//GEN-LAST:event_mobisWeeklyLabelMouseClicked

    private void mobisAccLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mobisAccLabel1MouseClicked
        accountPage = new MobisAccountPage();
        accountPage.setVisible(true);
    }//GEN-LAST:event_mobisAccLabel1MouseClicked

  
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
            java.util.logging.Logger.getLogger(AdminDashboardPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminDashboardPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminDashboardPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminDashboardPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminDashboardPanel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bonusReporterLabel;
    private javax.swing.JLabel dashboardLabel;
    private javax.swing.JLabel databaseLabel;
    private javax.swing.JLabel entryLabel1;
    private javax.swing.JPanel frame;
    private javax.swing.JPanel framePanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JLabel logoutLabel;
    private javax.swing.JLabel mobisAccLabel1;
    private javax.swing.JLabel mobisWeeklyLabel;
    private javax.swing.JLabel newOfficerLabel1;
    private javax.swing.JLabel reportLabel;
    private javax.swing.JTextField searchText;
    private javax.swing.JPanel sidePanel;
    private javax.swing.JPanel topPanel;
    private javax.swing.JLabel userLabel;
    // End of variables declaration//GEN-END:variables
}
