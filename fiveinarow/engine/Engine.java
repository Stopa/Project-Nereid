package fiveinarow.engine;

import fiveinarow.gui.*; 

public abstract class Engine {
    
    private Engine() {}; //no constructor
    
    private static int totalMoves; 
    private static int playerOneWins;
    private static int playerTwoWins; 
    
    private static Board board; 
    private static GameWindow gameWindow; 
    
    private static Player currentPlayer; 
    
    
    public static void turn() {
        //TODO
        
        
        currentPlayer = currentPlayer == Player.PLAYER_ONE ? 
                Player.PLAYER_TWO : Player.PLAYER_ONE;
        
    }
    
    public static void checkWin() {
        //TODO
    }
    
    public static void handleClick(int xcoord, int ycoord) {
        //TODO - disable the game window!!!!!
        
        Square square = board.getSquareAt(xcoord, ycoord); 
        
        if (checkMove(square)) {            
            //TODO - disable this button? 
            takeSquare(square);
            turn(); 
        }
        else {
            //TODO - anything? 
        }
        
        //TODO - enable the game window 
    }      
    
    public static boolean checkMove(Square square) {
        
        if (totalMoves == 0) return true; 
        
        if (square.getState() == Square.SquareState.UNSELECTED) return true;
        //TODO - ära muuta!! või panna konfist sõltuma?
                
        return false;  
    }
    
    public static void takeSquare(Square square) {
        
        if (currentPlayer == Player.PLAYER_ONE) {
            square.setState(Square.SquareState.PLAYER_ONE); 
        }
        
        else {
            square.setState(Square.SquareState.PLAYER_TWO); 
        } 
        
        totalMoves++; 
        gameWindow.updateGridAt(square.getXCoord(), square.getYCoord()); 
    }
    
    public static void init() {
        totalMoves = 0; 
        playerOneWins = 0;
        playerTwoWins = 0; 
        currentPlayer = Player.PLAYER_ONE; 
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
    
    public static void endGame(Player winner) {
        //TODO - kumb võitis? sellele liita.. 
        
        if (winner == Player.PLAYER_ONE) {
            playerOneWins++; 
            //TODO - update JLabel.. 
        }
        
        else {
            playerTwoWins++; 
            //TODO - update JLabel.. 
        }
    }
    
    public static Board getBoard() {
        return board; 
    }
    
    public enum Player {
        PLAYER_ONE, PLAYER_TWO; 
    }

}
