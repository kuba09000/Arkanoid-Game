/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package pl.polsl.Jakub.Lapaj.Model;

import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * Tests of the Model class methods
 * @author Jakub Łapaj
 */
public class ModelTest {
    
    public ModelTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of addBlock method, of class Model.
     * @param a parameters given in ValueSource 
     */
    @org.junit.jupiter.params.ParameterizedTest
    @ValueSource(ints={-20,0,550,600,800,900})
    public void testAddBlock(int a) {
        System.out.println("addBlock");
        //given
        int x = a;
        int y = a;
        Model instance = new Model();
        //when
        instance.addBlock(x, y);
        //then
        assertTrue((x>=0 && x<=800) && (y>=0 && y<=600),"Block out of screen"); 
    }    
}
