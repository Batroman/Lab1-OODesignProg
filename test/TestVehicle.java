import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.util.Objects;

import static org.junit.Assert.*;

public class TestVehicle {

    private Vehicle set;

    @Before
    public void init() {
        set = new Vehicle(4,100, Color.blue,"MyCar","N",0,0);
        set.currentSpeed = 1;
    }

    @Test
    public void testGetNrDoors(){
        assertEquals(4, set.getNrDoors());
    }
    @Test
    public void testGetEnginePower(){
        assertEquals(100, set.getEnginePower(), 0.0);
    }
    @Test
    public void testGetColor(){
        assertSame(set.getColor(), Color.blue);
    }
    @Test
    public void testSetColor(){
        set.setColor(Color.red);
        assertSame(set.getColor(), Color.red);

    }
    @Test
    public void testStartEngineSpeed(){
        set.startEngine();
        assert(set.getCurrentSpeed() == 0.1);
    }
    @Test
    public void testSpeedFactor(){
        assertEquals(1, set.speedFactor(), 0.0);
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
        assertEquals(0, set.getCurrentSpeed(), 0.0);
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
        assertEquals(1, set.getCurrentSpeed(), 0.0);
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
        assertEquals(1, set.getCurrentSpeed(), 0.0);
    }

    @Test
    public void testStopEngine() {
        set.stopEngine();
        assertEquals(0, set.getCurrentSpeed(), 0.0);
    }
    @Test
    public void testMoveUp() {
        set.setDirection("N");
        set.move();
        assertTrue(set.getPosition().getY() == set.getCurrentSpeed() && set.getPosition().getX() == 0);
    }

    @Test
    public void testMoveDown() {
        set.setDirection("S");
        set.move();
        assertTrue(set.getPosition().getY() == -set.getCurrentSpeed() && set.getPosition().getX() == 0);
    }
    @Test
    public void testMoveRight() {
        set.setDirection("E");
        set.move();
        assertTrue(set.getPosition().getX() == set.getCurrentSpeed() && set.getPosition().getY() == 0);
    }
    @Test
    public void testMoveLeft() {
        set.setDirection("W");
        set.move();
        assertTrue(set.getPosition().getX() == -set.getCurrentSpeed() && set.getPosition().getY() == 0);
    }

    @Test
    public void testTurnRightFrom0() {
        set.turnRight();
        assertEquals("E", set.getDirection());
    }

    @Test
    public void testTurnRightFrom90() {
        set.setDirection("E");
        set.turnRight();
        assertEquals("S", set.getDirection());
    }

    @Test
    public void testTurnRightFrom180() {
        set.setDirection("S");
        set.turnRight();
        assertEquals("W", set.getDirection());
    }

    @Test
    public void testTurnRightFrom270() {
        set.setDirection("W");
        set.turnRight();
        assertEquals("N", set.getDirection());
    }

    @Test
    public void testTurnLeftFrom0() {
        set.setDirection("N");
        set.turnLeft();
        assertEquals("W", set.getDirection());
    }

    @Test
    public void testTurnLeftFrom90() {
        set.setDirection("E");
        set.turnLeft();
        assertEquals("N", set.getDirection());
    }

    @Test
    public void testTurnLeftFrom180() {
        set.setDirection("S");
        set.turnLeft();
        assertEquals("E", set.getDirection());
    }

    @Test
    public void testTurnLeftFrom270() {
        set.setDirection("W");
        set.turnLeft();
        assertEquals("S", set.getDirection());
    }

}


