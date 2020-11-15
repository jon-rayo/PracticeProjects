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

public class SlotMachineFrame extends JFrame {
	private TilePanel pan;
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
		JMenuItem miRestart = new JMenuItem("Restart");
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
				JOptionPane.showMessageDialog(null, "Jonathan Rayo, https://github.com/jon-rayo/cpsc24500_workspace/tree/master/SlotMachineApp");
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
		c.add(pan,BorderLayout.CENTER);
		JPanel panSouth = new JPanel();
		panSouth.setLayout(new FlowLayout());
		JButton btnMax = new JButton("Max");
		panSouth.add(btnMax);
		JButton btnMid = new JButton("Mid");
		panSouth.add(btnMid);
		JButton btnMin = new JButton("Min");
		panSouth.add(btnMin);
		JLabel lblMoney = new JLabel("$");
		panSouth.add(lblMoney);
		JTextField txtMoney = new JTextField("5.00" ,5);
		panSouth.add(txtMoney);
		c.add(panSouth,BorderLayout.SOUTH);
		setupMenu();
	}
	public SlotMachineFrame() {
		setupLook();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
}
