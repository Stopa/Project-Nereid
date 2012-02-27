package fiveinarow.engine;

import fiveinarow.Configuration;

public class Board {
    
    private final Square[][] squaresGrid; 
    
    Board() {
        //TODO - check et boardsize pole negatiivne
        squaresGrid = new Square[Configuration.BOARDSIZE][Configuration.BOARDSIZE];
        setUpGrids(); 
    }
    
    private void setUpGrids() {
        
        for (int i = 0; i < Configuration.BOARDSIZE; i++) {
            for (int j = 0; j < Configuration.BOARDSIZE; j++) {
                squaresGrid[i][j] = new Square(i, j, this);
            }
        }
        
    }        
    
    public Square getSquareAt(int xcoord, int ycoord) {
        //TODO - check - et pole arrayexception 
        return squaresGrid[xcoord][ycoord];
    }

}
