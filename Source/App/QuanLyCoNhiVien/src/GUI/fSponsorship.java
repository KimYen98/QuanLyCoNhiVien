/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BLL.SponsorBLL;
import BLL.SponsorshipBLL;
import Entity.Sponsor;
import Entity.Sponsorship;
import Utilities.ControlFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author STIREN
 */
public class fSponsorship extends javax.swing.JInternalFrame {

    /**
     * Creates new form fSponsorship
     */
    SponsorBLL sponsorBLL =new SponsorBLL();
    SponsorshipBLL sponsorshipBLL=new SponsorshipBLL();
    ControlFormat control =new ControlFormat();
    private int flag=0;
    public fSponsorship() {
        initComponents();
        cbNameSponsorSponsorship.removeAllItems();
        control.bindingSponsorship(jTableSponsorship, sponsorshipBLL.LoadSponsorship());
        for(Sponsor sponsor: sponsorBLL.LoadSponsor())
        {
            cbNameSponsorSponsorship.addItem(sponsor.getName());
        }
        jDChSponsorshipDate.setDate(new Date());
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
        txfSearchSponsorship = new javax.swing.JTextField();
        btnSearchSponsorship = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txfIDSponsorship = new javax.swing.JTextField();
        cbNameSponsorSponsorship = new javax.swing.JComboBox<>();
        jDChSponsorshipDate = new com.toedter.calendar.JDateChooser();
        cbFormSponsorship = new javax.swing.JComboBox<>();
        txfMoneySponsorship = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        btnAddSponsorship = new javax.swing.JButton();
        btnEditSponsorship = new javax.swing.JButton();
        btnDelSponsorship = new javax.swing.JButton();
        btnSaveSponsorship = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableSponsorship = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();

        setClosable(true);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 153));
        jLabel1.setText("QUẢN LÝ CHƯƠNG TRÌNH TÀI TRỢ");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(268, 22, 528, 37);

        jPanel1.setOpaque(false);

        txfSearchSponsorship.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        btnSearchSponsorship.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSearchSponsorship.setForeground(new java.awt.Color(0, 0, 153));
        btnSearchSponsorship.setText("TÌM KIẾM");
        btnSearchSponsorship.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchSponsorshipActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txfSearchSponsorship, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(btnSearchSponsorship)
                .addGap(30, 30, 30))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txfSearchSponsorship, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearchSponsorship))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 82, 434, 61);

        jPanel2.setOpaque(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 153));
        jLabel2.setText("Mã tài trợ");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 153));
        jLabel3.setText("Tên nhà tài trợ");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 153));
        jLabel4.setText("Ngày tài trợ");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 153));
        jLabel5.setText("Hình thức tài trợ");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 153));
        jLabel6.setText("Số tiền tài trợ");

        txfIDSponsorship.setEditable(false);
        txfIDSponsorship.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        cbNameSponsorSponsorship.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        cbNameSponsorSponsorship.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jDChSponsorshipDate.setDateFormatString("dd-MM-yyyy");

        cbFormSponsorship.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        cbFormSponsorship.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tiền mặt", "Chuyển khoản", "Hiện vật" }));

        txfMoneySponsorship.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        txfMoneySponsorship.setText("0");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txfIDSponsorship)
                            .addComponent(cbNameSponsorSponsorship, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jDChSponsorshipDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txfMoneySponsorship)
                            .addComponent(cbFormSponsorship, 0, 411, Short.MAX_VALUE))))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txfIDSponsorship, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cbNameSponsorSponsorship, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4))
                    .addComponent(jDChSponsorshipDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbFormSponsorship, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txfMoneySponsorship, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(10, 149, 572, 234);

        jPanel4.setOpaque(false);

        btnAddSponsorship.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAddSponsorship.setForeground(new java.awt.Color(0, 0, 153));
        btnAddSponsorship.setText("THÊM");
        btnAddSponsorship.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddSponsorshipActionPerformed(evt);
            }
        });

        btnEditSponsorship.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEditSponsorship.setForeground(new java.awt.Color(0, 0, 153));
        btnEditSponsorship.setText("CẬP NHẬT");
        btnEditSponsorship.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditSponsorshipActionPerformed(evt);
            }
        });

        btnDelSponsorship.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDelSponsorship.setForeground(new java.awt.Color(0, 0, 153));
        btnDelSponsorship.setText("XÓA");
        btnDelSponsorship.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelSponsorshipActionPerformed(evt);
            }
        });

        btnSaveSponsorship.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSaveSponsorship.setForeground(new java.awt.Color(0, 0, 153));
        btnSaveSponsorship.setText("LƯU");
        btnSaveSponsorship.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveSponsorshipActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(btnAddSponsorship, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(btnEditSponsorship)
                .addGap(34, 34, 34)
                .addComponent(btnDelSponsorship, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(btnSaveSponsorship, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddSponsorship)
                    .addComponent(btnEditSponsorship)
                    .addComponent(btnDelSponsorship)
                    .addComponent(btnSaveSponsorship))
                .addContainerGap())
        );

        getContentPane().add(jPanel4);
        jPanel4.setBounds(65, 380, 520, 49);

        jTableSponsorship.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableSponsorship.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableSponsorshipMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableSponsorship);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(610, 90, 735, 620);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/bia6.jpg"))); // NOI18N
        getContentPane().add(jLabel7);
        jLabel7.setBounds(0, 0, 1490, 770);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void ClearText()
    {
        txfIDSponsorship.setText("");
        cbNameSponsorSponsorship.getItemAt(0);
        jDChSponsorshipDate.setDate(new Date());
        cbFormSponsorship.getItemAt(0);
        txfMoneySponsorship.setText("0");
    }
    public boolean Insert()
    {
        String namesponsor =cbNameSponsorSponsorship.getSelectedItem().toString();
        int idsponsor=sponsorBLL.getIdSponsor(namesponsor);
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date =jDChSponsorshipDate.getDate();
        String strdate =formatter.format(date);
        String format =cbFormSponsorship.getSelectedItem().toString();
        float money;
        if(format.equals("Tiền mặt") || format.equals("Chuyển khoản"))
            money =Float.parseFloat(txfMoneySponsorship.getText().toString());
        else
            money =0;
        if(namesponsor.equals("") || strdate.equals("") || txfMoneySponsorship.equals(""))
        {
            JOptionPane.showMessageDialog(this, "Bạn nhập thông tin chưa đầy đủ");
            return false;
        }
        else
        {
            if(sponsorshipBLL.Insert(idsponsor, strdate, format, money))
            {
                JOptionPane.showMessageDialog(this, "Thêm tài trợ thành công");
                return true;
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Thêm tài trợ thất bại");
                return false;
            }
        }
    }
    
    public boolean Update()
    {
        int id =Integer.parseInt(txfIDSponsorship.getText().toString());
        String namesponsor =cbNameSponsorSponsorship.getSelectedItem().toString();
        int idsponsor=sponsorBLL.getIdSponsor(namesponsor);
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date =jDChSponsorshipDate.getDate();
        String strdate =formatter.format(date);
        String format =cbFormSponsorship.getSelectedItem().toString();
        float money =Float.parseFloat(txfMoneySponsorship.getText().toString());
        if(namesponsor.equals("") || strdate.equals("") || txfMoneySponsorship.equals(""))
        {
            JOptionPane.showMessageDialog(this, "Bạn nhập thông tin chưa đầy đủ");
            return false;
        }
        else
        {
            if(sponsorshipBLL.Update(id, idsponsor, strdate,format, money))
            {
                JOptionPane.showMessageDialog(this, "Cập nhật tài trợ thành công");
                return true;
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Cập nhật tài trợ thất bại");
                return false;
            }
        }
    }
    public boolean Delete()
    {
        int idsponsorship=Integer.parseInt(txfIDSponsorship.getText().toString());
        String namesponsor =cbNameSponsorSponsorship.getSelectedItem().toString();
        int idsponsor=sponsorBLL.getIdSponsor(namesponsor);
        if(sponsorshipBLL.Delete(idsponsorship,idsponsor))
        {
            JOptionPane.showMessageDialog(this, "Xóa tài trợ thành công");
            return true;
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Xóa tài trợ thất bại");
            return false;
        }
    
    }
    
    private void btnAddSponsorshipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddSponsorshipActionPerformed
        // TODO add your handling code here:
        ClearText();
        btnAddSponsorship.setEnabled(false);
        btnEditSponsorship.setEnabled(false);
        btnDelSponsorship.setEnabled(false);
        btnSaveSponsorship.setEnabled(true);
        flag=1;
    }//GEN-LAST:event_btnAddSponsorshipActionPerformed

    private void btnEditSponsorshipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditSponsorshipActionPerformed
        // TODO add your handling code here:
         btnAddSponsorship.setEnabled(false);
        btnEditSponsorship.setEnabled(false);
        btnDelSponsorship.setEnabled(false);
        btnSaveSponsorship.setEnabled(true);
        flag=2;
    }//GEN-LAST:event_btnEditSponsorshipActionPerformed

    private void btnDelSponsorshipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelSponsorshipActionPerformed
        // TODO add your handling code here:
         btnAddSponsorship.setEnabled(false);
        btnEditSponsorship.setEnabled(false);
        btnDelSponsorship.setEnabled(false);
        btnSaveSponsorship.setEnabled(true);
        flag=3;
    }//GEN-LAST:event_btnDelSponsorshipActionPerformed

    private void btnSaveSponsorshipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveSponsorshipActionPerformed
        // TODO add your handling code here:
        if(flag==1)
        {
            if(Insert())
            {
                btnSaveSponsorship.setEnabled(false);
                control.bindingSponsorship(jTableSponsorship, sponsorshipBLL.LoadSponsorship());
                ClearText();
            }
            btnAddSponsorship.setEnabled(true);
            btnEditSponsorship.setEnabled(true);
            btnDelSponsorship.setEnabled(true);
        }
        if(flag==2)
        {
            if(Update())
            {
                btnSaveSponsorship.setEnabled(false);
                control.bindingSponsorship(jTableSponsorship, sponsorshipBLL.LoadSponsorship());
                ClearText();
            }
            btnAddSponsorship.setEnabled(true);
            btnEditSponsorship.setEnabled(true);
            btnDelSponsorship.setEnabled(true);
        }
        if(flag==3)
        {
            if(Delete())
            {
                btnSaveSponsorship.setEnabled(false);
                control.bindingSponsorship(jTableSponsorship, sponsorshipBLL.LoadSponsorship());
                ClearText();
            }
            btnAddSponsorship.setEnabled(true);
            btnEditSponsorship.setEnabled(true);
            btnDelSponsorship.setEnabled(true);
        }
    }//GEN-LAST:event_btnSaveSponsorshipActionPerformed

    private void btnSearchSponsorshipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchSponsorshipActionPerformed
        // TODO add your handling code here:
        String key =txfSearchSponsorship.getText().toString();
        control.bindingSponsorship(jTableSponsorship, sponsorshipBLL.SearchSponsorship(key));
        txfSearchSponsorship.setText("");
    }//GEN-LAST:event_btnSearchSponsorshipActionPerformed

    private void jTableSponsorshipMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableSponsorshipMouseClicked
        // TODO add your handling code here:
        int row=jTableSponsorship.getSelectedRow();
        txfIDSponsorship.setText(jTableSponsorship.getValueAt(row, 0).toString());
        String namesponsor=jTableSponsorship.getValueAt(row, 1).toString();
        if(jTableSponsorship.getValueAt(row, 1).toString().equals(namesponsor))
            cbNameSponsorSponsorship.setSelectedItem(namesponsor);
        jDChSponsorshipDate.setDate((Date)jTableSponsorship.getModel().getValueAt(row, 2));
        String format =jTableSponsorship.getValueAt(row, 3).toString();
        if(jTableSponsorship.getValueAt(row,3).toString().equals(format))
            cbFormSponsorship.setSelectedItem(format);
        txfMoneySponsorship.setText(jTableSponsorship.getValueAt(row, 4).toString());
        
    }//GEN-LAST:event_jTableSponsorshipMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddSponsorship;
    private javax.swing.JButton btnDelSponsorship;
    private javax.swing.JButton btnEditSponsorship;
    private javax.swing.JButton btnSaveSponsorship;
    private javax.swing.JButton btnSearchSponsorship;
    private javax.swing.JComboBox<String> cbFormSponsorship;
    private javax.swing.JComboBox<String> cbNameSponsorSponsorship;
    private com.toedter.calendar.JDateChooser jDChSponsorshipDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableSponsorship;
    private javax.swing.JTextField txfIDSponsorship;
    private javax.swing.JTextField txfMoneySponsorship;
    private javax.swing.JTextField txfSearchSponsorship;
    // End of variables declaration//GEN-END:variables
}
