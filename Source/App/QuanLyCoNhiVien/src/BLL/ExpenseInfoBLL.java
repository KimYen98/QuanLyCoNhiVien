/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.ExpenseInfoDAL;
import Entity.ExpenseInfo;
import java.util.ArrayList;

/**
 *
 * @author STIREN
 */
public class ExpenseInfoBLL {
    ExpenseInfoDAL DAL = new ExpenseInfoDAL();
    //Lấy thông tin CTCT
    public ArrayList<ExpenseInfo> LoadExpenseInfo(int IDExpense)
    {
        return DAL.LoadExpenseInfo(IDExpense);
    }
    //Thêm CTCT
    public boolean InsertExpenseInfo(int IDExpense, String NameExpenseInfo, float Money)
    {
        return DAL.InsertExpenseInfo(IDExpense, NameExpenseInfo, Money);
    }
    //Cập nhật CTCT
    public boolean UpdateExpenseInfo(int IDExpense, int IDExpenseIfo, String NameExpenseInfo, float Money)
    {
        return DAL.UpdateExpenseInfo(IDExpense, IDExpenseIfo, NameExpenseInfo, Money);
    }
    //Xóa CTCT
    
    public boolean DeleteExpenseInfo(int IDExpense, int IDExpenseIfo)
    {
        return DAL.DeleteExpenseInfo(IDExpense, IDExpenseIfo);
    }
    //Tìm kiếm CTCT theo ngày
    public ArrayList<ExpenseInfo> SearchExpenseInfo(String day)
    {
        return DAL.SearchExpenseInfo(day);
    }
}
