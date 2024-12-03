package ui;
import java.awt.*;
import java.awt.event.*;
import java.util.Objects;
import javax.swing.*;

// Driver selection UI class
class F1DriverSelection extends JFrame implements ActionListener 
{
    String selecteddrivers = "";
    JCheckBox checkbox1, checkbox2, checkbox3, checkbox4, checkbox5, checkbox6, checkbox7, checkbox8;

    public F1DriverSelection() {
        // Frame settings
        setTitle("Select your driver!");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());  // Using GridBagLayout for flexible layout
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);  // Padding between components
        gbc.anchor = GridBagConstraints.CENTER;  // Center components
        gbc.fill = GridBagConstraints.BOTH;
        
        // Define checkboxes with driver names and images
        checkbox1 = createCheckBox("Lewis Hamilton", Objects.requireNonNull(F1DriverSelection.class.getResource("/resources/lewishamilton.jpeg")).toString());
        checkbox2 = createCheckBox("Valtteri Bottas", Objects.requireNonNull(F1DriverSelection.class.getResource("/resources/valteribottas.jpeg")).toString());
        checkbox3 = createCheckBox("Charles Leclerc", Objects.requireNonNull(F1DriverSelection.class.getResource("/resources/charlesleclerc.jpeg")).toString());
        checkbox4 = createCheckBox("Carlos Sainz Jr.", Objects.requireNonNull(F1DriverSelection.class.getResource("/resources/carlossainz.jpeg")).toString());
        checkbox5 = createCheckBox("Lando Norris", Objects.requireNonNull(F1DriverSelection.class.getResource("/resources/landnorris.jpeg")).toString());
        checkbox6 = createCheckBox("Daniel Ricciardo", Objects.requireNonNull(F1DriverSelection.class.getResource("/resources/danielricciardo.jpeg")).toString());
        checkbox7 = createCheckBox("Max Verstappen", Objects.requireNonNull(F1DriverSelection.class.getResource("/resources/maxverstappen.jpeg")).toString());
        checkbox8 = createCheckBox("Sergio Perez", Objects.requireNonNull(F1DriverSelection.class.getResource("/resources/checoperez.jpeg")).toString());
        // Adding checkboxes to layout with positioning
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(checkbox1, gbc);
        
        gbc.gridx = 1;
        add(checkbox2, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(checkbox3, gbc);
        
        gbc.gridx = 1;
        add(checkbox4, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(checkbox5, gbc);
        
        gbc.gridx = 1;
        add(checkbox6, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(checkbox7, gbc);
        
        gbc.gridx = 1;
        add(checkbox8, gbc);
        
        // Submit button
        JButton submitdrivers = new JButton("Submit");
        submitdrivers.setFont(new Font("Arial", Font.BOLD, 14));  // Bold font for the button
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;  // Span across two columns
        gbc.anchor = GridBagConstraints.CENTER;
        add(submitdrivers, gbc);
        
        submitdrivers.addActionListener(this);
        
        // Final adjustments and frame visibility
        setVisible(true);
    }

    public String selecteddriversmethod() 
    {
        selecteddrivers = "";
        if (checkbox1.isSelected()) selecteddrivers +=checkbox1.getText()+",";
        if (checkbox2.isSelected()) selecteddrivers +=checkbox2.getText()+",";
        if (checkbox3.isSelected()) selecteddrivers +=checkbox3.getText()+",";
        if (checkbox4.isSelected()) selecteddrivers +=checkbox4.getText()+",";
        if (checkbox5.isSelected()) selecteddrivers +=checkbox5.getText()+",";
        if (checkbox6.isSelected()) selecteddrivers +=checkbox6.getText()+",";
        if (checkbox7.isSelected()) selecteddrivers +=checkbox7.getText()+",";
        if (checkbox8.isSelected()) selecteddrivers +=checkbox8.getText()+",";

        return selecteddrivers;
    }

    private JCheckBox createCheckBox(String driverName, String imagePath) {
        ImageIcon icon = new ImageIcon(new ImageIcon(imagePath).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
        JCheckBox checkbox = new JCheckBox(driverName, icon);
        checkbox.setHorizontalTextPosition(SwingConstants.RIGHT);  // Place the text to the right of the image
        return checkbox;
    }

    public void actionPerformed(ActionEvent e) 
    {
        selecteddrivers = selecteddriversmethod();
        if (!selecteddrivers.isEmpty()) 
        {
            String[] drivers = selecteddrivers.trim().split(",");
            JOptionPane.showMessageDialog(null, selecteddrivers, "Confirmation", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
            SwingUtilities.invokeLater(() -> new RaceEvents(drivers));
        } else 
        {
            JOptionPane.showMessageDialog(null, "No driver selected", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
