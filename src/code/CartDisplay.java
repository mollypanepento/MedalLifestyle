package medal;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.awt.geom.RoundRectangle2D;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.plaf.basic.BasicArrowButton;

public class CartDisplay extends JPanel implements MouseListener, ActionListener {
	private Cart cart;
	private LinkedHashMap <BasicArrowButton, Item> incAmtButtons = new LinkedHashMap <BasicArrowButton, Item>();
	private LinkedHashMap <BasicArrowButton, Item> decAmtButtons = new LinkedHashMap <BasicArrowButton, Item>();
	private LinkedHashMap <JButton, Item> removeButtons = new LinkedHashMap <JButton, Item>();
	private Color medalDarkPurple = new Color(115,118,236);
	private Color medalPurple = new Color(203, 205, 247);
	private Color medalPink = new Color(255,204,194);
	
	public CartDisplay(Cart cart) {
		this.cart = cart;
		this.setLayout(null);
		
		JLabel trashLabel = new JLabel(new ImageIcon("src/medal/trash.png"));
		this.add(trashLabel);
		

		//hash map of buttons
		for (Item i: cart.getItemsMap().keySet()) {
			BasicArrowButton inc = new BasicArrowButton(BasicArrowButton.NORTH);
			inc.addActionListener(this);
			this.add(inc);
			
			BasicArrowButton dec = new BasicArrowButton(BasicArrowButton.SOUTH);
			dec.addActionListener(this);
			this.add(dec);
			
//trash instantiation
		
			
				 ImageIcon oldTrashIcon = new ImageIcon("src/medal/trash.png");
				 Image img = oldTrashIcon.getImage();
				 Image newImg = img.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
//			    Image img = new Image("src/medal/trash.png");
				 ImageIcon trashIcon = new ImageIcon(newImg);
				 
			   
			  
//			ImageIcon trashImage = new ImageIcon("src/medal/trash.png");
//			JButton trash = new JButton(trashImage);
			  
			 
			  JButton trash = new JButton(trashIcon);
			  trash.setIcon(trashIcon);
//			  trash.setOpaque(false);
//			  trash.setContentAreaFilled(false);
//			  trash.setBorderPainted(false);
//			    trash.setDisabledIcon(trashIcon);
//			    trash.setEnabled(false);
			  trash.addActionListener(this);
			this.add(trash);
//			this.add(trashLabel);
			
			  incAmtButtons.put(inc, i);
			  decAmtButtons.put(dec, i);
//			  deleteImages.put(trashImage, i);
			  removeButtons.put(trash, i);
			  
		}
		
		
		System.out.println("incAmtButtons hashmap size: " + incAmtButtons.size());
		System.out.println("cart size: " + cart.getItemsMap().size());
	
	}
	
	public void removeIncButton(Item item) {
		  Iterator<Map.Entry<BasicArrowButton, Item> >
          iterator = incAmtButtons.entrySet().iterator();

      // Iterate over the HashMap
      while (iterator.hasNext()) {

          // Get the entry at this iteration
          Map.Entry<BasicArrowButton, Item>
              entry
              = iterator.next();

          // Check if this value is the required value
          if (item.equals(entry.getValue())) {

              // Remove this entry from HashMap
              iterator.remove();
          }
      }
	}
	
	public void removeDecButton(Item item) {
		  Iterator<Map.Entry<BasicArrowButton, Item> >
        iterator = decAmtButtons.entrySet().iterator();

    // Iterate over the HashMap
    while (iterator.hasNext()) {

        // Get the entry at this iteration
        Map.Entry<BasicArrowButton, Item>
            entry
            = iterator.next();

        // Check if this value is the required value
        if (item.equals(entry.getValue())) {

            // Remove this entry from HashMap
            iterator.remove();
        }
    }
	}
	
	public void paintComponent(Graphics g) {
		
		

       super.paintComponent(g);
       Graphics2D g2d = (Graphics2D) g;
   
       
       //draw rectangle boxes for items
       for(int i=0; i<cart.getItemsMap().size(); i++) {
    	 
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
       
       
       
//draw all of the trash buttons
       increment = 0;
       for (JButton button: removeButtons.keySet()) {
       		button.setBounds(710, 145+increment*150, 30, 30);
       		button.setSelected(false);
       		increment++;
    		
       	}  
       //draw all of the increase amount buttons
       increment = 0;
       for (BasicArrowButton button: incAmtButtons.keySet()) {
       		button.setBounds(410, 145+increment*150, 10, 10);
       		increment++;
    		
       	}
       
    
       
       //draw all of the decrease amount buttons
       increment = 0;
       for (BasicArrowButton button: decAmtButtons.keySet()) {
       		button.setBounds(420, 145+increment*150, 10, 10);
       		increment++;
    		
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		for (BasicArrowButton button: incAmtButtons.keySet()) {			
				if(e.getSource().equals(button)) {
					System.out.println("increase pressed");
					cart.incQuantityBy1(incAmtButtons.get(button));
					System.out.println("Quantity: " + cart.getQuantity(incAmtButtons.get(button)));
					repaint();
				
				}
		}
		for (BasicArrowButton button: decAmtButtons.keySet()) {			
			if(e.getSource().equals(button)) {
				Item item = decAmtButtons.get(button);
				if(cart.getQuantity(item)>0) {
					cart.decQuantityBy1(item);
					repaint();
				}
				
			}
		}
		
	
		
		for (JButton button: removeButtons.keySet()) {		
			if (e.getSource().equals(button)) {
				Item item = removeButtons.get(button);
//				System.out.println(item.getName());
				//remove item from cart
				cart.removeItem(item);
				//remove corresponding buttons from cart display
				removeButtons.remove(button);
				removeIncButton(item);
				removeDecButton(item);
				repaint();
				System.out.println("-----cartItems");
				for (Map.Entry<Item, Integer> entry : cart.getItemsMap().entrySet()) {
				      System.out.println(entry.getKey().getName() + ": " + entry.getValue());
				    }
				System.out.println("-----incAmtButtons");
				for (Map.Entry<BasicArrowButton, Item> entry : incAmtButtons.entrySet()) {
				      System.out.println(entry.getKey().getName() + ": " + entry.getValue().getName());
				    }
				System.out.println("-----decAmtButtons");
				for (Map.Entry<BasicArrowButton, Item> entry : decAmtButtons.entrySet()) {
				      System.out.println(entry.getKey().getName() + ": " + entry.getValue().getName());
				    }
				
				System.out.println("-----removeButtons");
				for (Entry<JButton, Item> entry : removeButtons.entrySet()) {
				      System.out.println(entry.getKey().getName() + ": " + entry.getValue().getName());
				    }
				System.out.println("cart size: " + cart.getItemsMap().size());
				System.out.println("incAmtButtons hashmap size: " + incAmtButtons.size());
				System.out.println("decAmtButtons hashmap size: " + decAmtButtons.size());
				System.out.println("removeButtons hashmap size: " + removeButtons.size());
				System.out.println("----------------------------");
				
				break;
			}
		}
	}
}
