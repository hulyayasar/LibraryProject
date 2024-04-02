import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


public class RegisterForm extends JFrame {
    private JTextField txtName, txtEmail, txtPassword;
    private JCheckBox isFacultyCheckBox, isStudentCheckBox, isStaffCheckBox,isMTCheckBox;
    private JButton btnRegister, btnCancel;

    public RegisterForm() {
    	
        setTitle("User Registration");
        setSize(550, 500);
      
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLayout(new GridLayout(9, 1,10,10));

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

        // Staff checkbox
        add(new JLabel("Staff:"));
        isStaffCheckBox = new JCheckBox();
        add(isStaffCheckBox);
        
        // MT checkbox
        add(new JLabel("Management Team:"));
        isMTCheckBox = new JCheckBox();
        add(isMTCheckBox);
        
        // Register button
        btnRegister = new JButton("Register");
        btnRegister.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                registerUser();
           //  loginForm lf = new loginForm();
                // Show the MainFrame
                dispose();
                User user = getUser(txtName.getText());
    
                txtName.setText("");
                txtEmail.setText("");
                txtPassword.setText("");
                MainFrame mainFrame = new MainFrame(user);
                mainFrame.setVisible(true);
               
                
            }
        });
        add(btnRegister);

        // Cancel button
        btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	loginForm lf = new loginForm();
                lf.setVisible(true);
                dispose();
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
        boolean isMT = isMTCheckBox.isSelected();
        boolean isStaff = isStaffCheckBox.isSelected();
        User user;
        if(isFaculty){
        	user = new Faculty(name,email,password);
        	   UserDatabase.saveUser(user,"F");
        }
        else if(isStudent){
        	user = new Student(name,email,password);
        	   UserDatabase.saveUser(user,"St");
        }
        else if(isMT){
        	user = new MTeam(name,email,password);
        	   UserDatabase.saveUser(user,"M");
        }
        else if(isStaff){
        	
        	user = new Staff(name,email,password);
     	   UserDatabase.saveUser(user,"S");
        }
     

        JOptionPane.showMessageDialog(this, "User registered successfully!");

   
//        txtName.setText("");
//        txtEmail.setText("");
//        txtPassword.setText("");
        isFacultyCheckBox.setSelected(false);
        isStudentCheckBox.setSelected(false);
        isStaffCheckBox.setSelected(false);
        isMTCheckBox.setSelected(false);
    }
    
    private User getUser(String name) {
        List<User> users = UserDatabase.loadUsers();
        for (User user : users) {
            if (user.getName().equals(name)) {
                return user;
            }
        }
        return null;
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