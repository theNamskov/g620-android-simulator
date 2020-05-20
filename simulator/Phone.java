import java.awt.*;
import javax.swing.*;


public class Phone extends AppPanel {
    private static final long serialVersionUID = 1L;

    JPanel recent, dial, favourites, pagenav;
    int pagenavY, pagenavH, pagenavW, 
        pagenavBtnAlignY;

    public Phone(Dimension size) {
        super(size);

        pagenavY = (int) (panelHeight * 0.87);
        pagenavH = navPaneY - pagenavY;
        pagenav = new JPanel();
        pagenav.setLayout(null);
        pagenav.setBounds(0, pagenavY, panelWidth, pagenavH);
        pagenav.setBackground(new Color(190, 255, 255));

        add(pagenav);

    }

    JButton addPageNavButton(ImageIcon icon) {
        JButton navBtn = new JButton(icon);
        navBtn.setFocusPainted(false);
        navBtn.setContentAreaFilled(false);
        navBtn.setBorderPainted(false);
        navBtn.setOpaque(false);
        // navBtn.setBounds(x, y, width, height);

        pagenav.add(navBtn);

        return navBtn;
    }
}