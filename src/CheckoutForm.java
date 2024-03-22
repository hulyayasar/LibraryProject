import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckoutForm extends JFrame {
    private JLabel userLabel;
    private JTextField userField;
    private JLabel paymentTypeLabel;
    private JComboBox<String> paymentTypeComboBox;
    private JLabel itemsLabel;
    private JTextField itemsField;
    private JLabel totalCostLabel;
    private JTextField totalCostField;
    private JButton checkoutButton;

    public CheckoutForm() {
        setTitle("Checkout");
        setSize(350, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);




        paymentTypeLabel = new JLabel("Payment Type:");
        paymentTypeComboBox = new JComboBox<>(new String[]{"Credit", "Debit", "Online Wallet"});
        itemsLabel = new JLabel("Items (ID list):");
        itemsField = new JTextField(20);
        totalCostLabel = new JLabel("Total Cost:");
        totalCostField = new JTextField(10);
        checkoutButton = new JButton("Checkout");


        checkoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                String paymentType = (String) paymentTypeComboBox.getSelectedItem();
                String items = itemsField.getText();
                double totalCost = Double.parseDouble(totalCostField.getText());


                dispose();
            }
        });


        JPanel panel = new JPanel(new GridLayout(5, 2));
        panel.add(userLabel);
        panel.add(userField);
        panel.add(paymentTypeLabel);
        panel.add(paymentTypeComboBox);
        panel.add(itemsLabel);
        panel.add(itemsField);
        panel.add(totalCostLabel);
        panel.add(totalCostField);
        panel.add(checkoutButton);
        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                CheckoutForm checkoutForm = new CheckoutForm();
                checkoutForm.setVisible(true);
            }
        });
    }
}
