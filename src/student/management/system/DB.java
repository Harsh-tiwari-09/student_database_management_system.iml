package student.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DB {

    Connection connection ;
    Statement statement ;




    DB(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

             connection = DriverManager.getConnection("jdbc:mysql:///studentdbm", "root", "Harshit&09");
            statement = connection.createStatement();

        } catch (Exception e) {
            e.printStackTrace() ;
        }
    }
}
