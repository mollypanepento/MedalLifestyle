

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.imageio.*;

import javax.swing.*;

public class SearchPage extends JPanel implements ActionListener {
	public static ArrayList<Item> searchList;
	JPanel contentPane, itemPane, sortPane, bigPane, sortedItemPane;
	JLabel heart, sort, price, discount, color;
	JRadioButton highLow, lowHigh, sale, freeShip;
	JButton clear, enter; 
	ButtonGroup group, group1; 
	Color lavender = new Color(183,189,231);
	Header h; 
	

	//ItemList itemList = new ItemList(); 
	
	
	public SearchPage() {
		
		Header.frame = new JFrame("Clothes");
		Header.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Header.frame.setBackground(Color.white);
		Header.frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		Header.frame.setUndecorated(true);
		Header.frame.setTitle("Medal Lifestyle");
		
		//create sort pane
		sortPane = new JPanel();
		sortPane.setLayout(new BoxLayout(sortPane, BoxLayout.Y_AXIS));
		sortPane.setBackground(Color.white);
		bigPane = new JPanel();
		bigPane.setBackground(Color.white);
		//header panel
		GridBagConstraints c4 = new GridBagConstraints();
		JPanel head = new JPanel();
		head.setPreferredSize(new Dimension(1600,50));
		h = new Header();
		head = h.createHeader();
		c4.fill = GridBagConstraints.HORIZONTAL;
		c4.ipady = 20;
		c4.weightx = 0.5;
		c4.gridwidth = 6;
		c4.gridx = 0;
		c4.gridy = 0;
		bigPane.add(head, c4);
		
		
		//bigPane.add(new JLabel(searchList.get(0).getDepartment()),c4);
		bigPane.setLayout(new BoxLayout(bigPane, BoxLayout.Y_AXIS));
		sort = new JLabel("Sort: ");
		sortPane.add(sort);
		price = new JLabel("By price:");
		sortPane.add(price);
		highLow = new JRadioButton("Highest to Lowest");
		highLow.setBackground(Color.white);
		sortPane.add(highLow);
		lowHigh = new JRadioButton("Lowest to Highest");
		lowHigh.setBackground(Color.white);
		sortPane.add(lowHigh);
		group = new ButtonGroup();
		group.add(lowHigh);
		group.add(highLow);
		
		//content pane
		contentPane = new JPanel();
		discount = new JLabel("By discount: ");
		discount.setBackground(Color.white);
		sortPane.add(discount);
		sale = new JRadioButton("On Sale");
		sale.setBackground(Color.white);
		sortPane.add(sale);
		freeShip = new JRadioButton("Free shipping");
		freeShip.setBackground(Color.white);
		sortPane.add(freeShip);
		contentPane.add(sortPane);
		group1 = new ButtonGroup();
		group1.add(freeShip);
		group1.add(sale);
		
		enter = new JButton("Sort");
		enter.addActionListener(this);
		sortPane.add(enter);
		clear = new JButton("Clear");
		clear.addActionListener(this);
		sortPane.add(clear);
		
		//create items pane
		itemPane = new JPanel(new GridLayout(0, 3));
		itemPane.setBackground(Color.white);
		heart = new JLabel(new ImageIcon("heart.png"));
		
		for(Item i : searchList) {
			itemPane.add(i.showItem());
		}
		
		sortedItemPane = new JPanel(new GridLayout(0, 3));
		sortedItemPane.setBackground(Color.white);
		
		
		contentPane.add(itemPane);
		bigPane.add(contentPane);
		bigPane.setPreferredSize(new Dimension(1600, 10000));
		/*Scrollbar pane */
		JScrollPane scrollbar = new JScrollPane(contentPane,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollbar.setWheelScrollingEnabled(true);
        scrollbar.getVerticalScrollBar().setUnitIncrement(20);
        
        c4.fill = GridBagConstraints.HORIZONTAL;
		c4.ipady = 750;
		c4.weightx = 0.5;
		c4.gridwidth = 6;
		c4.gridx = 0;
		c4.gridy = 2;
        bigPane.add(scrollbar, c4);
        Header.frame.setContentPane(bigPane);
		 
		/* Size and then display the frame. */
        Header.frame.pack();
        Header.frame.setSize(1600, 900);
        Header.frame.setVisible(true);
	}
	

	public JPanel showStorePage() {
		return this.bigPane; 
	} 
	
	public String getSelectedButtonText(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                return button.getText();
            }
        }

        return null;
    }
	
	public void actionPerformed(ActionEvent event) {
		/*
		String eventName = event.getActionCommand();
		  if (eventName.equals("Clear")) {
			group.clearSelection();
			group1.clearSelection();
		}
		  else if(eventName.equals("Sort")) {
			  System.out.println(getSelectedButtonText(group));
			  if(getSelectedButtonText(group).equals("Highest to Lowest")) {
				  ItemList.sortByPriceHighToLow(searchList);
				  SearchPage d = new SearchPage();
				  
//				 ArrayList<Item1> listHigh = (ItemList.sortHighPrice(department));
//				 for(Item1 i : listHigh) {
//						sortedItemPane.add(i.showItem());
//					}
				 //SearchPage c = new SearchPage(list);
//				 System.out.println(frame.getContentPane().getName());
//				 frame.getContentPane().remove(itemPane);
//				 frame.getContentPane().add(sortedItemPane);
//				 frame.validate();
				 
			  }
			  else if(getSelectedButtonText(group).equals("Lowest to Highest")) {
				  ItemList.sortByPriceLowToHigh(searchList);
				  SearchPage d = new SearchPage();
//				  ArrayList<Item1> listLow = (ItemList.sortLowPrice(department));
//				  itemPane.removeAll(); 
//					 for(Item1 i : listLow) {
//							itemPane.add(i.showItem());
//							//System.out.println(department.size());
//						}
			  }
			 
			  System.out.println(getSelectedButtonText(group1));
		  }
		  
//		  for(Item1 i: ItemList.clothes) {
//			  if(eventName.equals(i.getName())) {
//				ItemPage1 show = new ItemPage1(i);
//				frame.getContentPane().removeAll(); 
//				frame.getContentPane().add(show.showItemPage()); 
//				  
//			  }
//		  }	  
 * 
 */
	}
	
	private static void runGUI() {
		 JFrame.setDefaultLookAndFeelDecorated(true);
//		 ItemList.printList(ItemList.clothes);
//		 System.out.println(ItemList.clothes.size());
		 SearchPage s = new SearchPage();
	 }
		 
	 public static void main(String[] args) {
	 /* Methods that create and show a GUI should be run from an event-dispatching thread */
		 javax.swing.SwingUtilities.invokeLater(new Runnable() {
		//ItemList i = new ItemList(); 
		 public void run() {
			runGUI();
		 }
		});
		 
	 }
}
