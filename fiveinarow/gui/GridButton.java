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
        addActionListener(this); 
    }
                        
    public void actionPerformed(ActionEvent e) {
        //TODO - disable the game window!!!!!
        Engine.handleClick(xcoord, ycoord); 
        //TODO - enable the game window         
    }    
    
    @Override
    /**
     * 
     */
    public void repaint() {    
        this.setBackground(Engine.getBoard().getSquareAt(xcoord, ycoord).getState().getColor());
        super.repaint(); 
    }

}
