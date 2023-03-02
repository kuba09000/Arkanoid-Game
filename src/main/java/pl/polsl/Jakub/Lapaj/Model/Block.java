package pl.polsl.Jakub.Lapaj.Model;

/**
 * Block class
 * @author Jakub Łapaj
 */
public class Block {
    private int x, y, width = 60, height = 20;
    private boolean destroyed = false;

    /**
     * constructor of the block object
     * @param x horizontal position of the block
     * @param y vertical position of the block
     */
    public Block(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    //Getters and setters
    /**
     * Gets horizontal position of the block
     * @return horizontal position of the block
     */
    public int getX() {
        return x;
    }
    
    /**
     * Gets vertical position of the block
     * @return vertical position of the block
     */
    public int getY() {
        return y;
    }

    /**
     * Gets width of the block
     * @return width of the block
     */
    public int getWidth() {
        return width;
    }

    /**
     * Gets height of the block
     * @return height of the block
     */
    public int getHeight() {
        return height;
    }
    
    /**
     * Gets information if the block is destroyed
     * @return boolean value if the block is destroyed or not
     */
    public boolean getDestroyed(){
        return destroyed;
    }
    
    /**
     * Sets the value of the block when it is destroyed
     * @param destroyed actual state if the block is destroyed or not
     */
    public void setDestroyed(boolean destroyed){
        this.destroyed = destroyed;
        
    }
}
