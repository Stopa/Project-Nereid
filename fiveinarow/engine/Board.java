package fiveinarow.engine;

import fiveinarow.Configuration;

public class Board {
    
    //mänguruudustik
    private final Square[][] squaresGrid; 
    
    /**
     * Constructor with no arguments. 
     * Creates and sets up the gametable grids. 
     */
    Board() {
        //TODO - check et boardsize pole negatiivne
        //loome kahemõõtmelise ruutude (Square objektid) massiivi: 
        squaresGrid = new Square[Configuration.BOARDSIZE][Configuration.BOARDSIZE];        
        setUpGrids(); //anname ruutudele algväärtused:         
    }
    
    /**
     * Sets up the gametable grids.
     */
    
    private void setUpGrids() {    
        //kasutame nested for loope ruutude loomiseks ja algväärtustamiseks 
        //x-telg..
        for (int i = 0; i < Configuration.BOARDSIZE; i++) {
            //y-telg..
            for (int j = 0; j < Configuration.BOARDSIZE; j++) {
                //loob uue Square objekti, x=i, y=j, board=this
                squaresGrid[i][j] = new Square(i, j, this);
            }
        }
        
    }        
    
    /**
     * 
     * @param xcoord - X-axis coordinate
     * @param ycoord - Y-axis coordinate
     * @return Square object at x and y coordinates 
     */
    
    public Square getSquareAt(int xcoord, int ycoord) {
        //TODO - check - et pole arrayexception ehk koordinaadid klapiks        
        //kas handlida seda siin meetodis või väljaspool? 
                
        return squaresGrid[xcoord][ycoord]; //tagastame nende koordinaatidega ruudu
    }

}
