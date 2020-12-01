import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JPanel;

/**
 * The TilePanel class consists of an ArrayList of tiles that will come from the tile class.
 * The TilePanel class also uses the TileRandomizer class to randomize the tiles in the slot machine app.
 * TilePanel extends from the JPanel family which is a lightweight component. 
 * TilePanel implements MouseListener only as our goal is to be able to click on the tiles to randomize them based on their position.
 * @author Jonathan Rayo
 *
 */
public class TilePanel extends JPanel implements MouseListener {
	private ArrayList<Tile> tiles;
	private Random rnd;
	private TileRandomizer tr;
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	/*
	 * This function will react to mouse clicks when based on the position of the tile.
	 * The position of the tile will be divided into 4 sections based on the how wide the frame is. 
	 * These clicks use the setRandomly function from the tile class to randomize the tiles based on shape and color.
	 */
	public void mouseClicked(MouseEvent e) {
		rnd = new Random();
		int whichTile = e.getX()/(this.getWidth()/4);
		Tile tile = tiles.get(whichTile);
		tile.setRandomly(rnd);
		repaint();
	}
	/*
	 * TilePanel is public for viewing.
	 * Tiles are created from the ArrayList and are set to randomize themselves using the TileRandomizer class.
	 * There is a MouseListener needed to react to the mouse clicks so the tiles can be randomized. 
	 */
	public TilePanel() {
		tiles = new ArrayList<Tile>();
		tr = new TileRandomizer();
		tiles = tr.randomizeTiles();
		addMouseListener(this);
	}
	/*
	 * This is the function that will take in the tiles and set them randomly.
	 * This is used for when the user clicks on the max, mid, or min buttons.
	 * This is also used for when the user restarts the game.
	 */
	public void randomizeSlots() {
		rnd = new Random();
		for (Tile tile : tiles) {
			tile.setRandomly(rnd);
		}
	}
	/**
	 * 
	 * @return the tiles created.
	 */
	public ArrayList<Tile> getTiles() {
		return tiles;
	}
	/**
	 * 
	 * @param tiles the list of tiles.
	 */
	public void setTiles(ArrayList<Tile> tiles) {
		this.tiles = tiles;
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int cellWidth = this.getWidth() / 4;
		int tileSize = 4*cellWidth/5;
		int shape;
		Color color;
		Tile tile;
		for (int i = 0; i < tiles.size(); i++) {
			tile = tiles.get(i);
			shape = tile.getShape();
			color = tile.getActualColor();
			g.setColor(color);
			if (shape == 0) {
				g.fillOval(i*cellWidth + cellWidth/10, cellWidth/10, tileSize, tileSize); 
			} else if (shape == 1) {
				g.fillRect(i*cellWidth + cellWidth/10, cellWidth/10, tileSize, tileSize);
			} 
		}
	}

}