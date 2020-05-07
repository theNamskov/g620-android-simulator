
import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.geom.*;
import java.awt.event.*;

class MouseComponent extends JComponent {

    Toolkit kit = Toolkit.getDefaultToolkit();
    Dimension screenSize = kit.getScreenSize();
    final int DEFAULT_WIDTH = (int) (screenSize.width / 1.4);
    final int DEFAULT_HEIGHT = (int) (screenSize.height / 1.2);
    private static final int SIDE_LENGTH = 30;

    ArrayList<Rectangle2D> squares;
    private Rectangle2D current;

    public MouseComponent() {

        squares = new ArrayList<>();
        current = null;

        addMouseListener(new MouseHandler());
        addMouseMotionListener(new MouseMotionHandler());
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        for(Rectangle2D r : squares) {
            g2.setColor(generateRandomColor());
            g2.fill(r);
        }
    }

    public Rectangle2D find(Point2D p) {
        for(Rectangle2D r : squares) {
            if(r.contains(p)) return r;
        }

        return null;
    }

    public void add(Point2D p) {
        double x = p.getX();
        double y = p.getY();

        current = new Rectangle2D.Double(x - SIDE_LENGTH / 2, y - SIDE_LENGTH / 2, SIDE_LENGTH, SIDE_LENGTH);
        squares.add(current);
        repaint();
    }

    public void remove(Rectangle2D s) {
        if(s == null) return;
        if(s == current) current = null;
        squares.remove(s);
        repaint();
    }


    private class MouseHandler extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent event) {
            current = find(event.getPoint());
            if(current == null) add(event.getPoint());
        }

        @Override
        public void mouseClicked(MouseEvent event) {
            current = find(event.getPoint());
            if(current != null && event.getClickCount() >= 2) remove(current);
        }
    }

    private class MouseMotionHandler implements MouseMotionListener {

        @Override
        public void mouseMoved(MouseEvent event) {
            if(find(event.getPoint()) == null) setCursor(Cursor.getDefaultCursor());
            else setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
        }

        @Override
        public void mouseDragged(MouseEvent event) {
            if(current != null) {
                int x = event.getX();
                int y = event.getY();

                current.setFrame(x - SIDE_LENGTH / 2, y - SIDE_LENGTH / 2, SIDE_LENGTH, SIDE_LENGTH);
                repaint();
            }
        }
    }

    private Color generateRandomColor() {
        return new Color(
            (int) (Math.random() * 255 + 1),
            (int) (Math.random() * 255 + 1),
            (int) (Math.random() * 255 + 1),
            (int) (Math.random() * 255 + 1)
        );
    }
}