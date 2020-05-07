import com.toedter.calendar.JDateChooser;
//import com.toedter.calendar.JCalendar;

import javax.swing.*;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class testCalender extends JFrame {
    private JPanel jpCalender;
    private JPanel jpCld;
    private JTextField jtxtGetdate;
    private JButton jbtnGet;
    private JButton jbtnSet;
    Calendar var1 = Calendar.getInstance();
    JDateChooser Datechoos=new JDateChooser(var1.getTime());





    public testCalender(){
        setContentPane(jpCalender);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(400,250);

        Datechoos.setDateFormatString("dd/MM/yyyy");
        jpCld.add(Datechoos);
        GetDate();

    }

    public void GetDate(){
        jbtnGet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SimpleDateFormat sdfmt=new SimpleDateFormat("dd/MM/yyyy");
                String dt=sdfmt.format(Datechoos.getDate());
                jtxtGetdate.setText(dt);

            }
        });


        }






    public static void main(String[] args){
        new testCalender().setVisible(true);



    }

}
