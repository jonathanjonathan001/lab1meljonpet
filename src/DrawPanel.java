
import java.awt.*;
import java.util.List;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JComponent{



    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        // this.cc = cc;
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        List<CarVisualizer> carVisualizerList = Main.getCarVisualizerList();

        if (!carVisualizerList.isEmpty()) {
            for (CarVisualizer carVisualizer : carVisualizerList) {
                g.drawImage(carVisualizer.getImage(), (int) carVisualizer.getX(), (int) carVisualizer.getY(), null); // see javadoc for more info on the parameters
            }
        }
    }
}
