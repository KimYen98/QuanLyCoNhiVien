/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Entity.Child;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Bui Thi Huyen Tran
 */
public class ChildDAL extends  DataAccessHelper{
   //Load trẻ
    public ArrayList< Child> LoadChild ()
    {
        ArrayList <Child> temp =new ArrayList<>();
        String SQL="exec sp_HienThiDanhSachTre";
        try {
            getConnect();
            Statement st = conn.createStatement();
            ResultSet rs=st.executeQuery(SQL);
            if(rs!=null)
                while(rs.next())
                {
                    Child child =new Child();
                    child.setID(rs.getInt("MaTre"));
                    child.setName(rs.getString("TenTre"));
                    child.setSex(rs.getString("GioiTinh"));
                    child.setBirthday(rs.getDate("NgaySinh"));
                    child.setJoinDate(rs.getDate("NgayVao"));
                    child.setSituation(rs.getString("HoanCanh"));
                    child.setWhoBring(rs.getString("NguoiDuaTreVao"));
                    child.setStatus(rs.getInt("TrangThai"));
                    child.setNameStaff(rs.getString("TenNV"));
                    temp.add(child);
                    getClose();
                }
        } catch (Exception e) {
        }
        return temp;
    }
    //Thêm trẻ
    public boolean InsertChild(String name , String sex , String birthday , String joindate , String situation ,String whobring ,int status , int idstaff  )
    {
        String SQL="exec sp_ThemTre N'"+name+"',N'"+sex+"',N'"+birthday+"',N'"+joindate+"',N'"+situation+"',N'"+whobring+"','"+status+"',N'"+idstaff+"'";
        try {
            getConnect();
            Statement st =conn.createStatement();
            int rs=st.executeUpdate(SQL);
            if(rs>0 )
                return true;
            getClose();
        } catch (Exception e) {
        }
        return false;
    }
    //Cập nhật trẻ
    public boolean UpdateChild(int id,String name , String sex , String birthday , String joindate , String situation ,String whobring ,int status , int idstaff  )
    {
        String SQL="exec sp_CapNhatTre '"+id+"',N'"+name+"',N'"+sex+"',N'"+birthday+"',N'"+joindate+"',N'"+situation+"',N'"+whobring+"','"+status+"',N'"+idstaff+"'";
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
    //Tìm trẻ
    public ArrayList<Child> SearchChild(String key)
    {
        ArrayList<Child> temp= new ArrayList<>();
        String SQL="exec sp_TimTre N'"+key+"'";
        try {
            getConnect();
            Statement st = conn.createStatement();
            ResultSet rs=st.executeQuery(SQL);
            if(rs!=null)
                while(rs.next())
                {
                    Child child =new Child();
                    child.setID(rs.getInt("MaTre"));
                    child.setName(rs.getString("TenTre"));
                    child.setSex(rs.getString("GioiTinh"));
                    child.setBirthday(rs.getDate("NgaySinh"));
                    child.setJoinDate(rs.getDate("NgayVao"));
                    child.setSituation(rs.getString("HoanCanh"));
                    child.setWhoBring(rs.getString("NguoiDuaTreVao"));
                    child.setStatus(rs.getInt("TrangThai"));
                    child.setNameStaff(rs.getString("TenNV"));
                    temp.add(child);
                    getClose();
                }
        } catch (Exception e) {
        }
        return temp;
    }
    
}
