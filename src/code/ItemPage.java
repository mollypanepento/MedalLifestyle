package onlineStore;
import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


public class ItemPage1 extends JPanel implements ActionListener{
	public JFrame frameItemPage;
	double cost; 
	String value = "1";
	JPanel contentPane, bigPane, buyPane; 
	Header h = new Header(); 
	JLabel name, image, price, description;
	JButton addCart, wish, back;
	JComboBox quantity; 
	ImageIcon tempEmptyHeart = new ImageIcon("src/emptyHeart.png");
	Image imgEmptyHeart = tempEmptyHeart.getImage();
	Image newimg = imgEmptyHeart.getScaledInstance(100, 50,  java.awt.Image.SCALE_SMOOTH);
	ImageIcon emptyHeart = new ImageIcon(newimg);
	ItemList itemList = new ItemList(); 
	ImageIcon tempHeart = new ImageIcon("src/heart.PNG"); 
	Image imgHeart = tempHeart.getImage();
	Image newimg1 = imgHeart.getScaledInstance(70, 50,  java.awt.Image.SCALE_SMOOTH);
	ImageIcon heart = new ImageIcon(newimg1);
	Item1 item1; 
	ItemList i = new ItemList(); 
	private static final JViewport viewport = new JViewport(); 
	//https://www.youtube.com/watch?v=Yw0p7tTFAoc
	public ItemPage1(Item1 i) {
		item1 = i; 
		frameItemPage= new JFrame("Clothes");
		frameItemPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameItemPage.setBackground(Color.white);

		contentPane = new JPanel(); 
		//contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));
		contentPane.setBackground(Color.white);
		
		image = new JLabel();
		Image tempImg = i.getImg();
		Image newImg = tempImg.getScaledInstance(300, 250,  java.awt.Image.SCALE_SMOOTH);
		image.setIcon(new ImageIcon(newImg));
		contentPane.add(image);
		
		buyPane = new JPanel();
		name = new JLabel(i.getName());
		buyPane.add(name);
		price = new JLabel("$"+i.getPrice());
		cost = i.getPrice();
		buyPane.add(price);
		String q[]= {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
		quantity = new JComboBox(q);
		quantity.setSize(200, quantity.getPreferredSize().height);
		quantity.addActionListener(this);
		buyPane.add(quantity);
		addCart = new JButton("Add to Cart");
		addCart.addActionListener(this);
		buyPane.add(addCart);
		
		wish = new JButton();
		wish.setSize(100, 50);
		//wish.setText("hi");
		wish.setIcon(emptyHeart);
		wish.setForeground(Color.white);
		wish.setText("empty");
		wish.setContentAreaFilled(false);
		wish.setBorderPainted(false);
		wish.addActionListener(this);
		buyPane.add(wish);
		
		contentPane.add(buyPane);
		
		back = new JButton("Go Back"); 
		back.addActionListener(this);
		contentPane.add(back);
		
		bigPane = new JPanel(); 
		bigPane.setLayout(new BoxLayout(bigPane, BoxLayout.PAGE_AXIS));
		bigPane.setBackground(Color.white);
		bigPane.add(h.createHeader());
//		image = i.getImg();
//		image.setPreferredSize(new Dimension(300, 500));
//		bigPane.add(image);
		
		bigPane.add(contentPane);
		frameItemPage.setContentPane(bigPane);
		 
		/* Size and then display the frameItemPage. */
		frameItemPage.pack();
		frameItemPage.setVisible(true);
		frameItemPage.setSize(1600, 900);
	}
	private static void runGUI() {
		 JFrame.setDefaultLookAndFeelDecorated(true);
		 ItemPage1 c = new ItemPage1(ItemList.electronics.get(2));
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
			// method to add to wish list 
		  }
		  else if(eventName.equals("fill")) {
			  wish.setIcon(emptyHeart);
			  wish.setText("empty");
			  // method to remove from wish list 
		  } 
		  else if(eventName.equals("Add to Cart")) {
			  System.out.println(value);
			  System.out.println(cost);
			  System.out.println(item1.getPrice());
			  
			  // use angelina's add to cart method here 
		  }
		  else if(eventName.equals("Go Back")) {
			  System.out.println("Back clicked");
			  String department = item1.getDepartment();
//FIGURE OUT HOW TO USE VARIABLE TO CALL STATIC DEPARTMENT LISTS
			  Store1 s = new Store1(ItemList.findList(department));
			  System.out.println(ItemList.clothes.size());
		  }
		  cost = (double)(item1.getPrice()* Integer.parseInt(value));
	
		
	}	
	public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        //this.addActionListener(this);
        ImageObserver io = null;
        g2d.drawImage(item1.getImg(),430,60+150,100,100,null);
  
       }


	 public static void main(String[] args) {
	 /* Methods that create and show a GUI should be run from an event-dispatching thread */
		 javax.swing.SwingUtilities.invokeLater(new Runnable() {
		 public void run() {
			 ItemList i = new ItemList(); 
			runGUI();
		 }
		});
	 }
}
