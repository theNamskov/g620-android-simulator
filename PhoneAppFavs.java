import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class PhoneAppFavs extends JPanel {
    private static final long serialVersionUID = 1L;

    private AppDefault tmp = new AppDefault();
    int w = (int) (tmp.panelWidth * 0.92), h = tmp.contentPaneH;
    JLabel noFavsLabel = new JLabel();
    JLabel noFavsText = new JLabel("Quite lonely in here");
    JLabel header = new JLabel();
    JButton addFavsButton = new JButton(tmp.getIcon("add"));
    int labelX = (int) (w * 0.32);
    int iconsW = (int) (w * 0.34);
    int noFavsLabelY = (int) (h * 0.22), noFavsLabelH = (int) (h * 0.2);
    int gutterY = 10;
    int noFavsTextY = noFavsLabelY + noFavsLabelH, noFavsTextH = 30;
    int addFavsButtonY = noFavsTextY + noFavsTextH + (4 * gutterY), addFavsButtonH = (int) (noFavsLabelH * 0.9);

    public PhoneAppFavs(String title) {
        setLayout(null);
        setBackground(Color.lightGray.brighter().brighter().brighter());

        header.setFont(new Font("Lato", Font.BOLD, 28));
        header.setForeground(Color.darkGray);
        header.setBounds(4, 2, tmp.panelWidth, 30);
        header.setText(title);

        noFavsText.setFont(new Font("Lato", 0, 12));
        noFavsText.setForeground(Color.GRAY);
        noFavsText.setBounds((int) (labelX * 0.7), noFavsTextY, (int) (w * 0.8), noFavsTextH);
        noFavsText.setIcon(tmp.getIcon("lone"));

        noFavsLabel.setIcon(tmp.getIcon("no-favs"));
        noFavsLabel.setBounds(labelX, noFavsLabelY, iconsW, noFavsLabelH);

        addFavsButton.setOpaque(false);
        addFavsButton.setFocusable(false);
        addFavsButton.setBorderPainted(false);
        addFavsButton.setContentAreaFilled(false);
        addFavsButton.setBounds(labelX, addFavsButtonY, iconsW, iconsW);

        add(header);
        add(noFavsText);
        add(noFavsLabel);
        add(addFavsButton);

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        Ellipse2D addBg = new Ellipse2D.Double(labelX + 10, addFavsButtonY + 10, (int) (iconsW * 0.8),
                (int) (iconsW * 0.8));
        g2.setColor(tmp.navColor);
        g2.fill(addBg);

    }

}