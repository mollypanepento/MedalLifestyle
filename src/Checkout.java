import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Checkout extends JPanel implements ActionListener{
	JFrame frame;
	JPanel contentPaneHeart, contentPane, bigPane; 
	JLabel cart, info, pay, contactInfo, shippingInfo, email, fName, lName, phoneNum, address, output;
	JTextField emailA, fNameA, lNameA, phoneNumA, addressA; 
	JButton button; 
	
	//http://www.java2s.com/Tutorial/Java/0240__Swing/Usethewritemethodtowritethecontents.htm 
	//create and set up frame 
	public Checkout(){
		frame = new JFrame("Checkout");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//create a content pane
		contentPane = new JPanel();
		//contentPane.setLayout(new GridLayout(0, 2, 10, 5));
		contentPane.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		contentPane.setBackground(Color.white);
		contentPane.setBorder(BorderFactory.createLineBorder(Color.pink));
		//contentPane.setLayout(new GridLayout(8, 2));
		
		//create a content pane
//		contentPaneHeart = new JPanel();
//		contentPaneHeart.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
//		contentPaneHeart.setBackground(Color.white);
//		contentPaneHeart.setBorder(BorderFactory.createLineBorder(Color.pink));
		
		
		//create a content pane
//		bigPane = new JPanel();
//		bigPane.setBackground(Color.white);
//		bigPane.setLayout(new BoxLayout(bigPane, BoxLayout.PAGE_AXIS));
		
		//add hearts 
		cart = new JLabel(new ImageIcon("src/heartCart.PNG"));
		ImageIcon imageIconCart = new ImageIcon(new ImageIcon("src/heartCart.PNG").getImage().getScaledInstance(90, 90, Image.SCALE_DEFAULT));
		cart.setIcon(imageIconCart);
		info = new JLabel(new ImageIcon("src/heartInfo.PNG"));
		ImageIcon imageIconInfo = new ImageIcon(new ImageIcon("src/heartInfo.PNG").getImage().getScaledInstance(90, 90, Image.SCALE_DEFAULT));
		info.setIcon(imageIconInfo);
		pay = new JLabel(new ImageIcon("src/heartPay.PNG"));
		ImageIcon imageIconPay = new ImageIcon(new ImageIcon("src/heartPay.PNG").getImage().getScaledInstance(90, 90, Image.SCALE_DEFAULT));
		pay.setIcon(imageIconPay);
//		contentPaneHeart.add(cart);
//		contentPaneHeart.add(info);
//		contentPaneHeart.add(pay);
		contentPane.add(cart, BorderLayout.PAGE_START);
		contentPane.add(info, BorderLayout.PAGE_START);
		contentPane.add(pay, BorderLayout.PAGE_START);
		
		contactInfo = new JLabel("Contact Info");
		contactInfo.setFont(new Font("Cambria", Font.PLAIN, 20));
		contentPane.add(contactInfo, BorderLayout.LINE_START); 
		contentPane.add(new JLabel(""));
		
		//create and add a prompt and then a text field
		email = new JLabel("Email ");
		contentPane.add(email, BorderLayout.LINE_START);
		emailA = new JTextField();
		contentPane.add(emailA, BorderLayout.CENTER);
		
		shippingInfo = new JLabel("Shipping Info");
		shippingInfo.setFont(new Font("Cambria", Font.PLAIN, 20));
		contentPane.add(shippingInfo, BorderLayout.LINE_START); 
		contentPane.add(new JLabel("")); 
		
		fName = new JLabel("First Name ");
		contentPane.add(fName);
		fNameA = new JTextField();
		contentPane.add(fNameA);
		
		lName = new JLabel("Last Name ");
		contentPane.add(lName);
		lNameA = new JTextField();
		contentPane.add(lNameA);
		
		phoneNum = new JLabel("Phone Number ");
		contentPane.add(phoneNum);
		phoneNumA = new JTextField();
		contentPane.add(phoneNumA);
		
		address = new JLabel("Address ");
		contentPane.add(address);
		addressA = new JTextField();
		contentPane.add(addressA);
		
		//create and add button
		button = new JButton("Next");
		button.setActionCommand("Next");
		button.addActionListener(this);
		contentPane.add(button);
		button.setAlignmentX(JButton.LEFT_ALIGNMENT);
		
		output = new JLabel("");
		contentPane.add(output);
		//add content pane to frame
//		bigPane.add(contentPaneHeart);
//		bigPane.add(contentPane);
//		frame.setContentPane(bigPane);
		frame.setContentPane(contentPane);
		frame.getContentPane().setPreferredSize(new Dimension(200, 300));
		
		//Size and then display the frame
//		frame.pack();
//		frame.setVisible(true);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frame.setUndecorated(true);
		frame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent event) {
		String eventName = event.getActionCommand();
		
		if(eventName.equals("Next") && !(fNameA.getText().isEmpty() || lNameA.getText().isEmpty() || phoneNumA.getText().isEmpty() || addressA.getText().isEmpty())) {
			output.setText("Saved info");
		}
		else {
			output.setText("Please fill in all the information");
		}
	}
	
	private static void runGUI() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		
		Checkout test = new Checkout();
	}
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				runGUI();
			}
		});

	}
	
}