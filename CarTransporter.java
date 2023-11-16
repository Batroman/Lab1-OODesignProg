import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;

public class CarTransporter extends Vehicle{
    private Truckbed truckbedParent;
    private Storage storageParent;

    public int maxLoadingCapacity = 6;
    protected ArrayList<String> loadedCars = new ArrayList<>(maxLoadingCapacity);

    public CarTransporter(int nrDoors,
                          double enginePower,
                          Color color,
                          String modelName,
                          int direction,
                          double xPos,
                          double yPos){

        super(nrDoors, enginePower, color, modelName, direction, xPos, yPos);
        this.truckbedParent = new Truckbed();
        this.storageParent = new Storage();
    }
    public double getTruckbedAngle() {
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
    }

    protected void loadCarTransporter(Vehicle other) {
        if (checkDistance(other) && getTruckbedAngle() == 0 && loadedCars.size() < maxLoadingCapacity) {
            storageParent.loadCarTransporter(other);
            other.setPosition(getXPosition(), getYPosition()); //set loaded car's pos to same as transporter
        }
    }

    protected void unloadCarTransporter(){
        if(getTruckbedAngle() == 0 && getCurrentSpeed() == 0){

            //car to be unloaded
            Vehicle unloadedCar = storageParent.loadedCars.get(storageParent.loadedCars.size()-1);

            storageParent.unloadCarTransporter();

            // set new position for unloaded car
            unloadedCar.setPosition(getXPosition()-1, getYPosition()-1);
        }

    }

    @Override
    public void move() {
        double xPosition = getPosition().getX();
        double yPosition = getPosition().getY();
        switch (getDirection()) {
            case 0:
                yPosition += getCurrentSpeed();
                break;
            case 180:
                yPosition -= getCurrentSpeed();
                break;
            case 90:
                xPosition += getCurrentSpeed();
                break;
            case 270:
                xPosition -= getCurrentSpeed();
                break;
        }
        setPosition(xPosition, yPosition);
        moveLoadedCars();
    }

    private void moveLoadedCars() {
        for (Vehicle vehicle : storageParent.loadedCars) {
            vehicle.setPosition(getXPosition(), getYPosition());
        }
    }


}