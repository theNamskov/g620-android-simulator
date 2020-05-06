import java.awt.*;
import javax.swing.*;

public class GuiTest {

    static final int CLOSE = 3;

    static Image icon = new ImageIcon("barca-logo.png").getImage();

    static String title = "Barcelona Team Formation";


    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame TestGui = new JFrame();
            TestGui.setIconImage(icon);
            TestGui.setTitle(title);
            TestGui.setDefaultCloseOperation(CLOSE);
            TestGui.add(new Gui());
            TestGui.setLocationByPlatform(true);
            TestGui.setVisible(true);
            TestGui.pack();
        });
        
    }
}











































// import java.awt.*;

// import javax.swing.*;

// public class GuiTest {
//     private static final int CLOSE = 3;

//     private static Toolkit kit = Toolkit.getDefaultToolkit();
//     private static Dimension screenSize = kit.getScreenSize();
//     private static int screenWidth = screenSize.width;
//     private static int screenHeight = screenSize.height;

//     private static final int DEFAULT_WIDTH = screenWidth / 2;
//     private static final int DEFAULT_HEIGHT = screenHeight / 2;

//     private static Image icon = new ImageIcon("barca-logo.png").getImage();

//     private static String title = "Barcelona Team Formation";

//     public static void main(String[] args) {
//         EventQueue.invokeLater(() -> {
            
//             JFrame TestGui = new JFrame();
//             TestGui.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
//             TestGui.setLocationByPlatform(true);
//             TestGui.setIconImage(icon);
//             TestGui.setTitle(title);
//             TestGui.setDefaultCloseOperation(CLOSE);
//             TestGui.add(new Gui());
//             TestGui.setVisible(true);
//         });
//     }
// }