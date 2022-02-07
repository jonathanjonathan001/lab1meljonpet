import java.awt.*;
import java.awt.image.BufferedImage;

public class DrawableObject {
    final BufferedImage image;
    final Point point;

    public DrawableObject(BufferedImage image, Point point) {
        this.point = point;
        this.image = image;
    }

    public BufferedImage getImage() {
        return image;
    }


    public Point getPoint() {
        double x = point.getX();
        double y = point.getY();
        return new Point((int)x,(int)y);
    }

    public double getX() {
        return point.getX();
    }

    public double getY() {
        return point.getY();
    }

}
