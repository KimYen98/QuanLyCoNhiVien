/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.SponsorDAL;
import Entity.Sponsor;
import java.util.ArrayList;

/**
 *
 * @author Bui Thi Huyen Tran
 */
public class SponsorBLL {
    SponsorDAL DAL=new SponsorDAL();
    //Hiện thị danh sách nhà tài trợ
    public ArrayList<Sponsor> LoadSponsor()
    {
        return  DAL.LoadSponsor();
    }
    //Thêm nhà tài trợ
    public boolean InsertSponsor(String name , String phonenumber ,String address)
    {
        return DAL.InsertSponsor(name, phonenumber, address);
    }
    //Cập nhật nhà tài trợ
    public boolean UpdateSponsor(int id,String name , String phonenumber , String address)
    {
        return DAL.UpdateSponsor(id, name, phonenumber, address);
    }
    //Xóa nhà trợ
    public boolean  DeleteSponsor(int id)
    {
        return DAL.DeleteSponsor(id);
    }
    //Tìm nhà tài trợ
    public ArrayList<Sponsor> SearchSponsor(String key)
    {
        return DAL.SearchSposor(key);
    }
    //Lấy mã nhà tài trợ theo tên nhà tài trợ
    public int getIdSponsor(String name)
    {
        return DAL.getIdSponsor(name);
    }
}
