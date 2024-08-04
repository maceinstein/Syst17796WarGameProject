/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class WarGame extends Game{
    
    private GroupOfCards deck;
    private int player1RoundsWon = 0;
    private int player2RoundsWon = 0;

    public WarGame(String name) {
        super(name);
        this.deck = new GroupOfCards(52); // Initialize with standard deck size of 52 cards
    }
    
    public boolean verifyUsername(String username) {
        for (Player player : getPlayers()) {
            if (((WarPlayer) player).getUsername().equals(username)) {
                return false; // Username is taken
            }
        }
        return true; // Username is unique
    }
   public boolean validatePassword(String password) {
    if (password.length() <= 8) {
        System.out.println("Password must be longer than 8 characters.");
        System.out.println("");
        return false;
    }

    boolean hasSpecial = false;
    for (int i = 0; i < password.length(); i++) {
        char c = password.charAt(i);
        if (!Character.isLetterOrDigit(c)) {
            hasSpecial = true;
            break;
        }
    }

    if (!hasSpecial) {
        System.out.println("Password must contain at least one special character.");
        System.out.println("");
        
        return false;
    }

    return true;
    }
      
        
    
    public void shuffleDeck() {
        deck.shuffle();
    }

    public void distributeCards(WarPlayer player1, WarPlayer player2) {
        deck.deal(player1, player2);
    }

    public int compareCards(WarCard card1, WarCard card2) {
        return Integer.compare(card1.getRankValue(), card2.getRankValue());
    }
    
    public void triggerWar(WarPlayer player1, WarPlayer player2) {
    // Check if either player has fewer than 4 cards left
    if (player1.getHand().size() < 4 || player2.getHand().size() < 4) {
        return; // End the war if not enough cards to proceed
    }

    ArrayList<WarCard> warPile = new ArrayList<>();

    // Each player places three cards face down
    for (int i = 0; i < 3; i++) {
        warPile.add(player1.playCard());
        warPile.add(player2.playCard());
    }

    // Each player places one card face up to determine the winner of the war
    WarCard warCard1 = player1.playCard();
    WarCard warCard2 = player2.playCard();
    warPile.add(warCard1);
    warPile.add(warCard2);

    
    int result = compareCards(warCard1, warCard2);
    if (result > 0) {
        player1.getHand().addAll(warPile);
        player1RoundsWon++;
    } else if (result < 0) {
        player2.getHand().addAll(warPile);
         player2RoundsWon++;
    } else {
        triggerWar(player1, player2);
    }
 }
    
    @Override
    public void declareWinner() {
        WarPlayer player1 = (WarPlayer) getPlayers().get(0);
        WarPlayer player2 = (WarPlayer) getPlayers().get(1);
        
        WarPlayer winner;
        if (player1RoundsWon > player2RoundsWon) {
            winner = player1;
        } else if (player2RoundsWon > player1RoundsWon) {
            winner = player2;
        } else {
            // If rounds won are tied, decide based on card count
            if (player1.getHand().size() > player2.getHand().size()) {
                winner = player1;
            } else {
                winner = player2;
            }
        }

        detectWinner(winner);
    }

    @Override
    public void play() {
        WarPlayer player1 = (WarPlayer) getPlayers().get(0);
        WarPlayer player2 = (WarPlayer) getPlayers().get(1);

        while (!player1.getHand().isEmpty() && !player2.getHand().isEmpty()) {
            WarCard card1 = player1.playCard();
            WarCard card2 = player2.playCard();

            System.out.println("");
            System.out.println("---------------------");
            System.out.println(player1.getUsername() + " plays: " + card1);
            System.out.println(player2.getUsername() + " plays: " + card2);

            int result = compareCards(card1, card2);
            if (result > 0) {
                System.out.println(player1.getUsername() + " wins the round.");
                System.out.println("---------------------");
                player1.addCardToHand(card1);
                player1.addCardToHand(card2);
                player1RoundsWon++;
            } else if (result < 0) {
                System.out.println(player2.getUsername() + " wins the round.");
                System.out.println("---------------------");
                player2.addCardToHand(card1);
                player2.addCardToHand(card2);
                 player2RoundsWon++;
            } else {
                System.out.println("War! Both players played " + card1.getRank());
                System.out.println("---------------------");
                triggerWar(player1, player2);
            }
        }

        declareWinner();
    }
    
    
    public void detectWinner(WarPlayer winner) {
        System.out.println("");
        System.out.println("The winner of the game is: " + winner.getUsername());
       
    }
    
}
