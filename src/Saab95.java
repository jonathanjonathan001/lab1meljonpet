import java.awt.*;

/**
 * Specifies the car Saab95
 */
public class Saab95 extends Car {

    public boolean turboOn;

    /**
     * Creates a car Saab95
     */
    public Saab95(){
        super(2,125,0,Color.red,"Saab95");
        turboOn = false;
        stopEngine();
    }

    /**
     * Sets turbo on
     */
    public void setTurboOn(){
	    turboOn = true;
    }

    /**
     * Sets turbo off
     */
    public void setTurboOff(){
	    turboOn = false;
    }

    private double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }

    private void incrementSpeed(double amount){
        setCurrentSpeed(getCurrentSpeed() + speedFactor() * amount);
    }

    private void decrementSpeed(double amount){
        setCurrentSpeed(getCurrentSpeed() - speedFactor() * amount);
    }

    /**
     * Activates the accelerator of the car
     * @param amount the amount of acceleration
     */
    // TODO fix this method according to lab pm
    public void gas(double amount){
        incrementSpeed(amount);
    }

    /**
     * Activates the brakes of the car
     * @param amount the amount of brake power
     */
    // TODO fix this method according to lab pm
    public void brake(double amount){
        decrementSpeed(amount);
    }

}
