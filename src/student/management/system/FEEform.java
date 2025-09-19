package student.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;


public class FEEform extends JFrame implements ActionListener {

    Choice crollnumber;
JComboBox courseBox,Departmentbox , comboBox;
JLabel totalAmount;
JButton pay, update,back;

     FEEform()  {

         getContentPane ().setBackground ( new Color ( 252,245,210 ) );
         ImageIcon i1 = new ImageIcon ( ClassLoader.getSystemResource ( "icon/fee.png" ) );
         Image i2 = i1.getImage ().getScaledInstance ( 400,300,Image.SCALE_DEFAULT );
         ImageIcon i3 = new ImageIcon (i2);
         JLabel img = new JLabel ( i3 );
         img .setBounds ( 500,40,500,350 );
         add ( img );

JLabel rollnumber = new JLabel ("Select Roll Number");
rollnumber.setBounds ( 40,60,150,20 );
rollnumber.setFont ( new Font ( "Tahoma",Font.PLAIN,10 ) );
add ( rollnumber );


crollnumber = new Choice ();
crollnumber .setBounds ( 200,60,150,20 );
add ( crollnumber );
try{
    DB cv = new DB ();
    ResultSet rs = cv.statement.executeQuery ( "select * from student" );
    while(rs.next ()){
        crollnumber.add ( rs.getString ( "rollno" ) );
    }

} catch ( Exception e ) {
    e.printStackTrace ();
}

               JLabel name = new JLabel ("Name ");
                name .setBounds ( 40,100,150,20 );
                add(name);
                JLabel textName = new JLabel ();
                textName.setBounds ( 200,100,150,20 );
                add(textName);

         JLabel fname = new JLabel ("Father Name ");
         fname.setBounds ( 40,140,150,20 );
         add( fname );
         JLabel textfName = new JLabel ();
         textfName.setBounds ( 200,140,150,20 );
         add( textfName );
try {

    DB c = new DB ();
    String Q = "select * from student where rollno = '"+crollnumber.getSelectedItem ()+"'";
    ResultSet resultSet = c.statement.executeQuery ( Q);
    while (resultSet.next ()){
        textfName.setName ( resultSet.getString ( "name" ) );
        textfName.setName ( resultSet.getString ( "fname" ) );
    }


} catch ( Exception e ) {
    e.printStackTrace ();
}


                 crollnumber.addItemListener ( new ItemListener ( ) {
                     @Override
                     public void itemStateChanged(ItemEvent e) {
                         try {

                             DB c = new DB ();
                             String query = "select * from student where rollno = '"+crollnumber.getSelectedItem ()+"'";
                             ResultSet resultSet = c.statement.executeQuery ( query );
                             while (resultSet.next ()){
                                 textfName.setName ( resultSet.getString ( "name" ) );
                                 textfName.setName ( resultSet.getString ( "fname" ) );
                             }


                         } catch ( Exception ex ) {
                             ex.printStackTrace ();
                         }

                     }
                 } );

         JLabel Qualification= new JLabel("Course");
         Qualification.setBounds(40,180,150,30);
         Qualification.setFont( new Font("serif",Font.BOLD,20));
         add(Qualification);

         String course[] ={ "BTech","BBA","BCA","BSC","BA","MSC","MBA","MCA","MCom","MA","M.TECH",};
         courseBox = new JComboBox(course);
         courseBox .setBounds(200,180,150,30);
         courseBox.setBackground(Color.white);
         add(courseBox);


         JLabel Department= new JLabel("Branch");
         Department.setBounds(40,220,150,20);
         Department.setFont( new Font("serif",Font.BOLD,20));
         add(Department);

         String department [] ={ "CSE","CE","ME","EE","IT","CS_DS","CS_IOT","EX","ECE","AIML",};
         Departmentbox = new JComboBox(department);
         Departmentbox .setBounds(200,220,150,20);
         Departmentbox.setBackground(Color.white);
         add(Departmentbox);
         JLabel sem = new JLabel (" Select  Semester ");
         sem.setBounds ( 40,260,150,20 );
         add( sem );

         String semester[]={"semester1","semester2","semester3","semester4","semester5","semester6","semester7","semester8"};
         comboBox = new JComboBox(semester);
         comboBox.setBounds ( 200,260,150,20 );
         comboBox.setBackground ( Color.white );
         add ( comboBox );

         JLabel total  = new JLabel ("total");
         total.setBounds ( 40,300,150,20 );
         add ( total );

         totalAmount = new JLabel ();
         totalAmount.setBounds ( 200,300,150,20 );
         add ( totalAmount );


         update = new JButton ("Update");
         update.setBounds ( 30,380,100,20 );
         update.addActionListener ( this );
         update.setForeground ( Color.white );
         update.setBackground ( Color.black );
         add ( update );

         pay = new JButton ("Pay");
         pay.setBounds ( 150,380,100,20 );
         pay.addActionListener ( this );
         pay.setForeground ( Color.white );
         pay.setBackground ( Color.black );
         add (  pay );

         back = new JButton ("back");
         back.setBounds ( 290,380,100,20 );
         back.addActionListener ( this );
         back.setForeground ( Color.white );
         back.setBackground ( Color.black );
         add (  back );


         setSize ( 900,500 );
         setLocation ( 300,100 );
         setLayout ( null );
         setVisible ( true );



     }

    @Override
    public void actionPerformed(ActionEvent e) {
if (e.getSource ()==update){
    String course = (String) courseBox.getSelectedItem ();
    String semester = (String) comboBox.getSelectedItem ();

    try {
        DB c =new DB ();
        ResultSet resultSet = c.statement.executeQuery ( "select * from fee where course = '"+course+"'");
        while (resultSet.next ()){
            totalAmount.setText ( resultSet.getString ( semester ) );
        }

    } catch ( Exception ex ) {
        ex.printStackTrace ();
    }
} else if (e.getSource ()==pay) {

    String rollno =crollnumber.getSelectedItem ();
    String course = (String) courseBox.getSelectedItem ();
    String semester = (String) comboBox.getSelectedItem ();
    String branch = (String) Departmentbox.getSelectedItem ();
    String total = totalAmount.getText ();

try {

    DB c = new DB ();
    String q = "insert into collegefees values ('"+rollno+"','"+course+"','"+branch+"','"+semester+"','"+total+"')";
    c.statement.executeUpdate ( q );
    JOptionPane.showMessageDialog ( null,"fees submitted" );

} catch ( Exception ex ) {
    ex.printStackTrace ();
}
}else {
    setVisible ( false );
}

    }

    public static void main(String[] args)  {
         new FEEform ();

    }
}
