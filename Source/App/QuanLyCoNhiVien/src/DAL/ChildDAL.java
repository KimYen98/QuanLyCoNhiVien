/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Entity.Child;
import java.sql.PreparedStatement;
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
                     child.setBirthday(rs.getDate("NgaySinh"));
                    child.setSex(rs.getString("GioiTinh"));
                    child.setJoinDate(rs.getDate("NgayVao"));
                    child.setSituation(rs.getString("HoanCanh"));
                    child.setWhoBring(rs.getString("NguoiDuaTreVao"));
                    child.setStatus(rs.getInt("TrangThai"));
                    child.setNameStaff(rs.getString("TenNV"));
                    temp.add(child);
                   
                }
             getClose();
        } catch (Exception e) {
        }
        return temp;
    }
    //Thêm trẻ
    public boolean InsertChild(String name , String sex , String birthday , String joindate , String situation ,String whobring ,int status , int idstaff  )
    {
        String SQL="exec sp_ThemTre N'"+name+"',N'"+sex+"',N'"+birthday+"',N'"+joindate+"',N'"+situation+"',N'"+whobring+"','"+status+"','"+idstaff+"'";
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
        String SQL="exec sp_CapNhatTre '"+id+"',N'"+name+"',N'"+sex+"',N'"+birthday+"',N'"+joindate+"',N'"+situation+"',N'"+whobring+"','"+status+"','"+idstaff+"'";
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
    //Load trẻ hiện đang ở cô nhi viện
    public ArrayList< Child> LoadChildNow ()
    {
        ArrayList <Child> temp =new ArrayList<>();
        String SQL="exec sp_HienThiDanhSachTreHienOCoNhiVien";
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
                     child.setBirthday(rs.getDate("NgaySinh"));
                    child.setSex(rs.getString("GioiTinh"));
                    child.setJoinDate(rs.getDate("NgayVao"));
                    child.setSituation(rs.getString("HoanCanh"));
                    child.setWhoBring(rs.getString("NguoiDuaTreVao"));
                    child.setStatus(rs.getInt("TrangThai"));
                    child.setNameStaff(rs.getString("TenNV"));
                    temp.add(child);
                   
                }
             getClose();
        } catch (Exception e) {
        }
        return temp;
    }
    //Lấy mã trẻ theo tên trẻ
    public int getID(String name)    
    {
        String SQL="SELECT MaTre FROM Tre WHERE TenTre=N'"+name+"'";
        try {
            getConnect();
            PreparedStatement ps=conn.prepareStatement(SQL);
            ResultSet rs =ps.executeQuery();
            if(rs!=null && rs.next())
                return rs.getInt("MaTre");
            getClose();
        } catch (Exception e) {
        }
        return 0;
    }
    //Báo cáo trẻ thêm mới
    
    public ArrayList<Child> RPNewChild(String FromDate, String ToDate)
    {
        ArrayList <Child> temp =new ArrayList<>();
        String SQL = "EXEC SP_BaoCaoTreThemMoi '" + FromDate + "', '" + ToDate + "'";
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
                     child.setBirthday(rs.getDate("NgaySinh"));
                    child.setSex(rs.getString("GioiTinh"));
                    child.setJoinDate(rs.getDate("NgayVao"));
                    child.setSituation(rs.getString("HoanCanh"));
                    child.setWhoBring(rs.getString("NguoiDuaTreVao"));
                    child.setStatus(rs.getInt("TrangThai"));
                    child.setNameStaff(rs.getString("TenNV"));
                    temp.add(child);                   
                }
            getClose();
        } catch (Exception e) {
        }
        return temp;
    }
    //Báo cáo trẻ được nhận nuôi
    public ArrayList<Child> RPAdoptedChild(String FromDate, String ToDate)
    {
        ArrayList<Child> temp= new ArrayList<>();
        String SQL = "EXEC SP_BaoCaoTreDuocNhanNuoi '" + FromDate + "', '" + ToDate + "'";
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
                    
                }
            getClose();
        } catch (Exception e) {
        }
        return temp;
    }
    //Báo cáo trẻ đang ở cô nhi viện
    public ArrayList<Child> RPNumOfChild(int FromAge, int ToAge)
    {
        ArrayList<Child> temp= new ArrayList<>();
        String SQL = "EXEC SP_BaoCaoTreDangOCoNhiVien " + FromAge + ", " + ToAge;
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
                    
                }
            getClose();
        } catch (Exception e) {
        }
        return temp;
    }
    //Thống kê số lượng trẻ nam đang ở cô nhi viện
    public int getNumOfMaleChild()
    {
        String SQL = "EXEC SP_ThongKeTreNam";
        try {
            getConnect();
            PreparedStatement ps = conn.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            if(rs != null && rs.next())
                return rs.getInt("Nam");
            getClose();
        } catch (Exception e) {
        }
        return 0;
    }
    //Thống kê số lượng trẻ nữ đang ở cô nhi viện
    public int getNumOfFemaleChild()
    {
        String SQL = "EXEC SP_ThongKeTreNu";
        try {
            getConnect();
            PreparedStatement ps = conn.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            if(rs != null && rs.next())
                return rs.getInt("Nu");
            getClose();
        } catch (Exception e) {
        }
        return 0;
    }
}
