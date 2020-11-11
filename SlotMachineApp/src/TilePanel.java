import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import javax.swing.JPanel;

public class TilePanel extends JPanel implements MouseListener {
	private ArrayList<Tile> tiles;	
	
	public void clearTiles() {
		tiles.clear();
	}
	
	public ArrayList<Tile> getTiles() {
		return tiles;
	}
	public void setTiles(ArrayList<Tile> listofTiles) {
		tiles = listofTiles;
	}
	public TilePanel() {
		addMouseListener(this);
		tiles = new ArrayList<Tile>();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.ORANGE);
		g.fillOval(10, 75, 150, 150);
		g.setColor(Color.BLUE);
		g.fillRect(200, 75, 150, 150);
		g.setColor(Color.RED);
		g.fillRect(400, 75, 150, 150);
		g.fillRect(600, 75, 150, 150);
	}
	public void mouseClicked(MouseEvent e) { 
		TileWriter dw = new TileWriter();
		dw.writeToText("tiles.txt", tiles);
		repaint();
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