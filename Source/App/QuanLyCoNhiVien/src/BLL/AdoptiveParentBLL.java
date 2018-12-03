/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.AdoptiveParentDAL;
import Entity.AdoptiveParent;
import java.util.ArrayList;

/**
 *
 * @author Bui Thi Huyen Tran
 */
public class AdoptiveParentBLL {
    AdoptiveParentDAL DAL =new AdoptiveParentDAL();
    //Hiện thị danh sách người nhận trẻ
    public ArrayList<AdoptiveParent> LoadAdoptiveParent()
    {
        return DAL.LoadAdoptiveParent();
    }
    //Thêm người nhận trẻ
    public boolean InsertAdoptiveParent(String name ,String address , String phonenumber)
    {
        return DAL.InsertAdoptiveParent(name, address, phonenumber);
    }
    //Cập nhật người nhận trẻ
    public boolean UpdateAdoptiveParent(int id ,String name ,String address ,String phonenumber)
    {
        return DAL.UpdateAdoptiveParent(id, name, address, phonenumber);
    }
    
}
