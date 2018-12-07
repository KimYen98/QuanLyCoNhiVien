/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Entity.AdoptInfo;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Struct;
import java.util.ArrayList;
import javax.naming.spi.DirStateFactory;

/**
 *
 * @author Bui Thi Huyen Tran
 */
public class AdoptInfoDAL extends  DataAccessHelper{
    //Lấy danh sách thông tin chi tiết nhận trẻ
    public ArrayList<AdoptInfo> LoadAdoptInfo()
    {
        ArrayList <AdoptInfo> temp =new ArrayList<>();
        String SQL="exec sp_HienThiChiTietNguoiNhanTre";
        try {
            getConnect();
            Statement st = conn.createStatement();
            ResultSet rs=st.executeQuery(SQL);
            if(rs!=null)
                while(rs.next())
                {
                    AdoptInfo adoptInfo=new AdoptInfo();
                    adoptInfo.setNameAdoptiveParent(rs.getString("TenNguoiNhan"));
                    adoptInfo.setNameChild(rs.getString("TenTre"));
                    adoptInfo.setAdoptDate(rs.getDate("NgayNhan"));
                    temp.add(adoptInfo);
                   
                }
             getClose();
        } catch (Exception e) {
        }
        return temp;
    }
    //Thêm chi tiết người nhận trẻ
    public boolean  InsertAdoptInfo(int IdAdoptiveParent ,int IdChild , String AdoptDate)
    {
        String SQL="exec sp_ThemChiTietNhanTre '"+IdAdoptiveParent+"','"+IdChild+"','"+AdoptDate+"'";
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
    //Cập nhật chi tiết người nhận trẻ
    public boolean  UpdateAdoptInfo(int IdAdoptiveParent, int IdChild , String AdoptDate)
    {
        String SQL="exec sp_CapNhatChiTietNhanTre '"+IdAdoptiveParent+"','"+IdChild+"','"+AdoptDate+"'";
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
    //Xóa chi tiết người nhận trẻ
    public boolean  DeleteAdoptInfo(int IdAdoptiveParent , int IdChild)
    {
        String SQL="exec sp_XoaChiTietNhanTre '"+IdAdoptiveParent+"','"+IdChild+"'";
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
    //Tra cứu chi tiết nhận trẻ theo tên trẻ
    public ArrayList<AdoptInfo> SearchAdoptInfo_Child(String key)
    {
        ArrayList<AdoptInfo> temp =new ArrayList<>();
        String SQL="exec sp_TraCuuChiTietNguoiNhanTreTheoTenTre N'"+key+"'";
        try {
            getConnect();
            Statement st =conn.createStatement();
            ResultSet rs =st.executeQuery(SQL);
            if(rs!=null)
                while(rs.next())
                {
                    AdoptInfo adoptInfo =new AdoptInfo();
                    adoptInfo.setNameAdoptiveParent(rs.getString("TenNguoiNhan"));
                    adoptInfo.setNameChild(rs.getString("TenTre"));
                    adoptInfo.setAdoptDate(rs.getDate(rs.getString("NgayNhan")));
                }
            getClose();
        } catch (Exception e) {
        }
        return temp;
    }
     //Tra cứu chi tiết nhận trẻ theo tên trẻ
    public ArrayList<AdoptInfo> SearchAdoptInfo_Adopt(String key)
    {
        ArrayList<AdoptInfo> temp =new ArrayList<>();
        String SQL="exec sp_TimChiTietNguoiNhanTreTheoTenNguoiNhan N'"+key+"'";
        try {
            getConnect();
            Statement st =conn.createStatement();
            ResultSet rs =st.executeQuery(SQL);
            if(rs!=null)
                while(rs.next())
                {
                    AdoptInfo adoptInfo =new AdoptInfo();
                    adoptInfo.setNameAdoptiveParent(rs.getString("TenNguoiNhan"));
                    adoptInfo.setNameChild(rs.getString("TenTre"));
                    adoptInfo.setAdoptDate(rs.getDate(rs.getString("NgayNhan")));
                }
            getClose();
        } catch (Exception e) {
        }
        return temp;
    }
}
