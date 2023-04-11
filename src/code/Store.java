package onlineStore;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;

import javax.swing.*;

public class Store implements ActionListener{
	public JFrame frame;
	JPanel contentPane, itemPane, sortPane, bigPane;
	JLabel heart, sort, price, discount, color;
	JRadioButton highLow, lowHigh, sale, freeShip;
	JButton clear, enter; 
	ButtonGroup group, group1; 
	Color lavender = new Color(183,189,231);
	Item shirt, shirt2, shirt3, shirt4, shirt5, shirt6; 
	ArrayList<Item> clothes = new ArrayList<Item>(); 
	Header h = new Header(); 
	
	public Store() {
		frame = new JFrame("Clothes");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBackground(Color.white);
		
		//create sort pane
		sortPane = new JPanel();
		sortPane.setLayout(new BoxLayout(sortPane, BoxLayout.Y_AXIS));
		sortPane.setBackground(Color.white);
		bigPane = new JPanel();
		bigPane.setBackground(Color.white);
		bigPane.add(h.createHeader());
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
		itemPane = new JPanel(new GridLayout(2,3, 10, 10));
		itemPane.setBackground(Color.white);
		heart = new JLabel(new ImageIcon("src/heart.PNG"));
		shirt = new Item("src/cropTop.PNG", "Women's t-shirt", 20.00);
		shirt2 = new Item("src/cropTop.PNG", "Women's t-shirt", 20.00);
		shirt3 = new Item("src/cropTop.PNG", "Women's t-shirt", 20.00);
		shirt4 = new Item("src/cropTop.PNG", "Women's t-shirt", 20.00);
		shirt5 = new Item("src/cropTop.PNG", "Women's t-shirt", 20.00);
		clothes.add(shirt);
		clothes.add(shirt2);
		clothes.add(shirt3);
		clothes.add(shirt4);
		clothes.add(shirt5);

		itemPane.add(shirt.getItem());
		itemPane.add(shirt2.getItem());
		itemPane.add(shirt3.getItem());
		itemPane.add(shirt4.getItem());
		itemPane.add(shirt5.getItem());
		contentPane.add(itemPane);
		bigPane.add(contentPane);
		/* Add content pane to frame */
		frame.setContentPane(bigPane);
		 
		/* Size and then display the frame. */
		frame.pack();
		frame.setVisible(true);
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
		String eventName = event.getActionCommand();
		  if (eventName.equals("Clear")) {
			group.clearSelection();
			group1.clearSelection();
		}
		  else if(eventName.equals("Sort")) {
			  System.out.println(getSelectedButtonText(group));
			  System.out.println(getSelectedButtonText(group1));
		  }
		  for(Item i: clothes) {
			  if(eventName.equals(i.getName())) {
				ItemPage show = new ItemPage(i);
				frame.getContentPane().removeAll(); 
				frame.getContentPane().add(show.showItemPage()); 
				  
			  }
		  }	  
	}
	
	private static void runGUI() {
		 JFrame.setDefaultLookAndFeelDecorated(true);
		 Store c = new Store();
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
