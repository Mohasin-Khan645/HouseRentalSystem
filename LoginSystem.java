import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginSystem {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Admin Login");
        ImageIcon logoIcon = new ImageIcon(""); 
        JLabel logoLabel = new JLabel(logoIcon);
        logoLabel.setBounds(100, 10, 200, 50); 

        JLabel userLabel = new JLabel("Username:");
        JLabel passLabel = new JLabel("Password:");
        JTextField userField = new JTextField();
        JPasswordField passField = new JPasswordField();
        JButton loginButton = new JButton("Login");

        userLabel.setBounds(50, 50, 100, 30);
        userField.setBounds(150, 50, 150, 30);
        passLabel.setBounds(50, 100, 100, 30);
        passField.setBounds(150, 100, 150, 30);
        loginButton.setBounds(150, 150, 80, 30);

        frame.add(userLabel);
        frame.add(userField);
        frame.add(passLabel);
        frame.add(passField);
        frame.add(loginButton);

        frame.setSize(400, 300);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userField.getText();
                String password = new String(passField.getPassword());

                if (username.equals("Mohasin") && password.equals("mohasin45")) {
                    JOptionPane.showMessageDialog(frame, "Login Successful!");
                    frame.dispose();
                    HouseRentSystem.main(new String[0]); 
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid credentials. Try again.");
                }
            }
        });
    }
}
    