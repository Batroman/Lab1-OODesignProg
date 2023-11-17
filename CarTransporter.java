import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;

public class CarTransporter extends Vehicle{
    private Truckbed truckbedParent;
    private Storage<Vehicle> storageParent;

    public CarTransporter(int nrDoors,
                          double enginePower,
                          Color color,
                          String modelName,
                          int direction,
                          double xPos,
                          double yPos,
                          int maxLoadingCapacity){

        super(nrDoors, enginePower, color, modelName, direction, xPos, yPos);
        this.truckbedParent = new Truckbed();
        this.storageParent = new Storage<>(maxLoadingCapacity);
    }
    protected int getTruckbedAngle() {
        return truckbedParent.getTruckbedAngle();
    }

    protected ArrayList getLoadedCars(){return storageParent.getContents();}
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
    protected boolean checkDistance(Vehicle other) {
        double distance = Point2D.distance(getXPosition(), getYPosition(),
                other.getXPosition(), other.getYPosition());
        if (distance <= 2) {
            return true;
        }
        else {return false;}
    }

    protected void loadCarTransporter(Vehicle car) {
        if (checkDistance(car) && !(car instanceof CarTransporter) && (getTruckbedAngle() == 0)) {
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
        int transportDir = getDirection();
        for(Vehicle contents: storageParent.getContents()){
            contents.setPosition(transportXPos,transportYPos);
            contents.setDirection(transportDir);
        }
    }

}
