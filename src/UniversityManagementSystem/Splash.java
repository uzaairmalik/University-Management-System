package UniversityManagementSystem;

import java.awt.Image;
import javax.swing.*;

public class Splash extends JFrame implements Runnable {
    
    Thread t;

    Splash() {
        // Load the image and scale it
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);

        // Initialize and start the thread
        t = new Thread(this);
        t.start();

        // Set initial frame visibility
        setVisible(true);

        // Animate the frame size and position
        int x = 1;
        for (int i = 2; i <= 500; i += 4, x++) {
            setLocation(500 - ((i - x) / 2), 300 - (i / 2));
            setSize(i + 3 * x, i + x / 2);
            try {
                Thread.sleep(10);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        try {
            // Keep the splash screen visible for 7 seconds
            Thread.sleep(7000);
            setVisible(false);
            // Proceed to the next frame (e.g., main application window)
            new LogIn();
            // new MainFrame(); // Uncomment this line to open the main application window
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Splash();
    }
}
