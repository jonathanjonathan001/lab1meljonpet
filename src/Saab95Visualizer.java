import java.awt.*;

public class Saab95Visualizer extends CarVisualizer {

    private final String filePath = "pics/Saab95.jpg";
    private Point originPoint;

    public Saab95Visualizer (Point originPoint){
        this.originPoint = originPoint;

    }

    public String getFilePath(){
        return new String(filePath);
    }

    public Point getOriginPoint(){
        return originPoint;
    }


}
