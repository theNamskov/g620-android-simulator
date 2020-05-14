import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;


public class HomeScreen extends PhonePreset implements ActionListener{

    // Create home screen buttons
    private JButton[] buttons = new JButton[4];
    private JButton clock = new JButton();


    // Load image files
    Icon phone = new ImageIcon(getClass().getResource("./images/icons/phone.png"));
    Icon contacts = new ImageIcon(getClass().getResource("./images/icons/contacts.png"));
    Icon calendar = new ImageIcon(getClass().getResource("./images/icons/calendar.png"));
    Icon messages = new ImageIcon(getClass().getResource("./images/icons/messages.png"));


    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        // Set layout -- remove all existing layouts
        setLayout(null);

        // Create mat for clock to on
        g.setColor(new Color(222, 42, 209, 160)); // rgba , a => transparency(alpha)
        g.fillRoundRect(180, 130, 235, 100, 30, 30);

        // Get system time
        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm");
        LocalDateTime now = LocalDateTime.now();

        String time = timeFormat.format(now);

        // Clock
        clock.setText(time);
       
        clock.setFont(new Font("Raleway", Font.PLAIN, 72));
        clock.setForeground(Color.WHITE);
        clock.setBounds(180, 125, 235, 105);

        // -- make clock button transparent
        clock.setOpaque(false);
        clock.setContentAreaFilled(false);
        clock.setBorderPainted(false);
        add(clock);
        


        // Load icons and put them buttons
        // -- instantiate buttons
        for(int i=0; i<buttons.length; i++)
            buttons[i] = new JButton();
        
        
        // - put icons in an array
        Icon[] icons = {phone, contacts, calendar, messages};

        // - attach images to buttons
        for( int i=0; i<buttons.length; i++)
            buttons[i].setIcon(icons[i]);
        
        // - make buttons background transparent
        for( int i=0; i<buttons.length; i++){
            buttons[i].setOpaque(false);
            buttons[i].setContentAreaFilled(false);
            buttons[i].setBorderPainted(false);
        }

        // Set coordinates for buttons
        int btnX = 140;
        int btnY = 450;
        int btnW = 80;
        int btnH = 65;

        // Set size of buttons and add them to panel
        for(int i=0; i<buttons.length; i++){
            buttons[i].setBounds(btnX, btnY, btnW, btnH);
            add(buttons[i]);

            // -- register listeners for buttons
            buttons[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    handleButtonClick((JButton)e.getSource());
                }
            });

            btnX += btnW;
        }

        clock.addActionListener(this);
        
    }

    // Handle clock click
    public void actionPerformed(ActionEvent e){
        System.out.println("clock");
    }

    // Handle icon clicks
    public void handleButtonClick(JButton src){
        
        if( src.getIcon() == phone ){
            System.out.println("phone");
        }

        if( src.getIcon() == contacts ){
            System.out.println("contacts");
            // Go to contacts page
            ContactsPage panel = new ContactsPage();
            NewWindowFrame frame = new NewWindowFrame(panel);
            frame.setVisible(true);
            ((JFrame) SwingUtilities.getWindowAncestor(this)).dispose();
        }

        if( src.getIcon() == calendar ){
            System.out.println("calendar");
        }

        if( src.getIcon() == messages ){
            System.out.println("messages");
        }
    }
}