/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.StaffCategogyDAL;
import Entity.StaffCategogy;
import java.util.ArrayList;

/**
 *
 * @author Bui Thi Huyen Tran
 */
public class StaffCategogyBLL {
    StaffCategogyDAL DAL =new StaffCategogyDAL();
    //load loại nhân viên
    public ArrayList<StaffCategogy> LoadStaffCategogy()
    {
        return DAL.LoadStaffCategogy();
    }
    //Thêm loại nhân viên
    public boolean InsertStaffCategogy(String name)
    {
        return DAL.InsertStaffCategogy(name);
    }
    //Cập nhật loại nhân viên
    public boolean UpdateStaffCategogy(int id,String name)
    {
        return DAL.UpdateStaffCtegogy(id, name);
    }
    //Xóa loại nhân viên
    public boolean DeleteStaffCategogy(int id)
    {
        return DAL.DeleteStaffCategogy(id);
    }
    //Tìm loại nhân viên
    public ArrayList<StaffCategogy> SearchStaffCategogy(String key )
    {
        return DAL.SearchStaffCategogy(key);
    }
}
