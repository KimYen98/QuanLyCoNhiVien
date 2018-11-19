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
public class Sponsorship {
    private String  NameSponsor ;
    private int IDSponsorShip;
    private Date SponsorshipDate ;
    private String FormSponsorship;
    private float Money;

    /**
     * @return the NameSponsor
     */
    public String getNameSponsor() {
        return NameSponsor;
    }

    /**
     * @param NameSponsor the NameSponsor to set
     */
    public void setNameSponsor(String NameSponsor) {
        this.NameSponsor = NameSponsor;
    }

    /**
     * @return the IDSponsorShip
     */
    public int getIDSponsorShip() {
        return IDSponsorShip;
    }

    /**
     * @param IDSponsorShip the IDSponsorShip to set
     */
    public void setIDSponsorShip(int IDSponsorShip) {
        this.IDSponsorShip = IDSponsorShip;
    }

    /**
     * @return the SponsorshipDate
     */
    public Date getSponsorshipDate() {
        return SponsorshipDate;
    }

    /**
     * @param SponsorshipDate the SponsorshipDate to set
     */
    public void setSponsorshipDate(Date SponsorshipDate) {
        this.SponsorshipDate = SponsorshipDate;
    }

    /**
     * @return the FormSponsorship
     */
    public String getFormSponsorship() {
        return FormSponsorship;
    }

    /**
     * @param FormSponsorship the FormSponsorship to set
     */
    public void setFormSponsorship(String FormSponsorship) {
        this.FormSponsorship = FormSponsorship;
    }

    /**
     * @return the Money
     */
    public float getMoney() {
        return Money;
    }

    /**
     * @param Money the Money to set
     */
    public void setMoney(float Money) {
        this.Money = Money;
    }

    
}
