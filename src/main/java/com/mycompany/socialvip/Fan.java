/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.socialvip;

import com.mycompany.socialvip.Obs.Observer;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Fabo
 */
public class Fan implements Observer{
    
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


    @Override
    public void sendNotification(String notification, int amount, String celeb) {
        
        switch (notification){
            
            case ("LIKES") -> {
                JOptionPane.showMessageDialog(null, celeb + " has reached " + amount + " likes", this.getName(), JOptionPane.INFORMATION_MESSAGE);                  
            }
            case ("FOLLOWERS") -> {
                JOptionPane.showMessageDialog(null, celeb + " has reached " + amount + " followers", this.getName(), JOptionPane.INFORMATION_MESSAGE);
            }
        }       
    }
    
    
    
    
}
