import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JDayChooser;
//import com.toedter.calendar.JCalendar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ContainerAdapter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class testCalender extends JFrame {
    private JPanel jpCalender;
    private JPanel jpCld;
    private JTextField jtxtGetdate;
    private JButton jbtnGet;
    private JButton jbtnSet;
    private JButton button1;
    // private JButton dayButton;
    //JDateChooser Datechoo=new JDateChooser();
    Calendar var1 = Calendar.getInstance();
    JCalendar Datechoos=new JCalendar(var1.getTime());




    public testCalender() {
        setContentPane(jpCalender);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(400, 250);


        //  Datechoo.setDateFormatString("dd/MM/yyyy");
        jpCld.add(Datechoos);
        GetDate();


        button1.addActionListener(event -> {
            dayChooser day = new dayChooser();
            JFrame frame = new JFrame();
            frame.setSize(500, 500);
            frame.setLocation(400, 200);
            frame.setDefaultCloseOperation(2);
            frame.setVisible(true);
            frame.add(day);
        });

        jbtnSet.addActionListener(event -> {
            realDaychooser day = new realDaychooser();
            JFrame frame = new JFrame();
            frame.setSize(500, 500);
            frame.setLocation(400, 200);
            frame.setDefaultCloseOperation(2);
            frame.setVisible(true);
            frame.add(day);
        });
    }






   public void GetDate() {
       jbtnGet.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               SimpleDateFormat sdfmt = new SimpleDateFormat("dd/MM/yyyy");
               String dt = sdfmt.format(Datechoos.getDate());
               jtxtGetdate.setText(dt);

           }
       });
   }









    public static void main(String[] args){
        new testCalender().setVisible(true);



    }

}
