import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
/*
 * This class is named PumpkinPanel and is an extension of the imported JPanel class.
 * This contains all the options and defaults for the nose, eyes, and mouth.
 * This also contains defaults for user so the pumpkin doesn't go off screen.
 * This class is accessible later to be added to the main public class and be displayed as the application.
 */
class PumpkinPanel extends JPanel {
	private String eyeShape;
	private String noseShape;
	private String mouthShape;
	private int left;
	private int top;
	private int pumpHeight;
	private int pumpWidth;
	
	/*
	 * Returns eyeShape as the default constructor.
	 */
	public String getEyeShape() {
		return eyeShape;
	}
	
	/*
	 * This is the non-default constructor for the eyeShape.
	 * This what the user is allowed to type in the panel.
	 */
	public void setEyeShape(String  e) {
		if (e.equalsIgnoreCase("C")) {
			eyeShape = "c";
		}
		
		else if (e.equalsIgnoreCase("S")) {
			eyeShape = "s";
		}
		
		else if (e.equalsIgnoreCase("T")) {
			eyeShape = "t";
		}
	}
	
	/*
	 * This is the default constructor for the noseShape.
	 */
	public String getNoseShape() {
		return noseShape;
	}
	
	/*
	 * This is the non-default constructor for the noseShape.
	 * This what the user is allowed to type in the panel.
	 */
	public void setNoseShape(String n) {
		if (n.equalsIgnoreCase("C")) {
			noseShape = "c";
		}
		else if (n.equalsIgnoreCase("S")) {
			noseShape = "s";
		}
		
		else if (n.equalsIgnoreCase("T")) {
			noseShape = "t";
		}
	}
	
	/*
	 * This is the default constructor for the mouthShape.
	 */
	public String getMouthShape() {
		return mouthShape;
	}
	
	/*
	 * This is the non-default constructor for the mouthShape.
	 * This what the user is allowed to type in the panel.
	 */
	public void setMouthShape(String m) {
		if (m.equalsIgnoreCase("o")) {
			mouthShape = "o";
		}
		
		else if (m.equalsIgnoreCase("r")) {
			mouthShape = "r";
		}
	}
	
	/*
	 * This is the default constructor for the left or the x-coordinate on the frame.
	 */
	public int getLeft() {
		return left;
	}
	
	/*
	 * This is the non-default constructor for the left or the x-coordinate.
	 * There is a lower limit of 0 so the pumpkin doesn't go off screen from the left. 
	 * There is upper limit of 500 so the pumpkin doesn't go off screen from the right.
	 */
	
	public void setLeft(int x) {
		if (x < 0) {
			left = 200;
		}
		else if(x>500) {
			left = 200;
		}
		else {
			left = x;
		}
	}
	
	/*
	 * This is the default constructor for the top or the y-coordinate.
	 */
	
	public int getTop() {
		return top;
	}
	
	/*
	 * 	
	 *This is the non-default constructor for the left or the y-coordinate.
	 * There is a lower limit of 0 so the pumpkin doesn't go off screen from the top. 
	 * There is upper limit of 300 so the pumpkin doesn't go off screen from the bottom.
	 */

	public void setTop(int y) {
		if (y<0) {
			top = 100;
		}
		else if (y>300) {
			top = 100;
		}
		else {
			top = y;
		}
	}
	
	/*
	 * This is the default constructor for the pumpkin's width
	 */
	public int getPumpWidth() {
		return pumpWidth;
	}
	
	/*
	 * This is the non-default constructor for the pumpkinWidth.
	 * There is a lower limit of 50 so the pumpkin doesn't go off screen from the left. 
	 * There is upper limit of 500 so the pumpkin doesn't go off screen from the right.
	 */
	public void setPumpWidth(int w) {
		if (w<50) {
			pumpWidth = 200;
		}
		else if(w>500) {
			pumpWidth = 200;
		}
		else {
			pumpWidth = w;
		}
	}
	
	/*
	 * This is the default constructor for the pumpkin height.
	 */
	
	public int getPumpHeight() {
		return pumpHeight;
	}
	
	/*
	 * This is the non-default constructor for the pumpkin height.
	 * There is a lower limit of 50 so the pumpkin doesn't go off screen from the top. 
	 * There is upper limit of 350 so the pumpkin doesn't go off screen from the bottom.
	 */
	
	public void setPumpHeight(int h) {
		if (h<50) {
			pumpHeight = 100;
		}
		else if (h>350) {
			pumpHeight = 100;
		}
		else {
			pumpHeight = h;
		}
	}
	
	/*
	 * These are all the default options for the pumpkin when it is drawn on the frame.
	 */
	
	public PumpkinPanel() {
		pumpHeight = 100;
		pumpWidth = 200;
		top = 100;
		left = 200;
		eyeShape="c";
		noseShape="s";
		mouthShape="o";
	}
	
	/*
	 * These allow inputs from the user to modify the pumpkin to the sizes and shapes they desire.
	 */
	
	public PumpkinPanel(int h, int w, int x, int y, String e, String n, String m) {
		setPumpHeight(h);
		setPumpWidth(w);
		setLeft(x);
		setTop(y);
		setEyeShape(e);
		setNoseShape(n);
		setMouthShape(m);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		int[] Lxs = new int[3]; // left eye array for the x-axis
		int[] Lys = new int[3]; // left eye array for the y-axis
		
		int[] Rxs = new int[3]; // right eye array for the x-axis
		int[] Rys = new int[3]; // right eye array for the y-axis
		
		int[] Nxs = new int[3]; // array for the nose in the x-axis
		int[] Nys = new int[3]; // array for the nose in the y-axis.
		
		Lxs[0] = left+pumpWidth/3;
		Lys[0] = top+pumpHeight/4;
		Lxs[1] = left+(2*pumpWidth/5);
		Lys[1] = top+pumpHeight/2;
		Lxs[2] = left+pumpWidth/4;
		Lys[2] = top+pumpHeight/2;
		
		Rxs[0] = left+(2*pumpWidth)/3;
		Rys[0] = top+pumpHeight/4;
		Rxs[1] = left+(3*pumpWidth/4);
		Rys[1] = top+pumpHeight/2;
		Rxs[2] = left+(3*pumpWidth/5);
		Rys[2] = top+pumpHeight/2;
		
		Nxs[0] = left+pumpWidth/2;
		Nys[0] = top+3*pumpHeight/7;
		Nxs[1] = left+(3*pumpWidth/7);
		Nys[1] = top+(3*pumpHeight)/5;
		Nxs[2] = left+(5*pumpWidth)/9;
		Nys[2] = top+(3*pumpHeight)/5;
		
		super.paintComponent(g);
		//Below is what draws the pumpkin .
		g.setColor(Color.ORANGE);
		g.fillOval(left, top, pumpWidth, pumpHeight); // The default pumpkin.
		g.setColor(Color.WHITE);
		g.fillRect(left+(5*pumpWidth)/11, top-(2*pumpHeight)/12, pumpWidth/10, pumpHeight/5); // stem
		//Now we change the shapes based on input.
		if (eyeShape.equalsIgnoreCase("c")) {
			g.fillOval(left+(2*pumpWidth)/8,top+(2*pumpHeight)/8,pumpWidth/7, pumpHeight/7); // left eye as a circle.
			g.fillOval(left+(5*pumpWidth)/8, top+(2*pumpHeight)/8, pumpWidth/7, pumpHeight/7); // right eye as a circle.
		}
		else if(eyeShape.equalsIgnoreCase("s")) {
			g.fillRect(left+(2*pumpWidth)/8,top+(2*pumpHeight)/8,pumpWidth/7, pumpHeight/7); // left eye as a square.
			g.fillRect(left+(5*pumpWidth)/8, top+(2*pumpHeight)/8, pumpWidth/7, pumpHeight/7); // right eye as a square.
		}
		else if (eyeShape.equalsIgnoreCase("t")) {
			g.fillPolygon(Lxs, Lys, 3); // left eye as a triangle.
			g.fillPolygon(Rxs, Rys, 3); //right eye as triangle.
		}
		if (noseShape.equalsIgnoreCase("c")) {
			g.fillOval(left+(4*pumpWidth)/9,top+pumpHeight/2,pumpWidth/9,pumpHeight/9); // nose as a circle.
		}
		else if(noseShape.equalsIgnoreCase("s")) {
			g.fillRect(left+(4*pumpWidth)/9, top+pumpHeight/2, pumpWidth/9, pumpHeight/9); // nose as a square.
		}
		else if(noseShape.equalsIgnoreCase("t")) {
			g.fillPolygon(Nxs, Nys, 3); // nose as a triangle.
		}
		if (mouthShape.equalsIgnoreCase("o")) {
			g.fillOval(left+(2*pumpWidth)/8, top+(6*pumpHeight)/8, pumpWidth/2, pumpHeight/9); // mouth as oval.
		}
		else if (mouthShape.equalsIgnoreCase("r")) {
			g.fillRect(left+(2*pumpWidth)/8, top+(6*pumpHeight)/8, pumpWidth/2, pumpHeight/9); // mouth as rectangle.
		}
	}
}
	

	
/*
 * This is custom frame for the pumpkin maker application.
 * This frame includes all the options to the user including what shapes and sizes 
 * the user wants to use.
 * This frame also responds to the user's click when they choose "Draw" 
 * to change the pumpkin into their desired shape
 */
		
class PumpkinMakerFrame extends JFrame {
	/*
	 * Allows the frame to be centered on the screen when launched.
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
	/*
	 * Outlines the entire way the frame will look like.
	 * Adds the option for the user to specify the left, top, width, and height of the pumpkin.
	 * Adds the option for the user to specify the shapes of the eyes, mouth, and nose.
	 * Informs the user if they entered a integer out of bounds of the allowed intervals for the left, top, width, and height.
	 * Informs the user if they entered something other than a "s", "c " , or "t" for the eyes and nose.
	 * Informs the user if they entered something other than an "o" or "r" for the mouth.
	 */
	public void setupLook() {
		centerFrame(800,480);
		setTitle("Pumpkin Maker App");
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		PumpkinPanel panCenter = new PumpkinPanel();
		c.add(panCenter,BorderLayout.CENTER);
		JPanel panSouth = new JPanel();
		panSouth.setLayout(new FlowLayout());
		JLabel lblLeft = new JLabel("Left:");
		panSouth.add(lblLeft);
		JTextField txtLeft = new JTextField(3);
		panSouth.add(txtLeft);
		JLabel lblTop = new JLabel("Top:");
		panSouth.add(lblTop);
		JTextField txtTop = new JTextField(3);
		panSouth.add(txtTop);
		JLabel lblPumpWidth = new JLabel("Width:");
		panSouth.add(lblPumpWidth);
		JTextField txtPumpWidth = new JTextField(3);
		panSouth.add(txtPumpWidth);
		JLabel lblPumpHeight = new JLabel("Height:");
		panSouth.add(lblPumpHeight);
		JTextField txtPumpHeight = new JTextField(3);
		panSouth.add(txtPumpHeight);
		JLabel lblEye = new JLabel("Eye (C S T):");
		panSouth.add(lblEye);
		JTextField txtEye = new JTextField(2);
		panSouth.add(txtEye);
		JLabel lblNose = new JLabel("Nose (C S T):");
		panSouth.add(lblNose);
		JTextField txtNose = new JTextField(2);
		panSouth.add(txtNose);
		JLabel lblMouth = new JLabel("Mouth (O R):");
		panSouth.add(lblMouth);
		JTextField txtMouth = new JTextField(2);
		panSouth.add(txtMouth);
		JButton btnDraw = new JButton("Draw");
		btnDraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try { 
					int left = Integer.parseInt(txtLeft.getText());
					panCenter.setLeft(left);
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "The Left must be an Integer.");
				}
				try {
					int top = Integer.parseInt(txtTop.getText());
					panCenter.setTop(top);
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "The Top must be an Integer.");
				}
				try {
					int pumpWidth = Integer.parseInt(txtPumpWidth.getText());
					panCenter.setPumpWidth(pumpWidth);
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "The Width must be an Integer.");
				}
				try {
					int pumpHeight = Integer.parseInt(txtPumpHeight.getText());
					panCenter.setPumpHeight(pumpHeight);
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "The Height must be an Integer.");
				}
				String eyeShape = txtEye.getText();
				if (eyeShape.equalsIgnoreCase("c") || eyeShape.equalsIgnoreCase("s") || eyeShape.equalsIgnoreCase("t")) {
					panCenter.setEyeShape(eyeShape);
				}
				else {
					JOptionPane.showMessageDialog(null, "The eye must be either C, S, or T.");
				}
				String noseShape = txtNose.getText();
				if (noseShape.equalsIgnoreCase("c") || noseShape.equalsIgnoreCase("s") || noseShape.equalsIgnoreCase("t")) {
					panCenter.setNoseShape(noseShape);
				}
				else {
					JOptionPane.showMessageDialog(null, "The nose must be either C, S, or T.");
				}
				String mouthShape = txtMouth.getText();
				if (mouthShape.equalsIgnoreCase("o") || mouthShape.equalsIgnoreCase("r")) {
					panCenter.setMouthShape(mouthShape);
				}
				else {
					JOptionPane.showMessageDialog(null, "The mouth must be either O or R.");
				}
				repaint();
				
			}
		});
		panSouth.add(btnDraw);
		c.add(panSouth,BorderLayout.SOUTH);
	}


	public PumpkinMakerFrame() {
		setupLook();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

}


public class PumpkinMakerApp {
	public static void main(String[] args) {
		PumpkinMakerFrame frm = new PumpkinMakerFrame();
		frm.setVisible(true);
	}
}


