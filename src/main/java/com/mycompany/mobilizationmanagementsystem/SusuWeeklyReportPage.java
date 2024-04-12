
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
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


@SuppressWarnings("serial")
public class SusuWeeklyReportPage extends javax.swing.JPanel {
    public DatabaseConnection connect;
    public Connection con;
    PreparedStatement statement;
    ResultSet result;
    ResultSetMetaData metadata;
    DefaultTableModel tableModel;
    int columnCount;
    
    //method to calculate total sales
    public void CalculateTotalSales(){
        int finalTotalSales=0;
        String TotalsalesFormat=null;
        NumberFormat numberFormat = NumberFormat.getInstance();
        
        
        for(int i=0;i<weeklyReportTable.getRowCount();i++){
                int sales = Integer.parseInt(weeklyReportTable.getValueAt(i, 1).toString()); 
                finalTotalSales = finalTotalSales +sales;
                TotalsalesFormat =String.valueOf(numberFormat.format(finalTotalSales));
                
               }
               JOptionPane.showMessageDialog(null, "Total Sales is  "+TotalsalesFormat);
               
    }
    
    //method to calculate total customers visited
    public void CalculateTotalCustomersVisited(){
        NumberFormat numberFormat = NumberFormat.getInstance();
        int totalCustomersFormat=0;
        int finalTotalCusstomersVisited=0;
        for(int i=0;i<weeklyReportTable.getRowCount();i++){
                   
                finalTotalCusstomersVisited=finalTotalCusstomersVisited +
                Integer.parseInt(weeklyReportTable.getValueAt(i, 2).toString());
                totalCustomersFormat =Integer.parseInt(numberFormat.format(finalTotalCusstomersVisited));
               }
               JOptionPane.showMessageDialog(null, "Total Customers Visited is "+totalCustomersFormat);
               
    }
    
    //method to generate mobis report
    public void GenerateMobiReport() throws SQLException{
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
        try {
            //establish database connection
            connect = new DatabaseConnection();
            con = connect.getConnection();
            String mobiAccountNum = mobiAccNoText.getText();
            String startDate = dateFormat.format(startDateChooser.getDate());
            String endDate = dateFormat.format(endDateChooser.getDate());
            String selectQuery="SELECT * FROM `daily sales table`"
            +" WHERE  `Date` BETWEEN ? AND ?";  
            
           
            
            
             statement = con.prepareStatement(selectQuery);
             statement.setString(1,startDate);
             statement.setString(2,endDate);
//             statement.setString(3,mobiAccountNum);
            
             result = statement.executeQuery();
             metadata = result.getMetaData();
             columnCount = metadata.getColumnCount();
             
             tableModel = (DefaultTableModel) weeklyReportTable.getModel();
             tableModel.setRowCount(0);
             
//             for(int i=0;result.next();i++){
//                 
//             }
             
             
             while(result.next()){
                 //getting data from database table
               
               String date =String.valueOf(result.getDate("Date"));
               int dailySales = result.getInt("Daily Sales");
               int customerVisited = result.getInt("Customers_Visited");
               String mobiAccNo = result.getString("Mobi Account Number");
               
               if(mobiAccountNum.equals(mobiAccNo)){
                   //storing data into a string array variable
               Object[] rowData={date,dailySales,customerVisited};
               
               //adding values into jtable
               tableModel.addRow(rowData);
               mobiAccNoText.setText(""); 
               mobiAccNoText.requestFocus();
                   
               }
               
            
            }  
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SusuWeeklyReportPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
    public SusuWeeklyReportPage() {
        initComponents();
        weeklyReportTable.getTableHeader().setFont(new Font("Tahoma",Font.BOLD,14));
        weeklyReportTable.getTableHeader().setBackground(Color.BLACK);
        weeklyReportTable.getTableHeader().setForeground(new Color(0,100,34));
//        productTable.getTableHeader().setOpaque(false);
        weeklyReportTable.setRowHeight(20);
        weeklyReportTable.setFont(new Font("Tahoma",Font.BOLD,14));
        weeklyReportTable.setRowMargin(1);
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
        weeklyReportTable = new javax.swing.JTable();
        totalSalesButton = new javax.swing.JButton();
        totalCustomerVisited = new javax.swing.JButton();
        generateButton = new javax.swing.JButton();
        startDateLabel = new javax.swing.JLabel();
        startDateChooser = new com.toedter.calendar.JDateChooser();
        endDateChooser = new com.toedter.calendar.JDateChooser();
        endDateLabel = new javax.swing.JLabel();

        mainPanel.setBackground(new java.awt.Color(255, 179, 61));
        mainPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titleLabel.setFont(new java.awt.Font("Segoe UI Semilight", 1, 28)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(0, 100, 34));
        titleLabel.setText("SUSU WEEKLY REPORTS GENERATOR");
        mainPanel.add(titleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 0, -1, -1));

        formPanel.setBackground(new java.awt.Color(255, 179, 61));
        formPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 100, 34)));
        formPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mobiAccNoLabel.setFont(new java.awt.Font("Segoe UI Semilight", 1, 15)); // NOI18N
        mobiAccNoLabel.setForeground(new java.awt.Color(0, 100, 34));
        mobiAccNoLabel.setText("Mobi Acc. No");
        formPanel.add(mobiAccNoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        mobiAccNoText.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        mobiAccNoText.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 100, 34)));
        mobiAccNoText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mobiAccNoTextActionPerformed(evt);
            }
        });
        mobiAccNoText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                mobiAccNoTextKeyPressed(evt);
            }
        });
        formPanel.add(mobiAccNoText, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 220, 30));

        mobiNameLabel.setFont(new java.awt.Font("Segoe UI Semilight", 1, 15)); // NOI18N
        mobiNameLabel.setForeground(new java.awt.Color(0, 100, 34));
        mobiNameLabel.setText(" Mobi Name ");
        formPanel.add(mobiNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 20, -1, -1));

        mobiNameText.setEditable(false);
        mobiNameText.setBackground(new java.awt.Color(255, 253, 184));
        mobiNameText.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        mobiNameText.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        mobiNameText.setDisabledTextColor(new java.awt.Color(255, 253, 184));
        formPanel.add(mobiNameText, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 10, 220, 30));

        printtButton.setBackground(new java.awt.Color(0, 100, 34));
        printtButton.setFont(new java.awt.Font("Segoe UI Semilight", 1, 15)); // NOI18N
        printtButton.setForeground(new java.awt.Color(255, 179, 61));
        printtButton.setText("PRINT");
        printtButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        printtButton.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                printtButtonKeyPressed(evt);
            }
        });
        formPanel.add(printtButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, 130, 30));

        weeklyReportTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 100, 34)));
        weeklyReportTable.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        weeklyReportTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", " Daily Sales", " Customers Visited"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(weeklyReportTable);

        formPanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 660, 220));

        totalSalesButton.setBackground(new java.awt.Color(0, 100, 34));
        totalSalesButton.setFont(new java.awt.Font("Segoe UI Semilight", 1, 15)); // NOI18N
        totalSalesButton.setForeground(new java.awt.Color(255, 179, 61));
        totalSalesButton.setText("FIND TOTAL SALES");
        totalSalesButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        totalSalesButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                totalSalesButtonMouseClicked(evt);
            }
        });
        formPanel.add(totalSalesButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 410, 180, 30));

        totalCustomerVisited.setBackground(new java.awt.Color(0, 100, 34));
        totalCustomerVisited.setFont(new java.awt.Font("Segoe UI Semilight", 1, 15)); // NOI18N
        totalCustomerVisited.setForeground(new java.awt.Color(255, 179, 61));
        totalCustomerVisited.setText("FIND TOTAL CUS. VISITED");
        totalCustomerVisited.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        totalCustomerVisited.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                totalCustomerVisitedMouseClicked(evt);
            }
        });
        formPanel.add(totalCustomerVisited, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 410, 220, 30));

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
        generateButton.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                generateButtonKeyPressed(evt);
            }
        });
        formPanel.add(generateButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 130, 140, 30));

        startDateLabel.setFont(new java.awt.Font("Segoe UI Semilight", 1, 15)); // NOI18N
        startDateLabel.setForeground(new java.awt.Color(0, 100, 34));
        startDateLabel.setText("Start Date");
        formPanel.add(startDateLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        startDateChooser.setBackground(new java.awt.Color(255, 255, 255));
        startDateChooser.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 100, 34)));
        startDateChooser.setForeground(new java.awt.Color(0, 100, 34));
        startDateChooser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                startDateChooserKeyPressed(evt);
            }
        });
        formPanel.add(startDateChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 220, 30));

        endDateChooser.setBackground(new java.awt.Color(255, 255, 255));
        endDateChooser.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 100, 34)));
        endDateChooser.setForeground(new java.awt.Color(0, 100, 34));
        endDateChooser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                endDateChooserKeyPressed(evt);
            }
        });
        formPanel.add(endDateChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 80, 220, 30));

        endDateLabel.setFont(new java.awt.Font("Segoe UI Semibold", 1, 15)); // NOI18N
        endDateLabel.setForeground(new java.awt.Color(0, 100, 34));
        endDateLabel.setText("End Date");
        formPanel.add(endDateLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 90, -1, -1));

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

    private void mobiAccNoTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mobiAccNoTextKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            //establish database connection
            connect = new DatabaseConnection();
            String mobiAccNum = mobiAccNoText.getText();
            try {
                con = connect.getConnection();
                String retrieveQuery = "SELECT * FROM `mobis account number table`WHERE "
            + "`Mobi Account Number`= ?";
            
            statement = con.prepareStatement(retrieveQuery);
            statement.setString(1, mobiAccNum);
            result=statement.executeQuery();
            
            if(result.next()){
                String mobiName = result.getString("Mobi Name");
                mobiNameText.setText(mobiName);
                startDateChooser.requestFocus();
            }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(SusuWeeklyReportPage.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(SusuWeeklyReportPage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_mobiAccNoTextKeyPressed

    private void generateButtonKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_generateButtonKeyPressed
        try {
            GenerateMobiReport();
        } catch (SQLException ex) {
            Logger.getLogger(SusuWeeklyReportPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_generateButtonKeyPressed

    private void generateButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_generateButtonMouseClicked
        if(!mobiAccNoText.getText().isEmpty()){
            try {
            GenerateMobiReport();
        } catch (SQLException ex) {
            Logger.getLogger(SusuWeeklyReportPage.class.getName()).log(Level.SEVERE, null, ex);
        } 
        }else{
            JOptionPane.showMessageDialog(null, "Enter Mobi Account Number to proceed");
            mobiAccNoText.requestFocus();
        }
       
    }//GEN-LAST:event_generateButtonMouseClicked

    private void totalSalesButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_totalSalesButtonMouseClicked
        CalculateTotalSales();
    }//GEN-LAST:event_totalSalesButtonMouseClicked

    private void totalCustomerVisitedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_totalCustomerVisitedMouseClicked
        CalculateTotalCustomersVisited();
    }//GEN-LAST:event_totalCustomerVisitedMouseClicked

    private void printtButtonKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_printtButtonKeyPressed
        try {
            weeklyReportTable.print();
        } catch (PrinterException ex) {
            Logger.getLogger(SusuWeeklyReportPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_printtButtonKeyPressed

    private void mobiAccNoTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mobiAccNoTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mobiAccNoTextActionPerformed

    private void startDateChooserKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_startDateChooserKeyPressed
        if(evt.getKeyCode()== KeyEvent.VK_ENTER){
            endDateChooser.requestFocus();
        }
    }//GEN-LAST:event_startDateChooserKeyPressed

    private void endDateChooserKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_endDateChooserKeyPressed
         if(evt.getKeyCode()== KeyEvent.VK_ENTER){
            generateButton.requestFocus();
        }
    }//GEN-LAST:event_endDateChooserKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser endDateChooser;
    private javax.swing.JLabel endDateLabel;
    private javax.swing.JPanel formPanel;
    private javax.swing.JButton generateButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel mobiAccNoLabel;
    private javax.swing.JTextField mobiAccNoText;
    private javax.swing.JLabel mobiNameLabel;
    private javax.swing.JTextField mobiNameText;
    private javax.swing.JButton printtButton;
    private com.toedter.calendar.JDateChooser startDateChooser;
    private javax.swing.JLabel startDateLabel;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JButton totalCustomerVisited;
    private javax.swing.JButton totalSalesButton;
    private javax.swing.JTable weeklyReportTable;
    // End of variables declaration//GEN-END:variables
}
