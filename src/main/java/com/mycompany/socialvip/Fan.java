/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.socialvip;

import java.util.ArrayList;

/**
 *
 * @author Fabo
 */
public class Fan {
    
    private String name;
    private ArrayList<Celebrity> following = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Celebrity> getFollowing() {
        return following;
    }

    public void setFollowing(ArrayList<Celebrity> following) {
        this.following = following;
    }

    public Fan(String name) {
        this.name = name;
    }
    
    
    
}
