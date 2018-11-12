/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Entity.Staff;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Bui Thi Huyen Tran
 */
public class StaffDAL extends  DataAccessHelper{
    //Load nhân viên
    public ArrayList <Staff> LoadStaff()
    {
        ArrayList<Staff> temp =new ArrayList<>();
        String SQL="";
        try {
            getConnect();
            Statement st =conn.createStatement();
            ResultSet rs =st.executeQuery(SQL);
            if(rs!=null)
                while(rs.next())
                {
                    Staff staff =new Staff();
                    staff.setID(rs.getInt("MaNV"));
                    staff.setName(rs.getString("TenNV"));
                    staff.setSex(rs.getString("GioiTinh"));
                    staff.setBirthday(rs.getDate("NgaySinh"));
                    staff.setAddress(rs.getString("DiaChi"));
                    staff.setPhoneNumber(rs.getString("SoDT"));
                    staff.setStartWork(rs.getDate("NgayVL"));
                    staff.setNameStaffCategogy(rs.getString("TenLoaiNV"));
                    temp.add(staff);
                }
            getClose();
        } catch (Exception e) {
        }
        return temp;
    }
    //Thêm nhân viên
    public boolean InertStaff(String name , String sex ,String birthday ,String address ,String phonenumber , String startwork ,String namestaffcategogy )
    {
        String SQL="";
        try {
            getConnect();
            Statement st =conn.createStatement();
            int rs =st.executeUpdate(SQL);
            if(rs>0)
                return true;
            getClose();
        } catch (Exception e) {
        }
        return false;
    }
    //Cập nhật nhân viên
    public boolean  UpdateStaff(int id,String name , String sex ,String birthday ,String address ,String phonenumber , String startwork ,String namestaffcategogy)
    {
        String SQL="";
        try {
            getConnect();
            Statement st =conn.createStatement();
            int rs=st.executeUpdate(SQL);
            if(rs>0)
                return true;
            getClose();
        } catch (Exception e) {
        }
        return false;
    }
    public boolean  DeleteStaff(int id)
    {
        String SQL="";
        try {
            getConnect();
            Statement st =conn.createStatement();
            int rs=st.executeUpdate(SQL);
            if(rs>0)
                return true;
            getClose();
        } catch (Exception e) {
        }
        return false;
    }
}
