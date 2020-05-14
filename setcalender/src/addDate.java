import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JDayChooser;
import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;





    class MyJ {
        public static void main(String[] args) {
            JFrame frame = new JFrame();
            frame.setSize(800, 600);
            frame.setVisible(true);
            frame.setDefaultCloseOperation(3);

            JButton addTask = new JButton("add task");
            addTask.addActionListener(event ->
            {
                new addDate();
            });

        }
    }


    public class addDate extends JPanel {
        // private JTextField jtxtGetdate;
        // private JFrame b;
        private JPanel panel;

        public addDate() {
            JPanel buttonpanel = new JPanel();
            buttonpanel.setSize(500, 500);

            JLabel label = new JLabel();
            Thread clock=new Thread(){
                public void run(){
                    try {
                        for (; ; ) {
                            Calendar cal = new GregorianCalendar();
                            int day = cal.get(Calendar.MONTH);
                            int y = cal.get(Calendar.DAY_OF_MONTH);
                            int hour = cal.get(Calendar.YEAR);
                            int second = cal.get(Calendar.SECOND);
                            int min = cal.get(Calendar.MINUTE);
                            int hou = cal.get(Calendar.HOUR);
                            Font font=new Font("Courier",Font.BOLD,22);
                            label.setFont(font);


                            label.setText("TIME" + hou + ":" + min + ":" + second + "   DATE" + day + "/" + y + "/" + hour);
                            sleep(1000);
                        }
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }

            };
            clock.start();




            label.setSize(20, 20);
            label.setLocation(10, 400);
            buttonpanel.add(label);

            add(buttonpanel);
            // setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setVisible(true);
            setSize(300, 300);
        }}



  /*  public void time() {
            JLabel label=new JLabel();
        Calendar cal = new GregorianCalendar();
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int y = cal.get(Calendar.MONTH);
        int hour = cal.get(Calendar.YEAR);
        int second = cal.get(Calendar.SECOND);
        int min = cal.get(Calendar.MINUTE);
        int hou = cal.get(Calendar.HOUR);

        label.setText("TIME" + hou + ":" + min + ":" + second + "DATE" + hour + "," + y + "," + day);


    }}*/















