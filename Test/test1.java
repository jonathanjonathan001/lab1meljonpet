import org.junit.Before;
import org.junit.Test;

import java.awt.*;

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
    public void turnLeft_BecomesWest_WhenStartingFromNorth() {
        testSaab95.turnLeft();
        assertTrue(testSaab95.getCurrentDirection() == Car.Direction.WEST);
    }

    @Test
    public void turnLeft_BecomesSouth_WhenStartingFromWest() {
        testSaab95.setCurrentDirection(Car.Direction.WEST);
        testSaab95.turnLeft();
        assertTrue(testSaab95.getCurrentDirection() == Car.Direction.SOUTH);
    }

    @Test
    public void turnLeft_BecomesEast_WhenStartingFromSouth() {
        testSaab95.setCurrentDirection(Car.Direction.SOUTH);
        testSaab95.turnLeft();
        assertTrue(testSaab95.getCurrentDirection() == Car.Direction.EAST);
    }

    @Test
    public void testTurnLeft_BecomesNorth_WhenStartingFromEast() {
        testSaab95.setCurrentDirection(Car.Direction.EAST);
        testSaab95.turnLeft();
        assertTrue(testSaab95.getCurrentDirection() == Car.Direction.NORTH);
    }

    @Test
    public void testTurnRight_becomesEast_whenStartingFromNorth() {
        testSaab95.setCurrentDirection(Car.Direction.NORTH);
        testSaab95.turnRight();
        assertTrue(testSaab95.getCurrentDirection() == Car.Direction.EAST);
    }

    @Test
    public void testTurnRight_becomesSouth_whenStartingFromEast() {
        testSaab95.setCurrentDirection(Car.Direction.EAST);
        testSaab95.turnRight();
        assertTrue(testSaab95.getCurrentDirection() == Car.Direction.SOUTH);
    }

    @Test
    public void testTurnRight_becomesWest_whenStartingFromSouth() {
        testSaab95.setCurrentDirection(Car.Direction.SOUTH);
        testSaab95.turnRight();
        assertTrue(testSaab95.getCurrentDirection() == Car.Direction.WEST);
    }

    @Test
    public void testTurnRight_becomesNorth_whenStartingFromWest() {
        testSaab95.setCurrentDirection(Car.Direction.WEST);
        testSaab95.turnRight();
        assertTrue(testSaab95.getCurrentDirection() == Car.Direction.NORTH);
    }

    @Test
    public void testStopEngine() {
        testSaab95.setCurrentSpeed(1);
        testSaab95.stopEngine();
        assertTrue(testSaab95.getCurrentSpeed() == 0);
    }

    @Test
    public void testStartEngine() {
        testSaab95.startEngine();
        assertTrue(testSaab95.getCurrentSpeed() == 0.1);
    }

    @Test
    public void testGetNrDoors() {
        assertEquals(testSaab95.getNrDoors(), 2);
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

    @Test
    public void move_UpdatesPositionX_WhenMovingWest() {

        testSaab95.setCurrentDirection(Car.Direction.WEST);
        testSaab95.setCurrentSpeed(1);
        testSaab95.move();
        assertTrue(testSaab95.getxPosition() == -testSaab95.getCurrentSpeed());
    }

    @Test
    public void move_UpdatesPositionX_WhenMovingEast() {
        testSaab95.setCurrentDirection(Car.Direction.EAST);
        testSaab95.setCurrentSpeed(1);
        testSaab95.move();
        assertTrue(testSaab95.getxPosition() == testSaab95.getCurrentSpeed());
    }

    @Test
    public void setTurboOff() {
        testSaab95.setTurboOff();
        assertTrue(!testSaab95.turboOn);
    }


    @Test
    public void setTurboOn() {
        testSaab95.setTurboOn();
        assertTrue(testSaab95.turboOn);
    }

    @Test
    public void setColor() {
        testSaab95.setColor(Color.black);
        assertTrue(testSaab95.getColor() == Color.black);
    }

    @Test
    public void getColor() {
        testSaab95.setColor(Color.green);
        assertTrue(testSaab95.getColor() == Color.green);
    }

    @Test
    public void gas_Saab95_doesNotAffectCurrentSpeed_whenGasIsMoreThan1(){
        double speedBeforeGas = testSaab95.getCurrentSpeed();
        testSaab95.gas(2);
        assertTrue(testSaab95.getCurrentSpeed() == speedBeforeGas);
    }

    @Test
    public void gas_Saab95_DoesNotAffectCurrentSpeed_whenGasIsLessThan0() {
        double speedBeforeGas = testSaab95.getCurrentSpeed();
        testSaab95.gas(-1);
        assertTrue(testSaab95.getCurrentSpeed() == speedBeforeGas);
    }

    @Test
    public void gas_Volvo240_DoesNotAffectCurrentSpeed_whenGasIsMoreThan1() {
        double speedBeforeGas = testVolvo240.getCurrentSpeed();
        testVolvo240.gas(2);
        assertTrue(testVolvo240.getCurrentSpeed() == speedBeforeGas);
    }

    @Test
    public void gas_Volvo240_DoesNotAffectCurrentSpeed_whenGasIsLessThan0(){
        double speedBeforeGas = testVolvo240.getCurrentSpeed();
        testVolvo240.gas(-1);
        assertTrue(testVolvo240.getCurrentSpeed() == speedBeforeGas);
    }

    @Test
    public void brake_Saab95_DoesNotAffectSpeed_WhenBrakeAmountLessThan0(){
        double speedBeforeBrake = testSaab95.getCurrentSpeed();
        testSaab95.brake(-1);
        assertTrue(testSaab95.getCurrentSpeed() == speedBeforeBrake);
    }

    @Test
    public void brakeSaab95_DoesNotAffectSpeed_WhenBrakeAmountMoreThan1(){
        double speedBeforeBrake = testSaab95.getCurrentSpeed();
        testSaab95.brake(2);
        assertTrue(testSaab95.getCurrentSpeed() == speedBeforeBrake);
    }

    @Test
    public void brakeVolvo240_DoesNotAffectCurrentSpeed_WhenBrakeAmountLessThan0(){
        double speedBeforeBrake = testVolvo240.getCurrentSpeed();
        testVolvo240.brake(-1);
        assertTrue(testVolvo240.getCurrentSpeed() == speedBeforeBrake);
    }
}
