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
public class Child {
    private int ID;
    private String Name ;
    private String Sex ;
    private Date Birthday ;
    private Date JoinDate ;
    private String Situation ;
    private String WhoBring;
    private String Status ;
    private String NameStaff;

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
     * @return the JionDate
     */
    public Date getJoinDate() {
        return JoinDate;
    }

    /**
     * @param JionDate the JionDate to set
     */
    public void setJoinDate(Date JionDate) {
        this.JoinDate = JionDate;
    }

    /**
     * @return the Situation
     */
    public String getSituation() {
        return Situation;
    }

    /**
     * @param Situation the Situation to set
     */
    public void setSituation(String Situation) {
        this.Situation = Situation;
    }

    /**
     * @return the WhoBring
     */
    public String getWhoBring() {
        return WhoBring;
    }

    /**
     * @param WhoBring the WhoBring to set
     */
    public void setWhoBring(String WhoBring) {
        this.WhoBring = WhoBring;
    }

    /**
     * @return the Status
     */
    public String getStatus() {
        return Status;
    }

    /**
     * @param Status the Status to set
     */
    public void setStatus(String Status) {
        this.Status = Status;
    }

    /**
     * @return the NameStaff
     */
    public String getNameStaff() {
        return NameStaff;
    }

    /**
     * @param NameStaff the NameStaff to set
     */
    public void setNameStaff(String NameStaff) {
        this.NameStaff = NameStaff;
    }

    
    
}
