import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class TestVolvo {
    private Volvo240 set;
    @Before
    public void init() {
        set = new Volvo240();
        set.enginePower = 100;
        set.currentSpeed = set.getCurrentSpeed();

        set.carPosition.setPosition(0,0);
        set.carPosition.setDirection(0);


    }
    @Test
    public void testSpeedFactor(){
        assert(set.speedFactor() == 1.25);
    }

    @Test
    public void testIncrementSpeed(){
        set.incrementSpeed(2.0);
        assertTrue(set.getCurrentSpeed() == 2.5);

    }

    @Test
    public void testDecrementSpeed(){
        set.decrementSpeed(2.0);
        assertTrue(set.getCurrentSpeed() == 0);
    }

    @Test
    public void testMoveUp() {
        set.carPosition.move();
        assertTrue(set.carPosition.getPosition().getY() == set.getCurrentSpeed() && set.carPosition.getPosition().getX() == 0);
    }
    @Test
    public void testMoveDown() {
        set.carPosition.move();
        assertTrue(set.carPosition.getPosition().getY() == -set.getCurrentSpeed() && set.carPosition.getPosition().getX() == 0);
    }
    @Test
    public void testMoveRight() {
        set.carPosition.move();
        assertTrue(set.carPosition.getPosition().getX() == set.getCurrentSpeed() && set.carPosition.getPosition().getY() == 0);
    }
    @Test
    public void testMoveLeft() {
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
        // returns -90???
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
