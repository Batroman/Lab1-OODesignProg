import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.awt.*;

public class TestScania {

    private Scania set;

    @Before
    public void init(){
        set = new Scania(2, 250, Color.green, "ScaniaTruck", 0, 0, 0);
        set.currentSpeed = 0;

    }
    @Test
    public void testReduceTruckbedAngleOutOfRange(){
        set.reduceTruckbedAngle(30);
        assertEquals(set.getTruckbedAngle(), 0,0);
    }

    @Test
    public void testReduceTruckbedAngle(){
        set.increaseTruckbedAngle(50);
        set.reduceTruckbedAngle(30);
        assertEquals(set.getTruckbedAngle(), 20,0);
    }

    @Test
    public void testIncreaseTruckbedAngle(){
        set.increaseTruckbedAngle(40);
        assertEquals(set.getTruckbedAngle(), 40,0);
    }
    @Test
    public void testIncreaseTruckbedAngleOutOfRange(){
        set.increaseTruckbedAngle(80);
        assertEquals(set.getTruckbedAngle(), 70,0);
    }
    @Test
    public void testStartEngine(){
        set.startEngine();
        assertEquals(set.currentSpeed, 0.1,0);
    }
}
