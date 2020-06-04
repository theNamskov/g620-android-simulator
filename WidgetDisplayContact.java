import java.awt.*;
import javax.swing.*;

public class WidgetDisplayContact extends JFrame {
    private static final long serialVersionUID = 1L;

    AppDefault tmp = new AppDefault();
    ContactsAppRegister addContactPanel = new ContactsAppRegister();
    JButton close = new JButton("close");

    public WidgetDisplayContact(String phoneNumber, Point location) {
        close.setBounds(tmp.panelWidth - 40, 5, 40, 40);
        close.setIcon(tmp.getIcon("close-sm"));
        close.setOpaque(false);
        close.setBorder(null);
        close.setBorderPainted(false);
        close.setContentAreaFilled(false);
        close.setFocusable(false);
        close.addActionListener(event -> dispose());
        addContactPanel.add(close);
        add(addContactPanel);

        setUndecorated(true);
        setLocation(location);
        setAlwaysOnTop(true);
        setSize(new Dimension(tmp.panelWidth - 5, tmp.panelHeight));
        setVisible(true);
        addContactPanel.getSaveButton().addActionListener(e -> dispose());
    }

}