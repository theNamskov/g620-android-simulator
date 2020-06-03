import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
import java.util.ArrayList;
import java.util.Random;

public class WidgetCallerDetails extends JPanel {
    private static final long serialVersionUID = 1L;

    private AppDefault tmp = new AppDefault();
    public Random rn = new Random();
    public String callerID = "Unknown";
    public String phoneNumber;
    public Icon callerIcon = tmp.getIcon("unknown");
    public Color iconBgColor = new Color(rn.nextInt(220), rn.nextInt(230), rn.nextInt(240), 190);
    int width, height, iconX, iconY, iconSize;

    public JLabel nameLabel = new JLabel();
    public JLabel numberLabel = new JLabel();
    public JLabel photoItem = new JLabel();

    PhoneAppDB callDB = new PhoneAppDB();

    public WidgetCallerDetails() {

        // setCallerDetails();

        setLayout(new BorderLayout());
        setBackground(new Color(0, 0, 0, 0));

        photoItem.setHorizontalAlignment(JLabel.CENTER);
        nameLabel.setFont(new Font("Lato", 0, 22));
        nameLabel.setForeground(Color.white);
        nameLabel.setText(callerID);
        nameLabel.setHorizontalAlignment(JLabel.CENTER);
        numberLabel.setFont(new Font("Lato", 0, 18));
        numberLabel.setForeground(Color.white);
        numberLabel.setText(phoneNumber);
        numberLabel.setHorizontalAlignment(JLabel.CENTER);

        add(photoItem, BorderLayout.NORTH);
        add(nameLabel, BorderLayout.CENTER);
        add(numberLabel, BorderLayout.SOUTH);
    }

    public void setCallerDetails() {
        // DB queries go here
        ArrayList<String> callDetails = callDB.getLogData(this.phoneNumber);
        if (!callDetails.isEmpty())
            callerID = callDetails.get(0) + ' ' + callDetails.get(1);

        nameLabel.setText(callerID);
        photoItem.setIcon(callerIcon);
    }

    public void setPhoneNumber(String phoneNumber) {
        callDB.addLogData(phoneNumber, callDB.OUTGOING);
        this.phoneNumber = phoneNumber;
        numberLabel.setText(phoneNumber);
        setCallerDetails();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        width = getWidth();
        height = getHeight();
        iconX = (int) (width * 0.42);
        iconY = 0;
        iconSize = (int) (width * 0.16);

        Ellipse2D displayIconBg = new Ellipse2D.Double(iconX, iconY, iconSize, iconSize);
        g2.setColor(iconBgColor);
        g2.fill(displayIconBg);
    }
}