/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Entity.Expense;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author STIREN
 */
public class ExpenseDAL extends DataAccessHelper{
    public ArrayList<Expense> LoadExpense(){
        ArrayList<Expense> temp = new ArrayList<>();
        String SQL = "EXEC SP_HienThiChiTieu";
        try {
            getConnect();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            if(rs != null)
            while(rs.next())
            {
                Expense expense = new Expense();
                expense.setIDExpense(rs.getInt("MaChiTieu"));
                expense.setNameExpense(rs.getString("TenChiTieu"));
                expense.setExpenseDate(rs.getDate("NgayChi"));
                expense.setTotal(rs.getFloat("TongSoTien"));
                temp.add(expense);
            }
            getClose();
        } catch (Exception e) {
        }
        return temp;
    }
    
    //Thêm chi tiêu
    public boolean InsertExpense(String NameExpense, String ExpenseDate)
    {
        String SQL = "EXEC SP_ThemChiTieu N'" + NameExpense + "', '" + ExpenseDate + "'";
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
    //Cập nhật chi tiêu
    public boolean UpdateExpense(int IDExpense, String NameExpense, String ExpenseDate)
    {
        String SQL = "EXEC SP_CapNhatChiTieu " + IDExpense + ", N'" + NameExpense + "', '" + ExpenseDate + "'";
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
    //Xóa chi tiêu
    public boolean DeleteExpense(int IDExpense)
    {
        String SQL = "EXEC SP_XoaChiTieu " + IDExpense;
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
    //Tìm kiếm chi tiêu theo thời gian
    public ArrayList<Expense> SearchExpense(int month, int year)
    {
        ArrayList<Expense> temp =new ArrayList<>();
        String SQL = "EXEC SP_TimChiTieu " + month + ", " + year;
        try {
            getConnect();
            Statement st =conn.createStatement();
            ResultSet rs=st.executeQuery(SQL);
            if(rs!=null)
            {
                while (rs.next())
                {
                    Expense expense = new Expense();
                    expense.setIDExpense(rs.getInt("MaChiTieu"));
                    expense.setNameExpense(rs.getString("TenChiTieu"));
                    expense.setExpenseDate(rs.getDate("NgayChi"));
                    expense.setTotal(rs.getFloat("TongSoTien"));
                    temp.add(expense);
                }
            }
            getClose();
        } catch (Exception e) {
        }
        return temp;
    }
    //Thống kê số tiền chi tiêu trong khoảng thời gian
    
    public int getTotalExpense(String FromDate, String ToDate)
    {

        String SQL = "EXEC SP_ThongKeChiTieu '" + FromDate + "', '" + ToDate + "'";
        try {
            getConnect();
            PreparedStatement ps = conn.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            if(rs != null && rs.next())
                return rs.getInt("TienChiTieu");
            getClose();
        } catch (Exception e) {
        }
        return 0;
    } 
    //Thống kê quỹ tiền còn lại
    public int getFund()
    {
        String SQL = "EXEC SP_ThongKeQuy";

        try {
            getConnect();
            PreparedStatement ps = conn.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            if(rs != null && rs.next())
                return rs.getInt("Quy");
            getClose();
        } catch (Exception e) {
        }
        return 0;
    }
}
