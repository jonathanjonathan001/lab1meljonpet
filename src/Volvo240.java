import java.awt.*;



public class Volvo240 extends Car {

    private final static double TRIMFACTOR = 1.25;

    /**
     * Creates a car Volvo240
     */
    public Volvo240(){
        nrDoors = 4;
        color = Color.black;
        enginePower = 100;
        modelName = "Volvo240";
        stopEngine();
    }
    
    private double speedFactor(){
        return getEnginePower() * 0.01 * TRIMFACTOR;
    }

    private void incrementSpeed(double amount){
	    setCurrentSpeed(Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower()));
    }

    public void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
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
