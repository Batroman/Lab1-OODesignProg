import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class TestCar {

    private Car set;

    @Before
    public void init() {
        set = new Car();
    }


    @Test
    public void testGetNrDoors(){
        assertTrue(set.nrDoors == set.getNrDoors());
    }
    @Test
    public void testGetEnginePower(){
        assertTrue(set.enginePower == set.getEnginePower());
    }
    @Test
    public void testGetColor(){
        assertTrue(set.color == set.getColor());
    }
    @Test
    public void testSetColor(){
        set.setColor(Color.red);
        assertTrue(set.color == Color.red);

    }
    @Test
    public void testStartEngineSpeed(){
        set.startEngine();
        assertTrue(set.currentSpeed == 0.1);
    }
    @Test
    public void testSpeedFactor(){
        assertTrue(set.speedFactor() == 0);
    }
    @Test
    public void testIncrementSpeed(){

    }
    @Test
    public void testDecrementSpeed(){

    }
    @Test
    public void testBrake(){

    }
    @Test
    public void testGas(){

    }

}


