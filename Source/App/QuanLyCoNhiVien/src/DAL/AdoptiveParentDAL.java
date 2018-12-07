/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Entity.AdoptiveParent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Bui Thi Huyen Tran
 */
public class AdoptiveParentDAL extends  DataAccessHelper{
    //lấy danh sách người nhận trẻ
    public ArrayList<AdoptiveParent> LoadAdoptiveParent()
    {
        String SQL="exec sp_HienThiDanhSachNguoiNhanTre";
        ArrayList<AdoptiveParent> temp =new ArrayList<>();
        try {
            getConnect();
            Statement st =conn.createStatement();
            ResultSet rs =st.executeQuery(SQL);
            if(rs!=null)
                while(rs.next())
                {
                    AdoptiveParent adoptiveParent=new AdoptiveParent();
                    adoptiveParent.setID(rs.getInt("MaNguoiNhan"));
                    adoptiveParent.setName(rs.getString("TenNguoiNhan"));
                    adoptiveParent.setAddress(rs.getString("DiaChi"));
                    adoptiveParent.setPhoneNumber(rs.getString("SoDT"));
                    temp.add(adoptiveParent);
                }
            getClose();
        } catch (Exception e) {
        }
        return temp;
    }
    //Thêm người nhận trẻ
    public boolean  InsertAdoptiveParent(String name , String address , String phonenumber)
    {
        String SQL="exec sp_ThemNguoiNhanTre N'"+name+"',N'"+address+"',N'"+phonenumber+"'";
        try {
            getConnect();
            Statement statement=conn.createStatement();
            int rs=statement.executeUpdate(SQL);
            if(rs>0)
                return true;
            getClose();
        } catch (Exception e) {
        }
        return false;
    }
    //Cập nhật người nhận trẻ
    public boolean UpdateAdoptiveParent(int id , String name ,String address ,String phonenumber )
    {
        String SQL="exec sp_CapNhatNguoiNhanTre '"+id+"',N'"+name+"',N'"+address+"',N'"+phonenumber+"'";
        try {
            getConnect();
            Statement  st =conn.createStatement();
            int rs =st.executeUpdate(SQL);
            if(rs>0)
                return true;
            getClose();
        } catch (Exception e) {
        }
        return false;
    }
    //Tra cứu người nhận trẻ
     public ArrayList<AdoptiveParent> SeacrchAdoptiveParent(String key)
    {
        String SQL="exec sp_TraCuuNguoiNhanTre N'"+key+"'";
        ArrayList<AdoptiveParent> temp =new ArrayList<>();
        try {
            getConnect();
            Statement st =conn.createStatement();
            ResultSet rs =st.executeQuery(SQL);
            if(rs!=null)
                while(rs.next())
                {
                    AdoptiveParent adoptiveParent=new AdoptiveParent();
                    adoptiveParent.setID(rs.getInt("MaNguoiNhanTre"));
                    adoptiveParent.setName(rs.getString("TenNguoiNhanTre"));
                    adoptiveParent.setAddress(rs.getString("DiaChi"));
                    adoptiveParent.setPhoneNumber(rs.getString("SoDT"));
                    temp.add(adoptiveParent);
                }
            getClose();
        } catch (Exception e) {
        }
        return temp;
    }
     //Lấy mã người nhận trẻ theo tên người nhận trẻ
     public int getID(String name)
     {
         String SQL="SELECT MaNguoiNhan FROM NguoiNhanTre WHERE TenNguoiNhan=N'"+name+"'";
        try {
            getConnect();
            PreparedStatement ps=conn.prepareStatement(SQL);
            ResultSet rs =ps.executeQuery();
            if(rs!=null && rs.next())
                return rs.getInt("MaNguoiNhan");
            getClose();
        } catch (Exception e) {
        }
        return 0;
     }
}
