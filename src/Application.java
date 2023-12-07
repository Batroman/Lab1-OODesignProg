package src;

import src.Model.Vehicle;
import src.Model.VehicleFactory;
import src.VC.CarController;
import src.VC.CarView;
import src.VC.DrawPanel;

import java.awt.*;
import java.util.ArrayList;

public class Application {

    public static ArrayList<Vehicle> vehicleList = new ArrayList<>();

    public static void main(String[] args){

        Vehicle Volvo240 = VehicleFactory.createVolvo240(4,100, Color.black,"Volvo240",1,0);
        Vehicle Saab95 = VehicleFactory.createSaab95(2, 125, Color.red, "Saab95",  1,100);
        Vehicle Scania = VehicleFactory.createScania(2,250,Color.black,"Scania",1,200);

        vehicleList.add(Volvo240);
        vehicleList.add(Saab95);
        vehicleList.add(Scania);


        DrawPanel drawPanel = new DrawPanel(800,560, vehicleList);
        CarView frame = new CarView("CarSim 1.0", drawPanel);

        CarController cc = new CarController(vehicleList, frame);
    }

}
