package src;

import src.Model.Vehicle;
import src.Model.VehicleFactory;
import src.VC.CarController;

import java.awt.*;
import java.util.ArrayList;

public class Application {

    public ArrayList<Vehicle> vehicleList = new ArrayList<>();

    public static void main(String[] args){

        Vehicle Volvo240 = VehicleFactory.createVolvo240(4,100, Color.black,"Volvo240","E",1,0);
        Vehicle Saab95 = VehicleFactory.createSaab95(2, 125, Color.red, "Saab95", "E", 1,100);
        Vehicle Scania = VehicleFactory.createScania(2,250,Color.black,"Scania","E",1,200);

        CarController cc = new CarController(Volvo240, Saab95, Scania);

    }

}
