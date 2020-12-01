import java.util.ArrayList;
import java.util.Random;

public class TileRandomizer {
	private ArrayList<Tile> tiles;
	private Random rnd;
	
	/**
	 * This function will randomize the tiles at the beginning and after the
	 * user clicks on max,mid,min buttons.
	 * @return tiles on screen.
	 */
	public ArrayList<Tile> randomizeTiles(){
		tiles = new ArrayList<Tile>();
		Tile tile;
		rnd = new Random();
		for (int i = 0;i<4; i++) {
			tile = new Tile();
			tile.setRandomly(rnd);
			tiles.add(tile);
		}
		return tiles;
	}
	
}
	

 