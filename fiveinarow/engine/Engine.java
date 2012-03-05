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
        gameWindow.updateStatusLabel(currentPlayer.getMoveString() + " käik!");
        
    }
    
    /**
     * Checks whether the current square taking ended in the current player winning. 
     * 
     * @param square The currently clicked square. 
     * @return True - current player has won, false - game is not won yet. 
     */
    private static boolean checkWin(Square square) {          
        
        //4x4 massiiv
        //hoiab suundi, mis suunas kontrollitakse rekursiivselt kõrvalolevaid ruute
        //dirs[x][1|2|3|4], kus 1,2 ja 3,4 moodustavad suundade paarid, kus 
        //esimene element liidetakse x-koordinaadile ja teine element y-koordinaadile
        int[][] dirs = {{-1,-1,1,1},{1,-1,-1,1},{0,-1,0,1},{-1,0,1,0}}; 
        
        //loetavuse mõttes salvestame ruudu x ja y koordinaadid lokaalselt
        int currentX = square.getXCoord(); 
        int currentY = square.getYCoord(); 
        
        
        //proovime rekursiivselt läbi kõik 4 suundade paari
        for (int i = 0; i < dirs.length; i++) {
            
            //kui 1 (praegune ruut) pluss ruudud esimeses suunas 
            //plus ruudud teises suunas >= 5, on järelikult 5 ruutu reas 
            if (1 + 
            //esimene suund
            getDirectionCount(currentX + dirs[i][0],
                              currentY + dirs[i][1], 
                              dirs[i][0], 
                              dirs[i][1]) +                   
            //teine suund
            getDirectionCount(currentX + dirs[i][2], 
                              currentY + dirs[i][3], 
                              dirs[i][2], 
                              dirs[i][3]) 
            >= 5) return true; //5 ruutu reas, mäng võidetud        
        }
        
        return false; //kõik variandid proovitud, polnud 5, mäng pole võidetud                      
    }
    
    /**
     * Recursively gets the count of squares owned by the current player in this direction. 
     * 
     * @param xcoord X-coordinate of the square to be evaluated. 
     * @param ycoord Y-coordinate of the square to be evaluated. 
     * @param xchange Change in the x-direction of the next square to be evaluated. 
     * @param ychange Change in the y-direction of the next square to be evaluated. 
     * @return The number of player's squares in this direction. 
     */
    private static int getDirectionCount(int xcoord, int ycoord, int xchange, int ychange) {
        
        try {        
            if (board.getSquareAt(xcoord, ycoord).getState() == //uuritav ruut
                currentPlayer.getCorrespondingSquareState()) { //kuulub praegusele mängijale
                    return 1 + getDirectionCount(xcoord + xchange, //tagastame 1 + rekursiivselt
                                                 ycoord + ychange, //kutsume sama meetodi välja
                                                 xchange,          //järgmisele ruudule
                                                 ychange);
            }
        
        else return 0; //uuritav ruut ei kuulu mängijale, tagastame 0 
        }
        
        //püüab kinni exceptioni, kui prooviti ruutu, mis asus väljaspool mängulauda.. 
        catch (ArrayIndexOutOfBoundsException e) {           
            return 0; 
        }
                
    }
    
    /**
     * Handles the click on the grid button made in the graphical interface. 
     * 
     * @param xcoord X-coordinate of the clicked button. 
     * @param ycoord Y-coordinate of the clicked button. 
     */
    
    public static void handleClick(int xcoord, int ycoord) {
        
        if (activeWin) return; //kui mäng juba läbi, siis ignoreerib
        
        gameWindow.setEnabled(false); //protsessimise ajaks disableb mänguakna
        
        Square square = board.getSquareAt(xcoord, ycoord); //leiab viite loogilisele ruudule
        
        if (checkMove(square)) { //kui saab võtta seda ruutu üldse
            takeSquare(square); //praegune mängija võtab ruudu
            turn();             //teeme käiku lõpetavad protsessid 

        }
        else {
            //kui ei saa võtta, siis ignoreerime? 
            //TODO - näidata mingit veateadet statusLabelil? 
        } 
            
        gameWindow.setEnabled(true); //enableme uuesti mänguakna 
    }      
    
    /**
     * Checks the legality of the attempted move. 
     * CURRENTLY NOT IMPLEMENTED. 
     * 
     * @param square The square to be checked. 
     * @return True if move is legal, false if it is not. 
     */
    private static boolean checkMove(Square square) {
        
        if (totalMoves == 0) return true;  //kui esimene käik, võib igale poole käia
                        
        //ülejäänut (hetkel) ignoreeritakse. 
        /*
        if (square.getState() == Square.SquareState.UNSELECTED &&
                hasAdjacentSelectedSquares(square)) return true;
        //TODO - ära muuta!! või panna konfist sõltuma?
        //et kas peab juba kõrval äravõetud ruut olema? 
                
        return false;  
         * 
         */
        return true; 
    }
    
    /**
     * CURRENTLY UNUSED. 
     * 
     * @param square
     * @return 
     */
    private static boolean hasAdjacentSelectedSquares(Square square) {
        //TODO!!
        return true; 
    }
    
    /**
     * Changes the square's owner to the current player. 
     * 
     * @param square The square to be occupied. 
     */
    private static void takeSquare(Square square) {
        
        //paneb ruudu omanikuks (state'ks) praeguse mängija (state) 
        square.setState(currentPlayer.getCorrespondingSquareState());
        
        totalMoves++; //lisame käikude arvule ühe
        //pushime graafilkakomponenti uuenduse - äravõetud ruut uuendada
        gameWindow.updateGridAt(square.getXCoord(), square.getYCoord());
        
        //kontrollime, kas see käik lõpetas mängu
        if (checkWin(square)) {
            //uuendame staatusteksti
            gameWindow.updateStatusLabel(currentPlayer.getWinString() + " võit!");            
            activeWin = true; //määrame muutujasse, et aktiivne mäng on läbi 
        }
    }
    
    /**
     * Performs Engine setup. 
     */
    public static void init() {
        totalMoves = 0; //alguses tehtud 0 käiku
        playerOneWins = 0; //POLE KASUTUSES - esimese mängija võidud
        playerTwoWins = 0; //POLE KASUTUSES - teise mängija võidud
        currentPlayer = Player.PLAYER_ONE; //praegune mängija - esimene mängija
        activeWin = false; //aktiivne mäng ei ole läbi 
    }
        
    /**
     * Sets up logical board. 
     */
    private static void setUpBoard() {
        board = new Board(); //tekitame uue loogilise mängulaua
    }
    
    /**
     * Sets up graphical game window. 
     */
    private static void setUpGameWindow() {
        gameWindow = new GameWindow(); //loome uue graafilise mängulaua 
        gameWindow.setVisible(true); //paneme selle nähtavaks 
    }
    
    /**
     * Disposes of the current game window and board objects and creates new ones. 
     */
    
    public static void startNewGame() {   
        if (gameWindow != null) { //kui mänguaken eksisteerib        
        gameWindow.setVisible(false); //teeme selle protsessimise ajaks nähtamatuks
        gameWindow.dispose(); //kutsume välja dispose() meetodi, mis akna hävitab
        gameWindow = null; //paneme mänguakna nulliks, et GC selle ära koristaks
        }
        
        if (board != null) { //kui loogiline mängulaud eksisteerib        
        board = null; //paneme selle nulli, et GC selle ära koristaks 
        //TODO - kontrollida, et mäluleket poleks? 
        }
        
        //loome uue loogilise mängulaua
        setUpBoard(); 
        //loome uue graafilise mänguakna
        setUpGameWindow(); 
        //paneme staatustekstiks praeguse mängija käigu
        gameWindow.updateStatusLabel(currentPlayer.getMoveString() + " käik!");        
    }   
    
    /**
     * CURRENTLY UNUSED.  
     * @param winner 
     */
    
    private static void endGame(Player winner) {
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
     * Returns board reference. 
     * 
     * @return Reference to board object. 
     */
    public static Board getBoard() {
        return board; 
    }
    
    /**
     * Returns gamewindow reference. 
     * 
     * @return Reference to gameWindow object. 
     */
    public static GameWindow getGameWindow() {
        return gameWindow; 
    }
    
    /**
     * CURRENTLY UNUSED. 
     * 
     * @return 
     */
    public static int getPlayerOneWins() {
        return playerOneWins; 
    }
    
    /**
     * CURRENTLY UNUSED. 
     * 
     * @return
     */
    public static int getPlayerTwoWins() {
        return playerTwoWins; 
    }
    
    /**
     * Enum class that represents the two players. 
     */
    public enum Player {
        PLAYER_ONE(Square.SquareState.PLAYER_ONE, "Punane", "Punase"), //esimene mängija
        PLAYER_TWO(Square.SquareState.PLAYER_TWO, "Sinine", "Sinise"); //teine mängija
        
        private String moveString;
        private String winString;
        private Square.SquareState state; //mängijale vastav ruudu olek
        private String name; //mängija "nimi"
        
        /**
         * Constructs the Player enum. 
         *
         * @param state The Square.SquareState enum that corresponds to this player. 
         * @param name Player name. 
         */
        Player(Square.SquareState state, String name, String genitive) {
            this.state = state; //määrame vastava oleku
            this.name = name;
            this.moveString = genitive;
            this.winString = genitive;//määrame nime
        }
        
        /**
         * Returns the Square.SquareState enum that corresponds to this player. 
         * 
         * @return Corresponding Square.SquareState object. 
         */
        public Square.SquareState getCorrespondingSquareState() {
            return this.state;
        }
        
        /**
         * Returns the String representation of this enum. 
         * 
         * @return String representation of this enum. 
         */
        @Override 
        public String toString() {
            return this.name; //hetkel tagastame "nime".. 
        }
        
        public String getMoveString() {
            return this.moveString;
        }
        
        public String getWinString() {
            return this.winString;
        }
    }

}
