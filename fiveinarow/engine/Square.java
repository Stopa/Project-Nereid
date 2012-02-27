package fiveinarow.engine;

import java.awt.Color; 

import fiveinarow.Configuration; 

public class Square {
    
    private final int xcoord;
    private final int ycoord; 
    private final Board board; 
    private SquareState state; 
    
    Square(int xcoord, int ycoord, Board board) {
        this.xcoord = xcoord;
        this.ycoord = ycoord; 
        this.state = SquareState.UNSELECTED;
        this.board = board;         
    }
    
    public int getXCoord() {
        return this.xcoord; 
    }
    
    public int getYCoord() {
        return this.ycoord; 
    }
    
    public Board getBoard() {
        return this.board; 
    }
    
    public SquareState getState() {
        return this.state; 
    }
    
    public void setState(SquareState state) {
        this.state = state; 
    }
    
    
    
    
    
    public enum SquareState {
        PLAYER_ONE(Configuration.PLAYER_ONE_COLOR), 
        PLAYER_TWO(Configuration.PLAYER_TWO_COLOR), 
        UNSELECTED(Configuration.UNSELECTED_COLOR);         
        
        private final Color color; 
        
        SquareState(Color color) {
            this.color = color; 
        }
        
        public Color getColor() {
            return this.color; 
        }
    }

}
