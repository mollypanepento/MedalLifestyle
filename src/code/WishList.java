//NOT VISUALLY APPEALING YET, BUT EVERTHING WORKS EXCEPT ADD TO CART

import java.util.ArrayList;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import javax.imageio.*;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JViewport;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;

public class WishList extends JPanel implements MouseListener {
	private static final int WIDTH = 1500;
    private static final int HEIGHT = 10000;
    private static final int FRAME_WIDTH = 1600;
    private static final int FRAME_HEIGHT = 900;
    private static final Color PURP = new Color(203, 205, 247);
    private static final JViewport viewport = new JViewport();
    public static ItemList item = new ItemList();
    
    private static Ellipse2D priceLowToHighOval = new Ellipse2D.Double(1200, 600, 100, 100);
    private static Ellipse2D priceHighToLowOval = new Ellipse2D.Double(1400, 600, 100, 100);
    private static Ellipse2D nameOval = new Ellipse2D.Double(1200, 400, 100, 100);
    private static Ellipse2D departmentOval = new Ellipse2D.Double(1200, 200, 100, 100);
    private static RoundRectangle2D[] deleteBars;
    private static RoundRectangle2D[] addBars;
    
     
    
    public static ArrayList<Item> WishList = ItemList.ItemList;
    private JButton b;
    
	public static void main(String[] args) {
		//bigPane
		JPanel bigPane = new JPanel();
		bigPane.setLayout(new GridBagLayout());
		GridBagConstraints c4 = new GridBagConstraints();
		c4.fill = GridBagConstraints.HORIZONTAL;
		
		//header
		JPanel head = new JPanel();
		Header h = new Header();
		head = h.createHeader();
		c4.fill = GridBagConstraints.HORIZONTAL;
		c4.weightx = 0.5;
		c4.gridwidth = 6;
		c4.gridx = 0;
		c4.gridy = 0;
		bigPane.add(head, c4);
		
    	//Create wishlist JPanel
    	WishList wlist = new WishList();
        wlist.setLayout(new BoxLayout(wlist,BoxLayout.PAGE_AXIS));
        wlist.setBackground(Color.WHITE);
        wlist.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        wlist.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        //create scrollbar
        JScrollPane scrollbar = new JScrollPane(wlist,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollbar.setWheelScrollingEnabled(true);
        scrollbar.getVerticalScrollBar().setUnitIncrement(20);

        
        
        JFrame frame = new JFrame();
        frame.setTitle("WishList");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));

       // frame.setContentPane(scrollbar);
        c4.fill = GridBagConstraints.HORIZONTAL;
		c4.ipady = 750;
		c4.weightx = 0.5;
		c4.gridwidth = 6;
		c4.gridx = 0;
		c4.gridy = 2;
        bigPane.add(scrollbar, c4);
        frame.setContentPane(bigPane);
        
        JLabel wishlist = new JLabel("My Wishlist");
        wishlist.setFont(new Font("Tajawal", Font.PLAIN, 36));
        wishlist.setBorder(BorderFactory.createEmptyBorder(0,0,50,0));
        wlist.add(wishlist);
        

        frame.pack();
        frame.setVisible(true);
    
    }
	
	public void mouseClicked(MouseEvent e) {
		   if ((e.getButton() == 1) && priceLowToHighOval.contains(e.getX(), e.getY()) ) {
			   ItemList.sortByPriceLowToHigh(WishList);
		   }
		   if ((e.getButton() == 1) && priceHighToLowOval.contains(e.getX(), e.getY()) ) {
			   ItemList.sortByPriceHighToLow(WishList);
		   }
		   if ((e.getButton() == 1) && nameOval.contains(e.getX(), e.getY()) ) {
			   ItemList.sortByName(WishList);
		   }
		   if ((e.getButton() == 1) && departmentOval.contains(e.getX(), e.getY()) ) {
			   ItemList.sortByDepartment(WishList);
		   }
		   for(int i =0; i<deleteBars.length; i++) {
			   if(e.getButton()==1 && deleteBars[i].contains(e.getX(), e.getY())) {
				   WishList.remove(i);
				   deleteBars[i]=null;
			   }
		   }
		   repaint();
		 }
	
	/*public boolean contains(int x, int y) 
	{
	    return priceOval.contains(x, y);
	}*/
	
	public void paintComponent(Graphics g) {
		 deleteBars = new RoundRectangle2D[WishList.size()];
		addBars = new RoundRectangle2D[WishList.size()];
		fillList(deleteBars);
		fillList(addBars);
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        this.addMouseListener(this);
        
        for(int i=0; i<WishList.size(); i++) {
        	g.setColor(Color.black);
        	//Full item border
            g2d.drawRoundRect(410, 50+i*150, 650, 125, 50, 30);
            //add and delete button border
            g2d.draw(deleteBars[i]);
            g2d.draw(addBars[i]);
            //add button color
            g.setColor(PURP);
            g2d.fillRoundRect(800, 70+i*150, 236, 29, 30, 10);
            //Words
            g.setColor(Color.BLACK);
            g2d.drawString("Add to Cart",880,90+i*150);
            g2d.drawString("Delete",880,130+i*150);
            
            //Item specific
            g2d.drawImage(WishList.get(i).getImg(),430,60+i*150,100,100,null);
            g2d.drawString(WishList.get(i).getName(), 550, 80+i*150);
            g2d.drawString("$"+WishList.get(i).getPrice(), 560, 130+i*150);
            //g.setColor(Color.LIGHT_GRAY);
            g2d.drawString("Price", 1200, 600);
            g2d.drawString("Name", 1200, 400);
            g2d.drawString("Department", 1200, 200);
            g2d.drawString(""+WishList.size(), 1500, 100);
            g.setColor(PURP);
            g2d.fill(priceHighToLowOval);
            g2d.fill(priceLowToHighOval);
            g2d.fill(nameOval);
            g2d.fill(departmentOval);
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
	
	public void fillList(RoundRectangle2D[] list) {
		for(int i=0; i<list.length; i++) {
			list[i] = new RoundRectangle2D.Double(800, 110+i*150, 236,29,30,10);
		}
	}
}







