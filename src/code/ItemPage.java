package onlineStore;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


public class ItemPage implements ActionListener{
	public JFrame frameItemPage;
	double cost; 
	String value = "1";
	JPanel contentPane, bigPane; 
	JLabel name, image, price, description;
	JButton addCart, wish;
	JComboBox quantity; 
	ImageIcon tempEmptyHeart = new ImageIcon("src/emptyHeart.png");
	Image imgEmptyHeart = tempEmptyHeart.getImage();
	Image newimg = imgEmptyHeart.getScaledInstance(100, 50,  java.awt.Image.SCALE_SMOOTH);
	ImageIcon emptyHeart = new ImageIcon(newimg);
	
	ImageIcon tempHeart = new ImageIcon("src/heart.PNG"); 
	Image imgHeart = tempHeart.getImage();
	Image newimg1 = imgHeart.getScaledInstance(70, 50,  java.awt.Image.SCALE_SMOOTH);
	ImageIcon heart = new ImageIcon(newimg1);
	Item item1; 
	//https://www.youtube.com/watch?v=Yw0p7tTFAoc
	public ItemPage(Item i) {
		frameItemPage= new JFrame("Clothes");
		frameItemPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameItemPage.setBackground(Color.white);
		item1 = i; 
		contentPane = new JPanel(); 
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));
		contentPane.setBackground(Color.white);
		name = new JLabel(i.getName());
		contentPane.add(name);
		price = new JLabel("$"+i.getPrice());
		cost = i.getPrice();
		
		contentPane.add(price);
		String q[]= {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
		quantity = new JComboBox(q);
		quantity.setSize(200, quantity.getPreferredSize().height);
		quantity.addActionListener(this);
		contentPane.add(quantity);
		addCart = new JButton("Add to Cart");
		addCart.addActionListener(this);
		contentPane.add(addCart);
		
		wish = new JButton();
		wish.setSize(100, 50);
		//wish.setText("hi");
		wish.setIcon(emptyHeart);
		wish.setForeground(Color.white);
		wish.setText("empty");
		wish.setContentAreaFilled(false);
		wish.setBorderPainted(false);
		wish.addActionListener(this);
		contentPane.add(wish);
		
		bigPane = new JPanel(); 
		bigPane.setBackground(Color.white);
		image = i.getImage();
		image.setPreferredSize(new Dimension(300, 500));
		bigPane.add(image);
		
		bigPane.add(contentPane);
		frameItemPage.setContentPane(bigPane);
		 
		/* Size and then display the frameItemPage. */
		frameItemPage.pack();
		frameItemPage.setVisible(true);
	}
	private static void runGUI() {
		 JFrame.setDefaultLookAndFeelDecorated(true);
		 ItemPage c = new ItemPage(new Item("src/cropTop.PNG", "Women's t-shirt", 20));
	 }
	public JPanel showItemPage() {
		return this.bigPane; 
	}
	public void actionPerformed(ActionEvent event) {
		String eventName = event.getActionCommand();
		String value = (String) quantity.getSelectedItem();
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
		  else if(eventName.equals("Add to Cart")) {
			  System.out.println(value);
			  System.out.println(cost);
			  System.out.println(item1.getPrice());
		  }
		  cost = (double)(item1.getPrice()* Integer.parseInt(value));
	
		
	}	

	 public static void main(String[] args) {
	 /* Methods that create and show a GUI should be run from an event-dispatching thread */
		 javax.swing.SwingUtilities.invokeLater(new Runnable() {
		 public void run() {
			runGUI();
		 }
		});
	 }
}
