import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
import java.awt.event.*;

public class PhoneAppCall extends JPanel {
    private static final long serialVersionUID = 1L;

    AppDefault tmp = new AppDefault();
    int w = tmp.panelWidth, h = tmp.panelHeight;
    WidgetCallerDetails callDetails = new WidgetCallerDetails();
    JLabel callLoading = new JLabel();
    Icon muteDef = tmp.getIcon("mute"), muteSel = tmp.getIcon("mute-selected"), keypadDef = tmp.getIcon("dial"),
            speakerDef = tmp.getIcon("speaker"), speakerSel = tmp.getIcon("speaker-selected"),
            addCallDef = tmp.getIcon("add-call"), holdDef = tmp.getIcon("hold"), endCallIcon = tmp.getIcon("end-call");
    JButton mute = createCallAction("mute", muteDef, muteSel), keypad = createCallAction("dial", keypadDef, keypadDef),
            speaker = createCallAction("speaker", speakerDef, speakerSel),
            addCall = createCallAction("Add call", addCallDef, addCallDef),
            hold = createCallAction("hold", holdDef, holdDef);
    GridLayout gLayout = new GridLayout(2, 3);
    JPanel callActions = new JPanel();
    JButton endCallButton = new JButton(endCallIcon);

    public PhoneAppCall() {
        setLayout(null);
        setBackground(tmp.navColor);

        callLoading.setOpaque(false);
        callLoading.setForeground(Color.white);
        callLoading.setFont(new Font("Lato", Font.PLAIN, 12));
        callLoading.setText("Calling...");
        callLoading.setBounds((int) (w * 0.35), (int) (h * 0.23), (int) (w * 0.29), (int) (h * 0.04));
        callLoading.setHorizontalAlignment(JLabel.CENTER);
        add(callLoading);

        callDetails.setOpaque(false);
        callDetails.setBounds(0, 2, w, (int) (h * 0.2));
        add(callDetails);

        addCall.setEnabled(false);
        hold.setEnabled(false);

        callActions.setLayout(gLayout);
        callActions.setBounds(0, (int) (h * 0.4), w, (int) (h * 0.3));
        callActions.add(mute);
        callActions.add(keypad);
        callActions.add(speaker);
        callActions.add(addCall);
        callActions.add(hold);
        callActions.setOpaque(false);

        add(callActions);

        endCallButton.setBounds((int) (w * 0.4), (int) (h * 0.88), 45, 45);
        endCallButton.setContentAreaFilled(false);
        endCallButton.setBorderPainted(false);
        endCallButton.setOpaque(false);
        endCallButton.setFocusable(false);

        add(endCallButton);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        Ellipse2D endCallBg = new Ellipse2D.Double(w * 0.4, h * 0.88, 45, 45);
        g2.setColor(Color.RED);
        g2.fill(endCallBg);

    }

    class ActivateAction extends AbstractAction {
        private static final long serialVersionUID = 1L;

        boolean toggleIcon = false;
        Icon defaultIcon, selectedIcon;

        public ActivateAction(String actionName, Icon defaultIcon, Icon selectedIcon) {
            this.defaultIcon = defaultIcon;
            this.selectedIcon = selectedIcon;
            putValue(Action.SMALL_ICON, defaultIcon);
            putValue(Action.SHORT_DESCRIPTION, actionName);
        }

        @Override
        public void actionPerformed(ActionEvent event) {
            toggleIcon = !toggleIcon;
            if (toggleIcon)
                putValue(Action.SMALL_ICON, selectedIcon);
            else
                putValue(Action.SMALL_ICON, defaultIcon);
        }
    }

    public JButton createCallAction(String actionName, Icon defaultIcon, Icon selectedIcon) {
        AbstractAction action = new ActivateAction(actionName, defaultIcon, selectedIcon);
        JButton btn = new JButton(action);
        btn.setOpaque(false);
        btn.setContentAreaFilled(false);
        btn.setBorderPainted(false);
        btn.setFocusable(false);

        return btn;
    }

    public void setNumber(String phoneNum) {
        callDetails.setPhoneNumber(phoneNum);
    }

    public JButton terminate() {
        return endCallButton;
    }
}