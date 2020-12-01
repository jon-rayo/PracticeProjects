import java.util.ArrayList;

/**
 * The TileChecker class will be used to check the tiles and see if the colors and shapes match,
 * just colors, or the shapes. 
 * If nothing matches the user will loose amount they chose to bet.
 * @author Jonathan Rayo
 *
 */
public class TileChecker {
	private double money;
	private int shape, color, nextShape, nextColor;
	private boolean sameColor, sameShape;
	private Tile tile;
	private Tile nextTile;
	
	/**
	 * 
	 * This is the checkMax function which will reward 100 times the amount bet if everything matches
	 * Will reward 25 times if the colors match.
	 * Will take away all the money bet. 
	 * This function will take in an ArrayList of tiles and the amount the user bet.
	 * It will check if the tiles match in terms of shape and color.
	 * @param tiles ArrayList of tiles
	 * @param bet the amount the user bet
	 * @return the money lost or earned.
	 */
	public double checkMax(ArrayList<Tile> tiles, double bet) {
		money = bet;
		sameColor = true;
		sameShape = true;
		tile = tiles.get(0);
		shape = tile.getShape();
		color = tile.getColor();
		for (int i = 1; i<tiles.size();i++) {
			nextTile = tiles.get(i);
			nextShape = nextTile.getShape();
			nextColor = nextTile.getColor();
			if (shape != nextShape) {
				sameShape = false;
			}
			else if(color != nextColor) {
				sameColor = false;
			}
		}
		if (sameShape == true && sameColor == true) {
			money = money + (100*bet);
		} else if(sameColor == true) {
			money = money + (25*bet);
		}else {
			money = money - bet;
		}
		return money;
	}
	/**
	 * 
	 * This is the checkMid function which will reward 50 times the amount bet if everything matches
	 * Will reward 10 times if the colors match.
	 * Will take away the money bet. 
	 * This function will take in an ArrayList of tiles and the amount the user bet.
	 * It will check if the tiles match in terms of shape and color.
	 * @param tiles ArrayList of tiles
	 * @param bet the amount the user bet
	 * @return the money lost or earned.
	 */
	public double checkMid(ArrayList<Tile> tiles, double bet) {
		money = bet;
		sameColor = true;
		sameShape = true;
		tile = tiles.get(0);
		shape = tile.getShape();
		color = tile.getColor();
		for (int i = 1; i<tiles.size();i++) {
			nextTile = tiles.get(i);
			nextShape = nextTile.getShape();
			nextColor = nextTile.getColor();
			if (shape != nextShape) {
				sameShape = false;
			}
			if(color != nextColor) {
				sameColor = false;
			}
		}
		if (sameShape == true && sameColor == true) {
			money = money + (50*bet);
		} else if(sameColor == true) {
			money = money + (10*bet);
		}else {
			money = money - bet;
		}
		return money;
	}
	/**
	 * 
	 * This is the checkMax function which will reward 10 times the amount bet if everything matches
	 * Will reward 5 times if the colors match.
	 * Will take away the money bet. 
	 * This function will take in an ArrayList of tiles and the amount the user bet.
	 * It will check if the tiles match in terms of shape and color.
	 * @param tiles ArrayList of tiles
	 * @param bet the amount the user bet
	 * @return the money lost or earned.
	 */
	public double checkMin(ArrayList<Tile> tiles, double bet) {
		money = bet;
		sameColor = true;
		sameShape = true;
		tile = tiles.get(0);
		shape = tile.getShape();
		color = tile.getColor();
		for (int i = 1; i<tiles.size();i++) {
			nextTile = tiles.get(i);
			nextShape = nextTile.getShape();
			nextColor = nextTile.getColor();
			if (shape != nextShape) {
				sameShape = false;
			}
			if(color != nextColor) {
				sameColor = false;
			}
		}
		if (sameShape == true && sameColor == true) {
			money = money + (10*bet);
		} else if(sameColor == true) {
			money = money + (5*bet);
		}else {
			money = money - bet;
		}
		return money;
	}


	
}
	