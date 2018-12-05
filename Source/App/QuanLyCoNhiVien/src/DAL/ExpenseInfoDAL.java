/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Entity.ExpenseInfo;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author STIREN
 */
public class ExpenseInfoDAL extends DataAccessHelper{
    //Hiển thị thông thị chi tiết chi tiêu
    public ArrayList<ExpenseInfo> LoadExpenseInfo(int IDExpense)
    {
        ArrayList<ExpenseInfo> temp = new ArrayList<>();
        String SQL = "SP_HienThiCTCT " + IDExpense;
        try {
            getConnect();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            if(rs != null)
                while(rs.next())
                {
                    ExpenseInfo expenseInfo = new ExpenseInfo();
                    expenseInfo.setIDExpense(rs.getInt("MaChiTieu"));
                    expenseInfo.setIDExpenseInfo(rs.getInt("MaCT_ChiTieu"));
                    expenseInfo.setNameExpenseInfo(rs.getString("TenCTChiTieu"));
                    expenseInfo.setMoney(rs.getFloat("SoTien"));
                    temp.add(expenseInfo);
                }
            getClose();
        } catch (Exception e) {
        }
        return temp;
    }
    //Thêm chi tiết chi tiêu
    public boolean InsertExpenseInfo(int IDExpense, String NameExpenseInfo, float Money)
    {
        String SQL = "SP_ThemCTCT " + IDExpense + ", N'" + NameExpenseInfo + "', " + Money;
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
    //Cập nhật chi tiết chi tiêu
    public boolean UpdateExpenseInfo(int IDExpense, int IDExpenseIfo, String NameExpenseInfo, float Money)
    {
        String SQL = "SP_CapNhatCTCT " + IDExpense + ", " + IDExpenseIfo + ", N'" + NameExpenseInfo + "', " + Money;
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
    //Xóa chi tiết chi tiêu
    public boolean DeleteExpenseInfo(int IDExpense, int IDExpenseIfo)
    {
        String SQL = "SP_XoaCTCT " + IDExpense + ", " + IDExpenseIfo;
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
    //Tìm kiếm chi tiết chi tiêu theo ngày
    public ArrayList<ExpenseInfo> SearchExpenseInfo(String day)
    {
        ArrayList<ExpenseInfo> temp =new ArrayList<>();
        String SQL = "SP_TimKiemCTCT " + day;
        try {
            getConnect();
            Statement st =conn.createStatement();
            ResultSet rs=st.executeQuery(SQL);
            if(rs!=null)
            {
                while (rs.next())
                {
                    ExpenseInfo expenseInfo = new ExpenseInfo();
                    expenseInfo.setIDExpense(rs.getInt("MaChiTieu"));
                    expenseInfo.setIDExpenseInfo(rs.getInt("MaCT_ChiTieu"));
                    expenseInfo.setNameExpenseInfo(rs.getString("TenCTChiTieu"));
                    expenseInfo.setMoney(rs.getFloat("SoTien"));
                    temp.add(expenseInfo);
                }
            }
            getClose();
        } catch (Exception e) {
        }
        return temp;
    }
}
