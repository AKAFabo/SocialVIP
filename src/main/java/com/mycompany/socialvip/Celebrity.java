/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.socialvip;

import com.mycompany.socialvip.Obs.Observable;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Fabo
 */
public class Celebrity implements Serializable, Observable{
    
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

    @Override
    public void sendNotificaton(String notification, int amount) {
        
        switch (notification){
            
            case ("LIKES") -> {
                JOptionPane.showMessageDialog(null, this.getName() + " has reached " + amount + " likes");                  
            }
            case ("FOLLOWERS") -> {
                JOptionPane.showMessageDialog(null, this.getName() + " has reached " + amount + " followers");
            }
        }       
    }
}
