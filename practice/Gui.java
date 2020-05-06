import java.awt.*;
import javax.swing.*;

class Gui extends JPanel {
    Toolkit kit = Toolkit.getDefaultToolkit();
    Dimension screenSize = kit.getScreenSize();
    int screenHeight = screenSize.height;
    int screenWidth = screenSize.width;
    final int DEFAULT_WIDTH = screenWidth/2;
    final int DEFAULT_HEIGHT = screenHeight/2;

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawString("Not a Hello World program", 75, 100);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}














































// import java.awt.*;
// import javax.swing.JPanel;;

// public class Gui extends JPanel {

//     @Override
//     public void paintComponent(Graphics g) {
//         super.paintComponent(g);

//         g.setColor( new Color(0,0,0));
//         g.drawString("Not a Hello World Program", 75, 100);
//     }
// }