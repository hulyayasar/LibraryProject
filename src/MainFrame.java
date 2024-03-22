//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.util.List;
//
//public class MainFrame extends JFrame {
//    private JButton addButton;
//    private JButton loadButton;
//    private DefaultListModel<Item> listModel;
//    private JList<Item> itemList;
//
//    public MainFrame() {
//        setTitle("Item Management");
//        setSize(400, 300);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        
//        addButton = new JButton("Add Item");
//        loadButton = new JButton("Load Items");
//        listModel = new DefaultListModel<>();
//        itemList = new JList<>(listModel);
//
//        
//        addButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                
//                AddItemForm addItemForm = new AddItemForm();
//                addItemForm.setVisible(true);
//            }
//        });
//
//        loadButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//               
//                List<Item> items = ItemDatabase.loadItems();
//               
//                listModel.clear();
//               
//                for (Item item : items) {
//                    listModel.addElement(item);
//                }
//            }
//        });
//
//        
//        setLayout(new BorderLayout());
//        JPanel buttonPanel = new JPanel(new FlowLayout());
//        buttonPanel.add(addButton);
//        buttonPanel.add(loadButton);
//        add(buttonPanel, BorderLayout.NORTH);
//        add(new JScrollPane(itemList), BorderLayout.CENTER);
//    }
//
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                MainFrame mainFrame = new MainFrame();
//                mainFrame.setVisible(true);
//            }
//        });
//    }
//}
//
//class AddItemForm extends JFrame {
//    private JTextField nameField;
//    private JTextField locationField;
//    private JButton addButton;
//
//    public AddItemForm() {
//        setTitle("Add Item");
//        setSize(300, 150);
//
//        
//        nameField = new JTextField(20);
//        locationField = new JTextField(20);
//        addButton = new JButton("Add");
//
//        
//        addButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                
//                String name = nameField.getText();
//                String location = locationField.getText();
//                PhysicalItem item = new PhysicalItem(name, location);
//               
//                ItemDatabase.saveItem(item);
//               
//                dispose();
//            }
//        });
//
//        
//        setLayout(new GridLayout(3, 2));
//        add(new JLabel("Name:"));
//        add(nameField);
//        add(new JLabel("Location:"));
//        add(locationField);
//        add(new JLabel());
//        add(addButton);
//    }
//}

//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.util.List;
//
//public class MainFrame extends JFrame {
//    private DefaultListModel<Item> listModel;
//    private JList<Item> itemList;
//    private JButton addButton;
//    private User user;
//
//    public MainFrame(User user) {
//        this.user = user;
//        setTitle("Main Frame");
//        setSize(400, 300);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        // Initialize components
//        listModel = new DefaultListModel<>();
//        itemList = new JList<>(listModel);
//        addButton = new JButton("Add Item");
//
//        // Add action listener to the "Add Item" button
//        addButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                // If user is a manager, show AddItemForm
//                if (user != null && user.isManager()) {
//                    AddItemForm addItemForm = new AddItemForm();
//                    addItemForm.setVisible(true);
//                } else {
//                    JOptionPane.showMessageDialog(null, "You don't have permission to add items.");
//                }
//            }
//        });
//
//        // Add components to the frame
//        setLayout(new BorderLayout());
//        JPanel buttonPanel = new JPanel(new FlowLayout());
//        buttonPanel.add(addButton);
//        add(buttonPanel, BorderLayout.NORTH);
//        add(new JScrollPane(itemList), BorderLayout.CENTER);
//
//        // Load items
//        loadItems();
//    }
//
//    private void loadItems() {
//        List<Item> items = ItemDatabase.loadItems();
//        for (Item item : items) {
//            listModel.addElement(item);
//        }
//    }
//
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                MainFrame mainFrame = new MainFrame(null);
//                mainFrame.setVisible(true);
//            }
//        });
//    }
//}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class MainFrame extends JFrame {
    private DefaultListModel<String> listModel; // Modified to String for customized display
    private JList<String> itemList; // Modified to String for customized display
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

        // Initialize components
        listModel = new DefaultListModel<>();
        itemList = new JList<>(listModel);
        addToCartButton = new JButton("Add to Cart");
        checkoutButton = new JButton("Checkout");
        addItemButton = new JButton("Add Item");
        cart = new ArrayList<>();

        // Add action listener to the "Add to Cart" button
        addToCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add selected item to cart
                Item selectedItem = cart.get(itemList.getSelectedIndex());
                if (selectedItem != null) {
                    cart.add(selectedItem);
                    JOptionPane.showMessageDialog(null, "Item added to cart.");
                } else {
                    JOptionPane.showMessageDialog(null, "Please select an item to add to cart.");
                }
            }
        });

        // Add action listener to the "Checkout" button
        checkoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Show cart window
                showCart();
            }
        });

        // Add action listener to the "Add Item" button
        addItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Show AddItemForm
                AddItemForm addItemForm = new AddItemForm();
                addItemForm.setVisible(true);
            }
        });

        // Add components to the frame
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
            // Customize the display of items with name, author, and price
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
                // Assuming the user is a student
                User student = new User("John Doe", "john@example.com", false, true, "password");
                MainFrame mainFrame = new MainFrame(student);
                mainFrame.setVisible(true);
            }
        });
    }
}
