/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A concrete class that represents any grouping of cards for a Game. HINT, you might want to subclass this more than
 * once. The group of cards has a maximum size attribute which is flexible for reuse.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 */
public class GroupOfCards {

    //The group of cards, stored in an ArrayList
    private ArrayList<Card> cards;
    private int size;//the size of the grouping

    public GroupOfCards(int size) {
        this.size = size;
        this.cards = new ArrayList<>(size);
        initializeDeck();
    }

    /**
     * A method that will get the group of cards as an ArrayList
     *
     * @return the group of cards.
     */
    public ArrayList<Card> getCards() {
        return cards;
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    /**
     * @return the size of the group of cards
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the max size for the group of cards
     */
    public void setSize(int size) {
        this.size = size;
    }
    
    public void addCard(Card card) {
        cards.add(card);
    }
    
    public void initializeDeck() {
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};

        // Clear existing cards and set size to 0 before initializing deck
        cards.clear();
        int initialSize = 0;

        for (String suit : suits) {
            for (String rank : ranks) {
                cards.add(new WarCard(rank, suit));
                initialSize++;
            }
        }
        this.size = initialSize; // Update size after deck initialization
    }

    public void deal(WarPlayer player1, WarPlayer player2) {
        shuffle();
        int halfDeckSize = size / 2;
        for (int i = 0; i < halfDeckSize; i++) {
            player1.addCardToHand((WarCard) cards.get(i));
            player2.addCardToHand((WarCard) cards.get(i + halfDeckSize));
        }
    }

}//end class
