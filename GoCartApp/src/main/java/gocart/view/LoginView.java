package src.main.java.gocart.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import src.main.java.gocart.controller.LoginController;
import src.main.java.gocart.model.User;

public class LoginView extends JFrame{
    private LoginController loginController;

    // UI Components
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JLabel statusLabel;

    public LoginView(LoginController controller) {
        this.loginController = controller;
        initializeUI();
    }

    private void initializeUI() {
        setTitle("GoCart Login");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 2, 10, 10));

        // Username
        add(new JLabel("Username:"));
        usernameField = new JTextField();
        add(usernameField);

        // Password
        add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        add(passwordField);

        // Login Button
        loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performLogin();
            }
        });
        add(loginButton);

        // Status Label
        statusLabel = new JLabel();
        add(statusLabel);

        // Display the window
        setLocationRelativeTo(null);  // Center the window
        setVisible(true);
    }

    private void performLogin() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        User user = loginController.login(username, password);
        if (user != null) {
            statusLabel.setText("Login successful");
            // Proceed based on user role
            // For example, open CustomerView or SellerView based on user.getRole()
        } else {
            statusLabel.setText("Login failed");
        }
    }

}
