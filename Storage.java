import java.util.ArrayList;

public class Storage {

    public ArrayList loadedCars;

    public Storage(int maxLoadingCapacity) {
        ArrayList<Vehicle> loadedCars = new ArrayList<>(maxLoadingCapacity);
    }

    protected void loadStorage(Vehicle other, int maxLoad) {
        if (loadedCars.size() < maxLoad && !(other instanceof CarTransporter)) {}
            loadedCars.add(other);
    }

    protected void unloadStorage(){
            loadedCars.remove(loadedCars.size()-1);
    }

    protected void moveLoadedCar(){

    }


}
