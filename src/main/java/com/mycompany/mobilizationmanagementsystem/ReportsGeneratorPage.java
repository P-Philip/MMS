
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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


@SuppressWarnings("serial")
public class ReportsGeneratorPage extends javax.swing.JPanel {
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
        
        
        for(int i=0;i<reportTable.getRowCount();i++){
                int sales = Integer.parseInt(reportTable.getValueAt(i, 1).toString()); 
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
        for(int i=0;i<reportTable.getRowCount();i++){
                   
                finalTotalCusstomersVisited=finalTotalCusstomersVisited +
                Integer.parseInt(reportTable.getValueAt(i, 2).toString());
                totalCustomersFormat =Integer.parseInt(numberFormat.format(finalTotalCusstomersVisited));
               }
               JOptionPane.showMessageDialog(null, "Total Customers Visited is "+totalCustomersFormat);
               
    }
    
    //method to generate mobis report
    public void GenerateMobiReport() throws SQLException{
        
        try {
            //establish database connection
            connect = new DatabaseConnection();
            con = connect.getConnection();
            String mobiAccountNum = mobiAccNoText.getText();
            
            String selectQuery="SELECT * FROM `daily sales table`"
             +" WHERE  `Mobi Account Number`=? ORDER BY `Date`" ;
            
            
             statement = con.prepareStatement(selectQuery);
             statement.setString(1,mobiAccountNum);
             result = statement.executeQuery();
             metadata = result.getMetaData();
             columnCount = metadata.getColumnCount();
             
             tableModel = (DefaultTableModel) reportTable.getModel();
             tableModel.setRowCount(0);
             
//             for(int i=0;result.next();i++){
//                 
//             }
             
             
             while(result.next()){
                 //getting data from database table
               
               String date =result.getString("Date");
               int dailySales = result.getInt("Daily Sales");
               int customerVisited = result.getInt("Customers_Visited");
               
         
               
                //storing data into a string array variable
               Object[] rowData={date,dailySales,customerVisited};
               
               //adding values into jtable
               tableModel.addRow(rowData);
               mobiAccNoText.setText(""); 
               mobiAccNoText.requestFocus();
            
            }  
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReportsGeneratorPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
    public ReportsGeneratorPage() {
        initComponents();
        reportTable.getTableHeader().setFont(new Font("Tahoma",Font.BOLD,14));
        reportTable.getTableHeader().setBackground(Color.BLACK);
        reportTable.getTableHeader().setForeground(new Color(0,100,34));
//        productTable.getTableHeader().setOpaque(false);
        reportTable.setRowHeight(20);
        reportTable.setFont(new Font("Tahoma",Font.BOLD,14));
        reportTable.setRowMargin(1);
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
        reportTable = new javax.swing.JTable();
        totalSalesButton = new javax.swing.JButton();
        totalCustomerVisited = new javax.swing.JButton();
        generateButton = new javax.swing.JButton();

        mainPanel.setBackground(new java.awt.Color(255, 179, 61));
        mainPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titleLabel.setFont(new java.awt.Font("Segoe UI Semilight", 1, 28)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(0, 100, 34));
        titleLabel.setText("REPORTS GENERATOR");
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
        printtButton.setFont(new java.awt.Font("Segoe UI Semilight", 1, 15)); // NOI18N
        printtButton.setForeground(new java.awt.Color(255, 179, 61));
        printtButton.setText("PRINT");
        printtButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        printtButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                printtButtonMouseClicked(evt);
            }
        });
        printtButton.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                printtButtonKeyPressed(evt);
            }
        });
        formPanel.add(printtButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, 130, 30));

        reportTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 100, 34)));
        reportTable.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        reportTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(reportTable);

        formPanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 660, 260));

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
        formPanel.add(generateButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 90, 140, 30));

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
                generateButton.requestFocus();
            }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ReportsGeneratorPage.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ReportsGeneratorPage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_mobiAccNoTextKeyPressed

    private void generateButtonKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_generateButtonKeyPressed
        try {
            GenerateMobiReport();
        } catch (SQLException ex) {
            Logger.getLogger(ReportsGeneratorPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_generateButtonKeyPressed

    private void generateButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_generateButtonMouseClicked
        try {
            GenerateMobiReport();
        } catch (SQLException ex) {
            Logger.getLogger(ReportsGeneratorPage.class.getName()).log(Level.SEVERE, null, ex);
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
            reportTable.print();
        } catch (PrinterException ex) {
            Logger.getLogger(ReportsGeneratorPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_printtButtonKeyPressed

    private void printtButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_printtButtonMouseClicked
        try {
            reportTable.print();
        } catch (PrinterException ex) {
            Logger.getLogger(ReportsGeneratorPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_printtButtonMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel formPanel;
    private javax.swing.JButton generateButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel mobiAccNoLabel;
    private javax.swing.JTextField mobiAccNoText;
    private javax.swing.JLabel mobiNameLabel;
    private javax.swing.JTextField mobiNameText;
    private javax.swing.JButton printtButton;
    private javax.swing.JTable reportTable;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JButton totalCustomerVisited;
    private javax.swing.JButton totalSalesButton;
    // End of variables declaration//GEN-END:variables
}
