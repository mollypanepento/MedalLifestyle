package onlineStore;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JScrollPane; 
import javax.imageio.*;

import javax.swing.*;

public class Store1 extends JPanel implements ActionListener {
	public JFrame frame;
	JPanel contentPane, itemPane, sortPane, bigPane, sortedItemPane;
	JLabel heart, sort, price, discount, color;
	JRadioButton highLow, lowHigh, sale, freeShip;
	JButton clear, enter; 
	ButtonGroup group, group1; 
	Color lavender = new Color(183,189,231);
	Header h = new Header(); 
	ArrayList<Item1> department;
	ItemList itemList = new ItemList(); 
	
	public Store1(ArrayList<Item1> d) {
		department = d; 
		frame = new JFrame("Clothes");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBackground(Color.white);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frame.setUndecorated(true);
		frame.setTitle("Medal Lifestyle");
		
		//create sort pane
		sortPane = new JPanel();
		sortPane.setLayout(new BoxLayout(sortPane, BoxLayout.Y_AXIS));
		sortPane.setBackground(Color.white);
		bigPane = new JPanel();
		bigPane.setBackground(Color.white);
		String dept = " ";
		if(department.get(0).getDepartment().contentEquals("Clothes")) {
			dept = "Clothes";
		}else if(department.get(0).getDepartment().contentEquals("Electronics")) {
			dept = "Electronics";
		}else if(department.get(0).getDepartment().contentEquals("Fitness")) {
			dept = "Fitness";
		}else if(department.get(0).getDepartment().contentEquals("Furniture")) {
			dept = "Furniture";
		}else if(department.get(0).getDepartment().contentEquals("Jewelry")) {
			dept = "Jewelry";
		}else if(department.get(0).getDepartment().contentEquals("Kitchen")) {
			dept = "Kitchen";
		}else if(department.get(0).getDepartment().contentEquals("Skin Care")) {
			dept = "Skin Care";
		}else if(department.get(0).getDepartment().contentEquals("Stationary")) {
			dept = "Stationary";
		}
		
		//JPanel head = h.createHeader(itemList.getDept());
		h = new Header();
		head = h.createHeader(dept);
		head.setPreferredSize(new Dimension(1600,150));

		bigPane.add(head);

		bigPane.add(head);
		bigPane.add(new JLabel(department.get(0).getDepartment()));
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
		heart = new JLabel(new ImageIcon("src/heart.PNG"));
		
		for(Item1 i : department) {
			itemPane.add(i.showItem());
		}
		
		sortedItemPane = new JPanel(new GridLayout(0, 3));
		sortedItemPane.setBackground(Color.white);
		
		//create scrollbar
        JScrollPane scrollbar = new JScrollPane(contentPane,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollbar.setWheelScrollingEnabled(true);
        scrollbar.getVerticalScrollBar().setUnitIncrement(20);
		
		contentPane.add(itemPane);
		bigPane.add(scrollbar);
		//add content pane to frame
				Header.frame.setContentPane(bigPane);
						
				//Size and then display the frame
				Header.frame.pack();
				Header.frame.setVisible(true);
				Header.frame.setSize(1600,900);
	}
	

////	public JPanel showStorePage() {
////		return this.bigPane; 
////	} 
//	
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
		String eventName = event.getActionCommand();
		  if (eventName.equals("Clear")) {
			group.clearSelection();
			group1.clearSelection();
		}
		  else if(eventName.equals("Sort")) {
			  System.out.println(getSelectedButtonText(group));
			  if(getSelectedButtonText(group).equals("Highest to Lowest")) {
				  Store1 d = new Store1(ItemList.sortHighPrice(department));
				  
//				 ArrayList<Item1> listHigh = (ItemList.sortHighPrice(department));
//				 for(Item1 i : listHigh) {
//						sortedItemPane.add(i.showItem());
//					}
				 //Store1 c = new Store1(list);
//				 System.out.println(frame.getContentPane().getName());
//				 frame.getContentPane().remove(itemPane);
//				 frame.getContentPane().add(sortedItemPane);
//				 frame.validate();
				 
			  }
			  else if(getSelectedButtonText(group).equals("Lowest to Highest")) {
				  Store1 d2 = new Store1(ItemList.sortLowPrice(department));
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
	}
	
	private static void runGUI() {
		 JFrame.setDefaultLookAndFeelDecorated(true);
//		 ItemList.printList(ItemList.clothes);
//		 System.out.println(ItemList.clothes.size());
		 Store1 c = new Store1(ItemList.skincare);
		 
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
