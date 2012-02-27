package fiveinarow;

import java.awt.Color; 

public abstract class Configuration {
    
    private Configuration() {}; //no constructor 
    
    public static final int BOARDSIZE = 30;    
    
    public static final int GAMEWINDOW_HEIGHT = 800; 
    public static final int GAMEWINDOW_WIDTH = 800; 
    
    public static final int GAMEPANEL_HEIGHT = 600; 
    public static final int GAMEPANEL_WIDTH = 600; 
    public static final int GAMEPANEL_POSX = 100; 
    public static final int GAMEPANEL_POSY = 100; 
    
    public static final Color PLAYER_ONE_COLOR = Color.RED; 
    public static final Color PLAYER_TWO_COLOR = Color.BLUE; 
    public static final Color UNSELECTED_COLOR = Color.WHITE; 
}
