import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Buttons extends JPanel implements IObserver {

    CarController carController;



    JLabel gasLabel = new JLabel("Amount of gas");

    public Buttons(CarController carController) {
        this.carController = carController;
    }

    @Override
    public void update(String action, int amount) {
        switch (action){
            case "startAllCars": startAllCars();
                break;
            case "stopAllCars" : stopAllCars();
                break;
            case "gas" : gas(amount);
                break;
            case "brake" : brake(amount);
                break;
            case "turboOn" : turboOn();
                break;
            case "turboOff" : turboOff();
                break;
        }
    }

    private void addCar() {
        java.util.List<Car> cars = Main.getCars();
        int currentSize = cars.size();
        if (currentSize < 10){
            cars.add(CarFactory.createSaab95());
        }
    }

    private void removeCar() {
        java.util.List<Car> cars = Main.getCars();
        int currentSize = cars.size();
        if (currentSize > 0){
            cars.remove(currentSize - 1);
        }
    }

    void brake(int amount) {
        java.util.List<Car> cars = Main.getCars();
        double brake = ((double) amount / 100);
        for (Car car : cars) {
            car.brake(brake);
        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        java.util.List<Car> cars = Main.getCars();
        double gas = ((double) amount) / 100;
        for (Car car : cars) {
            car.gas(gas);
        }
    }

    void startAllCars() {
        java.util.List<Car> cars = Main.getCars();
        for (Car car : cars) {
            car.startEngine();
        }
    }

    void stopAllCars() {
        java.util.List<Car> cars = Main.getCars();
        for (Car car : cars) {
            car.stopEngine();
        }
    }

    void lift(int angleIncrease) {
        java.util.List<Car> trucks = Main.getTrucks();
        //TODO
        for (Car truck : trucks) {
            Scania castedTruck = (Scania) truck;
            castedTruck.liftTruckBed(angleIncrease);

        }
    }

    void lower(int angleDecrease) {
        java.util.List<Car> trucks = Main.getTrucks();
        //TODO
        for (Car truck : trucks) {
            Scania castedTruck = (Scania) truck;
            castedTruck.lowerTruckBed(angleDecrease);
        }
    }

    void turboOn() {
        java.util.List<Car> saab95s = Main.getSaab95s();
        //TODO
        for (Car saab95 : saab95s) {
            Saab95 castedSaab = (Saab95) saab95;
            castedSaab.setTurboOn();
        }
    }

    void turboOff() {
        List<Car> saab95s = Main.getSaab95s();
        //TODO
        for (Car saab95 : saab95s) {
            Saab95 castedSaab = (Saab95) saab95;
            castedSaab.setTurboOff();
        }
    }



    //TODO flytta nedanstående till CarController


}
