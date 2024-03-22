import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class loginForm extends JFrame {
	 private JTextField txtName, txtEmail, txtPassword;
	 private JButton btnRegister, btnLogIn;
	 private RegisterForm reg;
	
	public loginForm() {
		  setTitle("Login");
		  setSize(450, 200);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setLayout(new GridLayout(4, 2));
	        
	        // Name field
	        add(new JLabel("Name:"));
	        txtName = new JTextField();
	        add(txtName);
	        
	        // Password field
	        add(new JLabel("Password:"));
	        txtPassword = new JTextField();
	        add(txtPassword);
	        
	        
	        
	        // Register button
	        btnRegister = new JButton("Register");
	        btnRegister.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                reg = new RegisterForm();
	                reg.setVisible(true);
	            }
	        });
	        add(btnRegister);
	        
	        btnLogIn = new JButton("Login");
	        btnLogIn.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                // Authenticate the user
	                if (authenticateUser(txtName.getText(), txtPassword.getText())) {
	                    // Close the LoginForm window
	                    dispose();
	                    // Show the MainFrame
	                    User user = getUser(txtName.getText());
	                    MainFrame mainFrame = new MainFrame(user);
	                    mainFrame.setVisible(true);
	                } else {
	                    JOptionPane.showMessageDialog(null, "Invalid credentials. Please try again.");
	                }
	            }
	        });
	        add(btnLogIn);
	        
	        
	        

	}
	
	private boolean authenticateUser(String name, String password) {
        List<User> users = UserDatabase.loadUsers();
        for (User user : users) {
            if (user.getName().equals(name) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
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
	                loginForm form = new loginForm();
	                form.setVisible(true);
	            }
	        });
	    }

} 
