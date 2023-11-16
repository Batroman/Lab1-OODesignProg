import java.awt.*;
import java.awt.geom.Point2D;

public class CarTransporter extends Vehicle{
    private Truckbed truckbedParent;
    private Storage<Vehicle> storageParent;

    private final int maxLoadingCapacity = 6;

    public CarTransporter(int nrDoors,
                          double enginePower,
                          Color color,
                          String modelName,
                          int direction,
                          double xPos,
                          double yPos){

        super(nrDoors, enginePower, color, modelName, direction, xPos, yPos);
        this.truckbedParent = new Truckbed();
        this.storageParent = new Storage<>(maxLoadingCapacity);
    }
    protected double getTruckbedAngle() {
        return truckbedParent.getTruckbedAngle();
    }

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
    public boolean checkDistance(Vehicle other) {
        double distance = Point2D.distance(getXPosition(), getYPosition(),
                other.getXPosition(), other.getYPosition());
        if (distance <= 2) {
            return true;
        }
        else {return false;}

        //Do we need to test this.
    }

    protected void loadCarTransporter(Vehicle car) {
        if (checkDistance(car) && getTruckbedAngle() == 0 && !(car instanceof CarTransporter)) {
            storageParent.loadStorage(car);
            car.setPosition(getXPosition(), getYPosition());
        }
    }

    protected void unloadCarTransporter(){
        if(getTruckbedAngle() == 0 && getCurrentSpeed() == 0){
            storageParent.unloadStorage();
            //car to be unloaded
            //Vehicle unloadedCar = (Vehicle) storageParent.loadedCars.get(storageParent.loadedCars.size()-1);

            // set new position for unloaded car:
            // unloadedCar.setPosition(getXPosition()-1, getYPosition()-1);
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
