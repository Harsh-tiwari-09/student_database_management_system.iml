package student.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class EnterMarks extends JFrame implements ActionListener {

    Choice choicerollno;
JComboBox comboBox;
JTextField subcode1, subcode2, subcode3,subcode4,subcode5;
    JTextField subj1,subj2,subj3,subj4,subj5;
    JTextField mrk1,mrk2,mrk3,mrk4,mrk5;
    JButton submit, cancel;


EnterMarks(){

        getContentPane ().setBackground ( new Color ( 252,245,210 ) );
        ImageIcon i1 = new ImageIcon ( ClassLoader.getSystemResource ( "icon/exam.png" ) );
        Image i2 = i1.getImage ().getScaledInstance ( 400,300,Image.SCALE_DEFAULT );
ImageIcon i3 = new ImageIcon (i2);
      JLabel img = new JLabel ( i3 );
      img .setBounds ( 500,40,500,350 );
      add ( img );

      JLabel heading = new JLabel ("Enter Marks of Student");
      heading.setBounds ( 50,0,500,50 );
      add(heading);

        JLabel rollno = new JLabel (" Select by Roll No ");
        rollno.setBounds ( 50,50,150,50 );
        add(rollno);

        choicerollno = new Choice ();
        choicerollno.setBounds ( 200,70,150,50 );
        add(choicerollno);

        try {
          DB c = new DB ();
            ResultSet resultSet = c.statement.executeQuery ( "select * from student");
            while(resultSet.next ()){
                choicerollno.add(resultSet.getString ( "rollno" ));
            }

        } catch ( Exception e ) {
            e.printStackTrace ();

        }

        JLabel sem = new JLabel (" Select  Semester ");
        sem.setBounds ( 50,89,150,20 );
        add( sem );

        String semester[]={"1st sem","2st sem","3st sem","4st sem","5st sem" ,"6st sem","7st sem","8st sem"};
        comboBox = new JComboBox(semester);
        comboBox.setBounds ( 200,100,150,20 );
        comboBox.setBackground ( Color.white );
        add ( comboBox );

        JLabel EnterSubjectCode =new JLabel ("Enter subject Code :");
        EnterSubjectCode.setBounds ( 30,150,200,40 );
        add( EnterSubjectCode );

        JLabel Entersub  =new JLabel ("Enter subject :");
        Entersub.setBounds ( 170,150,200,40 );
        add(Entersub);

        JLabel EnterMark =new JLabel ("Enter Mark  :");
        EnterMark.setBounds ( 370,150,200,40 );
        add( EnterMark );

        subcode1 = new JTextField ();
        subcode1.setBounds ( 50,200,50,20 );
        add(subcode1);

        subcode2 = new JTextField ();
        subcode2.setBounds ( 50,230,50,20 );
        add(subcode2);

        subcode3 = new JTextField ();
        subcode3.setBounds ( 50,260,50,20 );
        add(subcode3);

        subcode4 = new JTextField ();
        subcode4.setBounds ( 50,290,50,20 );
        add(subcode4);

        subcode5 = new JTextField ();
        subcode5.setBounds ( 50,320,50,20 );
        add(subcode5);

        subj1 = new JTextField ();
        subj1.setBounds ( 150,200,200,20 );
        add(subj1);

        subj2 = new JTextField ();
        subj2.setBounds ( 150,230,200,20 );
        add(subj2);

        subj3 = new JTextField ();
        subj3.setBounds ( 150,260,200,20 );
        add(subj3);

        subj4 = new JTextField ();
        subj4.setBounds ( 150,290,200,20 );
        add(subj4);

        subj5 = new JTextField ();
        subj5.setBounds ( 150,320,200,20 );
        add(subj5);

        mrk1 = new JTextField ();
        mrk1.setBounds ( 400,200,50,20 );
        add(mrk1);

        mrk2 = new JTextField ();
        mrk2.setBounds ( 400,230,50,20 );
        add(mrk2);

        mrk3 = new JTextField ();
        mrk3.setBounds ( 400,260,50,20 );
        add(mrk3);

        mrk4 = new JTextField ();
        mrk4.setBounds ( 400,290,50,20 );
        add(mrk4);

        mrk5 = new JTextField ();
        mrk5.setBounds ( 400,320,50,20 );
        add(mrk5);

submit = new JButton ("Sumbit");
submit.setBounds ( 70,360,150,25 );
submit.setBackground ( Color.black );
submit.setForeground ( Color.white );
submit.addActionListener ( this );
add(submit);

    cancel = new JButton ("Cancel");
    cancel.setBounds ( 280,360,150,25 );
    cancel.setBackground ( Color.black );
    cancel.setForeground ( Color.white );
    cancel.addActionListener ( this );
    add(cancel);





        setSize ( 1000,500 );
        setLayout ( null );
        setLocation ( 300,150 );
        setVisible ( true );
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    if (e.getSource ()==submit){
        try{
            DB  c = new DB ();
            String Q1 = " insert into subjects values ('"+choicerollno.getSelectedItem ()+"','"+comboBox.getSelectedItem ()+"','"+subj1.getText ()+"','"+subj2.getText ()+"','"+subj3.getText ()+"','"+subj4.getText ()+"','"+subj5.getText ()+"')";
            String Q2 = " insert into marks values ('"+choicerollno.getSelectedItem ()+"','"+comboBox.getSelectedItem ()+"','"+mrk1.getText ()+"','"+mrk2.getText ()+"','"+mrk3.getText ()+"','"+mrk4.getText ()+"','"+mrk5.getText ()+"')";

            c.statement.executeUpdate (Q1  );
            c.statement.executeUpdate ( Q2 );

            JOptionPane.showMessageDialog ( null,"Marks inserted sucessfully" );
            setVisible ( false );



        } catch ( Exception E ) {
            E.printStackTrace ();

        }
    }else {
        setVisible(false);
    }

    }

    public static void main(String[] args) {
        new EnterMarks ();
    }
}
