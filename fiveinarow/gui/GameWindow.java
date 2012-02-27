package fiveinarow.gui;

import javax.swing.JFrame; 

import fiveinarow.Configuration; 

public class GameWindow extends JFrame {
    
    private GamePanel gamePanel;
    
    
    public GameWindow() {
        //TODO
        
        this.setSize(Configuration.GAMEWINDOW_WIDTH, 
                     Configuration.GAMEWINDOW_HEIGHT);
        this.setResizable(false);
        
        this.setLayout(null);
        
        this.gamePanel = new GamePanel(); 
        this.add(gamePanel);
        gamePanel.setBounds(Configuration.GAMEPANEL_POSX, 
                            Configuration.GAMEPANEL_POSY,
                            Configuration.GAMEPANEL_WIDTH,
                            Configuration.GAMEPANEL_HEIGHT);         
        gamePanel.setUpGridButtons();       
        
        this.setTitle("TODO!!!");

        
    }
    

}
