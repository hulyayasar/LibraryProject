import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

public class ObserverGUI extends JFrame {
    private SystemInterface systemInterface;
    private JButton btnRegister;
    private JButton btnViewDueItems;

    private void createAndShowGUI() {

        btnRegister = new JButton("Register");
        btnViewDueItems = new JButton("View Due Items");



        btnViewDueItems.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<String> dueItems = systemInterface.viewDueItems();

            }
        });



        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ObserverGUI();
            }
        });
    }
}

