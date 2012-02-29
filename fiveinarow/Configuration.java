package fiveinarow;

import java.awt.Color; 

public abstract class Configuration {
    
    private Configuration() {}; //no constructor 
    
    public static final int BOARDSIZE = 30; //mängulaua mõõtmed (nii loogiline kui graafiline)
    
    public static final int GAMEWINDOW_HEIGHT = 800; //mänguakna kõrgus
    public static final int GAMEWINDOW_WIDTH = 700;  //mänguakna laius
    
    public static final int GAMEPANEL_HEIGHT = 600; //nuppude paneeli kõrgus
    public static final int GAMEPANEL_WIDTH = 600; //nuppude paneeli laius
    public static final int GAMEPANEL_POSX = 50; //nuppude paneeli x-telje positsioon 
    public static final int GAMEPANEL_POSY = 75; //nuppude paneeli y-telje positsioon
    
    public static final int STATUSLABEL_HEIGHT = 100; //staatusteksti kõrgus
    public static final int STATUSLABEL_WIDTH = 400; //staatusteksti laius
    public static final int STATUSLABEL_POSX = 200; //staatusteksti x-telje positsioon
    public static final int STATUSLABEL_POSY = 680; //staatusteksti y-telje positsioon
    public static final Color STATUSLABEL_COLOR = Color.GREEN; //staatusteksti värv
    
    public static final int READ_ME_POSX = 550;
    public static final int READ_ME_POSY = 25;
    public static final int READ_ME_SIZE_X = 100;
    public static final int READ_ME_SIZE_Y = 25;
    public static final String READ_ME_CONTENT = "Five in a row on mäng, kus osalejad peavad "
                                               + "kordamööda värvima ruute.\n"
                                               + "Kes enne 5 järjestikust ruutu oma värviga värvitud "
                                               + "saab on võitja.\nNii lihtne see ongi.";
    
    public static final Color PLAYER_ONE_COLOR = Color.RED; //esimese mängija värv
    public static final Color PLAYER_TWO_COLOR = Color.BLUE; //teise mängija värv
    public static final Color UNSELECTED_COLOR = Color.WHITE; //valimata ruudu värv
}
