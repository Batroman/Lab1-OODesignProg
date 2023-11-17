import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;


public class TestVolvo {
    private Volvo240 set;
    @Before
    public void init() {
        set = new Volvo240(4,100, Color.black,"Volvo240","N",0,0);
        set.currentSpeed = 1;
    }
    @Test
    public void testSpeedFactor(){
        assert(set.speedFactor() == 1.25);
    }

    @Test
    public void testIncrementSpeed(){
        set.incrementSpeed(0.5);
        assertEquals(1.625, set.getCurrentSpeed(), 0.0);

    }

    @Test
    public void testDecrementSpeed(){
        set.decrementSpeed(0.5);
        assertEquals(0.375, set.getCurrentSpeed(), 0.0);
    }
}
