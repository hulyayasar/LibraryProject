

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class MainFrame extends JFrame {
    private DefaultListModel<String> listModel; 
    private JList<String> itemList; 
    private JButton addToCartButton;
    private JButton checkoutButton;
    private JButton addItemButton;
    private User user;
    private List<Item> cart;

    public MainFrame(User user) {
        this.user = user;
        setTitle("Main Frame");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

       
        listModel = new DefaultListModel<>();
        itemList = new JList<>(listModel);
        addToCartButton = new JButton("Add to Cart");
        checkoutButton = new JButton("Checkout");
        addItemButton = new JButton("Add Item");
        cart = new ArrayList<>();

      
        addToCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
                Item selectedItem = cart.get(itemList.getSelectedIndex());
                if (selectedItem != null) {
                    cart.add(selectedItem);
                    JOptionPane.showMessageDialog(null, "Item added to cart.");
                } else {
                    JOptionPane.showMessageDialog(null, "Please select an item to add to cart.");
                }
            }
        });

       
        checkoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Show cart window
                showCart();
            }
        });

       
        addItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Show AddItemForm
                AddItemForm addItemForm = new AddItemForm();
                addItemForm.setVisible(true);
            }
        });


        setLayout(new BorderLayout());
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(addToCartButton);
        buttonPanel.add(checkoutButton);
        buttonPanel.add(addItemButton);
        add(buttonPanel, BorderLayout.NORTH);
        add(new JScrollPane(itemList), BorderLayout.CENTER);

        // Load items
        loadItems();
    }

    private void loadItems() {
        List<Item> items = ItemDatabase.loadItems();
        for (Item item : items) {
          
            String displayText = item.getName() + " by " + item.getAuthor() + " - Price: $" + item.getPrice();
            listModel.addElement(displayText);
        }
    }

    private void showCart() {
        JFrame cartFrame = new JFrame("Cart");
        cartFrame.setSize(300, 200);
        JPanel cartPanel = new JPanel(new BorderLayout());
        JList<Item> cartList = new JList<>();
        DefaultListModel<Item> cartListModel = new DefaultListModel<>();
        for (Item item : cart) {
            cartListModel.addElement(item);
        }
        cartList.setModel(cartListModel);
        cartPanel.add(new JScrollPane(cartList), BorderLayout.CENTER);
        cartFrame.add(cartPanel);
        cartFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
              
                User student = new User("John Doe", "john@example.com", false, true, "password");
                MainFrame mainFrame = new MainFrame(student);
                mainFrame.setVisible(true);
            }
        });
    }
}
