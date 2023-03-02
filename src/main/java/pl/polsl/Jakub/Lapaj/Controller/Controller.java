package pl.polsl.Jakub.Lapaj.Controller;

import Exceptions.WrongValueException;
import pl.polsl.Jakub.Lapaj.Model.Model;
import pl.polsl.Jakub.Lapaj.View.View;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.TimerTask;
import java.util.Timer;
import javax.swing.JOptionPane;
/**
 * Controller class
 * @author Jakub Łapaj
 */
public class Controller {
    private final Model model;
    private final View view;
    private final Timer timer;

    /**
     * Constructor of the controller class object 
     * @param model - MVC pattern model object
     * @param view - MVC pattern view object 
     * @param args - Arguments given
     */
    public Controller(Model model, View view, String[] args) {
        this.model = model;
        this.view = view;

        // sets the paddle position
        model.setX(view.getWidth() / 2 );
        model.setY(view.getHeigt() - model.getHeight());
        
        //process the parameters given to the main function
        processParameters(args);

        // adds the blocks the to scene
        for (int i = 0; i < model.getRows(); i++) {
            for (int j = 0; j < 8; j++) {
                model.addBlock(50+(j*70+ model.getWidth()), 20+(i*45 +model.getWidth()));
            }
        }
        
        // updates the paddle's position
        this.timer = new Timer("Timer");
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (!model.getBall().getDead() && !model.getWin()) {
                    if (model.getX() < 0)
                        model.setX(1);
                    else if (model.getX() + model.getWidth() >= view.getWidth())
                        model.setX(view.getWidth() - model.getWidth() - 1);
                    model.update();
                    model.ballUpdate();
                    model.collisionPaddle();
                    model.collisionBlocks();
                }
                if (model.getBlocks().isEmpty()) {
                    model.setWin(true);
                }
            }
        }, 16, 16);
        

        this.view.addGameKeyboardListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                
                //assign action to keys
                switch (key) {
                case KeyEvent.VK_RIGHT:
                    model.setVelocity(10);
                    break;
                case KeyEvent.VK_LEFT:
                    model.setVelocity(-10);
                    break;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                model.setVelocity(0);
            }

            @Override
            public void keyTyped(KeyEvent e) {
            }
        });
    }
    
    /**
     * Processing arguments given to the main function
     * @param args arguments table given to the main function
     */
    private void processParameters(String args[]){
        if(args.length == 1){
             int number = Integer.parseInt(args[0]);
            
                try{
                    model.setRows(number);
                } catch (WrongValueException ex){
                    model.setDefaultRows();
                } 
        }
        else{
            String value = JOptionPane.showInputDialog(null, "Input difficulty level(1-8)!", 
                "Exception!", JOptionPane.ERROR_MESSAGE);
            int number = Integer.parseInt(value);
            try{
                    model.setRows(number);
                } catch (WrongValueException ex){
                    model.setDefaultRows();
                } 
        }
    }
}