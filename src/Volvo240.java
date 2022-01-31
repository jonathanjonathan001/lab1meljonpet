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
        super(4,100,0,Color.black,"Volvo240", TypeOfCar.PERSONAL_CAR);
        stopEngine();
    }

    @Override
    protected double speedFactor(){
        return getEnginePower() * 0.01 * TRIMFACTOR;
    }

}
