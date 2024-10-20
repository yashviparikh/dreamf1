package dreamf1;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;

class UserDetails
{
    private String username;
    private int userage;
    private String useremail;

    public UserDetails(String uname,int uage,String uemail)
    {
        this.username=uname;
        this.userage=uage;
        this.useremail=uemail;
    }
    public String getUsername()
    {
        return username;
    }
    public int getUserage()
    {
        return userage;
    }
    public String getUseremail()
    {
        return useremail;
    }
}
public class UserDetailsUI extends JFrame implements ActionListener
{
    JTextField name,age,email;
    JLabel lname,lage,lemail;
    JButton submit;
    public UserDetailsUI()
    {
        setTitle("Login!");
        setSize(500,500);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc=new GridBagConstraints();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        lname=new JLabel("UserName: ");
        lage=new JLabel("Age: ");
        lemail=new JLabel("Email: ");

        name=new JTextField(20);
        age=new JTextField(2);
        email=new JTextField(25);

        submit=new JButton("Submit");
        submit.addActionListener(this);

        gbc.fill=GridBagConstraints.HORIZONTAL;

        gbc.gridx=0;
        gbc.gridy=0;
        gbc.weightx=0.5;
        add(lname,gbc);

        gbc.gridx=1;
        add(name,gbc);
        
        gbc.gridx=0;
        gbc.gridy=1;
        add(lage,gbc);

        gbc.gridx=1;
        add(age,gbc);

        gbc.gridx=0;
        gbc.gridy=2;
        add(lemail,gbc);

        gbc.gridx=1;
        add(email,gbc);

        gbc.gridx=1;
        gbc.gridy=3;
        gbc.gridwidth=2;
        gbc.weighty=1.5;
        gbc.fill=GridBagConstraints.CENTER;
        add(submit);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        try
        {
            String uname=name.getText();
            int uage=Integer.parseInt(age.getText());
            String uemail=email.getText();

            UserDetails user= new UserDetails(uname,uage,uemail);

            JOptionPane.showMessageDialog(null,"Login registered for "+ user.getUsername(),"Confirmation",JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        }
        catch(NumberFormatException ne)
        {
            JOptionPane.showMessageDialog(null,"Login failed","Login failed",JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
public static void main(String [] args)
{
    SwingUtilities.invokeLater(()->new UserDetailsUI());
}
}
