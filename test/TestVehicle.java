import org.junit.Before;
import org.junit.Test;


import java.awt.*;

import static org.junit.Assert.*;

public class TestVehicle {

    private Vehicle set;

    @Before
    public void init() {
        set = new Vehicle(4,100, Color.blue,"MyCar",0,0,0);
        set.setDirection(0);
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
        assertEquals(1, set.getCurrentSpeed(), 0.0);
    }

    @Test
    public void testStopEngine() {
        set.stopEngine();
        assertEquals(0, set.getCurrentSpeed(), 0.0);
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
    public void testTurnRightFrom0() {
        set.turnRight();
        assertEquals(90, set.getDirection());
    }

    @Test
    public void testTurnRightFrom90() {
        set.setDirection(90);
        set.turnRight();
        assertEquals(180, set.getDirection());
    }

    @Test
    public void testTurnRightFrom180() {
        set.setDirection(180);
        set.turnRight();
        assertEquals(270, set.getDirection());
    }

    @Test
    public void testTurnRightFrom270() {
        set.setDirection(270);
        set.turnRight();
        assertEquals(0, set.getDirection());
    }

    @Test
    public void testTurnLeftFrom0() {
        set.setDirection(0);
        set.turnLeft();
        assertEquals(270, set.getDirection());
    }

    @Test
    public void testTurnLeftFrom90() {
        set.setDirection(90);
        set.turnLeft();
        assertEquals(0, set.getDirection());
    }

    @Test
    public void testTurnLeftFrom180() {
        set.setDirection(180);
        set.turnLeft();
        assertEquals(90, set.getDirection());
    }

    @Test
    public void testTurnLeftFrom270() {
        set.setDirection(270);
        set.turnLeft();
        assertEquals(180, set.getDirection());
    }

}


