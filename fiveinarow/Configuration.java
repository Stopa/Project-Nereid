package fiveinarow;

import java.awt.Color; 
import java.util.ArrayList;
import fiveinarow.engine.Square;

public abstract class Configuration {
    
    private Configuration() {}; //no constructor 
    
    public static GameSize BOARDSIZE = GameSize.THIRTY; //mängulaua mõõtmed (nii loogiline kui graafiline)
    
    public static final int GAMEWINDOW_HEIGHT = 800; //mänguakna kõrgus
    public static final int GAMEWINDOW_WIDTH = 700;  //mänguakna laius
    
    public static final int GAMEPANEL_HEIGHT = 600; //nuppude paneeli kõrgus
    public static final int GAMEPANEL_WIDTH = 600; //nuppude paneeli laius
    public static final int GAMEPANEL_POSX = 50; //nuppude paneeli x-telje positsioon 
    public static final int GAMEPANEL_POSY = 75; //nuppude paneeli y-telje positsioon
    
    public static final int STATUSLABEL_HEIGHT = 100; //staatusteksti kõrgus
    public static final int STATUSLABEL_WIDTH = 400; //staatusteksti laius
    public static final int STATUSLABEL_POSX = 200; //staatusteksti x-telje positsioon
    public static final int STATUSLABEL_POSY = 680; //staatusteksti y-telje positsioon
    
    public static final int READ_ME_POSX = 550;
    public static final int READ_ME_POSY = 25;
    public static final int READ_ME_SIZE_X = 100;
    public static final int READ_ME_SIZE_Y = 25;
    public static final String READ_ME_CONTENT = "Five in a row on mäng, kus osalejad peavad "
                                               + "kordamööda värvima ruute.\n"
                                               + "Kes enne 5 järjestikust ruutu oma värviga värvitud "
                                               + "saab on võitja.\nNii lihtne see ongi.";
    
    public static PlayerColor PLAYER_ONE_COLOR = PlayerColor.RED; //esimese mängija värv
    public static PlayerColor PLAYER_TWO_COLOR = PlayerColor.BLUE; //teise mängija värv
    public static final Color UNSELECTED_COLOR = Color.WHITE; //valimata ruudu värv
    
    /**
     * mängija värvid
     * @author Stopa
     *
     */
    public enum PlayerColor {
    	BLUE(Color.BLUE, "Sinine"),
    	RED(Color.RED, "Punane"),
    	GREEN(Color.GREEN, "Roheline"),
    	YELLOW(Color.YELLOW, "Kollane"),
    	PINK(Color.PINK, "Roosa"),
    	BLACK(Color.BLACK, "Must");
    	
    	private Color color;
    	private String name;
    	
    	PlayerColor(Color varv, String nimi) {
    		this.color = varv;
    		this.name = nimi;
    	}
    	
    	@Override
    	public String toString() {
    		return this.name;
    	}
    	
    	public Color getColor() {
    		return this.color;
    	}
    	
    	/**
    	 * tagastab värvi nime järgi enumi objekti
    	 * @param name
    	 * @return
    	 */
    	public static PlayerColor get(String name) {
    		for(PlayerColor obj: values()) {
    			if(obj.name.equals(name)) {
    				return obj;
    			}
    		}
    		throw new IllegalArgumentException(name);
    	}
    }
    
    /**
     * hoiab erinevaid akna suurusi
     * @author Stopa
     *
     */
    public enum GameSize {
    	TEN(10),
    	TWENTY(20),
    	THIRTY(30);
    	
    	private int size;
    	
    	GameSize(int suurus) {
    		this.size = suurus;
    	}
    	
    	@Override
    	public String toString() {
    		return String.valueOf(this.size);
    	}
    	
    	public int getSize() {
    		return this.size;
    	}
    	
    	public static GameSize get(int size) {
    		for(GameSize obj:values()) {
    			if(obj.size == size) {
    				return obj;
    			}
    		}
    		throw new IllegalArgumentException(String.valueOf(size));
    	}
    }
    
    /**
     * stringide massiiv sätete akna JComboBox jaoks
     * @return
     */
    public static String[] getColorsArray() {
    	ArrayList<String> result = new ArrayList();
    	
    	for(PlayerColor color:PlayerColor.values()) {
    		result.add(color.toString());
    	}
    	
    	return result.toArray(new String[result.size()]);
    }
    
    public static String[] getGameSizeArray() {
    	ArrayList<String> result = new ArrayList();
    	
    	for(GameSize size:GameSize.values()) {
    		result.add(size.toString());
    	}
    	
    	return result.toArray(new String[result.size()]);
    }
    
    /**
     * paneme uue värvi muutujasse ja uuendame ka SquareState enumis olevat värvi
     * @param color
     */
    
    public static void setP1Color(String color) {
    	PLAYER_ONE_COLOR = PlayerColor.get(color);
    	Square.SquareState.PLAYER_ONE.setColor(PLAYER_ONE_COLOR.getColor());
    }
    
    public static void setP2Color(String color) {
    	PLAYER_TWO_COLOR = PlayerColor.get(color);
    	Square.SquareState.PLAYER_TWO.setColor(PLAYER_TWO_COLOR.getColor());
    }
    
    public static void setGameSize(String size) {
    	BOARDSIZE = GameSize.get(Integer.parseInt(size));
    }
}
