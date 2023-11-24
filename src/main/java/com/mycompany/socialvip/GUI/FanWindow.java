/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.socialvip.GUI;

import com.mycompany.socialvip.Celebrity;
import com.mycompany.socialvip.Fan;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author Fabo
 */
public class FanWindow extends javax.swing.JFrame {

    /**
     * Creates new form FanWindow
     */
    public FanWindow() {
        initComponents();
        
        try {
            socket = new Socket("localhost", 1234);
            input = new ObjectInputStream(socket.getInputStream());
            output = new ObjectOutputStream(socket.getOutputStream());
            
            new Thread(new ClientHandler()).start();
        } catch (IOException e){
            e.printStackTrace();         
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        messagesPanel = new javax.swing.JPanel();
        celebMessagesPanel = new javax.swing.JPanel();
        celebritiesToFollowPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setText("Social VIP");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 158, 31));

        javax.swing.GroupLayout messagesPanelLayout = new javax.swing.GroupLayout(messagesPanel);
        messagesPanel.setLayout(messagesPanelLayout);
        messagesPanelLayout.setHorizontalGroup(
            messagesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 569, Short.MAX_VALUE)
        );
        messagesPanelLayout.setVerticalGroup(
            messagesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        getContentPane().add(messagesPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(441, 539, -1, -1));

        celebMessagesPanel.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout celebMessagesPanelLayout = new javax.swing.GroupLayout(celebMessagesPanel);
        celebMessagesPanel.setLayout(celebMessagesPanelLayout);
        celebMessagesPanelLayout.setHorizontalGroup(
            celebMessagesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 566, Short.MAX_VALUE)
        );
        celebMessagesPanelLayout.setVerticalGroup(
            celebMessagesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 431, Short.MAX_VALUE)
        );

        getContentPane().add(celebMessagesPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, -1, -1));

        celebritiesToFollowPanel.setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout celebritiesToFollowPanelLayout = new javax.swing.GroupLayout(celebritiesToFollowPanel);
        celebritiesToFollowPanel.setLayout(celebritiesToFollowPanelLayout);
        celebritiesToFollowPanelLayout.setHorizontalGroup(
            celebritiesToFollowPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 404, Short.MAX_VALUE)
        );
        celebritiesToFollowPanelLayout.setVerticalGroup(
            celebritiesToFollowPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 431, Short.MAX_VALUE)
        );

        getContentPane().add(celebritiesToFollowPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 80, -1, -1));

        jLabel2.setText("Posts:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        jLabel3.setText("Celebrities to follow:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(326, 517, -1, -1));

        jLabel4.setText("Celebrities to follow:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 60, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FanWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FanWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FanWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FanWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run(){
                
                String userName = JOptionPane.showInputDialog(null, "Type your username: ");
                
                FanWindow fw = new FanWindow();
                fw.setTitle(userName);
                fw.setVisible(true);
                currentFan.setName(userName);
                messagesPanel.setLayout(new BoxLayout(messagesPanel, BoxLayout.Y_AXIS));
                celebMessagesPanel.setLayout(new BoxLayout(celebMessagesPanel, BoxLayout.Y_AXIS));
                celebritiesToFollowPanel.setLayout(new BoxLayout(celebritiesToFollowPanel, BoxLayout.Y_AXIS));
            }
        });
    }
    
    private class ClientHandler implements Runnable{

        @Override
        public void run() {
            try {
                while (true) {
                    int option = input.readInt();
                    
                    switch(option) {
                        case (NEW_CELEBRITY) -> {
                            
                            Celebrity celeb = (Celebrity)input.readObject();
                            celebrities.add(celeb);
                            
                            JButton celebrityBox = new JButton();
                            celebrityBox.setText(celeb.getName());
                            celebrityBox.putClientProperty("Followers", 0);
                            celebrityBox.putClientProperty("Celebrity", celeb.getName());
                            celebrityBox.putClientProperty("Followed", "False");
                            celebritiesToFollowPanel.add(celebrityBox);
                            celebritiesToFollowPanel.revalidate();
                            celebritiesToFollowPanel.repaint();
                            System.out.println("Llegue aqui");
                            
                            //TODO -> Add following status check
                            
                            celebrityBox.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    
                                    if (celebrityBox.getClientProperty("Followed").equals("False")){
                                        int option = JOptionPane.showConfirmDialog(null, "Follow this celebrity?", "Confirmation",
                                                JOptionPane.YES_NO_OPTION);
                                       if (option == JOptionPane.YES_OPTION){
                                        celebrityBox.putClientProperty("Followed", "True");
                                        followingList.add(celeb);
                                       }
                                    } else {
                                        int option = JOptionPane.showConfirmDialog(null, "Unfollow this celebrity?", "Confirmation",
                                                JOptionPane.YES_NO_OPTION);      
                                        if (option == JOptionPane.YES_OPTION){
                                            celebrityBox.putClientProperty("Followed", "False");
                                            followingList.remove(celeb);
                                        }
                                    }
                                }                                                        
                            });
                        }
                        case (NEW_POST) -> {
                            
                            String message = input.readUTF();
                            Celebrity celeb = (Celebrity)input.readObject();
                            
                            JButton celebMessage = new JButton();
                            celebMessage.putClientProperty("Likes", 0);
                            celebMessage.setText(celeb.getName() + ": " + message + " " + celebMessage.getClientProperty("Likes") + " likes.");
                            
                            for (Celebrity celebrity : followingList){
                                
                                if (celebrity.getName().equals(celeb.getName())){
                            
                                    celebMessagesPanel.add(celebMessage);
                                    celebMessagesPanel.revalidate();
                                    celebMessagesPanel.repaint();
                                    
                                    celebMessage.addActionListener(new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            UIManager.put("OptionPane.yesButtonText", "Like");
                                            UIManager.put("OptionPane.noButtonText", "Dislike");
                                            
                                            int option = JOptionPane.showConfirmDialog(null, "Like/Dislike this post",
                                                    "Like", JOptionPane.YES_NO_OPTION);
                                            
                                            int currentLikes = (int) celebMessage.getClientProperty("Likes");
                                            
                                            if (option == JOptionPane.YES_OPTION){
                                                celebMessage.setText(celeb.getName() + ": " + message + " " + ++currentLikes + " likes.");
                                                celebMessage.putClientProperty("Likes", currentLikes);
                                                celebMessagesPanel.revalidate();
                                                celebMessagesPanel.repaint();
                                            } else {
                                                celebMessage.setText(celeb.getName() + ": " + message + " " + --currentLikes + " likes.");
                                                celebMessage.putClientProperty("Likes", currentLikes);
                                                celebMessagesPanel.revalidate();
                                                celebMessagesPanel.repaint();
                                            }
                                        }
                                    });
                                    
                                }
                            }
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FanWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    
    private static Fan currentFan = new Fan(" ");
    private static ArrayList<Celebrity> followingList = new ArrayList<>();
    private static ArrayList<Celebrity> celebrities = new ArrayList<>();
    
    private final static int NEW_CELEBRITY = 1;
    private final static int NEW_POST = 2;
    
    private ObjectOutputStream output;
    private ObjectInputStream input;
    private Socket socket;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JPanel celebMessagesPanel;
    private static javax.swing.JPanel celebritiesToFollowPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private static javax.swing.JPanel messagesPanel;
    // End of variables declaration//GEN-END:variables
}