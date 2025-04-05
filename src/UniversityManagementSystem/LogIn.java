package UniversityManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class LogIn extends JFrame implements ActionListener {

    JButton logIn, cancel;
    JTextField tfUsername;
    JPasswordField tfPassword;

    LogIn() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(40, 20, 100, 20);
        add(usernameLabel);

        tfUsername = new JTextField();
        tfUsername.setBounds(150, 20, 150, 20);
        add(tfUsername);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(40, 70, 100, 20);
        add(passwordLabel);

        tfPassword = new JPasswordField();
        tfPassword.setBounds(150, 70, 150, 20);
        add(tfPassword);

        logIn = new JButton("LOGIN");
        logIn.setBounds(40, 140, 120, 30);
        logIn.setBackground(Color.BLACK);
        logIn.setForeground(Color.WHITE);
        logIn.setFont(new Font("Tahoma", Font.BOLD, 15));
        logIn.addActionListener(this);
        add(logIn);

        cancel = new JButton("Cancel");
        cancel.setBounds(180, 140, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/Second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 0, 200, 200);
        add(image);

        setSize(600, 300);
        setLocation(500, 250);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == logIn) {
            String username = tfUsername.getText();
            String password = new String(tfPassword.getPassword());

            String query = "SELECT * FROM login WHERE username = ? AND password = ?";

            try {
                conn c = new conn();
                PreparedStatement ps = c.c.prepareStatement(query);
                ps.setString(1, username);
                ps.setString(2, password);

                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    setVisible(false);
                    new project();
                } else {
                    JOptionPane.showMessageDialog(null, "INVALID USERNAME OR PASSWORD");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == cancel) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new LogIn();
    }
}
