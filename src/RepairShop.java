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

    /**
     * Loads the chosen car into the repair shop if the maximum hasn't been breached and they're within reasonable range.
     * @param carLoading the car that is being loaded
     */
    public void load(T carLoading){
        if (carsInShop.size() < maximumCars && comparePositions(carLoading)){
            carsInShop.add(carLoading);
        }
    }

    /**
     * Removes a car from the Repair Shop
     * @param carUnloading the car that is being unloaded and removed
     */
    public void unload(T carUnloading) {
        if (carsInShop.contains(carUnloading)) {
           carsInShop.remove(carUnloading);
        }
    }
}
