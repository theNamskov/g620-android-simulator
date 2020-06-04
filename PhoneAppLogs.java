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
    JLabel header = new JLabel();

    public PhoneAppLogs(String title) {
        setLayout(null);

        header.setText(title);
        header.setFont(new Font("Lato", Font.BOLD, 28));
        header.setForeground(Color.darkGray);
        header.setBounds(4, 2, tmp.panelWidth, 30);

        add(header);

        getWidgets();
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