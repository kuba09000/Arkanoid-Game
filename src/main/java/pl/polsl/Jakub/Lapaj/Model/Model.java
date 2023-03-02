package pl.polsl.Jakub.Lapaj.Model;

import Exceptions.WrongValueException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;

/**
 * Model class
 * @author Jakub Łapaj
 */
public class Model extends Observable {
    private int x, y, width, height, velocity;
    private final int PADDLE_WIDTH = 60, PADDLE_HEIGHT = 20;
    private int rows = 3;

    private boolean win = false;

    private int score = 0;

    private List<Block> blocks;
    private Ball ball;

    /**
     * constructor of the model object
     */
    public Model() {
        this.width = PADDLE_WIDTH;
        this.height = PADDLE_HEIGHT;
        this.x = 400;
        this.y = 600;
        
        blocks = new ArrayList<>();
        ball = new Ball(400, 350);
    }

    /**
     * adds block to the map
     * @param x horizontal position of the blockS
     * @param y vertical position of the block
     */
    public void addBlock(int x, int y) {
        blocks.add(new Block(x, y));

        setChanged();
        notifyObservers();
    }
    
    //Getters and setters
    /**
     * Gets the horizontal coordinate of the paddle
     * @return horizontal coordinate of the paddle
     */
    public int getX() {
        return x;
    }

    /**
     * Sets the horizontal coordinate of the paddle
     * @param x horizontal coordinate of the paddle
     */
    public void setX(int x) {
        this.x = x;

        setChanged();
        notifyObservers();
    }

    /**
     * Gets the vertical coordinate of the paddle
     * @return vertical parameter of the paddle
     */
    public int getY() {
        return y;
    }

    /**
     * Sets vertical coordinate of the paddle
     * @param y vertical coordinate
     */
    public void setY(int y) {
        this.y = y;

        setChanged();
        notifyObservers();
    }

    /**
     * Gets the width of the paddle
     * @return width of the paddle
     */
    public int getWidth() {
        return width;
    }

    /**
     * Sets width of the paddle
     * @param width width of the paddle
     */
    public void setWidth(int width) {
        if(width >0){
            this.width = width;
        }
        

        setChanged();
        notifyObservers();
    }
    
    /**
     * Gets height of the paddle
     * @return height of the paddle
     */
    public int getHeight() {
        return height;
    }

    /**
     * Sets height of the paddle height
     * @param height paddle height
     */
    public void setHeight(int height) {
        this.height = height;

        setChanged();
        notifyObservers();
    }
    
    /**
     * Gets score of the game
     * @return score of the game
     */
    public int getScore() {
        return score;
    }

    /**
     * Sets score of the game
     * @param score actual score of the game
     */
    public void setScore(int score) {
        this.score = score;

        setChanged();
        notifyObservers();
    }

    /**
     * Gets the velocity of the paddle
     * @return velocity of the paddle
     */
    public int getVelocity() {
        return velocity;
    }

    /**
     * Sets velocity of the paddle
     * @param velocity paddle velocity
     */
    public void setVelocity(int velocity) {
        this.velocity = velocity;

        setChanged();
        notifyObservers();
    }
    
    /**
     * Gets number of brick rows
     * @return amount of brick rows
     */
    public int getRows(){
        return rows;
    }
    
    /**
     * Sets rows of bricks
     * @param rows amount of rows
     * @throws WrongValueException exception when the value is wrong
     */
    public void setRows(int rows)throws WrongValueException{
        if(rows<1 || rows >8){
            throw new WrongValueException();
        }
        else{
            this.rows = rows;
        }
    }

    /**
     * Sets default amount of rows
     */
    public void setDefaultRows(){
        this.rows = 5;
    }
    /**
     * Gets the ball object
     * @return object of the ball class
     */
    public Ball getBall() {
        return ball;
    }

    /**
     * Sets the ball value
     * @param ball object of the ball class
     */
    public void setBall(Ball ball) {
        this.ball = ball;

        setChanged();
        notifyObservers();
    }
    
    /**
     * Returns the list of blocks
     * @return list of blocks
     */
    public List<Block> getBlocks() {
        return blocks;
    }

    /**
     * Sets the list of blocks 
     * @param blocks 
     */
    public void setBlocks(List<Block> blocks) {
        this.blocks = blocks;

        setChanged();
        notifyObservers();
    }
    
    /**
     * 
     * @param win boolean variable of the win moment
     */
    public void setWin(boolean win){
        this.win = win;

        setChanged();
        notifyObservers();
    }
    
    /**
     * 
     * @return boolean variable if the game is won or not
     */
    public boolean getWin(){
        return win;
    }
    /**
     * update ball
     */
    public void ballUpdate() {
        ball.update();

        setChanged();
        notifyObservers();
    }

    //update paddle
    public void update() {
        this.x += this.velocity;

        setChanged();
        notifyObservers();
    }

    /**
     * tests collision of the ball with paddle
     */
    public void collisionPaddle() {
        ball.testCollisionWithPaddle(this, ball);

        setChanged();
        notifyObservers();
    }
    
    /**
     * tests collision of the ball with the bricks and manages the amount of blocks left
     * manage score
     */
    public void collisionBlocks() {
        Iterator<Block> it = blocks.iterator();
        while (it.hasNext()) {
            Block block = it.next();
            ball.testCollisionWithBlocks(block, ball);
            if (block.getDestroyed()) {
                score++;
                it.remove();
            }
        }

        setChanged();
        notifyObservers();
    }

    
}