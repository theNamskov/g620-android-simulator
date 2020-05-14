import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;


public class PhonePreset extends PhonePresetWithNoWallpaper{
    // Define custom colors
    private Color BACKGROUND = new Color(255,255,255);

    private BufferedImage samsung;

    public PhonePreset(){
        setBackground(BACKGROUND);
        // Load samsung image
        try{
            samsung = ImageIO.read(new File("./images/samsung.png"));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        // Draw Wallpaper design











        // Get width and height of panel
        int width = getWidth();
        int height = getHeight();

        // Draw samsung image on panel
        g.drawImage(samsung, 0, 0, width, height, this);

    }
}