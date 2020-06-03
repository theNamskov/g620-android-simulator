import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;

import org.w3c.dom.events.MouseEvent;

public class WidgetCallCard extends JPanel {
    private static final long serialVersionUID = 1L;

    AppDefault tmp = new AppDefault();
    Random rn = new Random();
    public String displayName = "Unknown";
    public String displayNumber;
    public String displayTimeStamp;
    public String callType;
    public Icon displayIcon;
    public JButton callNumberButton;
    public JLabel nameLabel = new JLabel();
    public JLabel numberLabel = new JLabel();
    public JLabel callTypeLabel = new JLabel();
    public JLabel timestampLabel = new JLabel();

    public int width = (int) (0.92 * tmp.panelWidth);
    public int height = (int) (0.14 * tmp.contentPaneH);
    public int iconX = (int) (width * 0.05);
    public int iconY = (int) (height * 0.1);
    public int iconSize = (int) (height * 0.8);
    int gutterX = 10, gutterY = 7;
    int labelX = iconX + iconSize + gutterX;
    int nameY = iconY + (int) (iconSize * 0.14);
    int nameW = (int) (width * 0.7), nameH = (int) (height * 0.204);
    int numberY = nameY + nameH + gutterY, numberW = nameW, numberH = (int) (nameH * 0.8);
    int timestampY = numberY + numberH + (int) (gutterY * 0.85);
    int timestampH = (int) (numberH * 0.6), timestampW = (int) (numberW * 0.7);
    int callTypeW = 18, callTypeH = timestampH + 10;
    public Color displayIconBgColor = new Color(rn.nextInt(150), rn.nextInt(150), rn.nextInt(150), 120);
    public Color callTypeIndicator;

    public WidgetCallCard(String displayName, String displayNumber, String displayTimeStamp, String callType,
            Icon displayIcon) {

        if (displayName != null)
            this.displayName = displayName;
        if (displayNumber != null)
            this.displayNumber = displayNumber;
        if (displayTimeStamp != null)
            this.displayTimeStamp = displayTimeStamp;
        if (displayIcon != null)
            this.displayIcon = displayIcon;
        this.callType = callType;
        setLayout(null);
        setBackground(new Color(0, 0, 0, 0));

        if (callType == "outgoing")
            callTypeIndicator = Color.BLUE.brighter().brighter().brighter();
        else if (callType == "received")
            callTypeIndicator = Color.GREEN.brighter().brighter().brighter();
        else if (callType == "missed")
            callTypeIndicator = Color.RED.brighter().brighter().brighter();

        nameLabel.setText(this.displayName);
        nameLabel.setFont(new Font("Lato", 0, 16));
        nameLabel.setForeground(Color.WHITE);
        numberLabel.setText(this.displayNumber);
        numberLabel.setFont(new Font("Lato", 0, 12));
        numberLabel.setForeground(Color.WHITE);
        timestampLabel.setText(this.displayTimeStamp);
        timestampLabel.setFont(new Font("Lato", 0, 8));
        callTypeLabel.setIcon(tmp.getIcon(this.callType));

        nameLabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                System.out.println("clicked!");
                new WidgetCall(displayNumber, tmp.custom_location);
            }
        });
        numberLabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                System.out.println("clicked!");
                new WidgetCall(displayNumber, tmp.custom_location);
            }
        });

        nameLabel.setBounds(labelX, nameY, nameW, nameH);
        numberLabel.setBounds(labelX, numberY, numberW, numberH);
        callTypeLabel.setBounds(labelX, timestampY, callTypeW, callTypeH);
        timestampLabel.setBounds(labelX + 20, timestampY + 5, timestampW, timestampH);
        timestampLabel.setForeground(tmp.navColor);

        add(nameLabel);
        add(numberLabel);
        add(callTypeLabel);
        add(timestampLabel);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        RoundRectangle2D borders = new RoundRectangle2D.Float(2, 1, width - 2, height - 2, 10, 10);
        g2.setColor(new Color(33, 55, 77, 110));
        g2.fill(borders);

        Ellipse2D callIndicator = new Ellipse2D.Double(labelX + 2, timestampY + 5, 5, 5);
        g2.setColor(callTypeIndicator);
        g2.fill(callIndicator);

        Ellipse2D displayIconBg = new Ellipse2D.Double(iconX, iconY, iconSize, iconSize);
        g2.setColor(displayIconBgColor);
        g2.fill(displayIconBg);
        g.setColor(Color.darkGray);
        g2.setFont(new Font("Lato", 0, 30));
        g2.drawString("" + displayName.charAt(0), iconX + (int) (iconSize / 3), iconY + (int) (0.6 * iconSize));
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public void setDisplayNumber(String displayNumber) {
        this.displayNumber = displayNumber;
    }

    public void setDisplayTimeStamp(String displayTimeStamp) {
        this.displayTimeStamp = displayTimeStamp;
    }

    public void setDisplayIcon(Icon displayIcon) {
        this.displayIcon = displayIcon;
    }

    class CallHandler extends MouseAdapter {
        public void mouseClicked(MouseEvent e) {
            System.out.println("clicked!");
            new WidgetCall(displayNumber, tmp.custom_location);
        }
    }
}