package src.Model;

public class RaisedState extends TruckbedState{

    public void lower(Truckbed truck){
        truck.setState(new LoweredState());
    }

    public void raise(Truckbed truck){
        System.out.println("Truckbed is already raised");
    }
    public void printStatus(){
        System.out.println("Truckbed raised");
    }
}
