
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

      //  List<CarVisualizer> carImagesList = Main.carImagesList;

       /* g.drawImage(volvoImage, carVisualizerList.get(0).getOriginPoint().x, carVisualizerList.get(0).getOriginPoint().y, null);
        g.drawImage(saab95Image, carVisualizerList.get(1).getOriginPoint().x, carVisualizerList.get(1).getOriginPoint().y, null);
        g.drawImage(scaniaImage, carVisualizerList.get(2).getOriginPoint().x, carVisualizerList.get(2).getOriginPoint().y, null);*/

        for (CarVisualizer drawableObject : carVisualizerList) {
            g.drawImage(drawableObject.getImage(), (int) drawableObject.getX(), (int) drawableObject.getY(), null); // see javadoc for more info on the parameters
        }
    }
}
