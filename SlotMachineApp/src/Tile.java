import java.io.Serializable;
import java.util.Random;
import java.awt.Color;
/**
 * The Tile class is the base for the entire application
 * It implements Serializable to be able to read in data from supported file formats.
 * Will determine the tiles along with their shapes and sizes.
 * Contains a setRandomly function that sets the color and shape to be random.
 * @author Jonathan Rayo
 *
 */
public class Tile implements Serializable {
	private static final Color[] colors = {Color.YELLOW, Color.GREEN, Color.ORANGE, Color.RED, Color.BLUE};
	private static final String[] colorNames = {"yellow","green","orange","red","blue"};
	private static final String[] shapes = {"circle","square"};
	private int color; //0 - yellow, 1 - green, 2 - orange, 3 - red, 4 - blue
	private int shape; // 0 - circle, 1 - square
	/*
	 * setting the tiles to red and shape to circle
	 * This is the default constructor class.
	 */
	public Tile() {
		color = 3;
		shape = 0;
	}
	/**
	 * Non-default constructor class that takes in the color and shape. 
	 * @param color the color of the tile
	 * @param shape the shape of the tile
	 */
	public Tile(int color, int shape) {
		setColor(color);
		setShape(shape);
	}
	/**
	 * 
	 * @return the color of tile as an int.
	 */
	public int getColor() {
		return color;
	}
	/**
	 * Set the color of the tile.
	 * @param color the color of the tile in terms of an int.
	 */
	public void setColor(int color) {
		if (color < 0) {
			this.color = 0;
		} else if (color > 4) {
			this.color = 4;
		} else {
			this.color = color;
		}
	}
	/**
	 * 
	 * @param rnd uses custom random to determine the color and shape of the tiles at random.
	 */
	public void setRandomly(Random rnd) {
		color = rnd.nextInt(colors.length);
		shape = rnd.nextInt(shapes.length);
	}
	/**
	 * 
	 * @return the key which is the color.
	 * This helps us use the colors as an array.
	 */
	public Color getActualColor() {
		return colors[color];
	}
	/**
	 * 
	 * @return the key which is the color as a string. This helps us write out the color as
	 * a string using the colorNames array.
	 */
	public String getColorName() {
		return colorNames[color];
	}
	/**
	 * 
	 * @return the shape of the tile as an int.
	 */
	public int getShape() {
		return shape; 
	}
	/**
	 * Set the shape of the tile.
	 * @param shape the shape of the tile in terms of an int.
	 */
	public void setShape(int shape) {
		if (shape < 0) {
			this.shape = 0;
		} else if (shape > 1) {
			this.shape = 1;
		} else {
			this.shape = shape;
		}
	}
	/**
	 * 
	 * @return the Key which is the shape as a string. This helps us write out the shape 
	 * as a string using the shapes array.
	 */
	public String getShapeAsString() {
		return shapes[shape];
	}
	/**
	 * 
	 * @return String that will show the color and shape as their actual shapes and colors currently.
	 */
	public String toStringFancy() {
		return String.format("%s %s", getColorName(), getShapeAsString());
	}
	@Override
	/**
	 * Returns the ints current for the color and shape of tiles.
	 */
	public String toString() {
		return String.format("%d %d",color,shape);
	}
	public int getCode() {
		return color*10+shape;
	}

}

