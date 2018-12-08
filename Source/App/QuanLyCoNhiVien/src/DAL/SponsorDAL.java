/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Entity.Sponsor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Bui Thi Huyen Tran
 */
public class SponsorDAL extends DataAccessHelper{
    //Load nhà tài trợ
    public ArrayList<Sponsor> LoadSponsor ()
    {
        ArrayList<Sponsor> temp=new ArrayList<>();
        String SQL="select * from NhaTaiTro";
        try {
            getConnect();
            Statement st =conn.createStatement();
            ResultSet rs=st.executeQuery(SQL);
            if(rs!=null)
            {
                while(rs.next())
                {
                    Sponsor sponsor=new Sponsor();
                    sponsor.setID(rs.getInt("MaNhaTaiTro"));
                    sponsor.setName(rs.getString("TenNhaTaiTro"));
                    sponsor.setPhoneNumber(rs.getString("SoDT"));
                    sponsor.setAddress(rs.getString("DiaChi"));
                    temp.add(sponsor);
                    
                }
            }
            getClose();
        } catch (Exception e) {
        }
        return temp;
    }
    //Thêm nhà tài trợ
    public boolean  InsertSponsor(String name, String phonenumber ,String address)
    {
        String SQL="exec sp_ThemNhaTaiTro N'"+name+"','"+phonenumber+"',N'"+address+"'";
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
    //Cập nhật nhà tài trợ
    public boolean  UpdateSponsor(int id,String name ,String phonenumber ,String address)
    {
        String SQL="exec sp_CapNhatNhaTaiTro '"+id+"',N'"+name+"',N'"+phonenumber+"',N'"+address+"'";
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
    //Xóa nhà tài trợ
    public boolean  DeleteSponsor(int id)
    {
        String SQL="exec sp_XoaNhaTaiTro '"+id+"'";
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
    //Tìm nhà tài trợ
    public ArrayList<Sponsor>  SearchSposor(String key)
    {
        ArrayList<Sponsor> temp =new ArrayList<>();
        String SQL="exec sp_TimNhaTaiTro N'"+key+"'";
        try {
            getConnect();
            Statement st =conn.createStatement();
            ResultSet rs=st.executeQuery(SQL);
            if(rs!=null)
            {
                while (rs.next())
                {
                     Sponsor sponsor=new Sponsor();
                    sponsor.setID(rs.getInt("MaNhaTaiTro"));
                    sponsor.setName(rs.getString("TenNhaTaiTro"));
                    sponsor.setPhoneNumber(rs.getString("SoDT"));
                    sponsor.setAddress(rs.getString("DiaChi"));
                    temp.add(sponsor);
                    
                }
            }
            getClose();
        } catch (Exception e) {
        }
        return temp;
        
    }
    //Lấy mã nhà tài trợ theo tên nhà tài trợ
    public int getIdSponsor(String name)
    {
        String SQL ="select MaNhaTaiTro from NhaTaiTro where TenNhaTaiTro=N'"+name+"'";
        try {
            getConnect();
            PreparedStatement ps=conn.prepareStatement(SQL);
            ResultSet rs =ps.executeQuery();
            if(rs!=null && rs.next())
                return rs.getInt("MaNhaTaiTro");
            getClose();
        } catch (Exception e) {
        }
        return 0;
        
    }
}
