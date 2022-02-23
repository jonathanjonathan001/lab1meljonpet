import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.function.ToDoubleBiFunction;

/*
 * This class represents the Controller part in the MVC pattern.
 * It's responsibilities is to listen to the View and responds in a appropriate manner by
 * modifying the model state and the updating the view.
 */

public class CarController {

    //TODO flytta nedanstående till Buttons


    void brake(int amount) {
        List<Car> cars = Main.getCars();
        double brake = ((double) amount / 100);
        for (Car car : cars) {
            car.brake(brake);
        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        List<Car> cars = Main.getCars();
        double gas = ((double) amount) / 100;
        for (Car car : cars) {
            car.gas(gas);
        }
    }

    void startAllCars() {
        List<Car> cars = Main.getCars();
        for (Car car : cars) {
            car.startEngine();
        }
    }

    void stopAllCars() {
        List<Car> cars = Main.getCars();
        for (Car car : cars) {
            car.stopEngine();
        }
    }

    void lift(int angleIncrease) {
        List<Car> trucks = Main.getTrucks();
        //TODO
        for (Car truck : trucks) {
            Scania castedTruck = (Scania) truck;
            castedTruck.liftTruckBed(angleIncrease);
        }
    }

    void lower(int angleDecrease) {
        List<Car> trucks = Main.getTrucks();
        //TODO
        for (Car truck : trucks) {
            Scania castedTruck = (Scania) truck;
            castedTruck.lowerTruckBed(angleDecrease);
        }
    }

    void turboOn() {
        List<Car> saab95s = Main.getSaab95s();
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
}
