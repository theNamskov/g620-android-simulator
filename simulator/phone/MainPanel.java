package simulator.phone;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.geom.*;


class MainPanel extends JPanel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    Image img;
    Dimension size;
    public MainPanel() {
        configure();
        // JButton button = new JButton("Hi");
        // button.setBackground(new Color(34, 72, 190, 90));
        // button.setBounds(40, 40, 50, 20);
        // button.setBorder(BorderFactory.createBevelBorder(3));
        // button.setOpaque(false);
        // button.setContentAreaFilled(false);
        // button.setBorderPainted(false);
        // add(button);
        add(new HomeScreen(size));
    }

    public void paintComponent(Graphics g) {
        g.drawImage(img, 0, 0, null);
        Graphics2D g2 = (Graphics2D) g;
        Rectangle2D.Double rect = new Rectangle2D.Double();
        rect.setFrame(40.2, 120.2, 200, 200);
        g2.setColor(new Color(150, 220, 200, 100));
        // g2.fill(rect);
    }

    public Dimension panelSize() {
        return getSize();
    }

    private void configure() {
        img = new ImageIcon(getClass().getResource("../../asset/frame/nokia-frame2.png")).getImage();
        size = new Dimension(img.getWidth(null), img.getHeight(null));
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
        setLayout(null);
        setBackground(new Color(220, 32, 47, 100));
    }
}

class NewPanelCallback implements ActionListener {
    public void actionPerformed(ActionEvent event) {
        new MainPanel();
    }
}