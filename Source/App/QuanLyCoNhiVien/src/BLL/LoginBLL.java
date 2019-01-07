/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.LoginDAL;

/**
 *
 * @author Bui Thi Huyen Tran
 */

public class LoginBLL {
    LoginDAL DAL =new LoginDAL();
    public boolean Login(String username ,String password )
    {
        return DAL.Login(username, password);
    }
}
