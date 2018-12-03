/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.Date;

/**
 *
 * @author Bui Thi Huyen Tran
 */
public class AdoptInfo {
    private String NameAdoptiveParent ;
    private String NameChild ;
    private Date AdoptDate;

    /**
     * @return the NameAdoptiveParent
     */
    public String getNameAdoptiveParent() {
        return NameAdoptiveParent;
    }

    /**
     * @param NameAdoptiveParent the NameAdoptiveParent to set
     */
    public void setNameAdoptiveParent(String NameAdoptiveParent) {
        this.NameAdoptiveParent = NameAdoptiveParent;
    }

    /**
     * @return the NameChild
     */
    public String getNameChild() {
        return NameChild;
    }

    /**
     * @param NameChild the NameChild to set
     */
    public void setNameChild(String NameChild) {
        this.NameChild = NameChild;
    }

    /**
     * @return the AdoptDate
     */
    public Date getAdoptDate() {
        return AdoptDate;
    }

    /**
     * @param AdoptDate the AdoptDate to set
     */
    public void setAdoptDate(Date AdoptDate) {
        this.AdoptDate = AdoptDate;
    }
    
}
