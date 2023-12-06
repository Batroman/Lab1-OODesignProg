package src.Model;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;

public class CarTransporter extends Vehicle{
    private Truckbed truckbedParent;
    private Storage<Cars> storageParent;

    public CarTransporter(int nrDoors,
                          double enginePower,
                          Color color,
                          String modelName,
                          String direction,
                          double xPos,
                          double yPos,
                          int maxLoadingCapacity){

        super(nrDoors, enginePower, color, modelName, direction, xPos, yPos);
        this.truckbedParent = new Truckbed();
        this.storageParent = new Storage<>(maxLoadingCapacity);
    }
    public int getTruckbedAngle() {
        return truckbedParent.getTruckbedAngle();
    }

    protected ArrayList<Cars> getLoadedCars(){return storageParent.getContents();}
    public void reduceTruckbedAngle() {
        if (getCurrentSpeed() == 0) {
            truckbedParent.reduceTruckbedAngle(70);
        }
    }
    public void increaseTruckbedAngle() {
        if (getCurrentSpeed() == 0) {
            truckbedParent.increaseTruckbedAngle(70);
        }
    }
    @Override
    public void startEngine() {
        if (getTruckbedAngle() == 0) {
            currentSpeed = 0.1;
        }
    }
    protected boolean checkDistance(Cars car) {
        double distance = Point2D.distance(getXPosition(), getYPosition(),
                car.getXPosition(), car.getYPosition());
        if (distance <= 2) {
            return true;
        }
        else {return false;}
    }

    protected void loadCarTransporter(Cars car) {
        if (checkDistance(car) && (getTruckbedAngle() == 0)) {
            storageParent.loadStorage(car);
            car.setPosition(getXPosition(), getYPosition());
        }
    }

    protected void unloadCarTransporter(){
        if(getTruckbedAngle() == 0 && getCurrentSpeed() == 0){
            storageParent.unloadStorage();
        }
    }

    @Override
    public void move() {
        super.move();
        double transportXPos = getXPosition();
        double transportYPos = getYPosition();
        String transportDir = getDirection();
        for(Vehicle contents: storageParent.getContents()){
            contents.setPosition(transportXPos,transportYPos);
            contents.setDirection(transportDir);
        }
    }

}
