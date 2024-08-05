/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ca.sheridancollege.project;
/**
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
*/

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
public class MainTest {
    
    public MainTest() {
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
     * Test of verifyUsername method, of class Main.
    @Test
    public void testMain() {
       System.out.println("main");
       String[] args = null;
       Main.main(args);
       fail("The test case is a prototype.");
    }
    */
    @Test
    public void testVerifyUsernameGood() {
        System.out.println("verifyUsername Good");
        String username = "sheridian"; //good Username
        boolean expResult = true;
        boolean result = Main.verifyUsername(username);
        assertEquals(expResult, result); 
    }
    @Test
    public void testVerifyUsernameBad() {
        
        System.out.println("verifyUsername Bad");
        String username = "bot"; //Bad Username
        boolean expResult = false;
        boolean result = Main.verifyUsername(username);
        assertEquals(expResult, result); 
     
    }
    @Test
    public void testVerifyUsernameBoundary() {
        System.out.println("verifyUsername Boundary");
        String username = "bot2"; //Samilar Username
        boolean expResult = true;
        boolean result = Main.verifyUsername(username);
        assertEquals(expResult, result); 
    }
}
