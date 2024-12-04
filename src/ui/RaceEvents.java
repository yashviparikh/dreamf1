package ui;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


class RaceEvents extends JFrame {
    JPanel cardPanel;
    CardLayout cardLayout;
    String[] drivers;

    public RaceEvents(String[] drivers) {
        this.drivers = drivers;
        setTitle("Race Events");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);  // Center the window

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        createRaceEventCards();

        add(cardPanel);
        setVisible(true);
    }

    public void createRaceEventCards() {
        // Card 1 - Lights Out
        JPanel lightsOutPanel = createEventPanel("Lights Out! The race has started.", Color.RED, "Next");

        // Card 2 - Overtaking
        JPanel overtakingPanel = createEventPanel("Overtaking! Verstappen overtakes Lando Norris.", Color.BLUE, "Next", "Back");

        // Card 3 - DRS
        JPanel drsPanel = createEventPanel("DRS Activated! Daniel Ricciardo is closing the gap on Carlos Sainz.", Color.RED, "Next", "Back");

        // Card 4 - Crash
        JPanel crashPanel = createEventPanel("Crash! Red flag, safety car on the track.", Color.PINK, "Next", "Back");

        // Card 5 - Safety Car
        JPanel safetyCarPanel = createEventPanel("Safety Car deployed! The field bunches up.", Color.ORANGE, "Next", "Back");

        // Card 6 - Pit Stop for Driver A
        JPanel pitStopPanelA = createEventPanel("Pit Stop! Lewis Hamilton switches to soft tires.", Color.RED, "Next", "Back");

        // Card 7 - Pit Stop for Driver B (Last card, no Show Points button)
        JPanel pitStopPanelB = createEventPanel("Pit Stop! Charles Leclerc switches to hard tires.", Color.BLUE, "Next", "Back");

        // Add cards to the card panel
        cardPanel.add(lightsOutPanel, "LightsOut");
        cardPanel.add(overtakingPanel, "Overtaking");
        cardPanel.add(drsPanel, "DRS");
        cardPanel.add(crashPanel, "Crash");
        cardPanel.add(safetyCarPanel, "SafetyCar");
        cardPanel.add(pitStopPanelA, "PitStopA");
        cardPanel.add(pitStopPanelB, "PitStopB");

        // Action listeners to navigate between cards
        setupNavigation(lightsOutPanel, overtakingPanel, drsPanel, crashPanel, safetyCarPanel, pitStopPanelA, pitStopPanelB);
    }

    private JPanel createEventPanel(String labelText, Color bgColor, String nextButtonText, String... additionalButtonTexts) {
        JPanel panel = new JPanel();
        panel.setBackground(bgColor);
        panel.setLayout(new BorderLayout(10, 10)); // Padding between components

        JLabel label = new JLabel(labelText, JLabel.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 16)); // Improved font
        label.setForeground(Color.WHITE); // Text color
        panel.add(label, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10)); // Centered buttons with padding
        JButton nextButton = new JButton(nextButtonText);
        styleButton(nextButton);
        buttonPanel.add(nextButton);

        for (String btnText : additionalButtonTexts) {
            JButton button = new JButton(btnText);
            styleButton(button);
            buttonPanel.add(button);
        }

        panel.add(buttonPanel, BorderLayout.SOUTH);
        return panel;
    }

    private void styleButton(JButton button) {
        button.setPreferredSize(new Dimension(120, 30)); // Set a preferred size for buttons
        button.setBackground(Color.BLACK); // Background color
        button.setForeground(Color.WHITE); // Text color
        button.setFocusPainted(false); // Remove focus border
        button.setBorder(BorderFactory.createRaisedBevelBorder()); // Raised effect
    }

    private void setupNavigation(JPanel... panels) {
        JButton nextButton1 = getNextButton(panels[0]);
        JButton nextButton2 = getNextButton(panels[1]);
        JButton backButton2 = getBackButton(panels[1]);
        JButton nextButton3 = getNextButton(panels[2]);
        JButton backButton3 = getBackButton(panels[2]);
        JButton nextButton4 = getNextButton(panels[3]);
        JButton backButton4 = getBackButton(panels[3]);
        JButton nextButton5 = getNextButton(panels[4]);
        JButton backButton5 = getBackButton(panels[4]);
        JButton nextButton6 = getNextButton(panels[5]);
        JButton backButton6 = getBackButton(panels[5]);
        JButton finalNextButton = getNextButton(panels[6]);
        JButton backButton7 = getBackButton(panels[6]);

        nextButton1.addActionListener(e -> cardLayout.show(cardPanel, "Overtaking"));
        nextButton2.addActionListener(e -> cardLayout.show(cardPanel, "DRS"));
        backButton2.addActionListener(e -> cardLayout.show(cardPanel, "LightsOut"));
        nextButton3.addActionListener(e -> cardLayout.show(cardPanel, "Crash"));
        backButton3.addActionListener(e -> cardLayout.show(cardPanel, "Overtaking"));
        nextButton4.addActionListener(e -> cardLayout.show(cardPanel, "SafetyCar"));
        backButton4.addActionListener(e -> cardLayout.show(cardPanel, "DRS"));
        nextButton5.addActionListener(e -> cardLayout.show(cardPanel, "PitStopA"));
        backButton5.addActionListener(e -> cardLayout.show(cardPanel, "Crash"));
        nextButton6.addActionListener(e -> cardLayout.show(cardPanel, "PitStopB"));
        backButton6.addActionListener(e -> cardLayout.show(cardPanel, "SafetyCar"));

        // Automatically show points after the last card
        finalNextButton.addActionListener(e -> {
            this.dispose(); // Close the RaceEvents window
            SwingUtilities.invokeLater(() -> new Points(drivers)); // Open the Points window
        });
        backButton7.addActionListener(e -> cardLayout.show(cardPanel, "PitStopA"));
    }

    private JButton getNextButton(JPanel panel) {
        JPanel buttonPanel = (JPanel) panel.getComponent(1); // Access button panel
        return (JButton) buttonPanel.getComponent(0); // Access next button
    }

    private JButton getBackButton(JPanel panel) {
        JPanel buttonPanel = (JPanel) panel.getComponent(1); // Access button panel
        if (buttonPanel.getComponentCount() > 1) {
            return (JButton) buttonPanel.getComponent(1); // Access back button if it exists
        }
        return null; // Return null if no back button exists
    }
}


class Points extends JFrame implements ActionListener {
    Map<String, Integer> driverPointsMap;
    JTable table;
    DefaultTableModel tableModel;
    String[] drivers;
    JButton updatePointsButton;

    // Constructor to set up the points table and UI elements
    public Points(String[] drivers) {
        this.drivers = drivers;
        driverPointsMap = new HashMap<>();
        for (String driver : drivers) {
            driverPointsMap.put(driver, 0);  // Initialize points to 0 for each driver
        }

        // Set up the main frame
        setTitle("Driver Points");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);  // Increased size for better spacing
        setLayout(new BorderLayout(10, 10));  // Add padding between components
        setLocationRelativeTo(null);

        // Table Setup
        String[] columnNames = {"Driver", "Points"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);
        table.setRowHeight(30);  // Increase row height for better readability
        table.setFont(new Font("SansSerif", Font.PLAIN, 14));  // Set table font for better aesthetics
        table.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 16));  // Header font styling
        table.getTableHeader().setBackground(Color.RED); // Header background color
        table.setBackground(Color.WHITE); // Table background color

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        // Button Panel at the bottom
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        buttonPanel.setBackground(Color.BLUE); // Set background color of the button panel

        // Update Points Button
        updatePointsButton = new JButton("Update Points");
        updatePointsButton.addActionListener(this);  // Add ActionListener to handle button clicks
        updatePointsButton.setPreferredSize(new Dimension(150, 40));  // Increase button size
        updatePointsButton.setFont(new Font("SansSerif", Font.BOLD, 14)); // Button font style
        updatePointsButton.setBackground(Color.ORANGE); // Button background color
        updatePointsButton.setForeground(Color.WHITE); // Button text color
        buttonPanel.add(updatePointsButton);

        // Exit Button
        JButton exitButton = new JButton("Exit Race");
        exitButton.setPreferredSize(new Dimension(150, 40));  // Increase button size
        exitButton.setFont(new Font("SansSerif", Font.BOLD, 14)); // Button font style
        exitButton.setBackground(Color.RED); // Button background color
        exitButton.setForeground(Color.WHITE); // Button text color
        exitButton.addActionListener(e -> System.exit(0)); // Exit the application
        buttonPanel.add(exitButton);

        // Add button panel to the frame
        add(buttonPanel, BorderLayout.SOUTH);

        // Populate the table with initial data
        refreshTable();
        setVisible(true);  // Make the window visible
    }

    // Method to refresh the table with current driver points
    private void refreshTable() {
        tableModel.setRowCount(0); // Clear existing rows
        for (Map.Entry<String, Integer> entry : driverPointsMap.entrySet()) {
            tableModel.addRow(new Object[]{entry.getKey(), entry.getValue()}); // Add updated driver points
        }
    }

    // Handle button clicks for updating points
    @Override
    public void actionPerformed(ActionEvent e) {
        // Update points randomly for each driver
        for (String driver : drivers) {
            int currentPoints = driverPointsMap.get(driver);
            // Add random points between 1 and 10 to each driver
            driverPointsMap.put(driver, currentPoints + (int) (Math.random() * 10 + 1));
        }
        refreshTable(); // Refresh table to show updated points
    }
}