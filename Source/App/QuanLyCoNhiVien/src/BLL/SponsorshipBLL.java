/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.SponsorDAL;
import DAL.SponsorshipDAL;
import Entity.Sponsorship;
import java.util.ArrayList;

/**
 *
 * @author Bui Thi Huyen Tran
 */
public class SponsorshipBLL {
    SponsorshipDAL DAL= new SponsorshipDAL();
    //Load tài trợ
    public ArrayList<Sponsorship> LoadSponsorship()
    {
        return DAL.LoadSponsorship();
    }
    //Thêm tài trợ
    public boolean Insert(int idsponsor , String date ,String format , float money)
    {
        return DAL.Insert(idsponsor, date, format, money);
    }
    //Cập nhật tài trợ
    public  boolean  Update (int id , int idsponsor ,String date ,String format ,float money)
    {
        return DAL.Update(id, idsponsor,date, format, money);
    }
    //Xóa tài trợ
    public boolean Delete(int idsponsorship,int idsponsor)
    {
        return DAL.Delete(idsponsorship ,idsponsor);
    }
    //Tìm tài trợ
    public ArrayList<Sponsorship> SearchSponsorship(String key )
    {
        return DAL.SearchSponsorShip(key);
    }
}
