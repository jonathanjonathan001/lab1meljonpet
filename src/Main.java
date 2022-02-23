import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;


public class Main {

    private final static int CAR_OFFSET = 100;
    private final static int delay = 50;

    static List<Car> cars = new ArrayList<>();
    static List<Car> trucks = new ArrayList<>();
    static List<Car> saab95s = new ArrayList<>();

   // private static List<CarVisualizer> carVisualizerList = new ArrayList<>();

    /*public static List<CarVisualizer> getCarVisualizerList(){
        return carVisualizerList;
    }*/

    /* public static void createCarVisualizerList(){

        Point volvo240Point = new Point((int)cars.get(0).getxPosition(),(int)cars.get(0).getyPosition());
        Volvo240Visualizer volvo240Visualizer = new Volvo240Visualizer(volvo240Point);

        Point saab95Point = new Point((int)cars.get(1).getxPosition(),(int)cars.get(1).getyPosition());
        Saab95Visualizer saab95Visualizer = new Saab95Visualizer(saab95Point);

        Point scaniaPoint = new Point((int)cars.get(2).getxPosition(),(int)cars.get(2).getyPosition());
        ScaniaVisualizer scaniaVisualizer = new ScaniaVisualizer(scaniaPoint);

        carVisualizerList.add(volvo240Visualizer);
        carVisualizerList.add(saab95Visualizer);
        carVisualizerList.add(scaniaVisualizer);
    } */

    public static void updateCarVisualizerList(){
        for (int i = 0; i < carVisualizerList.size(); i++) {
            int xPos = (int)cars.get(i).getxPosition();
            int yPos = (int)cars.get(i).getyPosition();
            carVisualizerList.get(i).setOriginPoint(new Point(xPos, yPos));
        }
    } */

    static List<DrawableObject> carImagesList = new ArrayList<>();

    public List<DrawableObject> getCarImagesList() {
        return carImagesList;
    }

    public static Point findCarPoint(Car car) {
        return new Point((int) car.getxPosition(), (int) car.getyPosition());
    }

    public static DrawableObject createDrawableObject(BufferedImage image, Car car) {
        return new DrawableObject(image, findCarPoint(car));
    }

    public static List<Car> getCars(){
        return cars;
    }
    public static List<Car> getTrucks() {return trucks;}
    public static List<Car> getSaab95s() { return saab95s; }

    static void updateCarImagesList(CarView frame) {
        carImagesList.add(createDrawableObject(frame.drawPanel.volvoImage, cars.get(0)));
        carImagesList.add(createDrawableObject(frame.drawPanel.saab95Image, cars.get(1)));
        carImagesList.add(createDrawableObject(frame.drawPanel.scaniaImage, cars.get(2)));
    }

    private static List<Car> makeSublistOfSaab95(){
        for (Car car: cars) {
            if (car.getModelName().equals("Saab95")) {
                saab95s.add(car);
            }
        }
        return saab95s;
    }

    private static List<Car> makeSublistOfTrucks(){
        for (Car car: cars) {
            if (car.getCarType() == Car.TypeOfCar.TRUCK) {
                trucks.add(car);
            }
        }
        return trucks;
    }

    public static void init() {

        Volvo240 volvo240 = CarFactory.createVolvo240();
        Saab95 saab95 = CarFactory.createSaab95();
        Scania scania = CarFactory.createScania();

        cars.add(volvo240);
        cars.add(saab95);
        cars.add(scania);

        List<Car> trucks = makeSublistOfTrucks();
        List<Car> saab95s = makeSublistOfSaab95();

        cars.get(0).setyPosition(0 * CAR_OFFSET);
        cars.get(1).setyPosition(1 * CAR_OFFSET);
        cars.get(2).setyPosition(2 * CAR_OFFSET);

        createCarVisualizerList();

        carImagesList.add(createDrawableObject(frame.drawPanel.volvoImage, cars.get(0)));
        carImagesList.add(createDrawableObject(frame.drawPanel.saab95Image, cars.get(1)));
        carImagesList.add(createDrawableObject(frame.drawPanel.scaniaImage, cars.get(2)));
    }

    public static void main(String[] args) {
        // Instance of this class

        init();

        CarController cc = new CarController();

        // Start a new view and send a reference of self
        CarView frame = new CarView("CarSim 1.0", cc);
        Timer timer = new Timer(delay, new TimerListener(frame));

        // Start the timer
        timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    private static class TimerListener implements ActionListener {

        private CarView frame;

        public TimerListener (CarView frame){
            this.frame = frame;
        }

        public void actionPerformed(ActionEvent e) {
            for (Car car : cars) {
                int carImageWidth = frame.drawPanel.volvoImage.getWidth();
                if (car.getxPosition() > (frame.getFrameX() - carImageWidth) || car.getxPosition() < 0) {
                    car.turnLeft();
                    car.turnLeft();
                }
                car.move();
                int x = (int) Math.round(car.getxPosition());
                int y = (int) Math.round(car.getyPosition());


                updateCarVisualizerList();
           /*     carImagesList.clear();
                updateCarImagesList(frame);*/

                // frame.drawPanel.moveit(x, y);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
        }
    }
}
