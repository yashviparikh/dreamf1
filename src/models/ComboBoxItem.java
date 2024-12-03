package models;
import javax.swing.*;

// ComboBox item class to hold team names and logos
public class ComboBoxItem 
{
    String text;
    Icon icon;

    public ComboBoxItem(String text, Icon icon) 
    {
        this.text = text;
        this.icon = icon;
    }

    public String getText() 
    {
        return text;
    }

    public Icon getIcon() 
    {
        return icon;
    }

    @Override
    public String toString() 
    {
        return text;
    }
}
