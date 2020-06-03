import java.awt.*;
import java.util.*;
import javax.swing.*;

public class PhoneAppLogs extends JPanel {
    private static final long serialVersionUID = 1L;

    private AppDefault tmp = new AppDefault();
    int widgetWidth = (int) (tmp.panelWidth * 0.92);
    int widgetHeight = 80, gap = 5;
    ArrayList<WidgetCallCard> widgets;
    PhoneAppDB middleware = new PhoneAppDB();
    // JPanel w1 = new WidgetCallCard("Francisca", "+233 26 222 1123", "Today",
    // null);
    // JPanel w2 = new WidgetCallCard("Samuel", "+233 57 122 2333", "Today", null);
    // JPanel w3 = new WidgetCallCard("Ahornam", "+233 24 333 4445", "Today", null);
    // JPanel w4 = new WidgetCallCard("Madam Gifty", "+233 26 222 1123", "Today",
    // null);
    // JPanel w5 = new WidgetCallCard("L3trician", "+233 57 122 2333", "Today",
    // null);
    // JPanel w6 = new WidgetCallCard("Jumia", "+233 24 333 4445", "Today", null);
    // JPanel w7 = new WidgetCallCard("Danielle", "+233 57 122 2333", "Today",
    // null);
    // JPanel w8 = new WidgetCallCard("Unknown", "+233 24 333 4445", "Today", null);
    JLabel header = new JLabel();

    public PhoneAppLogs(String title) {
        setLayout(null);

        header.setText(title);
        header.setFont(new Font("Lato", Font.BOLD, 28));
        header.setForeground(Color.darkGray);
        header.setBounds(4, 2, tmp.panelWidth, 30);

        // w1.setBounds(4, 40, widgetWidth, widgetHeight);
        // w2.setBounds(4, 125, widgetWidth, widgetHeight);
        // w3.setBounds(4, 210, widgetWidth, widgetHeight);
        // w4.setBounds(4, 295, widgetWidth, widgetHeight);
        // w5.setBounds(4, 380, widgetWidth, widgetHeight);
        // w6.setBounds(4, 465, widgetWidth, widgetHeight);
        // w7.setBounds(4, 550, widgetWidth, widgetHeight);
        // w8.setBounds(4, 635, widgetWidth, widgetHeight);

        add(header);

        getWidgets();
        // add(w1);
        // add(w2);
        // add(w3);
        // add(w4);
        // add(w5);
        // add(w6);
        // add(w7);
        // add(w8);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setPreferredSize(new Dimension(tmp.panelWidth, 20 + ((widgetHeight + 7) * widgets.size())));
    }

    public void getWidgets() {
        widgets = middleware.getFullLogsDetails();
        render();
    }

    public void render() {
        int x = 4, y = 40;
        for (WidgetCallCard widget : widgets) {
            widget.setBounds(x, y, widgetWidth, widgetHeight);
            add(widget);
            y += widgetHeight + gap;
        }
    }
}