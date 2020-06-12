import javax.swing.*;
import java.awt.*;


public class dayChooser extends AppDefault {
    // private JTextField jtxtGetdate;
    // private JFrame b;

    JButton button=new JButton();
    JTextArea area=new JTextArea(5,6);
    JLabel label=new JLabel();
    JPanel panel=new JPanel();
    JTextArea textArea1=new JTextArea();
    JButton saveButton=new JButton();
    JPanel buttonpanel=new JPanel();
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        //buttonpanel.setBounds(374,40,620,649);
        buttonpanel.setBounds(0, 0, panelWidth, contentPaneH);
        buttonpanel.setOpaque(true);
       // buttonpanel.setBackground(new Color(218, 29, 190, 200));

        label.setText("TYPE YOUR TO-DO LIST HERE");
        //label.setSize(20,20);
        // label.setLocation(10,400);
        label.setBounds(80,10,150,30);

        //area.setLocation(50,400);
        area.setBounds(10,120,270,300);


        button.setText("DONE");
        button.setBounds(80,470,100,60);
        button.setVisible(true);
        add(buttonpanel);
        buttonpanel.setLayout(null);
        buttonpanel.add(button);
        buttonpanel.add(area);
        buttonpanel.add(label);


        //add(buttonpanel);


        revalidate();
        // setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        //setVisible(true);
        //setSize(300,300);










    }
}
