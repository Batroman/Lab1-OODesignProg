import java.util.ArrayList;

public class CarWorkshop<T extends Vehicle> {
    private Storage<T> parent;
    public CarWorkshop(int maxLoadingCapacity){
        this.parent = new Storage<>(maxLoadingCapacity);
    }
    protected ArrayList<T> getLoadedCars(){
        return parent.getContents();
    }
    protected void loadWorkshop(T car) {
        parent.loadStorage(car);
    }
    protected void unloadWorkshop(T car){
        parent.unloadStorage();
    }
}



