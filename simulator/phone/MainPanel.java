package simulator.phone;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


class MainPanel extends JPanel {

    private static final long serialVersionUID = 1L;
    Image img;
    Dimension size;
    public MainPanel() {
        configure();
        add(new HomeScreen(size));
    }

    public void paintComponent(Graphics g) {
        g.drawImage(img, 0, 0, null);
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
    }
}

class NewPanelCallback implements ActionListener {
    public void actionPerformed(ActionEvent event) {
        new MainPanel();
    }
}