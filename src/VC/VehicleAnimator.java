package src.VC;

import src.Model.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class VehicleAnimator {

    private final ArrayList<Vehicle> vehicleList;

    public VehicleAnimator(ArrayList<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
    }
    public void animate(){
        try {
            while (true) {
                Thread.sleep(50);
                notifyListeners();
            }
        } catch (InterruptedException e) {
            System.exit(0);
        }
    }

    private final List<TimerObserver> listeners = new ArrayList<>();

    public void addListener(TimerObserver l){
        listeners.add(l);
    }

    protected void notifyListeners(){
        for (TimerObserver l : listeners)
            l.actOnTimerChange();
    }

}
