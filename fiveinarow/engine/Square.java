package fiveinarow.engine;

import java.awt.Color; 

import fiveinarow.Configuration; 

public class Square {
    
    private final int xcoord; //selle ruudu x-koordinaat mängulaual
    private final int ycoord;  //selle ruudu y-koordinaat mängulaual
    private final Board board;  //viide mängulaua objektile
    private SquareState state; //selle ruudu "seis" - kellele "kuulub" 
    
    /**
     * Square constructor. Creates a new Square object. 
     * 
     * @param xcoord x-coordinate on the gameboard. 
     * @param ycoord y-coordinate on the gameboard. 
     * @param board gameboard reference. 
     */
    Square(int xcoord, int ycoord, Board board) {
        this.xcoord = xcoord; //määrame x-koordinaadi
        this.ycoord = ycoord; //määrame y-koordinaadi
        this.state = SquareState.UNSELECTED; //algväärtuseks paneme, et ruut pole ühegi mängija oma
        this.board = board; //defineerime viite mängulauale 
    }
    
    /**
     * Returns this Square's x-coordinate as an integer. 
     * @return This square's x-coordinate on the gameboard. 
     */
    public int getXCoord() {
        return this.xcoord; 
    }
    
    /**
     * Returns y-coordinate as an integer.
     * @return This square's x-coordinate on the gameboard. 
     */
    public int getYCoord() {
        return this.ycoord; 
    }
    
    /**
     * Returns board reference. 
     * @return The board reference. 
     */
    public Board getBoard() {
        return this.board; 
    }
    
    /**
     * Returns square's state. 
     * @return Square.SquareState enum reference. 
     */
    public SquareState getState() {
        return this.state; 
    }
    
    /**
     * Sets the square's state. 
     * @param state Sets square's state to the parameter. 
     */
    public void setState(SquareState state) {
        this.state = state; 
    }
    
    
    
    
    /**
     * Enum class representing Square's owner/state. 
     */
    public enum SquareState {
        PLAYER_ONE(Configuration.PLAYER_ONE_COLOR.getColor()), //esimene mängija
        PLAYER_TWO(Configuration.PLAYER_TWO_COLOR.getColor()), //teine mängija
        UNSELECTED(Configuration.UNSELECTED_COLOR); //valimata (algväärtus)
        
        private Color color; //graafikas kasutatud värv selle olekuga ruutude jaoks
        
        /**
         * SquareState constructor. 
         * @param color Sets the color used in the graphical representation for this state. 
         */
        SquareState(Color color) {
            this.color = color; 
        }
        
        /**
         * Returns the Color object used for this enum. 
         * @return Color object associated with this state. 
         */
        public Color getColor() {
            return this.color; 
        }
        
        /**
         * Paneb enumi väärtuseks uue värvi - kasutusel sätete aknas
         * @param newColor
         */
        public void setColor(Color newColor) {
        	this.color = newColor;
        }
    }

}
