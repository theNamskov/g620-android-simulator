import java.awt.*;
import javax.swing.*;

public class PhoneAppLogs extends JPanel {
    private static final long serialVersionUID = 1L;

    private AppDefault tmp = new AppDefault();
    JPanel w1 = new WidgetCallCard("Ahornam", "0575847961", "Thurs", null);
    JPanel w2 = new WidgetCallCard("Ehornam", "0575847961", "Thurs", null);
    JPanel w3 = new WidgetCallCard("Ihornam", "0575847961", "Thurs", null);

    public PhoneAppLogs() {
        setLayout(null);
        w1.setBounds(3, 4, 150, 100);
        w2.setBounds(3, 120, 150, 100);
        w3.setBounds(3, 250, 150, 100);

        add(w1);
        add(w2);
        add(w3);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setPreferredSize(new Dimension(tmp.panelWidth, tmp.contentPaneH + 5));
    }
}