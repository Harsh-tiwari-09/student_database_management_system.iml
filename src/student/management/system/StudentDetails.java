package student.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import  java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;


public class StudentDetails extends JFrame  implements ActionListener {

    Choice choice;
    JTable table;

    JButton search, print, update, add, cancel;


    StudentDetails() {
        getContentPane ( ).setBackground ( new Color ( 192,164,252 ) );

        JLabel heading = new JLabel ( "Search by Roll number" );
        heading.setBounds ( 20, 20, 150, 20 );
        add ( heading );

        choice = new Choice ( );
        choice.setBounds ( 180, 20, 150, 20 );
        add ( choice );

        try {
            DB c = new DB ( );
            ResultSet resultSet = c.statement.executeQuery ( "select*from student " );
            while (resultSet.next ( )) {
                choice.add ( resultSet.getString ( "rollno" ) );
            }

        } catch ( Exception e ) {
            e.printStackTrace ( );
        }

        table = new JTable ( );
        try {
            DB c = new DB ( );
            ResultSet resultSet = c.statement.executeQuery ( "select*from student" );
            table.setModel ( DbUtils.resultSetToTableModel ( resultSet ) );


        } catch ( Exception e ) {
            e.printStackTrace ( );
        }
        JScrollPane js = new JScrollPane ( table );
        js.setBounds ( 0, 100, 900, 600 );
        add ( js );


        search = new JButton ( "Search" );
        search.setBounds ( 20, 70, 80, 20 );
        search.addActionListener ( this );
        add ( search );

        print = new JButton ( "Print" );
        print.setBounds ( 120, 70, 80, 20 );
        print.addActionListener ( this );
        add ( print );

        add = new JButton ( "Add" );
        add.setBounds ( 220, 70, 80, 20 );
        add.addActionListener ( this );
        add ( add );

        update = new JButton ( "Update" );
        update.setBounds ( 320, 70, 80, 20 );
        update.addActionListener ( this );
        add ( update );

        cancel = new JButton ( "Cancel" );
        cancel.setBounds ( 420, 70, 80, 20 );
        cancel.addActionListener ( this );
        add ( cancel );


        setLayout ( null );
        setSize ( 900, 700 );
        setLocation ( 300, 100 );
setVisible (  true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource ( ) == search) {
            String q = "select * from student where rollno = '"+choice.getSelectedItem ()+"'";
            try{
                DB c = new DB ();
                ResultSet resultSet = c.statement.executeQuery ( q);
                table.setModel ( DbUtils.resultSetToTableModel ( resultSet ) );

            } catch ( Exception E ) {
                E.printStackTrace (  );
            }

        } else if (e.getSource ()==print) {

            try{

                table.print (  );

            } catch ( Exception E ) {
               E .printStackTrace (); ;
            }


        } else if (e.getSource ()==add) {
            setVisible ( false );
            new Addstudent ();
        } else if (e.getSource ()==update) {
            setVisible ( false );
            new StudentUpdate ();

        }else {
            setVisible ( false );
        }



    }


    public static void main(String[] args) {
        new StudentDetails ( );
    }
}
