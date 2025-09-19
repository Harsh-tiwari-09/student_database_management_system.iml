package student.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class StudentUpdate  extends JFrame implements ActionListener {

    JTextField textAddress;
    JTextField textphoneNumber;
    JTextField textEmail;

    JTextField  textaaddherno, textcourse ,textbranch;

    JTextField textrollno;

    Choice cEMPID;

    JButton submit, cancel ;

    StudentUpdate(){

        getContentPane().setBackground(new Color (230,210,252));
        JLabel heading = new JLabel("Update student details");
        heading .setBounds(50,10,500,50);
        heading.setFont(new Font("serif",Font.BOLD,35));
        add(heading);

        JLabel empId = new JLabel ( "select roll no" );
        empId.setBounds (50,100,200,20  );
        empId.setFont ( new Font ( "serif",Font.PLAIN,20 ) );
        add(empId);

        cEMPID = new Choice ();
        cEMPID.setBounds ( 250,100,200,20 );
        add(cEMPID);

        try{
            DB c = new DB ();
            ResultSet rs = c.statement.executeQuery ( "select * from student" );
            while (rs.next ()){
                cEMPID.add(rs.getString ("rollno" ));
            }

        } catch ( Exception e ) {
            e.printStackTrace (  );
        }



        JLabel name = new JLabel("Name");
        name.setBounds(50,150,100,30);
        name.setFont( new Font("serif",Font.BOLD,20));
        add(name);

        JLabel textname =new JLabel ();
        textname.setBounds(150,150,200,30);
        textname.setFont( new Font("serif",Font.BOLD,20));

        add(textname);


        JLabel fname = new JLabel(" Father's Name");
        fname.setBounds(400,150,200,30);
        fname.setFont( new Font("serif",Font.BOLD,20));
        add(fname);

        JLabel  textFather =new JLabel ();
        textFather.setBounds(600,150,200,30);
        textFather.setFont( new Font("serif",Font.BOLD,20));

        add( textFather);


        JLabel empID = new JLabel(" Roll No");
        empID.setBounds(50,200,200,30);
        empID.setFont( new Font("serif",Font.BOLD,20));
        add(empID);

        textrollno  =new JTextField ();
        textrollno.setBounds(200,200,100,30);
        textrollno.setFont( new Font("serif",Font.BOLD,20));

        add(textrollno);

        JLabel Dob = new JLabel(" Date of birthday");
        Dob.setBounds(400,200,200,30);
        Dob.setFont( new Font("serif",Font.BOLD,20));
        add(Dob);

        JLabel dobDob = new JLabel ();
        dobDob.setBounds(600,200,150,30);
        add( dobDob );

        JLabel address= new JLabel(" Address");
        address.setBounds(50,250,200,30);
        address.setFont( new Font("serif",Font.BOLD,20));
        add(address);

        textAddress =new JTextField();
        textAddress.setBounds(200,250,150,30);
        textAddress.setFont( new Font("serif",Font.BOLD,20));

        add( textAddress);

        JLabel phone = new JLabel(" phone Number");
        phone.setBounds(400,250,200,30);
        phone.setFont( new Font("serif",Font.BOLD,20));
        add(phone);

        textphoneNumber =new JTextField();

        textphoneNumber.setBounds(600,250,150,30);
        textphoneNumber.setFont( new Font("serif",Font.BOLD,20));

        add( textphoneNumber);


        JLabel email = new JLabel("Email");
        email.setBounds(50,300,200,30);
        email.setFont( new Font("serif",Font.BOLD,20));
        add(email);

        textEmail =new JTextField();

        textEmail.setBounds(200,300,150,30);
        textEmail.setFont( new Font("serif",Font.BOLD,20));

        add( textEmail);

        JLabel m10 = new JLabel("Class X");
        m10.setBounds(400,300,200,30);
        m10.setFont( new Font("serif",Font.BOLD,20));
        add(m10);

        JLabel   textMarks =new JLabel ();
        textMarks.setBounds(600,300,150,30);
        textMarks.setFont( new Font("serif",Font.BOLD,20));
        add( textMarks);

        JLabel m12 = new JLabel("Class XII");
        m12.setBounds(50,350,200,30);
        m12.setFont( new Font("serif",Font.BOLD,20));
        add(m12);

        JLabel  textM12 =new JLabel ();

        textM12.setBounds(200,350,150,30);
        textM12.setFont( new Font("serif",Font.BOLD,20));

        add(  textM12);

        JLabel AaddharNo= new JLabel("Aaddhar card Number");
        AaddharNo.setBounds(400,350,200,30);
        AaddharNo.setFont( new Font("serif",Font.BOLD,20));
        add(AaddharNo);

        textaaddherno =new JTextField();

        textaaddherno.setBounds(600,350,150,30);
        textaaddherno.setFont( new Font("serif",Font.BOLD,20));

        add(textaaddherno);

        JLabel Qualification= new JLabel("Course");
        Qualification.setBounds(50,400,150,30);
        Qualification.setFont( new Font("serif",Font.BOLD,20));
        add(Qualification);

        textcourse = new JTextField ();
        textcourse.setBounds ( 200,400,200,30 );
        add(textcourse);



        JLabel Department= new JLabel("Branch");
        Department.setBounds(400,400,200,30);
        Department.setFont( new Font("serif",Font.BOLD,20));
        add(Department);

        textbranch = new JTextField ();
        textbranch.setBounds ( 600,400,150,30 );
        add(textbranch);

        try{
            DB c = new DB ();
            String query = "select * from student where rollno = '"+ cEMPID.getSelectedItem ()+"'";
            ResultSet resultSet = c.statement.executeQuery ( query);
            while (resultSet.next ()){
                textname.setText ( resultSet.getString ( "name" ) );
                textFather.setText  ( resultSet.getString ( "fname" )  );
                dobDob.setText ( resultSet.getString ( "Dob" ) );
                textAddress .setText ( resultSet.getString ( "address" ) );
                textphoneNumber.setText ( resultSet.getString ( "phone" ) );
                textEmail.setText (resultSet.getString ( "email" )  );
                textMarks.setText ( resultSet.getString ( "class_X" ) );
                textM12.setText ( resultSet.getString ( "class_xII") );
                textaaddherno.setText ( resultSet.getString ( "aadhar" ) );
                textrollno.setText ( resultSet.getString ( "rollno" ) );
                textcourse.setText ( resultSet.getString ( "course" ) );
                textbranch.setText ( resultSet.getString ( "branch" ) );


            }
        } catch ( Exception E ) {
            E.printStackTrace ();
        }

        cEMPID.addItemListener ( new ItemListener ( ) {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try{

                    DB c = new DB ();
                    String query = "select * from student where rollno = '"+ cEMPID.getSelectedItem ()+"'";
                    ResultSet resultSet = c.statement.executeQuery ( query);
                    while (resultSet.next ()) {
                        textname.setText ( resultSet.getString ( "name" ) );
                        textFather.setText ( resultSet.getString ( "fname" ) );
                        dobDob.setText ( resultSet.getString ( "Dob" ) );
                        textAddress.setText ( resultSet.getString ( "address" ) );
                        textphoneNumber.setText ( resultSet.getString ( "phone" ) );
                        textEmail.setText ( resultSet.getString ( "email" ) );
                        textMarks.setText ( resultSet.getString ( "class_X" ) );
                        textM12.setText ( resultSet.getString ( "class_xII" ) );
                        textaaddherno.setText ( resultSet.getString ( "aadhar" ) );
                        textrollno.setText ( resultSet.getString ( "rollno" ) );
                        textcourse.setText ( resultSet.getString ( "course" ) );
                        textbranch.setText ( resultSet.getString ( "branch" ) );
                    }


                }catch ( Exception E ){
                    E.printStackTrace ();
                }
            }
        } );

        submit = new JButton("Update");
        submit.setBounds(250,550,120,30);
        submit. setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        add( submit );

        cancel = new JButton("cancel");
        cancel.setBounds(450,550,120,30);
        cancel. setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        add(cancel);





        setSize(900,700);

        setLocation(350,50);
        setLayout(null);
        setVisible(true);





    }
/*
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource ()==submit){


            String empId = textrollno.getText ();
            String address = textAddress.getText ();
            String phone = textphoneNumber.getText ( );
            String email = textEmail.getText ();
            String course = textcourse.getText ();
            String branch = textbranch.getText ();
            try {
                String Q = "update student set address = '"+address+"', phone ='"+phone+"', email = '"+email+"', course ='"+course+"', branch = '"+branch+"', rollno = '"+empId+"'";
                DB c = new DB ();
                c.statement.executeUpdate ( Q );
                JOptionPane.showMessageDialog ( null,"detalis update" );
                setVisible ( false );

            } catch ( Exception E ) {
                E.printStackTrace ();
            }
        }else {
            setVisible ( false );
        }

    }
    */
@Override
public void actionPerformed(ActionEvent e) {
    if (e.getSource() == submit) {
        String empId = cEMPID.getSelectedItem(); // Get the selected roll number
        String address = textAddress.getText();
        String phone = textphoneNumber.getText();
        String email = textEmail.getText();
        String course = textcourse.getText();
        String branch = textbranch.getText();

        try {
            // Update query with WHERE clause to specify which record to update
            String Q = "UPDATE student SET address = '" + address +
                    "', phone = '" + phone +
                    "', email = '" + email +
                    "', course = '" + course +
                    "', branch = '" + branch +
                    "' WHERE rollno = '" + empId + "'"; // Add WHERE clause

            DB c = new DB();
            c.statement.executeUpdate(Q);
            JOptionPane.showMessageDialog(null, "Details updated successfully");
            setVisible(false);
        } catch (Exception E) {
            E.printStackTrace();
        }
    } else {
        setVisible(false);
    }
}
    public static void main(String[] args) {
      new  StudentUpdate( );

    }
}
