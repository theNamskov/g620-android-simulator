import java.awt.*;
import javax.swing.*;

class ButtonFrame extends JFrame {

    Toolkit kit = Toolkit.getDefaultToolkit();
    Dimension screenSize = kit.getScreenSize();

    final int DEFAULT_WIDTH = (int) (screenSize.width / 1.4);
    final int DEFAULT_HEIGHT = (int) (screenSize.height / 1.4);

    JPanel buttonPanel = new JPanel();

    public ButtonFrame() {

        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        JButton redButton = makeButton("Red Button", Color.RED),
                yellowButton = makeButton("Yellow Button", Color.YELLOW),
                greenButton = makeButton("Green Button", Color.GREEN);

        buttonPanel.add(redButton);
        buttonPanel.add(yellowButton);
        buttonPanel.add(greenButton);

        add(buttonPanel);
    }

    private JButton makeButton(String buttonLabel, Color backgroundColor) {
        JButton button = new JButton(buttonLabel);
        button.addActionListener(event -> buttonPanel.setBackground(backgroundColor));

        return button;
    }

}