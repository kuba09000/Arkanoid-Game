package pl.polsl.Jakub.Lapaj.View;

import pl.polsl.Jakub.Lapaj.Model.Model;
import java.awt.Color;
import java.awt.Font;
import static java.awt.Font.BOLD;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;
import pl.polsl.Jakub.Lapaj.Model.Block;

/**
 * View class
 * @author Jakub Łapaj
 */

public class View extends javax.swing.JFrame implements Observer {
    private Model model;
    private final int WIDTH = 800;
    private final int HEIGHT = 600;
    private javax.swing.JPanel panel;

    /**
     * Empty constructor for class object
     */
    
    public View() {
        initComponents();
    }

    /**
     * Constructor with arguments
     * @param model - MVC pattern model object
     */
    
    public View(Model model) {
        this();
        this.model = model;

        this.model.addObserver(this);

        this.setSize(WIDTH + 16, HEIGHT + 39);

    }
    
    /**
     * Rendering the game
     * @param gg - graphic object used to desing the application
     */
    
    public void render(Graphics gg) {
        Graphics2D g = (Graphics2D) gg;

        // background
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WIDTH + 400, HEIGHT + 400);

        if (!model.getBall().getDead()) {
            // blocks
            g.setColor(Color.WHITE);
            for (Block b : model.getBlocks()) {
                g.drawRect(b.getX(), b.getY(), b.getWidth(), b.getHeight());
                g.fillRect(b.getX(), b.getY(), b.getWidth(), b.getHeight());
            }
            // paddle
            g.setColor(Color.RED);
            g.fillRect(model.getX(), model.getY(), model.getWidth(), model.getHeight());

            // ball
            g.setColor(Color.GREEN);
            g.fillOval(model.getBall().getX() - model.getBall().getRadius(), model.getBall().getY() - model.getBall().getRadius(),
                    model.getBall().getRadius() * 2, model.getBall().getRadius() * 2);

            // score
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", BOLD, 20));
            g.drawString("score: " + model.getScore(), 5, 30);
            g.drawString("lifes: " + model.getBall().getLives(), 5, 50);
        } else if (model.getBall().getDead()) {
            g.setColor(Color.RED);
            g.setFont(new Font("Arial", BOLD, 55));
            g.drawString("Game Over!", WIDTH / 2 - 220, HEIGHT / 2);
        } else if (model.getWin()) {
            System.out.println("win");
            g.setColor(Color.GREEN);
            g.setFont(new Font("Arial", BOLD, 55));
            g.drawString("You win!", WIDTH / 2 - 220, HEIGHT / 2);
        }
    }

    
    public void update(Observable o, Object arg) {
        this.repaint();
    }
    public void addGameKeyboardListener(KeyListener l) {
        this.addKeyListener(l);
    }

    /**
     * Gets width of the window
     * @return width of the window
     */
    public int getWidth() {
        return WIDTH;
    }
    
    /**
     * Gets height of the window
     * @return height of the window
     */
    public int getHeigt() {
        return HEIGHT;
    }
    
    /**
     * initialize components of the application, sets the frame and render graphics
     */
    
    private void initComponents() {
        panel = new JPanel() {
            
            @Override
            public void paint(Graphics g) {

                render(g);
                
            }
        };

        this.add(panel);
    }
}