import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class TestCar {

    private Car set;

    @Before
    public void init() {
        set = new Car();
        set.carPosition.setPosition(0,0);
        set.carPosition.setDirection(0);
        set.currentSpeed = 1;

    }

    @Test
    public void testGetNrDoors(){
        assertTrue(set.nrDoors == set.getNrDoors());
    }
    @Test
    public void testGetEnginePower(){
        assertTrue(set.enginePower == set.getEnginePower());
    }
    @Test
    public void testGetColor(){
        assertTrue(set.color == set.getColor());
    }
    @Test
    public void testSetColor(){
        set.setColor(Color.red);
        assertTrue(set.color == Color.red);

    }
    @Test
    public void testStartEngineSpeed(){
        set.startEngine();
        assert(set.currentSpeed == 0.1);
    }
    @Test
    public void testSpeedFactor(){
        assertTrue(set.speedFactor() == 1);
    }
    @Test
    public void testIncrementSpeed(){
        set.enginePower = 100;
        set.speedFactor();
        set.incrementSpeed(2.0);
        assertEquals(set.currentSpeed,3,0);

    }
    @Test
    public void testDecrementSpeed(){
        set.decrementSpeed(2.0);
        assertTrue(set.currentSpeed == 0);
    }
    @Test
    public void testBrakeOK(){
        set.brake(0.5);
        assertEquals(set.currentSpeed,0.5,0);
    }
    @Test
    public void testBrakeOutOfRange(){
        set.brake(1.2);
        assertTrue(set.currentSpeed == set.currentSpeed);
    }
    @Test
    public void testGasOK(){
        set.enginePower = 100;
        set.gas(0.5);
        assertEquals(set.currentSpeed, 1.5, 0);
    }
    @Test
    public void testGasOutRange(){
        set.enginePower = 100;
        set.gas(1.2);
        assertTrue(set.currentSpeed == set.currentSpeed);
    }
    @Test
    public void testMoveUp() {
        set.carPosition.setDirection(0);
        set.carPosition.move();
        assertTrue(set.carPosition.getPosition().getY() == set.getCurrentSpeed() && set.carPosition.getPosition().getX() == 0);
    }
    @Test
    public void testMoveDown() {
        set.carPosition.setDirection(180);
        set.carPosition.move();
        assertTrue(set.carPosition.getPosition().getY() == -set.getCurrentSpeed() && set.carPosition.getPosition().getX() == 0);
    }
    @Test
    public void testMoveRight() {
        set.carPosition.setDirection(90);
        set.carPosition.move();
        assertTrue(set.carPosition.getPosition().getX() == set.getCurrentSpeed() && set.carPosition.getPosition().getY() == 0);
    }
    @Test
    public void testMoveLeft() {
        set.carPosition.setDirection(270);
        set.carPosition.move();
        assertTrue(set.carPosition.getPosition().getX() == -set.getCurrentSpeed() && set.carPosition.getPosition().getY() == 0);
    }
    @Test
    public void testTurnRightFrom0() {
        set.carPosition.turnRight();
        assertTrue(set.carPosition.getDirection() == 90);
    }

    @Test
    public void testTurnRightFrom90() {
        set.carPosition.setDirection(90);
        set.carPosition.turnRight();
        assertTrue(set.carPosition.getDirection() == 180);
    }

    @Test
    public void testTurnRightFrom180() {
        set.carPosition.setDirection(180);
        set.carPosition.turnRight();
        assertTrue(set.carPosition.getDirection() == 270);
    }

    @Test
    public void testTurnRightFrom270() {
        set.carPosition.setDirection(270);
        set.carPosition.turnRight();
        assertTrue(set.carPosition.getDirection() == 0);
    }

    @Test
    public void testTurnLeftFrom0() {
        set.carPosition.setDirection(0);
        set.carPosition.turnLeft();
        assertTrue(set.carPosition.getDirection() == 270);
    }

    @Test
    public void testTurnLeftFrom90() {
        set.carPosition.setDirection(90);
        set.carPosition.turnLeft();
        assertTrue(set.carPosition.getDirection() == 0);
    }

    @Test
    public void testTurnLeftFrom180() {
        set.carPosition.setDirection(180);
        set.carPosition.turnLeft();
        assertTrue(set.carPosition.getDirection() == 90);
    }

    @Test
    public void testTurnLeftFrom270() {
        set.carPosition.setDirection(270);
        set.carPosition.turnLeft();
        assertTrue(set.carPosition.getDirection() == 180);
    }

}


