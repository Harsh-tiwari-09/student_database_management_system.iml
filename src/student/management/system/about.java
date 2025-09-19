package student.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class about  extends JFrame implements ActionListener {
    about(){

        ImageIcon i1 = new ImageIcon ( ClassLoader.getSystemResource ( "icon/about - Copy.png" ) );
        Image i2 = i1.getImage ( ).getScaledInstance ( 300,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon (i2);
        JLabel img = new JLabel ( i3 );
        img.setBounds ( 350,0,350,250 );
        add (img);

        JLabel heading = new JLabel ("<html> ITM</br>GOI</html>");
        heading.setBounds ( 70,20,300,130 );
        heading.setFont ( new Font ("tahoma",Font.BOLD,30 ) );
        add(heading);

        JLabel name = new JLabel ( "Harshit Tiwari" );
        name.setBounds ( 60,260,550,30 );
        name.setFont ( new Font ("tahoma",Font.BOLD,30 ) );
        add(name);

        JLabel contact = new JLabel ( " Tiwari@gmail.com" );
        contact.setBounds ( 70,320,300,30 );
        contact.setFont ( new Font ("tahoma",Font.BOLD,30 ) );
        add(contact);


        setSize ( 700,500 );
        setLocation ( 400,150 );
        getContentPane ().setBackground ( new Color ( 252,228,210 ) );
        setLayout ( null );
        setVisible ( true );

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        new about ();

    }
}
