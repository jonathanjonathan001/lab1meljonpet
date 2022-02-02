import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.util.Deque;

import static org.junit.Assert.*;

public class test1 {

    private static final double DELTA = 0.0001;
    Saab95 testSaab95;
    Volvo240 testVolvo240;
    Scania testScania;
    MrsTransporter testMrs;


    @Before
    public void init() {
        testSaab95 = new Saab95();
        testVolvo240 = new Volvo240();
        testScania = new Scania();
        testMrs = new MrsTransporter();
        testMrs.getCurrentCars().clear();
        testMrs.lowerRamp();
    }

    @Test
    public void saab_turnLeft_BecomesWest_WhenStartingFromNorth() {
        testSaab95.turnLeft();
        assertEquals(testSaab95.getCurrentDirection(), Car.Direction.WEST);
    }

    @Test
    public void saab_turnLeft_BecomesSouth_WhenStartingFromWest() {
        testSaab95.setCurrentDirection(Car.Direction.WEST);
        testSaab95.turnLeft();
        assertEquals(testSaab95.getCurrentDirection(), Car.Direction.SOUTH);
    }

    @Test
    public void saab_turnLeft_BecomesEast_WhenStartingFromSouth() {
        testSaab95.setCurrentDirection(Car.Direction.SOUTH);
        testSaab95.turnLeft();
        assertEquals(testSaab95.getCurrentDirection(), Car.Direction.EAST);
    }

    @Test
    public void saab_TurnLeft__BecomesNorth_WhenStartingFromEast() {
        testSaab95.setCurrentDirection(Car.Direction.EAST);
        testSaab95.turnLeft();
        assertEquals(testSaab95.getCurrentDirection(), Car.Direction.NORTH);
    }

    @Test
    public void volvo_turnLeft_BecomesWest_WhenStartingFromNorth() {
        testVolvo240.turnLeft();
        assertEquals(testVolvo240.getCurrentDirection(), Car.Direction.WEST);
    }

    @Test
    public void volvo_turnLeft_BecomesSouth_WhenStartingFromWest() {
        testVolvo240.setCurrentDirection(Car.Direction.WEST);
        testVolvo240.turnLeft();
        assertEquals(testVolvo240.getCurrentDirection(), Car.Direction.SOUTH);
    }

    @Test
    public void volvo_turnLeft_BecomesEast_WhenStartingFromSouth() {
        testVolvo240.setCurrentDirection(Car.Direction.SOUTH);
        testVolvo240.turnLeft();
        assertEquals(testVolvo240.getCurrentDirection(), Car.Direction.EAST);
    }

    @Test
    public void volvo_TurnLeft_BecomesNorth_WhenStartingFromEast() {
        testVolvo240.setCurrentDirection(Car.Direction.EAST);
        testVolvo240.turnLeft();
        assertEquals(testVolvo240.getCurrentDirection(), Car.Direction.NORTH);
    }

    @Test
    public void saab_TurnRight_becomesEast_whenStartingFromNorth() {
        testSaab95.setCurrentDirection(Car.Direction.NORTH);
        testSaab95.turnRight();
        assertEquals(testSaab95.getCurrentDirection(), Car.Direction.EAST);
    }

    @Test
    public void saab_TurnRight_becomesSouth_whenStartingFromEast() {
        testSaab95.setCurrentDirection(Car.Direction.EAST);
        testSaab95.turnRight();
        assertEquals(testSaab95.getCurrentDirection(), Car.Direction.SOUTH);
    }

    @Test
    public void saab_TurnRight_becomesWest_whenStartingFromSouth() {
        testSaab95.setCurrentDirection(Car.Direction.SOUTH);
        testSaab95.turnRight();
        assertEquals(testSaab95.getCurrentDirection(), Car.Direction.WEST);
    }

    @Test
    public void saab_TurnRight_becomesNorth_whenStartingFromWest() {
        testSaab95.setCurrentDirection(Car.Direction.WEST);
        testSaab95.turnRight();
        assertEquals(testSaab95.getCurrentDirection(), Car.Direction.NORTH);
    }

    @Test
    public void volvo_TurnRight_becomesEast_whenStartingFromNorth() {
        testVolvo240.setCurrentDirection(Car.Direction.NORTH);
        testVolvo240.turnRight();
        assertEquals(testVolvo240.getCurrentDirection(), Car.Direction.EAST);
    }

    @Test
    public void volvo_TurnRight_becomesSouth_whenStartingFromEast() {
        testVolvo240.setCurrentDirection(Car.Direction.EAST);
        testVolvo240.turnRight();
        assertEquals(testVolvo240.getCurrentDirection(), Car.Direction.SOUTH);
    }

    @Test
    public void volvo_TurnRight_becomesWest_whenStartingFromSouth() {
        testVolvo240.setCurrentDirection(Car.Direction.SOUTH);
        testVolvo240.turnRight();
        assertEquals(testVolvo240.getCurrentDirection(), Car.Direction.WEST);
    }

    @Test
    public void volvo_TurnRight_becomesNorth_whenStartingFromWest() {
        testVolvo240.setCurrentDirection(Car.Direction.WEST);
        testVolvo240.turnRight();
        assertEquals(testVolvo240.getCurrentDirection(), Car.Direction.NORTH);
    }

    @Test
    public void testStopEngine() {
        testSaab95.setCurrentSpeed(1);
        testSaab95.stopEngine();
        assertEquals(testSaab95.getCurrentSpeed(), 0, DELTA);
    }

    @Test
    public void testStartEngine() {
        testSaab95.startEngine();
        assertEquals(testSaab95.getCurrentSpeed(), 0.1, DELTA);
    }

    @Test
    public void testGetNrDoors() {
        assertEquals(testSaab95.getNrDoors(), 2);
    }

    @Test
    public void move_saab_UpdatesPositionY_WhenPointingNorth() {

        testSaab95.setCurrentDirection(Car.Direction.NORTH);
        testSaab95.setCurrentSpeed(1);
        testSaab95.move();
        assertEquals(testSaab95.getyPosition(), testSaab95.getCurrentSpeed(), DELTA);
    }

    @Test
    public void move_saab_UpdatesPositionY_WhenMovingSouth() {

        testSaab95.setCurrentDirection(Car.Direction.SOUTH);
        testSaab95.setCurrentSpeed(1);
        testSaab95.move();
        assertEquals(testSaab95.getyPosition(), -testSaab95.getCurrentSpeed(), DELTA);
    }

    @Test
    public void move_saab_UpdatesPositionX_WhenMovingWest() {

        testSaab95.setCurrentDirection(Car.Direction.WEST);
        testSaab95.setCurrentSpeed(1);
        testSaab95.move();
        assertEquals(testSaab95.getxPosition(), -testSaab95.getCurrentSpeed(), DELTA);
    }

    @Test
    public void move_saab_UpdatesPositionX_WhenMovingEast() {
        testSaab95.setCurrentDirection(Car.Direction.EAST);
        testSaab95.setCurrentSpeed(1);
        testSaab95.move();
        assertEquals(testSaab95.getxPosition(), testSaab95.getCurrentSpeed(), DELTA);
    }

    @Test
    public void move_volvo_UpdatesPositionY_WhenPointingNorth() {

        testVolvo240.setCurrentDirection(Car.Direction.NORTH);
        testVolvo240.setCurrentSpeed(1);
        testVolvo240.move();
        assertEquals(testVolvo240.getyPosition(), testVolvo240.getCurrentSpeed(), DELTA);
    }

    @Test
    public void move_volvo_UpdatesPositionY_WhenMovingSouth() {

        testVolvo240.setCurrentDirection(Car.Direction.SOUTH);
        testVolvo240.setCurrentSpeed(1);
        testVolvo240.move();
        assertEquals(testVolvo240.getyPosition(), -testVolvo240.getCurrentSpeed(), DELTA);
    }

    @Test
    public void move_volvo_UpdatesPositionX_WhenMovingWest() {

        testVolvo240.setCurrentDirection(Car.Direction.WEST);
        testVolvo240.setCurrentSpeed(1);
        testVolvo240.move();
        assertEquals(testVolvo240.getxPosition(), -testVolvo240.getCurrentSpeed(), DELTA);
    }

    @Test
    public void move_volvo_UpdatesPositionX_WhenMovingEast() {
        testVolvo240.setCurrentDirection(Car.Direction.EAST);
        testVolvo240.setCurrentSpeed(1);
        testVolvo240.move();
        assertEquals(testVolvo240.getxPosition(), testVolvo240.getCurrentSpeed(), DELTA);
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
        assertEquals(testSaab95.getColor(), Color.black);
    }

    @Test
    public void getColor() {
        testSaab95.setColor(Color.green);
        assertEquals(testSaab95.getColor(), Color.green);
    }

    @Test
    public void gas_Saab95_doesNotAffectCurrentSpeed_whenGasIsMoreThan1() {
        double speedBeforeGas = testSaab95.getCurrentSpeed();
        testSaab95.gas(2);
        assertEquals(testSaab95.getCurrentSpeed(), speedBeforeGas, DELTA);
    }

    @Test
    public void gas_Saab95_DoesNotAffectCurrentSpeed_whenGasIsLessThan0() {
        double speedBeforeGas = testSaab95.getCurrentSpeed();
        testSaab95.gas(-1);
        assertEquals(testSaab95.getCurrentSpeed(), speedBeforeGas, DELTA);
    }

    @Test
    public void gas_Volvo240_DoesNotAffectCurrentSpeed_whenGasIsMoreThan1() {
        double speedBeforeGas = testVolvo240.getCurrentSpeed();
        testVolvo240.gas(2);
        assertEquals(testVolvo240.getCurrentSpeed(), speedBeforeGas, DELTA);
    }

    @Test
    public void gas_Volvo240_DoesNotAffectCurrentSpeed_whenGasIsLessThan0() {
        double speedBeforeGas = testVolvo240.getCurrentSpeed();
        testVolvo240.gas(-1);
        assertEquals(testVolvo240.getCurrentSpeed(), speedBeforeGas, DELTA);
    }

    @Test
    public void brake_Saab95_DoesNotAffectSpeed_WhenBrakeAmountLessThan0() {
        double speedBeforeBrake = testSaab95.getCurrentSpeed();
        testSaab95.brake(-1);
        assertEquals(testSaab95.getCurrentSpeed(), speedBeforeBrake, DELTA);
    }

    @Test
    public void brakeSaab95_DoesNotAffectSpeed_WhenBrakeAmountMoreThan1() {
        double speedBeforeBrake = testSaab95.getCurrentSpeed();
        testSaab95.brake(2);
        assertEquals(testSaab95.getCurrentSpeed(), speedBeforeBrake, DELTA);
    }

    @Test
    public void brakeVolvo240_DoesNotAffectCurrentSpeed_WhenBrakeAmountLessThan0() {
        double speedBeforeBrake = testVolvo240.getCurrentSpeed();
        testVolvo240.brake(-1);
        assertEquals(testVolvo240.getCurrentSpeed(), speedBeforeBrake, DELTA);
    }

    @Test
    public void gasScania_doesNotIncreaseSpeed_WhenTruckBedAngleIsNotZero() {
        double speedBeforeGas = testScania.getCurrentSpeed();
        testScania.liftTruckBed(testScania.truckBed.getMaxAngle());
        testScania.gas(testScania.getEnginePower());
        double speedAfterGas = testScania.getCurrentSpeed();
        assertEquals(speedBeforeGas, speedAfterGas, DELTA);
    }

    @Test
    public void scaniaBedAngle_WillNotGoBelow0_whenDecrementAmountMoreThan70() {
        testScania.lowerTruckBed(80);
        assertTrue(testScania.truckBed.angleIsZero());
    }

    @Test
    public void ScaniaIncrementAngleNotOver70_whenIncreaseAmountMoreThan70() {
        testScania.liftTruckBed(80);
        assertEquals(testScania.truckBed.getAngle(), testScania.truckBed.getMaxAngle());
    }

    @Test
    public void MrsTransportUnload_DoesNotUnload_WhenRampIsUp() {
        testMrs.load(testSaab95);
        testMrs.liftRamp();
        testMrs.unload();
        assertTrue(testMrs.getCurrentCars().contains(testSaab95));
    }

    @Test
    public void mrsTransporterUnload_UnloadsTheCarThatEnteredLast() {
        testMrs.load(testSaab95);
        testMrs.load(testVolvo240);
        testMrs.unload();
        Deque<Car> currentCars = testMrs.getCurrentCars();
        assertTrue(!currentCars.contains(testVolvo240) && currentCars.contains(testSaab95));
    }

    @Test
    public void mrsTransporterLoad_StackSize1_WhenLoadedWith1Car() {
        testMrs.load(testSaab95);
        assertEquals(testMrs.getCurrentCars().size(), 1);
    }

    @Test
    public void mrsTransporterGas_DoesNotWork_WhenInRampStateIsDown() {
        double speedBeforeGas = testMrs.getCurrentSpeed();
        testMrs.gas(testMrs.getEnginePower());
        double speedAfterGas = testMrs.getCurrentSpeed();
        assertEquals(speedBeforeGas, speedAfterGas, DELTA);
    }

    @Test
    public void mrsTransporterLowerRamp_DoesNotLower_WhenInMotion() {
        testMrs.liftRamp();
        Ramp.RampState stateBeforeGas = testMrs.getRampState();
        testMrs.gas(testMrs.getEnginePower());
        Ramp.RampState stateAfterGas = testMrs.getRampState();
        assertEquals(stateBeforeGas, stateAfterGas);
    }

}