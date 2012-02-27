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
        
        currentPlayer = currentPlayer == Player.PLAYER_ONE ? 
                Player.PLAYER_TWO : Player.PLAYER_ONE;
        
    }
    
    public static boolean checkWin(Square square) {
        //TODO
        //kontrollida AINULT seda ruutu
        //eeldusel et teised ju pole muutunud.. 
        //rekursiivselt?  
        
        int[][] dirs = {{-1,-1,1,1},{1,-1,-1,1},{0,-1,0,1},{-1,0,1,0}}; 
        
        int currentX = square.getXCoord(); 
        int currentY = square.getYCoord(); 
        
        for (int i = 0; i < dirs.length; i++) {
            
            if (1 + 
            getDirectionCount(currentX + dirs[i][0],
                              currentY + dirs[i][1], 
                              dirs[i][0], 
                              dirs[i][1]) +                   
            getDirectionCount(currentX + dirs[i][2], 
                              currentY + dirs[i][3], 
                              dirs[i][2], 
                              dirs[i][3]) 
            >= 5) return true;                 
        }
        
        return false; 
        
        
       
    }
    
    private static int getDirectionCount(int xcoord, int ycoord, int xchange, int ychange) {
        
        try {
        
        if (board.getSquareAt(xcoord, ycoord).getState() == 
                currentPlayer.getCorrespondingSquareState()) {
                    return 1 + getDirectionCount(xcoord + xchange,
                                                 ycoord + ychange,
                                                 xchange,
                                                 ychange);
            }
        
        else return 0; 
        
        }
        
        //TODO - katseta kas see ikka toimib.. 
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("debug - visati exception.."); 
            return 0; 
        }
                
    }
    
    public static void handleClick(int xcoord, int ycoord) {
        
        gameWindow.setEnabled(false); 
        
        Square square = board.getSquareAt(xcoord, ycoord); 
        
        if (checkMove(square)) {            
            takeSquare(square);
            turn(); 
        }
        else {
            //TODO - anything? 
        }        
        gameWindow.setEnabled(true); 
    }      
    
    public static boolean checkMove(Square square) {
        
        if (totalMoves == 0) return true; 
                        
        if (square.getState() == Square.SquareState.UNSELECTED &&
                hasAdjacentSelectedSquares(square)) return true;
        //TODO - ära muuta!! või panna konfist sõltuma?
        //et kas peab juba kõrval äravõetud ruut olema? 
                
        return false;  
    }
    
    private static boolean hasAdjacentSelectedSquares(Square square) {
        //TODO!!
        return true; 
    }
    
    public static void takeSquare(Square square) {
        
        square.setState(currentPlayer.getCorrespondingSquareState()); 
        
        totalMoves++; 
        gameWindow.updateGridAt(square.getXCoord(), square.getYCoord());
        
        if (checkWin(square)) {
            System.out.println(currentPlayer.toString() + " wins!"); 
        }
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
            //TODO - update status JLabel.. 
        }
        
        else {
            playerTwoWins++; 
            //TODO - update status JLabel.. 
        }
    }
    
    public static Board getBoard() {
        return board; 
    }
    
    public static GameWindow getGameWindow() {
        return gameWindow; 
    }
    
    public enum Player {
        PLAYER_ONE(Square.SquareState.PLAYER_ONE, "Punane"), 
        PLAYER_TWO(Square.SquareState.PLAYER_TWO, "Sinine"); 
        
        private Square.SquareState state; 
        private String name; 
        
        Player(Square.SquareState state, String name) {
            this.state = state; 
            this.name = name; 
        }
        
        public Square.SquareState getCorrespondingSquareState() {
            return this.state; 
        }
        
        public String toString() {
            return this.name; 
        }
       
    }

}
