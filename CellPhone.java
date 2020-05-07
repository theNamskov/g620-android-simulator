 /**

 This program simulates a cellphone.

 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;

public class CellPhone extends JFrame {

    private final String WINDOW_TITLE = "CellPhone Simulation";
    private final int WINDOW_WIDTH = 200;
    private final int WINDOW_HEIGHT = 300;
    String input;


    // The following named controls will appear in our GUI

    private JPanel textPanel = new JPanel();
    private JPanel digitPanel = new JPanel();
    private JPanel buttonPanel = new JPanel();


    private JLabel displayLabel = new JLabel ("                     NOKIA ");

    private JTextField displayTextField = new JTextField(20);

    private JButton sendButton = new JButton("Send");
    private JButton clearButton = new JButton("Clear");
    private JButton endButton = new JButton(" End ");
    private JButton redialButton = new JButton("Redial");
    private JButton Button1 = new JButton("1");
    private JButton Button2 = new JButton("2");
    private JButton Button3 = new JButton("3");
    private JButton Button4 = new JButton("4");
    private JButton Button5 = new JButton("5");
    private JButton Button6 = new JButton("6");
    private JButton Button7 = new JButton("7");
    private JButton Button8 = new JButton("8");
    private JButton Button9 = new JButton("9");
    private JButton Button0 = new JButton("0");
    private JButton astrButton = new JButton("*");
    private JButton boundButton = new JButton("#");

    /** We'll use DecimalFormat later to convert the result to a String with two decimal places.
     */

    private DecimalFormat df2 = new DecimalFormat("#,###.00");

    /**
     The main method creates an instance of the cellphone class, which displays
     its window on the screen.
     */

    public static void main(String[] args) {
        new CellPhone();
    }

    /**
     The constructor for this application will initialize the JFrame
     by setting the window title bar, giving the frame a size,
     initializing all the controls that appear on the frame, and
     then make it visible.
     */
    public CellPhone()
    {

        setTitle(WINDOW_TITLE);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        buildTextPanel();
        buildButtonPanel();
        buildDigitPanel();
        setLayout(new BorderLayout());
        add(textPanel,BorderLayout.NORTH);
        add(buttonPanel,BorderLayout.CENTER);
        add(digitPanel,BorderLayout.SOUTH);
        clearDisplay();
        setVisible(true);

    }

    /**
     The buildTextPanel method creates a panel to hold the label and the textfield.
     */
    public void buildTextPanel () {
        textPanel.setLayout(new BorderLayout());
        textPanel.add(displayLabel,BorderLayout.NORTH);
        textPanel.add(displayTextField,BorderLayout.CENTER);
        textPanel.setBackground(Color.RED);
    }

    /**
     The buildButtonPanel method creates a panel to hold the send,clear,end and redial buttons.
     */
    public void buildButtonPanel () {
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(sendButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(endButton);
        buttonPanel.add(redialButton);
        sendButton.addActionListener(new SendButtonListener());
        clearButton.addActionListener(new ClearButtonListener());
        endButton.addActionListener(new EndButtonListener());
        redialButton.addActionListener(new RedialButtonListener());
        buttonPanel.setBackground(Color.RED);
    }

    /**
     The buildDigitPanel method creates a panel to hold the digit buttons.
     */
    public void buildDigitPanel () {
        digitPanel.setLayout(new GridLayout(4,3));
        digitPanel.add(Button1);
        digitPanel.add(Button2);
        digitPanel.add(Button3);
        digitPanel.add(Button4);
        digitPanel.add(Button5);
        digitPanel.add(Button6);
        digitPanel.add(Button7);
        digitPanel.add(Button8);
        digitPanel.add(Button9);
        digitPanel.add(astrButton);
        digitPanel.add(Button0);
        digitPanel.add(boundButton);

/** create innerlistener to all buttons, then add all buttons to
 this listener.
 */

        InnerListener listener= new InnerListener();
        Button1.addActionListener(listener);
        Button2.addActionListener(listener);
        Button3.addActionListener(listener);
        Button4.addActionListener(listener);
        Button5.addActionListener(listener);
        Button6.addActionListener(listener);
        Button7.addActionListener(listener);
        Button8.addActionListener(listener);
        Button9.addActionListener(listener);
        Button0.addActionListener(listener);
        astrButton.addActionListener(listener);
        boundButton.addActionListener(listener);
    }



    /**
     SendButtonListener is an action listener class for
     the Send button.
     */

    private class SendButtonListener implements ActionListener {
        /**
         The actionPerformed method executes when the user clicks on the send button.
         @param e The event object.
         */

        public void actionPerformed(ActionEvent e) {

            input= displayTextField.getText();
            sendCalling();

        }
    }

    /**
     ClearButtonListener is an action listener class for
     the Clear button.
     */

    private class ClearButtonListener implements ActionListener {

        /**
         The actionPerformed method executes when the user clicks on the clear button.
         @param e The event object.
         */

        public void actionPerformed(ActionEvent e) {

            clearDisplay();
        }
    }

    /**
     EndButtonListener is an action listener class for the Exit button.
     */

    private class EndButtonListener implements ActionListener {
        /**
         The actionPerformed method executes when the user clicks on the end button.
         @param e The event object.
         */

        public void actionPerformed(ActionEvent e) {

            endCalling();
        }
    }

    private class RedialButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            input= displayTextField.getText();
            redialCalling();
        }
    }


    /**
     The clearDisplay method will clear the digit,send,end and redial fields.
     */

    public void clearDisplay() {
        displayTextField.setText(" ");

    }

    /**
     The sendCalling method will dislay a message when calling.
     */
    public void sendCalling() {
        displayTextField.setText("Calling " + input+ input+ input+ "-" + input+ input+input+ "-" +input+ input+ input+ input);

    }
    /**
     The endCalling method will dislay a message when call is ended.
     */
    public void endCalling() {
        displayTextField.setText("Call Ended");

    }
    /**
     The redialCalling method will dislay a message when number is redialing.
     */
    public void redialCalling() {
        displayTextField.setText("Redialing " + input+ input+ input+ "-" + input+ input+input+ "-" + input+ input+ input+ input );

    }



    private class InnerListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==Button1) {
                displayTextField.setText("1");
            }
            else if (e.getSource()==Button2) {
                displayTextField.setText("2");
            }
            else if (e.getSource()==Button3) {
                displayTextField.setText("3");
            }
            else if (e.getSource()==Button4) {
                displayTextField.setText("4");
            }
            else if (e.getSource()==Button5) {
                displayTextField.setText("5");
            }
            else if (e.getSource()==Button6) {
                displayTextField.setText("6");
            }
            else if (e.getSource()==Button7) {
                displayTextField.setText("7");
            }
            else if (e.getSource()==Button8) {
                displayTextField.setText("8");
            }
            else if (e.getSource()==Button9) {
                displayTextField.setText("9");
            }
            else if (e.getSource()==Button0) {
                displayTextField.setText("0");
            }
            else if (e.getSource()==astrButton) {
                displayTextField.setText("*");
            }
            else if (e.getSource()==boundButton) {
                displayTextField.setText("#");
            }

        }
    }
}

