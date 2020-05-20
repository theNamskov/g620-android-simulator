package simulator.phone.apps;

import java.awt.*;
import javax.swing.*;
import java.io.File;


public class AppPanel extends JPanel {
    private static final long serialVersionUID = 1L;

    int beginX = 50, beginY = 400,
        initWidth = 10, initHeight = 30,
        panelWidth, panelHeight,
        navPaneY;
    Dimension size;

    JPanel navigationPane;
    JButton backButton, homeButton;

    String iconsHeadPath = "../../../asset/img/icons/";
    String navLeft = "navleft", navHome = "navhome";
    String png = ".png";

    public AppPanel(Dimension size) {
        super();
        this.size = size;

        setLayout(null);
        setBackground(new Color(210, 211, 211));
        panelWidth = size.width; panelHeight = size.height;
        setBounds(0, 0, panelWidth, panelHeight);

        File directory = new File("../");
        System.out.println(directory.getAbsolutePath());

        System.out.println("Width: "+panelWidth);
        System.out.println("Height: "+panelHeight);

        backButton = makeNavButton(new ImageIcon(getClass().getResource(iconsHeadPath+navLeft+png)), "Left");
        homeButton = makeNavButton(new ImageIcon(getClass().getResource(iconsHeadPath+navHome+png)), "Center");

        navigationPane = new JPanel();
        navPaneY = (int)(panelHeight*0.96);
        navigationPane.setBounds(0, navPaneY, panelWidth, panelHeight-navPaneY);
        navigationPane.setBackground(new Color(33, 55, 77));
        navigationPane.setLayout(new BorderLayout());

        add(navigationPane);

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    public JButton makeNavButton(Icon icon, String position) {
        JButton btn = new JButton(icon);
        navigationPane.add(btn, position);
        return btn;
    }
}