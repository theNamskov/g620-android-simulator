// import java.awt.*;
// import javax.swing.*;
// import java.awt.event.*;

// class ActionFrame extends JFrame {

//     Toolkit kit = Toolkit.getDefaultToolkit();
//     Dimension screenSize = kit.getScreenSize();
//     final int DEFAULT_WIDTH = (int) (screenSize.width * 0.5);
//     final int DEFAULT_HEIGHT = (int) (screenSize.height * 0.8);

//     private JPanel buttonPanel;

//     public ActionFrame() {
//         setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);import java.awt.*;
// import javax.swing.*;
// import java.awt.event.*;

// class ActionFrame extends JFrame {

//     Toolkit kit = Toolkit.getDefaultToolkit();
//     Dimension screenSize = kit.getScreenSize();
//     final int DEFAULT_WIDTH = (int) (screenSize.width * 0.5);
//     final int DEFAULT_HEIGHT = (int) (screenSize.height * 0.8);

//     private JPanel buttonPanel;

//     public ActionFrame() {
//         setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

//         buttonPanel = new JPanel();
        
//         ColorAction
//         lightGreenAction = new ColorAction(
//             "Light Green",
//             new ImageIcon("barca-logo.png"),
//             Color.green.brighter().brighter().brighter()
//         ),
//         pinkAction = new ColorAction(
//             "Pink",
//             new ImageIcon("barca-logo.png"),
//             Color.PINK
//         ),
//         brightRedAction = new ColorAction(
//             "Bright Red",
//             new ImageIcon("barca-logo.png"),
//             Color.RED.brighter().brighter().brighter()
//         );

//         buttonPanel.add(new JButton(lightGreenAction));
//         buttonPanel.add(new JButton(pinkAction));
//         buttonPanel.add(new JButton(brightRedAction));

//         add(buttonPanel);

//         InputMap imap = buttonPanel.getInputMap();
//         imap.put(KeyStroke.getKeyStroke("ctrl L"), "panel.light-green");
//         imap.put(KeyStroke.getKeyStroke("ctrl P"), "panel.pink");
//         imap.put(KeyStroke.getKeyStroke("ctrl B"), "panel.bright-red");

//         ActionMap amap = buttonPanel.getActionMap();
//         amap.put("panel.light-green", lightGreenAction);
//         amap.put("panel.pink", pinkAction);
//         amap.put("panel.bright-red", brightRedAction);

//     }

//     private class ColorAction extends AbstractAction {

//         public ColorAction(String name, Icon icon, Color color) {
//             putValue(Action.NAME, name);
//             putValue(Action.SMALL_ICON, icon);
//             putValue(Action.SHORT_DESCRIPTION, "Set panel background to " + name.toLowerCase());
//             putValue("color", color);
//         }

//         @Override
//         public void actionPerformed(ActionEvent event) {
//             Color c = (Color) getValue("color");
//             buttonPanel.setBackground(c);
//         }
//     }
// }

//         buttonPanel = new JPanel();
        
//         ColorAction
//         lightGreenAction = new ColorAction(
//             "Light Green",
//             new ImageIcon("barca-logo.png"),
//             Color.green.brighter().brighter().brighter()
//         ),
//         pinkAction = new ColorAction(
//             "Pink",
//             new ImageIcon("barca-logo.png"),
//             Color.PINK
//         ),
//         brightRedAction = new ColorAction(
//             "Bright Red",
//             new ImageIcon("barca-logo.png"),
//             Color.RED.brighter().brighter().brighter()
//         );

//         buttonPanel.add(new JButton(lightGreenAction));
//         buttonPanel.add(new JButton(pinkAction));
//         buttonPanel.add(new JButton(brightRedAction));

//         add(buttonPanel);

//         InputMap imap = buttonPanel.getInputMap();
//         imap.put(KeyStroke.getKeyStroke("ctrl L"), "panel.light-green");
//         imap.put(KeyStroke.getKeyStroke("ctrl P"), "panel.pink");
//         imap.put(KeyStroke.getKeyStroke("ctrl B"), "panel.bright-red");

//         ActionMap amap = buttonPanel.getActionMap();
//         amap.put("panel.light-green", lightGreenAction);
//         amap.put("panel.pink", pinkAction);
//         amap.put("panel.bright-red", brightRedAction);

//     }

//     private class ColorAction extends AbstractAction {

//         public ColorAction(String name, Icon icon, Color color) {
//             putValue(Action.NAME, name);
//             putValue(Action.SMALL_ICON, icon);
//             putValue(Action.SHORT_DESCRIPTION, "Set panel background to " + name.toLowerCase());
//             putValue("color", color);
//         }

//         @Override
//         public void actionPerformed(ActionEvent event) {
//             Color c = (Color) getValue("color");
//             buttonPanel.setBackground(c);
//         }
//     }
// }



































// import java.awt.*;
// import javax.swing.*;
// import java.awt.event.*;

// public class ActionFrame extends JFrame {
//     private JPanel buttonPanel;
    
//     private Toolkit kit = Toolkit.getDefaultToolkit();
//     private Dimension screenSize = kit.getScreenSize();
//     final int DEFAULT_WIDTH = (int) (screenSize.width * 0.7);
//     final int DEFAULT_HEIGHT = (int) (screenSize.height * 0.6);

//     public ActionFrame() {
//         setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

//         buttonPanel = new JPanel();

//         Action yellowAction = new ColorAction("Yellow", new ImageIcon("barca-logo.png"), Color.YELLOW);
//         Action blueAction = new ColorAction("Blue", new ImageIcon("barca-logo.png"), Color.BLUE);
//         Action redAction = new ColorAction("Red", new ImageIcon("barca-logo.png"), Color.RED);

//         buttonPanel.add(new JButton(yellowAction));
//         buttonPanel.add(new JButton(blueAction));
//         buttonPanel.add(new JButton(redAction));

//         add(buttonPanel);

//         InputMap imap = buttonPanel.getInputMap(1);
//         imap.put(KeyStroke.getKeyStroke("ctrl Y"), "panel.yellow");
//         imap.put(KeyStroke.getKeyStroke("ctrl B"), "panel.blue");
//         imap.put(KeyStroke.getKeyStroke("ctrl R"), "panel.red");

//         ActionMap amap = buttonPanel.getActionMap();
//         amap.put("panel.yellow", yellowAction);
//         amap.put("panel.blue", blueAction);
//         amap.put("panel.red", redAction);
//     }

//     public class ColorAction extends AbstractAction {
//         public ColorAction(String name, Icon icon, Color c) {
//             putValue(Action.NAME, name);
//             putValue(Action.SMALL_ICON, icon);
//             putValue(Action.SHORT_DESCRIPTION, "Set panel color to " + name.toLowerCase());
//             putValue("color", c);
//         }

//         public void actionPerformed(ActionEvent event) {
//             Color c = (Color) getValue("color");
//             buttonPanel.setBackground(c);
//         }
//     }

// }