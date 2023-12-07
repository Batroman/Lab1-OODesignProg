package src.Model;

import java.util.ArrayList;

public class CarWorkshop<T extends Cars> {
    private Storage<T> parent;
    public CarWorkshop(int maxLoadingCapacity){
        this.parent = new Storage<>(maxLoadingCapacity);
    }
    public ArrayList<T> getLoadedCars(){
        return parent.getContents();
    }
    public void loadWorkshop(T car) {
        parent.loadStorage(car);
    }
    public void unloadWorkshop(){
        parent.unloadStorage();
    }
}



