/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author STIREN
 */
public class ExpenseInfo {
    private int IDExpense;
    private int IDExpenseInfo;
    private String NameExpenseInfo;
    private float Money;

    public ExpenseInfo() {
        this.IDExpense = 0;
        this.IDExpenseInfo = 0;
        this.NameExpenseInfo = "";
        this.Money = 0;
    }

    public int getIDExpense() {
        return IDExpense;
    }

    public int getIDExpenseInfo() {
        return IDExpenseInfo;
    }

    public String getNameExpenseInfo() {
        return NameExpenseInfo;
    }

    public float getMoney() {
        return Money;
    }

    public void setIDExpense(int IDExpense) {
        this.IDExpense = IDExpense;
    }

    public void setIDExpenseInfo(int IDExpenseInfo) {
        this.IDExpenseInfo = IDExpenseInfo;
    }

    public void setNameExpenseInfo(String NameExpenseInfo) {
        this.NameExpenseInfo = NameExpenseInfo;
    }

    public void setMoney(float Money) {
        this.Money = Money;
    }
}
