import javax.swing.*;
import java.awt.event.*;

public class ButtonFrameTest {

    public static void main(String[] args) {
        ButtonFrame frame = new ButtonFrame();
        frame.setDefaultCloseOperation(3);
        frame.setVisible(true);
        frame.setTitle("Button, Button And oh Another Button!");
        // frame.addWindowListener(new WindowAdapter() {
        //     public void windowClosing(WindowEvent e) {
        //         if(true) {
        //             System.exit(0);
        //         }
        //     }
        // });

        UIManager.LookAndFeelInfo[] infos = UIManager.getInstalledLookAndFeels();
        
        String className = infos[2].getClassName();
        try {
            UIManager.setLookAndFeel(className);
            SwingUtilities.updateComponentTreeUI(frame);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    

}