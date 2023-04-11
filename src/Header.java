
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Header implements ActionListener{
	JFrame frame;
	JPanel contentPane, smallPane, navPane;
	JLabel logo;
	JTextField search;
	JButton clothes, electronics, fitness, furniture, jewelry, kitchen, skinCare, stationary;
	JButton submit, signIn, purchase, cart;
	Color lavender = new Color(183,189,231);
	
	public Header() {
		
	}
	
	public JPanel createHeader() {
		//frame = new JFrame("Header");
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//contentPane.setSize(100,100);
		
		/* Create a content pane */
		 smallPane = new JPanel();
		 smallPane.setBackground(lavender);
		 
		 /* Create a label that shows the logo */
		 logo = new JLabel(new ImageIcon("src/MEDALlogo.PNG"));
		 smallPane.add(logo);
		 //smallPane.add(Box.createRigidArea(new Dimension(0,5)));
		 
		 //create the search bar
		 search = new JTextField();
		 search.setText("Search");
			search.addFocusListener(new FocusListener(){
				public void focusGained(FocusEvent event) {
					if(search.getText().equals("Search")) {
						search.setText("");
					}
				}
				
				public void focusLost(FocusEvent event) {
					if(search.getText().equals("")) {
						search.setText("Search");
					}
				}
			});
		 search.setPreferredSize(new Dimension(800,30));
		 smallPane.add(search);
		 
		 submit = new JButton("Submit");
		 submit.setBackground(lavender);
		 submit.setForeground(Color.black);
		 submit.setBorder(BorderFactory.createLineBorder(Color.black));
		 submit.setBorder(BorderFactory.createEmptyBorder(5,10,5, 10));
		 submit.addActionListener(this);
		 smallPane.add(submit);
		 
		 //create signIn button
		 signIn = new JButton("Hello, sign in!");
		 signIn.setBackground(lavender);
		 signIn.setForeground(Color.black);
		 signIn.setBorder(BorderFactory.createLineBorder(Color.black));
		 signIn.setBorder(BorderFactory.createEmptyBorder(20,85,20, 85));
		 signIn.addActionListener(this);
		 smallPane.add(signIn);
		 
		 //create returns button
		 purchase = new JButton("Make Purchase");
		 purchase.setBackground(lavender);
		 purchase.setForeground(Color.black);
		 purchase.setBorder(BorderFactory.createLineBorder(Color.black));
		 purchase.setBorder(BorderFactory.createEmptyBorder(20,85,20,85));
		 purchase.addActionListener(this);
		 smallPane.add(purchase);
		 
		 //create cart button
		 cart = new JButton(new ImageIcon("src/cartSmall.png"));
		 cart.setBackground(lavender);
		 smallPane.add(cart);
		 
		 
		 //create the navigation panel
		 navPane = new JPanel();
		 navPane.setLayout(new BoxLayout(navPane, BoxLayout.LINE_AXIS));
		 navPane.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
		 navPane.setBackground(lavender);
		 //navPane.add(Box.createHorizontalGlue());
		 
		 
		 /* Create the clothes button */
		 clothes = new JButton("Clothes");
		 clothes.setBackground(lavender);
		 clothes.setForeground(Color.black);
		 clothes.setBorder(BorderFactory.createLineBorder(Color.white));
		 clothes.setBorder(BorderFactory.createEmptyBorder(5,75,5,75));
		 clothes.addActionListener(this);
		 navPane.add(clothes);
		 
		 /* Create the electronics button */
		 electronics = new JButton("Electronics");
		 electronics.setBackground(lavender);
		 electronics.setForeground(Color.black);
		 electronics.setBorder(BorderFactory.createLineBorder(Color.white));
		 electronics.setBorder(BorderFactory.createEmptyBorder(5,75,5,75));
		 electronics.addActionListener(this);
		 navPane.add(electronics);
		 
		 /* Create the fitness button */
		 fitness = new JButton("Fitness");
		 fitness.setBackground(lavender);
		 fitness.setForeground(Color.black);
		 fitness.setBorder(BorderFactory.createLineBorder(Color.white));
		 fitness.setBorder(BorderFactory.createEmptyBorder(5,75,5,75));
		 fitness.addActionListener(this);
		 navPane.add(fitness);
		 
		 /* Create the furniture button */
		 furniture = new JButton("Furniture");
		 furniture.setBackground(lavender);
		 furniture.setForeground(Color.black);
		 furniture.setBorder(BorderFactory.createLineBorder(Color.white));
		 furniture.setBorder(BorderFactory.createEmptyBorder(5,75,5,75));
		 furniture.addActionListener(this);
		 navPane.add(furniture);
		 
		 /* Create the jewlery button */
		 jewelry = new JButton("Jewelry");
		 jewelry.setBackground(lavender);
		 jewelry.setForeground(Color.black);
		 jewelry.setBorder(BorderFactory.createLineBorder(Color.white));
		 jewelry.setBorder(BorderFactory.createEmptyBorder(5,75,5,75));
		 jewelry.addActionListener(this);
		 navPane.add(jewelry);
		 
		 /* Create the kitchen button */
		 kitchen = new JButton("Kitchen");
		 kitchen.setBackground(lavender);
		 kitchen.setForeground(Color.black);
		 kitchen.setBorder(BorderFactory.createLineBorder(Color.white));
		 kitchen.setBorder(BorderFactory.createEmptyBorder(5,75,5,75));
		 kitchen.addActionListener(this);
		 navPane.add(kitchen);
		 
		 /* Create the skin care button */
		 skinCare = new JButton("Skin care");
		 skinCare.setBackground(lavender);
		 skinCare.setForeground(Color.black);
		 skinCare.setBorder(BorderFactory.createLineBorder(Color.white));
		 skinCare.setBorder(BorderFactory.createEmptyBorder(5,75,5,75));
		 skinCare.addActionListener(this);
		 navPane.add(skinCare);
		 
		 /* Create the stationary button */
		 stationary = new JButton("Stationary");
		 stationary.setBackground(lavender);
		 stationary.setForeground(Color.black);
		 stationary.setBorder(BorderFactory.createLineBorder(Color.white));
		 stationary.setBorder(BorderFactory.createEmptyBorder(5,75,5,75));
		 stationary.addActionListener(this);
		 navPane.add(stationary);
		 
		 contentPane = new JPanel();
		 contentPane.setBackground(lavender);
		 contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));
		 contentPane.add(smallPane, BorderLayout.CENTER);
		 contentPane.add(navPane, BorderLayout.PAGE_END);
		 
		 return contentPane;

		 /* Add content pane to frame */
		 //frame.setContentPane(contentPane);
		 
		 /* Size and then display the frame. */
		 //frame.pack();
		// frame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent event) {
		String eventName = event.getActionCommand();
		  if (eventName.equals("Clothes")) {
			  	clothes.setBackground(Color.white);
			  	electronics.setBackground(lavender);
			  	fitness.setBackground(lavender);
			  	furniture.setBackground(lavender);
			  	jewelry.setBackground(lavender);
			  	kitchen.setBackground(lavender);
			  	skinCare.setBackground(lavender);
			  	stationary.setBackground(lavender);
			  	signIn.setBackground(lavender);
			  	purchase.setBackground(lavender);
			  	cart.setBackground(lavender);
			  	submit.setBackground(lavender);
		  } 
		  else if(eventName.contentEquals("Electronics")){
			  electronics.setBackground(Color.white);
			  clothes.setBackground(lavender);
			  fitness.setBackground(lavender);
			  furniture.setBackground(lavender);
			  jewelry.setBackground(lavender);
			  kitchen.setBackground(lavender);
			  skinCare.setBackground(lavender);
			  stationary.setBackground(lavender);
			  signIn.setBackground(lavender);
			  	purchase.setBackground(lavender);
			  	cart.setBackground(lavender);
			  	submit.setBackground(lavender);
			  
		  }
		  else if(eventName.contentEquals("Fitness")){
			  fitness.setBackground(Color.white);
			  electronics.setBackground(lavender);
			  clothes.setBackground(lavender);
			  furniture.setBackground(lavender);
			  jewelry.setBackground(lavender);
			  kitchen.setBackground(lavender);
			  skinCare.setBackground(lavender);
			  stationary.setBackground(lavender);
			  signIn.setBackground(lavender);
			  	purchase.setBackground(lavender);
			  	cart.setBackground(lavender);
			  	submit.setBackground(lavender);
			  
		  }
		  else if(eventName.contentEquals("Furniture")){
			  furniture.setBackground(Color.white);
			  electronics.setBackground(lavender);
			  clothes.setBackground(lavender);
			  fitness.setBackground(lavender);
			  jewelry.setBackground(lavender);
			  kitchen.setBackground(lavender);
			  skinCare.setBackground(lavender);
			  stationary.setBackground(lavender);
			  signIn.setBackground(lavender);
			  	purchase.setBackground(lavender);
			  	cart.setBackground(lavender);
			  	submit.setBackground(lavender);
			  
		  }
		  else if(eventName.contentEquals("Jewelry")){
			  jewelry.setBackground(Color.white);
			  electronics.setBackground(lavender);
			  clothes.setBackground(lavender);
			  fitness.setBackground(lavender);
			  furniture.setBackground(lavender);
			  kitchen.setBackground(lavender);
			  skinCare.setBackground(lavender);
			  stationary.setBackground(lavender);
			  signIn.setBackground(lavender);
			  	purchase.setBackground(lavender);
			  	cart.setBackground(lavender);
			  	submit.setBackground(lavender);
			  
		  }
		  else if(eventName.contentEquals("Kitchen")){
			  kitchen.setBackground(Color.white);
			  electronics.setBackground(lavender);
			  clothes.setBackground(lavender);
			  fitness.setBackground(lavender);
			  furniture.setBackground(lavender);
			  jewelry.setBackground(lavender);
			  skinCare.setBackground(lavender);
			  stationary.setBackground(lavender);
			  signIn.setBackground(lavender);
			  	purchase.setBackground(lavender);
			  	cart.setBackground(lavender);
			  	submit.setBackground(lavender);
			  
		  }
		  else if(eventName.contentEquals("Skin care")){
			  skinCare.setBackground(Color.white);
			  electronics.setBackground(lavender);
			  clothes.setBackground(lavender);
			  fitness.setBackground(lavender);
			  furniture.setBackground(lavender);
			  jewelry.setBackground(lavender);
			  kitchen.setBackground(lavender);
			  stationary.setBackground(lavender);
			  signIn.setBackground(lavender);
			  	purchase.setBackground(lavender);
			  	cart.setBackground(lavender);
			  	submit.setBackground(lavender);
			  
		  }
		  else if(eventName.contentEquals("Stationary")){
			  stationary.setBackground(Color.white);
			  electronics.setBackground(lavender);
			  clothes.setBackground(lavender);
			  fitness.setBackground(lavender);
			  furniture.setBackground(lavender);
			  jewelry.setBackground(lavender);
			  kitchen.setBackground(lavender);
			  skinCare.setBackground(lavender);
			  signIn.setBackground(lavender);
			  purchase.setBackground(lavender);
			  cart.setBackground(lavender);
			  submit.setBackground(lavender);
		  }
		  else if(eventName.contentEquals("Submit")) {
			  submit.setBackground(Color.WHITE);
			  stationary.setBackground(lavender);
			  electronics.setBackground(lavender);
			  clothes.setBackground(lavender);
			  fitness.setBackground(lavender);
			  furniture.setBackground(lavender);
			  jewelry.setBackground(lavender);
			  kitchen.setBackground(lavender);
			  skinCare.setBackground(lavender);
			  signIn.setBackground(lavender);
			  purchase.setBackground(lavender);
			  cart.setBackground(lavender);
		  }
		  else if(eventName.contentEquals("Hello, sign in!")) {
			  signIn.setBackground(Color.WHITE);
			  stationary.setBackground(lavender);
			  electronics.setBackground(lavender);
			  clothes.setBackground(lavender);
			  fitness.setBackground(lavender);
			  furniture.setBackground(lavender);
			  jewelry.setBackground(lavender);
			  kitchen.setBackground(lavender);
			  skinCare.setBackground(lavender);
			  purchase.setBackground(lavender);
			  cart.setBackground(lavender);
			  submit.setBackground(lavender);
		  }
		  else if(eventName.contentEquals("Make Purchase")) {
			  purchase.setBackground(Color.WHITE);
			  stationary.setBackground(lavender);
			  electronics.setBackground(lavender);
			  clothes.setBackground(lavender);
			  fitness.setBackground(lavender);
			  furniture.setBackground(lavender);
			  jewelry.setBackground(lavender);
			  kitchen.setBackground(lavender);
			  skinCare.setBackground(lavender);
			  signIn.setBackground(lavender);
			  cart.setBackground(lavender);
			  submit.setBackground(lavender);
			  new Info();
		  }
		  else {
			  stationary.setBackground(lavender);
			  electronics.setBackground(lavender);
			  clothes.setBackground(lavender);
			  fitness.setBackground(lavender);
			  furniture.setBackground(lavender);
			  jewelry.setBackground(lavender);
			  kitchen.setBackground(lavender);
			  skinCare.setBackground(lavender);
			  signIn.setBackground(lavender);
			  purchase.setBackground(lavender);
			  submit.setBackground(lavender);
		  }
	}
	
	
}