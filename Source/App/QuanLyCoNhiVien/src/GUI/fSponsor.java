/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BLL.SponsorBLL;
import Utilities.ControlFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author STIREN
 */
public class fSponsor extends javax.swing.JInternalFrame {

    /**
     * Creates new form fDonor
     */
    SponsorBLL sponsorBLL =new SponsorBLL();
    ControlFormat control=new ControlFormat();
    private int flag=0;
    public fSponsor() {
        initComponents();
        control.bindingSponsor(jTableSponsor, sponsorBLL.LoadSponsor());
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
        txfSearchSponsor = new javax.swing.JTextField();
        btnSearchSponsor = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txfIDSponsor = new javax.swing.JTextField();
        txfNameSponsor = new javax.swing.JTextField();
        txfPhoneSponsor = new javax.swing.JTextField();
        txfAddressSponsor = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        btnAddSponsor = new javax.swing.JButton();
        btnEditSponsor = new javax.swing.JButton();
        btnDelSponsor = new javax.swing.JButton();
        btnSaveSponsor = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableSponsor = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();

        setClosable(true);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel1.setText("QUẢN LÝ NHÀ TÀI TRỢ");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(460, 20, 348, 37);

        jPanel1.setOpaque(false);

        txfSearchSponsor.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        btnSearchSponsor.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSearchSponsor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/search.png"))); // NOI18N
        btnSearchSponsor.setText("TÌM KIẾM");
        btnSearchSponsor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchSponsorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(87, Short.MAX_VALUE)
                .addComponent(txfSearchSponsor, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSearchSponsor)
                .addGap(28, 28, 28))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txfSearchSponsor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearchSponsor))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 81, 501, 60);

        jPanel2.setOpaque(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Mã nhà tài trợ");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Tên nhà tài trợ");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Số điện thoại");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Địa chỉ");

        txfIDSponsor.setEditable(false);
        txfIDSponsor.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        txfNameSponsor.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        txfPhoneSponsor.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        txfAddressSponsor.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txfIDSponsor, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
                    .addComponent(txfNameSponsor)
                    .addComponent(txfPhoneSponsor)
                    .addComponent(txfAddressSponsor))
                .addGap(19, 19, 19))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txfIDSponsor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txfNameSponsor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txfPhoneSponsor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txfAddressSponsor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(10, 148, 485, 187);

        jPanel4.setOpaque(false);

        btnAddSponsor.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAddSponsor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/add.png"))); // NOI18N
        btnAddSponsor.setText("THÊM");
        btnAddSponsor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddSponsorActionPerformed(evt);
            }
        });

        btnEditSponsor.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEditSponsor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/tools.png"))); // NOI18N
        btnEditSponsor.setText("CẬP NHẬT");
        btnEditSponsor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditSponsorActionPerformed(evt);
            }
        });

        btnDelSponsor.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDelSponsor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/rubbish-bin.png"))); // NOI18N
        btnDelSponsor.setText("XÓA");
        btnDelSponsor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelSponsorActionPerformed(evt);
            }
        });

        btnSaveSponsor.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSaveSponsor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/folder.png"))); // NOI18N
        btnSaveSponsor.setText("LƯU");
        btnSaveSponsor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveSponsorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(btnAddSponsor, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditSponsor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDelSponsor, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSaveSponsor, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddSponsor)
                    .addComponent(btnEditSponsor)
                    .addComponent(btnDelSponsor)
                    .addComponent(btnSaveSponsor))
                .addContainerGap())
        );

        getContentPane().add(jPanel4);
        jPanel4.setBounds(15, 346, 540, 70);

        jTableSponsor.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableSponsor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableSponsorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableSponsor);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(561, 81, 750, 630);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/bia2.png"))); // NOI18N
        getContentPane().add(jLabel6);
        jLabel6.setBounds(0, 0, 1470, 750);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public boolean  Insert()
    {
        String name =txfNameSponsor.getText().toString();
        String phonenumber =txfPhoneSponsor.getText().toString();
        String address =txfAddressSponsor.getText().toString();
        if( name.equals("")|| phonenumber.equals("")|| address.equals(""))
        {
            JOptionPane.showMessageDialog(this, "Bạn nhập thông tin chưa đầy đủ");
            return false;
        }
        else{
            if(sponsorBLL.InsertSponsor(name, phonenumber, address))
            {
                JOptionPane.showMessageDialog(this, "Thêm thành công nhà tài trợ");
                return true;
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Thêm thất bại nhà tài trợ");
                return false;
            }
        }
    }
    public boolean Update()
    {
        int id =Integer.parseInt(txfIDSponsor.getText().toString());
        String name =txfNameSponsor.getText().toString();
        String phonenumber =txfPhoneSponsor.getText().toString();
        String address =txfAddressSponsor.getText().toString();
        if(name.equals("")||phonenumber.equals("")||address.equals(""))
        {
            JOptionPane.showMessageDialog(this, "Bạn nhập thông tin chưa đầy đủ");
            return false;
        }
        else{
            if(sponsorBLL.UpdateSponsor(id, name, phonenumber, address))
            {
                JOptionPane.showMessageDialog(this, "Cập nhật thành công nhà tài trợ");
                return true;
            }
            else{
                JOptionPane.showMessageDialog(this, "Cập nhật thất bại nhà tài trợ");
                return false;
            }
        }
    }
    public boolean Delete()
    {
        int id=Integer.parseInt(txfIDSponsor.getText().toString());
        if(sponsorBLL.DeleteSponsor(id))
        {
            JOptionPane.showMessageDialog(this, "Xóa thành công nhà tài trợ");
            return true;
        }
        else{
            JOptionPane.showMessageDialog(this, "Xóa thất bại nhà tài trợ");
            return false;
        }
    }
    public void ClearText()
    {
        txfIDSponsor.setText("");
        txfNameSponsor.setText("");
        txfPhoneSponsor.setText("");
        txfAddressSponsor.setText("");
    }
    private void btnAddSponsorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddSponsorActionPerformed
        // TODO add your handling code here:
        ClearText();
        btnAddSponsor.setEnabled(false);
        btnEditSponsor.setEnabled(false);
        btnDelSponsor.setEnabled(false);
        btnSaveSponsor.setEnabled(true);
        flag=1;
    }//GEN-LAST:event_btnAddSponsorActionPerformed
    
    private void btnEditSponsorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditSponsorActionPerformed
        // TODO add your handling code here:
        btnAddSponsor.setEnabled(false);
        btnEditSponsor.setEnabled(false);
        btnDelSponsor.setEnabled(false);
        btnSaveSponsor.setEnabled(true);
        flag=2;
    }//GEN-LAST:event_btnEditSponsorActionPerformed

    private void btnDelSponsorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelSponsorActionPerformed
        // TODO add your handling code here:
        btnAddSponsor.setEnabled(false);
        btnEditSponsor.setEnabled(false);
        btnDelSponsor.setEnabled(false);
        btnSaveSponsor.setEnabled(true);
        flag=3;
    }//GEN-LAST:event_btnDelSponsorActionPerformed

    private void btnSaveSponsorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveSponsorActionPerformed
        // TODO add your handling code here:
        if(flag==1)
        {
            if(Insert())
            {
                btnSaveSponsor.setEnabled(false);
                control.bindingSponsor(jTableSponsor, sponsorBLL.LoadSponsor());
                ClearText();
            }
            btnAddSponsor.setEnabled(true);
            btnEditSponsor.setEnabled(true);
            btnDelSponsor.setEnabled(true);
            
        }
        if(flag==2)
        {
            if(Update())
            {
                 btnSaveSponsor.setEnabled(false);
                control.bindingSponsor(jTableSponsor, sponsorBLL.LoadSponsor());
                ClearText();
            }
            btnAddSponsor.setEnabled(true);
            btnEditSponsor.setEnabled(true);
            btnDelSponsor.setEnabled(true);
        }
         if(flag==3)
        {
            if(Delete())
            {
                 btnSaveSponsor.setEnabled(false);
                control.bindingSponsor(jTableSponsor, sponsorBLL.LoadSponsor());
                ClearText();
            }
            btnAddSponsor.setEnabled(true);
            btnEditSponsor.setEnabled(true);
            btnDelSponsor.setEnabled(true);
        }
    }//GEN-LAST:event_btnSaveSponsorActionPerformed

    private void btnSearchSponsorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchSponsorActionPerformed
        // TODO add your handling code here:
        String key =txfSearchSponsor.getText().toString();
        control.bindingSponsor(jTableSponsor, sponsorBLL.SearchSponsor(key));
        txfSearchSponsor.setText("");
    }//GEN-LAST:event_btnSearchSponsorActionPerformed

    private void jTableSponsorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableSponsorMouseClicked
        // TODO add your handling code here:
        int row=jTableSponsor.getSelectedRow();
        txfIDSponsor.setText(jTableSponsor.getValueAt(row, 0).toString());
        txfNameSponsor.setText(jTableSponsor.getValueAt(row, 1).toString());
        txfPhoneSponsor.setText(jTableSponsor.getValueAt(row, 2).toString());
        txfAddressSponsor.setText(jTableSponsor.getValueAt(row, 3).toString());
    }//GEN-LAST:event_jTableSponsorMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddSponsor;
    private javax.swing.JButton btnDelSponsor;
    private javax.swing.JButton btnEditSponsor;
    private javax.swing.JButton btnSaveSponsor;
    private javax.swing.JButton btnSearchSponsor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableSponsor;
    private javax.swing.JTextField txfAddressSponsor;
    private javax.swing.JTextField txfIDSponsor;
    private javax.swing.JTextField txfNameSponsor;
    private javax.swing.JTextField txfPhoneSponsor;
    private javax.swing.JTextField txfSearchSponsor;
    // End of variables declaration//GEN-END:variables
}
