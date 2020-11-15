import java.io.Serializable;
import java.util.Random;

public class Tile implements Serializable {
	private int tileColor;
	private int tileShape;
	
	public int getTileColor() {
		return tileColor;
	}
	public int getTileShape() {
		return tileShape;
	}
	/**
	 * 
	 * @param ts the shape it will be 
	 * 0 for squares
	 * 1 for circle
	 */
	public void setTileShape(int ts) {
		if (ts == 0) {
			tileShape = 0; // square
		}
		else {
			tileShape = 1; // circle
		}
	}
	/**
	 * 
	 * @param tc the color it will have
	 * 0 for red
	 * 1 for blue
	 * 2 for orange
	 * 3 for yellow
	 * 4 for green
	 */
	public void setTileColor (int tc) {
		if (tc == 0) {
			tileColor = 0; // red
		}
		else if ( tc == 1) {
			tileColor = 1; // blue
		}
		else if (tc == 2) {
			tileColor =2; // orange
		}
		else if (tc == 3) {
			tileColor = 3; // yellow
		}
		else if (tc == 4) { // green
			tileColor = 4;
		}
	}
	public void setRandomly() {
		Random rnd = new Random ();
		this.tileShape = rnd.nextInt(2);
		this.tileColor = rnd.nextInt(5);
	}
	public Tile() {
		tileColor = 0;
		tileShape = 0;
	}
	public Tile( int color, int shape) {
		setTileColor(color);
		setTileShape(shape);
	}
	@Override
	public String toString() {
		return String.format("%d %d", tileColor, tileShape);
	}
}

