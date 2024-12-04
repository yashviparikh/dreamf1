package utils;
import java.awt.*;
import javax.swing.*;
import models.*;


// Renderer for ComboBox to show icons and text
public class ComboBoxRenderer extends JLabel implements ListCellRenderer<ComboBoxItem> {
    public ComboBoxRenderer() 
    {
        setOpaque(true);
    }

    public Component getListCellRendererComponent(JList<? extends ComboBoxItem> list, ComboBoxItem value, int index, boolean isSelected, boolean cellHasFocus) {
        setFont(new Font("Calibri", Font.BOLD, 20));
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
