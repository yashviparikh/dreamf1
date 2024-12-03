package utils;
import models.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.HashMap;
import java.util.Map;


// Renderer for ComboBox to show icons and text
public class ComboBoxRenderer extends JLabel implements ListCellRenderer<ComboBoxItem> {
    public ComboBoxRenderer() 
    {
        setOpaque(true);
    }

    public Component getListCellRendererComponent(JList<? extends ComboBoxItem> list, ComboBoxItem value, int index, boolean isSelected, boolean cellHasFocus) {
        setFont(new Font("Arial", Font.PLAIN, 10));
        setPreferredSize(new Dimension(250, 100));
        if (isSelected) 
        {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        } else 
        {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }

        setText(value.getText());
        setIcon(value.getIcon());
        return this;
    }
}
