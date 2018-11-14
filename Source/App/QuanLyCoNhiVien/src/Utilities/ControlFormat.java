/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import Entity.Staff;
import Entity.StaffCategogy;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Bui Thi Huyen Tran
 */
public class ControlFormat {
    //lấy dữ liệu bảng loại nhân viên
    public void bindingStaffCategogy(JTable name , ArrayList<StaffCategogy> arr)
    {
        Vector header =new Vector();
        header.add("Mã loại nhân viên");
        header.add("Tên loại nhân viên");
        Vector data =new Vector();
        for( StaffCategogy staffCategogy: arr)
        {
            Vector row=new Vector();
            row.add(staffCategogy.getID());
            row.add(staffCategogy.getName());
            data.add(row);
        }
        //DefaultTableModel
        DefaultTableModel dtm = new DefaultTableModel(data,header){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        name.setModel(dtm); 
    }
     //Lấy dữ liệu bảng nhân viên
    public void bindingStaff(JTable name , ArrayList<Staff> arr)
    {
        Vector header =new Vector();
        header.add("Mã nhân viên");
        header.add("Tên nhân viên");
        header.add("Giới tính");
        header.add("Ngày sinh");
        header.add("Địa chỉ");
        header.add("Số điện thoại");
        header.add("Ngày vào làm");
        header.add("Loại nhân viên");
        Vector data =new Vector();
        for(Staff staff : arr)
        {
            Vector row = new Vector();
            row.add(staff.getID());
            row.add(staff.getName());
            row.add(staff.getSex());
            row.add(staff.getBirthday());
            row.add(staff.getAddress());
            row.add(staff.getPhoneNumber());
            row.add(staff.getStartWork());
            row.add(staff.getNameStaffCategogy());
            data.add(row);
        }
        //DefaultTableModel
        DefaultTableModel dtm = new DefaultTableModel(data,header){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        name.setModel(dtm); 
    }
}
