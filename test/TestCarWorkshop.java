import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class TestCarWorkshop {

    private CarWorkshop<Volvo240> set;
    private CarWorkshop<Vehicle> genericworkshop;
    private Volvo240 volvo;
    private Saab95 saab;
    @Before
    public void init(){
        set = new CarWorkshop<>(5);
        volvo = new Volvo240(4,100, Color.black,"Volvo240",0,0,0);
        saab = new Saab95(2, 125, Color.red, "Saab95", 0, 5,5);
        genericworkshop = new CarWorkshop<>(3);
    }

    @Test
    public void testLoadVolvoWorkshop(){
        set.loadWorkshop(volvo);
        assertTrue(set.getLoadedCars().contains(volvo));
    }
    @Test
    public void testLoadWorkshopMaxLoad() {
        for (int i = 0; i < 7; i++) {
            set.loadWorkshop(volvo);
        }
        assertEquals(5, set.getLoadedCars().size());
    }

    @Test
    public void testUnloadVolvoWorkshop(){
        set.loadWorkshop(volvo);
        set.unloadWorkshop(volvo);
        assertTrue(set.getLoadedCars().isEmpty());
    }
    @Test
    public void testLoadGenericWorkshop(){
        genericworkshop.loadWorkshop(volvo);
        genericworkshop.loadWorkshop(saab);
        assertTrue(genericworkshop.getLoadedCars().contains(volvo) && genericworkshop.getLoadedCars().contains(saab));
    }

    @Test
    public void testUnloadGenericWorkshop(){

    }

}
