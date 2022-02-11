import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/*
 * This class represents the Controller part in the MVC pattern.
 * It's responsibilities is to listen to the View and responds in a appropriate manner by
 * modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    private final static int CAR_OFFSET = 100;


    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<Car> cars = new ArrayList<>();
    ArrayList<DrawableObject> carImagesList = new ArrayList<>();

    Volvo240 volvo240 = new Volvo240();
    Saab95 saab95 = new Saab95();
    Scania scania = new Scania();

    //methods:

    public ArrayList<DrawableObject> getCarImagesList() {
        return carImagesList;
    }

    public Point findCarPoint(Car car) {
        return new Point((int) car.getxPosition(), (int) car.getyPosition());
    }

    public DrawableObject createDrawableObject(BufferedImage image, Car car) {
        return new DrawableObject(image, findCarPoint(car));
    }

    //nämensåattejorå!

    public void init() {
        volvo240.setyPosition(0 * CAR_OFFSET);
        saab95.setyPosition(1 * CAR_OFFSET);
        scania.setyPosition(2 * CAR_OFFSET);

        cars.add(volvo240);
        cars.add(saab95);
        cars.add(scania);

        carImagesList.add(createDrawableObject(frame.drawPanel.volvoImage, volvo240));
        carImagesList.add(createDrawableObject(frame.drawPanel.saab95Image, saab95));
        carImagesList.add(createDrawableObject(frame.drawPanel.scaniaImage, scania));
    }

    public static void main(String[] args) {
        // Instance of this class

        CarController cc = new CarController();

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        cc.init();
        // Start the timer
        cc.timer.start();
    }

    void updateCarImagesList() {
        carImagesList.add(createDrawableObject(frame.drawPanel.volvoImage, volvo240));
        carImagesList.add(createDrawableObject(frame.drawPanel.saab95Image, saab95));
        carImagesList.add(createDrawableObject(frame.drawPanel.scaniaImage, scania));
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    private class TimerListener implements ActionListener {
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

                carImagesList.clear();
                updateCarImagesList();

                frame.drawPanel.moveit(x, y);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
        }
    }

    void brake(int amount) {
        double brake = ((double) amount / 100);
        for (Car car : cars) {
            car.brake(brake);
        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Car car : cars
        ) {
            car.gas(gas);
        }
    }

    void startAllCars() {
        for (Car car : cars) {
            car.startEngine();
        }
    }

    void stopAllCars() {
        for (Car car : cars) {
            car.stopEngine();
        }
    }
}
