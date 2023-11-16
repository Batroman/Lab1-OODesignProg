import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class TestCarWorkshop {

    private CarWorkshop set;
    private Storage storageset;
    private Volvo240 volvo;
    @Before
    public void init(){
        volvo = new Volvo240(4,100, Color.black,"Volvo240",0,0,0);
        set = new CarWorkshop<>(volvo,20);
    }

}
