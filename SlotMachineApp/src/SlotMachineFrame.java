import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 * The SlotMachineFrame class sets up the way the application will look.
 * This class will show the tiles displayed on the screen.
 * This is how the user interacts with the application.
 * This class sets up the menu.
 * The SlotMachineFrame extends as a JFrame which includes all of JFrame's attributes.
 * @author Jonathan Rayo
 *
 */
public class SlotMachineFrame extends JFrame {
	private TilePanel pan;
	private JTextField txtMoney;
	private JButton btnMax, btnMid, btnMin;
	private double  money = 5.00;
	private double bet;
	private TileChecker tc;
	
	
	/*
	 * This function will allow the frame to be centered on the desktop
	 */
	public void centerFrame(int width, int height) {
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenDims = tk.getScreenSize();
		int screenWidth = (int)screenDims.getWidth();
		int screenHeight = (int)screenDims.getHeight();
		int left = (screenWidth - width)/2;
		int top = (screenHeight - height)/2;
		setBounds(left,top,width,height);
	}
	/**
	 * This will set up the way the menu will look like
	 * with the drop down menu
	 * 
	 */
	public void setupMenu() {
		JMenuBar mbar = new JMenuBar();
		JMenu mnuFile = new JMenu("File");
		JMenuItem miSave = new JMenuItem("Save Tiles");
		miSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser();
				TileWriter tw;
				if (jfc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
					tw = new TileWriter();
					if (tw.write(jfc.getSelectedFile(),pan.getTiles())) {
						JOptionPane.showMessageDialog(null, "Tiles were written");
					} else {
						JOptionPane.showMessageDialog(null, "Tiles could not be written");
					}
				}
			}
		});
		JMenuItem miLoad = new JMenuItem("Load Tiles");
		miLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser();
				TileReader tr;
				ArrayList<Tile> tilesRead;
				if (jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					tr = new TileReader();
					tilesRead = tr.read(jfc.getSelectedFile());
					if (tilesRead == null) {
						JOptionPane.showMessageDialog(null, "Could not be read.");
					} else {
						pan.setTiles(tilesRead);
						repaint();
					}
				}
			}
		});
		JMenuItem miPrint = new JMenuItem("Print");
		miPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Tile> tiles = pan.getTiles();
				for (Tile tile : tiles) {
					System.out.println(tile.toStringFancy());
				}
			}
		});
		JMenuItem miRestart = new JMenuItem("Restart");
		miRestart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				money = 5.00;
				pan.randomizeSlots(); // randomizes the tiles when restarting.
				btnMax.setEnabled(true);
				btnMid.setEnabled(true);
				btnMin.setEnabled(true);
				txtMoney.setText(String.format("%.2f", 5.0));
				repaint(); // draw the tiles
			}
		});
		JMenuItem miExit = new JMenuItem("Exit");
		miExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnuFile.add(miSave);
		mnuFile.add(miLoad);
		mnuFile.add(miPrint);
		mnuFile.add(miRestart);
		mnuFile.add(miExit);
		mbar.add(mnuFile);
		JMenu mnuHelp = new JMenu("Help");
		JMenuItem miAbout = new JMenuItem("About");
		miAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Jonathan Rayo, 'https://github.com/jon-rayo/cpsc24500_workspace' ");
			}
		});
		mnuHelp.add(miAbout);
		mbar.add(mnuHelp);
		setJMenuBar(mbar);
	}
	/**
	 * Sets up the way the frame will look like when the application starts
	 */
	public void setupLook() {
		centerFrame(800,400);
		setTitle("Vegas Baby, Vegas! Slot Machine");
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		pan = new TilePanel();
		tc = new TileChecker();
		ArrayList<Tile> tiles = pan.getTiles(); // will be used for the tiles to be checked.
		c.add(pan,BorderLayout.CENTER);
		JPanel panSouth = new JPanel();
		panSouth.setLayout(new FlowLayout());
		btnMax = new JButton("Max");
		panSouth.add(btnMax);
		btnMax.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bet = money; // getting the money set to the amount bet.
				money = tc.checkMax(tiles, bet); // set money = to the checkMax function that takes in the tiles and amount bet.
				txtMoney.setText(String.format("%.2f", money)); // prints the updated money to the JTxtField
				if (money <= 0) {
					btnMax.setEnabled(false);
					btnMid.setEnabled(false);
					btnMin.setEnabled(false);
				} else {
					btnMax.setEnabled(true);
					btnMid.setEnabled(true);
					btnMin.setEnabled(true);
				}
				pan.randomizeSlots();
				repaint();
			}
		});
		btnMid = new JButton("Mid");
		panSouth.add(btnMid);
		btnMid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bet = money/2;// getting the money set to the amount bet/2 since mid is half.
				money = tc.checkMid(tiles, bet); // set money = to the checkMid function that takes in the tiles and amount bet.
				txtMoney.setText(String.format("%.2f", money)); // prints the updated money to the JTxtField
				if (money <= 0) {
					btnMax.setEnabled(false);
					btnMid.setEnabled(false);
					btnMin.setEnabled(false);
				} else {
					btnMax.setEnabled(true);
					btnMid.setEnabled(true);
					btnMin.setEnabled(true);
				}
				pan.randomizeSlots();
				repaint();
			}
		});
		btnMin = new JButton("Min");
		panSouth.add(btnMin);
		btnMin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bet = money/10; // getting the money set to the amount bet/10 since min is 10%.
				money = tc.checkMin(tiles, bet); // set money = to the checkMin function that takes in the tiles and amount bet.
				txtMoney.setText(String.format("%.2f", money));
				if (money <= 0) {
					btnMax.setEnabled(false);
					btnMid.setEnabled(false);
					btnMin.setEnabled(false);
				} else {
					btnMax.setEnabled(true);
					btnMid.setEnabled(true);
					btnMin.setEnabled(true);
				}
				pan.randomizeSlots();
				repaint();
			}
		});
		c.add(panSouth,BorderLayout.SOUTH);
		JLabel lblMoney = new JLabel("$");
		panSouth.add(lblMoney);
		txtMoney = new JTextField(6);
		txtMoney.setEditable(false);
		txtMoney.setText(String.format("%.2f", 5.0));
		panSouth.add(txtMoney);
		setupMenu();
	}
	public SlotMachineFrame() {
		setupLook();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
}
