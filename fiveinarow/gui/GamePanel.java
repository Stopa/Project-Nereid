package fiveinarow.gui;

import javax.swing.JPanel; 
import java.awt.GridLayout; 
import fiveinarow.Configuration;

public class GamePanel extends JPanel {
    
    private GridButton[][] gridButtons; 
        
    /**
     * 
     */
    public GamePanel() {
        //TODO
        this.setLayout(new GridLayout(Configuration.BOARDSIZE, 
                                      Configuration.BOARDSIZE, 
                                      0, 
                                      0)); 
        //TODO - layout vaja settida.. 
                

    }
    
    /**
     * 
     */
    void setUpGridButtons() {
        
        gridButtons = new GridButton[Configuration.BOARDSIZE][Configuration.BOARDSIZE]; 
        
        for (int i = 0; i < Configuration.BOARDSIZE; i++) {
            for (int j = 0; j < Configuration.BOARDSIZE; j++) {
                GridButton tmp = new GridButton(i, j);
                gridButtons[i][j] = tmp;                 
                this.add(tmp); 
            }
        }
        
    }
    
    /**
     * 
     * @param xcoord
     * @param ycoord
     * @return 
     */
    GridButton getGridAt(int xcoord, int ycoord) {
        return gridButtons[xcoord][ycoord]; 
    }
   

}
