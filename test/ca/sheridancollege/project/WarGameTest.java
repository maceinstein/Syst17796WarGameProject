/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package ca.sheridancollege.project;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Yiqing Zhou
 */
public class WarGameTest {
    
    public WarGameTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    /**
    @Test
    public void testVerifyUsername() {
        System.out.println("verifyUsername");
        String username = "";
        WarGame instance = null;
        boolean expResult = false;
        boolean result = instance.verifyUsername(username);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    */
    @Test
    public void testValidatePasswordGood() {
        System.out.println("Test validatePasswordGood");
        String password = "Passw0rd@";
        WarGame instance = new WarGame("TestWarGame");
        boolean expResult = true;
        boolean result = instance.validatePassword(password);
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testValidatePasswordBad() {
        System.out.println("Test validatePasswordBad");
        String password = "Passw0rd";
        WarGame instance = new WarGame("TestWarGame");
        boolean expResult = false;
        boolean result = instance.validatePassword(password);
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testValidatePasswordBoundary() {
        System.out.println("Test validatePasswordBoundary");
        String password = "";
        WarGame instance = new WarGame("TestWarGame");
        boolean expResult = false;
        boolean result = instance.validatePassword(password);
        assertEquals(expResult, result);
        // fail("The test case is a prototype.");
    }
    /**
    @Test
    public void testShuffleDeck() {
        System.out.println("shuffleDeck");
        WarGame instance = null;
        instance.shuffleDeck();
        fail("The test case is a prototype.");
    }

    @Test
    public void testDistributeCards() {
        System.out.println("distributeCards");
        WarPlayer player1 = null;
        WarPlayer player2 = null;
        WarGame instance = null;
        instance.distributeCards(player1, player2);
        fail("The test case is a prototype.");
    }
    * */
    
    @Test
    public void testCompareCardsGood() {
        //good = bigger
        System.out.println("compareCards Good");
        WarCard card1 = new WarCard("10", "Diamond");
        WarCard card2 = new WarCard("5", "Diamond");
        WarGame instance = new WarGame("TestWarGame");
        int expResult = 1;
        int result = instance.compareCards(card1, card2);
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testCompareCardsBad() {
        //Bad = smaller
        System.out.println("compareCards Bad");
        WarCard card1 = new WarCard("2", "Diamond");
        WarCard card2 = new WarCard("5", "Diamond");
        WarGame instance = new WarGame("TestWarGame");
        int expResult = -1;
        int result = instance.compareCards(card1, card2);
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testCompareCardsBoundary() {
        //boundery = equal
        System.out.println("compareCards Boundary");
        WarCard card1 = new WarCard("5", "Club");
        WarCard card2 = new WarCard("5", "Diamond");
        WarGame instance = new WarGame("TestWarGame");
        int expResult = 0;
        int result = instance.compareCards(card1, card2);
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }
    
    /**
    @Test
    public void testTriggerWar() {
        System.out.println("triggerWar");
        WarPlayer player1 = null;
        WarPlayer player2 = null;
        WarGame instance = null;
        instance.triggerWar(player1, player2);
        fail("The test case is a prototype.");
    }

    @Test
    public void testDeclareWinner() {
        System.out.println("declareWinner");
        WarGame instance = null;
        instance.declareWinner();
        fail("The test case is a prototype.");
    }

    @Test
    public void testPlay() {
        System.out.println("play");
        WarGame instance = null;
        instance.play();
        fail("The test case is a prototype.");
    }

    @Test
    public void testDetectWinner() {
        System.out.println("detectWinner");
        WarPlayer winner = null;
        WarGame instance = null;
        instance.detectWinner(winner);
        fail("The test case is a prototype.");
    }
    */
}
