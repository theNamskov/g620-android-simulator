import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class ActionFrame extends JFrame {
    Toolkit kit = Toolkit.getDefaultToolkit();
    Dimension screenSize = kit.getScreenSize();
    final int DEFAULT_WIDTH = (int) (screenSize.width / 1.5);
    final int DEFAULT_HEIGHT = (int) (screenSize.height / 1.7);

    JPanel buttonPanel;

    ActionFrame() {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        buttonPanel = new JPanel();

        ColorAction redAction = new ColorAction("red", new ImageIcon("barca-logo.png"), Color.RED.brighter().brighter().brighter()),
               yellowAction = new ColorAction("yellow", new ImageIcon("barca-logo.png"), Color.YELLOW.brighter().brighter().brighter()),
               greenAction = new ColorAction("green", new ImageIcon("barca-logo.png"), Color.green.brighter().brighter().brighter());

        buttonPanel.add(new JButton(redAction));
        buttonPanel.add(new JButton(yellowAction));
        buttonPanel.add(new JButton(greenAction));

        add(buttonPanel);

        InputMap imap = buttonPanel.getInputMap();
        imap.put(KeyStroke.getKeyStroke("R"), "panel.red");
        imap.put(KeyStroke.getKeyStroke("Y"), "panel.yellow");
        imap.put(KeyStroke.getKeyStroke("G"), "panel.green");

        ActionMap amap = buttonPanel.getActionMap();
        amap.put("panel.red", redAction);
        amap.put("panel.yellow", yellowAction);
        amap.put("panel.green", greenAction);

    }

    private class ColorAction extends AbstractAction {
        ColorAction(String name, Icon icon, Color color) {
            putValue(Action.NAME, name);
            putValue(Action.SMALL_ICON, icon);
            putValue(Action.SHORT_DESCRIPTION, "Set background color to "+name.toLowerCase());
            putValue("color", color);
        }
        
        @Override
        public void actionPerformed(ActionEvent event) {
            Color c = (Color) getValue("color");
            buttonPanel.setBackground(c);
        }
    }
}