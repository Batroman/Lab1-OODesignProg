public class CarWorkshop<T extends Vehicle> {
    private Storage parent;
    private T typeOfCar;

    public CarWorkshop(T typeOfCar){
        this.typeOfCar = typeOfCar;
        // CarWorkshop<T> NyVerkstad = new CarWorkshop<>();
    }
}

