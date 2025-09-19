package student.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Addstudent extends JFrame implements ActionListener {



    JTextField textname;
    JTextField  textFather;
    JTextField textAddress;
    JTextField textphoneNumber;
    JTextField textEmail;
    JTextField textMarks;
    JTextField  textM12;
    JTextField  textaaddherno;
JTextField textroll;
    JDateChooser cDob;
    JComboBox courseBox , Departmentbox;
    JButton sumbit , cancel;


    Addstudent(){


            getContentPane().setBackground(new Color (128,176,255));
            JLabel heading = new JLabel("Add Student Details");
            heading .setBounds(310,30,500,50);
            heading.setFont(new Font("serif",Font.BOLD,30));
            add(heading);

            JLabel name = new JLabel("Name");
            name.setBounds(50,150,100,30);
            name.setFont( new Font("serif",Font.BOLD,20));
            add(name);


            textname =new JTextField();
            textname.setBounds(150,150,200,30);
            textname.setFont( new Font("serif",Font.BOLD,20));

            add(textname);

            JLabel fname = new JLabel(" Father's Name");
            fname.setBounds(400,150,200,30);
            fname.setFont( new Font("serif",Font.BOLD,20));
            add(fname);


            textFather =new JTextField();
            textFather.setBounds(600,150,200,30);
            textFather.setFont( new Font("serif",Font.BOLD,20));

            add( textFather);

            JLabel rollno = new JLabel(" Roll number");
        rollno .setBounds(50,200,200,30);
        rollno.setFont( new Font("serif",Font.BOLD,20));
            add(rollno);

        textroll =new JTextField();
        textroll.setBounds(200,200,100,30);
        textroll.setFont( new Font("serif",Font.BOLD,20));

            add(textroll);

            JLabel Dob = new JLabel(" Date of birthday");
            Dob.setBounds(400,200,200,30);
            Dob.setFont( new Font("serif",Font.BOLD,20));
            add(Dob);

            cDob = new JDateChooser();
            cDob.setBounds(600,200,150,30);
            add(cDob);

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

            textMarks =new JTextField();

            textMarks.setBounds(600,300,150,30);
            textMarks.setFont( new Font("serif",Font.BOLD,20));

            add( textMarks);

            JLabel m12 = new JLabel("Class XII");
            m12.setBounds(50,350,200,30);
            m12.setFont( new Font("serif",Font.BOLD,20));
            add(m12);

            textM12 =new JTextField();

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
            Qualification.setBounds(50,400,200,30);
            Qualification.setFont( new Font("serif",Font.BOLD,20));
            add(Qualification);

            String course[] ={ " B.TECH","BBA","BCA","BSC","BA","MSC","MBA","MCA","MCom","MA","M.TECH",};
            courseBox = new JComboBox(course);
            courseBox .setBounds(200,400,150,30);
            courseBox.setBackground(Color.white);
            add(courseBox);


            JLabel Department= new JLabel("Branch");
            Department.setBounds(400,400,200,30);
            Department.setFont( new Font("serif",Font.BOLD,20));
            add(Department);

            String department [] ={ "CSE","CE","ME","EE","IT","CS_DS","CS_IOT","EX","ECE","AIML",};
            Departmentbox = new JComboBox(department);
            Departmentbox .setBounds(600,400,150,30);
            Departmentbox.setBackground(Color.white);
            add(Departmentbox);

            sumbit = new JButton("sumbit");
            sumbit.setBounds(250,550,120,30);
            sumbit. setBackground(Color.black);
            sumbit.setForeground(Color.white);
            sumbit.addActionListener(this);
            add(sumbit);

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

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource()== sumbit){
                String name = textname .getText();
                String fname = textFather.getText();
                String rollno = textroll .getText();
                String Dob = (( JTextField)cDob.getDateEditor().getUiComponent()).getText();
                String address  = textAddress.getText();
                String phone = textphoneNumber .getText();
                String email = textEmail.getText();
                String m10 = textMarks .getText();
                String m12 = textM12.getText();
                String AaddharNo = textaaddherno .getText();
                String Qualification = (String) courseBox.getSelectedItem();
                String Department = (String) Departmentbox.getSelectedItem();
                try{
                    String q  = "insert into student values('"+name+"', '"+fname+"','"+rollno+"','"+Dob+"','"+address+"', '"+phone+"','"+email+"','"+m10+"','"+m12+"','"+AaddharNo+"','"+Qualification+"','"+Department+"')";
                    DB c = new DB();
                    c.statement.executeUpdate(q);
                    JOptionPane.showMessageDialog(null,"Details Inserted");
                    setVisible(false);


                }catch ( Exception E){
                    E.printStackTrace();
                }
            } else {
                setVisible(false);
            }
        }


    public static void main(String[] args) {
        new Addstudent ();

    }
}
