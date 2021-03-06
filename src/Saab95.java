import java.awt.*;

/**
 * Specifies the car Saab95
 */
public class Saab95 extends Car {

    private boolean turboOn;

    /**
     * Creates a car Saab95
     */
    public Saab95() {
        super(2, 125, 0, Color.red, "Saab95", TypeOfCar.PERSONAL_CAR);
        turboOn = false;
        stopEngine();
    }

    /**
     * checks to see whether the turbo is on
     *
     * @return if turbo is activated
     */
    public boolean turboIsOn() {
        return turboOn;
    }

    /**
     * Sets turbo on
     */
    public void setTurboOn() {
        turboOn = true;
    }

    /**
     * Sets turbo off
     */
    public void setTurboOff() {
        turboOn = false;
    }

    @Override
    protected double speedFactor() {
        double turbo = 1;
        if (turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }

}
