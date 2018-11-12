/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.StaffDAL;
import Entity.Staff;
import java.util.ArrayList;

/**
 *
 * @author Bui Thi Huyen Tran
 */
public class SatffBLL {
     StaffDAL DAL=new StaffDAL();
    //Load nhân viên
    public ArrayList<Staff> LoadStaff()
    {
        return DAL.LoadStaff();
    }
    //thêm nhân viên
    public boolean InsertStaff(String name , String sex ,String birthday ,String address ,String phonenumber , String startwork ,String namestaffcategogy)
    {
        return DAL.InertStaff(name, sex, birthday, address, phonenumber, startwork, namestaffcategogy);
    }
    //cập nhật nhân viên
    public boolean UpdateStaff(int id,String name , String sex ,String birthday ,String address ,String phonenumber , String startwork ,String namestaffcategogy)
    {
        return DAL.UpdateStaff(id, name, sex, birthday, address, phonenumber, startwork, namestaffcategogy);
    }
    //Xóa nhân viên
    public boolean  DeleteStaff(int id)
    {
        return DAL.DeleteStaff(id);
    }
}
