/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BLL.ChildBLL;
import Utilities.ControlFormat;
import java.awt.print.PrinterException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author STIREN
 */
public class fReportNumOfChild extends javax.swing.JInternalFrame {

    /**
     * Creates new form fReportNumOfChild
     */
    ControlFormat control = new ControlFormat();
    ChildBLL childBLL = new ChildBLL();
    
    public fReportNumOfChild() {
        initComponents();
        Load();
    }

    public void Load()
    {
        cbFromAge.removeAllItems();
        cbFromAge.addItem("Tất cả");
        for(int i=1; i <= 20; i++)
            cbFromAge.addItem(String.valueOf(i));
        cbToAge.removeAllItems();
        cbToAge.addItem("Tất cả");
        for(int i=1; i <= 20; i++)
            cbToAge.addItem(String.valueOf(i));
        jDChFromDateAdoptedChild.setDate(new Date());
        jDChToDateAdoptedChild.setDate(new Date());
        jDChFromDateNewChild.setDate(new Date());
        jDChToDateNewChild.setDate(new Date());
        
        btnPrintRPNewChild.setEnabled(false);
        btnPrintRPAdoptedChild.setEnabled(false);
        btnPrintRPNumOfChild.setEnabled(false);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jDChFromDateAdoptedChild = new com.toedter.calendar.JDateChooser();
        jDChToDateAdoptedChild = new com.toedter.calendar.JDateChooser();
        btnRPAdoptedChild = new javax.swing.JButton();
        btnPrintRPAdoptedChild = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableAdoptedChild = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        txaRPAdoptedChild = new javax.swing.JTextArea();
        jLabel14 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        cbFromAge = new javax.swing.JComboBox<>();
        cbToAge = new javax.swing.JComboBox<>();
        btnRPNumOfChild = new javax.swing.JButton();
        btnPrintRPNumOfChild = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTableNumOfChild = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        txaRPNumOfChild = new javax.swing.JTextArea();
        jLabel15 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jDChFromDateNewChild = new com.toedter.calendar.JDateChooser();
        jDChToDateNewChild = new com.toedter.calendar.JDateChooser();
        btnRPNewChild = new javax.swing.JButton();
        btnPrintRPNewChild = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        txaPRNewChild = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableNewChild = new javax.swing.JTable();
        jLabel16 = new javax.swing.JLabel();

        setClosable(true);

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        jPanel2.setLayout(null);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel9.setText("DANH SÁCH TRẺ ĐƯỢC NHẬN NUÔI");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(423, 38, 541, 37);

        jPanel5.setOpaque(false);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Thời gian thống kê");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Từ ngày");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Đến ngày");

        jDChFromDateAdoptedChild.setDateFormatString("dd-MM-yyyy");
        jDChFromDateAdoptedChild.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        jDChToDateAdoptedChild.setDateFormatString("dd-MM-yyyy");
        jDChToDateAdoptedChild.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jDChFromDateAdoptedChild, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jDChToDateAdoptedChild, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE))))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7))
                    .addComponent(jDChFromDateAdoptedChild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(jDChToDateAdoptedChild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel5);
        jPanel5.setBounds(10, 86, 331, 131);

        btnRPAdoptedChild.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnRPAdoptedChild.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/rpwahouse.png"))); // NOI18N
        btnRPAdoptedChild.setText("THỐNG KÊ");
        btnRPAdoptedChild.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRPAdoptedChildActionPerformed(evt);
            }
        });
        jPanel2.add(btnRPAdoptedChild);
        btnRPAdoptedChild.setBounds(420, 100, 160, 41);

        btnPrintRPAdoptedChild.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnPrintRPAdoptedChild.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/print.png"))); // NOI18N
        btnPrintRPAdoptedChild.setText("IN BÁO CÁO");
        btnPrintRPAdoptedChild.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintRPAdoptedChildActionPerformed(evt);
            }
        });
        jPanel2.add(btnPrintRPAdoptedChild);
        btnPrintRPAdoptedChild.setBounds(420, 150, 160, 41);

        jTableAdoptedChild.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTableAdoptedChild);

        jPanel2.add(jScrollPane2);
        jScrollPane2.setBounds(80, 200, 1085, 350);

        txaRPAdoptedChild.setColumns(20);
        txaRPAdoptedChild.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        txaRPAdoptedChild.setRows(5);
        jScrollPane4.setViewportView(txaRPAdoptedChild);

        jPanel2.add(jScrollPane4);
        jScrollPane4.setBounds(979, 86, 49, 39);

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/bia2.png"))); // NOI18N
        jPanel2.add(jLabel14);
        jLabel14.setBounds(0, 0, 1470, 720);

        jTabbedPane1.addTab("Trẻ được nhận nuôi", jPanel2);

        jPanel3.setLayout(null);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel10.setText("DANH SÁCH TRẺ ĐANG Ở CÔ NHI VIỆN");
        jPanel3.add(jLabel10);
        jLabel10.setBounds(426, 42, 588, 37);

        jPanel6.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Độ tuổi");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Từ");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Đến");

        cbFromAge.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        cbFromAge.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbToAge.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        cbToAge.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbFromAge, 0, 113, Short.MAX_VALUE)
                            .addComponent(cbToAge, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbToAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(cbFromAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel12)))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel6);
        jPanel6.setBounds(221, 102, 238, 112);

        btnRPNumOfChild.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnRPNumOfChild.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/rpwahouse.png"))); // NOI18N
        btnRPNumOfChild.setText("THỐNG KÊ");
        btnRPNumOfChild.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRPNumOfChildActionPerformed(evt);
            }
        });
        jPanel3.add(btnRPNumOfChild);
        btnRPNumOfChild.setBounds(558, 113, 150, 41);

        btnPrintRPNumOfChild.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnPrintRPNumOfChild.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/print.png"))); // NOI18N
        btnPrintRPNumOfChild.setText("IN BÁO CÁO");
        btnPrintRPNumOfChild.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintRPNumOfChildActionPerformed(evt);
            }
        });
        jPanel3.add(btnPrintRPNumOfChild);
        btnPrintRPNumOfChild.setBounds(554, 172, 160, 41);

        jTableNumOfChild.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane5.setViewportView(jTableNumOfChild);

        jPanel3.add(jScrollPane5);
        jScrollPane5.setBounds(60, 230, 1120, 420);

        txaRPNumOfChild.setColumns(20);
        txaRPNumOfChild.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        txaRPNumOfChild.setRows(5);
        jScrollPane6.setViewportView(txaRPNumOfChild);

        jPanel3.add(jScrollPane6);
        jScrollPane6.setBounds(1177, 102, 57, 29);

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/bia2.png"))); // NOI18N
        jPanel3.add(jLabel15);
        jLabel15.setBounds(0, 0, 1430, 740);

        jTabbedPane1.addTab("Trẻ đang ở cô nhi viện", jPanel3);

        jPanel1.setLayout(null);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel5.setText("DANH SÁCH TRẺ THÊM MỚI");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(408, 36, 420, 37);

        jPanel4.setOpaque(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Thời gian thống kê");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Từ ngày");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Đến ngày");

        jDChFromDateNewChild.setDateFormatString("dd-MM-yyyy");
        jDChFromDateNewChild.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        jDChToDateNewChild.setDateFormatString("dd-MM-yyyy");
        jDChToDateNewChild.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jDChFromDateNewChild, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jDChToDateNewChild, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE))))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3))
                    .addComponent(jDChFromDateNewChild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jDChToDateNewChild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel4);
        jPanel4.setBounds(10, 91, 328, 112);

        btnRPNewChild.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnRPNewChild.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/rpwahouse.png"))); // NOI18N
        btnRPNewChild.setText("THỐNG KÊ");
        btnRPNewChild.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRPNewChildActionPerformed(evt);
            }
        });
        jPanel1.add(btnRPNewChild);
        btnRPNewChild.setBounds(410, 120, 150, 40);

        btnPrintRPNewChild.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnPrintRPNewChild.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/print.png"))); // NOI18N
        btnPrintRPNewChild.setText("IN BÁO CÁO");
        btnPrintRPNewChild.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintRPNewChildActionPerformed(evt);
            }
        });
        jPanel1.add(btnPrintRPNewChild);
        btnPrintRPNewChild.setBounds(410, 170, 160, 40);

        txaPRNewChild.setColumns(20);
        txaPRNewChild.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        txaPRNewChild.setRows(5);
        jScrollPane3.setViewportView(txaPRNewChild);

        jPanel1.add(jScrollPane3);
        jScrollPane3.setBounds(1142, 36, 48, 56);

        jTableNewChild.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTableNewChild);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(70, 220, 1108, 440);

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/bia2.png"))); // NOI18N
        jPanel1.add(jLabel16);
        jLabel16.setBounds(0, 0, 1400, 670);

        jTabbedPane1.addTab("Trẻ thêm mới", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1392, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 689, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    private void btnRPNewChildActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRPNewChildActionPerformed
        // TODO add your handling code here:

        String FromDate, ToDate;
        if(jDChFromDateNewChild.getDate() == null)
        FromDate = "";
        else
        FromDate = formatter.format(jDChFromDateNewChild.getDate());
        if(jDChToDateNewChild.getDate() == null)
        ToDate = "";
        else
        ToDate = formatter.format(jDChToDateNewChild.getDate());

        control.bindingChild(jTableNewChild, childBLL.RPNewChild(FromDate, ToDate));
        if(jTableNewChild.getRowCount() > 0)
        btnPrintRPNewChild.setEnabled(true);
        else btnPrintRPNewChild.setEnabled(false);
    }//GEN-LAST:event_btnRPNewChildActionPerformed

    private void btnPrintRPNewChildActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintRPNewChildActionPerformed
        // TODO add your handling code here:
        txaPRNewChild.setText("");
        txaPRNewChild.append("\t\t\t\t\t CÔ NHI VIỆN HƯỚNG DƯƠNG\n\n");
        txaPRNewChild.append("Địa chỉ: 184 Phan Văn Khỏe, Phường 5, Quận 1, TP Hồ Chí Minh\n");
        txaPRNewChild.append("Số điện thoại: (08) 3821 0199\n\n");
        txaPRNewChild.append("\t\t\t\t\t DANH SÁCH TRẺ THÊM MỚI\n");
        txaPRNewChild.append("\t\t\t\t\t(Từ ngày " + formatter.format(jDChFromDateNewChild.getDate()) + " đến ngày " + formatter.format(jDChToDateNewChild.getDate()) + ")\n\n");
        txaPRNewChild.append("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
        txaPRNewChild.append("Mã trẻ \t Tên trẻ \t\t Ngày sinh \t Giới tính \t Ngày vào \t Hoàn cảnh \t Người đưa trẻ vào \t Trạng thái \t Tên bảo mẫu \n");
        txaPRNewChild.append("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");

        int row = jTableNewChild.getRowCount();
        int column = jTableNewChild.getColumnCount();

        for(int i=0; i < row; i++)
        {
            for(int j=0; j < column; j++)
            {
                if(j == 5)
                {
                    int end;
                    if(jTableNewChild.getValueAt(i, j).toString().length() < 10)
                    {
                        end = jTableNewChild.getValueAt(i, j).toString().length();
                        txaPRNewChild.append(jTableNewChild.getValueAt(i, j).toString().substring(0, end) + "\t");
                    }
                    else
                    {
                        end = 10;
                        txaPRNewChild.append(jTableNewChild.getValueAt(i, j).toString().substring(0, end) + "...\t");
                    }
                }
                else
                txaPRNewChild.append(jTableNewChild.getValueAt(i, j).toString() + "\t");
            }
            txaPRNewChild.append("\n");
        }
        try {
            txaPRNewChild.print();
        } catch (PrinterException ex) {
            Logger.getLogger(fReportNumOfChild.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnPrintRPNewChildActionPerformed

    private void btnRPAdoptedChildActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRPAdoptedChildActionPerformed
        // TODO add your handling code here:
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        String FromDate, ToDate;
        if(jDChFromDateAdoptedChild.getDate() == null)
        FromDate = "";
        else FromDate = formatter.format(jDChFromDateAdoptedChild.getDate());
        if(jDChToDateAdoptedChild.getDate() == null)
        ToDate = "";
        else ToDate = formatter.format(jDChToDateAdoptedChild.getDate());
        control.bindingChild(jTableAdoptedChild, childBLL.RPAdoptedChild(FromDate, ToDate));
        if(jTableAdoptedChild.getRowCount() > 0)
        btnPrintRPAdoptedChild.setEnabled(true);
        else btnPrintRPAdoptedChild.setEnabled(false);
    }//GEN-LAST:event_btnRPAdoptedChildActionPerformed

    private void btnPrintRPAdoptedChildActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintRPAdoptedChildActionPerformed
        // TODO add your handling code here:
        txaRPAdoptedChild.setText("");
        txaRPAdoptedChild.append("\t\t\t\t\t CÔ NHI VIỆN HƯỚNG DƯƠNG\n\n");
        txaRPAdoptedChild.append("Địa chỉ: 184 Phan Văn Khỏe, Phường 5, Quận 1, TP Hồ Chí Minh\n");
        txaRPAdoptedChild.append("Số điện thoại: (08) 3821 0199\n\n");
        txaRPAdoptedChild.append("\t\t\t\t\t DANH SÁCH TRẺ ĐƯỢC NHẬN NUÔI\n");
        txaRPAdoptedChild.append("\t\t\t\t\t(Từ ngày " + formatter.format(jDChFromDateAdoptedChild.getDate()) + " đến ngày " + formatter.format(jDChToDateAdoptedChild.getDate()) + ")\n\n");
        txaRPAdoptedChild.append("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
        txaRPAdoptedChild.append("Mã trẻ \t Tên trẻ \t\t Ngày sinh \t Giới tính \t Ngày vào \t Hoàn cảnh \t Người đưa trẻ vào \t Trạng thái \t Tên bảo mẫu \n");
        txaRPAdoptedChild.append("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");

        int row = jTableAdoptedChild.getRowCount();
        int column = jTableAdoptedChild.getColumnCount();

        for(int i=0; i < row; i++)
        {
            for(int j=0; j < column; j++)
            {
                if(j == 5)
                {
                    int end;
                    if(jTableAdoptedChild.getValueAt(i, j).toString().length() < 10)
                    {
                        end = jTableAdoptedChild.getValueAt(i, j).toString().length();
                        txaRPAdoptedChild.append(jTableAdoptedChild.getValueAt(i, j).toString().substring(0, end) + "\t");
                    }
                    else
                    {
                        end = 10;
                        txaRPAdoptedChild.append(jTableAdoptedChild.getValueAt(i, j).toString().substring(0, end) + "...\t");
                    }
                }
                else
                txaRPAdoptedChild.append(jTableAdoptedChild.getValueAt(i, j).toString() + "\t");
            }
            txaRPAdoptedChild.append("\n");
        }
        try {
            txaRPAdoptedChild.print();
        } catch (PrinterException ex) {
            Logger.getLogger(fReportNumOfChild.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnPrintRPAdoptedChildActionPerformed

    private void btnRPNumOfChildActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRPNumOfChildActionPerformed
        // TODO add your handling code here:
        int FromAge, ToAge;
        if(cbFromAge.getSelectedItem().equals("Tất cả"))
        FromAge = 0;
        else FromAge = Integer.parseInt(cbFromAge.getSelectedItem().toString());

        if(cbToAge.getSelectedItem().equals("Tất cả"))
        ToAge = 0;
        else ToAge = Integer.parseInt(cbToAge.getSelectedItem().toString());

        control.bindingChild(jTableNumOfChild, childBLL.RPNumOfChild(FromAge, ToAge));
        if(jTableNumOfChild.getRowCount() > 0)
        btnPrintRPNumOfChild.setEnabled(true);
        else
        btnPrintRPNumOfChild.setEnabled(false);
    }//GEN-LAST:event_btnRPNumOfChildActionPerformed

    private void btnPrintRPNumOfChildActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintRPNumOfChildActionPerformed
        // TODO add your handling code here:
        txaRPNumOfChild.setText("");
        txaRPNumOfChild.append("\t\t\t\t\t CÔ NHI VIỆN HƯỚNG DƯƠNG\n\n");
        txaRPNumOfChild.append("Địa chỉ: 184 Phan Văn Khỏe, Phường 5, Quận 1, TP Hồ Chí Minh\n");
        txaRPNumOfChild.append("Số điện thoại: (08) 3821 0199\n\n");
        txaRPNumOfChild.append("\t\t\t\t\t DANH SÁCH TRẺ ĐANG Ở CÔ NHI VIỆN\n\n");
        txaRPNumOfChild.append("Số lượng nam: " + childBLL.getNumOfMaleChild() + "\n");
        txaRPNumOfChild.append("Số lượng nữ: " + childBLL.getNumOfFemaleChild() + "\n\n");
        txaRPNumOfChild.append("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
        txaRPNumOfChild.append("Mã trẻ \t Tên trẻ \t\t Ngày sinh \t Giới tính \t Ngày vào \t Hoàn cảnh \t Người đưa trẻ vào \t Trạng thái \t Tên bảo mẫu \n");
        txaRPNumOfChild.append("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");

        int row = jTableNumOfChild.getRowCount();
        int column = jTableNumOfChild.getColumnCount();

        for(int i=0; i < row; i++)
        {
            for(int j=0; j < column; j++)
            {
                if(j == 5)
                {
                    int end;
                    if(jTableNumOfChild.getValueAt(i, j).toString().length() < 10)
                    {
                        end = jTableNumOfChild.getValueAt(i, j).toString().length();
                        txaRPNumOfChild.append(jTableNumOfChild.getValueAt(i, j).toString().substring(0, end) + "\t");
                    }
                    else
                    {
                        end = 10;
                        txaRPNumOfChild.append(jTableNumOfChild.getValueAt(i, j).toString().substring(0, end) + "...\t");
                    }
                }
                else
                txaRPNumOfChild.append(jTableNumOfChild.getValueAt(i, j).toString() + "\t");
            }
            txaRPNumOfChild.append("\n");
        }
        try {
            txaRPNumOfChild.print();
        } catch (PrinterException ex) {
            Logger.getLogger(fReportNumOfChild.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnPrintRPNumOfChildActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPrintRPAdoptedChild;
    private javax.swing.JButton btnPrintRPNewChild;
    private javax.swing.JButton btnPrintRPNumOfChild;
    private javax.swing.JButton btnRPAdoptedChild;
    private javax.swing.JButton btnRPNewChild;
    private javax.swing.JButton btnRPNumOfChild;
    private javax.swing.JComboBox<String> cbFromAge;
    private javax.swing.JComboBox<String> cbToAge;
    private com.toedter.calendar.JDateChooser jDChFromDateAdoptedChild;
    private com.toedter.calendar.JDateChooser jDChFromDateNewChild;
    private com.toedter.calendar.JDateChooser jDChToDateAdoptedChild;
    private com.toedter.calendar.JDateChooser jDChToDateNewChild;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTableAdoptedChild;
    private javax.swing.JTable jTableNewChild;
    private javax.swing.JTable jTableNumOfChild;
    private javax.swing.JTextArea txaPRNewChild;
    private javax.swing.JTextArea txaRPAdoptedChild;
    private javax.swing.JTextArea txaRPNumOfChild;
    // End of variables declaration//GEN-END:variables
}
