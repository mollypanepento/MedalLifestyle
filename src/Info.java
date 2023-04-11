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
import javax.swing.SwingConstants;

public class Info{
	JFrame frame;
	JPanel bigPane, head, leftPane, rightPane, progressPane, textPane, pricePane, bottomPane;
	JLabel cart, info, pay, contactInfo, shippingAddress;
	JLabel subtotal, subPrice, ship, shipPrice, total, totalPrice;
	JTextField email, first, last, address, aprt, city, st, zip, phone;
	JButton back, next;
	JSeparator horiz, vert;
	Color lavender = new Color(183,189,231);
	double itemsPrice = 15.00;
	static String emailText;
	static String firstText;
	static String lastText;
	static String addText;
	static String aprtText;
	static String cityText;
	static String stText;
	static String zipText;
	static String phoneText;
	
	public Info() {
		
		//create and set up frame 
		frame = new JFrame("Checkout");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		//create progress pane
		progressPane = new JPanel();
		progressPane.setLayout(new GridLayout(0,3));
		progressPane.setBackground(Color.white);
		progressPane.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		cart = new JLabel(new ImageIcon("src/heartCart.PNG"));
		ImageIcon imageIconCart = new ImageIcon(
				new ImageIcon("src/heartCart.PNG").getImage().getScaledInstance(90, 90, Image.SCALE_DEFAULT));
		cart.setIcon(imageIconCart);
		info = new JLabel(new ImageIcon("src/heartInfo.PNG"));
		ImageIcon imageIconInfo = new ImageIcon(
				new ImageIcon("src/heartInfoEmpty.PNG").getImage().getScaledInstance(90, 90, Image.SCALE_DEFAULT));
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
		
		email = new JTextField();
		email.setText("Email");
		email.addFocusListener(new FocusListener(){
			public void focusGained(FocusEvent event) {
				if(email.getText().equals("Email")) {
					email.setText("");
				}
			}
			
			public void focusLost(FocusEvent event) {
				if(email.getText().equals("")) {
					email.setText("Email");
				}
			}
		});
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 40;
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
		
		
		first = new JTextField();
		first.setText("First name");
		first.addFocusListener(new FocusListener(){
			public void focusGained(FocusEvent event) {
				if(first.getText().equals("First name")) {
					first.setText("");
				}
			}
			
			public void focusLost(FocusEvent event) {
				if(first.getText().equals("")) {
					first.setText("First name");
				}
			}
		});
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridwidth = 3;
		c.gridx = 0;
		c.gridy = 3;
		textPane.add(first, c);
		
		last = new JTextField();
		last.setText("Last name");
		last.addFocusListener(new FocusListener(){
			public void focusGained(FocusEvent event) {
				if(last.getText().equals("Last name")) {
					last.setText("");
				}
			}
			
			public void focusLost(FocusEvent event) {
				if(last.getText().equals("")) {
					last.setText("Last name");
				}
			}
		});
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipadx = 100;
		c.weightx = 0.5;
		c.gridwidth = 3;
		c.gridx = 3;
		c.gridy = 3;
		textPane.add(last, c);
		
		address = new JTextField();
		address.setText("Address");
		address.addFocusListener(new FocusListener(){
			public void focusGained(FocusEvent event) {
				if(address.getText().equals("Address")) {
					address.setText("");
				}
			}
			
			public void focusLost(FocusEvent event) {
				if(address.getText().equals("")) {
					address.setText("Address");
				}
			}
		});
		c.fill = GridBagConstraints.HORIZONTAL;
		      //make this component tall
		c.weightx = 0.0;
		c.gridwidth = 6;
		c.gridx = 0;
		c.gridy = 4;
		textPane.add(address, c);
		
		aprt = new JTextField();
		aprt.setText("Apartment, suite, etc. (optional)");
		aprt.addFocusListener(new FocusListener(){
			public void focusGained(FocusEvent event) {
				if(aprt.getText().equals("Apartment, suite, etc. (optional)")) {
					aprt.setText("");
				}
			}
			
			public void focusLost(FocusEvent event) {
				if(aprt.getText().equals("")) {
					aprt.setText("Apartment, suite, etc. (optional)");
				}
			}
		});
		c.fill = GridBagConstraints.HORIZONTAL;
		//c.ipady = 40;      //make this component tall
		c.weightx = 0.0;
		c.gridwidth = 6;
		c.gridx = 0;
		c.gridy = 5;
		textPane.add(aprt, c);
		
		
		city = new JTextField();
		city.setText("City");
		city.addFocusListener(new FocusListener(){
			public void focusGained(FocusEvent event) {
				if(city.getText().equals("City")) {
					city.setText("");
				}
			}
			
			public void focusLost(FocusEvent event) {
				if(city.getText().equals("")) {
					city.setText("City");
				}
			}
		});
		c.weightx = 0.5;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 6;
		textPane.add(city, c);

		st = new JTextField();
		st.setText("State");
		st.addFocusListener(new FocusListener(){
			public void focusGained(FocusEvent event) {
				if(st.getText().equals("State")) {
					st.setText("");
				}
			}
			
			public void focusLost(FocusEvent event) {
				if(st.getText().equals("")) {
					st.setText("State");
				}
			}
		});
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridwidth = 2;
		c.gridx = 2;
		c.gridy = 6;
		textPane.add(st, c);

		zip = new JTextField();
		zip.setText("ZIP code");
		zip.addFocusListener(new FocusListener(){
			public void focusGained(FocusEvent event) {
				if(zip.getText().equals("ZIP code")) {
					zip.setText("");
				}
			}
			
			public void focusLost(FocusEvent event) {
				if(zip.getText().equals("")) {
					zip.setText("ZIP code");
				}
			}
		});
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridwidth = 2;
		c.gridx = 4;
		c.gridy = 6;
		textPane.add(zip, c);
		
		phone = new JTextField();
		phone.setText("Phone #");
		phone.addFocusListener(new FocusListener(){
			public void focusGained(FocusEvent event) {
				if(phone.getText().equals("Phone #")) {
					phone.setText("");
				}
			}
			
			public void focusLost(FocusEvent event) {
				if(phone.getText().equals("")) {
					phone.setText("Phone #");
				}
			}
		});
		c.fill = GridBagConstraints.HORIZONTAL;
		//c.ipady = 40;      //make this component tall
		c.weightx = 0.0;
		c.gridwidth = 6;
		c.gridx = 0;
		c.gridy = 7;
		textPane.add(phone, c);
		
		back = new JButton(new ImageIcon("src/backToCart.PNG"));
		ImageIcon imageIconBack = new ImageIcon(
				new ImageIcon("src/backToCart.PNG").getImage().getScaledInstance(100, 70, Image.SCALE_DEFAULT));
		back.setIcon(imageIconBack);
		back.setBackground(Color.white);
		
		leftPane = new JPanel();
		leftPane.setLayout(new BoxLayout(leftPane, BoxLayout.PAGE_AXIS));
		leftPane.setBackground(Color.white);
		leftPane.add(progressPane, BorderLayout.CENTER);
		leftPane.add(textPane, BorderLayout.CENTER);
		leftPane.add(back, BorderLayout.PAGE_END);
		leftPane.add(new JSeparator(JSeparator.VERTICAL), BorderLayout.EAST);
		
		//create price pane
		pricePane = new JPanel();
		pricePane.setBackground(Color.white);
		pricePane.setLayout(new GridBagLayout());
		GridBagConstraints c2 = new GridBagConstraints();
		c2.fill = GridBagConstraints.HORIZONTAL;
		
		
		subtotal = new JLabel("Subtotal:");
		c2.fill = GridBagConstraints.HORIZONTAL;
		c2.ipady = 40;
		c2.weightx = 0.5;
		c2.gridwidth = 2;
		c2.gridx = 0;
		c2.gridy = 0;
		pricePane.add(subtotal, c2);
		
		subPrice = new JLabel("$" + itemsPrice + "0");
		c2.fill = GridBagConstraints.HORIZONTAL;
		c2.weightx = 0.5;
		c2.gridwidth = 2;
		c2.gridx = 6;
		c2.gridy = 0;
		pricePane.add(subPrice, c2);
		
		ship = new JLabel("Shipping:");
		c2.fill = GridBagConstraints.HORIZONTAL;
		c2.weightx = 0.5;
		c2.gridwidth = 2;
		c2.gridx = 0;
		c2.gridy = 1;
		pricePane.add(ship, c2);
		
		shipPrice = new JLabel("TBD");
		c2.fill = GridBagConstraints.HORIZONTAL;
		c2.weightx = 0.5;
		c2.gridwidth = 2;
		c2.gridx = 6;
		c2.gridy = 1;
		pricePane.add(shipPrice, c2);
		
		horiz = new JSeparator(JSeparator.HORIZONTAL);
		c2.fill = GridBagConstraints.HORIZONTAL;
		c2.weightx = 0.5;
		c2.gridwidth = 8;
		c2.gridx = 0;
		c2.gridy = 2;
		pricePane.add(horiz, c2);
		
		
		total = new JLabel("Total:");
		c2.fill = GridBagConstraints.HORIZONTAL;
		c2.weightx = 0.5;
		c2.gridwidth = 2;
		c2.gridx = 3;
		c2.gridy = 3;
		pricePane.add(total, c2);
		
		totalPrice = new JLabel("TBD");
		c2.fill = GridBagConstraints.HORIZONTAL;
		c2.weightx = 0.5;
		c2.gridwidth = 2;
		c2.gridx = 6;
		c2.gridy = 3;
		pricePane.add(totalPrice, c2);
		
	
      	pricePane.setPreferredSize(new Dimension(200, 100));
		pricePane.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		
		next = new JButton(new ImageIcon("src/nextToPay.PNG"));
		ImageIcon imageIconNext = new ImageIcon(
				new ImageIcon("src/nextToPay.PNG").getImage().getScaledInstance(100, 70, Image.SCALE_DEFAULT));
		next.setIcon(imageIconNext);
		next.setBackground(Color.white);
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				emailText = email.getText();
				firstText = first.getText();
				lastText = last.getText();
				addText = address.getText();
				cityText = city.getText();
				stText = st.getText();
				zipText = zip.getText();
				phoneText = phone.getText();
				frame.dispose();
				new Payment();
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
		c4.ipady = 20;
		c4.weightx = 0.5;
		c4.gridwidth = 6;
		c4.gridx = 0;
		c4.gridy = 0;
		bigPane.add(head, c4);
		
		leftPane = new JPanel();
		leftPane.setLayout(new BoxLayout(leftPane, BoxLayout.PAGE_AXIS));
		leftPane.setBackground(Color.white);
		leftPane.add(progressPane, BorderLayout.PAGE_START);
		leftPane.add(textPane, BorderLayout.CENTER);
		leftPane.setPreferredSize(new Dimension(800, 1500));
		c4.fill = GridBagConstraints.HORIZONTAL;
		c4.ipady = 50;
		c4.weightx = 0.5;
		c4.gridwidth = 4;
		c4.gridx = 0;
		c4.gridy = 1;
		bigPane.add(leftPane, c4);
		
		rightPane = new JPanel();
		rightPane.setBackground(Color.white);
		rightPane.setLayout(new BoxLayout(rightPane, BoxLayout.PAGE_AXIS));
		rightPane.add(pricePane, BorderLayout.PAGE_START);
		rightPane.setPreferredSize(new Dimension(500, 1500));
		c4.fill = GridBagConstraints.HORIZONTAL;
		c4.ipady = 50;
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
		bottomPane.add(next);
		c4.fill = GridBagConstraints.HORIZONTAL;
		c4.ipady = 35;
		c4.weightx = 0.5;
		c4.gridwidth = 6;
		c4.gridx = 0;
		c4.gridy = 2;
		bigPane.add(bottomPane, c4);
		
		//add content pane to frame
		frame.setContentPane(bigPane);
				
		//Size and then display the frame
		//code for creating a full screen window
		frame.pack();
		frame.setVisible(true);
		frame.setSize(1600,900);
		frame.setTitle("Info");
		
	
	}
	
	public static String getEmail() {
		return emailText;
	}
	
	public static String getFirstName() {
		return firstText;
	}
	
	public static String getLastName() {
		return lastText;
	}
	
	public static String getAddress() {
		return addText;
	}
	
	public static String getAprt() {
		return aprtText;
	}
	
	public static String getCity() {
		return cityText;
	}
	
	public static String getState() {
		return stText;
	}
	
	public static String getZip() {
		return zipText;
	}
	
	public static String getPhone() {
		return phoneText;
	}
	
	
	private static void runGUI() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		
		Info in = new Info();
	}
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				runGUI();
			}
		});

	}
	
}
