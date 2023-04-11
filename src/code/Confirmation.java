import java.awt.BorderLayout;
import java.awt.Color;
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

public class Confirmation {
	JFrame frame;
	JPanel bigPane, head, leftPane, rightPane, progressPane, textPane, pricePane, bottomPane;
	JButton back, placeOrder;
	JLabel prompt, contactInfo, email, shippingAddress, first, last, address, aprt, city, st, zip, phone;
	JLabel creditCard, number, cardName, exp, secCode;
	JLabel subtotal, subPrice, ship, shipPrice, total, totalPrice;
	JLabel cart, info, pay, confirm;
	JSeparator horiz, vert;
	
	
	public Confirmation() {
		frame = new JFrame("Confirm Order");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//create progress pane
		progressPane = new JPanel();
		progressPane.setLayout(new GridLayout(0,4));
		progressPane.setBackground(Color.white);
		progressPane.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		cart = new JLabel(new ImageIcon("src/heartCart.PNG"));
		ImageIcon imageIconCart = new ImageIcon(
			new ImageIcon("src/heartCart.PNG").getImage().getScaledInstance(90, 90, Image.SCALE_DEFAULT));
		cart.setIcon(imageIconCart);
		info = new JLabel(new ImageIcon("src/heartInfo.PNG"));
		ImageIcon imageIconInfo = new ImageIcon(
			new ImageIcon("src/heartInfo.PNG").getImage().getScaledInstance(90, 90, Image.SCALE_DEFAULT));
		info.setIcon(imageIconInfo);
		pay = new JLabel(new ImageIcon("src/heartPay.PNG"));
		ImageIcon imageIconPay = new ImageIcon(
			new ImageIcon("src/heartPay.PNG").getImage().getScaledInstance(90, 90, Image.SCALE_DEFAULT));
		pay.setIcon(imageIconPay);
		confirm = new JLabel(new ImageIcon("src/heartConfirmEmpty.PNG"));
		ImageIcon imageIconConfirm = new ImageIcon(
			new ImageIcon("src/heartConfirmEmpty.PNG").getImage().getScaledInstance(90, 90, Image.SCALE_DEFAULT));
		confirm.setIcon(imageIconConfirm);

		progressPane.add(cart);
		progressPane.add(info);
		progressPane.add(pay);
		progressPane.add(confirm);
				
		//create text pane
		textPane = new JPanel();
		textPane.setBackground(Color.white);
		textPane.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;

		prompt = new JLabel("Please confirm your information below:");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipadx = 100;
		//c.ipady = 20;
		c.weightx = 0.0;
		c.gridwidth = 6;
		c.gridx = 0;
		c.gridy = 0;
		textPane.add(prompt, c);
		
		contactInfo = new JLabel("Contact Information");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipadx = 100;
		c.ipady = 20;
		c.weightx = 0.0;
		c.gridwidth = 6;
		c.gridx = 0;
		c.gridy = 1;
		textPane.add(contactInfo, c);
		
		email = new JLabel();
		email.setText("Email: " + Info.getEmail());
		email.setBorder(BorderFactory.createLineBorder(Color.black));
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 40;
		c.weightx = 0.0;
		c.gridwidth = 6;
		c.gridx = 0;
		c.gridy = 2;
		textPane.add(email, c);
		
		shippingAddress = new JLabel("Shipping Address");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.0;
		c.gridwidth = 6;
		c.gridx = 0;
		c.gridy = 3;
		textPane.add(shippingAddress, c);
		
		
		first = new JLabel();
		first.setText("First name:" + Info.getFirstName());
		first.setBorder(BorderFactory.createLineBorder(Color.black));
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridwidth = 3;
		c.gridx = 0;
		c.gridy = 4;
		textPane.add(first, c);
		
		last = new JLabel();
		last.setText("Last name: " + Info.getLastName());
		last.setBorder(BorderFactory.createLineBorder(Color.black));
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipadx = 100;
		c.weightx = 0.5;
		c.gridwidth = 3;
		c.gridx = 3;
		c.gridy = 4;
		textPane.add(last, c);
		
		address = new JLabel();
		address.setText("Address: " + Info.getAddress());
		address.setBorder(BorderFactory.createLineBorder(Color.black));
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.0;
		c.gridwidth = 6;
		c.gridx = 0;
		c.gridy = 5;
		textPane.add(address, c);
		
		aprt = new JLabel();
		aprt.setText("Apartment, suite, etc. (optional): " + Info.getAprt());
		aprt.setBorder(BorderFactory.createLineBorder(Color.black));
		c.fill = GridBagConstraints.HORIZONTAL;
		//c.ipady = 40;      //make this component tall
		c.weightx = 0.0;
		c.gridwidth = 6;
		c.gridx = 0;
		c.gridy = 6;
		textPane.add(aprt, c);
		
		
		city = new JLabel();
		city.setText("City: " + Info.getCity());
		city.setBorder(BorderFactory.createLineBorder(Color.black));
		c.weightx = 0.5;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 7;
		textPane.add(city, c);

		st = new JLabel();
		st.setText("State: " + Info.getState());
		st.setBorder(BorderFactory.createLineBorder(Color.black));
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridwidth = 2;
		c.gridx = 2;
		c.gridy = 7;
		textPane.add(st, c);

		zip = new JLabel();
		zip.setText("ZIP code: " + Info.getZip());
		zip.setBorder(BorderFactory.createLineBorder(Color.black));
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridwidth = 2;
		c.gridx = 4;
		c.gridy = 7;
		textPane.add(zip, c);
		
		phone = new JLabel();
		phone.setText("Phone #: " + Info.getPhone());
		phone.setBorder(BorderFactory.createLineBorder(Color.black));
		c.fill = GridBagConstraints.HORIZONTAL;
		//c.ipady = 40;      //make this component tall
		c.weightx = 0.0;
		c.gridwidth = 6;
		c.gridx = 0;
		c.gridy = 8;
		textPane.add(phone, c);
		
		creditCard = new JLabel("Credit Card");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.0;
		c.gridwidth = 4;
		c.gridx = 0;
		c.gridy = 9;
		textPane.add(creditCard, c);
				
		number = new JLabel();
		number.setText("Card Number: " + Payment.getNumber());
		number.setBorder(BorderFactory.createLineBorder(Color.black));
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 40;
		c.weightx = 2;
		c.gridwidth = 4;
		c.gridx = 0;
		c.gridy = 10;
		textPane.add(number, c);
		
		cardName = new JLabel();
		cardName.setText("Name on Card: " + Payment.getCardName());
		cardName.setBorder(BorderFactory.createLineBorder(Color.black));
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.0;
		c.gridwidth = 4;
		c.gridx = 0;
		c.gridy = 11;
		textPane.add(cardName, c);
		
		exp = new JLabel();
		exp.setText("Exp Date: " + Payment.getExp());
		exp.setBorder(BorderFactory.createLineBorder(Color.black));
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.0;
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 12;
		textPane.add(exp, c);
				
		secCode = new JLabel();
		secCode.setText("Security Code: " + Payment.getSecCode());
		secCode.setBorder(BorderFactory.createLineBorder(Color.black));
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.0;
		c.gridwidth = 2;
		c.gridx = 2;
		c.gridy = 12;
		textPane.add(secCode, c);
		
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
						
				subPrice = new JLabel("$" + Payment.getItemsPrice() + "0");
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
						
				shipPrice = new JLabel("$"  + Payment.getShipChoice() + "0");
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
						
				totalPrice = new JLabel("$" + Payment.getTotaled() + "0");
				c3.fill = GridBagConstraints.HORIZONTAL;
				c3.weightx = 0.5;
				c3.gridwidth = 2;
				c3.gridx = 6;
				c3.gridy = 3;
				pricePane.add(totalPrice, c3);
		
		
		back = new JButton(new ImageIcon("src/backToPay.PNG"));
		ImageIcon imageIconBack = new ImageIcon(
				new ImageIcon("src/backToPay.PNG").getImage().getScaledInstance(90, 90, Image.SCALE_DEFAULT));
		back.setIcon(imageIconBack);
		back.setBackground(Color.white);
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				frame.dispose();
				new Payment();
			}
		});
		
		placeOrder = new JButton(new ImageIcon("src/placeOrder.PNG"));
		ImageIcon imageIconOrder = new ImageIcon(
				new ImageIcon("src/placeOrder.PNG").getImage().getScaledInstance(90, 90, Image.SCALE_DEFAULT));
		placeOrder.setIcon(imageIconOrder);
		placeOrder.setBackground(Color.white);
		placeOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				frame.dispose();
				//new Payment();
			}
		});
		
		bigPane = new JPanel();
		bigPane.setBackground(Color.white);
		bigPane.setLayout(new GridBagLayout());
		GridBagConstraints c4 = new GridBagConstraints();
		c4.fill = GridBagConstraints.HORIZONTAL;
		
		Header h = new Header();
		head = h.createHeader();
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
		leftPane.add(textPane, BorderLayout.PAGE_END);
		c4.fill = GridBagConstraints.HORIZONTAL;
		//c4.ipady = 50;
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
		bottomPane.add(placeOrder);
		c4.fill = GridBagConstraints.HORIZONTAL;
		//c4.ipady = 40;
		c4.weightx = 0.5;
		c4.gridwidth = 6;
		c4.gridx = 0;
		c4.gridy = 2;
		bigPane.add(bottomPane, c4);
		
		//add content pane to frame
		frame.setContentPane(bigPane);
				
		//Size and then display the frame
		frame.pack();
		frame.setVisible(true);
		frame.setSize(1600,900);
		
	}
	
	private static void runGUI() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		
		Confirmation con = new Confirmation();
	}
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				runGUI();
			}
		});

	}
	
	
}
