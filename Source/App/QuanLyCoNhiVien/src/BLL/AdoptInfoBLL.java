/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.AdoptInfoDAL;
import Entity.AdoptInfo;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author Bui Thi Huyen Tran
 */
public class AdoptInfoBLL {
    AdoptInfoDAL DAL=new AdoptInfoDAL();
    public ArrayList<AdoptInfo> LoadAdoptInfo()
    {
        return  DAL.LoadAdoptInfo();
    }
    public boolean  InsertAdoptInfo(int IdAdoptiveParent, int IdChild , Date AdoptDate)
    {
        return DAL.InsertAdoptInfo(IdAdoptiveParent, IdChild, AdoptDate);
    }
    public boolean  UpdateAdoptInfo(int IdAdoptiveParent, int IdChild , Date AdoptDate)
    {
        return DAL.UpdateAdoptInfo(IdAdoptiveParent, IdChild, AdoptDate);
    }
    public boolean  DeleteAdoptInfo(int IdAdoptiveParent, int IdChild)
    {
        return DAL.DeleteAdoptInfo(IdAdoptiveParent, IdChild);
    }
    public ArrayList<AdoptInfo> SearchAdoptInfo_Child(String key)
    {
        return  DAL.SearchAdoptInfo_Child(key);
    }
     public ArrayList<AdoptInfo> SearchAdoptInfo_Adopt(String key)
    {
        return  DAL.SearchAdoptInfo_Adopt(key);
    }
}
