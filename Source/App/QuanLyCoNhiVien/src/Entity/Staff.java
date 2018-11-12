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
public class Staff {
    private int ID ;
    private String Name ;
    private String Sex ;
    private Date Birthday ;
    private String Address ;
    private String PhoneNumber ;
    private Date StartWork ;
    private String NameStaffCategogy ;

    /**
     * @return the ID
     */
    public int getID() {
        return ID;
    }

    /**
     * @param ID the ID to set
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * @return the Name
     */
    public String getName() {
        return Name;
    }

    /**
     * @param Name the Name to set
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     * @return the Sex
     */
    public String getSex() {
        return Sex;
    }

    /**
     * @param Sex the Sex to set
     */
    public void setSex(String Sex) {
        this.Sex = Sex;
    }

    /**
     * @return the Birthday
     */
    public Date getBirthday() {
        return Birthday;
    }

    /**
     * @param Birthday the Birthday to set
     */
    public void setBirthday(Date Birthday) {
        this.Birthday = Birthday;
    }

    /**
     * @return the Address
     */
    public String getAddress() {
        return Address;
    }

    /**
     * @param Address the Address to set
     */
    public void setAddress(String Address) {
        this.Address = Address;
    }

    /**
     * @return the PhoneNumber
     */
    public String getPhoneNumber() {
        return PhoneNumber;
    }

    /**
     * @param PhoneNumber the PhoneNumber to set
     */
    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    /**
     * @return the StartWork
     */
    public Date getStartWork() {
        return StartWork;
    }

    /**
     * @param StartWork the StartWork to set
     */
    public void setStartWork(Date StartWork) {
        this.StartWork = StartWork;
    }

    /**
     * @return the NameStaffCategogy
     */
    public String getNameStaffCategogy() {
        return NameStaffCategogy;
    }

    /**
     * @param NameStaffCategogy the NameStaffCategogy to set
     */
    public void setNameStaffCategogy(String NameStaffCategogy) {
        this.NameStaffCategogy = NameStaffCategogy;
    }
}
