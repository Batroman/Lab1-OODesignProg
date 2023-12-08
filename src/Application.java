package src;

import src.Model.Vehicle;
import src.Model.VehicleFactory;
import src.VC.*;


import java.awt.*;
import java.util.ArrayList;

public class Application {

    private AnimationTicker animationTicker;

    public static ArrayList<Vehicle> vehicleList = new ArrayList<>();

    protected Application() {
        Vehicle Volvo240 = VehicleFactory.createVolvo240(4,100, Color.black,"Volvo240",1,0);
        Vehicle Saab95 = VehicleFactory.createSaab95(2, 125, Color.red, "Saab95",  150,100);
        Vehicle Scania = VehicleFactory.createScania(2,250,Color.black,"Scania",500,200);

        vehicleList.add(Volvo240);
        vehicleList.add(Saab95);
        vehicleList.add(Scania);

        DrawPanel drawPanel;
        drawPanel = new DrawPanel(800, 560, vehicleList);

        CarView frame;
        frame = new CarView("CarSim 1.0", drawPanel);

        CarController cc;
        cc = new CarController(frame, vehicleList);

        animationTicker = new AnimationTicker();

        addListener(cc);
        addListener(drawPanel);
        animate();
    }

    public static void main(String[] args){
        Application app = new Application();
    }

    // Delegate these methods to the AnimationTicker-class:
    public void animate(){
        animationTicker.animate();
    }
    public void addListener(AnimationTickerObserver observer){
        animationTicker.addObserver(observer);
    }

}
