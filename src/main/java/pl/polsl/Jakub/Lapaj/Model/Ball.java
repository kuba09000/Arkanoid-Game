package pl.polsl.Jakub.Lapaj.Model;

import java.awt.Rectangle;

/**
 * Ball class
 * @author Jakub Łapaj
 */
public class Ball {
    private int x, y, vel_x = 3, vel_y = 3;
    private int lives = 3;
    private enum RadiusSize{
        Small(5),
        Medium(10),
        Large(15);
        
        private final int size;
        
        RadiusSize(int size){
            this.size = size;
        }
        
        public int getSize(){
            return size;
        }
    }
    private int radius = RadiusSize.Medium.getSize();
    
    private boolean dead = false;

    /**
     * Constructor of the ball object
     * @param x horizontal position of the ball
     * @param y vertical position of the ball
     */
    public Ball(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    //Getters and setters for the attributes
    /**
     * Gets the horizontal position of the ball
     * @return horizontal position of the ball
     */
    public int getX() {
        return x;
    }

    /**
     * Sets the horizontal position of the ball
     * @param x horizontal position of the ball
     */
    public void setX(int x) {
        this.x = x;
    }
    
    /**
     * Gets vertical position of the ball
     * @return vertical position of the ball
     */
    public int getY() {
        return y;
    }

    /**
     * Sets vertical position of the ball
     * @param y vertical position of the ball
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Gets the radius of the ball
     * @return radius of the ball
     */
    public int getRadius() {
        return radius;
    }

    /**
     * Sets the ball radius
     * @param radius value of the ball radius
     */
    public void setRadius(int radius) {
        this.radius = radius;
    }

    /**
     * Gets horiozontal velocity
     * @return horizontal velocity
     */
    public int getVel_x() {
        return vel_x;
    }

    /**
     * Sets horizontal velocity
     * @param vel_x horizontal velocity
     */
    public void setVel_x(int vel_x) {
        this.vel_x = vel_x;
    }

    /**
     * Gets ball velocity
     * @return ball velocity
     */
    public int getVel_y() {
        return vel_y;
    }

    /**
     * Sets ball velocity
     * @param vel_y vertical velocity
     */
    public void setVel_y(int vel_y) {
        this.vel_y = vel_y;
    }
    
    /**
     * Gets the actual value of lives 
     * @return actual value of lives left
     */
    public int getLives() {
        return lives;
    }

    /**
     * Sets the lives of the game
     * @param lives value of the remaining lives
     */
    public void setLives(int lives) {
        this.lives = lives;
    }
    
    /**
     * Sets the value of the game state
     * @param dead value of the endgame
     */
    public void setDead(boolean dead){
        this.dead = dead;
    }
    
    /**
     * Gets the info if the game is over or not
     * @return boolean value of the endgame
     */
    public boolean getDead(){
        return dead;
    }

    /**
     * Updates the ball
     */
    public void update() {
        x += vel_x;
        y += vel_y;

        if (left() < 0)
            vel_x *=-1;
        else if (right() > 800)
            vel_x *=-1;
        if (top() < 0) {
            vel_y *=-1;
        } else if (bottom() > 600) {
            vel_y *= -1;
            x = 400;
            y = 400;

            if (lives <= 0) {
                this.dead = true;
            }

            lives--;
        }
    }

    /**
     * Gets left bound
     * @return position of the left bound
     */
    double left() {
        return x - radius;
    }

    /**
     * Gets right bound
     * @return position of the right bound
     */
    double right() {
        return x + radius;
    }

    /**
     * Gets top bound
     * @return position of the top bound
     */
    double top() {
        return y - radius;
    }

    /**
     * Gets bottom bound
     * @return position of the bottom bound
     */
    double bottom() {
        return y + radius;
    }

    /**
     * tests the collision of the ball with bricks
     * @param mBrick object of block of bricks
     * @param mBall ball object
     */
    void testCollisionWithBlocks(Block mBrick, Ball mBall) {
        if (new Rectangle(mBall.getX(),mBall.getY(),10,10).intersects(new Rectangle(mBrick.getX(),mBrick.getY(),60,20))){
            mBrick.setDestroyed(true);
            mBall.vel_y *= -1; 
        }   
    }
    
    /**
     * tests the collision of the ball with paddle
     * @param mPaddle object of paddle
     * @param mBall ball object
     */
    void testCollisionWithPaddle(Model mPaddle, Ball mBall) {
        if (new Rectangle(mBall.getX(),mBall.getY(),10,10).intersects(new Rectangle(mPaddle.getX(),mPaddle.getY(),60,20))){
            mBall.vel_y *= -1; 
        }   
    }
}