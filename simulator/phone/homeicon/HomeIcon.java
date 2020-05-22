package simulator.phone.homeicon;

import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;


public class HomeIcon extends JPanel {
    private static final long serialVersionUID = 1L;

    Color iconBg = new Color(180, 185, 181, 70), nullifier = new Color(0,0,0,0);
    JButton btn;
    int locX, locY, iconSize;
    int iconPos, btnPos, btnSize;

    public HomeIcon(Icon icon, int locX, int locY, int iconSize) {
        super();

        this.locX = locX;
        this.locY = locY;
        this.iconSize = iconSize;

        setLayout(null);
        setBounds(locX, locY, this.iconSize, this.iconSize);
        setBackground(nullifier);
        // setBorder(null);

        iconPos = (int) (this.iconSize*0.05);
        JPanel btnPanel = new BackgroundPanel(iconPos, this.iconSize);
        btnPanel.setLayout(null);     

        btn = new JButton(icon);
        btn.setBorderPainted(false);
        btn.setOpaque(false);
        btn.setContentAreaFilled(false);
        btn.setFocusable(false);
        btnPos = (int) (iconSize*0.01);
        btnSize = (int) (iconSize*0.9);
        btn.setBounds(btnPos, btnPos, btnSize, btnSize);

        btnPanel.add(btn);

        add(btnPanel);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    public JButton getButton() {
        return btn;
    }
}

class BackgroundPanel extends JPanel {
    int iconPosition, iconSize;
    BackgroundPanel(int iconPos, int iconSize) {
        super();

        this.iconPosition = iconPos;
        this.iconSize = (int) (iconSize*0.8);
        setBounds(iconPosition, iconPosition, iconSize, iconSize);
        setBackground(new Color(0,0,0,0));
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(new Color(230, 240, 250, 210));
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        Rectangle2D bgFrame = new Rectangle2D.Double(iconPosition, iconPosition, iconSize, iconSize);
        Ellipse2D iconBgRound = new Ellipse2D.Double();
        iconBgRound.setFrame(bgFrame);
        g2.draw(iconBgRound);
        g2.fill(iconBgRound);
    }
}