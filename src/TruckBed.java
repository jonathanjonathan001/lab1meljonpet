
public class TruckBed {

    private int angle;

    private static final int MAX_ANGLE = 70;

    public TruckBed(int angle) {
        this.angle = angle;
    }

    /**
     * Returns current angle of the truck bed
     *
     * @return the current angle of the truck bed
     */
    public int getAngle() {
        return angle;
    }

    /**
     * Increases the angle of the truck bed
     *
     * @param angleIncrease angle with which to increase the current angle
     * @param currentSpeed  checks if the car using the truck bed is standing still
     */
    public void increaseAngle(int angleIncrease, double currentSpeed) {
        int total = angle + angleIncrease;

        if (total < MAX_ANGLE && currentSpeed == 0) {
            angle += angleIncrease;
        } else if (total > MAX_ANGLE) {
            angle = MAX_ANGLE;
        }
    }

    /**
     * Returns the maximum angle of the car's truckbed
     *
     * @return maximum angle of car's truckbed
     */
    public int getMaxAngle() {
        return MAX_ANGLE;
    }

    /**
     * Decreases the angle of the truck bed
     *
     * @param angleDecrease angle with which to decrease the current angle
     * @param currentSpeed  checks if the car using the truck bed is standing still
     */
    public void decreaseAngle(int angleDecrease, double currentSpeed) {
        int total = angle - angleDecrease;

        if (total > 0 && currentSpeed == 0) {
            angle -= angleDecrease;
        } else if (total < 0) {
            angle = 0;
        }
    }

    /**
     * Checks if the angle of the truck bed is zero
     *
     * @return true if angle is zero, false if not
     */
    public boolean angleIsZero() {
        return angle == 0;
    }

}