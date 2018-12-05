/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bui Thi Huyen Tran
 */
public class DataAccessHelper {
    protected  Connection conn;
    String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    public void getConnect() throws SQLException{
        try {
            Class.forName(driver);
            //conn = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-JLJ2TBG;databaseName=QUANLYNHASACH", "sa", "1234");//integratedSecurity=True
            conn = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-JLJ2TBG:1433;databaseName=QuanLyCoNhiVien","sa","1234");//integratedSecurity=True
        
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DataAccessHelper.class.getName()).log(Level.SEVERE, null, ex);
        }        
    } 
    
    public void getClose(){
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataAccessHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
