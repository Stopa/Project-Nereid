package fiveinarow.gui;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent; 
import javax.swing.JButton; 
import fiveinarow.engine.Engine; 

public class GridButton extends JButton implements ActionListener {
    
    private final int xcoord; //selle nupu x-koordinaat massiivis
    private final int ycoord; //selle nupu y-koordinaat massiivis
    
    /**
     * Constructs new GridButton instance. 
     * 
     * @param xcoord X-coordinate of the button. 
     * @param ycoord Y-coordinate of the button. 
     */
    public GridButton(int xcoord, int ycoord) {  
        //määrame väärtused
        this.xcoord = xcoord;
        this.ycoord = ycoord; 
        addActionListener(this); //lisame ActionListener hiireklõpse jne kuulama 
    }
       
    /**
     * ActionListener implementation. Handles clicking the grid buttons. 
     * 
     * @param e ActionEvent fired by clicking the button. 
     */
    @Override 
    public void actionPerformed(ActionEvent e) {        
        Engine.handleClick(xcoord, ycoord); //kutsume välja vastava Engine meetodi
    }    
    
    /**
     * Repaints the button. 
     */
    @Override   
    public void repaint() { 
        //määrame uue taustavärvi
        this.setBackground(Engine.getBoard().getSquareAt(xcoord, ycoord).getState().getColor());
        super.repaint(); //ja kutsume välja superklassi vastava meetodi 
    }

}
