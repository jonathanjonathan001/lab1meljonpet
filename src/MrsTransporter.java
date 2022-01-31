import java.awt.*;
import java.util.*;

public class MrsTransporter extends Car {

    private static final int MAX_CARS = 10;
    private final Ramp ramp = new Ramp(Ramp.RampState.UP);
    private final Deque<Car> currentCars = new ArrayDeque<>(MAX_CARS);


    /**
     * Creates a truck MrsTransporter
     */
    public MrsTransporter(){
        super(2, 125, 0, Color.blue, "MrsTransporter", TypeOfCar.TRUCK);
        stopEngine();
    }

    @Override
    protected double speedFactor() {
        return getEnginePower() * 0.01;
    }

    /**
     * returns true if the ramp is up, false if the ramp is up
      * @return ramp state
     */
    public boolean rampIsLifted(){
        return ramp.getCurrentRampState() == Ramp.RampState.UP;
    }

    /**
     * Moves the truck and all its loaded cars
     */
    @Override
    public void move (){
        super.move();
        updatePositionOfCurrentCars();
    }

    /**
     * Activates the accelerator of the car if the ramp is up
     * @param amount the amount of acceleration
     */
    @Override
    public void gas(double amount) {
        if (amount >= 0 && amount <= 1 && rampIsLifted()) {
            incrementSpeed(amount);
        }
    }

    /**
     * Lowers the ramp
     */
    public void lowerRamp(){
        if(rampIsLifted() && getCurrentSpeed() == 0){
            ramp.setCurrentRampState(Ramp.RampState.UP);
        }
    }

    /**
     * Lifts the ramp
     */
    public void liftRamp(){
        if(!rampIsLifted() && getCurrentSpeed() == 0){
            ramp.setCurrentRampState(Ramp.RampState.DOWN);
        }
    }

    /**
     * Loads the car transport with a car
     * @param car the current car
     */
    public void load(Car car){
        if (!rampIsLifted() && isClose(car) && car.getCarType() == TypeOfCar.PERSONAL_CAR){
            currentCars.push(car);
        }
    }

    /**
     * Unloads a car from the car transport
     */
    public void unload(){
        if (!rampIsLifted() && !currentCars.isEmpty()){
            currentCars.peek().setxPosition(getxPosition()+1);
            currentCars.pop();
        }
    }

    private void updatePositionOfCurrentCars(){
        for (Car c : currentCars){
            c.setxPosition(this.getxPosition());
            c.setyPosition(this.getyPosition());
        }
    }

    private boolean isClose(Car car) {
        boolean checkX = (this.getxPosition()-car.getxPosition() <= 10);
        boolean checkY = (this.getyPosition()-car.getyPosition() <= 10);
        return checkX && checkY;
    }

    public Deque<Car> getCurrentCars(){
        return currentCars;
    }

    public Ramp.RampState getRampState(){
        return ramp.getCurrentRampState();
    }

}
