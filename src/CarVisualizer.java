import javax.lang.model.util.Elements;
import java.awt.*;

public abstract class CarVisualizer {
    
    Point originPoint;


    public abstract String getFilePath();

    public abstract Point getOriginPoint();

    public void setOriginPoint(Point newPoint){
        originPoint = newPoint;
    }
}
