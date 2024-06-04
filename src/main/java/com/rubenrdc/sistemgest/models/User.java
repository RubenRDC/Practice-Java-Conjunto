/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rubenrdc.sistemgest.models;

/**
 *
 * @author Ruben
 */
public class User {
    private int id;
    private String name,subname,tell,email;
    private String row[]=new String[4];
    
    public User(int id,String name, String subname, String tell, String email) {
        this.id = id;
        this.name = name;
        this.subname = subname;
        this.tell = tell;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubname() {
        return subname;
    }

    public void setSubname(String subname) {
        this.subname = subname;
    }

    public String getTell() {
        return tell;
    }

    public void setTell(String tell) {
        this.tell = tell;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String[] getRow(){
        row[0]=name;
        row[1]=subname;
        row[2]=email;
        row[3]=tell;
        return row;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
 
    
    public String getString(){
        return id+" "+name+" "+subname+" "+email+" "+tell;
    }
}
