package ui;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import models.*;
import utils.*;

class F1TeamSelection extends JFrame implements ActionListener 
{
    JComboBox<models.ComboBoxItem> combobox;

    public F1TeamSelection() {
        // Frame settings
        setTitle("Select your team!");
        setSize(600, 500);  // Adjusted size for better fit
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(20, 20, 20, 20);  // Padding around components
        gbc.anchor = GridBagConstraints.CENTER;

        // ComboBox items with images
        ComboBoxItem[] items = {
            new ComboBoxItem("Mercedes", new ImageIcon(Objects.requireNonNull(F1TeamSelection.class.getResource("/resources/mercedeslogo.jpeg")))),
            new ComboBoxItem("Ferrari", new ImageIcon(Objects.requireNonNull(F1TeamSelection.class.getResource("/resources/ferrarilogo.jpeg")))),
            new ComboBoxItem("Mclaren", new ImageIcon(Objects.requireNonNull(F1TeamSelection.class.getResource("/resources/mclaren logo.png")))),
            new ComboBoxItem("RedBull", new ImageIcon(Objects.requireNonNull(F1TeamSelection.class.getResource("/resources/redbull logo.jpeg"))))
        };

        // ComboBox setup
        combobox = new JComboBox<>(items);
        combobox.setFont(new Font("Arial", Font.PLAIN, 14));  // Adjusted font
        combobox.setPreferredSize(new Dimension(250, 50));    // Adjusted size
        combobox.setRenderer(new ComboBoxRenderer());

        // Adding ComboBox to the layout
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(combobox, gbc);

        // Button setup
        JButton getTeamButton = new JButton("Get Team!");
        getTeamButton.setFont(new Font("Sans-Serif", Font.BOLD, 14));  // Bold button text
        gbc.gridy = 1;  // Position below the ComboBox
        add(getTeamButton, gbc);

        // Button action listener
        getTeamButton.addActionListener(this);

        // Make frame visible
        setVisible(true);
    }

    public static ComboBoxItem extractedSelectedTeam(JComboBox<ComboBoxItem> combobox) {
        return (ComboBoxItem) combobox.getSelectedItem();
    }

    public void actionPerformed(ActionEvent e) 
    {
        ComboBoxItem selectedteam = extractedSelectedTeam(combobox);
        if (selectedteam != null) 
        {
            JOptionPane.showMessageDialog(null, "Team selected: " + selectedteam.getText(), "Confirmation", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
            new F1DriverSelection();
        } else 
        {
            JOptionPane.showMessageDialog(null, "Selection failed", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
