import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestClass {
    private Volvo240 set;
    @Before
    public void init() {
        set = new Volvo240();
        set.enginePower = 100;
        set.currentSpeed = set.getCurrentSpeed();


        set.position.setLocation(0, 0);
        set.direction = 0;

    }
    @Test
    public void testSpeedFactor(){
        assertTrue(set.speedFactor() == 1.25);
    }

    @Test
    public void testIncrementSpeed(){
        double speed1 = set.getCurrentSpeed() + set.speedFactor() * amount;

        if(speed1 < set.enginePower){
            assertTrue(set.currentSpeed == speed1);
        }
        else{
            assertTrue(set.currentSpeed == set.enginePower);
        }


    }

    @Test
    public void testMove() {
        //set.Position.Movable.move();
    }

    public void testTurnLeft() {

    }

    public void testTurnRight() {

    }

}
