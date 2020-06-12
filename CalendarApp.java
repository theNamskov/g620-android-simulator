
import com.toedter.calendar.JCalendar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

//import com.toedter.calendar.JCalendar;


public class CalendarApp extends AppDefault {
    private static final long serialVersionUID = 1L;

    JPanel test = new JPanel();
    JPanel panel=new JPanel();
    JPanel panel1=new JPanel();
    JButton button1=new JButton();
    JButton jbtnSet=new JButton("day");
    JButton jbtnGet=new JButton();
    Calendar var1 = Calendar.getInstance();
    JCalendar Datechoos=new JCalendar(var1.getTime());
    JTextField jtxtGetdate=new JTextField();
    dayChooser day = new dayChooser();
    realDaychooser lay=new realDaychooser();




    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        test.setBounds(0, 0, panelWidth, contentPaneH);
        test.setBackground(new Color(218, 129, 191, 200));
        test.setLayout(null);
        add(test);
        //setContentPane(test);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setLocationRelativeTo(null);
        Datechoos.setBounds(0,30,255,350);
        // Datechoos.setDecorationBackgroundVisible(true);
        //Datechoos.setVisible(true);



        test.add(Datechoos);

        //test.add(panel);
        test.add(jtxtGetdate);
        test.add(button1);
        test.add(jbtnSet);
        test.add(jbtnGet);
        GetDate();
        //navAction(JPanel app);


        button1.setText("agender");
        button1.setBounds(2,470,100,60);


        button1.addActionListener(event -> {

            test.removeAll();
            test.revalidate();
            test.repaint();

            test.setBounds(0, 0, panelWidth, contentPaneH);
            test.setLayout(null);
            day.setBounds(0, 0, panelWidth, contentPaneH);
            add(test);
            test.add(day);
            revalidate();
        });

       // button1.addActionListener(event -> navAction(new dayChooser()));

        jbtnSet.setText("day");
        jbtnSet.setBounds(150,470,100,60);

        jbtnSet.addActionListener(event -> {
            test.removeAll();
            test.revalidate();
            test.repaint();

            test.setBounds(0, 0, panelWidth, contentPaneH);
            test.setLayout(null);
             lay.setBounds(0, 0, 400, 400);
             add(test);
             test.add(lay);

            //revalidate();
        });

            jbtnGet.setText("click to set");
            jbtnGet.setBounds(2,0,70,28);
            jtxtGetdate.setBounds(80,0,70,30);

            revalidate();





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


}