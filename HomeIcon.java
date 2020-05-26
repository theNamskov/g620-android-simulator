import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;


public class HomeIcon extends JPanel {
    private static final long serialVersionUID = 1L;

    private JButton button = new JButton();
    private ImageIcon icon;
    private int x, y, width, height;
    private Color iconBg = new Color(55, 55, 55), trnsprnt = new Color(0, 0, 0, 0);

    public HomeIcon(ImageIcon icon) {
        this.icon = icon;
        button.setIcon(this.icon);

        setLayout(new BorderLayout());
        setBackground(trnsprnt);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setFocusable(false);
        button.setSize(50, 50);
        add(button, BorderLayout.CENTER);

        g2.setColor(iconBg);

        width = getWidth();
        height = getHeight();
        x = (int) (0.04 * width);
        y = (int) (0.018 * height);

        g2.fill( new Ellipse2D.Double(x, y, (int)(0.72 * width), (int)(0.77 * height)) );
        revalidate();
    }

    public JButton getButton() {
        return button;
    }
}