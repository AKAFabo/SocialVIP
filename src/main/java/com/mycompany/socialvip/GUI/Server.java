/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.socialvip.GUI;

import com.mycompany.socialvip.Celebrity;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fabo
 */
public class Server {
    
    private ServerSocket serverSocket;
    private static ArrayList<ObjectOutputStream> clients = new ArrayList<>();
    private int clientsOnline = 1;
    
    private final static int NEW_CELEBRITY = 1;
    private final static int NEW_POST = 2;
    private final static int REACHED_LIKES = 3;
    private final static int REACHED_FOLLOWERS = 4;
    private final static int LIKE_RECEIVED = 5;
    private final static int FOLLOW_RECEIVED = 6;
    
    public Server(int port) {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server is running on port " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                ObjectOutputStream clientOut = new ObjectOutputStream(clientSocket.getOutputStream());
                clients.add(clientOut);               
                System.out.println("Client #" + clientsOnline + " joined");
                clientsOnline++;

                ClientHandler handler = new ClientHandler(clientSocket);
                new Thread(handler).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        int port = 1234;
        new Server(port);
    }
    
    private static class ClientHandler implements Runnable {        
        private Socket socket;
        private ObjectInputStream inputStream;
        
        public ClientHandler(Socket clientSocket) {
            socket = clientSocket;
            try {
                inputStream = new ObjectInputStream(socket.getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            try {
                while (true) {
                    
                    int option = inputStream.readInt();
                    
                    switch (option){
                        case (NEW_CELEBRITY) -> {
                            Celebrity celebrity = (Celebrity)inputStream.readObject();
                            registerCelebrity(celebrity);
                        }
                        case (NEW_POST) -> {                           
                            String message = inputStream.readUTF();
                            Celebrity celebrity = (Celebrity)inputStream.readObject();                            
                            sendNewPost(message, celebrity);                                                                                
                        }  
                        case (REACHED_LIKES) ->{
                            int likes = inputStream.readInt();
                            String celeb = inputStream.readUTF();
                            likesGoalReached(likes, celeb);
                        }
                        
                        case (REACHED_FOLLOWERS) -> {
                            int followers = inputStream.readInt();
                            String celeb = inputStream.readUTF();
                            followersGoalReached(followers, celeb);
                        }
                        case (LIKE_RECEIVED) -> {
                            int likes = inputStream.readInt();
                            String fullMSG = inputStream.readUTF();
                            String oldMSG = inputStream.readUTF();
                            Celebrity celeb = (Celebrity)inputStream.readObject();
                            registerLike(likes, fullMSG, oldMSG, celeb);
                        }
                        case (FOLLOW_RECEIVED) -> {
                            int followers = inputStream.readInt();
                            Celebrity celeb = (Celebrity)inputStream.readObject();                           
                            registerFollow(followers, celeb);
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    public static void sendNewPost(String message, Celebrity celebrity){
        
        for (ObjectOutputStream client : clients) {
            try {
                client.writeInt(NEW_POST);
                client.writeUTF(message);
                client.writeObject(celebrity);
                client.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
    }
    
    public static void registerCelebrity(Celebrity celebrity){
        for (ObjectOutputStream client : clients) {
            try {
                client.writeInt(NEW_CELEBRITY);
                client.writeObject(celebrity);
                client.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
    }
    
    public static void likesGoalReached(int likes, String celebName){
        for (ObjectOutputStream client : clients) {
            try {
                client.writeInt(REACHED_LIKES);
                client.writeInt(likes);
                client.writeUTF(celebName);
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }
    
    public static void followersGoalReached(int follower, String celebName){
        for (ObjectOutputStream client : clients) {
            try {
                client.writeInt(REACHED_FOLLOWERS);
                client.writeInt(follower);
                client.writeUTF(celebName);
                client.flush();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }
    
    public static void registerLike(int likes, String fullMSG, String oldMSG, Celebrity celeb){
        
        for (ObjectOutputStream client : clients) {
            try {
                client.writeInt(LIKE_RECEIVED);
                client.writeInt(likes);
                client.writeUTF(fullMSG);
                client.writeUTF(oldMSG);
                client.writeObject(celeb);
                client.flush();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }
    
    public static void registerFollow(int follows, Celebrity celeb){
        for (ObjectOutputStream client : clients) {
            try {
                client.writeInt(FOLLOW_RECEIVED);
                client.writeInt(follows);
                client.writeObject(celeb);
                client.flush();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }
    
}
