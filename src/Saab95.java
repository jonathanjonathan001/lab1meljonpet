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

    @Override
    protected double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }

}
