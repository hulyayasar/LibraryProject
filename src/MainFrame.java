

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class MainFrame extends JFrame {
    private DefaultListModel<Item> listModel,mylistModel,oListModel,sListModel;
    private JList<Item> itemList;
    private JList<Item> myList;
    private JButton addToCartButton;
    private JButton checkoutButton;
    private JButton addItemButton;
    private JButton subButton,refButton;
    JFrame cartFrame;
    private JButton overdueButton;
    private User user;
    private List<Item> cart, myitems,overList;
    Payment payment;

    public MainFrame(User user) {
    	
        this.user = user;
        if((this.user instanceof Visitor) == false){
        setTitle(user.getName()+ "'s "+"Library");
        setSize(700, 600);}
        else {setTitle("Library");
        setSize(600, 300);}
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        listModel = new DefaultListModel<>();
        mylistModel = new DefaultListModel<>();
        oListModel = new DefaultListModel<>();
        sListModel = new DefaultListModel<>();
        itemList = new JList<>(listModel);
        myList = new JList<>(mylistModel);
        
        
        refButton = new JButton("Refresh");
        subButton = new JButton("Subscriptions");
        overdueButton = new JButton("Overdue");
        
        
        addToCartButton = new JButton("Add to Cart");
        checkoutButton = new JButton("Checkout");
        if(user instanceof MTeam) {
        addItemButton = new JButton("Add Item");
        }
        cart = new ArrayList<>();
        User u = this.user;
        addToCartButton.addActionListener(new ActionListener() {
        	
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = itemList.getSelectedIndex();
                if (selectedIndex != -1) { // Check if an item is selected
                    Item selectedItem = itemList.getModel().getElementAt(selectedIndex);
                    
                    if((u instanceof Visitor) && ((selectedItem instanceof PhysicalItem)==false) ) {
                    	
                    	  JOptionPane.showMessageDialog(null, "You can't add that item");
                    }
                    else if(u instanceof Visitor && selectedItem instanceof PhysicalItem && (selectedItem.getPrice() - 0.001)< 0.01) 
                    {JOptionPane.showMessageDialog(null, "You can't add that item");}
                    else {
                    cart.add(selectedItem); // Add the selected item to the cart list
                    JOptionPane.showMessageDialog(null, "Item added to cart.");}
                    
                } else {
                    JOptionPane.showMessageDialog(null, "Please select an item to add to cart.");
                }
            }
        });
        subButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                showSubs();
            }
        });
        overdueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
         
                showOverdue();
            }
        });
        checkoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                showCart();
            }
        });
        if(addItemButton !=null && user instanceof MTeam ) {
        addItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Show AddItemForm
                AddItemForm addItemForm = new AddItemForm();
                addItemForm.setVisible(true);
            }
        });
        }
        
       User p = this.user;
        refButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	dispose();
        		MainFrame mainFrame = new MainFrame(p);
                mainFrame.setVisible(true);
            }
        });
        
        
        
        setLayout(new BorderLayout());
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(overdueButton);
        buttonPanel.add(subButton);
        buttonPanel.add(addToCartButton);
        buttonPanel.add(checkoutButton);
        buttonPanel.add(refButton);
        if(user instanceof MTeam) {
        buttonPanel.add(addItemButton);
        }
        add(buttonPanel, BorderLayout.BEFORE_FIRST_LINE);
  
    if((user instanceof Visitor) == false) {
    	  add(new JLabel(this.user.getName() +"'s items"),BorderLayout.BEFORE_LINE_BEGINS);
        add(new JScrollPane(myList),BorderLayout.CENTER);
    }
//  add(new JLabel("Library items"),BorderLayout.AFTER_LINE_ENDS);
        add(new JScrollPane(itemList), BorderLayout.PAGE_END);
        loadSubs();
      loadOverdueItems();

       
        if((user instanceof Visitor) == false) {
        	 loadMyItems();
        myList.setCellRenderer(new ItemListCellRenderer2());
        
        }
        loadItems();

        // Customize list cell renderer
    
        itemList.setCellRenderer(new ItemListCellRenderer());
    }
    
    private void loadSubs() {
        List<Item> items = ItemDatabase.loadMyItems(this.user.getID());
        for (Item item : items) {
        	
        	if(item instanceof MagazineNewspaper && item.getPrice()==0.0)
            sListModel.addElement(item);
        }
    }
    
    private void loadOverdueItems() {
        List<Item> items = ItemDatabase.loadMyItems(this.user.getID());
        for (Item item : items) {
        	
        	if(item instanceof PhysicalItem && item.getPrice()==0.0)
            oListModel.addElement(item);
        }
    }
    private void loadMyItems() {
        List<Item> items = ItemDatabase.loadMyItems(this.user.getID());
        for (Item item : items) {
            mylistModel.addElement(item);
        }
    }
    private void loadItems() {
        List<Item> items = ItemDatabase.loadItems();
        for (Item item : items) {
            listModel.addElement(item);
        }
    }

    private void showSubs() {
    	User person = this.user;
        JFrame  oFrame = new JFrame("Subscriptions List");
        oFrame.setSize(300, 250);
        JPanel oPanel = new JPanel(new BorderLayout());
      //  DefaultListModel<Item> oListModel = new DefaultListModel<>();
        JList<Item> sList = new JList<>(sListModel);

        JLabel Label = new JLabel("Items"); 
        JButton cancelButton = new JButton("Cancel Subscription");
        
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = sList.getSelectedIndex();
                if (selectedIndex != -1) { // Check if an item is selected
                    Item selectedItem = sList.getModel().getElementAt(selectedIndex);
                
                    ItemDatabase.remove(selectedItem,person);
                    sListModel.remove(selectedIndex);
                    
                    JOptionPane.showMessageDialog(null, "Item has been return");
                } else {
                    JOptionPane.showMessageDialog(null, "Please select an item to unsubscribe");
                }
            }
        });


        sList.setCellRenderer(new ItemListCellRenderer());
        oPanel.add(new JScrollPane(sList), BorderLayout.CENTER);
        oPanel.add(Label, BorderLayout.NORTH);
        oPanel.add(cancelButton, BorderLayout.SOUTH);
        oFrame.add(oPanel);
        oFrame.setVisible(true);
    }
    
    private void showOverdue() {
    	User person = this.user;
        JFrame  oFrame = new JFrame("Overdued Items");
        oFrame.setSize(300, 250);
        JPanel oPanel = new JPanel(new BorderLayout());
      //  DefaultListModel<Item> oListModel = new DefaultListModel<>();
        JList<Item> oList = new JList<>(oListModel);

        JLabel Label = new JLabel("Overdue List"); 
        JButton returnButton = new JButton("Return Item");
        
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = oList.getSelectedIndex();
                if (selectedIndex != -1) { // Check if an item is selected
                    Item selectedItem = oList.getModel().getElementAt(selectedIndex);
    
                    ItemDatabase.remove(selectedItem,person);
                    oListModel.remove(selectedIndex);
                    
                    JOptionPane.showMessageDialog(null, "Item has been return");
                } else {
                    JOptionPane.showMessageDialog(null, "Please select an item");
                }
            }
        });


        oList.setCellRenderer(new ItemListCellRenderer());
        oPanel.add(new JScrollPane(oList), BorderLayout.CENTER);
        oPanel.add(Label, BorderLayout.NORTH);
        oPanel.add(returnButton, BorderLayout.SOUTH);
        oFrame.add(oPanel);
        oFrame.setVisible(true);
    }

    private void showCart() {
        cartFrame = new JFrame("Cart");
        cartFrame.setSize(300, 250);
        JPanel cartPanel = new JPanel(new BorderLayout());
        DefaultListModel<Item> cartListModel = new DefaultListModel<>();
        JList<Item> cartList = new JList<>(cartListModel);
        double totalPrice = calculateTotalPrice(); // Calculate total price
        JLabel totalPriceLabel = new JLabel("Total Price: $" + totalPrice); // Display total price
        JButton confirmOrderButton = new JButton("Confirm Order");
        confirmOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Show bought items and paid price upon confirming the order
              // showBoughtItems(cartListModel, totalPrice);
            	selectPaymentMethod(cartListModel, totalPrice);
            }
        });

        for (Item item : cart) {
            cartListModel.addElement(item);
        }

        cartList.setCellRenderer(new ItemListCellRenderer());
        cartPanel.add(new JScrollPane(cartList), BorderLayout.CENTER);
        cartPanel.add(totalPriceLabel, BorderLayout.NORTH);
        cartPanel.add(confirmOrderButton, BorderLayout.SOUTH);
        cartFrame.add(cartPanel);
        cartFrame.setVisible(true);
    }

    private double calculateTotalPrice() {
        double totalPrice = 0.0;
        for (Item item : cart) {
            totalPrice += item.getPrice();
        }
        return totalPrice;
    }
    
    private void selectPaymentMethod(DefaultListModel<Item> cartListModel, double totalPrice) {
    	 JFrame payFrame = new JFrame("Payment Method");
         payFrame.setSize(300, 250);
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

         JButton cash = new JButton("Cash");
         cash.addActionListener(new ActionListener() {
            
             @Override
             public void actionPerformed(ActionEvent e) {
                 // Show bought items and paid price upon confirming the order
                // showBoughtItems(cartListModel, totalPrice);
            	 
             	cashSelected(cartListModel, totalPrice);
             	payFrame.dispose();
             }
         });

         JButton creditDebit = new JButton("Credit/Debit");
         creditDebit.addActionListener(new ActionListener() {
            

			@Override
             public void actionPerformed(ActionEvent e) {
                 // Show bought items and paid price upon confirming the order
                // showBoughtItems(cartListModel, totalPrice);
				
             	creditDebitSelected1(cartListModel, totalPrice);
             	payFrame.dispose();
             	
             }
         });
         setLayout(new BorderLayout());
         JPanel buttonPanel = new JPanel(new FlowLayout());
         buttonPanel.add(cash);
         buttonPanel.add(creditDebit);
         add(buttonPanel, BorderLayout.NORTH);
         payFrame.add(buttonPanel);
         payFrame.setVisible(true);
         

    }
    
    
    private boolean cashSelected(DefaultListModel<Item> cartListModel, double totalPrice) {
    	 JFrame boughtItemsFrame = new JFrame("Bought Items");
    	 setSize(400, 300);
         boughtItemsFrame.setSize(300, 250);
         JPanel boughtItemsPanel = new JPanel(new BorderLayout());
         JList<Item> boughtItemsList = new JList<>(cartListModel);
         payment = new Cash();
         JLabel totalPriceLabel = new JLabel(payment.pay(totalPrice));

         boughtItemsList.setCellRenderer(new ItemListCellRenderer()); // Set custom cell renderer
        boughtItemsPanel.add(new JScrollPane(boughtItemsList), BorderLayout.CENTER);
         boughtItemsPanel.add(totalPriceLabel, BorderLayout.SOUTH);
        boughtItemsFrame.add(boughtItemsPanel);
         boughtItemsFrame.setVisible(true);

 		for(Item i: cart) {
 	
 			ItemDatabase.addItem(i,this.user);
 			
 		}
 		cart.clear();
 		cartFrame.dispose();
		this.dispose();
 		MainFrame mainFrame = new MainFrame(this.user);
        mainFrame.setVisible(true);
         return true;
         
    }
    
    private boolean creditDebitSelected1(DefaultListModel<Item> cartListModel, double totalPrice) {
    	 JFrame boughtItemsFrame = new JFrame("Credit/Debit");
    	 setSize(400, 300);
         boughtItemsFrame.setSize(300, 250);
         JPanel boughtItemsPanel = new JPanel(new GridLayout(5,2));
         
          JButton btnConfirm;
         

         // Name field
         JLabel billname =new JLabel("Billing Name:");
         JTextField txtName = new JTextField();
         boughtItemsPanel.add(txtName);
         

         // cardNumber field
         JLabel cardNumb = new JLabel("Card Number:");
        JTextField txtCardNum = new JTextField();
         add(txtCardNum);

         // cvv field
          JLabel cvvs =new JLabel("CVV:");
          JTextField txtcvv = new JTextField();
         add(txtcvv);
         
         //DateOfExpiry
          JLabel DOE = new JLabel("Date Of Expiry(MM:YY):");
         JTextField txtDateOfExpiry = new JTextField();
         add(txtDateOfExpiry);
         
         
         String name = txtName.getText();
         String cardNum = txtCardNum.getText();
         String cvv = txtcvv.getText();
         String DateOfExpiry = txtDateOfExpiry.getText();
         
         btnConfirm = new JButton("Confirm Purchase");
         btnConfirm.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
            	 creditDebitSelected2(cartListModel, totalPrice,name,cardNum,cvv,DateOfExpiry);
             }
         });
         add(btnConfirm);
         boughtItemsPanel.add(billname, BorderLayout.WEST);
         boughtItemsPanel.add(txtName, BorderLayout.EAST);
         boughtItemsPanel.add(cardNumb, BorderLayout.WEST);
         boughtItemsPanel.add(txtCardNum, BorderLayout.EAST);
         boughtItemsPanel.add(cvvs, BorderLayout.WEST);
         boughtItemsPanel.add(txtcvv, BorderLayout.EAST);
         boughtItemsPanel.add(DOE, BorderLayout.WEST);
         boughtItemsPanel.add(txtDateOfExpiry, BorderLayout.EAST);
         boughtItemsPanel.add(btnConfirm, BorderLayout.EAST);
         boughtItemsFrame.add(boughtItemsPanel); 
         boughtItemsFrame.setVisible(true); 
     	
 		for(Item i: cart) {
 	
 			ItemDatabase.addItem(i,this.user);
 		}
 		cart.clear();
 		cartFrame.dispose();
 		this.dispose();
		MainFrame mainFrame = new MainFrame(this.user);
        mainFrame.setVisible(true);
         return true;
    }
    
    private boolean creditDebitSelected2(DefaultListModel<Item> cartListModel, double totalPrice,String name, String cardNum ,String cvv, String DateOfExpiry) {
   	 JFrame boughtItemsFrame = new JFrame("Bought Items");
   	 setSize(400, 300);
        boughtItemsFrame.setSize(300, 250);
        JPanel boughtItemsPanel = new JPanel(new BorderLayout());
        JList<Item> boughtItemsList = new JList<>(cartListModel);
        payment = new CreditDebit(name,cardNum,cvv,DateOfExpiry);
        JLabel totalPriceLabel = new JLabel(payment.pay(totalPrice));

        boughtItemsList.setCellRenderer(new ItemListCellRenderer()); // Set custom cell renderer
        boughtItemsPanel.add(new JScrollPane(boughtItemsList), BorderLayout.CENTER);
        boughtItemsPanel.add(totalPriceLabel, BorderLayout.SOUTH);
        boughtItemsFrame.add(boughtItemsPanel);
        boughtItemsFrame.setVisible(true);
        
        return true;
   }


    private void showBoughtItems(DefaultListModel<Item> cartListModel, double totalPrice) {
        JFrame boughtItemsFrame = new JFrame("Bought Items");
        boughtItemsFrame.setSize(300, 250);
        JPanel boughtItemsPanel = new JPanel(new BorderLayout());
        JList<Item> boughtItemsList = new JList<>(cartListModel);
        JLabel totalPriceLabel = new JLabel("Total Paid Price: $" + totalPrice);

        boughtItemsList.setCellRenderer(new ItemListCellRenderer()); // Set custom cell renderer
        boughtItemsPanel.add(new JScrollPane(boughtItemsList), BorderLayout.CENTER);
        boughtItemsPanel.add(totalPriceLabel, BorderLayout.SOUTH);
        boughtItemsFrame.add(boughtItemsPanel);
        boughtItemsFrame.setVisible(true);
        


	
     	
    }

    class ItemListCellRenderer extends JLabel implements ListCellRenderer<Item> {
        public ItemListCellRenderer() {
            setOpaque(true);
        }

        @Override
        public Component getListCellRendererComponent(JList<? extends Item> list, Item item, int index,
                                                      boolean isSelected, boolean cellHasFocus) {
            setText(item.getName() + " by " + item.getAuthor() + " - Price: $" + item.getPrice());
            setBackground(isSelected ? list.getSelectionBackground() : list.getBackground());
            setForeground(isSelected ? list.getSelectionForeground() : list.getForeground());
            return this;
        }
    }

    class ItemListCellRenderer2 extends JLabel implements ListCellRenderer<Item> {
        public ItemListCellRenderer2() {
            setOpaque(true);
        }

        @Override
        public Component getListCellRendererComponent(JList<? extends Item> list, Item item, int index,
                                                      boolean isSelected, boolean cellHasFocus) {
            setText(item.getName() + " by " + item.getAuthor());
            setBackground(isSelected ? list.getSelectionBackground() : list.getBackground());
            setForeground(isSelected ? list.getSelectionForeground() : list.getForeground());
            return this;
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                User student = new Student("John Doe", "john@example.com", "password");
                MainFrame mainFrame = new MainFrame(student);
                mainFrame.setVisible(true);
            }
        });
    }
}