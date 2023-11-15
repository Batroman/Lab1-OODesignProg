import java.awt.geom.Point2D;
import java.util.ArrayList;

public class Storage {

    public ArrayList<Vehicle> loadedCars = new ArrayList<Vehicle>();

    protected void loadCarTransporter(Vehicle other) {
            loadedCars.add(other);
    }

    protected void unloadCarTransporter(){
            loadedCars.remove(loadedCars.size()-1);
    }
}
