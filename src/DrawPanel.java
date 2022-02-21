import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JComponent{

    // Just a single image, TODO: Generalize
    BufferedImage volvoImage;
    BufferedImage saab95Image;
    BufferedImage scaniaImage;
    // To keep track of a single cars position
    /*Point volvoPoint = new Point();
    Point saab95Point = new Point();
    Point scaniaPoint = new Point();*/

    CarController cc;

    // TODO: Make this general for all cars
    void moveit(int x, int y){

        //saab95Point.x = x;
        //saab95Point.y = y;
        //scaniaPoint.x = x;
        //scaniaPoint.y = y;
    }



    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        // this.cc = cc;
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        // Print an error message in case file is not found with a try/catch block
        try {
            volvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
            saab95Image = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg"));
            scaniaImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg"));
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for(int i = 0; i < cc.getCarImagesList().size(); i++){
            g.drawImage(cc.getCarImagesList().get(i).getImage(), (int)cc.getCarImagesList().get(i).getX(), (int)cc.getCarImagesList().get(i).getY(), null); // see javadoc for more info on the parameters
        }
    }
}
