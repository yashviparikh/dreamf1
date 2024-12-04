package ui;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import models.*;

// User details UI class
public class UserDetailsUI extends JFrame implements ActionListener 
{
    JTextField name, age, email;
    JLabel lname, lage, lemail;
    JButton submit;
public UserDetailsUI() 
{
    setTitle("Login!");
    setSize(500, 500);
    setLayout(new GridBagLayout());
    setLocationRelativeTo(null); 
    GridBagConstraints gbc = new GridBagConstraints();
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    getContentPane().setBackground(new Color(240, 240, 240));

    lname = new JLabel("Username: ");
    lname.setFont(new Font("Calibri", Font.BOLD, 18));
    lage = new JLabel("Age: ");
    lage.setFont(new Font("Calibri", Font.BOLD, 18));
    lemail = new JLabel("Email: ");
    lemail.setFont(new Font("Calibri", Font.BOLD, 18));

    name = new JTextField(20);
    name.setFont(new Font("Calibri", Font.PLAIN, 14));
    age = new JTextField(2);
    age.setFont(new Font("Calibri", Font.PLAIN, 14));
    email = new JTextField(25);
    email.setFont(new Font("Calibri", Font.PLAIN, 14));

    submit = new JButton("Submit");
    submit.setFont(new Font("Arial", Font.BOLD, 24));
        submit.setBackground(new Color(0, 153, 0));  // Green button
        submit.setForeground(Color.WHITE);
    submit.addActionListener(this);

    // Common settings for all labels and text fields
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.insets = new Insets(10, 10, 10, 10);  // Padding around components
    gbc.weightx = 0.5;

    // UserName Label
    gbc.gridx = 0;
    gbc.gridy = 0;
    add(lname, gbc);

    // UserName TextField
    gbc.gridx = 1;
    add(name, gbc);

    // Age Label
    gbc.gridx = 0;
    gbc.gridy = 1;
    add(lage, gbc);

    // Age TextField
    gbc.gridx = 1;
    add(age, gbc);

    // Email Label
    gbc.gridx = 0;
    gbc.gridy = 2;
    add(lemail, gbc);

    // Email TextField
    gbc.gridx = 1;
    add(email, gbc);

    // Submit Button (Now correctly placed below the text fields)
    gbc.gridx = 0;
    gbc.gridy = 3;
    gbc.gridwidth = 2;  // Button spans across two columns
    gbc.anchor = GridBagConstraints.CENTER;  // Center the button
    gbc.fill = GridBagConstraints.NONE;      // Let the button have its default size
    gbc.weighty = 1.0;  // Push the button down by adding weight
    add(submit, gbc);

    setVisible(true);
}

    public void actionPerformed(ActionEvent e) 
    {
        try {
            String uname = name.getText();
            int uage = Integer.parseInt(age.getText());
            String uemail = email.getText();

            UserDetails user = new UserDetails(uname, uage, uemail);

            JOptionPane.showMessageDialog(null, "Login registered for " + user.getUsername(), "Confirmation", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
            new F1TeamSelection();
        } 
        catch (NumberFormatException ne) 
        {
            JOptionPane.showMessageDialog(null, "Login failed", "Login failed", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
