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

public class Item1 implements ActionListener{
	Image image; 
	private String desc;
	private double price;
	private String name;
	private String department;
	private JPanel pane;
	private JLabel imageLabel, priceLabel; 
	private JButton itemButton, wish; 
	private Box horizontalBox; 
	ImageIcon tempEmptyHeart = new ImageIcon("src/emptyHeart.png");
	Image imgEmptyHeart = tempEmptyHeart.getImage();
	Image newimg = imgEmptyHeart.getScaledInstance(70, 50,  java.awt.Image.SCALE_SMOOTH);
	ImageIcon emptyHeart = new ImageIcon(newimg);
	ImageIcon tempHeart = new ImageIcon("src/heart.PNG"); 
	Image imgHeart = tempHeart.getImage();
	Image newimg1 = imgHeart.getScaledInstance(70, 50,  java.awt.Image.SCALE_SMOOTH);
	ImageIcon heart = new ImageIcon(newimg1);
	
	public Item1(String name, Image img, double price, String department, String desc){
		this.name = name;
		image = img.getScaledInstance(200, 140,  java.awt.Image.SCALE_SMOOTH);
		this.price = price;
		this.desc = desc;
		this.department = department;
	}
	
	public JPanel showItem() {
		pane = new JPanel(); 
		pane.setLayout(new BoxLayout(pane, BoxLayout.PAGE_AXIS));
		pane.setBackground(Color.WHITE);
		
		imageLabel = new JLabel();
		Image newimg = imgEmptyHeart.getScaledInstance(70, 50,  java.awt.Image.SCALE_SMOOTH);
		ImageIcon emptyHeart = new ImageIcon(newimg);
		imageLabel.setIcon(new ImageIcon(this.getImg()));
		imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		pane.add(imageLabel);
		
		itemButton = new JButton(name);
		itemButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		itemButton.addActionListener(this);
		itemButton.setBackground(Color.white);
		pane.add(itemButton);
		priceLabel = new JLabel("$"+String.valueOf(price));
		priceLabel.setFont(new Font("Serif", Font.PLAIN, 14));
		
		
		wish = new JButton();
		//wish.setSize(100, 50);
		wish.setIcon(emptyHeart);
		wish.setForeground(Color.white);
		wish.setText("empt");
		wish.setContentAreaFilled(false);
		wish.setBorderPainted(false);
		wish.addActionListener(this);
		pane.add(wish);
		pane.add(priceLabel);
		//pane.add(heart);
		
	    horizontalBox = Box.createHorizontalBox();
	    horizontalBox.add(Box.createHorizontalStrut(100));
	    horizontalBox.add(priceLabel);
	    horizontalBox.add(Box.createHorizontalStrut(20));
	    horizontalBox.add(wish);
	    pane.add(horizontalBox);
	    
	    return pane; 
	}
	
	public Image getImg() {
		return image;
	}

	public void setImg(Image img) {
		this.image = img;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
	public void actionPerformed(ActionEvent event) {
		String eventName = event.getActionCommand();
		  if (eventName.equals("empt")) {
			wish.setIcon(heart);
			wish.setText("fill");
			// method to add to wish list 
		}
		  else if(eventName.equals("fill")) {
			  wish.setIcon(emptyHeart);
			  wish.setText("empt");
			  // method to remove from wish list 
		  }
		  else if(eventName.equals(name)) {
			  System.out.println(name);
			  ItemPage1 show = new ItemPage1(this);
	
		  }
		
		
	        
	}
	

}
