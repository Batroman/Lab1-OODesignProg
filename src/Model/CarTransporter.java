package src.Model;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;

public class CarTransporter extends Truck{
    private Truckbed truckbedParent;
    private Storage<Cars> storageParent;

    public CarTransporter(int nrDoors,
                          double enginePower,
                          Color color,
                          String modelName,
                          double xPos,
                          double yPos,
                          int maxLoadingCapacity){

        super(nrDoors, enginePower, color, modelName, xPos, yPos);
        this.truckbedParent = new Truckbed();
        this.storageParent = new Storage<>(maxLoadingCapacity);
    }
    @Override
    public int getTruckbedAngle() {
        return truckbedParent.getTruckbedAngle();
    }

    public ArrayList<Cars> getLoadedCars(){return storageParent.getContents();}

    public void lowerTruckbed() {
        if (getCurrentSpeed() == 0) {
            truckbedParent.lower(70);
        }
    }
    public void raiseTruckbed() {
        if (getCurrentSpeed() == 0) {
            truckbedParent.raise(70);
        }
    }
    @Override
    public void startEngine() {
        if (getTruckbedAngle() == 0) {
            currentSpeed = 0.1;
        }
    }
    protected boolean checkDistance(Cars car) {
        double distance = Point2D.distance(getPosition().x, getPosition().y,
                car.getPosition().x, car.getPosition().y);
        if (distance <= 2) {
            return true;
        }
        else {return false;}
    }

    public void loadCarTransporter(Cars car) {
        if (checkDistance(car) && (getTruckbedAngle() == 0)) {
            storageParent.loadStorage(car);
            car.getPosition().setLocation(getPosition().x, getPosition().y);
        }
    }

    public void unloadCarTransporter(){
        if(getTruckbedAngle() == 0 && getCurrentSpeed() == 0){
            storageParent.unloadStorage();
        }
    }

    @Override
    public void move() {
        super.move();
        double transportXPos = getPosition().x;
        double transportYPos = getPosition().y;
        Direction transportDir = getDirection();
        for(Vehicle contents: storageParent.getContents()){
            contents.setPosition(transportXPos,transportYPos);
            contents.setDirection(transportDir);
        }
    }

}
