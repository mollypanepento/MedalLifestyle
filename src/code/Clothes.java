package onlineStore;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Clothes implements ActionListener{
	JFrame frame;
	JPanel contentPane, filterPane, itemsPane, cropPane, naturePane, quarterPane, brownPame, greenPane, skirtPane, greenMenPane, stripePane, blackPane, starPane;
	JLabel cropImg, natureImg, quarterImg, brownImg, greenImg, skirtImg, greenMenImg, stripeImg, blackImg, starImg;
	JButton cropTop, naturePack, quarterZip, brownCargo, greenSweater, skirt, greenCargo, stripeSweater, blackSweatshirt, longStar;
	JLabel cropPrice, naturePrice, quarterPrice, brownPrice, greenPrice, skirtPrice, greenMenPrice, stripePrice, blackPrice, starPrice;
	JLabel heart;
	JLabel sort;
	Color lavender = new Color(183,189,231);
	
	public Clothes() {
		frame = new JFrame("Clothes");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//create items pane
		itemsPane = new JPanel(new GridLayout(4,3));
		heart = new JLabel(new ImageIcon("src/heart.PNG"));
		
		//create crop top pane
		cropPane = new JPanel();
		cropPane.setBackground(Color.WHITE);
	
		cropImg = new JLabel(new ImageIcon("src/cropTop.PNG"));
		cropPane.add(cropImg);
		cropTop = new JButton("Blue crop top (Women)");
		cropTop.addActionListener(this);
		cropPane.add(cropTop);
		cropPrice = new JLabel("$20");
		cropPane.add(cropPrice);
		cropPane.add(heart);
		
		
		//add each item to item pane
		itemsPane.add(cropPane);
		
		//add each pane to content pane
		contentPane = new JPanel();
		contentPane.add(itemsPane);

		 /* Add content pane to frame */
		 frame.setContentPane(contentPane);
		 
		 /* Size and then display the frame. */
		 frame.pack();
		 frame.setVisible(true);
		
		
	}
	
	public void actionPerformed(ActionEvent event) {
		String eventName = event.getActionCommand();
		  if (eventName.equals("Blue crop top (Women")) {
			cropTop.setBackground(lavender);
		  } 
	}
	
	private static void runGUI() {
		 JFrame.setDefaultLookAndFeelDecorated(true);
		 Clothes c = new Clothes();
	 }
		 
	 public static void main(String[] args) {
	 /* Methods that create and show a GUI should be run from an event-dispatching thread */
		 javax.swing.SwingUtilities.invokeLater(new Runnable() {
		 public void run() {
			runGUI();
		 }
		});
	 }
}
