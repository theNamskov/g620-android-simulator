import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class PhoneAppDial extends JPanel {
    private static final long serialVersionUID = 1L;

    private AppDefault tmp = new AppDefault();
    Color dialColor = tmp.navColor;
    private int pagenavH = tmp.navPaneY - (int) (tmp.panelHeight*0.87);
    private int suggestionH, w = tmp.panelWidth, h = tmp.contentPaneH - pagenavH, 
            dialY = suggestionH = (int)(0.51*h), dialH = (int) (0.49 * h);
    public JButton numberField = new JButton();
    private Dial dialpane = new Dial();
    String iconsHeadPath = tmp.iconsHeadPath, png = tmp.png;
    Icon callIcon = new ImageIcon(PhoneFrame.class.getResource(iconsHeadPath+"call-icon"+png)),
         bkspIcon = new ImageIcon(PhoneFrame.class.getResource(iconsHeadPath+"backspace"+png));
    JButton callButton = new JButton(new CallAction(callIcon));
    JButton backspace = new JButton(new EraseAction(bkspIcon));
    JPanel numPanel = new JPanel();
    int numPanelH = (int) ((dialH/4)*1.03), numPanelY = 1+dialY-numPanelH;
    int numFieldW = (int)(w*0.77);
    Font lato = new Font("Lato", Font.PLAIN, 24);


    private class Dial extends JPanel {
        private static final long serialVersionUID = 1L;
        JButton one = createButton("1"), 
                    two = createButton("2"),
                    three = createButton("3"),
                    four = createButton("4"),
                    five = createButton("5"),
                    six = createButton("6"),
                    seven = createButton("7"),
                    eight = createButton("8"),
                    nine = createButton("9"),
                    star = createButton("*"),
                    zero = createButton("0"),
                    hash = createButton("#");
                    

        public Dial() {}


        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            setLayout(new GridLayout(5, 3));
            setSize(new Dimension(w, dialH));
            setBackground(new Color(0, 0, 0, 0));

            add(one); add(two); add(three); add(four);
            add(five); add(six); add(seven); add(eight);
            add(nine); add(star); add(zero); add(hash);

            callButton.setFocusPainted(false);
            callButton.setBorderPainted(false);
            callButton.setBackground(dialColor);
            callButton.setSize(w, (int) dialH/5);
            add(callButton);

        }

        public JButton createButton(String dialChar) {
            JButton btn = new JButton(dialChar);
            btn.setFocusPainted(false);
            btn.setBorder(BorderFactory
               .createMatteBorder(1, 0, 1, 1, new Color(240, 240, 240, 80)));
            btn.setBackground(dialColor);
            btn.setForeground(Color.WHITE);
            btn.setFont(new Font("Lato", Font.PLAIN, 14));
            btn.addActionListener(new InsertAction());
            return btn;
        }

        class InsertAction extends AbstractAction {
            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed(ActionEvent event) {
                JButton btn = (JButton) event.getSource();
                numberField.setText(numberField.getText()+btn.getText());
            }
        }
    }



    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setLayout(null);

        numberField.setBounds(0, numPanelY, numFieldW, numPanelH);
        numberField.setBorderPainted(false);
        numberField.setFocusable(false);
        numberField.setForeground(Color.WHITE);
        numberField.setBackground(dialColor);
        numberField.setFont(new Font("Lato", Font.PLAIN, 24));

        backspace.setBounds(numFieldW, numPanelY, (w-numFieldW), numPanelH);
        backspace.setFocusable(false);
        backspace.setBorderPainted(false);
        backspace.setBackground(dialColor);

        add(numberField); add(backspace);

        dialpane.setBounds(-1, dialY, w+1, dialH);
        add(dialpane);
        revalidate();
    }

    class CallAction extends AbstractAction {
        private static final long serialVersionUID = 1L;

        public CallAction(Icon icon) {
            putValue(Action.SMALL_ICON, icon);
            putValue(Action.SHORT_DESCRIPTION, "call number");
        }

        @Override
        public void actionPerformed(ActionEvent event) {
            // setLayout(null);
        }
    }

    class EraseAction extends AbstractAction {
        private static final long serialVersionUID = 1L;

        public EraseAction(Icon icon) {
            putValue(Action.SMALL_ICON, icon);
            putValue(Action.SHORT_DESCRIPTION, "Clear");
        }

        @Override
        public void actionPerformed(ActionEvent event) {
            String str = numberField.getText();
            if(str.length() != 0) numberField.setText(str.substring(0, str.length()-1));
        }
    }
}