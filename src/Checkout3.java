import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Checkout3 {
	JFrame frame;
	JPanel bigPane, leftPane, progressPane, textPane, pricePane;
	JLabel cart, info, pay, contactInfo, shippingAddress;
	JLabel subtotal, subPrice, ship, shipPrice, total, totalPrice;
	JTextField email, first, last, address, aprt, city, st, zip, phone;
	final static int GAP = 10;
	
	public Checkout3() {
		
		//create and set up frame 
		frame = new JFrame("Checkout");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//create progress pane
		progressPane = new JPanel();
		progressPane.setLayout(new GridLayout(0,3));
		progressPane.setBackground(Color.white);
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
				new ImageIcon("src/heartPayEmpty.PNG").getImage().getScaledInstance(90, 90, Image.SCALE_DEFAULT));
		pay.setIcon(imageIconPay);

		progressPane.add(cart);
		progressPane.add(info);
		progressPane.add(pay);
		
		
		//create text pane
		textPane = new JPanel();
		textPane.setBackground(Color.white);
		textPane.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;

		contactInfo = new JLabel("Contact Information");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipadx = 100;
		c.ipady = 20;
		c.weightx = 0.0;
		c.gridwidth = 6;
		c.gridx = 0;
		c.gridy = 0;
		textPane.add(contactInfo, c);
		
		email = new JTextField("Email");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.0;
		c.gridwidth = 6;
		c.gridx = 0;
		c.gridy = 1;
		textPane.add(email, c);
		
		shippingAddress = new JLabel("Shipping Address");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.0;
		c.gridwidth = 6;
		c.gridx = 0;
		c.gridy = 2;
		textPane.add(shippingAddress, c);
		
		
		first = new JTextField("First name");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridwidth = 3;
		c.gridx = 0;
		c.gridy = 3;
		textPane.add(first, c);
		
		last = new JTextField("Last Name");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipadx = 100;
		c.weightx = 0.5;
		c.gridwidth = 3;
		c.gridx = 3;
		c.gridy = 3;
		textPane.add(last, c);
		
		address = new JTextField("Address");
		c.fill = GridBagConstraints.HORIZONTAL;
		      //make this component tall
		c.weightx = 0.0;
		c.gridwidth = 6;
		c.gridx = 0;
		c.gridy = 4;
		textPane.add(address, c);
		
		aprt = new JTextField("Apartment, suite, etc. (optional)");
		c.fill = GridBagConstraints.HORIZONTAL;
		//c.ipady = 40;      //make this component tall
		c.weightx = 0.0;
		c.gridwidth = 6;
		c.gridx = 0;
		c.gridy = 5;
		textPane.add(aprt, c);
		
		
		city = new JTextField("City");
		c.weightx = 0.5;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 6;
		textPane.add(city, c);

		st = new JTextField("State");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridwidth = 2;
		c.gridx = 2;
		c.gridy = 6;
		textPane.add(st, c);

		zip = new JTextField("ZIP code");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridwidth = 2;
		c.gridx = 4;
		c.gridy = 6;
		textPane.add(zip, c);
		
		phone = new JTextField("Phone #");
		c.fill = GridBagConstraints.HORIZONTAL;
		//c.ipady = 40;      //make this component tall
		c.weightx = 0.0;
		c.gridwidth = 6;
		c.gridx = 0;
		c.gridy = 7;
		textPane.add(phone, c);
		
		leftPane = new JPanel();
		leftPane.setLayout(new BoxLayout(leftPane, BoxLayout.PAGE_AXIS));
		leftPane.setBackground(Color.white);
		leftPane.add(progressPane, BorderLayout.CENTER);
		leftPane.add(textPane, BorderLayout.PAGE_END);
		
		//create price pane
		pricePane = new JPanel();
		pricePane.setBackground(Color.white);
		pricePane.setLayout(new GridBagLayout());
		GridBagConstraints c2 = new GridBagConstraints();
		c2.fill = GridBagConstraints.HORIZONTAL;
		
		
		subtotal = new JLabel("Subtotal:");
		c2.fill = GridBagConstraints.HORIZONTAL;
		c2.weightx = 0.0;
		c2.gridwidth = 2;
		c2.gridx = 0;
		c2.gridy = 0;
		pricePane.add(subtotal, c);
		
		subPrice = new JLabel("TBD");
		c2.fill = GridBagConstraints.HORIZONTAL;
		c2.weightx = 0.0;
		c2.gridwidth = 2;
		c2.gridx = 4;
		c2.gridy = 0;
		pricePane.add(subPrice, c);
		
		ship = new JLabel("Shipping:");
		c2.fill = GridBagConstraints.HORIZONTAL;
		c2.weightx = 0.0;
		c2.gridwidth = 2;
		c2.gridx = 0;
		c2.gridy = 1;
		pricePane.add(ship, c);
		
		shipPrice = new JLabel("TBD");
		c2.fill = GridBagConstraints.HORIZONTAL;
		c2.weightx = 0.0;
		c2.gridwidth = 2;
		c2.gridx = 4;
		c2.gridy = 1;
		pricePane.add(shipPrice, c);
		
		
		total = new JLabel("Total:");
		c2.fill = GridBagConstraints.HORIZONTAL;
		c2.weightx = 0.0;
		c2.gridwidth = 2;
		c2.gridx = 2;
		c2.gridy = 2;
		pricePane.add(total, c);
		
		totalPrice = new JLabel("TBD");
		c2.fill = GridBagConstraints.HORIZONTAL;
		c2.weightx = 0.0;
		c2.gridwidth = 2;
		c2.gridx = 4;
		c2.gridy = 2;
		pricePane.add(totalPrice, c);
		
		
		//pricePane.add(new JSeparator(JSeparator.HORIZONTAL), BorderLayout.CENTER);
	
      	//pricePane.setPreferredSize(new Dimension(200, 100));
		
		
		
		
		
		
		bigPane = new JPanel();
		//bigPane.setLayout(new BoxLayout(bigPane, BoxLayout.PAGE_AXIS));
		bigPane.setBackground(Color.white);
		//contentPane.setLayout(new GridLayout(2,2));
		bigPane.add(leftPane);
		bigPane.add(new JSeparator(JSeparator.VERTICAL));
		bigPane.add(pricePane);
		
		
		//add content pane to frame
		frame.setContentPane(bigPane);
				
		//Size and then display the frame
		frame.pack();
		frame.setVisible(true);
		
		
		
	}
	
	private static void runGUI() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		
		Checkout3 c3 = new Checkout3();
	}
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				runGUI();
			}
		});

	}
	
}
