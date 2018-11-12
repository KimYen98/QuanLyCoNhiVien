/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

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
}
