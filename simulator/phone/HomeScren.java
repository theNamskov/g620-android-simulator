package simulator.phone;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.concurrent.ThreadLocalRandom;
import java.time.*;
import java.time.format.*;

class HomeScreen extends JPanel {

    String wallpaperHeadPath = "../../asset/img/wallpaper/bg";
    String jpg = ".jpg";
    String wallpaperPath = wallpaperHeadPath + "11" + jpg;
    Image wallpaper;
    JButton clock;
    String time;

    public HomeScreen(Dimension size) {
        setBounds(10, 39, (int) (size.width * 0.92), (int) (size.height * 0.89));
        setBackground(new Color(250, 250, 250, 200));
        wallpaper = new ImageIcon(getClass().getResource(wallpaperPath)).getImage();


        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("hh:mm");
        LocalDateTime now = LocalDateTime.now();

        time = timeFormat.format(now);
        clock = new JButton();
        clock.setText(time);
        new Timer(0, event -> { time = timeFormat.format(LocalDateTime.now()); clock.setText(time); }).start();
        clock.setFont(new Font("Lato", Font.PLAIN, 62));
        clock.setForeground(new Color(230, 240, 250, 210));
        clock.setBounds(40, 300, 235, 105);
        clock.setOpaque(false);
        clock.setContentAreaFilled(false);
        clock.setBorderPainted(false);
        add(clock);

        backgroundHandler();
    }

    private void backgroundHandler() {
        new Timer(12000, event -> {
            this.wallpaperPath = wallpaperHeadPath + (ThreadLocalRandom.current().nextInt(1, 11)) + jpg;
            wallpaper = new ImageIcon(getClass().getResource(wallpaperPath)).getImage();
            // this.time = timeFormat.format(now); clock.setText(this.time);
            repaint(); 
        }).start();
    }

    public void paintComponent(Graphics g) {
        g.drawImage(wallpaper, 0, 0, null);
    }
}