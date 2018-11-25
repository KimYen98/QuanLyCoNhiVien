/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Entity.Sponsorship;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Bui Thi Huyen Tran
 */
public class SponsorshipDAL extends  DataAccessHelper{
    //Lấy danh sách tài trợ
    public ArrayList<Sponsorship> LoadSponsorship()
    {
        String SQL="exec sp_HienThiDanhSachTaiTro";
        ArrayList<Sponsorship> temp= new ArrayList<>();
        try {
            getConnect();
            Statement st = conn.createStatement();
            ResultSet rs =st.executeQuery(SQL);
            if(rs!=null)
            {
                while(rs.next())
                {
                    Sponsorship sponsorship =new Sponsorship();
                    sponsorship.setNameSponsor(rs.getString("TenNhaTaiTro"));
                    sponsorship.setIDSponsorShip(rs.getInt("MaTaiTro"));
                    sponsorship.setSponsorshipDate(rs.getDate("NgayTaiTro"));
                    sponsorship.setFormSponsorship(rs.getString("HinhThucTaiTro"));
                    sponsorship.setMoney(rs.getFloat("SoTien"));
                    temp.add(sponsorship);
                }
            }
            getClose();
        } catch (Exception e) {
        }
        return temp;
    }
    //Thêm tài trợ
    public boolean  Insert(int idsponsor , String sponsorshipdate ,String formatsponsorship ,float money)
    {
        String SQL="exec sp_ThemTaiTro '"+idsponsor+"',N'"+sponsorshipdate+"',N'"+formatsponsorship+"','"+money+"'";
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
    //Cập nhật nhà tài trợ
    public boolean  Update (int idsponsorship,int idsponsor  ,String sponsorshipdate ,String formatsponsorship,float money)
    {
         String SQL="exec sp_CapNhatTaiTro '"+idsponsorship+"','"+idsponsor+"',N'"+sponsorshipdate+"',N'"+formatsponsorship+"','"+money+"'";
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
    //Xóa tài trợ
    public boolean  Delete (int idsponsorship )
    {
         String SQL="exec sp_XoaTaiTro '"+idsponsorship+"'";
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
    public ArrayList<Sponsorship> SearchSponsorShip(String key)
    {
        String SQL="exec sp_TimTaiTro N'"+key+"'";
        ArrayList<Sponsorship> temp= new ArrayList<>();
        try {
            getConnect();
            Statement st = conn.createStatement();
            ResultSet rs =st.executeQuery(SQL);
            if(rs!=null)
            {
                while(rs.next())
                {
                    Sponsorship sponsorship =new Sponsorship();
                    sponsorship.setNameSponsor(rs.getString("TenNhaTaiTro"));
                    sponsorship.setIDSponsorShip(rs.getInt("MaTaiTro"));
                    sponsorship.setSponsorshipDate(rs.getDate("NgayTaiTro"));
                    sponsorship.setFormSponsorship(rs.getString("HinhThucTaiTro"));
                    sponsorship.setMoney(rs.getFloat("SoTien"));
                    temp.add(sponsorship);
                }
            }
            getClose();
        } catch (Exception e) {
        }
        return temp;
    }
}