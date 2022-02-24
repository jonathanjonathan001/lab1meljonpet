import java.awt.*;

public class Saab95Visualizer extends CarVisualizer {

    private static final String filePath = "pics/Saab95.jpg";


    public Saab95Visualizer (Car car){
        super(filePath, new Point((int)car.getxPosition(), (int)car.getyPosition()));
    }

}
