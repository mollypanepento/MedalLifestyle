package onlineStore;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Image;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Item implements ActionListener{
	JLabel image, priceLabel;
	String name;
	Box horizontalBox;
	double price;
	JPanel cropPane; 
	JButton itemButton, wish; 
	Color lavender = new Color(183,189,231);
	
	ImageIcon tempEmptyHeart = new ImageIcon("src/emptyHeart.png");
	Image imgEmptyHeart = tempEmptyHeart.getImage();
	Image newimg = imgEmptyHeart.getScaledInstance(100, 50,  java.awt.Image.SCALE_SMOOTH);
	ImageIcon emptyHeart = new ImageIcon(newimg);
	
	ImageIcon tempHeart = new ImageIcon("src/heart.PNG"); 
	Image imgHeart = tempHeart.getImage();
	Image newimg1 = imgHeart.getScaledInstance(70, 50,  java.awt.Image.SCALE_SMOOTH);
	ImageIcon heart = new ImageIcon(newimg1);
	
	public Item(String i, String n, double p) {
		name = n; 
		price = p; 
		cropPane = new JPanel(); 
		cropPane.setLayout(new BoxLayout(cropPane, BoxLayout.PAGE_AXIS));
		cropPane.setBackground(Color.WHITE);
		image = new JLabel(new ImageIcon(i));
		image.setAlignmentX(Component.CENTER_ALIGNMENT);
		cropPane.add(image);
		itemButton = new JButton(n);
		itemButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		itemButton.addActionListener(this);
		itemButton.setBackground(Color.white);
		cropPane.add(itemButton);
		priceLabel = new JLabel("$"+String.valueOf(p));
		priceLabel.setFont(new Font("Serif", Font.PLAIN, 14));
		
		
		wish = new JButton();
		wish.setSize(100, 50);
		//wish.setText("hi");
		wish.setIcon(emptyHeart);
		wish.setForeground(Color.white);
		wish.setText("empty");
		wish.setContentAreaFilled(false);
		wish.setBorderPainted(false);
		wish.addActionListener(this);
		cropPane.add(wish);
		cropPane.add(priceLabel);
		//cropPane.add(heart);
		
	    horizontalBox = Box.createHorizontalBox();
	    horizontalBox.add(Box.createHorizontalStrut(100));
	    horizontalBox.add(priceLabel);
	    horizontalBox.add(Box.createHorizontalStrut(20));
	    horizontalBox.add(wish);
	    cropPane.add(horizontalBox);
//	    panel = new JPanel(new BorderLayout());
//	    panel.add(horizontalBox);
//	    panel
//	        .setBorder(BorderFactory
//	            .createTitledBorder("Beginning/End Glues"));
//	    contentPane.add(panel);
	}
	
	public JPanel getItem() {
		return this.cropPane; 
	}
	public JLabel getImage() {
		return image; 
	}
	public JButton getItemButton() {
		return itemButton;
	}
	
	public String getName() {
		return name; 
	}
	public double getPrice() {
		return price; 
	}
	public void setPrice(double p) {
		price = p; 
	}
	public void actionPerformed(ActionEvent event) {
		String eventName = event.getActionCommand();
		  if (eventName.equals("empty")) {
			wish.setIcon(heart);
			wish.setText("fill");
			// method to add to wishlist 
		}
		  else if(eventName.equals("fill")) {
			  wish.setIcon(emptyHeart);
			  wish.setText("empty");
			  // method to remove from wishlist 
		  }
		  else if(eventName.equals(name)) {
			  Item shirt=new Item("src/cropTop.PNG", "Women's t-shirt", 20.00);
			  System.out.println("yay");
			  System.out.println(name);
//			  frame.getContentPane().removeAll(); 
//			  frame.getContentPane().add(new JPanel()); 
	
		  }
		
		
		//if (e.getSource() == button1)
	        
	}
}
