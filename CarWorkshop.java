public class CarWorkshop<T extends Vehicle> {
    private Storage<T> parent;
    private T typeOfVehicle;

    private final int maxLoadingCapacity = 20;
    public CarWorkshop(T typeOfVehicle, int maxLoadingCapacity){
        this.typeOfVehicle = typeOfVehicle;
        this.parent = new Storage<>(maxLoadingCapacity);
        // CarWorkshop<T> NyVerkstad = new CarWorkshop<>();
    }
    protected void loadWorkshop(T typeOfVehicle) {
        parent.loadStorage(typeOfVehicle);
    }

    protected void unloadWorkshop(T typeOfVehicle){
        parent.unloadStorage();
    }
}



