import java.awt.*;
import javax.swing.*;

class Main {

    public static void main(String[] args) {
            JFrame frame = new JFrame();
            PhoneFrame phonePanel = new PhoneFrame();
            Dimension frameSize = phonePanel.getSize();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new BorderLayout());
            frame.setUndecorated(true);
            frame.setSize(frameSize);
            frame.setLocationByPlatform(true);

            JPanel background = new JPanel();
            background.setBackground(new Color(50, 50, 50));
            background.add(phonePanel);

            frame.add(background);
            frame.setVisible(true);
    }
}