import java.awt.*;
import javax.swing.*;


public class PhoneAppLogs extends JPanel {
    private static final long serialVersionUID = 1L;

    private AppDefault tmp = new AppDefault();

    public PhoneAppLogs() {
        setLayout(new BorderLayout());
        add(new JButton(getClass().getSimpleName()));
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setPreferredSize(new Dimension(tmp.panelWidth, tmp.contentPaneH+5));
    }
}