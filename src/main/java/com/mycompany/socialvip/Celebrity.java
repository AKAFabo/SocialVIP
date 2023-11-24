/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.socialvip;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Fabo
 */
public class Celebrity implements Serializable{
    
    private String name;
    private int numberOfFollowers = 0;
    private ArrayList<Fan> followers = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfFollowers() {
        return numberOfFollowers;
    }

    public void setNumberOfFollowers(int numberOfFollowers) {
        this.numberOfFollowers = numberOfFollowers;
    }

    public ArrayList<Fan> getFollowers() {
        return followers;
    }

    public void setFollowers(ArrayList<Fan> followers) {
        this.followers = followers;
    }

    public Celebrity(String name) {
        this.name = name;
    }
    
    
    
}
