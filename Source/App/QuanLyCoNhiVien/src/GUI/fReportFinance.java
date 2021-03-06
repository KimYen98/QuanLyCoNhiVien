/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BLL.ExpenseBLL;
import BLL.SponsorshipBLL;
import java.awt.print.PrinterException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author STIREN
 */
public class fReportFinance extends javax.swing.JInternalFrame {

    /**
     * Creates new form fReportFinance
     */
    ExpenseBLL expenseBLL = new ExpenseBLL();
    SponsorshipBLL sponsorshipBLL = new SponsorshipBLL();
    
    public fReportFinance() {
        initComponents();
        jDChFromDateRPFinance.setDate(new Date());
        jDChToDateRPFinance.setDate(new Date());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jDChFromDateRPFinance = new com.toedter.calendar.JDateChooser();
        jDChToDateRPFinance = new com.toedter.calendar.JDateChooser();
        btnRPFinance = new javax.swing.JButton();
        btnPrintRPFinance = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaRPFinance = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();

        setClosable(true);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel1.setText("BÁO CÁO TÌNH HÌNH TÀI CHÍNH");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(254, 29, 495, 37);

        jPanel1.setOpaque(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Thời gian thống kê");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Từ ngày");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Đến ngày");

        jDChFromDateRPFinance.setDateFormatString("dd-MM-yyyy");
        jDChFromDateRPFinance.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        jDChToDateRPFinance.setDateFormatString("dd-MM-yyyy");
        jDChToDateRPFinance.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jDChFromDateRPFinance, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jDChToDateRPFinance, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE))))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3))
                    .addComponent(jDChFromDateRPFinance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jDChToDateRPFinance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(130, 90, 331, 131);

        btnRPFinance.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnRPFinance.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/rpDoanhThu.png"))); // NOI18N
        btnRPFinance.setText("THỐNG KÊ");
        btnRPFinance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRPFinanceActionPerformed(evt);
            }
        });
        getContentPane().add(btnRPFinance);
        btnRPFinance.setBounds(510, 130, 150, 41);

        btnPrintRPFinance.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnPrintRPFinance.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/print.png"))); // NOI18N
        btnPrintRPFinance.setText("IN BÁO CÁO");
        btnPrintRPFinance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintRPFinanceActionPerformed(evt);
            }
        });
        getContentPane().add(btnPrintRPFinance);
        btnPrintRPFinance.setBounds(700, 130, 157, 40);

        txaRPFinance.setEditable(false);
        txaRPFinance.setColumns(20);
        txaRPFinance.setRows(5);
        jScrollPane1.setViewportView(txaRPFinance);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(140, 220, 1080, 470);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/bia2.png"))); // NOI18N
        getContentPane().add(jLabel5);
        jLabel5.setBounds(0, 0, 1490, 760);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    private void btnRPFinanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRPFinanceActionPerformed
        // TODO add your handling code here:
        String FromDate, ToDate;
        if(jDChFromDateRPFinance.getDate() == null)
            FromDate = "";
        else
            FromDate = formatter.format(jDChFromDateRPFinance.getDate());
        if(jDChToDateRPFinance.getDate() == null)
            ToDate = "";
        else
        ToDate = formatter.format(jDChToDateRPFinance.getDate());
        
        Date Today = new Date();
        
        txaRPFinance.setText("");
        txaRPFinance.append("\t\t CÔ NHI VIỆN HƯỚNG DƯƠNG\n\n");
        txaRPFinance.append("Địa chỉ: 184 Phan Văn Khỏe, Phường 5, Quận 1, TP Hồ Chí Minh\n");
        txaRPFinance.append("Số điện thoại: (08) 3821 0199\n\n");
        txaRPFinance.append("\t\t BÁO CÁO TÀI CHÍNH\n");
        txaRPFinance.append("\t\t (Từ ngày " + FromDate + " đến ngày " + ToDate + ")\n\n");
        txaRPFinance.append("Ngày lập báo cáo: " + formatter.format(Today) + "\n\n");
        txaRPFinance.append("Tổng số tiền tài trợ: " + sponsorshipBLL.getTotalSponsorship(FromDate, ToDate) + "\n");
        txaRPFinance.append("Tổng số tiền chi tiêu: " + expenseBLL.getTotalExpense(FromDate, ToDate) + "\n");
        txaRPFinance.append("Tổng tiền quỹ hiện tại: " + expenseBLL.getFund());
    }//GEN-LAST:event_btnRPFinanceActionPerformed

    private void btnPrintRPFinanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintRPFinanceActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            txaRPFinance.print();
        } catch (PrinterException ex) {
            Logger.getLogger(fReportFinance.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnPrintRPFinanceActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPrintRPFinance;
    private javax.swing.JButton btnRPFinance;
    private com.toedter.calendar.JDateChooser jDChFromDateRPFinance;
    private com.toedter.calendar.JDateChooser jDChToDateRPFinance;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txaRPFinance;
    // End of variables declaration//GEN-END:variables
}
