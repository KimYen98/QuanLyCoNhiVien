/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.ExpenseDAL;
import Entity.Expense;
import java.util.ArrayList;

/**
 *
 * @author STIREN
 */
public class ExpenseBLL {
    ExpenseDAL DAL = new ExpenseDAL();
    //Lấy thông tin chi tiêu
    public ArrayList<Expense> LoadExpense()
    {
        return DAL.LoadExpense();
    }
    //Thêm chi tiêu
    public boolean InsertExpense(String NameExpense, String ExpenseDate)
    {
        return DAL.InsertExpense(NameExpense, ExpenseDate);
    }
    //Cập nhật chi tiêu
    public boolean UpdateExpense(int IDExpense, String NameExpense, String ExpenseDate)
    {
        return DAL.UpdateExpense(IDExpense, NameExpense, ExpenseDate);
    }
    //Xóa chi tiêu
    public boolean DeleteExpense(int IDExpense)
    {
        return DAL.DeleteExpense(IDExpense);
    }
    //Tìm kiếm chi tiêu
    public ArrayList<Expense> SearchExpense(int month, int year)
    {
        return DAL.SearchExpense(month, year);
    }
    //Thống kê chi tiêu trong khoảng thời gian
    public int getTotalExpense(String FromDate, String ToDate)
    {
        return DAL.getTotalExpense(FromDate, ToDate);
    }
    public int getFund()
    {
        return DAL.getFund();
    }
}
