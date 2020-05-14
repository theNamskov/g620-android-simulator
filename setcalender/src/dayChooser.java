import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDayChooser;

import javax.swing.*;
import java.awt.*;
import java.util.Calendar;
class MyJTest {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(800, 600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(3);

        JButton addTask = new JButton("add task");
        addTask.addActionListener(event ->
        {
            new dayChooser();
        });

    }
}


public class dayChooser extends JPanel {
    // private JTextField jtxtGetdate;
   // private JFrame b;
    private JPanel panel;
    private JTextArea textArea1;
    private JButton saveButton;
    public dayChooser(){
        JPanel buttonpanel=new JPanel();
        buttonpanel.setSize(500,500);

        JLabel label=new JLabel("TYPE YOUR TO-DO LIST HERE");
        label.setSize(20,20);
        label.setLocation(10,400);
        JTextArea area=new JTextArea(5,6);
        area.setLocation(50,400);
        JButton button=new JButton("save");
        button.setLocation(60,400);
        buttonpanel.add(button);
        buttonpanel.add(area);
        buttonpanel.add(label);

        add(buttonpanel);



       // setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setVisible(true);
        setSize(300,300);









    }
}