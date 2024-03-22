import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddItemForm extends JFrame {
    private JLabel nameLabel;
    private JTextField nameField;
    private JLabel idLabel;
    private JTextField idField;
    private JLabel authorLabel;
    private JTextField authorField;
    private JLabel priceLabel;
    private JTextField priceField;
    private JCheckBox disabledCheckBox;
    private JCheckBox buyableCheckBox;
    private JButton addButton;

    public AddItemForm() {
        setTitle("Add Item");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Initialize components
        nameLabel = new JLabel("Name:");
        nameField = new JTextField(20);
        idLabel = new JLabel("Item ID:");
        idField = new JTextField(10);
        authorLabel = new JLabel("Author:");
        authorField = new JTextField(20);
        priceLabel = new JLabel("Price:");
        priceField = new JTextField(10);
        disabledCheckBox = new JCheckBox("Disabled");
        buyableCheckBox = new JCheckBox("Buyable");
        addButton = new JButton("Add");

        // Add action listener to the "Add" button
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get values from the form
                String name = nameField.getText();
                int itemID = Integer.parseInt(idField.getText());
                String author = authorField.getText();
                double price = Double.parseDouble(priceField.getText());
                boolean isDisabled = disabledCheckBox.isSelected();
                boolean isBuyable = buyableCheckBox.isSelected();

                // Create the appropriate item based on user input
                Item newItem = new PhysicalItem(name, itemID, author, price, isDisabled, isBuyable);

                // Save the item to the database
                ItemDatabase.saveItem(newItem);

                // Close the form
                dispose();
            }
        });

        // Add components to the frame
        JPanel panel = new JPanel(new GridLayout(6, 2));
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(idLabel);
        panel.add(idField);
        panel.add(authorLabel);
        panel.add(authorField);
        panel.add(priceLabel);
        panel.add(priceField);
        panel.add(disabledCheckBox);
        panel.add(buyableCheckBox);
        panel.add(addButton);
        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                AddItemForm addItemForm = new AddItemForm();
                addItemForm.setVisible(true);
            }
        });
    }
}
