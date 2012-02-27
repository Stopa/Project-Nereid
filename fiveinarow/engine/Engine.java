package fiveinarow.engine;

import fiveinarow.gui.*; 

public abstract class Engine {
    
    private Engine() {}; //no constructor
    
    private static int totalMoves; 
    private static int redWins;
    private static int blueWins; 
    
    private static Board board; 
    private static GameWindow gameWindow; 
    
    
    public static void turn() {
        //TODO
        //change player
    }
    
    public static void checkWin() {
        //TODO
    }
    
    public static boolean checkMove(Square square) {
        
        if (totalMoves == 0) {
            return true; 
        }
        //TODO
        return true; 
    }
    
    public static void takeSquare(Square square) {
        //TODO
        //check win here 
    }
    
    public static void init() {
        totalMoves = 0; 
        redWins = 0;
        blueWins = 0; 
    }
        
    
    public static void setUpBoard() {
        board = new Board();
    }
    
    public static void setUpGameWindow() {
        gameWindow = new GameWindow(); 
        gameWindow.setVisible(true);
    }
    
    public static void startGame() {
        //TODO
    }   
    
    public static Board getBoard() {
        return board; 
    }

}
