import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;


public class HomeIcon extends JPanel {
    private static final long serialVersionUID = 1L;

    Color iconBg = new Color(180, 185, 181, 70);
    JButton btn;
    int locX, locY, w = 50, h = 52;
    public HomeIcon(Icon icon, int locX, int locY) {
        super();

        this.locX = locX;
        this.locY = locY;

        setLayout(new BorderLayout());
        setBounds(locX, locY, w, h);
        setBackground(new Color(0, 0, 0, 0));

        btn = new JButton(icon);
        btn.setBorderPainted(false);
        btn.setOpaque(false);
        btn.setContentAreaFilled(false);
        btn.setFocusable(false);
        add(btn, BorderLayout.NORTH);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(this.iconBg);

        Graphics2D g2 = (Graphics2D) g;

        Rectangle2D bgFrame = new Rectangle2D.Double(locX, locY, w, h);
        Ellipse2D iconBgRound = new Ellipse2D.Double();
        iconBgRound.setFrame(bgFrame);
        g2.draw(iconBgRound);
        g2.fill(iconBgRound);
    }

    public JButton getButton() {
        return btn;
    }
}
