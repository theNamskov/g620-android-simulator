import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class PhoneApp extends AppDefault {
    private static final long serialVersionUID = 1L;

    JPanel pagenav = new JPanel(), tmp = new JPanel();
    public int pagenavY = (int) (panelHeight * 0.87),
               pagenavH = navPaneY - pagenavY,
               pagenavW = panelWidth,
               pagenavColumn = (int) (pagenavW * 0.2),
               dialPaneY = 0,
               dialPaneH = contentPaneH;

    JPanel activePane = new PhoneAppDial();

    private SelectedIndicatorPane indicatorPane = new SelectedIndicatorPane();
    Rectangle selectedIndicator;
    JButton dialButton, logsButton, favsButton;
    String dialTitle = "dial",
           logsTitle = "logs",
           favsTitle = "favs",
           dialIcon = "dial-default",
           logsIcon = "logs-default",
           favsIcon = "favs-default";


    public PhoneApp() {}


    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // activePane.setBounds(0, 0, panelWidth+6, contentPaneH-pagenavH);
        // add(activePane);

        pagenav.setLayout(null);
        pagenav.setBounds(0, pagenavY, pagenavW, pagenavH);

        indicatorPane = new SelectedIndicatorPane();
        pagenav.add(indicatorPane);

        dialButton = addPageNavButton(dialTitle, new ImageIcon(PhoneFrame.class.getResource(iconsHeadPath+dialIcon+png)), 0);
        logsButton = addPageNavButton(logsTitle, new ImageIcon(PhoneFrame.class.getResource(iconsHeadPath+logsIcon+png)), pagenavColumn*2);
        favsButton = addPageNavButton(favsTitle, new ImageIcon(PhoneFrame.class.getResource(iconsHeadPath+favsIcon+png)), pagenavColumn*4);

        add(pagenav);

        activePane.setBounds(0, 0, panelWidth+6, 5+contentPaneH-pagenavH);
        add(activePane);
    }


    // Page navigation  buttons setup
    JButton addPageNavButton(String title, ImageIcon icon, int posX) {
        JButton navBtn = new JButton(icon);
        navBtn.setFocusPainted(false);
        navBtn.setContentAreaFilled(false);
        navBtn.setBorderPainted(false);
        navBtn.setBounds(posX, (int)(pagenavH*0.1), pagenavColumn, (int)(pagenavH*0.9));

        navBtn.addActionListener(event -> {
            JButton focusedButton = (JButton) (event.getSource());
            if(title == dialTitle) {
                activePane = new PhoneAppDial();
                indicatorPane.navigate(focusedButton.getBounds(selectedIndicator));
                add(activePane);
            }

            revalidate();
        });

        pagenav.add(navBtn);

        return navBtn;
    }



    private class SelectedIndicatorPane extends JPanel {
        private static final long serialVersionUID = 1L;
        
        int paneHeight = (int) (pagenavH * 0.1);
        int x = 0, y = 0, paneWidth = pagenavColumn;

        //  Constructor
        SelectedIndicatorPane() {
            this.setLayout(null);
            this.setBounds(0, 0, pagenavW, paneHeight);
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(navColor);
            setBackground(new Color(0,0,0,0));
            g.fillRect(x, y, paneWidth, paneHeight);
        }

        void navigate(Rectangle indicator) {
            x = indicator.x;
            this.repaint();
        }
    }
}



