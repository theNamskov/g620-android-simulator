import java.awt.*;
import javax.swing.*;

public class WidgetAddContact extends JFrame {
    private static final long serialVersionUID = 1L;

    AppDefault tmp = new AppDefault();
    ContactsAppRegister addContactPanel = new ContactsAppRegister();
    JButton close = new JButton("close");

    public WidgetAddContact(Point location) {

        // setLayout(null);

        // test.setSize(200, 40);
        // test.add(close);
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
        // setBackground(new Color(210, 120, 210, 40));
        setSize(new Dimension(tmp.panelWidth, tmp.panelHeight));
        setVisible(true);
        addContactPanel.getSaveButton().addActionListener(e -> dispose());
    }

}

// import java.awt.*;
// import javax.swing.*;

// public class WidgetAddContact extends JFrame {
// private static final long serialVersionUID = 1L;

// AppDefault tmp = new AppDefault();
// PhoneAppCall callPane = new PhoneAppCall();

// public WidgetAddContact(Point location) {
// System.out.println(location);
// callPane.setSize(tmp.panelWidth, tmp.panelHeight);
// callPane.setNumber("0244111222");
// callPane.terminate().addActionListener(e -> dispose());

// setUndecorated(true);
// setAlwaysOnTop(true);
// setLocation(location);
// setSize(tmp.panelWidth - 5, tmp.panelHeight);
// add(callPane);

// setVisible(true);
// }

// }