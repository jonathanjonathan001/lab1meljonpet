import java.awt.*;

public class ScaniaVisualizer extends CarVisualizer {

    private final String filePath = "pics/Scania.jpg";
    private Point originPoint;

    public ScaniaVisualizer (Point originPoint){
        this.originPoint = originPoint;
    }

    public String getFilePath(){
        return new String(filePath);
    }

    public Point getOriginPoint(){
        return originPoint;
    }
}