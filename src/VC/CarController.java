package src.VC;

import src.Application;
import src.Model.Saab95;
import src.Model.Scania;
import src.Model.Vehicle;
import src.Model.VehicleFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.http.WebSocket;
import java.util.ArrayList;
import java.util.Random;
import java.util.random.RandomGenerator;

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
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;

    // A list of cars
    ArrayList<Vehicle> cars = new ArrayList<>();


    // CarController accepts an arbitrary number of objects of type Vehicle
    public CarController(ArrayList<Vehicle> vehicles, CarView frame) {
        this.frame = frame;
        cars = vehicles;

      //  this.frame = new CarView("CarSim 1.0", this);

        // Start the timer
        this.timer.start();

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

        frame.addCarsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    addCars();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        frame.removeCarsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    removeCars();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

    }
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Vehicle car : cars) {
                reverseCarAtWindowEdge(car);
                car.move();
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
        }
    }
    //Methods

    protected static void reverseCarAtWindowEdge(Vehicle car) {
        if(car.getPosition().x <= 0 || car.getPosition().y >= 800-110){
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
                ((Scania) car).raiseTruckbed(10);

        }
    }

    void lowerBed(){
        for (Vehicle car: cars){
            if (car instanceof Scania){
                ((Scania) car).lowerTruckbed(10);
            }
        }
    }


    void addCars() throws IOException {
        Random randomNumber = new Random();
        int n = randomNumber.nextInt(3);
        if (frame.drawPanel.cars.size() < 10) {
            switch (n) {
                case 0:
                    frame.drawPanel.cars.add(VehicleFactory.createVolvo240(4, 100, Color.black, "Volvo240", 1, 0));
                    break;
                case 1:
                    frame.drawPanel.cars.add(VehicleFactory.createSaab95(2, 125, Color.red, "Saab95",  1,  100));
                    break;
                case 2:
                    frame.drawPanel.cars.add(VehicleFactory.createScania(2, 250, Color.black, "Scania",  1, 200));
                    break;
            }
            frame.drawPanel.addImageFilesToCars(cars);
        }

        //Add a car to a random location - not the same as existing car.
    }


    void removeCars() throws IOException {
        if (!frame.drawPanel.cars.isEmpty()){
            frame.drawPanel.cars.removeLast();
        }
        // Need to add function - remove images from cars in DrawPanel

    }

}

