import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class TestSaab {

    private Saab95 set;
    @Before
    public void init(){
        set = new Saab95(2, 125, Color.red, "Saab95", 0, 5,5);
        set.currentSpeed = 1;
    }

    @Test
    public void testSpeedFactorTurboOff(){
        set.setTurboOff();
        double speedFact = set.getEnginePower() * 1 * 0.01;
        assertTrue(set.speedFactor() == speedFact);
    }

    @Test
    public void testSpeedFactorTurboOn(){
        set.setTurboOn();
        double speedFact = set.getEnginePower() * 1.3 * 0.01;
        assertTrue(set.speedFactor() == speedFact);
    }

    @Test
    public void testIncrementSpeed(){
        set.incrementSpeed(0.5);
        assertTrue(set.getCurrentSpeed() == 1.625);

    }

    @Test
    public void testDecrementSpeed() {
        set.decrementSpeed(0.5);
        assertTrue(set.getCurrentSpeed() == 0.375);
    }
}
