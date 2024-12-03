package main;

import ui.UserDetailsUI;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new UserDetailsUI());
    }
}
