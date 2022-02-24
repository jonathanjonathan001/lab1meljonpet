import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public abstract class CarVisualizer {
    BufferedImage image;
    final Point point;

    public CarVisualizer(String imagePath, Point point) {
        try {
            this.image = ImageIO.read(DrawPanel.class.getResourceAsStream(imagePath));
        } catch (IOException ex) {
            ex.printStackTrace();
            this.image = null;
        }
        this.point = point;
    }

    public BufferedImage getImage() {
        return image;
    }

    public Point getPoint() {
        double x = point.getX();
        double y = point.getY();
        return new Point((int) x, (int) y);
    }

    public double getX() {
        return point.getX();
    }

    public double getY() {
        return point.getY();
    }

    public int getImageWidth(){
        return image.getWidth();
    }

}
