package simulator.phone.homeicon;

import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
// import java.awt.event.*;


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
        // setBorder(null);

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

// public class IconButton extends JComponent {
//     private Icon icon;
//     private String tooltip;
//     private String type;
//     private String appName;
//     private JPanel application;
//     private Dimension size;

//     final String[] apps = {"contacts", "phone", "messaging", "calendar"};


//     public IconButton(String appName, String type, Icon icon, Dimension size) {
//         this.icon = icon;
//         this.appName = appName;
//         this.tooltip = "View " + this.appName + " application";
//         this.type = type;
//         this.size = size;
//     }

//     public JButton getButton() {
//         JButton btn = new JButton(new LaunchAction());
//         // btn.setBounds(40, 908, 48, 50);
//         btn.setFocusable(false);
//         btn.setContentAreaFilled(false);
//         btn.setBorderPainted(false);
//         btn.setOpaque(false);

//         return btn;
//     }

//     private class LaunchAction extends AbstractAction {

//         public LaunchAction() {
//             putValue(Action.SHORT_DESCRIPTION, tooltip);
//             putValue(Action.SMALL_ICON, icon);
//             putValue(Action.NAME, appName);
//             putValue("type", type);
//         }

//         public void actionPerformed(ActionEvent event) {
//             application = new JPanel();
//             application.setBounds(10, 39, (int) (size.width * 0.92), (int) (size.height * 0.89));
//             application.setBackground(new Color(34, 40, 22, 100));
//         }
//     }
// }