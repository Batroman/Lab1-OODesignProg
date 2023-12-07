package src.Model;

public class LoweredState extends TruckbedState{

    public void raise(Truckbed truck){
        truck.setState(new RaisedState());
    }
    public void lower(Truckbed truck){
        System.out.println("Truckbed is already low");

    }
    public void printStatus(){
        System.out.println("Truckbed lowered");
    }
}

