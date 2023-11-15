import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class TestCarTransporter {

    private CarTransporter CarTransporterObj;
    private Volvo240 VolvoObj;
    private Saab95 SaabObj;

    @Before
    public void init() {
        CarTransporterObj = new CarTransporter(2, 250, Color.green, "ScaniaVabis", 0, 0, 0);
        CarTransporterObj.currentSpeed = 0;

        VolvoObj = new Volvo240(4,100, Color.black,"Volvo240",0,0,0);
        VolvoObj.currentSpeed = 0;

        SaabObj = new Saab95(2, 125, Color.red, "Saab95", 0, 5,5);
    }

    @Test
    public void testLoadCarTransporter() {
        CarTransporterObj.loadCarTransporter(VolvoObj);
        CarTransporterObj.loadCarTransporter(VolvoObj);
        CarTransporterObj.loadCarTransporter(VolvoObj);
        CarTransporterObj.loadCarTransporter(VolvoObj);
        CarTransporterObj.loadCarTransporter(VolvoObj);
        CarTransporterObj.loadCarTransporter(VolvoObj);
        CarTransporterObj.loadCarTransporter(SaabObj);
        System.out.println(CarTransporterObj.loadedCars);
    }

    @Test
    public void testLoadCarTransporterMaxLoad() {
        for (int i = 0; i < CarTransporterObj.maxLoadingCapacity + 3; i++) {
            CarTransporterObj.loadCarTransporter(VolvoObj);
        }
        assertTrue(CarTransporterObj.loadedCars.size() >= CarTransporterObj.maxLoadingCapacity);
    }
}
