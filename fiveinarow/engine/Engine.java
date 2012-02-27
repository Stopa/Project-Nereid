package fiveinarow.engine;

import fiveinarow.gui.GameWindow; 

public abstract class Engine {
    
    private Engine() {}; //no constructor   
    
    private static int totalMoves; //tehtud käikude arv selle mängu jooksul
    private static int playerOneWins; //esimese mängija võitude arv mängukorra jooksul
    private static int playerTwoWins; //teise mängija võitude arv mängukorra jooksul
    
    private static Board board; //board objekt - loogiline mängulaud
    private static GameWindow gameWindow; //mänguaken ehk graafiline mängulaud
    
    private static Player currentPlayer; //mängija, kelle käik parasjagu on
    
    private static boolean activeWin; //kas parasjagu on üks mängija võitnud
    //kasutatakse mitmes kohas mängu flow juhtimisel
    //TODO - mõelda parem lahendus välja? 
    
    
    /**
     * Handles player switching and pushes new status string to game window. 
     */
    private static void turn() {       
        
        //muudab mängijat
        currentPlayer = currentPlayer == Player.PLAYER_ONE ? 
                Player.PLAYER_TWO : Player.PLAYER_ONE;
        
        //kui pole ühe mängija võit aktiivne, siis pushitakse uus staatus
        if (!activeWin)
        gameWindow.updateStatusLabel(currentPlayer.toString() + " käik!");
        
    }
    
    /**
     * 
     * @param square
     * @return 
     */
    private static boolean checkWin(Square square) {
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
    
    /**
     * 
     * @param xcoord
     * @param ycoord
     * @param xchange
     * @param ychange
     * @return 
     */
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
    
    /**
     * 
     * @param xcoord
     * @param ycoord 
     */
    
    public static void handleClick(int xcoord, int ycoord) {
        
        if (activeWin) return; 
        
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
    
    /**
     * 
     * @param square
     * @return 
     */
    public static boolean checkMove(Square square) {
        
        if (totalMoves == 0) return true; 
                        
        if (square.getState() == Square.SquareState.UNSELECTED &&
                hasAdjacentSelectedSquares(square)) return true;
        //TODO - ära muuta!! või panna konfist sõltuma?
        //et kas peab juba kõrval äravõetud ruut olema? 
                
        return false;  
    }
    
    /**
     * 
     * @param square
     * @return 
     */
    private static boolean hasAdjacentSelectedSquares(Square square) {
        //TODO!!
        return true; 
    }
    
    /**
     * 
     * @param square 
     */
    public static void takeSquare(Square square) {
        
        square.setState(currentPlayer.getCorrespondingSquareState()); 
        
        totalMoves++; 
        gameWindow.updateGridAt(square.getXCoord(), square.getYCoord());
        
        if (checkWin(square)) {
            gameWindow.updateStatusLabel(currentPlayer.toString() + " võit!");
            gameWindow.setEnabled(false); //TODO - muuta    
            activeWin = true; 
        }
    }
    
    /**
     * 
     */
    public static void init() {
        totalMoves = 0; 
        playerOneWins = 0;
        playerTwoWins = 0; 
        currentPlayer = Player.PLAYER_ONE; 
        activeWin = false; 
    }
        
    /**
     * 
     */
    private static void setUpBoard() {
        board = new Board();
    }
    
    /**
     * 
     */
    private static void setUpGameWindow() {
        gameWindow = new GameWindow(); 
        gameWindow.setVisible(true);
    }
    
    /**
     * Disposes of the current game window and board objects and creates new ones. 
     */
    
    public static void startNewGame() {   
        if (gameWindow != null) {
        //praegune gamewindow dev/null
        gameWindow.setVisible(false);
        gameWindow.dispose(); 
        gameWindow = null; 
        }
        
        if (board != null) {
        //praegune board dev/null
        board = null; 
        }
        
        //uus board
        setUpBoard(); 
        //uus gamewindow
        setUpGameWindow(); 
        gameWindow.updateStatusLabel(currentPlayer.toString() + " käik!");
        //set visible
    }   
    
    /**
     * CURRENTLY UNUSED.  
     * @param winner 
     */
    
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
    
    /**
     * 
     * @return 
     */
    public static Board getBoard() {
        return board; 
    }
    
    /**
     * 
     * @return 
     */
    public static GameWindow getGameWindow() {
        return gameWindow; 
    }
    
    /**
     * 
     * @return 
     */
    public static int getPlayerOneWins() {
        return playerOneWins; 
    }
    
    /**
     * 
     * @return
     */
    public static int getPlayerTwoWins() {
        return playerTwoWins; 
    }
    
    /**
     * 
     */
    public enum Player {
        PLAYER_ONE(Square.SquareState.PLAYER_ONE, "Punane"), 
        PLAYER_TWO(Square.SquareState.PLAYER_TWO, "Sinine"); 
        
        private Square.SquareState state; 
        private String name; 
        
        /**
         * 
         * @param state
         * @param name 
         */
        Player(Square.SquareState state, String name) {
            this.state = state; 
            this.name = name; 
        }
        
        /**
         * 
         * @return 
         */
        public Square.SquareState getCorrespondingSquareState() {
            return this.state; 
        }
        
        /**
         * 
         * @return 
         */
        public String toString() {
            return this.name; 
        }
       
    }

}
