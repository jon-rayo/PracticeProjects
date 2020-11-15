import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import javax.swing.JPanel;

public class TilePanel extends JPanel implements MouseListener {
	private String mouseStatus;
	private ArrayList<Tile> tiles;	
	private Tile tile1 = new Tile();
	private Tile tile2 = new Tile();
	private Tile tile3 = new Tile();
	private Tile tile4 = new Tile();
	private int y;
	private int tileHeight;
	private int tileWidth;
	
	public ArrayList<Tile> getTiles() {
		return tiles;
	}
	public void setTiles(ArrayList<Tile> listOfTiles) {
		tiles = listOfTiles; // the list of the tiles.
	}
	public TilePanel() {
		tiles = new ArrayList<Tile>();
		addMouseListener(this);
		y = 75; 
		tileHeight = 150;
		tileWidth = 150;
		tiles.add(tile1);
		tiles.add(tile2);
		tiles.add(tile3);
		tiles.add(tile4);
		tile1.setRandomly();
		tile2.setRandomly();
		tile3.setRandomly();
		tile4.setRandomly();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		int noOfTile = 0; // we starts with 0 tiles and draw them as the porgram advances. 
		super.paintComponent(g);
		for (Tile tile : tiles) {
			if (tile.getTileShape() == 0 && tile.getTileColor() == 0) { // red square
				g.setColor(Color.RED);
				if (noOfTile == 0) {
					g.fillRect(10, y, tileWidth, tileHeight);
					noOfTile = 1+noOfTile; 
				}
				else if ( noOfTile == 1) {
					g.fillRect(200, y, tileWidth, tileHeight);
					noOfTile = 1+noOfTile;
				}
				else if (noOfTile == 2) {
					g.fillRect(400, y, tileWidth, tileHeight);
					noOfTile = 1+ noOfTile;
				}
				else if (noOfTile == 3) {
					g.fillRect(600, y, tileWidth, tileHeight);
				}
			}
			else if (tile.getTileShape() == 0 && tile.getTileColor() == 1) { // blue square
				g.setColor(Color.BLUE);
				if (noOfTile == 0) {
					g.fillRect(10, y, tileWidth, tileHeight);
					noOfTile = 1+noOfTile; 
				}
				else if ( noOfTile == 1) {
					g.fillRect(200, y, tileWidth, tileHeight);
					noOfTile = 1+noOfTile;
				}
				else if (noOfTile == 2) {
					g.fillRect(400, y, tileWidth, tileHeight);
					noOfTile = 1+ noOfTile;
				}
				else if (noOfTile == 3) {
					g.fillRect(600, y, tileWidth, tileHeight);
				}
			}
			else if (tile.getTileShape() == 0 && tile.getTileColor() == 2) { // orange square
				g.setColor(Color.ORANGE);
				if (noOfTile == 0) {
					g.fillRect(10, y, tileWidth, tileHeight);
					noOfTile = 1+noOfTile; 
				}
				else if ( noOfTile == 1) {
					g.fillRect(200, y, tileWidth, tileHeight);
					noOfTile = 1+noOfTile;
				}
				else if (noOfTile == 2) {
					g.fillRect(400, y, tileWidth, tileHeight);
					noOfTile = 1+ noOfTile;
				}
				else if (noOfTile == 3) {
					g.fillRect(600, y, tileWidth, tileHeight);
				}
			}
			else if (tile.getTileShape() == 0 && tile.getTileColor() == 3) { // yellow square
				g.setColor(Color.YELLOW);
				if (noOfTile == 0) {
					g.fillRect(10, y, tileWidth, tileHeight);
					noOfTile = 1+noOfTile; 
				}
				else if ( noOfTile == 1) {
					g.fillRect(200, y, tileWidth, tileHeight);
					noOfTile = 1+noOfTile;
				}
				else if (noOfTile == 2) {
					g.fillRect(400, y, tileWidth, tileHeight);
					noOfTile = 1+ noOfTile;
				}
				else if (noOfTile == 3) {
					g.fillRect(600, y, tileWidth, tileHeight);
				}
			}
			else if (tile.getTileShape() == 0 && tile.getTileColor() == 4) { // green square
				g.setColor(Color.GREEN);
				if (noOfTile == 0) {
					g.fillRect(10, y, tileWidth, tileHeight);
					noOfTile = 1+noOfTile; 
				}
				else if ( noOfTile == 1) {
					g.fillRect(200, y, tileWidth, tileHeight);
					noOfTile = 1+noOfTile;
				}
				else if (noOfTile == 2) {
					g.fillRect(400, y, tileWidth, tileHeight);
					noOfTile = 1+ noOfTile;
				}
				else if (noOfTile == 3) {
					g.fillRect(600, y, tileWidth, tileHeight);
				}
			}
			else if (tile.getTileShape() == 1 && tile.getTileColor() == 0) { // red circle 
				g.setColor(Color.RED);
				if (noOfTile == 0) {
					g.fillOval(10, y, tileWidth, tileHeight);
					noOfTile = 1+noOfTile; 
				}
				else if ( noOfTile == 1) {
					g.fillOval(200, y, tileWidth, tileHeight);
					noOfTile = 1+noOfTile;
				}
				else if (noOfTile == 2) {
					g.fillOval(400, y, tileWidth, tileHeight);
					noOfTile = 1+ noOfTile;
				}
				else if (noOfTile == 3) {
					g.fillOval(600, y, tileWidth, tileHeight);
				}
			}
			else if (tile.getTileShape() == 1 && tile.getTileColor() == 1) { // blue circle 
				g.setColor(Color.BLUE);
				if (noOfTile == 0) {
					g.fillOval(10, y, tileWidth, tileHeight);
					noOfTile = 1+noOfTile; 
				}
				else if ( noOfTile == 1) {
					g.fillOval(200, y, tileWidth, tileHeight);
					noOfTile = 1+noOfTile;
				}
				else if (noOfTile == 2) {
					g.fillOval(400, y, tileWidth, tileHeight);
					noOfTile = 1+ noOfTile;
				}
				else if (noOfTile == 3) {
					g.fillOval(600, y, tileWidth, tileHeight);
				}
			}
			else if (tile.getTileShape() == 1 && tile.getTileColor() == 2) { // orange circle 
				g.setColor(Color.ORANGE);
				if (noOfTile == 0) {
					g.fillOval(10, y, tileWidth, tileHeight);
					noOfTile = 1+noOfTile; 
				}
				else if ( noOfTile == 1) {
					g.fillOval(200, y, tileWidth, tileHeight);
					noOfTile = 1+noOfTile;
				}
				else if (noOfTile == 2) {
					g.fillOval(400, y, tileWidth, tileHeight);
					noOfTile = 1+ noOfTile;
				}
				else if (noOfTile == 3) {
					g.fillOval(600, y, tileWidth, tileHeight);
				}
			}
			else if (tile.getTileShape() == 1 && tile.getTileColor() == 3) { // yellow circle 
				g.setColor(Color.YELLOW);
				if (noOfTile == 0) {
					g.fillOval(10, y, tileWidth, tileHeight);
					noOfTile = 1+noOfTile; 
				}
				else if ( noOfTile == 1) {
					g.fillOval(200, y, tileWidth, tileHeight);
					noOfTile = 1+noOfTile;
				}
				else if (noOfTile == 2) {
					g.fillOval(400, y, tileWidth, tileHeight);
					noOfTile = 1+ noOfTile;
				}
				else if (noOfTile == 3) {
					g.fillOval(600, y, tileWidth, tileHeight);
				}
			}
			else if (tile.getTileShape() == 1 && tile.getTileColor() == 4) { // green circle 
				g.setColor(Color.GREEN);
				if (noOfTile == 0) {
					g.fillOval(10, y, tileWidth, tileHeight);
					noOfTile = 1+noOfTile; 
				}
				else if ( noOfTile == 1) {
					g.fillOval(200, y, tileWidth, tileHeight);
					noOfTile = 1+noOfTile;
				}
				else if (noOfTile == 2) {
					g.fillOval(400, y, tileWidth, tileHeight);
					noOfTile = 1+ noOfTile;
				}
				else if (noOfTile == 3) {
					g.fillOval(600, y, tileWidth, tileHeight);
				}
			}
		}
	}
	public String getMouseStatus() {
		return mouseStatus;
	}
	public void setMouseStatus(String ms) {
		mouseStatus = ms;
	}
	public void mouseClicked(MouseEvent e) { 
		TileWriter dw = new TileWriter();
		dw.writeToText("tiles.txt", tiles);
		if (e.getX() > 10 && e.getX() < 150 && e.getY() > y && e.getY() < 230) { // first tile
			tile1.setRandomly();
			repaint();
		}
		else if (e.getX() > 200 && e.getX() < 350 && e.getY() > y && e.getY() < 230) { // second tile
			tile2.setRandomly();
			repaint();
		}
		else if ( e.getX() > 400 && e.getX() < 550 && e.getY() > y && e.getY() < 230) { // third tile
			tile3.setRandomly();
			repaint();
		}
		else if (e.getX() > 600 && e.getX() < 750 && e.getY() > y && e.getY() < 230) { // fourth tile
			tile4.setRandomly();
			repaint();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}