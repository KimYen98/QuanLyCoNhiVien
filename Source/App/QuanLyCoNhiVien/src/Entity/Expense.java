/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.Date;

/**
 *
 * @author STIREN
 */
public class Expense {
    private int IDExpense;
    private String NameExpense;
    private Date ExpenseDate;
    private float Total;

    public Expense() {
        this.IDExpense = 0;
        this.NameExpense = "";
        this.ExpenseDate = ExpenseDate;
        this.Total = 0;
    }

    public int getIDExpense() {
        return IDExpense;
    }

    public String getNameExpense() {
        return NameExpense;
    }

    public Date getExpenseDate() {
        return ExpenseDate;
    }

    public float getTotal() {
        return Total;
    }

    public void setIDExpense(int IDExpense) {
        this.IDExpense = IDExpense;
    }

    public void setNameExpense(String NameExpense) {
        this.NameExpense = NameExpense;
    }

    public void setExpenseDate(Date ExpenseDate) {
        this.ExpenseDate = ExpenseDate;
    }

    public void setTotal(float Total) {
        this.Total = Total;
    }
}
