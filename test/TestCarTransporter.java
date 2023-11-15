import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class TestCarTransporter {

    private CarTransporter CarTransporterObj;
    private Volvo240 VolvoObj;

    @Before
    public void init() {
        CarTransporterObj = new CarTransporter(2, 250, Color.green, "ScaniaVabis", 0, 0, 0);
        CarTransporterObj.currentSpeed = 0;

        VolvoObj = new Volvo240(4,100, Color.black,"Volvo240",0,0,0);
        VolvoObj.currentSpeed = 0;
    }

    @Test
    public void testLoadCarTransporter() {
        CarTransporterObj.loadCarTransporter(VolvoObj);
        System.out.println(CarTransporterObj);
    }
}
