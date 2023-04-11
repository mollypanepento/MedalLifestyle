package onlineStore;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
 
public class StoreCard extends JFrame{
	private int currentCard = 1;
	JPanel contentPane, sortPane, bigPane;
	JLabel heart, sort, price, discount, color;
	JRadioButton highLow, lowHigh, sale, freeShip;
	JButton clear, itemButton; 
	ButtonGroup group, group1; 
	Color lavender = new Color(183,189,231);
	Item shirt, shirt2, shirt3, shirt4, shirt5, shirt6; 
	ArrayList<Item> clothes = new ArrayList<Item>(); 
	 
    // Declaration of objects
    // of CardLayout class.
    public CardLayout cl;
    public StoreCard()
    {
 
        // Function to set visibility of JFrame
        setTitle("Card Layout Example");
 
        // Creating Object of "Jpanel" class
        JPanel cardPanel = new JPanel();
 
        // Initialization of object "c1"
        // of CardLayout class.
        cl = new CardLayout();
 
        // set the layout
        cardPanel.setLayout(cl);
 
        // Initialization of object
        // "jp1" of JPanel class.
        Store s = new Store(); 
        JPanel sPanel = s.showStorePage();
 
        // Initialization of object
        // "jp2" of CardLayout class.
        Item shirt = new Item("src/cropTop.PNG", "Women's t-shirt", 20.00);
        ItemPage show = new ItemPage(shirt);
        JPanel jp2 = show.showItemPage();
 
 
        // labels 
        JLabel jl1 = new JLabel("Card1");
        JLabel jl2 = new JLabel("Card2");
 
        // Adding the cardPanel on "jp1"
        cardPanel.add(sPanel, "1");
 
        // Adding the cardPanel on "jp2"
        cardPanel.add(jp2, "2");
 
 
        // Creating Object of "JPanel" class
        JPanel buttonPanel = new JPanel();
 
        JButton firstBtn = new JButton("First");
        JButton nextBtn = new JButton("Next");
        JButton previousBtn = new JButton("Previous");
        JButton lastBtn = new JButton("Last");
 
        // Adding JButton "firstbtn" on JFrame.
        buttonPanel.add(firstBtn);
        buttonPanel.add(nextBtn);
        buttonPanel.add(previousBtn);
        buttonPanel.add(lastBtn);
 
        // add firstbtn in ActionListener
        
        JButton itemButton = shirt.getItemButton(); 
        
        itemButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0)
            {
                // used first c1 CardLayout
                cl.show(shirt.getItem(), "yaya");
            }
        });
        firstBtn.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent arg0)
            {
                 
                // used first c1 CardLayout
                cl.first(cardPanel);
 
                // value of currentcard is 1
                currentCard = 1;
            }
        });
 
        // add lastbtn in ActionListener
        lastBtn.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent arg0)
            {
 
                // used last c1 CardLayout
                cl.last(cardPanel);
 
                // value of currentcard is 4
                currentCard = 4;
            }
        });
 
        // add nextbtn in ActionListener
        nextBtn.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent arg0)
            {
                // if condition apply
                if (currentCard < 4)
                {        
                    // increment the value of currentcard by 1
                    currentCard += 1;
 
                    // show the value of currentcard
                    cl.show(cardPanel, "" + (currentCard));
                }
            }
        });
 
        // add previousbtn in ActionListener
        previousBtn.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent arg0)
            {
                // if condition apply
                if (currentCard > 1) {
 
                    // decrement the value
                    // of currentcard by 1
                    currentCard -= 1;
 
                    // show the value of currentcard
                    cl.show(cardPanel, "" + (currentCard));
                }
            }
        });
 
        // used to get content pane
        getContentPane().add(cardPanel, BorderLayout.NORTH);
 
        // used to get content pane
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);
    }
 
    // Main Method
    public static void main(String[] args)
    {
 
        // Creating Object of CardLayoutDemo class.
        StoreCard cl = new StoreCard();
 
        // Function to set default operation of JFrame.
        cl.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        // Function to set visibility of JFrame.
        cl.setVisible(true);
    }
}
