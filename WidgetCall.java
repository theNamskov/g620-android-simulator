import java.awt.*;
import javax.swing.*;

public class WidgetCall extends JFrame {
    private static final long serialVersionUID = 1L;

    AppDefault tmp = new AppDefault();
    PhoneAppCall callPane = new PhoneAppCall();

    public WidgetCall(String phoneNum, Point location) {
        System.out.println(location);
        callPane.setSize(tmp.panelWidth, tmp.panelHeight);
        callPane.setNumber(phoneNum);
        callPane.terminate().addActionListener(e -> dispose());

        setUndecorated(true);
        setAlwaysOnTop(true);
        setLocation(location);
        setSize(tmp.panelWidth - 5, tmp.panelHeight);
        add(callPane);

        setVisible(true);
    }

}