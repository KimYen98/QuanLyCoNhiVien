/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import Entity.AdoptInfo;
import Entity.AdoptiveParent;
import Entity.Child;
import Entity.Sponsor;
import Entity.Sponsorship;
import Entity.Staff;
import Entity.StaffCategogy;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import sun.security.rsa.RSACore;

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
        header.add("Trạng thái");
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
            if(staff.getStatus()==1)
                row.add("Đang làm việc");
            if(staff.getStatus()==0)
                row.add("Đã nghỉ việc");
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
    //Lấy dữ liệu ở bảng trẻ
    public void bindingChild(JTable name ,ArrayList<Child> arr)
    {
        Vector header =new Vector();
        header.add("Mã trẻ");
        header.add("Tên trẻ");
        header.add("Ngày sinh");
        header.add("Giới tính");
        header.add("Ngày vào");
        header.add("Hoàn cảnh");
        header.add("Người đưa trẻ vào");
        header.add("Trạng thái");
        header.add("Tên bảo mẫu");
        Vector data =new Vector();
        for(Child child : arr)
        {
            Vector row =new Vector();
            row.add(child.getID());
            row.add(child.getName());
             row.add(child.getBirthday());
            row.add(child.getSex());
            row.add(child.getJoinDate());
            row.add(child.getSituation());
            row.add(child.getWhoBring());
            if(child.getStatus()==1)
                row.add("Ở cô nhi viện");
            if(child.getStatus()==0)
                row.add("Không còn ở cô nhi viện");
            row.add(child.getNameStaff());
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
    
    //Lấy dữ liệu ở bàng nhà tài trợ
    public void bindingSponsor(JTable name ,ArrayList<Sponsor> arr)        
    {
       Vector header =new Vector();
       header.add("Mã nhà tài trợ");
       header.add("Tên nhà tài trợ");
       header.add("Số điện thoại");
       header.add("Địa chỉ");
       Vector data =new Vector();
       for(Sponsor sponsor:arr)
       {
           Vector row =new Vector();
           row.add(sponsor.getID());
           row.add(sponsor.getName());
           row.add(sponsor.getPhoneNumber());
           row.add(sponsor.getAddress());
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
    //Lấy dữ liệu ở bảng tài trợ
    public void bindingSponsorship(JTable name , ArrayList<Sponsorship> arr)
    {
        Vector header =new Vector();
        header.add("Mã tài trợ");
        header.add("Tên nhà tài trợ");
        header.add("Ngày tài trợ");
        header.add("Hình thức tài trợ");
        header.add("Số tiền");
        Vector data =new Vector();
        for(Sponsorship sponsorship :arr)
        {
            Vector row =new Vector();
            row.add(sponsorship.getIDSponsorShip());
            row.add(sponsorship.getNameSponsor());
            row.add(sponsorship.getSponsorshipDate());
            row.add(sponsorship.getFormSponsorship());
            row.add(sponsorship.getMoney());
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
    //Lấy dữ liệu ở bảng người nhận trẻ
    public void bindingAdoptiveParent(JTable name ,ArrayList<AdoptiveParent> arr)
    {
        Vector header =new Vector();
        header.add("Mã người nhận");
        header.add("Tên người nhận");
        header.add("Địa chỉ");
        header.add("Số điện thoại");
        Vector data =new Vector();
        for(AdoptiveParent adoptiveParent :arr)
        {
            Vector row=new Vector();
            row.add(adoptiveParent.getID());
            row.add(adoptiveParent.getName());
            row.add(adoptiveParent.getAddress());
            row.add(adoptiveParent.getPhoneNumber());
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
    //Lấy dữ liệu ở bảng chi tiết nhận trẻ
    public void bindingAdoptInfo(JTable name ,ArrayList<AdoptInfo> arr)
    {
        Vector header =new Vector();
        header.add("Tên người nhận");
        header.add("Tên trẻ");
        header.add("Ngày nhận");
        Vector data =new Vector();
        for(AdoptInfo adoptInfo:arr)
        {
            Vector row =new Vector();
            row.add(adoptInfo.getNameAdoptiveParent());
            row.add(adoptInfo.getNameChild());
            row.add(adoptInfo.getAdoptDate());
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
