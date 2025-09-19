package student.management.system;

import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame implements Runnable {

     final Thread t;

    Splash () {


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/harsh.jpeg") );
        Image i2 = i1.getImage().getScaledInstance(1000, 500, Image.SCALE_DEFAULT  );
        ImageIcon i3 = new ImageIcon(i2);
         JLabel img =new JLabel(i3);
        add(img);
         t = new Thread(this);
        t.start();

        setVisible(true);
        int x =1;
        for ( int i = 2;i<= 500;i+=4,x+=1){
            setLocation( 300 -(( 1 + x)/1),50 -( i/10));
            setSize( i+ 5*x,i+x/1);
            try{
                Thread.sleep(10);
            } catch (Exception e){
                e.printStackTrace() ;
            }
        }
    }

   


    public void run (){
        try{
            Thread .sleep( 7000) ;
            setVisible( false) ;
            new login();

        }catch (Exception e){
            e.printStackTrace() ;
        }
    }
    public static void main (String[] args){
        new Splash();
    }
}

