package student.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class StudentLeavedetails extends JFrame implements ActionListener {
    Choice choiceRollNo;
    JTable table;
    JButton search,print,cancel;
StudentLeavedetails(){
    getContentPane ().setBackground ( new Color ( 250,172,206 ) );




    JLabel heading = new JLabel ( "Search by roll no " );
    heading.setBounds ( 20,20,150,20 );
    add(heading);

    choiceRollNo = new Choice ();
    choiceRollNo.setBounds ( 180,20,150,20 );
    add(choiceRollNo);


    try{
        DB c = new DB ();
        ResultSet resultSet = c.statement.executeQuery ( "select * from student");
        while ( resultSet.next ()) {
            choiceRollNo.add ( resultSet.getString ( "rollno" ) );
        }

    } catch ( Exception e ) {
        e.printStackTrace (  );
    }

    table = new JTable ();
    try {

        DB c = new DB ();
        ResultSet resultSet= c.statement.executeQuery ( "select * from studentleave");
        table.setModel ( DbUtils.resultSetToTableModel ( resultSet ) );
    } catch ( Exception e ) {
        e.printStackTrace (  );
    }

    JScrollPane scrollPane = new JScrollPane (table);
    scrollPane .setBounds ( 0,100,900,600);
    add(scrollPane);

    search = new JButton ("Search");
    search.setBounds ( 20,70,80,20 );
    search.addActionListener ( this );
    add ( search );

    cancel = new JButton ("Cancel");
    cancel.setBounds ( 120,70,80,20 );
    cancel.addActionListener ( this );
    add ( cancel );


    print = new JButton ("Print");
    print.setBounds ( 220,70,80,20 );
    print.addActionListener ( this );
    add ( print );



    setSize ( 900,700 );
    setLocation ( 300,100);
    setLayout ( null );
    setVisible ( true );





}

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource ()==search){
            String q ="select * from studentleave where rollno = '"+choiceRollNo.getSelectedItem ()+"'";
            try {

                DB c = new DB ();
                ResultSet resultSet = c.statement.executeQuery ( q);
                table.setModel ( DbUtils.resultSetToTableModel ( resultSet ) );
            } catch ( Exception ex ) {
                ex.printStackTrace (  );
            }

        } else if (e.getSource ()==print) {
            try {
                table.print (  );

            } catch ( Exception ex ) {
                ex.printStackTrace (  );
            }

        }else {
            setVisible ( false );
        }

    }

    public static void main(String[] args) {
        new StudentLeavedetails ();
    }
}
