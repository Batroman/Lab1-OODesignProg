import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class TestCarTransporter {

    private CarTransporter set;
    private Volvo240 VolvoObj;
    private Saab95 SaabObj;

    private CarTransporter transport;

    @Before
    public void init() {
        set = new CarTransporter(2, 250, Color.green, "ScaniaVabis", 0, 0, 0,6);
        set.currentSpeed = 0;

        transport = new CarTransporter(2, 250, Color.green, "ScaniaVabis", 0, 0, 0,6);

        VolvoObj = new Volvo240(4,100, Color.black,"Volvo240",0,0,0);
        VolvoObj.currentSpeed = 0;

        SaabObj = new Saab95(2, 125, Color.red, "Saab95", 0, 5,5);

    }

    @Test
    public void testReduceTruckbedAngle(){
        set.reduceTruckbedAngle();
        assertEquals(set.getTruckbedAngle(), +0,0);
    }

    @Test
    public void testIncreaseTruckbedAngle(){
        set.increaseTruckbedAngle();
        assertEquals(set.getTruckbedAngle(),70,0);
    }
   @Test
    public void testStartEngine(){
        set.startEngine();
        assertEquals(set.currentSpeed, 0.1,0);
    }

    @Test
    public void testLoadCarTransporter() {
        set.loadCarTransporter(VolvoObj);
        assertTrue(set.getLoadedCars().contains(VolvoObj));
    }
    @Test
    public void testLoadCarTransporterWithNotLoadableCar(){
        set.loadCarTransporter(SaabObj);
        assertTrue(set.getLoadedCars().isEmpty());
    }
    @Test
    public void testLoadCarTransportWithOtherCarTransport(){
        set.loadCarTransporter(transport);
        assertTrue(set.getLoadedCars().isEmpty());
    }

    @Test
    public void testLoadCarTransporterMaxLoad() {
       for (int i = 0; i < set.getLoadedCars().size() + 2; i++) {
            set.loadCarTransporter(VolvoObj);
        }
        assertTrue(set.getLoadedCars().size() == 6);
    }
    @Test
    public void testUnloadCarTransporter(){
        set.loadCarTransporter(VolvoObj);
        set.unloadCarTransporter();
        assertTrue(set.getLoadedCars().isEmpty());
    }
    @Test
    public void testUnloadedCarNewPos(){
        set.loadCarTransporter(VolvoObj);
        set.unloadCarTransporter();
        assertTrue(VolvoObj.getXPosition() == -1.0 && VolvoObj.getYPosition() == -1.0);
    }

    @Test
    public void testMovesTheLoadedCars(){
        set.loadCarTransporter(VolvoObj);
        set.currentSpeed = 2;
        set.move();
        assertEquals(VolvoObj.getPosition(), set.getPosition());
    }
}

