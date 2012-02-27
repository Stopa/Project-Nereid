package fiveinarow.gui;

import javax.swing.JPanel; 
import java.awt.GridLayout; 
import fiveinarow.Configuration;

public class GamePanel extends JPanel {
        
    public GamePanel() {
        //TODO
        this.setLayout(new GridLayout(Configuration.BOARDSIZE, 
                                      Configuration.BOARDSIZE, 
                                      0, 
                                      0)); 
        //TODO - layout vaja settida.. 

    }
    
    void setUpGridButtons() {
        for (int i = 0; i < Configuration.BOARDSIZE; i++) {
            for (int j = 0; j < Configuration.BOARDSIZE; j++) {
                //TODO
                this.add(new GridButton(i, j));                
            }
        }
        
    }

}
