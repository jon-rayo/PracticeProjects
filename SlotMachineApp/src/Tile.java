import java.io.Serializable;

public class Tile implements Serializable {
	private int x;
	private int y;
	private int tileWidth;
	private int tileHeight;
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getTileWidth() {
		return tileWidth;
	}
	public int getTileHeight() {
		return tileHeight;
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public void setTileWidth(int width) {
		tileWidth = width;
	}
	public void setTileHeight(int height) {
		tileHeight = height;
	}
	public Tile() {
		x = 100;
		y = 75;
		tileWidth = 100;
		tileHeight = 100;
	}
	public Tile(int x, int y, int width, int height) {
		setX(x);
		setY(y);
		setTileWidth(width);
		setTileHeight(height);
	}
	@Override
	public String toString() {
		return String.format("%d %d %d %d", x, y, tileWidth, tileHeight);
	}
}

