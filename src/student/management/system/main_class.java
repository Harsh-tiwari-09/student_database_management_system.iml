package student.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class main_class extends JFrame  implements ActionListener {
    main_class(){
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/Zero Gravity.png"));
        Image i2 =i1.getImage().getScaledInstance(1500,750, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2) ;
        JLabel img = new JLabel(i3)   ;
        add(img);

        JMenuBar mb = new JMenuBar();

        // new information
        JMenu newInfo = new JMenu("New Information");
        newInfo.setForeground(Color.black);
        mb.add(newInfo);

        JMenuItem facultyInfo =new JMenuItem("New faculty information");
        facultyInfo.setBackground(Color.white);
        facultyInfo.addActionListener ( this );
        newInfo.add(facultyInfo);

        JMenuItem studentInfo = new JMenuItem("New Student information");
        studentInfo.setBackground(Color.white);
        studentInfo.addActionListener ( this );
        newInfo.add(studentInfo);


        // details
        JMenu details = new JMenu("View Details");
        details .setForeground(Color.black);
        mb.add(details);

        JMenuItem facultyDetails = new JMenuItem( "  View Faculty Details");
        facultyDetails.setBackground(Color.white);
        facultyDetails.addActionListener ( this );
        details.add(facultyDetails);

        JMenuItem studentDetails = new JMenuItem(" View student Details");
        studentDetails.setBackground(Color.white);
        studentDetails.addActionListener ( this );
        details.add(studentDetails);

        //leave

        JMenu leave =new JMenu("Apply for leave");
        leave .setForeground(Color.black);
        mb.add(leave);

        JMenuItem facultyLeave = new JMenuItem("faculty leave");
        facultyLeave.setBackground(Color.white);
        facultyLeave.addActionListener ( this );
        leave.add(facultyLeave);

        JMenuItem studentLeave = new JMenuItem("student leave");
        studentLeave.setBackground(Color.white);
        studentLeave.addActionListener ( this );
        leave.add(studentLeave);

        //leave details

        JMenu leaveDetails =new JMenu("Leave Details");
        leaveDetails.setForeground(Color.black);
        mb.add(leaveDetails);

        JMenuItem facultyLeaveDetails = new JMenuItem("faculty leave details");
        facultyLeaveDetails.setBackground(Color.white);
        facultyLeaveDetails.addActionListener ( this );
        leaveDetails.add(facultyLeaveDetails);

        JMenuItem studentLeaveDetails = new JMenuItem("student leave details");
        studentLeaveDetails.setBackground(Color.white);
        studentLeaveDetails.addActionListener ( this );
        leaveDetails.add(studentLeaveDetails);


        //exam

        JMenu exam = new JMenu("examination");
        exam.setForeground(Color.black);
        mb.add(exam);

        JMenuItem examinationDetails = new JMenuItem("examination result");
        examinationDetails.setBackground(Color.white);
        examinationDetails.addActionListener ( this );
        exam.add(examinationDetails);

        JMenuItem enterMarks = new JMenuItem("enter marks");
        enterMarks.setBackground(Color.white);
        enterMarks.addActionListener ( this );
        exam.add(enterMarks);

        //update information

        JMenu updateInfo = new JMenu("Update Details");
        updateInfo.setForeground(Color.black);
        mb.add(updateInfo);

        JMenuItem facultyUpdateInfo = new JMenuItem("faculty Update Details ");
        facultyUpdateInfo .setBackground(Color.white);
        facultyUpdateInfo.addActionListener ( this );
        updateInfo.add(facultyUpdateInfo );

        JMenuItem studentUpdateInfo= new JMenuItem("student Update Details");
        studentUpdateInfo.setBackground(Color.white);
        studentUpdateInfo.addActionListener ( this );
        updateInfo.add(studentUpdateInfo);

        //fee

        JMenu feeInfo = new JMenu("fee Details");
        feeInfo.setForeground(Color.black);
        mb.add(feeInfo);

        JMenuItem feeStructure = new JMenuItem("fee  structure ");
        feeStructure .setBackground(Color.white);
        feeStructure.addActionListener ( this );
        feeInfo.add( feeStructure);

        JMenuItem feeFrom= new JMenuItem("student fee from");
        feeFrom.setBackground(Color.white);
        feeFrom.addActionListener ( this );
        feeInfo.add(feeFrom);

        //utility

        JMenu utility= new JMenu("utility");
        utility.setForeground(Color.black);
        utility.addActionListener ( this );
        mb.add( utility);

        JMenuItem calculator= new JMenuItem("calculator ");
        calculator .setBackground(Color.white);
        calculator.addActionListener(this);
        utility.add(calculator);

        JMenuItem Notepad= new JMenuItem("notepad");
        Notepad.setBackground(Color.white);
        Notepad.addActionListener(this);
        utility.add(Notepad);

        // about

        JMenu about= new JMenu("about");
        about.setForeground(Color.black);
        mb.add( about);

        JMenuItem About= new JMenuItem("About ");
        About .setBackground(Color.white);
        About.addActionListener ( this );
        about.add(About);


//exit
        JMenu exit= new JMenu("Exit");
        exit.setForeground(Color.black);
        mb.add(exit);

        JMenuItem Exit= new JMenuItem("Exit ");
        Exit .setBackground(Color.white);
        Exit.addActionListener(this);
        exit.add(Exit);





        setJMenuBar(mb);

        setSize(1540,850);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String sm = e.getActionCommand();
         if ( sm.equals("Exit ")){
             System.exit(15);
         } else if ( sm.equals("calculator")) {
             try{
                 Runtime.getRuntime().exec("calc.exe");

             }catch (Exception E){
                 E.printStackTrace();
             }
         } else if (sm.equals("notepad")) {
             try{
                 Runtime.getRuntime().exec ( "notepad.exe" );
             } catch ( Exception E ) {
                 E.printStackTrace ( );
             }

         } else if (sm.equals ( "New faculty information" )) {
             new AddFaculty ();

         } else if (sm.equals ( "New Student information" )) {
             new Addstudent ();


         } else if (sm.equals ( "  View Faculty Details" )) {
             new Facultydetails ();

         } else if (sm.equals (" View student Details")) {
             new StudentDetails ();

         } else if (sm.equals ( "faculty leave" )) {
             new FacultyLeave ();

         } else if (sm.equals ( "student leave" )) {
             new StudentLeave ();
         } else if (sm.equals ( "faculty leave details" )) {
             new FacultyLeavedetails ();


         } else if (sm.equals ( "student leave details" )) {
             new StudentLeavedetails ();

         } else if (sm.equals ("faculty Update Details "  )) {
             new UpdateFaculty ();

         } else if (sm.equals ( "student Update Details" )) {
             new StudentUpdate ();

         } else if (sm.equals ( "enter marks" )) {
             new EnterMarks ();


         } else if (sm.equals ("examination result" )) {
             new ExaminationDetails ();

         } else if (sm.equals ( "fee  structure " )) {
             new FeeStructure ();

         } else if (sm.equals ( "student fee from" )) {
             new FEEform ();

         } else if (sm.equals ( "About " )) {
             new about ();
         }

    }

    public static void main(String[] args) {
        new main_class ();

    }
}
