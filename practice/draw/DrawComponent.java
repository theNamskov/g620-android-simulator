package draw;

import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;


class DrawComponent extends JComponent {

    public void paintComponent(Graphics g) {
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        final int DEFAULT_WIDTH = getWidth() / 2;
        final int DEFAULT_HEIGHT = getHeight() / 2;

        Graphics2D g2 = (Graphics2D) g;

        double leftX = DEFAULT_WIDTH * 0.05;
        double topY = DEFAULT_HEIGHT * 0.05;
        double width = DEFAULT_WIDTH * 0.95;
        double height = DEFAULT_HEIGHT * 0.95;

        Rectangle2D rect = new Rectangle2D.Double(leftX, topY, width, height);
        g2.draw(rect);

        Ellipse2D ellipse = new Ellipse2D.Double();
        ellipse.setFrame(rect);
        g2.draw(ellipse);

        g2.draw(new Line2D.Double(leftX, topY, leftX + width, topY + height));

        double centerX = rect.getCenterX();
        double centerY = rect.getCenterY();
        double radius = DEFAULT_HEIGHT / 2;

        Ellipse2D circle = new Ellipse2D.Double();
        circle.setFrameFromCenter(centerX, centerY, centerX + radius, centerY + radius);
        g2.draw(circle);
    }

    public Dimension getPreferredSize() {
        return new Dimension(300, 200);
    }
}