package src;

import src.Model.Vehicle;
import src.Model.VehicleFactory;
import src.VC.*;


import java.awt.*;
import java.util.ArrayList;

public class Application {

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private static final int delay = 50;

    private CarController cc;

    private VehicleAnimator animator = null;

    public static ArrayList<Vehicle> vehicleList = new ArrayList<>();

    protected Application() {
        Vehicle Volvo240 = VehicleFactory.createVolvo240(4,100, Color.black,"Volvo240","E",1,0);
        Vehicle Saab95 = VehicleFactory.createSaab95(2, 125, Color.red, "Saab95", "E", 1,100);
        Vehicle Scania = VehicleFactory.createScania(2,250,Color.black,"Scania","E",1,200);

        vehicleList.add(Volvo240);
        vehicleList.add(Saab95);
        vehicleList.add(Scania);

        DrawPanel drawPanel;
        drawPanel = new DrawPanel(800, 560, vehicleList);

        CarView frame;
        frame = new CarView("CarSim 1.0", drawPanel);

        CarController cc = new CarController(frame, vehicleList);

        animator = new VehicleAnimator(vehicleList);
        animate(drawPanel);
    }

    public static void main(String[] args){
        Application app = new Application();
    }

    public void animate(DrawPanel drawPanel){
        animator.animate(drawPanel);
    }
    public void addListener(TimerObserver l){
        animator.addListener(l);
    }

}
