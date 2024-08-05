/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 *
 * @author harneet
 */
public class WarPlayer extends Player{
    
    private String username;
    private String password;
    private ArrayList<WarCard> hand;

    public WarPlayer(String username, String password) {
        super(username);
        this.username = username;
        this.password = password;
        this.hand = new ArrayList<>();
    }
    
    

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<WarCard> getHand() {
        return hand;
    }

    public void addCardToHand(WarCard card) {
        hand.add(card);
    }
    
    public WarCard playCard() {
        if (!hand.isEmpty()) {
            return hand.remove(0);
        }
        return null;
    }
    
    @Override
    public void play() {
        // Implement game-specific play logic if needed
        playCard();
    }
    
}
