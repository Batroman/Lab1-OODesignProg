package src.VC;

import src.Model.Saab95;
import src.Model.Scania;
import src.Model.Vehicle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* Its responsibilities are to listen to the View and respond in an appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The frame that represents this instance View of the MVC pattern
    CarView frame;




    // A list of cars
    ArrayList<Vehicle> cars = new ArrayList<>();

    // CarController accepts a CarView-object AND an ArrayList of Vehicles
    public CarController(CarView frame, ArrayList<Vehicle> vehicleList) {
        this.frame = frame;

        cars = vehicleList;

        // Listeners for CarView
        frame.gasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gas(frame.gasAmount);
            }
        });
        frame.brakeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { brake(frame.gasAmount);
            }
        });
        frame.turboOnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {turboOn();
            }
        });
        frame.turboOffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { turboOff();
            }
        });
        frame.liftBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {liftBed();
            }
        });
        frame.lowerBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {lowerBed();
            }
        });
        frame.startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {startAllCars();
            }
        });
        frame.stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {stopAllCars();
            }
        });

    }
    //Methods

    protected static void reverseCarAtWindowEdge(Vehicle car) {
        if(car.getXPosition() <= 0 || car.getXPosition() >= 800-110){
            car.turnLeft();
            car.turnLeft();
        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle car : cars
                ) {
            car.gas(gas);
        }
    }
    void brake(int amount){
        double brake = ((double)amount/ 100);
        for (Vehicle car : cars){
            car.brake(brake);
        }
    }

    void startAllCars(){
        for (Vehicle car : cars){
            car.startEngine();
        }
    }

    void stopAllCars(){
        for (Vehicle car : cars){
            car.stopEngine();
        }
    }


    void turboOn(){
        for (Vehicle car: cars){
            if (car instanceof Saab95)
                ((Saab95) car).setTurboOn();
        }
    }

    void turboOff(){
        for (Vehicle car: cars){
            if (car instanceof Saab95)
                ((Saab95) car).setTurboOff();
        }
    }

    void liftBed(){
        for (Vehicle car: cars){
            if (car instanceof Scania)
                ((Scania) car).increaseTruckbedAngle(10);

        }
    }

    void lowerBed(){
        for (Vehicle car: cars){
            if (car instanceof Scania){
                ((Scania) car).reduceTruckbedAngle(10);
            }
        }
    }

}
