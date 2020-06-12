import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JDayChooser;
import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;


public class realDaychooser extends AppDefault{
    private JPanel jpCalender;
    //private JPanel cld;

    // private JButton dayButton;
    //JDateChooser Datechoo=new JDateChooser();
    //Calendar var1 = Calendar.getInstance();
    JDayChooser Datechoos = new JDayChooser();
   // addDate date=new addDate();
    JPanel cld  = new JPanel();


    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        cld.setBounds(0, 0, panelWidth, contentPaneH);
        Datechoos.setBounds(4,4,350,350);
        //date.setBounds(4,365,300,30);
        add(cld);
        cld.add(Datechoos);
        //cld.add(date);




        //add(cld);


        setVisible(true);
        //setSize(300,300);


    }


}




