package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MainGUI implements ActionListener{
    private JFrame frame;
    private JPanel panel;
    private JLabel usernameLabel;
    private JTextField userText;
    private  JLabel passwordLabel;
    private JPasswordField passwordText;
    private JButton loginButton;
    private JLabel successLabel;
    private JButton signupButton;

    public MainGUI()  {
        frame = new JFrame();
        panel = new JPanel();
        frame.setSize(500,250);
        frame.setTitle("Login APP");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(panel);

        panel.setLayout(null);

        usernameLabel = new JLabel("Username");
        usernameLabel.setBounds(20,20, 80, 25);
        panel.add(usernameLabel);

        userText = new JTextField();
        userText.setBounds(20,40,165,25);
        panel.add(userText);

        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(20,80, 80, 25);
        panel.add(passwordLabel);

        passwordText = new JPasswordField();
        passwordText.setBounds(20,100,165,25);
        panel.add(passwordText);

        successLabel = new JLabel("");
        successLabel.setBounds(40,130,165,25);
        panel.add(successLabel);

        loginButton = new JButton("Login");
        loginButton.setBounds(50,150,100,25);
        loginButton.addActionListener(this);
        panel.add(loginButton);


        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        BotonLogin b = new BotonLogin(userText,passwordText,successLabel);
        if (b.check()) {
            new menuRepresentativo();
        }
        frame.setVisible(false);

    }
}
