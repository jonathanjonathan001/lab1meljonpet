import java.awt.*;

public class ScaniaVisualizer extends CarVisualizer {

    private static final String filePath = "pics/Scania.jpg";


    public ScaniaVisualizer (Car car){
        super(filePath, new Point((int)car.getxPosition(), (int)car.getyPosition()));
    }

}