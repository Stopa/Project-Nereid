package fiveinarow;

import fiveinarow.engine.*;

public class FiveInARow {

    public static void main(String[] args) {
        Engine.init();
        Engine.setUpBoard();
        Engine.setUpGameWindow();
        Engine.startGame(); 
    }

}
