package src.VC;

import src.Model.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class VehicleAnimator {

    private final ArrayList<Vehicle> vehicleList;

    public VehicleAnimator(ArrayList<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
    }
    public void animate(DrawPanel drawPanel){
        try {
            while (true) {
                Thread.sleep(50);
                System.out.println("Hello");
                for(Vehicle car: vehicleList) {
                    //reverseCarAtWindowEdge(car);
                    car.move();
                    //notifyListeners();

                    // repaint() calls the paintComponent method of the panel
                    drawPanel.repaint();
                }
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
