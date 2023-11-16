import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.util.Objects;

import static org.junit.Assert.*;

public class TestCarTransporter {

    private CarTransporter set;
    private Volvo240 VolvoObj;
    private Saab95 SaabObj;

    private Storage storageset;

    @Before
    public void init() {
        set = new CarTransporter(2, 250, Color.green, "ScaniaVabis", 0, 0, 0);
        set.currentSpeed = 0;

        VolvoObj = new Volvo240(4,100, Color.black,"Volvo240",0,0,0);
        VolvoObj.currentSpeed = 0;

        SaabObj = new Saab95(2, 125, Color.red, "Saab95", 0, 5,5);

        storageset = new Storage(6);
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
        assertEquals(storageset.loadedCars.size(),1,0);
    }

    @Test
    public void testLoadCarTransporterMaxLoad() {
       for (int i = 0; i < set.maxLoadingCapacity + 3; i++) {
            set.loadCarTransporter(VolvoObj);
        }
        assertTrue(storageset.loadedCars.size() >= set.maxLoadingCapacity);
    }

    @Test
    public void testUnloadCarTransporter(){
        set.loadCarTransporter(VolvoObj);
        set.unloadCarTransporter();
        assertTrue(storageset.loadedCars.isEmpty());

    }
}

