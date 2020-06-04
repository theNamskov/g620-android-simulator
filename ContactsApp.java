import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;

public class ContactsApp extends AppDefault {
    private static final long serialVersionUID = 1L;

    AppDefault tmp = new AppDefault();
    JPanel test = new JPanel();
    JScrollPane container;
    JLabel header = new JLabel("Contacts");
    PhoneAppDB middleware = new PhoneAppDB();
    JButton addContactButton = new JButton(tmp.getIcon("add-sm-black"));
    ArrayList<WidgetContactCard> widgets;
    int widgetWidth = (int) (0.9 * tmp.panelWidth);
    public int widgetHeight = 75;
    public int gap = 5;

    public ContactsApp() {
        setLayout(null);

        header.setBounds(4, 3, (int) (tmp.panelWidth * 0.6), 35);
        header.setFont(new Font("Lato", Font.PLAIN, 28));
        header.setForeground(Color.DARK_GRAY);

        addContactButton.setBounds((int) (0.87 * tmp.panelWidth), 8, 14, 24);
        addContactButton.setFocusable(false);
        addContactButton.setBorderPainted(false);
        addContactButton.setBackground(tmp.navColor);
        addContactButton.setContentAreaFilled(false);
        addContactButton.addActionListener(event -> {
            Point loc = this.getLocationOnScreen();
            new WidgetAddContact(loc);
        });

        test.setLayout(null);

        getWidgets();
        test.setBounds(0, 0, tmp.panelWidth, 20 + ((widgetHeight + 7) * widgets.size()));
        container = new JScrollPane(test);
        container.setPreferredSize(new Dimension(tmp.panelWidth + 4, contentPaneH - 50));
        container.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        container.setBounds(2, 50, tmp.panelWidth, contentPaneH - 50);
        container.setBorder(null);
        container.setBackground(new Color(0, 0, 0, 0));

        add(header);
        add(addContactButton);
        add(container);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    public void getWidgets() {
        widgets = middleware.getContactsData();
        render();
    }

    public void render() {
        int x = 8, y = 10;
        for (WidgetContactCard widget : widgets) {
            widget.setBounds(x, y, widgetWidth, widgetHeight);
            test.add(widget);
            y += widgetHeight + gap;
        }
    }
}