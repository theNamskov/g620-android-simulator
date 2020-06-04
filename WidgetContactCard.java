import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.geom.*;

public class WidgetContactCard extends JPanel {
    private static final long serialVersionUID = 1L;

    AppDefault tmp = new AppDefault();
    Random rn = new Random();
    public String phoneNumber;
    public String displayName;
    public Icon userIcon;
    public int w = (int) (0.9 * tmp.panelWidth), h = (int) (0.11 * tmp.panelHeight);
    public int iconX = (int) (w * 0.05);
    public int iconY = (int) (h * 0.1);
    public int iconSize = (int) (h * 0.8);
    public int gutter = 10;
    public int labelX = iconX + iconSize + gutter;
    public int nameY = iconY + 2;
    public int nameH = (int) (h * 0.3);
    public int numberY = nameY + nameH + 2;
    public int numberH = (int) (nameH * 0.89);
    public int labelW = w - labelX - 3;

    public JLabel nameLabel = new JLabel();
    public JLabel numberLabel = new JLabel();
    public Color displayIconBgColor = new Color(rn.nextInt(150), rn.nextInt(150), rn.nextInt(150), 120);

    public WidgetContactCard(String phoneNumber, String displayName, Icon userIcon) {
        setLayout(null);
        setBackground(new Color(0, 0, 0, 0));

        this.phoneNumber = phoneNumber;
        this.displayName = displayName;
        this.userIcon = userIcon;

        nameLabel.setText(this.displayName);
        nameLabel.setFont(new Font("Lato", Font.PLAIN, 18));
        nameLabel.setBounds(labelX, nameY, labelW, nameH);
        nameLabel.setForeground(Color.WHITE);

        numberLabel.setText(this.phoneNumber);
        numberLabel.setFont(new Font("Lato", Font.PLAIN, 12));
        numberLabel.setBounds(labelX, numberY, labelW, numberH);
        numberLabel.setForeground(Color.WHITE);

        add(nameLabel);
        add(numberLabel);

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        RoundRectangle2D borders = new RoundRectangle2D.Float(2, 1, w - 2, w - 2, 10, 10);
        g2.setColor(new Color(33, 55, 77, 110));
        g2.fill(borders);

        Ellipse2D displayIconBg = new Ellipse2D.Double(iconX, iconY, iconSize, iconSize);
        g2.setColor(displayIconBgColor);
        g2.fill(displayIconBg);
        g.setColor(Color.darkGray);
        g2.setFont(new Font("Lato", 0, 30));
        g2.drawString("" + displayName.charAt(0), iconX + (int) (iconSize / 3), iconY + (int) (0.6 * iconSize));
    }
}