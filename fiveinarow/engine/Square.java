package fiveinarow.engine;

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
    
    
    public void handleClick() {
        //TODO - disable the game window!!!!!
        
        if (Engine.checkMove(this)) {            
            //TODO - disable this button? 
            Engine.takeSquare(this);
            Engine.turn(); 
        }
        else {
            //TODO - anything? 
        }
        
        //TODO - enable the game window 
    }    
    
    
    
    public enum SquareState {
        PLAYER_ONE, PLAYER_TWO, UNSELECTED; 
        //TODO
    }

}
