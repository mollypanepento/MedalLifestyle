import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

public class Payment implements ActionListener{
	Header h = new Header();
	//JFrame frame;
	JPanel bigPane, leftPane, rightPane, bottomPane, progressPane, shipPane, cardPane, pricePane;
	JPanel head;
	JLabel cart, info, pay, shipping, creditCard;
	JButton regular, express, twoDay, back, confirm;
	JLabel subtotal, subPrice, ship, shipPrice, total, totalPrice;
	JTextField number, name, exp, secCode;
	JSeparator horiz, vert;
	Color lavender = new Color(183,189,231);
	static double itemsPrice = 15.00;
	static double shipChoice = 0.00;
	static double totaled = 0.00;
	static String numberText;
	static String cardNameText;
	static String expText;
	static String secCodeText;
	
	public Payment() {
		//create and set up frame 
		Header.frame = new JFrame("Checkout");
		Header.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
		//create progress pane
		progressPane = new JPanel();
		progressPane.setLayout(new GridLayout(0,3));
		progressPane.setBackground(Color.white);
		progressPane.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		cart = new JLabel(new ImageIcon("heartCart.PNG"));
		ImageIcon imageIconCart = new ImageIcon(
						new ImageIcon("heartCart.PNG").getImage().getScaledInstance(90, 90, Image.SCALE_DEFAULT));
		cart.setIcon(imageIconCart);
		info = new JLabel(new ImageIcon("heartInfo.PNG"));
		ImageIcon imageIconInfo = new ImageIcon(
						new ImageIcon("heartInfo.PNG").getImage().getScaledInstance(90, 90, Image.SCALE_DEFAULT));
		info.setIcon(imageIconInfo);
		pay = new JLabel(new ImageIcon("heartPay.PNG"));
		ImageIcon imageIconPay = new ImageIcon(
				new ImageIcon("heartPayEmpty.PNG").getImage().getScaledInstance(90, 90, Image.SCALE_DEFAULT));
		pay.setIcon(imageIconPay);

		progressPane.add(cart);
		progressPane.add(info);
		progressPane.add(pay);
		
		//create shipping pane
		shipPane = new JPanel();
		shipPane.setBackground(Color.white);
		shipPane.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		shipPane.setLayout(new GridBagLayout());
		GridBagConstraints c1 = new GridBagConstraints();
		c1.fill = GridBagConstraints.HORIZONTAL;

		shipping = new JLabel("Shipping");
		c1.fill = GridBagConstraints.HORIZONTAL;
		c1.weightx = 2;
		c1.gridwidth = 4;
		c1.gridx = 0;
		c1.gridy = 0;
		shipPane.add(shipping, c1);
				
		regular = new JButton("Regular: $7.50");
		regular.addActionListener(this);
		regular.setBackground(Color.white);
		c1.fill = GridBagConstraints.HORIZONTAL;
		c1.ipady = 40;
		c1.weightx = 0.0;
		c1.gridwidth = 4;
		c1.gridx = 0;
		c1.gridy = 1;
		shipPane.add(regular, c1);
		
		express = new JButton("Express: $10.00");
		express.addActionListener(this);
		express.setBackground(Color.white);
		c1.fill = GridBagConstraints.HORIZONTAL;
		c1.weightx = 0.0;
		c1.gridwidth = 4;
		c1.gridx = 0;
		c1.gridy = 2;
		shipPane.add(express, c1);
		
		twoDay = new JButton("2-Day: $12.50");
		twoDay.addActionListener(this);
		twoDay.setBackground(Color.white);
		c1.fill = GridBagConstraints.HORIZONTAL;
		c1.weightx = 0.0;
		c1.gridwidth = 4;
		c1.gridx = 0;
		c1.gridy = 3;
		shipPane.add(twoDay, c1);
		
		//create card pane
		cardPane = new JPanel();
		cardPane.setBackground(Color.white);
		cardPane.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		cardPane.setLayout(new GridBagLayout());
		GridBagConstraints c2 = new GridBagConstraints();
		c2.fill = GridBagConstraints.HORIZONTAL;

		creditCard = new JLabel("Credit Card");
		c2.fill = GridBagConstraints.HORIZONTAL;
		c2.weightx = 0.0;
		c2.gridwidth = 4;
		c2.gridx = 0;
		c2.gridy = 0;
		cardPane.add(creditCard, c2);
				
		number = new JTextField();
		number.setText("Card Number");
		number.addFocusListener(new FocusListener(){
			public void focusGained(FocusEvent event) {
				if(number.getText().equals("Card Number")) {
					number.setText("");
				}
			}
			
			public void focusLost(FocusEvent event) {
				if(number.getText().equals("")) {
					number.setText("Card Number");
				}
			}
		});
		c2.fill = GridBagConstraints.HORIZONTAL;
		c2.ipady = 40;
		c2.weightx = 2;
		c2.gridwidth = 4;
		c2.gridx = 0;
		c2.gridy = 1;
		cardPane.add(number, c2);
		
		name = new JTextField();
		name.setText("Name on Card");
		name.addFocusListener(new FocusListener(){
			public void focusGained(FocusEvent event) {
				if(name.getText().equals("Name on Card")) {
					name.setText("");
				}
			}
			
			public void focusLost(FocusEvent event) {
				if(name.getText().equals("")) {
					name.setText("Name on Card");
				}
			}
		});
		c2.fill = GridBagConstraints.HORIZONTAL;
		c2.weightx = 0.0;
		c2.gridwidth = 4;
		c2.gridx = 0;
		c2.gridy = 2;
		cardPane.add(name, c2);
		
		exp = new JTextField();
		exp.setText("Exp Date");
		exp.addFocusListener(new FocusListener(){
			public void focusGained(FocusEvent event) {
				if(exp.getText().equals("Exp Date")) {
					exp.setText("");
				}
			}
			
			public void focusLost(FocusEvent event) {
				if(exp.getText().equals("")) {
					exp.setText("Exp Date");
				}
			}
		});
		c2.fill = GridBagConstraints.HORIZONTAL;
		c2.weightx = 0.0;
		c2.gridwidth = 2;
		c2.gridx = 0;
		c2.gridy = 3;
		cardPane.add(exp, c2);
				
		secCode = new JTextField();
		secCode.setText("Security Code");
		secCode.addFocusListener(new FocusListener(){
			public void focusGained(FocusEvent event) {
				if(secCode.getText().equals("Security Code")) {
					secCode.setText("");
				}
			}
			
			public void focusLost(FocusEvent event) {
				if(secCode.getText().equals("")) {
					secCode.setText("Security Code");
				}
			}
		});
		c2.fill = GridBagConstraints.HORIZONTAL;
		c2.weightx = 0.0;
		c2.gridwidth = 2;
		c2.gridx = 2;
		c2.gridy = 3;
		cardPane.add(secCode, c2);
		
		back = new JButton(new ImageIcon("backToInfo.PNG"));
		ImageIcon imageIconBack = new ImageIcon(
				new ImageIcon("backToInfo.PNG").getImage().getScaledInstance(90, 90, Image.SCALE_DEFAULT));
		back.setIcon(imageIconBack);
		back.setBackground(Color.white);
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				Header.frame.dispose();
				new Info();
			}
		});
		
		//back.setBorder(BorderFactory.createEmptyBorder(10,0,10, 0));
		
		
		//create price pane
		pricePane = new JPanel();
		pricePane.setBackground(Color.white);
		pricePane.setLayout(new GridBagLayout());
		GridBagConstraints c3 = new GridBagConstraints();
		c3.fill = GridBagConstraints.HORIZONTAL;
				
				
		subtotal = new JLabel("Subtotal:");
		c3.fill = GridBagConstraints.HORIZONTAL;
		c3.ipady = 40;
		c3.weightx = 0.5;
		c3.gridwidth = 2;
		c3.gridx = 0;
		c3.gridy = 0;
		pricePane.add(subtotal, c3);
				
		subPrice = new JLabel("$" + itemsPrice + "0");
		c3.fill = GridBagConstraints.HORIZONTAL;
		c3.weightx = 0.5;
		c3.gridwidth = 2;
		c3.gridx = 6;
		c3.gridy = 0;
		pricePane.add(subPrice, c3);
				
		ship = new JLabel("Shipping:");
		c3.fill = GridBagConstraints.HORIZONTAL;
		c3.weightx = 0.5;
		c3.gridwidth = 2;
		c3.gridx = 0;
		c3.gridy = 1;
		pricePane.add(ship, c3);
				
		shipPrice = new JLabel("$"  + shipChoice + "0");
		c3.fill = GridBagConstraints.HORIZONTAL;
		c3.weightx = 0.5;
		c3.gridwidth = 2;
		c3.gridx = 6;
		c3.gridy = 1;
		pricePane.add(shipPrice, c3);
				
		horiz = new JSeparator(JSeparator.HORIZONTAL);
		c3.fill = GridBagConstraints.HORIZONTAL;
		c3.weightx = 0.5;
		c3.gridwidth = 8;
		c3.gridx = 0;
		c3.gridy = 2;
		pricePane.add(horiz, c3);
				
				
		total = new JLabel("Total:");
		c3.fill = GridBagConstraints.HORIZONTAL;
		c3.weightx = 0.5;
		c3.gridwidth = 2;
		c3.gridx = 3;
		c3.gridy = 3;
		pricePane.add(total, c3);
				
		totalPrice = new JLabel("$" + totaled + "0");
		c3.fill = GridBagConstraints.HORIZONTAL;
		c3.weightx = 0.5;
		c3.gridwidth = 2;
		c3.gridx = 6;
		c3.gridy = 3;
		pricePane.add(totalPrice, c3);
		//pricePane.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		
		confirm = new JButton(new ImageIcon("confirm.PNG"));
		ImageIcon imageIconConfirm = new ImageIcon(
				new ImageIcon("confirm.PNG").getImage().getScaledInstance(90, 90, Image.SCALE_DEFAULT));
		confirm.setIcon(imageIconConfirm);
		confirm.setBackground(Color.white);
		confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				numberText = number.getText();
				cardNameText = name.getText();
				expText = exp.getText();
				secCodeText = secCode.getText();
				Header.frame.dispose();
				new Confirmation();
			}
		});
		
		
		bigPane = new JPanel();
		bigPane.setBackground(Color.white);
		bigPane.setLayout(new GridBagLayout());
		GridBagConstraints c4 = new GridBagConstraints();
		c4.fill = GridBagConstraints.HORIZONTAL;
		
		h = new Header();
		head = h.createHeader();
		//header.setBackground(lavender);
		//header.setLayout(new BoxLayout(header, BoxLayout.PAGE_AXIS));
		//header.add(smallPane, BorderLayout.CENTER);
		//header.add(navPane, BorderLayout.PAGE_END);
		c4.fill = GridBagConstraints.HORIZONTAL;
		c4.weightx = 0.5;
		c4.gridwidth = 6;
		c4.gridx = 0;
		c4.gridy = 0;
		bigPane.add(head, c4);
		
		leftPane = new JPanel();
		leftPane.setLayout(new BoxLayout(leftPane, BoxLayout.PAGE_AXIS));
		leftPane.setBackground(Color.white);
		leftPane.add(progressPane, BorderLayout.PAGE_START);
		leftPane.add(shipPane, BorderLayout.CENTER);
		leftPane.add(cardPane, BorderLayout.CENTER);
		//leftPane.add(back, BorderLayout.PAGE_END);
		//leftPane.setPreferredSize(new Dimension(800, 570));
		c4.fill = GridBagConstraints.HORIZONTAL;
		c4.weightx = 0.5;
		c4.gridwidth = 4;
		c4.gridx = 0;
		c4.gridy = 1;
		bigPane.add(leftPane, c4);
		
		rightPane = new JPanel();
		rightPane.setBackground(Color.white);
		rightPane.setLayout(new BoxLayout(rightPane, BoxLayout.PAGE_AXIS));
		rightPane.add(pricePane, BorderLayout.PAGE_START);
		//rightPane.add(checkOut, BorderLayout.PAGE_END);
		//rightPane.setPreferredSize(new Dimension(500, 800));
		c4.fill = GridBagConstraints.HORIZONTAL;
		c4.weightx = 0.5;
		c4.gridwidth = 2;
		c4.gridx = 4;
		c4.gridy = 1;
		bigPane.add(rightPane, c4);
		
		bottomPane = new JPanel();
		bottomPane.setLayout(new BoxLayout(bottomPane, BoxLayout.X_AXIS));
		bottomPane.setBackground(Color.white);
		bottomPane.add(back);
		bottomPane.add(Box.createGlue());
		bottomPane.add(confirm);
		c4.fill = GridBagConstraints.HORIZONTAL;
		c4.ipady = 40;
		c4.weightx = 0.5;
		c4.gridwidth = 6;
		c4.gridx = 0;
		c4.gridy = 2;
		bigPane.add(bottomPane, c4);
		
		//add content pane to frame
		Header.frame.setContentPane(bigPane);
				
		//Size and then display the frame
		Header.frame.pack();
		Header.frame.setVisible(true);
		Header.frame.setSize(1600,900);
	}
	

	
	public void actionPerformed(ActionEvent event) {
		String eventName = event.getActionCommand();

		if (eventName.contentEquals("Regular: $7.50")) {
			 regular.setBackground(lavender);
			 express.setBackground(Color.white);
			 twoDay.setBackground(Color.white);
			 shipPrice.setText("$" + 7.50 + "0");
			 totalPrice.setText("$" + (itemsPrice + 7.50) + "0");
	  }
		  else if(eventName.contentEquals("Express: $10.00")) {
			  regular.setBackground(Color.white);
			  express.setBackground(lavender);
			  twoDay.setBackground(Color.white);
			  shipPrice.setText("$" + 10.00 + "0");
			  totalPrice.setText("$" + (itemsPrice + 10.00) + "0");
		  }
		  else if(eventName.contentEquals("2-Day: $12.50")) {
			  regular.setBackground(Color.white);
			  express.setBackground(Color.white);
			  twoDay.setBackground(lavender);
			  shipPrice.setText("$" + 12.50 + "0");
			  totalPrice.setText("$" + (itemsPrice + 12.50) + "0");
		  }
		  else {
			  regular.setBackground(Color.white);
			  express.setBackground(Color.white);
			  twoDay.setBackground(Color.white);
		  }
	}
	
	public static String getNumber() {
		return numberText;
	}
	
	public static String getCardName() {
		return cardNameText;
	}
	
	public static String getExp() {
		return expText;
	}
	
	public static String getSecCode() {
		return secCodeText;
	}
	
	public static double getItemsPrice() {
		return itemsPrice;
	}
	
	public static double getShipChoice() {
		return shipChoice;
	}
	
	public static double getTotaled() {
		return totaled;
	}
	
	private static void runGUI() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		Payment pay = new Payment();
	}
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				runGUI();
			}
		});

	}
	
}
