package simulator.phone;

import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
import java.util.concurrent.ThreadLocalRandom;
import java.time.*;
import java.time.format.*;


import simulator.phone.homeicon.*;
import simulator.phone.apps.phone.Phone;
import simulator.phone.apps.messaging.Messaging;
import simulator.phone.apps.calendar.Calendar;
import simulator.phone.apps.contacts.Contacts;

public class HomeScreen extends JPanel {

    Dimension size, panelSize;
    int panelHeight, panelWidth;
    String wallpaperHeadPath = "../../asset/img/wallpaper/bg";
    String iconHeadPath = "../../asset/img/icon/";
    String jpg = ".jpg", png = ".png";
    String wallpaperPath = wallpaperHeadPath + "11" + jpg;
    Image wallpaper;
    JButton clock;
    String time;
    String phone = "phone", contacts = "contacts", messaging = "messaging", calendar = "calendar";
    int iconGutter, iconSize = 60;
    JPanel application;

    public HomeScreen(Dimension size) {
        setLayout(null);
        this.size = size;
        panelHeight = (int) (size.height * 0.89) + 2;
        panelWidth = (int) (size.width * 0.92);
        setBounds(10, 39, panelWidth, panelHeight);
        setBackground(new Color(250, 250, 250, 200));
        wallpaper = new ImageIcon(getClass().getResource(wallpaperPath)).getImage();

        this.panelSize = new Dimension(panelWidth, panelHeight);

        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("hh:mm");
        
        clock = new JButton();
        new Timer(0, event -> { time = timeFormat.format(LocalDateTime.now()); clock.setText(time); }).start();
        clock.setFont(new Font("Lato", Font.PLAIN, 62));
        clock.setForeground(new Color(230, 240, 250, 210));
        clock.setBounds(30, 30, 235, 60);
        clock.setOpaque(false);
        clock.setContentAreaFilled(false);
        clock.setBorderPainted(false);
        clock.setFocusable(false);
        add(clock);

        iconGutter = (int) (panelWidth*0.01);
        iconSize = (int) ((panelWidth-(iconGutter*4))/4);

        int phoneX = iconGutter, iconAlignY = 502;
        HomeIcon phoneIcon = new HomeIcon(new ImageIcon(HomeScreen.class.getResource(iconHeadPath+phone+png)), 
            phoneX, 
            iconAlignY, 
            iconSize
        );
        phoneIcon.getButton().addActionListener(event -> resolveApplication(phone));

        int messagingX = phoneX+iconSize+iconGutter;
        HomeIcon messagingIcon = new HomeIcon(new ImageIcon(HomeScreen.class.getResource(iconHeadPath+messaging+png)), 
            messagingX, 
            iconAlignY, 
            iconSize
        );
        messagingIcon.getButton().addActionListener(event -> resolveApplication(messaging));

        int calendarX = messagingX+iconSize+iconGutter;
        HomeIcon calendarIcon = new HomeIcon(new ImageIcon(HomeScreen.class.getResource(iconHeadPath+calendar+png)), 
            calendarX, 
            iconAlignY, 
            iconSize
        );
        calendarIcon.getButton().addActionListener(event -> resolveApplication(calendar));

        int contactsX = calendarX+iconSize+iconGutter;
        HomeIcon contactsIcon = new HomeIcon(new ImageIcon(HomeScreen.class.getResource(iconHeadPath+contacts+png)), 
            contactsX, 
            iconAlignY, 
            iconSize
        );
        contactsIcon.getButton().addActionListener(event -> resolveApplication(contacts));


        add(phoneIcon);
        add(messagingIcon);
        add(calendarIcon);
        add(contactsIcon);

        backgroundHandler();
    }

    private void backgroundHandler() {
        new Timer(12000, event -> {
            this.wallpaperPath = wallpaperHeadPath + (ThreadLocalRandom.current().nextInt(1, 11)) + jpg;
            wallpaper = new ImageIcon(getClass().getResource(wallpaperPath)).getImage();
            repaint(); 
        }).start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(wallpaper, 0, 0, null);

        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    }

    void resolveApplication(String app) {
        if(app.equalsIgnoreCase(phone)) application = new Phone(panelSize);
        else if(app.equalsIgnoreCase(messaging)) application = new Messaging(panelSize);
        else if(app.equalsIgnoreCase(calendar)) application = new Calendar(panelSize);
        else if (app.equalsIgnoreCase(contacts)) application = new Contacts(panelSize);

        removeAll();
        add(application);
        repaint();
    }

}