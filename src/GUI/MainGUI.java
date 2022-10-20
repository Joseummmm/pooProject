package GUI;

import javax.swing.*;
import java.io.FileNotFoundException;

public class MainGUI {
    private JFrame frame;
    private JPanel panel;
    private JLabel usernameLabel;
    private JTextField userText;
    private  JLabel passwordLabel;
    private JPasswordField passwordText;
    private JButton loginButton;
    private JLabel successLabel;

    public MainGUI() throws FileNotFoundException {
        frame = new JFrame();
        panel = new JPanel();
        frame.setSize(420,144);
        frame.setTitle("Login POO");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(panel);

        panel.setLayout(null);

        usernameLabel = new JLabel("username");
        usernameLabel.setBounds(20,20, 80, 25);
        panel.add(usernameLabel);

        userText = new JTextField();
        userText.setBounds(100,20,165,25);
        panel.add(userText);

        passwordLabel = new JLabel("password");
        passwordLabel.setBounds(20,60, 80, 25);
        panel.add(passwordLabel);

        passwordText = new JPasswordField();
        passwordText.setBounds(100,60,165,25);
        panel.add(passwordText);

        successLabel = new JLabel("");
        successLabel.setBounds(200,20,80,25);
        panel.add(successLabel);

        loginButton = new JButton("login");
        loginButton.setBounds(300,40,80,25);
        loginButton.addActionListener(new BotonLogin(userText,passwordText, successLabel));
        panel.add(loginButton);


        frame.setVisible(true);
    }
}
