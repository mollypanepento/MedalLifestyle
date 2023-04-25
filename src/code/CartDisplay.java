package medal;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.awt.geom.RoundRectangle2D;
import java.text.NumberFormat;
import java.util.HashMap;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.plaf.basic.BasicArrowButton;

public class CartDisplay extends JPanel implements MouseListener {
	private Cart cart;
	private HashMap <BasicArrowButton, Item> incAmtButtons = new HashMap <BasicArrowButton, Item>();
	private HashMap <BasicArrowButton, Item> decAmtButtons = new HashMap <BasicArrowButton, Item>();
	private Color medalDarkPurple = new Color(115,118,236);
	private Color medalPurple = new Color(203, 205, 247);
	private Color medalPink = new Color(255,204,194);
	
//	private ArrayList<JButton> = new ArrayList<JButton>;
//	private BasicArrowButton incAmtBtn, decAmtBtn;
//	this.addMouseListener(this);
	
	public CartDisplay(Cart cart) {
		this.cart = cart;
		this.setLayout(null);

		//hash map of buttons
		for (Item i: cart.getItemsMap().keySet()) {
			  incAmtButtons.put(new BasicArrowButton(BasicArrowButton.NORTH), i);
			  decAmtButtons.put(new BasicArrowButton(BasicArrowButton.SOUTH), i);
		}
	}
	
	public void paintComponent(Graphics g) {
		
		
//		 deleteBars = new RoundRectangle2D[WishList.size()];
//		addBars = new RoundRectangle2D[WishList.size()];
//		fillList(deleteBars);
//		fillList(addBars);
       super.paintComponent(g);
       Graphics2D g2d = (Graphics2D) g;
   
       
       //draw rectangle boxes for items
       for(int i=0; i<8; i++) {
    	 
       	g2d.setColor(medalDarkPurple);
       	
       	g2d.setStroke(new BasicStroke(10));
       	g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    	g2d.drawRoundRect(210, 50+i*150, 650, 125, 50, 30);
    
    	g2d.setColor(medalPurple);
       	RoundRectangle2D roundRect = new RoundRectangle2D.Double(210, 50+i*150, 650, 125, 50, 30);
       	g2d.fill(roundRect);
       

       }
       
       //TODO: test with actual images
       //draw all of the item images, item names, item prices
       
       g2d.setColor(Color.black);
       int increment = 0;
       NumberFormat formatter = NumberFormat.getCurrencyInstance();
       for(Item i: cart.getItemsMap().keySet()) {
    	   g2d.drawImage(i.getImg(), 430,60+increment*150,100,100, null);
    	   g2d.drawString(i.getName(), 410, 80+increment*150);
    	   g2d.drawString(formatter.format(i.getPrice()), 700, 80+increment*150);
    	   g2d.drawString("Qty: " + cart.getQuantity(i) , 440, 150+increment*150);
    	   increment++;
       }
       
       //draw all of the increase amount buttons
       increment = 0;
       for (BasicArrowButton button: incAmtButtons.keySet()) {
       		button.setBounds(410, 145+increment*150, 10, 10);
       		increment++;
    		this.add(button);
       	}
       
       //draw all of the decrease amount buttons
       increment = 0;
       for (BasicArrowButton button: decAmtButtons.keySet()) {
       		button.setBounds(420, 145+increment*150, 10, 10);
       		increment++;
    		this.add(button);
       	}
       
    //draw rectangle for subtotal
    g2d.setColor(medalPink);
    Double rect = new Rectangle2D.Double(1010, 50, 350, 125);
    g2d.draw(rect);
    g2d.setColor(Color.white);
   	g2d.fill(rect);
   	
   	g2d.setColor(Color.black);
   	String subtotal = formatter.format(cart.getSubtotal());
   	g2d.drawString("Subtotal (" + cart.getTotalAmtOfItems() + " items): " + subtotal, 1010, 80);
   	
   	//draw rectangle for going to checkout
   	g2d.setColor(medalPink);
   	RoundRectangle2D roundRect = new RoundRectangle2D.Double(1010, 200, 350, 125, 50, 30);
   	g2d.draw(roundRect);
   	g2d.setColor(Color.white);
   	g2d.fill(roundRect);
   	
   	g2d.setColor(Color.black);
   	g2d.drawString("Checkout", 1010, 220);
   	
   	
    
       
	}
	
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

		for (Item i: incAmtButtons.values()) {
			 
			if(e.getComponent().equals(button)) {
				Item item = incAmtButtons.
				cart.incQuantityBy1(item);
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
