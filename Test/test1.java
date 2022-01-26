import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class test1 {

    Saab95 testSaab95;
    Volvo240 testVolvo240;

    @Before
    public void init() {
        testSaab95 = new Saab95();
        testVolvo240 = new Volvo240();
    }

    @Test
    public void move_UpdatesPositionY_WhenPointingNorth() {

        testSaab95.setCurrentDirection(Car.Direction.NORTH);
        testSaab95.setCurrentSpeed(1);
        testSaab95.move();
        assertTrue(testSaab95.getyPosition() == testSaab95.getCurrentSpeed());
    }

    @Test
    public void move_UpdatesPositionY_WhenMovingSouth() {

        testSaab95.setCurrentDirection(Car.Direction.SOUTH);
        testSaab95.setCurrentSpeed(1);
        testSaab95.move();
        assertTrue(testSaab95.getyPosition() == -testSaab95.getCurrentSpeed());
    }

}
