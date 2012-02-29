package fiveinarow.gui;

import javax.swing.JFrame; 
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

import fiveinarow.Configuration; 
import java.awt.Color;

import java.awt.Font;

public class GameWindow extends JFrame {
    
    private GamePanel gamePanel;
    
    //private JLabel playerOneWinsLabel;
    //private JLabel playerTwoWinsLabel; 
    private JLabel statusLabel; 
    
    private JButton readmeButton;
    
    //private JButton newGameButton; 
    
    /**
     * 
     */
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
        
        /*
        playerOneWinsLabel = new JLabel();
        playerOneWinsLabel.setBounds(WIDTH, WIDTH, WIDTH, WIDTH);
        playerOneWinsLabel.setForeground(Color.red); //TODO
        updatePlayerOneWins();
        
        playerTwoWinsLabel = new JLabel(); 
        playerTwoWinsLabel.setBounds(WIDTH, WIDTH, WIDTH, WIDTH); 
        playerTwoWinsLabel.setForeground(Color.red); //TODO        
        updatePlayerTwoWins(); 
         * 
         */
        
        statusLabel = new JLabel();
        statusLabel.setBounds(Configuration.STATUSLABEL_POSX,
                              Configuration.STATUSLABEL_POSY,
                              Configuration.STATUSLABEL_WIDTH,
                              Configuration.STATUSLABEL_HEIGHT);        
        statusLabel.setForeground(Configuration.STATUSLABEL_COLOR); 
        statusLabel.setFont(new Font("SansSerif", Font.BOLD, 50)); //TODO - võlunumber, võta ära!
        this.add(statusLabel); 
        
        this.readmeButton = new JButton ("Loe mind");
        readmeButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(
                null,
                Configuration.READ_ME_CONTENT,
                "Loe mind",
                JOptionPane.INFORMATION_MESSAGE);
            }
        });
        
        readmeButton.setSize(Configuration.READ_ME_SIZE_X,Configuration.READ_ME_SIZE_Y);
        readmeButton.setLocation(Configuration.READ_ME_POSX,Configuration.READ_ME_POSY);
        this.add(readmeButton);
        
                        
        
        this.setTitle("Five in a row!"); 

        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    } 
    
    /**
     * CURRENTLY UNUSED. 
     */
    public final void updatePlayerOneWins() {
        //TODO
    }
    
    /**
     * CURRENTLY UNUSED. 
     */
    public final void updatePlayerTwoWins() {
        //TODO 
    }
    
    /**
     * 
     * @param text 
     */
    public final void updateStatusLabel(String text) {
        statusLabel.setText(text); 
    }
    
    
    /**
     * 
     * @param xcoord
     * @param ycoord 
     */
    public void updateGridAt(int xcoord, int ycoord) {
        gamePanel.getGridAt(xcoord, ycoord).repaint();
    }
    
    

}
