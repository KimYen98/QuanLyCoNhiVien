/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BLL.AdoptiveParentBLL;
import Utilities.ControlFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author STIREN
 */
public class fAdoptiveParent extends javax.swing.JInternalFrame {

    /**
     * Creates new form fAdoptiveParent
     */
    private int flag=0;
    AdoptiveParentBLL adoptiveParentBLL =new AdoptiveParentBLL();
    ControlFormat control =new ControlFormat();
    public fAdoptiveParent() {
        initComponents();
        btnSaveAPa.setEnabled(false);
        control.bindingAdoptiveParent(jTableAPa, adoptiveParentBLL.LoadAdoptiveParent());
        txfNameAPa.setEnabled(false);
        txfAddressAPa.setEnabled(false);
        txfPhoneAPa.setEnabled(false);
        
    }
     //Hàm chuẩn hóa tên
    public String chuanHoa(String str) {
        str = str.trim();
        str = str.replaceAll("\\s+", " ");
        return str;
    }
 
    public String chuanHoaDanhTuRieng(String str) {
        str = chuanHoa(str.toLowerCase());
        String temp[] = str.split(" ");
        str = ""; // ? ^-^
        for (int i = 0; i < temp.length; i++) {
            str += String.valueOf(temp[i].charAt(0)).toUpperCase() + temp[i].substring(1);
            if (i < temp.length - 1) // ? ^-^
                str += " ";
        }
        return str;
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
        txfSearchAPa = new javax.swing.JTextField();
        btnSearchAPa = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txfIDAPa = new javax.swing.JTextField();
        txfNameAPa = new javax.swing.JTextField();
        txfAddressAPa = new javax.swing.JTextField();
        txfPhoneAPa = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        btnAddAPa = new javax.swing.JButton();
        btnEditAPa = new javax.swing.JButton();
        btnSaveAPa = new javax.swing.JButton();
        btnDeleteAPa = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableAPa = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();

        setClosable(true);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel1.setText("QUẢN LÝ NGƯỜI NHẬN NUÔI TRẺ");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(463, 33, 511, 37);

        jPanel1.setOpaque(false);

        txfSearchAPa.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        btnSearchAPa.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSearchAPa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/search.png"))); // NOI18N
        btnSearchAPa.setText("TÌM KIẾM");
        btnSearchAPa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchAPaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txfSearchAPa, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(btnSearchAPa)
                .addGap(19, 19, 19))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txfSearchAPa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearchAPa))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 113, 391, 63);

        jPanel2.setOpaque(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Mã người nhận");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Tên người nhận");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Địa chỉ");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Số điện thoại");

        txfIDAPa.setEditable(false);
        txfIDAPa.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        txfNameAPa.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        txfAddressAPa.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        txfPhoneAPa.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        txfPhoneAPa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfPhoneAPaKeyTyped(evt);
            }
        });

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
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txfIDAPa, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                    .addComponent(txfNameAPa)
                    .addComponent(txfAddressAPa)
                    .addComponent(txfPhoneAPa))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txfIDAPa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txfNameAPa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txfAddressAPa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txfPhoneAPa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(10, 178, 506, 193);

        jPanel4.setOpaque(false);

        btnAddAPa.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAddAPa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/add.png"))); // NOI18N
        btnAddAPa.setText("THÊM");
        btnAddAPa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddAPaActionPerformed(evt);
            }
        });

        btnEditAPa.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEditAPa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/tools.png"))); // NOI18N
        btnEditAPa.setText("CẬP NHẬT");
        btnEditAPa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditAPaActionPerformed(evt);
            }
        });

        btnSaveAPa.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSaveAPa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/folder.png"))); // NOI18N
        btnSaveAPa.setText("LƯU");
        btnSaveAPa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveAPaActionPerformed(evt);
            }
        });

        btnDeleteAPa.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDeleteAPa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/rubbish-bin.png"))); // NOI18N
        btnDeleteAPa.setText("XÓA");
        btnDeleteAPa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteAPaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAddAPa, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEditAPa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDeleteAPa, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(btnSaveAPa, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddAPa)
                    .addComponent(btnEditAPa)
                    .addComponent(btnSaveAPa)
                    .addComponent(btnDeleteAPa))
                .addContainerGap())
        );

        getContentPane().add(jPanel4);
        jPanel4.setBounds(20, 377, 520, 63);

        jTableAPa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
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
        jTableAPa.setAutoscrolls(false);
        jTableAPa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableAPaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableAPa);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(567, 130, 770, 570);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/bia2.png"))); // NOI18N
        getContentPane().add(jLabel6);
        jLabel6.setBounds(0, 0, 1350, 710);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void ClearText()
    {
        txfIDAPa.setText("");
        txfNameAPa.setText("");
        txfAddressAPa.setText("");
        txfPhoneAPa.setText("");
    }
    public boolean Insert()
    {
        String name=txfNameAPa.getText().toString();
        String address =txfAddressAPa.getText().toString();
        String phonenumber =txfPhoneAPa.getText().toString();
        name=chuanHoaDanhTuRieng(name);
        address=chuanHoa(address);
        if(name.equals("")|| address.equals("")||phonenumber.equals(""))
        {
            JOptionPane.showMessageDialog(this, "Bạn nhập thông tin chưa đầy đủ.");
            return false;
        }
        else
        {
            if(adoptiveParentBLL.InsertAdoptiveParent(name, address, phonenumber))
            {
                JOptionPane.showMessageDialog(this, "Thêm người nhận trẻ thành công.");
                return true;
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Thêm người nhận trẻ thất bại.");
                return false;
            }
        }
    }
    public boolean Update()
    {
        int id =Integer.parseInt(txfIDAPa.getText().toString());
        String name=txfNameAPa.getText().toString();
        String address =txfAddressAPa.getText().toString();
        String phonenumber =txfPhoneAPa.getText().toString();
         name=chuanHoaDanhTuRieng(name);
        address=chuanHoa(address);
        if(name.equals("")|| address.equals("")||phonenumber.equals(""))
        {
            JOptionPane.showMessageDialog(this, "Bạn nhập thông tin chưa đầy đủ.");
            return false;
        }
        else
        {
            if(adoptiveParentBLL.UpdateAdoptiveParent(id,name, address, phonenumber))
            {
                JOptionPane.showMessageDialog(this, "Cập nhật người nhận trẻ thành công.");
                return true;
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Cập nhật người nhận trẻ thất bại.");
                return false;
            }
        }
    }
    public boolean Delete()
    {
        int id=Integer.parseInt(txfIDAPa.getText().toString());
        if(Delete())
        {
            JOptionPane.showMessageDialog(this, "Xóa thành công người nhận trẻ");
            return true;
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Xóa thất bại người nhận trẻ");
            return false;
        }
    }
    private void btnAddAPaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddAPaActionPerformed
        // TODO add your handling code here:
        ClearText();
        btnAddAPa.setEnabled(false);
        btnEditAPa.setEnabled(false);
        btnDeleteAPa.setEnabled(false);
        btnSaveAPa.setEnabled(true);
        flag=1;
        txfNameAPa.setEnabled(true);
        txfAddressAPa.setEnabled(true);
        txfPhoneAPa.setEnabled(true);
    }//GEN-LAST:event_btnAddAPaActionPerformed

    private void btnEditAPaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditAPaActionPerformed
        // TODO add your handling code here:
         btnAddAPa.setEnabled(false);
        btnEditAPa.setEnabled(false);
        btnDeleteAPa.setEnabled(false);
        btnSaveAPa.setEnabled(true);
        flag=2;
        txfNameAPa.setEnabled(true);
        txfAddressAPa.setEnabled(true);
        txfPhoneAPa.setEnabled(true);
    }//GEN-LAST:event_btnEditAPaActionPerformed

    private void btnSaveAPaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveAPaActionPerformed
        // TODO add your handling code here:
        if(flag==1)
        {
            if(Insert())
            {
                
                control.bindingAdoptiveParent(jTableAPa, adoptiveParentBLL.LoadAdoptiveParent());
                btnSaveAPa.setEnabled(false);
                ClearText();
                txfNameAPa.setEnabled(false);
        txfAddressAPa.setEnabled(false);
        txfPhoneAPa.setEnabled(false);
            }
            btnAddAPa.setEnabled(true);
            btnEditAPa.setEnabled(true);
            btnDeleteAPa.setEnabled(true);
        }
        if(flag==2)
        {
            if(Update())
            {
                control.bindingAdoptiveParent(jTableAPa, adoptiveParentBLL.LoadAdoptiveParent());
                btnSaveAPa.setEnabled(false);
                txfNameAPa.setEnabled(false);
        txfAddressAPa.setEnabled(false);
        txfPhoneAPa.setEnabled(false);
            }
            btnAddAPa.setEnabled(true);
            btnEditAPa.setEnabled(true);
        btnDeleteAPa.setEnabled(true);
        }
        if(flag==3)
        {
            if(Delete())
            {
                control.bindingAdoptiveParent(jTableAPa, adoptiveParentBLL.LoadAdoptiveParent());
                btnSaveAPa.setEnabled(false);
                txfNameAPa.setEnabled(false);
        txfAddressAPa.setEnabled(false);
        txfPhoneAPa.setEnabled(false);
            }
            btnAddAPa.setEnabled(true);
            btnEditAPa.setEnabled(true);
            btnDeleteAPa.setEnabled(true);
        }
    }//GEN-LAST:event_btnSaveAPaActionPerformed

    private void btnSearchAPaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchAPaActionPerformed
        // TODO add your handling code here:
        String key =txfSearchAPa.getText().toString();
        control.bindingAdoptiveParent(jTableAPa, adoptiveParentBLL.SearchAdoptiveParent(key));
        txfSearchAPa.setText("");
    }//GEN-LAST:event_btnSearchAPaActionPerformed

    private void jTableAPaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableAPaMouseClicked
        // TODO add your handling code here:
        int row =jTableAPa.getSelectedRow();
        txfIDAPa.setText(jTableAPa.getValueAt(row, 0).toString());
        txfNameAPa.setText(jTableAPa.getValueAt(row, 1).toString());
        txfAddressAPa.setText(jTableAPa.getValueAt(row, 2).toString());
        txfPhoneAPa.setText(jTableAPa.getValueAt(row, 3).toString());
    }//GEN-LAST:event_jTableAPaMouseClicked

    private void txfPhoneAPaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfPhoneAPaKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (((c < '0') || (c > '9')) || txfPhoneAPa.getText().length() >= 10)
            evt.consume();
    }//GEN-LAST:event_txfPhoneAPaKeyTyped

    private void btnDeleteAPaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteAPaActionPerformed
        // TODO add your handling code here:
       btnAddAPa.setEnabled(false);
       btnEditAPa.setEnabled(false);
       btnDeleteAPa.setEnabled(false);
       btnSaveAPa.setEnabled(true);
       txfNameAPa.setEnabled(true);
        txfAddressAPa.setEnabled(true);
        txfPhoneAPa.setEnabled(true);
    }//GEN-LAST:event_btnDeleteAPaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddAPa;
    private javax.swing.JButton btnDeleteAPa;
    private javax.swing.JButton btnEditAPa;
    private javax.swing.JButton btnSaveAPa;
    private javax.swing.JButton btnSearchAPa;
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
    private javax.swing.JTable jTableAPa;
    private javax.swing.JTextField txfAddressAPa;
    private javax.swing.JTextField txfIDAPa;
    private javax.swing.JTextField txfNameAPa;
    private javax.swing.JTextField txfPhoneAPa;
    private javax.swing.JTextField txfSearchAPa;
    // End of variables declaration//GEN-END:variables
}
