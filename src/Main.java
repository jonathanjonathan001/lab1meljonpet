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
    static List<Car> volvo240s = new ArrayList<>();

    static List<CarVisualizer> carVisualizerList = new ArrayList<>();


    public static List<CarVisualizer> getCarVisualizerList() {
        return carVisualizerList;
    }

    public static Point findCarPoint(Car car) {
        return new Point((int) car.getxPosition(), (int) car.getyPosition());
    }



    public static List<Car> getCars(){
        return cars;
    }

    public static List<Car> getTrucks() {
        return trucks;
    }

    public static List<Car> getSaab95s() {
        return saab95s;
    }

    public static List<Car> getVolvo240s() {
        return volvo240s;
    }

    static void updateCarVisualizerList() {
        for (Car saab95: saab95s) {
            carVisualizerList.add(new Saab95Visualizer(saab95));
        }

        for (Car volvo240 : volvo240s) {
            carVisualizerList.add(new Volvo240Visualizer(volvo240));
        }

        for (Car scania: trucks) {
            carVisualizerList.add(new ScaniaVisualizer(scania));
        }
    }

    public static void init(CarView frame) {

        Volvo240 volvo240 = CarFactory.createVolvo240();
        Saab95 saab95 = CarFactory.createSaab95();
        Scania scania = CarFactory.createScania();

        cars.add(volvo240);
        cars.add(saab95);
        cars.add(scania);

        trucks.add(scania);
        saab95s.add(saab95);
        volvo240s.add(volvo240);

        setCarOffsets();

        carImagesList.add(createDrawableObject(frame.drawPanel.volvoImage, cars.get(0)));
        carImagesList.add(createDrawableObject(frame.drawPanel.saab95Image, cars.get(1)));
        carImagesList.add(createDrawableObject(frame.drawPanel.scaniaImage, cars.get(2)));
    }

    public static void main(String[] args) {
        // Instance of this class


        CarController cc = new CarController();

        cc.initButtons();


        // Start a new view and send a reference of self
        CarView frame = new CarView("CarSim 1.0", new Buttons(cc), cc);
        Timer timer = new Timer(delay, new TimerListener(frame));

        cc.addObserver(frame.buttons);

        init(frame);
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


                //    updateCarVisualizerList();
               // carImagesList.clear();
                updateCarVisualizerList();

                // frame.drawPanel.moveit(x, y);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
        }
    }
}
