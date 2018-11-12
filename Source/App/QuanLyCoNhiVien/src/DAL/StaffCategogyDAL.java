/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Entity.StaffCategogy;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Bui Thi Huyen Tran
 */
public class StaffCategogyDAL extends  DataAccessHelper{
    //Load loại nhân viên
    public ArrayList<StaffCategogy> LoadStaffCategogy()
    {
        ArrayList<StaffCategogy> temp =new ArrayList<>();
        String SQL="select * from LoaiNhanVien";
        try {
            getConnect();
            Statement st =conn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            if(rs!=null)
                while(rs.next())
                {
                    StaffCategogy staffCategogy=new StaffCategogy();
                    staffCategogy.setID(rs.getInt("MaLoaiNV"));
                    staffCategogy.setName(rs.getString("TenLoaiNV"));
                    temp.add(staffCategogy);
                }
            getClose();
        } catch (Exception e) {
        }
        return temp;
    }
    //Thêm loại nhân viên
    public boolean InsertStaffCategogy(String name)
    {
        String SQL="exec sp_ThemLoaiNhanVien N'"+name+"'";
        try {
            getConnect();
            Statement st =conn.createStatement();
            int rs= st.executeUpdate(SQL);
            if(rs>0)
                return true;
            getClose();
        } catch (Exception e) {
        }
        return  false;
    }
    
    //Cập nhật loại nhân viên
    public boolean  UpdateStaffCtegogy(int id, String name)
    {
        String SQL="exec sp_CapNhatLoaiNhanVien '"+id+"',N'"+name+"'";
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
    //Xóa loại nhân viên
    public boolean  DeleteStaffCategogy(int id)
    {
        String SQL="DELETE FROM LoaiNhanVien WHERE MaLoaiNV='"+id+"'";
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
    //Tìm loại nhân viên
    public ArrayList<StaffCategogy> SearchStaffCategogy(String key)
    {
        ArrayList<StaffCategogy> temp =new ArrayList<>();
        String SQL="exec sp_TimLoaiNhanVien N'"+key+"'";
        try {
            getConnect();
            Statement st =conn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            if(rs!=null)
                while(rs.next())
                {
                    StaffCategogy staffCategogy=new StaffCategogy();
                    staffCategogy.setID(rs.getInt("MaLoaiNV"));
                    staffCategogy.setName(rs.getString("TenLoaiNV"));
                    temp.add(staffCategogy);
                }
            getClose();
        } catch (Exception e) {
        }
        return temp;
    }
}