package src.Model;

public class Truckbed {

    private int currentTruckbedAngle;
    private TruckbedState state;

    public Truckbed() {
        this.state = new LoweredState();
    }
    public void setState(TruckbedState state){
        this.state = state;
    }
    public int getTruckbedAngle() {
        return currentTruckbedAngle;
    }
    public void raise(int angle){
        state.raise(this);
        if (angle > 0) {
            currentTruckbedAngle = Math.min(currentTruckbedAngle + angle, 70);
        }
    }

    public void lower(int angle){
        state.lower(this);
        if (angle > 0) {
            currentTruckbedAngle = Math.max(currentTruckbedAngle - angle, 0);
        }
    }

    public void printStatus(){
        state.printStatus();
    }
}
