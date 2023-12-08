package src.VC;

import src.Model.Saab95;
import src.Model.Scania;
import src.Model.Vehicle;
import src.Model.VehicleFactory;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/*
* This class represents the Controller part in the MVC pattern.
* Its responsibilities are to listen to the View and respond in an appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController implements AnimationTickerObserver {
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
    //Methods

    protected static void reverseCarAtWindowEdge(Vehicle car) {
        if(car.getPosition().x < 0 || car.getPosition().x >= 800-110){
            car.turnLeft();
            car.turnLeft();
        }
        if(car.getPosition().y < 0 || car.getPosition().y >= 500){
            car.turnRight();
            car.turnRight();
        }
    }

    // Listener for AnimationTicker
    @Override
    public void actOnAnimationTicker() {
        for (Vehicle car: cars) {
            reverseCarAtWindowEdge(car);
            car.move();
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
        int x = randomNumber.nextInt(690);
        int y = randomNumber.nextInt(500);
        if (cars.size() < 10) {
            switch (n) {
                case 0:
                    cars.add(VehicleFactory.createVolvo240(4, 100, Color.black, "Volvo240", x, y));
                    break;
                case 1:
                    cars.add(VehicleFactory.createSaab95(2, 125, Color.red, "Saab95", x, y));
                    break;
                case 2:
                    cars.add(VehicleFactory.createScania(2, 250, Color.black, "Scania", x, y));
                    break;
            }

            frame.drawPanel.addImageFilesToCars(cars);
        }
    }

    void removeCars() throws IOException {
        if (!cars.isEmpty()){
            cars.removeLast();
        }
        // Need to add function - remove images from cars in DrawPanel

    }

}
