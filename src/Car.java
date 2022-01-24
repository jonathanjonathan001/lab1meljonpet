import java.awt.*;

/**
 * Represents a car
 */
public abstract class Car implements Movable  {

    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name

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

    /**
     * returns the power of the engine
     * @return power of the engine
     */
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

    /**
     * Starts the engine
     */
    public void startEngine(){
        currentSpeed = 0.1;
    }

    /**
     * Stops the engine
     */
    public void stopEngine(){
        currentSpeed = 0;
    }

    /**
     * Returns the x-coordinate of the car
     * @return x coordinate of the car
     */
    public double getxPosition(){
        return xPosition;
    }

    /**
     * Returns the y-coordinate of the car
     * @return y-coordinate of the car
     */
    public double getyPosition(){
        return yPosition;
    }

    /**
     * returns the current direction of the car
     * @return direction of the car
     */
    public Direction getCurrentDirection() {
        return currentDirection;
    }

    /**
     * Set the current direction of the car
     * @param dir preferred direction
     */
    public void setCurrentDirection(Direction dir){
        currentDirection = dir;
    }

    /**
     * Moves the car according to direction
     */
    public void move() {
        if (currentDirection == Direction.NORTH){
            yPosition += currentSpeed;
        } else if (currentDirection == Direction.SOUTH){
            yPosition -= currentSpeed;
        } else if (currentDirection == Direction.EAST){
            xPosition += currentSpeed;
        } else if (currentDirection == Direction.WEST){
            xPosition-= currentSpeed;
        }
    }

    /**
     * Turns vehicle to the left
     */
    public void turnLeft() {
        switch (currentDirection) {
            case NORTH -> currentDirection = Direction.WEST;
            case EAST -> currentDirection = Direction.NORTH;
            case SOUTH -> currentDirection = Direction.EAST;
            case WEST -> currentDirection = Direction.SOUTH;
        }
    }

    /**
     * Turns vehicle to the right
     */
    public void turnRight() {
        switch (currentDirection) {
            case NORTH -> currentDirection = Direction.EAST;
            case EAST -> currentDirection = Direction.SOUTH;
            case SOUTH -> currentDirection = Direction.WEST;
            case WEST -> currentDirection = Direction.NORTH;
        }
    }
}
