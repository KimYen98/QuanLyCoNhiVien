/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.ChildDAL;
import Entity.Child;
import java.util.ArrayList;

/**
 *
 * @author Bui Thi Huyen Tran
 */
public class ChildBLL {
    ChildDAL DAL =new ChildDAL();
    //Load trẻ
    public ArrayList <Child> LoadChild()
    {
        return DAL.LoadChild();
    }
    //Thêm trẻ
    public boolean  InsertChild(String name , String sex , String birthday , String joindate , String situation ,String whobring ,int status , int idstaff  )
    {
        return DAL.InsertChild(name, sex, birthday, joindate, situation, whobring, status, idstaff);
    }
    //Cập nhật trẻ
    public boolean UpdateChild(int id,String name , String sex , String birthday , String joindate , String situation ,String whobring ,int status , int idstaff  )
    {
        return DAL.UpdateChild(id, name, sex, birthday, joindate, situation, whobring, status, idstaff);
    }
    //Tìm trẻ
    public ArrayList<Child> SearchChild(String key)
    {
        return DAL.SearchChild(key);
    }
    //Load trẻ hiện đang ở cô nhi viện
    public ArrayList <Child> LoadChildNow()
    {
        return DAL.LoadChildNow();
    }
    //Lấy mã trẻ theo tên trẻ
    public int getID(String name)
    {
        return DAL.getID(name);
    }
}
