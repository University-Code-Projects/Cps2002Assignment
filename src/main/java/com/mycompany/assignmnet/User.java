/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.assignmnet;
import java.util.*;
/**
 *
 * @author jonathan
 */
public class User {
    
    private String name;
    private String surname;
    private String address;
    private String email;
    private int id;
    private String nationality;
    private Date dob; 

    public User(){
        
    }

    public User(String name, String surname, int id) {
        this.name = name;
        this.surname = surname;
        this.id = id;
        this.address = "Unknown";
        this.address = "Unknown";
    }

    public User(String name, String surname, String address, String email, int id, String nationality, Date dob) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.email = email;
        this.id = id;
        this.nationality = nationality;
        this.dob = dob;
    }
    
    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public int getId() {
        return id;
    }

    public String getNationality() {
        return nationality;
    }

    public Date getDob() {
        return dob;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }   
}
