// import java.util.*;
import javax.swing.*;

class MouseFrame extends JFrame {

    public MouseFrame() {
        MouseComponent drawingCanvas = new MouseComponent();
        // JButton resetButton = new JButton("Reset");
        // resetButton.addActionListener(event -> drawingCanvas.squares = new ArrayList<>());
        // add(resetButton);
        add(drawingCanvas);
    }
}