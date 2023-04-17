package onlineStore;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class OrderPlaced {
	
	JFrame frame;
	JPanel bigPane, head, textPane, bottomPane;
	JLabel celebrate, message, email, orderNum, write;
	JButton keep, cancel;
	Color lavender = new Color(183,189,231);
	
	public OrderPlaced() {
		frame = new JFrame("Confirm Order");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		celebrate = new JLabel(new ImageIcon("src/celebrate.PNG"), JLabel.CENTER);
		ImageIcon imageIconYay = new ImageIcon(
				new ImageIcon("src/celebrate.PNG").getImage().getScaledInstance(250, 300, Image.SCALE_DEFAULT));
			celebrate.setIcon(imageIconYay);
			celebrate.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		celebrate.setBorder(BorderFactory.createEmptyBorder(0,50,0,50));
		
		message = new JLabel("Your order has been placed!");
		message.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		message.setFont(new Font("Calibri", Font.PLAIN, 25));
		message.setBorder(BorderFactory.createEmptyBorder(0,100,0,100));
		
		email = new JLabel("A confirmation email has been sent to " + Info.getEmail(),JLabel.CENTER);
		email.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		email.setFont(new Font("Calibri", Font.PLAIN, 25));
		email.setBorder(BorderFactory.createEmptyBorder(0,100,0,100));
		
		orderNum = new JLabel("Your order number is: #" + getOrderNum(), JLabel.CENTER);
		orderNum.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		orderNum.setFont(new Font("Calibri", Font.PLAIN, 25));
		orderNum.setBorder(BorderFactory.createEmptyBorder(0,100,0,100));
		
		write = new JLabel("(Write this number down for future reference)");
		write.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		write.setFont(new Font("Calibri", Font.PLAIN, 20));
		write.setBorder(BorderFactory.createEmptyBorder(0,100,0,100));
		
		keep = new JButton(new ImageIcon("src/keepShopping.PNG"));
		ImageIcon imageIconKeep = new ImageIcon(
				new ImageIcon("src/keepShopping.PNG").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		keep.setIcon(imageIconKeep);
		keep.setBackground(Color.white);
		keep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				frame.dispose();
				//new Payment();
			}
		});
		
		cancel = new JButton(new ImageIcon("src/cancel.PNG"));
		ImageIcon imageIconCancel = new ImageIcon(
				new ImageIcon("src/cancel.PNG").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		cancel.setIcon(imageIconCancel);
		cancel.setBackground(Color.white);
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				/*orderNum = 1000 + (int)Math.random()*1;
				
				for(int i = 0; i < used.size(); i++) {
					if(orderNum == used.get(i)) {
						orderNum = 1000 + (int)Math.random()*1000;
					}
				}
				used.add(orderNum);*/
				frame.dispose();
				//new OrderPlaced();
			}
		});
		
		bigPane = new JPanel();
		bigPane.setBackground(Color.white);
		bigPane.setLayout(new BoxLayout(bigPane, BoxLayout.PAGE_AXIS));
		
		
		Header h = new Header();
		head = h.createHeader();
		head.setPreferredSize(new Dimension(1600,150));
		bigPane.add(head, BorderLayout.PAGE_START);
		
		textPane = new JPanel();
		textPane.setBorder(BorderFactory.createLineBorder(lavender));
		textPane.setLayout(new BoxLayout(textPane, BoxLayout.PAGE_AXIS));
		textPane.setBackground(Color.white);
		textPane.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		textPane.setPreferredSize(new Dimension(1600, 500));
		textPane.add(celebrate, BorderLayout.PAGE_START);
		textPane.add(message, BorderLayout.CENTER);
		textPane.add(email, BorderLayout.CENTER);
		textPane.add(orderNum, BorderLayout.CENTER);
		textPane.add(write, BorderLayout.PAGE_END);
		
		bigPane.add(Box.createVerticalStrut(50));
		bigPane.add(textPane, BorderLayout.CENTER);
		
		bottomPane = new JPanel();
		bottomPane.setBackground(Color.white);
		bottomPane.add(keep);
		bottomPane.add(Box.createGlue());
		bottomPane.add(cancel);
		bottomPane.setPreferredSize(new Dimension(1600,300));
		bigPane.add(bottomPane, BorderLayout.PAGE_END);
		
		//add content pane to frame
		frame.setContentPane(bigPane);
						
		//Size and then display the frame
		frame.pack();
		frame.setVisible(true);
		frame.setSize(1600,900);
		
	}
	
	public static int getOrderNum() {

		final AtomicLong sequence = new AtomicLong(System.currentTimeMillis() / 1000);

	    return (int) sequence.incrementAndGet();
	    
	}
	
	
	private static void runGUI() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		OrderPlaced success = new OrderPlaced();
	}
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				runGUI();
			}
		});

	}
	
}
