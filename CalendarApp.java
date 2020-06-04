import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class CalendarApp extends AppDefault {
    private static final long serialVersionUID = 1L;

    JPanel test = new JPanel();

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        test.setBounds(0, 0, panelWidth, contentPaneH);
        test.setBackground(new Color(218, 129, 191, 200));
        add(test);
    }
}