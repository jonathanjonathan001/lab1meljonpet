import java.awt.*;

/**
 * Specifies the car Volvo240
 */

public class Volvo240 extends Car {

    private final static double TRIMFACTOR = 1.25;

    /**
     * Creates a car Volvo240
     */
    public Volvo240(){
        super(4,100,0,Color.black,"Volvo240");
        stopEngine();
    }
    
    private double speedFactor(){
        return getEnginePower() * 0.01 * TRIMFACTOR;
    }

    private void incrementSpeed(double amount){
	    setCurrentSpeed(Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower()));
    }

    private void decrementSpeed(double amount){
        setCurrentSpeed(Math.max(getCurrentSpeed() - speedFactor() * amount,0));
    }
}
