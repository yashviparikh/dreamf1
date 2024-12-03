package models;
import ui.*;
import utils.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.HashMap;
import java.util.Map;

public class UserDetails {
    private String username;
    private int userage;
    private String useremail;

    public UserDetails(String uname, int uage, String uemail) {
        this.username = uname;
        this.userage = uage;
        this.useremail = uemail;
    }

    public String getUsername() {
        return username;
    }

    public int getUserage() {
        return userage;
    }

    public String getUseremail() {
        return useremail;
    }
}