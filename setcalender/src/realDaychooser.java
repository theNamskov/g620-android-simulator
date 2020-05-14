import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JDayChooser;
import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;


public class realDaychooser extends JPanel {
        private JPanel jpCalender;
        private JPanel cld;

        // private JButton dayButton;
        //JDateChooser Datechoo=new JDateChooser();
        //Calendar var1 = Calendar.getInstance();
        JDayChooser Datechoos = new JDayChooser();
        addDate date=new addDate();



        public realDaychooser() {
            JPanel cld = new JPanel();
            cld.setSize(500, 500);
            cld.add(Datechoos);
            cld.add(date);




            add(cld);


            setVisible(true);
            setSize(300,300);


        }


    }



