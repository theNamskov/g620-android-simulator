import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
import java.util.concurrent.ThreadLocalRandom;
import java.time.*;
import java.time.format.*;

class HomeScreen extends JPanel {

    public Dimension size, panelSize;
    int panelHeight, panelWidth;
    String wallpaperHeadPath = "asset/img/wallpaper/bg";
    String iconHeadPath = "asset/img/icon/";
    String jpg = ".jpg", png = ".png";
    String wallpaperPath = wallpaperHeadPath + "11" + jpg;
    Image wallpaper;
    JButton clock;
    String time;
    String phone = "phone", contacts = "contacts", messaging = "messaging", calendar = "calendar";
    int iconGutter = 10, iconSize = 54;
    JPanel application;

    public HomeScreen(Dimension size) {
        setLayout(null);
        this.size = size;
        panelHeight = (int) (size.height * 0.89) + 2;
        panelWidth = (int) (size.width * 0.92);
        setBounds(10, 39, panelWidth, panelHeight);
        setBackground(new Color(250, 250, 250, 200));
        wallpaper = new ImageIcon(getClass().getResource(wallpaperPath)).getImage();

        panelSize = new Dimension(panelWidth, panelHeight);

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

        int phoneX = 23, iconAlignY = 502;
        HomeIcon phoneIcon = new HomeIcon(new ImageIcon(getClass().getResource(iconHeadPath+phone+png)), phoneX, iconAlignY);
        phoneIcon.getButton().addActionListener(event -> resolveApplication(phone, panelSize));

        int messagingX = phoneX+iconSize+iconGutter;
        HomeIcon messagingIcon = new HomeIcon(new ImageIcon(getClass().getResource(iconHeadPath+messaging+png)), messagingX, iconAlignY);
        messagingIcon.getButton().addActionListener(event -> resolveApplication(messaging, panelSize));

        int calendarX = messagingX+iconSize+iconGutter;
        HomeIcon calendarIcon = new HomeIcon(new ImageIcon(getClass().getResource(iconHeadPath+calendar+png)), calendarX, iconAlignY);
        calendarIcon.getButton().addActionListener(event -> resolveApplication(calendar, panelSize));

        int contactsX = calendarX+iconSize+iconGutter;
        HomeIcon contactsIcon = new HomeIcon(new ImageIcon(getClass().getResource(iconHeadPath+contacts+png)), contactsX, iconAlignY);
        contactsIcon.getButton().addActionListener(event -> resolveApplication(contacts, panelSize));


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

    public void paintComponent(Graphics g) {
        g.drawImage(wallpaper, 0, 0, null);

        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(new Color(240, 240, 240));

        int phoneBgX = 21, bgAlignY = 498;
        Rectangle2D bgFrame1 = new Rectangle2D.Double(phoneBgX, bgAlignY, iconSize, iconSize);
        Ellipse2D iconBg1 = new Ellipse2D.Double();
        iconBg1.setFrame(bgFrame1);
        g2.fill(iconBg1);

        int messagingBgX = phoneBgX+iconSize+iconGutter;
        Rectangle2D bgFrame2 = new Rectangle2D.Double(messagingBgX, bgAlignY, iconSize, iconSize);
        Ellipse2D iconBg2 = new Ellipse2D.Double();
        iconBg2.setFrame(bgFrame2);
        g2.fill(iconBg2);

        int calendarBgX = messagingBgX+iconSize+iconGutter;
        Rectangle2D bgFrame3 = new Rectangle2D.Double(calendarBgX, bgAlignY, iconSize, iconSize);
        Ellipse2D iconBg3 = new Ellipse2D.Double();
        iconBg3.setFrame(bgFrame3);
        g2.fill(iconBg3);

        int contactsBgX = calendarBgX+iconSize+iconGutter;
        Rectangle2D bgFrame4 = new Rectangle2D.Double(contactsBgX, bgAlignY, iconSize, iconSize);
        Ellipse2D iconBg4 = new Ellipse2D.Double();
        iconBg4.setFrame(bgFrame4);
        g2.fill(iconBg4);

        new HomeScreen(size);
    }

    void resolveApplication(String app, Dimension size) {
        if(app.equalsIgnoreCase("calendar")) application = new Calendar(size);
        else if(app.equalsIgnoreCase("phone")) application = new Phone(size);
        else if(app.equalsIgnoreCase("messaging")) application = new Messaging(size);
        else if (app.equalsIgnoreCase("contacts")) application = new Contacts(size);
        else application = new AppPanel(size);

        removeAll();
        add(application);
        repaint();
    }
}