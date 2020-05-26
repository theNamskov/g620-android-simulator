import java.awt.*;
import javax.swing.*;

public class PhoneFrame extends JPanel {
    private static final long serialVersionUID = 1L;
    
    private Image img = new ImageIcon(PhoneFrame.class.getResource("asset/frame/nokia-frame2.png")).getImage();
    private Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
    private JPanel home = new HomeScreen();
    
    public PhoneFrame() {
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
        setLayout(null);
        setBackground(Color.DARK_GRAY);

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
        setLayout(null);

        g.drawImage(img, 0, 0, this);

        // home.setBackground(Color.BLACK);
        home.setBounds(15, 38, (int)(size.width*0.9), (int)(size.height*0.895));
        add(home);
    }
}