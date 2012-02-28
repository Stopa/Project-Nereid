package fiveinarow.gui;

import javax.swing.JPanel; 
import java.awt.GridLayout; 
import fiveinarow.Configuration;

public class GamePanel extends JPanel {
    
    //hoiab nuppude graafilisi representatsiooni, YxY massiivis
    private GridButton[][] gridButtons; 
        
    /**
     * Sets up the gamepanel component. 
     */
    public GamePanel() {
        //määrame layoutiks gridlayouti
        //anname sellele x-telge ja y-telge pidi ruutude arvu
        //ning ruutudevahelise vahe pikslites (0) 
        this.setLayout(new GridLayout(Configuration.BOARDSIZE, 
                                      Configuration.BOARDSIZE, 
                                      0, 
                                      0));                
    }

    /**
     * Sets up the grid buttons, initializing them and saving the references in an array. 
     */
    void setUpGridButtons() {
        
        //initsialiseerime graafiliste mängunuppude kahemõõtmelise massiivi
        gridButtons = new GridButton[Configuration.BOARDSIZE][Configuration.BOARDSIZE]; 
        
        //ja anname selle igale elemendile kahe for loopi abil uue objekti väärtuseks
        for (int i = 0; i < Configuration.BOARDSIZE; i++) {
            for (int j = 0; j < Configuration.BOARDSIZE; j++) {
                GridButton tmp = new GridButton(i, j); //loome uue objekti
                gridButtons[i][j] = tmp; //paneme selle massiivi
                this.add(tmp); //ja lisame ka gamepanel paneelile, et oleks näha
            }
        }
        
    }
    
    /**
     * Returns the GridButton object at x,y coordinates. 
     * 
     * @param xcoord X-coordinate of the GridButton.
     * @param ycoord Y-coordinate of the GridButton. 
     * @return GridButton at these coordinates. 
     */
    GridButton getGridAt(int xcoord, int ycoord) {
        return gridButtons[xcoord][ycoord]; //võtame massiivist nende indeksitega nupu 
    }
   

}
