package draw;

import java.awt.*;
import javax.swing.*;

public class DrawTest {
    private static final int CLOSE = 3;

    public static void main(String[] args) {
        EventQueue.invokeLater(()-> {
            JFrame frame = new DrawFrame();
            frame.setTitle("DrawTest");
            frame.setDefaultCloseOperation(CLOSE);
            frame.setVisible(true);
        });
    }
}