import java.util.ArrayList;
import java.util.List;

public class RepairShop<T extends Car> {


    private int maximumCars;
    List<T> carsInShop;
    private double xPosition = 0;
    private double yPosition = 0;


    public RepairShop (int maximumCars) {
        this.maximumCars = maximumCars;
        this.carsInShop = new ArrayList<>();
    }

    boolean comparePositions(T compareCar){
        boolean checkX = Math.abs(compareCar.getxPosition() - xPosition) <= 10;
        boolean checkY = Math.abs(compareCar.getyPosition() - yPosition) <= 10;
        return checkX && checkY;
    }


    public void load(T carLoading){
        if (carsInShop.size() < maximumCars && comparePositions(carLoading)){
            carsInShop.add(carLoading);
        }
    }

    public void unLoad(int index) {

    }
}
