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
}
