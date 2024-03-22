
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

//public class MainFrame extends JFrame {
//    private DefaultListModel<Item> listModel;
//    private JList<Item> itemList;
//    private JButton addToCartButton;
//    private JButton checkoutButton;
//    private JButton addItemButton;
//    private User user;
//    private List<Item> cart;
//
//    public MainFrame(User user) {
//        this.user = user;
//        setTitle("Main Frame");
//        setSize(400, 300);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        listModel = new DefaultListModel<>();
//        itemList = new JList<>(listModel);
//        addToCartButton = new JButton("Add to Cart");
//        checkoutButton = new JButton("Checkout");
//        addItemButton = new JButton("Add Item");
//        cart = new ArrayList<>();
//
//        addToCartButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                int selectedIndex = itemList.getSelectedIndex();
//                if (selectedIndex != -1) { // Check if an item is selected
//                    Item selectedItem = itemList.getModel().getElementAt(selectedIndex);
//                    cart.add(selectedItem); // Add the selected item to the cart list
//                    JOptionPane.showMessageDialog(null, "Item added to cart.");
//                } else {
//                    JOptionPane.showMessageDialog(null, "Please select an item to add to cart.");
//                }
//            }
//        });
//
//        checkoutButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                // Show cart window
//                showCart();
//            }
//        });
//
//        addItemButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                // Show AddItemForm
//                AddItemForm addItemForm = new AddItemForm();
//                addItemForm.setVisible(true);
//            }
//        });
//
//        setLayout(new BorderLayout());
//        JPanel buttonPanel = new JPanel(new FlowLayout());
//        buttonPanel.add(addToCartButton);
//        buttonPanel.add(checkoutButton);
//        buttonPanel.add(addItemButton);
//        add(buttonPanel, BorderLayout.NORTH);
//        add(new JScrollPane(itemList), BorderLayout.CENTER);
//
//        // Load items
//        loadItems();
//
//        // Customize list cell renderer
//        itemList.setCellRenderer(new ItemListCellRenderer());
//    }
//
//    private void loadItems() {
//        List<Item> items = ItemDatabase.loadItems();
//        for (Item item : items) {
//            listModel.addElement(item);
//        }
//    }
//
//    private void showCart() {
//        JFrame cartFrame = new JFrame("Cart");
//        cartFrame.setSize(300, 200);
//        JPanel cartPanel = new JPanel(new BorderLayout());
//        DefaultListModel<Item> cartListModel = new DefaultListModel<>(); // Create a list model for cart items
//        JList<Item> cartList = new JList<>(cartListModel); // Use the list model for the JList
//        for (Item item : cart) {
//            cartListModel.addElement(item); // Add item to the cart list model
//        }
//        cartList.setCellRenderer(new ItemListCellRenderer()); // Set custom list cell renderer
//        cartPanel.add(new JScrollPane(cartList), BorderLayout.CENTER);
//        cartFrame.add(cartPanel);
//        cartFrame.setVisible(true);
//    }
//
//
//    public void refreshItemList() {
//        listModel.clear();
//        loadItems();
//    }
//
//    // Custom list cell renderer for items
//    private class ItemListCellRenderer extends JLabel implements ListCellRenderer<Item> {
//        public ItemListCellRenderer() {
//            setOpaque(true);
//            setBorder(new EmptyBorder(5, 10, 5, 10));
//        }
//
//        @Override
//        public Component getListCellRendererComponent(JList<? extends Item> list, Item value, int index, boolean isSelected, boolean cellHasFocus) {
//            // Customize the display of each item
//            setText(value.getName() + " by " + value.getAuthor() + " - Price: $" + value.getPrice());
//            setBackground(isSelected ? list.getSelectionBackground() : list.getBackground());
//            setForeground(isSelected ? list.getSelectionForeground() : list.getForeground());
//            return this;
//        }
//    }
//
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                User student = new User("John Doe", "john@example.com", false, true, "password");
//                MainFrame mainFrame = new MainFrame(student);
//                mainFrame.setVisible(true);
//            }
//        });
//    }
//}

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class MainFrame extends JFrame {
    private DefaultListModel<Item> listModel;
    private JList<Item> itemList;
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
                int selectedIndex = itemList.getSelectedIndex();
                if (selectedIndex != -1) { // Check if an item is selected
                    Item selectedItem = itemList.getModel().getElementAt(selectedIndex);
                    cart.add(selectedItem); // Add the selected item to the cart list
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

        // Customize list cell renderer
        itemList.setCellRenderer(new ItemListCellRenderer());
    }

    private void loadItems() {
        List<Item> items = ItemDatabase.loadItems();
        for (Item item : items) {
            listModel.addElement(item);
        }
    }

//    private void showCart() {
//        JFrame cartFrame = new JFrame("Cart");
//        cartFrame.setSize(300, 200);
//        JPanel cartPanel = new JPanel(new BorderLayout());
//        DefaultListModel<String> cartListModel = new DefaultListModel<>(); // Create a list model for cart items
//        JList<String> cartList = new JList<>(cartListModel); // Use the list model for the JList
//        for (Item item : cart) {
//            // Customize the display of items with name, author, and price
//            String displayText = item.getName() + " by " + item.getAuthor() + " - Price: $" + item.getPrice();
//            cartListModel.addElement(displayText); // Add item to the cart list model
//        }
//        cartPanel.add(new JScrollPane(cartList), BorderLayout.CENTER);
//        cartFrame.add(cartPanel);
//        cartFrame.setVisible(true);
//    }
    private void showCart() {
        JFrame cartFrame = new JFrame("Cart");
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
                showBoughtItems(cartListModel, totalPrice);
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

//    private void showBoughtItems(DefaultListModel<Item> cartListModel, double totalPrice) {
//        JFrame boughtItemsFrame = new JFrame("Bought Items");
//        boughtItemsFrame.setSize(300, 250);
//        JPanel boughtItemsPanel = new JPanel(new BorderLayout());
//        JList<Item> boughtItemsList = new JList<>(cartListModel);
//        JLabel totalPriceLabel = new JLabel("Total Paid Price: $" + totalPrice);
//
//        boughtItemsPanel.add(new JScrollPane(boughtItemsList), BorderLayout.CENTER);
//        boughtItemsPanel.add(totalPriceLabel, BorderLayout.SOUTH);
//        boughtItemsFrame.add(boughtItemsPanel);
//        boughtItemsFrame.setVisible(true);
//    }
//
//
//    // Custom list cell renderer for items
//    private class ItemListCellRenderer extends JLabel implements ListCellRenderer<Item> {
//        public ItemListCellRenderer() {
//            setOpaque(true);
//            setBorder(new EmptyBorder(5, 10, 5, 10));
//        }
//
//        @Override
//        public Component getListCellRendererComponent(JList<? extends Item> list, Item value, int index, boolean isSelected, boolean cellHasFocus) {
//            // Customize the display of each item
//            setText(value.getName() + " by " + value.getAuthor() + " - Price: $" + value.getPrice());
//            setBackground(isSelected ? list.getSelectionBackground() : list.getBackground());
//            setForeground(isSelected ? list.getSelectionForeground() : list.getForeground());
//            return this;
//        }
//    }
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

