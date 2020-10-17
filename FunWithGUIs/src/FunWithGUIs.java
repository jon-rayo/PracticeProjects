import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Container;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.Color;
public class FunWithGUIs {
	public static void main(String[] arga) {
		JFrame frm = new JFrame();
		frm.setTitle("My First GUI");
		frm.setBounds(100,50,500,400); // l,t,w,h
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c= frm.getContentPane();
	//	c.setBackground(Color.BLACK);
		JButton btnClick = new JButton("Click Me!");
		JLabel lblSouth = new JLabel("John Cena");
		lblSouth.setHorizontalAlignment(SwingConstants.CENTER);
		lblSouth.setFont(new Font("Arial",Font.BOLD,24));
		c.setLayout(new BorderLayout());;
		c.add(btnClick, BorderLayout.CENTER);
		c.add(lblSouth, BorderLayout.SOUTH);
		frm.setVisible(true);
	}
	
}
