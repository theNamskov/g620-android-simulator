import java.awt.*;
import java.awt.geom.*;
import java.util.Random;

import javax.swing.*;

public class WidgetCallCard extends JPanel {
    private static final long serialVersionUID = 1L;

    AppDefault tmp = new AppDefault();
    Random rn = new Random();
    public String displayName;
    public String displayNumber;
    public String displayTimeStamp;
    public Icon displayIcon;
    public JButton callNumberButton;
    public JLabel nameLabel = new JLabel();
    public JLabel numberLabel = new JLabel();
    public JLabel timestampLabel = new JLabel();

    public int width = (int) (0.92 * tmp.panelWidth);
    public int height = (int) (0.14 * tmp.contentPaneH);
    public int iconX = (int) (width * 0.05);
    public int iconY = (int) (height * 0.1);
    public int iconSize = (int) (height * 0.8);
    int gutterX = 10, gutterY = 7;
    int labelX = iconX + iconSize + gutterX;
    int nameY = iconY + (int) (iconSize * 0.14);
    int nameW = (int) (width * 0.6), nameH = (int) (height * 0.2);
    int numberY = nameY + nameH + gutterY, numberW = nameW, numberH = (int) (nameH * 0.8);
    int timestampY = numberY + numberH + (int) (gutterY * 0.85);
    int timestampH = (int) (numberH * 0.6), timestampW = (int) (numberW * 0.5);
    public Color displayIconBgColor = new Color(rn.nextInt(150), rn.nextInt(150), rn.nextInt(150), 120);

    public WidgetCallCard(String displayName, String displayNumber, String displayTimeStamp, Icon displayIcon) {
        this.displayName = displayName;
        this.displayNumber = displayNumber;
        this.displayTimeStamp = displayTimeStamp;
        this.displayIcon = displayIcon;
        setLayout(null);
        setBackground(new Color(0, 0, 0, 0));

        nameLabel.setText(displayName);
        nameLabel.setFont(new Font("Lato", 0, 18));
        nameLabel.setForeground(Color.WHITE);
        numberLabel.setText(displayNumber);
        numberLabel.setFont(new Font("Lato", 0, 14));
        numberLabel.setForeground(Color.WHITE);
        timestampLabel.setText(displayTimeStamp);
        timestampLabel.setFont(new Font("Lato", 0, 8));

        nameLabel.setBounds(labelX, nameY, nameW, nameH);
        numberLabel.setBounds(labelX, numberY, numberW, numberH);
        timestampLabel.setBounds(labelX, timestampY, timestampW, timestampH);
        timestampLabel.setForeground(tmp.navColor);

        add(nameLabel);
        add(numberLabel);
        add(timestampLabel);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        RoundRectangle2D borders = new RoundRectangle2D.Float(2, 1, width - 2, height - 2, 10, 10);
        g2.setColor(new Color(33, 55, 77, 110));
        g2.fill(borders);

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
}