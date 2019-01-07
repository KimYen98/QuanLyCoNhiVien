/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BLL.ChildBLL;
import BLL.StaffBLL;
import Entity.Staff;
import Utilities.ControlFormat;
import com.toedter.calendar.JDateChooser;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author STIREN
 */
public class fChild extends javax.swing.JInternalFrame {

    /**
     * Creates new form fChild
     */
    ChildBLL childBLL=new ChildBLL();
    ControlFormat control =new ControlFormat();
    StaffBLL staffBLL=new StaffBLL();
    private int flag=0;
    public fChild() {
        initComponents();
        btnSaveChild.setEnabled(false);
        cbNameStaffChild.removeAllItems();
        control.bindingChild(jTableChild, childBLL.LoadChild());
        jTableChild.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTableChild.getColumnModel().getColumn(1).setPreferredWidth(200);
        jTableChild.getColumnModel().getColumn(2).setPreferredWidth(100);
        jTableChild.getColumnModel().getColumn(3).setPreferredWidth(70);
        jTableChild.getColumnModel().getColumn(4).setPreferredWidth(150);
        jTableChild.getColumnModel().getColumn(5).setPreferredWidth(150);
        jTableChild.getColumnModel().getColumn(6).setPreferredWidth(150);
        jTableChild.getColumnModel().getColumn(7).setPreferredWidth(200);
        jTableChild.getColumnModel().getColumn(8).setPreferredWidth(200);
        for(Staff staff: staffBLL.LoadAnny())
        {
            cbNameStaffChild.addItem(staff.getName());
        }
        jDChJoinDateChild.setDate(new Date());
        txfNameChild.setEnabled(false);
        txfWhoBring.setEnabled(false);
        rbFeMale.setEnabled(false);
        rbMale.setEnabled(false);
        jDChBirthdayChild.setEnabled(false);
        jDChJoinDateChild.setEnabled(false);
        cbNameStaffChild.setEnabled(false);
        cbStatus.setEnabled(false);
        txaSituation.setEnabled(false);
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

        buttonGroupSex = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btnAddChild = new javax.swing.JButton();
        btnEditChild = new javax.swing.JButton();
        btnSaveChild = new javax.swing.JButton();
        btnDeleteChild = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableChild = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        txfSearchChild = new javax.swing.JTextField();
        btnSearchChild = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txfIDChild = new javax.swing.JTextField();
        txfNameChild = new javax.swing.JTextField();
        jDChBirthdayChild = new com.toedter.calendar.JDateChooser();
        jPanel2 = new javax.swing.JPanel();
        rbMale = new javax.swing.JRadioButton();
        jDChJoinDateChild = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaSituation = new javax.swing.JTextArea();
        txfWhoBring = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        cbNameStaffChild = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        cbStatus = new javax.swing.JComboBox<>();
        rbFeMale = new javax.swing.JRadioButton();
        jLabel10 = new javax.swing.JLabel();

        setClosable(true);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel1.setText("QUẢN LÝ TRẺ");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(520, 10, 221, 37);

        jPanel4.setOpaque(false);

        btnAddChild.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAddChild.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/add.png"))); // NOI18N
        btnAddChild.setText("THÊM");
        btnAddChild.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddChildActionPerformed(evt);
            }
        });

        btnEditChild.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEditChild.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/tools.png"))); // NOI18N
        btnEditChild.setText("CẬP NHẬT");
        btnEditChild.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditChildActionPerformed(evt);
            }
        });

        btnSaveChild.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSaveChild.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/folder.png"))); // NOI18N
        btnSaveChild.setText("LƯU");
        btnSaveChild.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveChildActionPerformed(evt);
            }
        });

        btnDeleteChild.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDeleteChild.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/rubbish-bin.png"))); // NOI18N
        btnDeleteChild.setText("XÓA");
        btnDeleteChild.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteChildActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAddChild, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEditChild)
                .addGap(26, 26, 26)
                .addComponent(btnDeleteChild, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSaveChild, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddChild)
                    .addComponent(btnEditChild)
                    .addComponent(btnSaveChild)
                    .addComponent(btnDeleteChild))
                .addContainerGap())
        );

        getContentPane().add(jPanel4);
        jPanel4.setBounds(20, 540, 590, 60);

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane2.setAutoscrolls(true);

        jTableChild.setAutoCreateRowSorter(true);
        jTableChild.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTableChild.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã trẻ", "Tên trẻ", "Ngày sinh", "Giới tính", "Ngày vào", "Hoàn cảnh", "Người đưa trẻ vào", "Trạng thái", "Tên bảo mẫu"
            }
        ));
        jTableChild.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTableChild.setAutoscrolls(false);
        jTableChild.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableChildMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableChild);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(620, 120, 730, 520);

        jPanel3.setOpaque(false);

        txfSearchChild.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        btnSearchChild.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSearchChild.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/search.png"))); // NOI18N
        btnSearchChild.setText("TÌM KIẾM");
        btnSearchChild.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchChildActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txfSearchChild, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSearchChild)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSearchChild)
                    .addComponent(txfSearchChild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3);
        jPanel3.setBounds(610, 60, 411, 47);

        jPanel1.setOpaque(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Mã trẻ");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Tên trẻ");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Ngày sinh");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Giới tính");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Ngày vào");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Hoàn cảnh");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Người đưa trẻ vào");

        txfIDChild.setEditable(false);
        txfIDChild.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        txfNameChild.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        jDChBirthdayChild.setDateFormatString("dd-MM-yyyy");
        jDChBirthdayChild.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        jPanel2.setOpaque(false);

        buttonGroupSex.add(rbMale);
        rbMale.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        rbMale.setText("Nam");
        rbMale.setOpaque(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rbMale)
                .addGap(33, 33, 33))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(rbMale)
                .addGap(0, 14, Short.MAX_VALUE))
        );

        jDChJoinDateChild.setDateFormatString("dd-MM-yyyy");
        jDChJoinDateChild.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        txaSituation.setColumns(20);
        txaSituation.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        txaSituation.setRows(5);
        jScrollPane1.setViewportView(txaSituation);

        txfWhoBring.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Trạng thái");

        cbNameStaffChild.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        cbNameStaffChild.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Tên bảo mẫu");

        cbStatus.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        cbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ở cô nhi viện", "Không còn ở cô nhi viện" }));

        buttonGroupSex.add(rbFeMale);
        rbFeMale.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        rbFeMale.setText("Nữ");
        rbFeMale.setOpaque(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6))
                        .addGap(101, 101, 101)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txfIDChild)
                            .addComponent(jDChBirthdayChild, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(rbFeMale)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(txfNameChild)
                            .addComponent(jDChJoinDateChild, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8))
                        .addGap(45, 45, 45)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbStatus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE)
                            .addComponent(txfWhoBring)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(76, 76, 76)
                        .addComponent(cbNameStaffChild, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txfIDChild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txfNameChild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4))
                    .addComponent(jDChBirthdayChild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbFeMale)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDChJoinDateChild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel7))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txfWhoBring, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbNameStaffChild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(46, 108, 560, 430);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/bia2.png"))); // NOI18N
        getContentPane().add(jLabel10);
        jLabel10.setBounds(0, -50, 1410, 800);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void ClearText()
    {
        txaSituation.setText("");
        txfNameChild.setText("");
        txfIDChild.setText("");
        jDChJoinDateChild.setDate(new Date());
        cbStatus.setSelectedItem("Đang ở cô nhi viện");
        cbNameStaffChild.setSelectedIndex(0);
        rbFeMale.setSelected(true);
        jDChBirthdayChild.setDate(null);
        txfWhoBring.setText("");
        jDChJoinDateChild.setDate(new Date());
    }
    public boolean Delete()
    {
        int id=Integer.parseInt(txfIDChild.getText().toString());
        if(childBLL.DeleteChild(id))
        {
            JOptionPane.showMessageDialog(this, "Xóa trẻ thành công");
            return true;
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Xóa trẻ thất bại");
            return false;
        }
    }
    public boolean  Insert()
    {
        String name =txfNameChild.getText().toString();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        java.sql.Date  birthday =new java.sql.Date( jDChBirthdayChild.getDate().getTime());
        String sex ="";
        if(rbMale.isSelected())
            sex="Nam";
        if(rbFeMale.isSelected())
            sex="Nữ";
        java.sql.Date  joindate=new java.sql.Date( jDChJoinDateChild.getDate().getTime());
        String situation =txaSituation.getText().toString();
        String whobring =txfWhoBring.getText().toString();
        String status =cbStatus.getSelectedItem().toString();
        int status_;
        if(status.equals("Ở cô nhi viện"))
            status_=1;
        else
            status_=0;
        String namestaff =cbNameStaffChild.getSelectedItem().toString();
        int id=staffBLL.getID(namestaff);
        name=chuanHoaDanhTuRieng(name);
        situation=chuanHoa(situation);
        whobring=chuanHoaDanhTuRieng(whobring);
        if(name.equals("")|| birthday.equals("")|| sex.equals("")|| joindate.equals("")|| situation.equals("") || whobring.equals("")||
                status.equals("")|| namestaff.equals(""))
        {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập đầy đủ thông tin");
            return false;
        }
        else{
            if(childBLL.InsertChild(name, sex, birthday,joindate, situation, whobring, status_, id))
            {
                JOptionPane.showMessageDialog(this, "Thêm trẻ thành công");
                return true;
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Thêm trẻ thất bại");
                return false;
            }
        }
    }
    public boolean Update ()
    {
        int id =Integer.parseInt(txfIDChild.getText().toString());
        String name =txfNameChild.getText().toString();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        java.sql.Date  birthday =new java.sql.Date( jDChBirthdayChild.getDate().getTime());
        String sex ="";
        if(rbMale.isSelected())
            sex="Nam";
        if(rbFeMale.isSelected())
            sex="Nữ";
        java.sql.Date  joindate=new java.sql.Date( jDChJoinDateChild.getDate().getTime());
        String situation =txaSituation.getText().toString();
        String whobring =txfWhoBring.getText().toString();
        String status =cbStatus.getSelectedItem().toString();
        int status_;
        if(status.equals("Ở cô nhi viện"))
            status_=1;
        else
            status_=0;
        name=chuanHoaDanhTuRieng(name);
        situation=chuanHoa(situation);
        whobring=chuanHoaDanhTuRieng(whobring);
        String namestaff =cbNameStaffChild.getSelectedItem().toString();
        int idstaff=staffBLL.getID(namestaff);
        if(name.equals("")|| birthday.equals("")|| sex.equals("")|| joindate.equals("")|| situation.equals("") || whobring.equals("")||
                status.equals("")|| namestaff.equals(""))
        {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập đầy đủ thông tin");
            return false;
        }
        else{
            if(childBLL.UpdateChild(id, name, sex, birthday, joindate, situation, whobring, status_, idstaff))
            {
                JOptionPane.showMessageDialog(this, "Cập nhật trẻ thành công");
                return true;
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Cập nhật trẻ thất bại");
                return false;
            }
        }
    }
    
    private void btnAddChildActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddChildActionPerformed
        // TODO add your handling code here:
        ClearText();
        btnAddChild.setEnabled(false);
        btnEditChild.setEnabled(false);
        btnSaveChild.setEnabled(true);
        btnDeleteChild.setEnabled(false);
        flag=1;
        txfNameChild.setEnabled(true);
        txfWhoBring.setEnabled(true);
        rbFeMale.setEnabled(true);
        rbMale.setEnabled(true);
        jDChBirthdayChild.setEnabled(true);
        jDChJoinDateChild.setEnabled(true);
        cbNameStaffChild.setEnabled(true);
        cbStatus.setEnabled(true);
        txaSituation.setEnabled(true);
    }//GEN-LAST:event_btnAddChildActionPerformed

    private void btnEditChildActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditChildActionPerformed
        // TODO add your handling code here:
        btnAddChild.setEnabled(false);
        btnEditChild.setEnabled(false);
        btnSaveChild.setEnabled(true);
        btnDeleteChild.setEnabled(false);
        flag=2;
        txfNameChild.setEnabled(true);
        txfWhoBring.setEnabled(true);
        rbFeMale.setEnabled(true);
        rbMale.setEnabled(true);
        jDChBirthdayChild.setEnabled(true);
        jDChJoinDateChild.setEnabled(true);
        cbNameStaffChild.setEnabled(true);
        cbStatus.setEnabled(true);
        txaSituation.setEnabled(true);
    }//GEN-LAST:event_btnEditChildActionPerformed

    private void btnSaveChildActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveChildActionPerformed
        // TODO add your handling code here:
        if(flag==1)
        {
            if(Insert())
            {
                btnSaveChild.setEnabled(false);
                control.bindingChild(jTableChild, childBLL.LoadChild());
                ClearText();
               txfNameChild.setEnabled(false);
        txfWhoBring.setEnabled(false);
        rbFeMale.setEnabled(false);
        rbMale.setEnabled(false);
        jDChBirthdayChild.setEnabled(false);
        jDChJoinDateChild.setEnabled(false);
        cbNameStaffChild.setEnabled(false);
        cbStatus.setEnabled(false);
        txaSituation.setEnabled(false);
            }
            btnAddChild.setEnabled(true);
            btnEditChild.setEnabled(true);
            btnDeleteChild.setEnabled(true);
        }
        if(flag==2)
        {
            if(Update())
            {
                btnSaveChild.setEnabled(false);
                control.bindingChild(jTableChild, childBLL.LoadChild());
                txfNameChild.setEnabled(false);
        txfWhoBring.setEnabled(false);
        rbFeMale.setEnabled(false);
        rbMale.setEnabled(false);
        jDChBirthdayChild.setEnabled(false);
        jDChJoinDateChild.setEnabled(false);
        cbNameStaffChild.setEnabled(false);
        cbStatus.setEnabled(false);
        txaSituation.setEnabled(false);
                ClearText();
            }
            btnAddChild.setEnabled(true);
            btnEditChild.setEnabled(true);
            btnDeleteChild.setEnabled(true);
        }
        if(flag==3)
        {
            if(Delete())
            {
                btnSaveChild.setEnabled(false);
                control.bindingChild(jTableChild, childBLL.LoadChild());
                txfNameChild.setEnabled(false);
        txfWhoBring.setEnabled(false);
        rbFeMale.setEnabled(false);
        rbMale.setEnabled(false);
        jDChBirthdayChild.setEnabled(false);
        jDChJoinDateChild.setEnabled(false);
        cbNameStaffChild.setEnabled(false);
        cbStatus.setEnabled(false);
        txaSituation.setEnabled(false);
                ClearText();
            }
            btnAddChild.setEnabled(true);
            btnEditChild.setEnabled(true);
            btnDeleteChild.setEnabled(true);
        }
    }//GEN-LAST:event_btnSaveChildActionPerformed

    private void btnSearchChildActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchChildActionPerformed
        // TODO add your handling code here:
        String key =txfSearchChild.getText().toString();
        control.bindingChild(jTableChild, childBLL.SearchChild(key));
        txfSearchChild.setText("");
    }//GEN-LAST:event_btnSearchChildActionPerformed

    private void jTableChildMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableChildMouseClicked
        // TODO add your handling code here:
        int row= jTableChild.getSelectedRow();
        txfIDChild.setText(jTableChild.getValueAt(row, 0).toString());
        txfNameChild.setText(jTableChild.getValueAt(row, 1).toString());
        jDChBirthdayChild.setDate((Date)jTableChild.getModel().getValueAt(row, 2));
        jDChJoinDateChild.setDate((Date) jTableChild.getModel().getValueAt(row, 4));
        String sex =jTableChild.getValueAt(row, 3).toString();
        if(sex.equals("Nam"))
            rbMale.setSelected(true);
        if(sex.equals("Nữ"))
            rbFeMale.setSelected(true);
        txaSituation.setText(jTableChild.getValueAt(row, 5).toString());
        txfWhoBring.setText(jTableChild.getValueAt(row, 6).toString());
        String status =jTableChild.getValueAt(row, 7).toString();
        if(status.equals("Ở cô nhi viện"))
            cbStatus.setSelectedItem("Ở cô nhi viện");
        if(status.equals("Không còn ở cô nhi viện"))
            cbStatus.setSelectedItem("Không còn ở cô nhi viện");
        String namestaff =jTableChild.getValueAt(row, 8).toString();
        cbNameStaffChild.setSelectedItem(namestaff);
    }//GEN-LAST:event_jTableChildMouseClicked

    private void btnDeleteChildActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteChildActionPerformed
        // TODO add your handling code here:
        btnAddChild.setEnabled(false);
        btnEditChild.setEnabled(false);
        btnDeleteChild.setEnabled(false);
        btnSaveChild.setEnabled(true);
        flag=3;
        txfNameChild.setEnabled(true);
        txfWhoBring.setEnabled(true);
        rbFeMale.setEnabled(true);
        rbMale.setEnabled(true);
        jDChBirthdayChild.setEnabled(true);
        jDChJoinDateChild.setEnabled(true);
        cbNameStaffChild.setEnabled(true);
        cbStatus.setEnabled(true);
        txaSituation.setEnabled(true);
    }//GEN-LAST:event_btnDeleteChildActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddChild;
    private javax.swing.JButton btnDeleteChild;
    private javax.swing.JButton btnEditChild;
    private javax.swing.JButton btnSaveChild;
    private javax.swing.JButton btnSearchChild;
    private javax.swing.ButtonGroup buttonGroupSex;
    private javax.swing.JComboBox<String> cbNameStaffChild;
    private javax.swing.JComboBox<String> cbStatus;
    private com.toedter.calendar.JDateChooser jDChBirthdayChild;
    private com.toedter.calendar.JDateChooser jDChJoinDateChild;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableChild;
    private javax.swing.JRadioButton rbFeMale;
    private javax.swing.JRadioButton rbMale;
    private javax.swing.JTextArea txaSituation;
    private javax.swing.JTextField txfIDChild;
    private javax.swing.JTextField txfNameChild;
    private javax.swing.JTextField txfSearchChild;
    private javax.swing.JTextField txfWhoBring;
    // End of variables declaration//GEN-END:variables
}
