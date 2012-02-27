package fiveinarow.gui;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent; 
import javax.swing.JButton; 
import fiveinarow.engine.Engine; 

public class GridButton extends JButton implements ActionListener {
    
    private final int xcoord;
    private final int ycoord; 
    
    public GridButton(int xcoord, int ycoord) {        
        this.xcoord = xcoord;
        this.ycoord = ycoord; 
    }
                        
    public void actionPerformed(ActionEvent e) {
        //TODO - disable the game window!!!!!
        Engine.getBoard().getSquareAt(xcoord,ycoord).handleClick(); 
        //TODO - enable the game window         
    }    
    
    public void drawGrid() {
        //TODO - set värv
        //TODO - set sümbol
        //TODO - kutsu oma update vms välja.. 
    }

}
