
package electricity.billing.system;
import javax.swing.*;
import java.awt.*;
//runnable inside whatever abstract method we have to override else make your class as abstract(but no objections can be created)
public class Splash extends JFrame implements Runnable {
    Thread t;
    Splash(){
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/elect.jpg"));
        Image i2 = i1.getImage().getScaledInstance(730, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);
        setVisible(true); //user should see frame first
        //multithreading sleep funtion code execution stops for that time
        int x=1;
        for (int i=3; i<600; i+=4, x+=1){
            setSize(i+x, i); //frame of this dim, top-left by default origin
            setLocation(700-((i+x)/2), 440-(i/2));
              try{
                  Thread.sleep(5);
                }catch(Exception e){
                    e.printStackTrace();
                }
        }
        t = new Thread(this);
        t.start(); //start internally calls run
        setVisible(true);
        
    }
    public void run(){
        try{
            Thread.sleep(7000);
            setVisible(false);
            new login();
            //login
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        new Splash();
    }
    
}
