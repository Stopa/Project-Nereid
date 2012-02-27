
package world;

public abstract class WorldObjectFactory {
    
    private WorldObjectFactory() {}; // no constructor. ever. 
    
    public PlanetTemplate createNewPlanet() {
        //TODO
        
        PlanetTemplate template = new PlanetTemplate();
        
        
        return template; 
    }        

}
