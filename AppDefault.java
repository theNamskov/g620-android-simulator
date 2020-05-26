import java.awt.*;
import javax.swing.*;


public class AppDefault extends JPanel {
    private static final long serialVersionUID = 1L;
    private Image img = new ImageIcon(PhoneFrame.class.getResource("asset/frame/nokia-frame2.png")).getImage();
    public int panelWidth = (int)(0.92 * img.getWidth(null)),
               panelHeight = (int) (0.895 * img.getHeight(null)),
               navPaneY = (int)(0.96 * panelHeight),
               navButtonsAlignY = (int) ((panelHeight-navPaneY)*0.15),
               navPaneH = panelHeight-navPaneY,
               contentPaneH = panelHeight - navPaneH;
    private JPanel navigationPane = new JPanel();
    JButton backButton, homeButton;
    private int backButtonPosX = (int)(panelWidth*.08),
                homeButtonPosX = (int)(panelWidth*.46);
    public String iconsHeadPath = "asset/img/icon/", png = ".png";
    private String navLeft = "navleft", navHome = "navhome";
    private ImageIcon backIcon = new ImageIcon(PhoneFrame.class.getResource(iconsHeadPath+navLeft+png)),
                      homeIcon = new ImageIcon(PhoneFrame.class.getResource(iconsHeadPath+navHome+png));
    public Color navColor = new Color(33, 55, 77);
    JPanel navApp;

    public AppDefault() {

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        setLayout(null);
        setBackground(new Color(0, 0, 0, 0));

        navigationPane.setBounds(0, navPaneY, panelWidth, navPaneH);
        navigationPane.setBackground(navColor);
        navigationPane.setLayout(null);

        backButton = makeNavButton(backIcon, backButtonPosX);
        homeButton = makeNavButton(homeIcon, homeButtonPosX);
        homeButton.addActionListener(event -> navAction(new HomeScreen()));

        add(navigationPane);
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

    public void navAction(JPanel app) {
        HomeScreen parent = (HomeScreen) this.getParent();
        parent.remove(this);
        navApp = app;
        navApp.setBounds(0, 0, panelWidth, panelHeight);
        parent.add(navApp);
        parent.repaint();
    }
}