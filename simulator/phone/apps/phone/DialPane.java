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
        for(int i = 0; i < 150; i++) {
            btn = new JButton("hello "+i);
            btn.setBounds(2, i*5, 150, 3);
            panel.add(btn);
        }
        scrollPane = new JScrollPane(panel);
        scrollPane.setBounds(0, locY, size.width+10, size.height-2);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
    }

    public JPanel getPanel() {
        return panel;
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

}