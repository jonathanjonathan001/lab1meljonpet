import java.awt.*;

public class Volvo240Visualizer extends CarVisualizer {

    private static final String filePath = "pics/Volvo240.jpg";


    public Volvo240Visualizer (Car car){
        super(filePath, new Point((int)car.getxPosition(), (int)car.getyPosition()));
    }

}
