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
        String SQL="";
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
                    child.setStatus(rs.getString("TrangThai"));
                    child.setNameStaff(rs.getString("MaNV"));
                    temp.add(child);
                    getClose();
                }
        } catch (Exception e) {
        }
        return temp;
    }
    //Thêm trẻ
    public boolean InsertChild(String name , String sex , String birthday , String joindate , String situation ,String whobring ,String status , String namestaff  )
    {
        String SQL="";
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
    public boolean UpdateChild(int id,String name , String sex , String birthday , String joindate , String situation ,String whobring ,String status , String namestaff  )
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
