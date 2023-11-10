import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class TestCar {

    private Car set;

    @Before
    public void init() {
        set = new Car(4,100, Color.blue,"MyCar",0,0,0);
        set.setDirection(0);
        set.currentSpeed = 1;
    }

    @Test
    public void testGetNrDoors(){
        assertTrue(set.getNrDoors() == 4);
    }
    @Test
    public void testGetEnginePower(){
        assertTrue(set.getEnginePower() == 100);
    }
    @Test
    public void testGetColor(){
        assertTrue(set.getColor() == Color.blue);
    }
    @Test
    public void testSetColor(){
        set.setColor(Color.red);
        assertTrue(set.getColor() == Color.red);

    }
    @Test
    public void testStartEngineSpeed(){
        set.startEngine();
        assert(set.getCurrentSpeed() == 0.1);
    }
    @Test
    public void testSpeedFactor(){
        assertTrue(set.speedFactor() == 1);
    }
    @Test
    public void testIncrementSpeed(){
        set.speedFactor();
        set.incrementSpeed(2.0);
        assertEquals(set.getCurrentSpeed(),3,0);

    }
    @Test
    public void testDecrementSpeed(){
        set.decrementSpeed(2.0);
        assertTrue(set.getCurrentSpeed() == 0);
    }
    @Test
    public void testBrakeInRange(){
        set.brake(0.5);
        assertEquals(set.getCurrentSpeed(),0.5,0);
    }
    @Test
    public void testBrakeOutOfRange(){
        set.brake(1.2);
        // currentSpeed should not change if the amount sent to gas is out of range
        assertTrue(set.getCurrentSpeed() == 1);
    }
    @Test
    public void testGasInRange(){
        set.gas(0.5);
        assertEquals(set.getCurrentSpeed(), 1.5, 0);
    }
    @Test
    public void testGasOutOfRange(){
        set.gas(1.2);
        // currentSpeed should not change if the amount sent to gas is out of range
        assertTrue(set.getCurrentSpeed() == 1);
    }

    @Test
    public void testStopEngine() {
        set.stopEngine();
        assertTrue(set.getCurrentSpeed() == 0);
    }
    @Test
    public void testMoveUp() {
        set.setDirection(0);
        set.move();
        assertTrue(set.getPosition().getY() == set.getCurrentSpeed() && set.getPosition().getX() == 0);
    }

    @Test
    public void testMoveDown() {
        set.setDirection(180);
        set.move();
        assertTrue(set.getPosition().getY() == -set.getCurrentSpeed() && set.getPosition().getX() == 0);
    }
    @Test
    public void testMoveRight() {
        set.setDirection(90);
        set.move();
        assertTrue(set.getPosition().getX() == set.getCurrentSpeed() && set.getPosition().getY() == 0);
    }
    @Test
    public void testMoveLeft() {
        set.setDirection(270);
        set.move();
        assertTrue(set.getPosition().getX() == -set.getCurrentSpeed() && set.getPosition().getY() == 0);
    }

    @Test
    public void testMoveAngularX() {
        set.move(Math.PI / 3);
        assertEquals(set.getXPosition(), 1/2, 0.1 );
    }

    @Test
    public void testMoveAngularY() {
        set.move(Math.PI / 3);
        assertEquals(set.getYPosition(),Math.sqrt(3)/2, 0.2 );
    }
    @Test
    public void testTurnRightFrom0() {
        set.turnRight();
        assertTrue(set.getDirection() == 90);
    }

    @Test
    public void testTurnRightFrom90() {
        set.setDirection(90);
        set.turnRight();
        assertTrue(set.getDirection() == 180);
    }

    @Test
    public void testTurnRightFrom180() {
        set.setDirection(180);
        set.turnRight();
        assertTrue(set.getDirection() == 270);
    }

    @Test
    public void testTurnRightFrom270() {
        set.setDirection(270);
        set.turnRight();
        assertTrue(set.getDirection() == 0);
    }

    @Test
    public void testTurnLeftFrom0() {
        set.setDirection(0);
        set.turnLeft();
        assertTrue(set.getDirection() == 270);
    }

    @Test
    public void testTurnLeftFrom90() {
        set.setDirection(90);
        set.turnLeft();
        assertTrue(set.getDirection() == 0);
    }

    @Test
    public void testTurnLeftFrom180() {
        set.setDirection(180);
        set.turnLeft();
        assertTrue(set.getDirection() == 90);
    }

    @Test
    public void testTurnLeftFrom270() {
        set.setDirection(270);
        set.turnLeft();
        assertTrue(set.getDirection() == 180);
    }

}


