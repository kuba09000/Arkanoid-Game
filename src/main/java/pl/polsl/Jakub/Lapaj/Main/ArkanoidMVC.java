package pl.polsl.Jakub.Lapaj.Main;

import pl.polsl.Jakub.Lapaj.Model.Model;
import pl.polsl.Jakub.Lapaj.View.View;
import pl.polsl.Jakub.Lapaj.Controller.Controller;

/**
 * Main class 
 * @author Jakub Łapaj
 */
public class ArkanoidMVC {
    /**
     * Main method of the program
     * @param args first value represents the number of block rows 
     */
    public static void main(String[] args) {
        
        Model model = new Model();
        View view = new View(model); 
        Controller controller = new Controller(model, view, args);
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                view.setVisible(true);
            }
        });
    }
}