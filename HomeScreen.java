import java.awt.*;
import javax.swing.*;

import java.util.Random;
import java.time.*;
import java.time.format.*;

public class HomeScreen extends JPanel {
    private static final long serialVersionUID = 1L;

    private Image img = new ImageIcon(PhoneFrame.class.getResource("asset/frame/nokia-frame2.png")).getImage();
    private Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
    private int panelWidth = (int) (size.width * 0.9), panelHeight = (int) (size.height * 0.895);
    private JLabel clock = new JLabel();
    private String time;
    private BackgroundWallpaper background = new BackgroundWallpaper();
    private DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("hh:mm");

    private String iconHeadPath = "asset/img/icon/";
    private String phone = "phone", contacts = "contacts", messaging = "messaging", calendar = "calendar";
    private String png = ".png";
    private HomeIcon phoneIcon = new HomeIcon(new ImageIcon(PhoneFrame.class.getResource(iconHeadPath + phone + png)));
    private HomeIcon messagingIcon = new HomeIcon(
            new ImageIcon(PhoneFrame.class.getResource(iconHeadPath + messaging + png)));
    private HomeIcon calendarIcon = new HomeIcon(
            new ImageIcon(PhoneFrame.class.getResource(iconHeadPath + calendar + png)));
    private HomeIcon contactsIcon = new HomeIcon(
            new ImageIcon(PhoneFrame.class.getResource(iconHeadPath + contacts + png)));
    private int iconAlignY = 500, iconSize = 64, totalIconNum = 4, initGap = (int) (0.05 * panelWidth),
            phoneX = initGap, iconGutter = (panelWidth - ((initGap * 2) + (iconSize * totalIconNum))) / 3,
            messagingX = phoneX + iconSize + iconGutter, calendarX = messagingX + iconSize + iconGutter,
            contactsX = calendarX + iconSize + iconGutter;

    JPanel application = new AppDefault();
    AppDefault phoneApp = new PhoneApp(), messagingApp = new MessagingApp(), calendarApp = new CalendarApp(),
            contactsApp = new ContactsApp();

    public HomeScreen() {
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // clock
        time = timeFormat.format(LocalDateTime.now());
        clock.setText(time);
        clock.setFont(new Font("Lato", Font.PLAIN, 62));
        clock.setForeground(new Color(230, 240, 250, 210));
        clock.setBounds(65, 30, 200, 85);
        clock.setFocusable(false);
        clock.setOpaque(false);
        add(clock);

        // Homescreen applications
        phoneIcon.setBounds(phoneX, iconAlignY, iconSize, iconSize);
        phoneIcon.getButton().addActionListener(event -> resolveApplication(phone));
        add(phoneIcon);
        messagingIcon.setBounds(messagingX, iconAlignY, iconSize, iconSize);
        messagingIcon.getButton().addActionListener(event -> resolveApplication(messaging));
        add(messagingIcon);
        calendarIcon.setBounds(calendarX, iconAlignY, iconSize, iconSize);
        calendarIcon.getButton().addActionListener(event -> resolveApplication(calendar));
        add(calendarIcon);
        contactsIcon.setBounds(contactsX, iconAlignY, iconSize, iconSize);
        contactsIcon.getButton().addActionListener(event -> resolveApplication(contacts));
        add(contactsIcon);

        // background
        background.setBounds(0, 0, panelWidth, panelHeight);
        add(background);
    }

    void resolveApplication(String app) {
        if (app.equalsIgnoreCase(phone))
            application = phoneApp;
        else if (app.equalsIgnoreCase(messaging))
            application = messagingApp;
        else if (app.equalsIgnoreCase(calendar))
            application = calendarApp;
        else if (app.equalsIgnoreCase(contacts))
            application = contactsApp;

        removeAll();
        setLayout(null);
        application.setBounds(0, 0, panelWidth, panelHeight);
        add(application);
        repaint();
    }

}

// wallpaper background class
class BackgroundWallpaper extends JPanel {
    private static final long serialVersionUID = 1L;

    private String wallpaperHeadPath = "asset/img/wallpaper/bg";
    private String jpg = ".jpg";
    private Random rand = new Random();
    private String wallpaperPath = wallpaperHeadPath + (rand.nextInt(11) + 1) + jpg;
    private Image wallpaper = new ImageIcon(HomeScreen.class.getResource(wallpaperPath)).getImage();
    public Timer bgTimer = new Timer(12000, event -> {
        this.wallpaperPath = wallpaperHeadPath + (rand.nextInt(11) + 1) + jpg;
        this.wallpaper = new ImageIcon(HomeScreen.class.getResource(wallpaperPath)).getImage();
    });

    public BackgroundWallpaper() {
        new Timer(12000, event -> {
            this.wallpaperPath = wallpaperHeadPath + (rand.nextInt(11) + 1) + jpg;
            this.wallpaper = new ImageIcon(HomeScreen.class.getResource(wallpaperPath)).getImage();
            revalidate();
        });
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(this.wallpaper, 0, 0, null);
        bgTimer.start();
    }
}
