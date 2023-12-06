package src.VC;

import src.Model.Saab95;
import src.Model.Scania;
import src.Model.Vehicle;

import javax.swing.*;
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

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener(this));

    // The frame that represents this instance View of the MVC pattern
    CarView frame;

    // A list of cars
    ArrayList<Vehicle> cars = new ArrayList<>();


    // CarController accepts an arbitrary number of objects of type Vehicle
    public CarController(Vehicle... list) {

        //Adding each vehicle to the ArrayList 'cars'
        for (Vehicle vehicle: list) {
            cars.add(vehicle);
        }

        this.frame = new CarView("CarSim 1.0", this);

        // Start the timer
        this.timer.start();

        // Listeners for CarView
        this.frame.gasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gas(frame.gasAmount);
            }
        });
        this.frame.brakeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { brake(frame.gasAmount);
            }
        });
        this.frame.turboOnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {turboOn();
            }
        });
        this.frame.turboOffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { turboOff();
            }
        });
        this.frame.liftBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {liftBed();
            }
        });
        this.frame.lowerBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {lowerBed();
            }
        });
        this.frame.startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {startAllCars();
            }
        });
        this.frame.stopButton.addActionListener(new ActionListener() {
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
