package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import Controller.*;

public class LoginGUI extends JFrame implements ActionListener {
    private JLabel welcomeLabel;
    private JLabel usernameLabel, passwordLabel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private ArrayList<User> users;
    private JButton exitButton;
    Testdata start;

    public LoginGUI(Testdata start) {
        this.start = start;
        setTitle("Login GUI");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(false);

        welcomeLabel = new JLabel("Welcome To Cinemax Cinemas");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 30));
        welcomeLabel.setForeground(Color.BLUE);
        users = loadUsersFromCSV("Model\\users.csv"); // Load users from CSV file

        usernameLabel = new JLabel("Username:");
        passwordLabel = new JLabel("Password:");

        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);

        loginButton = new JButton("Login");
        loginButton.addActionListener(this);
        loginButton.setBackground(Color.BLACK);
        loginButton.setForeground(Color.WHITE);
        exitButton = new JButton("Exit");
        exitButton.addActionListener(this);
        exitButton.setBackground(Color.BLACK);
        exitButton.setForeground(Color.WHITE);

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(welcomeLabel, gbc);

        gbc.gridwidth = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        add(usernameLabel, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(usernameField, gbc);

        gbc.gridy = 2;
        gbc.gridx = 0;
        gbc.anchor = GridBagConstraints.LINE_END;
        add(passwordLabel, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(passwordField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        add(loginButton, gbc);

        gbc.gridx = 1;
        add(exitButton, gbc);
    }

    private ArrayList<User> loadUsersFromCSV(String filename) {
        ArrayList<User> userList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            boolean headerSkipped = false;
            while ((line = br.readLine()) != null) {
                if (!headerSkipped) {
                    headerSkipped = true;
                    continue; // Skip header line
                }

                String[] userData = line.split(",");
                String username = userData[0];
                String password = userData[1];
                String role = userData[2];

                if (role.equalsIgnoreCase("admin")) {
                    userList.add(new Admin(username, password));
                } else if (role.equalsIgnoreCase("user")) {
                    userList.add(new User(username, password));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return userList;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            for (User user : users) {
                if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                    // Successful login
                    dispose(); // Close the LoginGUI
                    MainGUI mainGUI = new MainGUI(user, start);
                    mainGUI.setVisible(true);
                    return;
                }
            }
            // Invalid login
            JOptionPane.showMessageDialog(this, "Invalid username or password. Please try again.");
        } else if (e.getSource() == exitButton) {
            System.exit(0);
        }
    }


}
