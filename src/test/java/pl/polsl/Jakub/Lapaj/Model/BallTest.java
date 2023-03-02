/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package pl.polsl.Jakub.Lapaj.Model;

import java.awt.Rectangle;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * Tests of the Ball class methods
 * @author Jakub Łapaj
 */
public class BallTest {
    
    public BallTest() {
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
     * Parameterized test of left method, of class Ball.
     * @param a parameters given in ValueSource 
     */
    @org.junit.jupiter.params.ParameterizedTest
    @ValueSource(ints={5,10,150,790,850})
    public void testLeft(int a) {
        System.out.println("left");
        //given
        Ball instance = new Ball(a,0);
        //when
         int result = (int) instance.left();
        //then
        assertTrue(result>=0,"Out of screen range");
        assertTrue(result<=780,"Out of screen range");
    }
    
    /**
     * Parameterized test of right method, of class Ball.
     * @param a parameters given in ValueSource 
     */
    @org.junit.jupiter.params.ParameterizedTest
    @ValueSource(ints={5,10,150,790,850})
    public void testRight(int a) {
        System.out.println("right");
        //given
        Ball instance = new Ball(a,0);
        //when
        int result = (int) instance.right();
        //then
        assertTrue(result>=20,"Out of screen range");
        assertTrue(result<=800,"Out of screen range");
    }
    
    /**
     * Parameterized test of top method, of class Ball.
     * @param a parameters given in ValueSource 
     */
    @org.junit.jupiter.params.ParameterizedTest
    @ValueSource(ints={5,10,150,590,800})
    public void testTop(int a) {
        System.out.println("top");
        //given
        Ball instance = new Ball(0,a);
        //when
         int result = (int) instance.top();
        //then
        assertTrue(result>=0,"Out of screen range");
        assertTrue(result<=580,"Out of screen range");
    }
    
    /**
     * Parameterized test of bottom method, of class Ball.
     * @param a parameters given in ValueSource 
     */
    @org.junit.jupiter.params.ParameterizedTest
    @ValueSource(ints={5,10,150,590,800})
    public void testBottom(int a) {
        System.out.println("top");
        //given
        Ball instance = new Ball(0,a);
        //when
         int result = (int) instance.bottom();
        //then
        assertTrue(result>=20,"Out of screen range");
        assertTrue(result<=600,"Out of screen range");
    }

    /**
     * Test of testCollisionWithBlocks method, of class Ball.
     * @param a parameters given in ValueSource 
     */
    @org.junit.jupiter.params.ParameterizedTest
    @ValueSource(ints={5,400,700})
    public void testTestCollisionWithBlocks(int a) {
        System.out.println("testCollisionWithBlocks");
        //given
        Block mBrick = new Block(400,400);
        Ball mBall = new Ball(a,a);
        Ball instance = mBall;
        //when
        instance.testCollisionWithBlocks(mBrick, mBall);
        //then
        assertFalse(new Rectangle(mBall.getX(),mBall.getY(),10,10).intersects(new Rectangle(mBrick.getX(),mBrick.getY(),60,20)),"Block collides with the ball");
    }

    /**
     * Test of testCollisionWithPaddle method, of class Ball.
     * @param a parameters given in ValueSource 
     */
    @org.junit.jupiter.params.ParameterizedTest
    @ValueSource(ints={5,400,700})
    public void testTestCollisionWithPaddle(int a) {
        System.out.println("testCollisionWithPaddle");
        //given
        Model mPaddle = new Model();
        Ball mBall = new Ball(a,600);
        Ball instance = new Ball(0,0);
        //when
        instance.testCollisionWithPaddle(mPaddle, mBall);
        //then
        assertFalse(new Rectangle(mBall.getX(),mBall.getY(),10,10).intersects(new Rectangle(mPaddle.getX(),mPaddle.getY(),60,20)),"Paddle collides with ball");
    }
    
}
