import java.awt.*;

public class Volvo240Visualizer extends CarVisualizer {

    private final String filePath = "pics/Volvo240.jpg";
    private Point originPoint;

    public Volvo240Visualizer (Point originPoint){
        this.originPoint = originPoint;
    }

    public String getFilePath(){
        return new String(filePath);
    }

    public Point getOriginPoint(){
        return originPoint;
    }
}
