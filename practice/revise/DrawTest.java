import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;


public class DrawTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new DrawFrame();
            frame.setTitle("Draw Test");
            frame.setDefaultCloseOperation(3);
            frame.setVisible(true);
        });
    }
}

class DrawFrame extends JFrame {
    public DrawFrame() {
        add(new DrawComponent());
        pack();
    }
}

class DrawComponent extends JComponent {

    public void paintComponent(Graphics g) {
        final int DEFAULT_WIDTH = (int) getWidth()/2;
        final int DEFAULT_HEIGHT = (int) getHeight()/2;

        Graphics2D g2 = (Graphics2D) g;

        Point2D rectPT = new Point2D.Double(DEFAULT_WIDTH * 0.2, DEFAULT_HEIGHT * 0.3);
        int width = (int) (DEFAULT_WIDTH * 0.7 * 2);
        int height = (int) (DEFAULT_HEIGHT * 0.6 * 2);
        Point2D rectEnd = new Point2D.Double(rectPT.getX() + width, rectPT.getY() + height);

        Rectangle2D rect = new Rectangle2D.Double();
        rect.setFrameFromDiagonal(rectPT, rectEnd);
        g2.setPaint(Color.CYAN);
        g2.fill(rect);
        // g2.draw(rect);

        Ellipse2D ellipse = new Ellipse2D.Double();
        ellipse.setFrame(rect);
        g2.setPaint(Color.DARK_GRAY);
        g2.fill(ellipse);

        g2.setPaint(Color.PINK);
        g2.draw(new Line2D.Double(rectPT, rectEnd));

        Double centerX = rect.getCenterX();
        Double centerY = rect.getCenterY();
        Point2D center = new Point2D.Double(centerX, centerY);
        double radius = DEFAULT_WIDTH * 0.7;

        Ellipse2D circle = new Ellipse2D.Double();
        circle.setFrameFromCenter(centerX, centerY, centerX + radius, centerY + radius);
        g2.setPaint(Color.MAGENTA);
        g2.fill(circle);
        // g2.draw(circle);
    }

    public Dimension getPreferredSize() {
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        return screenSize;
    }
}