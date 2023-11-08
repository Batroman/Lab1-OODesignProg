import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestSaab {

    private Saab95 set;
    @Before
    public void init(){
        set = new Saab95();
        set.enginePower = 125;
    }

    @Test
    public void testSpeedFactorTurboOff(){
        set.setTurboOff();
        double speedFact = set.enginePower * 1 * 0.01;
        assertTrue(set.speedFactor() == speedFact);
    }

    @Test
    public void testSpeedFactorTurboOn(){
        set.setTurboOn();
        double speedFact = set.enginePower * 1.3 * 0.01;
        assertTrue(set.speedFactor() == speedFact);
    }

    @Test
    public void testIncrementSpeed(){
        set.incrementSpeed(2.0);
        assertTrue(set.getCurrentSpeed() == 2.5);

    }

    @Test
    public void testDecrementSpeed() {
        set.decrementSpeed(2.0);
        assertTrue(set.getCurrentSpeed() == -2.5);
    }
}
