package simulator.phone.apps.phone;

import java.awt.*;
import javax.swing.*;
// import java.util.*;


public class DialPane {
    JPanel panel;
    JScrollPane scrollPane;
    Dimension size;
    int locY;
    JButton btn;

    public DialPane(Dimension size, int locY) {
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.BLACK);
        panel.setPreferredSize(new Dimension(size.width, size.height));
        int i;
        for(i = 1; i < 200; i++) {
            btn = new JButton("hello "+i);
            btn.setBounds(10, i*25, (int)(size.width * 0.8), 20);
            panel.add(btn);
        }
        System.out.println(i);
        panel.setPreferredSize(new Dimension(size.width, (i*25)+20));
        scrollPane = new JScrollPane(panel);
        scrollPane.setBounds(0, locY, size.width+12, size.height);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    }

    public JPanel getPanel() {
        return panel;
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

}