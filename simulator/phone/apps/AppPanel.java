package simulator.phone.apps;

import java.awt.*;
import javax.swing.*;

import simulator.phone.*;

public class AppPanel extends JPanel {
    private static final long serialVersionUID = 1L;

    public int beginX = 50, beginY = 400,
            initWidth = 10, initHeight = 30,
            panelWidth, panelHeight,
            navPaneY, navButtonsAlignY;
    public Dimension size;

    JPanel navigationPane;
    JButton backButton, homeButton;

    String iconsHeadPath = "../../../asset/img/icon/";
    String navLeft = "navleft", navHome = "navhome";
    String png = ".png";

    public AppPanel(Dimension size) {
        this.size = size;

        setLayout(null);
        setBackground(new Color(210, 211, 211));
        panelWidth = size.width; panelHeight = size.height;
        setBounds(0, 0, panelWidth, panelHeight);

        navigationPane = new JPanel();
        navPaneY = (int)(panelHeight*0.96);
        navigationPane.setBounds(0, navPaneY, panelWidth, panelHeight-navPaneY);
        navigationPane.setBackground(new Color(33, 55, 77));
        navigationPane.setLayout(null);

        navButtonsAlignY = (int) ((panelHeight-navPaneY)*0.15);
        int backButtonPosX = (int) (panelWidth*.08);
        backButton = makeNavButton(new ImageIcon(AppPanel.class.getResource(iconsHeadPath+navLeft+png)), backButtonPosX);

        int homeButtonPosX = (int) (panelWidth*.45);
        homeButton = makeNavButton(new ImageIcon(AppPanel.class.getResource(iconsHeadPath+navHome+png)), homeButtonPosX);
        homeButton.addActionListener(event -> {
           JComponent parent = (JComponent)(this.getParent());
           parent.removeAll();
           JComponent grandParent = (JComponent)(parent.getParent());
           grandParent.remove(parent);
           grandParent.repaint();
           grandParent.setLayout(null);
           Dimension home = new MainPanel().size;
           grandParent.add(new HomeScreen(home));
           grandParent.repaint();
        });

        add(navigationPane);

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    public JButton makeNavButton(Icon icon, int posX) {
        JButton btn = new JButton(icon);
        btn.setContentAreaFilled(false);
        btn.setFocusable(false);
        btn.setBorderPainted(false);
        btn.setBounds(posX, navButtonsAlignY, 20, (int) ((panelHeight-navPaneY)*0.8));
        navigationPane.add(btn);

        return btn;
    }
}