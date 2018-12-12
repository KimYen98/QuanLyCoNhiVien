/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BLL.AdoptInfoBLL;
import BLL.AdoptiveParentBLL;
import BLL.ChildBLL;
import Entity.AdoptInfo;
import Entity.AdoptiveParent;
import Entity.Child;
import Utilities.ControlFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author STIREN
 */
public class fAdoptInfo extends javax.swing.JInternalFrame {

    /**
     * Creates new form fAdoptInfo
     */
    private int flag=0;
    AdoptInfoBLL adoptInfoBLL =new AdoptInfoBLL();
    ControlFormat control =new ControlFormat();
    ChildBLL childBLL =new ChildBLL();
    AdoptiveParentBLL adoptiveParentBLL=new AdoptiveParentBLL();
    ChildBLL childBLL1=new ChildBLL();
    public fAdoptInfo() {
        initComponents();
        control.bindingAdoptInfo(jTableAdoptInfo, adoptInfoBLL.LoadAdoptInfo());
        control.bindingAdoptiveParent(jTableAPa, adoptiveParentBLL.LoadAdoptiveParent());
        control.bindingChild(jTableChild,childBLL.LoadChildNow());
        jDChAdoptDate.setDate(new Date());
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
        txfSearchAdoptInfo = new javax.swing.JTextField();
        btnSearchAdoptInfo = new javax.swing.JButton();
        cbSearchAdoptInfo = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jDChAdoptDate = new com.toedter.calendar.JDateChooser();
        txfNameAdoptiveParent = new javax.swing.JTextField();
        txfNameChild = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableAdoptInfo = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        btnAddAdoptInfo = new javax.swing.JButton();
        btnEditAdoptInfo = new javax.swing.JButton();
        btnDelAdoptInfo = new javax.swing.JButton();
        btnSaveAdoptInfo = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableAPa = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableChild = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        txfSearchAPa = new javax.swing.JTextField();
        btnSearchAPa = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        txfSearchChild = new javax.swing.JTextField();
        btnSearchChild = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setClosable(true);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel1.setText("QUẢN LÝ VIỆC NHẬN NUÔI TRẺ");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(420, 30, 475, 37);

        jPanel1.setOpaque(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Tìm theo tên của:");

        txfSearchAdoptInfo.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        btnSearchAdoptInfo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSearchAdoptInfo.setText("TÌM KIẾM");
        btnSearchAdoptInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchAdoptInfoActionPerformed(evt);
            }
        });

        cbSearchAdoptInfo.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        cbSearchAdoptInfo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Trẻ", "Người nhận nuôi", " " }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txfSearchAdoptInfo)
                    .addComponent(cbSearchAdoptInfo, 0, 205, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(btnSearchAdoptInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbSearchAdoptInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSearchAdoptInfo)
                    .addComponent(txfSearchAdoptInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(21, 130, 540, 120);

        jPanel2.setOpaque(false);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Tên người nhận nuôi");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Tên trẻ");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Ngày nhận");

        jDChAdoptDate.setDateFormatString("dd-MM-yyyy");
        jDChAdoptDate.setFocusable(false);
        jDChAdoptDate.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        txfNameAdoptiveParent.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        txfNameChild.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jDChAdoptDate, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
                    .addComponent(txfNameAdoptiveParent)
                    .addComponent(txfNameChild))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txfNameAdoptiveParent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txfNameChild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDChAdoptDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(20, 250, 539, 160);

        jTableAdoptInfo.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableAdoptInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableAdoptInfoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableAdoptInfo);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(578, 422, 770, 270);

        jPanel4.setOpaque(false);

        btnAddAdoptInfo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAddAdoptInfo.setText("THÊM");
        btnAddAdoptInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddAdoptInfoActionPerformed(evt);
            }
        });

        btnEditAdoptInfo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEditAdoptInfo.setText("CẬP NHẬT");
        btnEditAdoptInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditAdoptInfoActionPerformed(evt);
            }
        });

        btnDelAdoptInfo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDelAdoptInfo.setText("XÓA");
        btnDelAdoptInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelAdoptInfoActionPerformed(evt);
            }
        });

        btnSaveAdoptInfo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSaveAdoptInfo.setText("LƯU");
        btnSaveAdoptInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveAdoptInfoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAddAdoptInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btnEditAdoptInfo)
                .addGap(26, 26, 26)
                .addComponent(btnDelAdoptInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btnSaveAdoptInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddAdoptInfo)
                    .addComponent(btnEditAdoptInfo)
                    .addComponent(btnDelAdoptInfo)
                    .addComponent(btnSaveAdoptInfo))
                .addContainerGap())
        );

        getContentPane().add(jPanel4);
        jPanel4.setBounds(90, 430, 480, 47);

        jTableAPa.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableAPa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableAPaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableAPa);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(580, 160, 390, 240);

        jTableChild.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jTableChild.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableChild.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTableChild.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableChildMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTableChild);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(980, 160, 360, 240);

        jPanel3.setOpaque(false);

        txfSearchAPa.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        btnSearchAPa.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSearchAPa.setText("TÌM KIẾM");
        btnSearchAPa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchAPaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txfSearchAPa, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSearchAPa)
                .addGap(19, 19, 19))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txfSearchAPa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearchAPa))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3);
        jPanel3.setBounds(570, 100, 351, 47);

        jPanel5.setOpaque(false);

        txfSearchChild.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        btnSearchChild.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSearchChild.setText("TÌM KIẾM");
        btnSearchChild.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchChildActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txfSearchChild, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSearchChild)
                .addContainerGap(51, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txfSearchChild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearchChild))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel5);
        jPanel5.setBounds(970, 90, 411, 58);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/bia2.png"))); // NOI18N
        getContentPane().add(jLabel7);
        jLabel7.setBounds(0, 0, 1370, 730);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void ClearText()
    {
       txfNameAdoptiveParent.setText("");
       txfNameChild.setText("");
       jDChAdoptDate.setDate(new Date());
    }
    public boolean  Insert()
    {
        String nameadopt =txfNameAdoptiveParent.getText().toString();
        int idadopt =adoptiveParentBLL.getID(nameadopt);
        String namechild =txfNameChild.getText().toString();
        int idchild=childBLL.getID(namechild);
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        java.sql.Date  adoptdate=new java.sql.Date( jDChAdoptDate.getDate().getTime());
        if(nameadopt.equals("")|| namechild.equals("") ||adoptdate.equals(null))
        {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập thông tin đầy đủ");
            return false;
        }
        else
        {
            if(adoptInfoBLL.InsertAdoptInfo(idadopt, idchild, adoptdate))
            {
                JOptionPane.showMessageDialog(this, "Thêm thành công chi tiết nhận trẻ");
                return true;
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Thêm thất bại chi tiết nhận trẻ");
                return false;
            }
        }
    }
    public boolean  Update()
    {
        String nameadopt =txfNameAdoptiveParent.getText().toString();
        int idadopt =adoptiveParentBLL.getID(nameadopt);
        String namechild =txfNameChild.getText().toString();
        int idchild=childBLL.getID(namechild);
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        java.sql.Date  adoptdate=new java.sql.Date( jDChAdoptDate.getDate().getTime());
        if(nameadopt.equals("")|| namechild.equals("") ||adoptdate.equals(null))
        {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập thông tin đầy đủ");
            return false;
        }
        else
        {
            if(adoptInfoBLL.UpdateAdoptInfo(idadopt, idchild, adoptdate))
            {
                JOptionPane.showMessageDialog(this, "Cập nhật thành công chi tiết nhận trẻ");
                return true;
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Cập nhật thất bại chi tiết nhận trẻ");
                return false;
            }
        }
    }
    public boolean Delete()
    {
        String nameadopt =txfNameAdoptiveParent.getText().toString();
        int idadopt =adoptiveParentBLL.getID(nameadopt);
        String namechild =txfNameChild.getText().toString();
        int idchild=childBLL.getID(namechild);
        if(adoptInfoBLL.DeleteAdoptInfo(idadopt, idchild))
            {
                JOptionPane.showMessageDialog(this, "Xóa thành công chi tiết nhận trẻ");
                return true;
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Xóa thất bại chi tiết nhận trẻ");
                return false;
            }
    }
    private void btnAddAdoptInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddAdoptInfoActionPerformed
        // TODO add your handling code here:
        ClearText();
        btnAddAdoptInfo.setEnabled(false);
        btnEditAdoptInfo.setEnabled(false);
        btnDelAdoptInfo.setEnabled(false);
        btnSaveAdoptInfo.setEnabled(true);
        flag=1;
    }//GEN-LAST:event_btnAddAdoptInfoActionPerformed

    private void btnEditAdoptInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditAdoptInfoActionPerformed
        // TODO add your handling code here:
        btnAddAdoptInfo.setEnabled(false);
        btnEditAdoptInfo.setEnabled(false);
        btnDelAdoptInfo.setEnabled(false);
        btnSaveAdoptInfo.setEnabled(true);
        flag=2;
    }//GEN-LAST:event_btnEditAdoptInfoActionPerformed

    private void btnDelAdoptInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelAdoptInfoActionPerformed
        // TODO add your handling code here:
        btnAddAdoptInfo.setEnabled(false);
        btnEditAdoptInfo.setEnabled(false);
        btnDelAdoptInfo.setEnabled(false);
        btnSaveAdoptInfo.setEnabled(true);
        flag=3;
    }//GEN-LAST:event_btnDelAdoptInfoActionPerformed

    private void btnSaveAdoptInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveAdoptInfoActionPerformed
        // TODO add your handling code here:
        if(flag==1)
        {
            if(Insert())
            {
                control.bindingAdoptInfo(jTableAdoptInfo, adoptInfoBLL.LoadAdoptInfo());
                ClearText();
                btnSaveAdoptInfo.setEnabled(false);
            }
            btnEditAdoptInfo.setEnabled(true);
            btnAddAdoptInfo.setEnabled(true);
            btnDelAdoptInfo.setEnabled(true);
        }
        if(flag==2)
        {
            if(Update())
            {
                control.bindingAdoptInfo(jTableAdoptInfo, adoptInfoBLL.LoadAdoptInfo());
                ClearText();
                btnSaveAdoptInfo.setEnabled(false);
            }
            btnEditAdoptInfo.setEnabled(true);
            btnAddAdoptInfo.setEnabled(true);
            btnDelAdoptInfo.setEnabled(true);
        }
        if(flag==3)
        {
            if(Delete())
            {
                control.bindingAdoptInfo(jTableAdoptInfo, adoptInfoBLL.LoadAdoptInfo());
                ClearText();
                btnSaveAdoptInfo.setEnabled(false);
            }
            btnEditAdoptInfo.setEnabled(true);
            btnAddAdoptInfo.setEnabled(true);
            btnDelAdoptInfo.setEnabled(true);
        }
    }//GEN-LAST:event_btnSaveAdoptInfoActionPerformed

    private void btnSearchAdoptInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchAdoptInfoActionPerformed
        // TODO add your handling code here:
        String key =txfSearchAdoptInfo.getText().toString();
        if(cbSearchAdoptInfo.getSelectedItem().toString().equals("Trẻ"))
        {
            control.bindingAdoptInfo(jTableAdoptInfo, adoptInfoBLL.SearchAdoptInfo_Child(key));
        }
        if(cbSearchAdoptInfo.getSelectedItem().equals("Người nhận nuôi"))
        {
            control.bindingAdoptInfo(jTableAdoptInfo, adoptInfoBLL.SearchAdoptInfo_Adopt(key));
        }
        txfSearchAdoptInfo.setText("");
        cbSearchAdoptInfo.setSelectedIndex(0);
    }//GEN-LAST:event_btnSearchAdoptInfoActionPerformed

    private void jTableAdoptInfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableAdoptInfoMouseClicked
        // TODO add your handling code here:
        int row =jTableAdoptInfo.getSelectedRow();
        txfNameAdoptiveParent.setText(jTableAdoptInfo.getValueAt(row, 0).toString());
        txfNameChild.setText(jTableAdoptInfo.getValueAt(row, 1).toString());
        jDChAdoptDate.setDate((Date)jTableAdoptInfo.getModel().getValueAt(row, 2));
        
    }//GEN-LAST:event_jTableAdoptInfoMouseClicked

    private void jTableAPaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableAPaMouseClicked
        // TODO add your handling code here:
        int row =jTableAPa.getSelectedRow();
        txfNameAdoptiveParent.setText(jTableAPa.getValueAt(row, 1).toString());
    }//GEN-LAST:event_jTableAPaMouseClicked

    private void jTableChildMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableChildMouseClicked
        // TODO add your handling code here:
        int row= jTableChild.getSelectedRow();
        txfNameChild.setText(jTableChild.getValueAt(row, 1).toString());
    }//GEN-LAST:event_jTableChildMouseClicked

    private void btnSearchAPaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchAPaActionPerformed
        // TODO add your handling code here:
        String key =txfSearchAPa.getText().toString();
        control.bindingAdoptiveParent(jTableAPa, adoptiveParentBLL.SearchAdoptiveParent(key));
        txfSearchAPa.setText("");
    }//GEN-LAST:event_btnSearchAPaActionPerformed

    private void btnSearchChildActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchChildActionPerformed
        // TODO add your handling code here:
        String key =txfSearchChild.getText().toString();
        control.bindingChild(jTableChild, childBLL.SearchChildNow(key));
        txfSearchChild.setText("");
    }//GEN-LAST:event_btnSearchChildActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddAdoptInfo;
    private javax.swing.JButton btnDelAdoptInfo;
    private javax.swing.JButton btnEditAdoptInfo;
    private javax.swing.JButton btnSaveAdoptInfo;
    private javax.swing.JButton btnSearchAPa;
    private javax.swing.JButton btnSearchAdoptInfo;
    private javax.swing.JButton btnSearchChild;
    private javax.swing.JComboBox<String> cbSearchAdoptInfo;
    private com.toedter.calendar.JDateChooser jDChAdoptDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTableAPa;
    private javax.swing.JTable jTableAdoptInfo;
    private javax.swing.JTable jTableChild;
    private javax.swing.JTextField txfNameAdoptiveParent;
    private javax.swing.JTextField txfNameChild;
    private javax.swing.JTextField txfSearchAPa;
    private javax.swing.JTextField txfSearchAdoptInfo;
    private javax.swing.JTextField txfSearchChild;
    // End of variables declaration//GEN-END:variables
}
