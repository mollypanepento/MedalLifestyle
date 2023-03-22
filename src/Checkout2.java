import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;
public class Checkout2 {
	private static void createAndShowGUI() {
        String[] labels = {"Name: ", "Fax: ", "Email: ", "Address: "};
        int numPairs = labels.length;
        JLabel cart, info, pay, contactInfo, shippingInfo, email, fName, lName, phoneNum, address, output;
    	JTextField emailA, fNameA, lNameA, phoneNumA, addressA; 
    	JButton button;

        //Create and populate the panel.
        JPanel contentPane = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
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
        

        //Create and set up the window.
        JFrame frame = new JFrame("SpringForm");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Set up the content pane.
        //p.setOpaque(true);  //content panes must be opaque
        //frame.setContentPane(p);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
