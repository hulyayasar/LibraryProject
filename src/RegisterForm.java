import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


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

//    private void registerUser() {
//        String name = txtName.getText();
//        String email = txtEmail.getText();
//        String password = txtPassword.getText();
//        boolean isFaculty = isFacultyCheckBox.isSelected();
//        boolean isStudent = isStudentCheckBox.isSelected();
//
//        // Create a User object with the given details
//        User user = new User(name, email, isFaculty, isStudent,password);
//
//        // Here you would typically call user.tryRegister(user) to perform the registration logic
//        // This is a placeholder to indicate where the registration logic would be invoked
//        System.out.println("Registering " + name);
//    }
    
    private void registerUser() {
        String name = txtName.getText();
        String email = txtEmail.getText();
        String password = txtPassword.getText();
        boolean isFaculty = isFacultyCheckBox.isSelected();
        boolean isStudent = isStudentCheckBox.isSelected();

        // Create a User object with the given details
        User user = new User(name, email, isFaculty, isStudent, password);

        // Save the user to the database
        UserDatabase.saveUser(user);
//        final String CSV_FILE = "users.csv";
//        try (PrintWriter writer = new PrintWriter(new FileWriter(CSV_FILE, true))) {
//            // Write header if file is empty
//            if (new File(CSV_FILE).length() == 0) {
//                writer.println("name,email,isFaculty,isStudent,password");
//            }
//
//            // Write user information
//            writer.println(user.getName() + "," + user.getEmail() + "," +
//                    user.isFaculty() + "," + user.isStudent() + "," + user.getPassword());
//        } catch (IOException e) {
//            e.printStackTrace();
//            System.err.println("Failed to save user to CSV file: " + e.getMessage());
//        }

     // Provide feedback to the user
        JOptionPane.showMessageDialog(this, "User registered successfully!");

        // Clear the input fields
        txtName.setText("");
        txtEmail.setText("");
        txtPassword.setText("");
        isFacultyCheckBox.setSelected(false);
        isStudentCheckBox.setSelected(false);
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