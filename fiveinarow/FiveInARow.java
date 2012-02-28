package fiveinarow;

import fiveinarow.engine.*;

public class FiveInARow {

    /**
     * The entry point for the program flow. 
     * 
     * @param args UNUSED. 
     */
    public static void main(String[] args) {
        Engine.init(); //seame üles Engine muutujad jmt
        Engine.startNewGame();  //alustame uut mängu (s.h. graafika) 
    }

}
