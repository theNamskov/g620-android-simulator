import javax.swing.*;

public class NewWindowFrame extends JFrame{

    public NewWindowFrame(JPanel panel){
        setTitle("samsung");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(620, 650);
        setResizable(true);
        setLocationRelativeTo(null);
        add(panel);
    }
        
}