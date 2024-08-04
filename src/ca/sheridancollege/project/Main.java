/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class Main {
    public static ArrayList<Player> players = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        WarGame warGame = new WarGame("War Card Game");

        int playerCount = 1;

        System.out.println("=== Welcome to the War Card Game! ===");
        System.out.println("====================================");

        while (playerCount < 2) {
            System.out.println("\n--- Register Player " + (playerCount + 1) + " ---");
            boolean usernameValid; 
            String username;
            do {
                System.out.print("Enter username: ");
                username = scanner.nextLine();
                usernameValid = verifyUsername(username);
                if (!usernameValid) {
                    System.out.println("Username is already taken. Please enter a different username.");
                }
            } while (!usernameValid);

            // Input and validate password
            String password;
            boolean passwordValid;
            do {
                System.out.print("Enter password (must include special characters and be longer than 8 characters): ");
                password = scanner.nextLine();
                passwordValid = warGame.validatePassword(password);
                if (!passwordValid) {
                    System.out.println("Password must include at least one special character and be longer than 8 characters. Please try again.");
                }
            } while (!passwordValid);

            // Create and add the player to the game
            WarPlayer player = new WarPlayer(username, password);
            players.add(player);
           
            playerCount++;
        }

        System.out.println("\n=== All players are registered! ===");
        System.out.println("Starting the game...");

        // Set players for the game
        warGame.setPlayers(players);

        // Initialize and shuffle the deck, then deal cards to players
        warGame.shuffleDeck();
        warGame.distributeCards((WarPlayer) players.get(0), (WarPlayer) players.get(1));

        // Start the game
        warGame.play();

        System.out.println("\n=== Game Over! ===");
        System.out.println("Thank you for playing the War Card Game!");

        
        
    }

    // Validate username
    public static boolean verifyUsername(String name) {
        if (Main.players.isEmpty()) {
            // For testing purposes, we add one player named "bot"
            WarPlayer bot = new WarPlayer("bot", "Passw0rd");
            players.add(bot);
        }

         boolean usernameValid;
        for (Player player : Main.players) {
            if (((WarPlayer) player).getUsername().equals(name)) {
                return false; // Username is taken
            }
        }
        return true; // Username is unique
    }
    
}
