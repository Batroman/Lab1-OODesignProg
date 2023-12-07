package src.Model;

abstract class TruckbedState {
    abstract void raise(Truckbed truck);
    abstract void lower(Truckbed truck);
    void printStatus() {}

}
