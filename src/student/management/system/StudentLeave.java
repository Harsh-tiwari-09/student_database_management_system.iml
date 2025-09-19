package student.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class StudentLeave extends JFrame implements ActionListener {

    Choice choiceRollNO,choiceTime;
JDateChooser selDate;
 JButton submit ,cancel;

    StudentLeave (){

        getContentPane ().setBackground (new Color (210,232,252  )   );

        JLabel heading = new JLabel ("Apply leave (Student)");
        heading.setBounds ( 40,50,300,30 );
        heading.setFont ( new Font ( "Tahoma", Font.BOLD,20 ) );
        add(heading)   ;

        JLabel RollNoSer = new JLabel ("Search by roll number");
        RollNoSer.setBounds ( 60,100,200,20 );
       // RollNoSer.setFont ( new Font ( "Tahoma", Font.BOLD,18) );
        add(RollNoSer)   ;

        choiceRollNO = new Choice ();
        choiceRollNO.setBounds ( 60,130,200,20 );
        add ( choiceRollNO );


        try {

            DB c =new DB();
            ResultSet resultSet = c.statement.executeQuery ( "select * from student" );

            while (resultSet.next()){

                choiceRollNO.add(resultSet.getString ( "rollno" ));
            }

        } catch ( Exception e ) {
            e.printStackTrace (  );
        }


        JLabel lbldate = new JLabel ("DATE");
        lbldate.setBounds ( 60,180,200,20 );
lbldate.setFont ( new Font ( "tahoms",Font.PLAIN,18 ) );
add(lbldate);


        selDate = new JDateChooser ();
        selDate.setBounds ( 60,210,200,25 );
        add(selDate);


        JLabel time = new JLabel ("Time Duration");
        time.setBounds ( 60,260,200,20 );
        time.setFont ( new Font ( "tahoms",Font.PLAIN,18 ) );
        add( time );

        choiceTime = new Choice ();
        choiceTime.setBounds ( 60,290,200,290 );
        choiceTime.add("full day");
        choiceTime.add("half day");
        add ( choiceTime );


        submit = new JButton ("Submit");
        submit.setBounds ( 60,350,100,25 );
        submit.setBackground ( Color.black );
submit.setForeground ( Color.white );
submit.addActionListener ( this );
add ( submit );




           cancel     = new JButton ("Cancel");
        cancel.setBounds ( 200,350,100,25 );
        cancel.setBackground ( Color.black );
        cancel.setForeground ( Color.white );
        cancel.addActionListener ( this );
        add ( cancel );



        setSize ( 500,550 );
        setLocation ( 550,100 );
        setLayout ( null );
        setVisible ( true );

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if( e.getSource ()==submit){
            String rollno = choiceRollNO.getSelectedItem ();
            String date  =((JTextField) selDate.getDateEditor ().getUiComponent ()).getText ();
            String time = choiceTime.getSelectedItem ();
            String Q = "insert into studentleave values( '"+rollno+"' ,  '"+ date+"'  , '"+time+"')";
            try {

                DB c = new DB();
                c.statement.executeUpdate ( Q );
                JOptionPane.showMessageDialog ( null,"Leave confirmed" );
                setVisible ( false );


            } catch ( Exception E ) {
                E.printStackTrace (  );
            }

        }else {
            setVisible ( false );
        }


    }

    public static void main(String[] args) {
        new StudentLeave ();

    }

}
