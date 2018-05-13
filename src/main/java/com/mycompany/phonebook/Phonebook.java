/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.phonebook;

import java.io.Serializable;

/**
 *
 * @author hsoleimany
 */
public class Phonebook implements Serializable {

    private int id;

    private String Name;

    private String Family;

    private String Address;

    private String mobile;

    public Phonebook(String Name, String Family, String Address, String mobile) {
        this.Name = Name;
        this.Family = Family;
        this.Address = Address;
        this.mobile = mobile;
    }

    public Phonebook() {
    }

    public Phonebook(int id, String Name, String Family, String Address, String mobile) {
        this.id = id;
        this.Name = Name;
        this.Family = Family;
        this.Address = Address;
        this.mobile = mobile;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getFamily() {
        return Family;
    }

    public void setFamily(String Family) {
        this.Family = Family;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

}
