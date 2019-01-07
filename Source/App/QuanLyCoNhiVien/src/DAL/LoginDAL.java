/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Bui Thi Huyen Tran
 */
public class LoginDAL extends  DataAccessHelper{
    //Đăng nhập
     public boolean Login(String username ,String password )
    {
        String SQL="EXEC sp_DangNhap N'"+username+"',N'"+password+"'";
        try {
            getConnect();
            PreparedStatement st =conn.prepareCall(SQL);
            ResultSet rs=st.executeQuery();
            if(rs!=null && rs.next())
                return true;
            getClose();
        } catch (Exception e) {
        }
        return false;
    } 
}
