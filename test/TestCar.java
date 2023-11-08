import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestCar {

    private Car set;

    @Before
    public void init() {
        set = new Car();
        set.currentSpeed = 50;

    }

    @Test
    public void testMove() {
        /*set.Position.move();
        set.Movable.move();

        Position pos;
        pos = new Position();*/
    }
}
