/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Entity.Staff;
import java.sql.PreparedStatement;
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
        String SQL="exec sp_HienThiDanhSachNhanVien";
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
                    staff.setStatus(rs.getInt("TrangThai"));
                    temp.add(staff);
                }
            getClose();
        } catch (Exception e) {
        }
        return temp;
    }
    //Thêm nhân viên
    public boolean InertStaff(String name , String sex ,String birthday ,String address ,String phonenumber , String startwork ,int idstaffcategogy ,int status)
    {
        String SQL="exec sp_ThemNhanVien N'"+name+"',N'"+sex+"',N'"+birthday+"','"+address+"',N'"+phonenumber+"',N'"+startwork+"','"+idstaffcategogy+"','"+status+"'";
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
    public boolean  UpdateStaff(int id,String name , String sex ,String birthday ,String address ,String phonenumber , String startwork ,int idstaffcategogy, int status)
    {
        String SQL="exec sp_CapNhatNhanVien '"+id+"', N'"+name+"',N'"+sex+"',N'"+birthday+"','"+address+"',N'"+phonenumber+"',N'"+startwork+"','"+idstaffcategogy+"','"+status+"'";
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
    //Xóa nhân viên
    public boolean  DeleteStaff(int id)
    {
        String SQL="exec sp_XoaNhanVien '"+id+"'";
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
    //Tìm nhân viên
    public ArrayList <Staff> SearchStaff(String key)
    {
        ArrayList<Staff> temp =new ArrayList<>();
        String SQL="exec sp_TimNhanVien N'"+key+"'";
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
                    staff.setStatus(rs.getInt("TrangThai"));
                    temp.add(staff);
                }
            getClose();
        } catch (Exception e) {
        }
        return temp;
    }
    //Hiện thi danh sách nhân viên là bảo mẫu
    public ArrayList <Staff> LoadNanny()
    {
        ArrayList<Staff> temp =new ArrayList<>();
        String SQL="exec sp_HienThiDanhSachBaoMau";
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
                    staff.setStatus(rs.getInt("TrangThai"));
                    temp.add(staff);
                }
            getClose();
        } catch (Exception e) {
        }
        return temp;
    }
    //Lấy mã nhân viên theo tên nhân viên
    public int getID(String name)
    {
        String SQL="SELECT MaNV FROM NhanVien WHERE TenNV=N'"+name+"'";
        try {
            getConnect();
            PreparedStatement ps=conn.prepareStatement(SQL);
            ResultSet rs =ps.executeQuery();
            if(rs!=null && rs.next())
                return rs.getInt("MaNV");
            getClose();
        } catch (Exception e) {
        }
        return 0;
    }   
}
