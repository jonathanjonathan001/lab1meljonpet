import java.awt.*;


public abstract class Car implements CarInterface  {

    public enum Direction {NORTH, EAST, SOUTH, WEST}
    private Direction currentDirection = Direction.NORTH;
    private double xPosition = 0;
    private double yPosition = 0;

    /**
     * Creates a default car
     * @param nrDoors number of doors on the car
     * @param enginePower engine power of the car
     * @param currentSpeed current speed of the car
     * @param color color of the car
     * @param modelName name of the car model
     */
    public Car(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.currentSpeed = currentSpeed;
        this.color = color;
        this.modelName = modelName;
    }

    /**
     * Sets the current speed of the car
     * @param currentSpeed current speed of the car
     */
    public void setCurrentSpeed(double currentSpeed) { this.currentSpeed = currentSpeed; }

    /**
     * Returns the current speed of the car
     * @return current speed
     */
    public double getCurrentSpeed(){
        return currentSpeed;
    }

    /**
     * Returns the number of doors on the car
     * @return number of doors
     */
    public int getNrDoors(){
        return nrDoors;
    }
    public double getEnginePower(){
        return enginePower;
    }


    /**
     * returns the color of the car
     * @return color of the car
     */
    public Color getColor(){
        return color;
    }

    /**
     * sets the color of the car
     * @param clr a color
     */
    public void setColor(Color clr){
        color = clr;
    }

    public void startEngine(){
        currentSpeed = 0.1;
    }

    public void stopEngine(){
        currentSpeed = 0;
    }


}
