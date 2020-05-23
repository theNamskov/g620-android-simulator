package simulator.phone.apps.phone;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.geom.*;

import simulator.phone.apps.AppPanel;;


public class Phone extends AppPanel {
    private static final long serialVersionUID = 1L;

    JPanel logs, dial, favs, pagenav;
    public int pagenavY, pagenavH, pagenavW, pagenavColumn,
        pagenavBtnAlignY,
        dialPaneY, dialPaneH;
    
    String dialTitle = "dial",
           logsTitle = "logs",
           favsTitle = "favs",
           dialIcon = "dial-default",
           logsIcon = "logs-default",
           favsIcon = "favs-default";

    ButtonGroup navGroup;

    SelectedIndicatorPane indicatorPane;
    Rectangle selectedIndicator;

    //  Constructor
    public Phone(Dimension size) {
        super(size);

        init();
    }

    void init() {
        pagenavY = (int) (panelHeight * 0.87);
        pagenavW = panelWidth;
        pagenavH = navPaneY - pagenavY;
        pagenavColumn = (int) (pagenavW * 0.2);
        
        dialPaneY = (int) (panelHeight*0.05);
        dialPaneH = panelHeight - (dialPaneY + navPaneH + pagenavH);
        DialPane dialPane = new DialPane(new Dimension(panelWidth, dialPaneH), dialPaneY);
        add(dialPane.getScrollPane());

        pagenav = new JPanel();
        pagenav.setLayout(null);
        pagenav.setBounds(0, pagenavY, pagenavW, pagenavH);

        indicatorPane = new SelectedIndicatorPane();
        pagenav.add(indicatorPane);

        JButton dialButton = addPageNavButton(dialTitle, new ImageIcon(AppPanel.class.getResource(iconsHeadPath+dialIcon+png)), 0),
        logsButton = addPageNavButton(logsTitle, new ImageIcon(AppPanel.class.getResource(iconsHeadPath+logsIcon+png)), pagenavColumn*2),
        favsButton = addPageNavButton(favsTitle, new ImageIcon(AppPanel.class.getResource(iconsHeadPath+favsIcon+png)), pagenavColumn*4);

        add(pagenav);

        
    }

    JButton addPageNavButton(String title, ImageIcon icon, int posX) {
        JButton navBtn = new JButton(new SwitchAction(title, icon));
        navBtn.setFocusPainted(false);
        navBtn.setContentAreaFilled(false);
        navBtn.setBorderPainted(false);
        navBtn.setBounds(posX, (int)(pagenavH*0.1), pagenavColumn, (int)(pagenavH*0.9));

        pagenav.add(navBtn);

        return navBtn;
    }

    private class SwitchAction extends AbstractAction {
        String paneTitle;
        JButton focusedButton;
        int buttonNumber;

        //  Constructor
        SwitchAction(String paneTitle, ImageIcon icon) {
            this.paneTitle = paneTitle;
            putValue(Action.SHORT_DESCRIPTION, paneTitle);
            putValue(Action.SMALL_ICON, icon);
        }

        public void actionPerformed(ActionEvent event) {
            focusedButton = (JButton) (event.getSource());
            indicatorPane.navigate(focusedButton.getBounds(selectedIndicator));
        }
    }

    private class SelectedIndicatorPane extends JPanel {
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
            g.fillRect(x, 0, paneWidth, paneHeight);
        }

        void navigate(Rectangle indicator) {
            x = indicator.x;
            this.repaint();
        }
    }
}