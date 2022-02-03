import java.awt.*;

public class Scania extends Car {

    TruckBed truckBed = new TruckBed(0);

    /**
     * Creates a car Scania
     */
    public Scania() {
        super(2, 125, 0, Color.yellow, "Scania", TypeOfCar.TRUCK);
        stopEngine();
    }

    @Override
    protected double speedFactor() {
        return getEnginePower() * 0.01;
    }

    @Override
    /**
     * Activates the accelerator of the car if the truck bed angle is 0
     * @param amount the amount of acceleration
     */
    public void gas(double amount) {

        if (truckBed.angleIsZero()) {
            super.gas(amount);
        }
    }

    /**
     * Lifts the truck bed (if truck is standing still)
     *
     * @param increaseAmount How much the bed will lift
     */
    public void liftTruckBed(int increaseAmount) {
        truckBed.increaseAngle(increaseAmount, getCurrentSpeed());
    }

    /**
     * Lowers the truck bed if truck is standing still
     *
     * @param decreaseAmount How much the bed will be lowered
     */
    public void lowerTruckBed(int decreaseAmount) {
        truckBed.decreaseAngle(decreaseAmount, getCurrentSpeed());
    }
}
