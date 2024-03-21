import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class RegisterForm extends JFrame {
    private JTextField txtName, txtEmail, txtPassword;
    private JCheckBox isFacultyCheckBox, isStudentCheckBox;
    private JButton btnRegister, btnCancel;

    public RegisterForm() {
        setTitle("User Registration");
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 2));

        // Name field
        add(new JLabel("Name:"));
        txtName = new JTextField();
        add(txtName);

        // Email field
        add(new JLabel("Email:"));
        txtEmail = new JTextField();
        add(txtEmail);

        // Password field
        add(new JLabel("Password:"));
        txtPassword = new JTextField();
        add(txtPassword);

        // Faculty checkbox
        add(new JLabel("Faculty:"));
        isFacultyCheckBox = new JCheckBox();
        add(isFacultyCheckBox);

        // Student checkbox
        add(new JLabel("Student:"));
        isStudentCheckBox = new JCheckBox();
        add(isStudentCheckBox);

        // Register button
        btnRegister = new JButton("Register");
        btnRegister.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                registerUser();
            }
        });
        add(btnRegister);

        // Cancel button
        btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the window
            }
        });
        add(btnCancel);
    }

    private void registerUser() {
        String name = txtName.getText();
        String email = txtEmail.getText();
        String password = txtPassword.getText();
        boolean isFaculty = isFacultyCheckBox.isSelected();
        boolean isStudent = isStudentCheckBox.isSelected();

        // Create a User object with the given details
        User user = new User(name, email, isFaculty, isStudent,password);

        // Here you would typically call user.tryRegister(user) to perform the registration logic
        // This is a placeholder to indicate where the registration logic would be invoked
        System.out.println("Registering " + name);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                RegisterForm form = new RegisterForm();
                form.setVisible(true);
            }
        });
    }
}