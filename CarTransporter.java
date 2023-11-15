import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;

public class CarTransporter extends Vehicle{
    private Truckbed parent;
    // private Storage storageparent;
    protected ArrayList<String> loadedCars = new ArrayList<>(6);

    public CarTransporter(int nrDoors,
                          double enginePower,
                          Color color,
                          String modelName,
                          int direction,
                          double xPos,
                          double yPos){

        super(nrDoors, enginePower, color, modelName, direction, xPos, yPos);
        this.parent = new Truckbed();
    }
    public double getTruckbedAngle() {
        return parent.getTruckbedAngle();
    }

    public void reduceTruckbedAngle() {
        if (getCurrentSpeed() == 0) {
            parent.reduceTruckbedAngle(70);
        }
    }
    public void increaseTruckbedAngle() {
        if (getCurrentSpeed() == 0) {
            parent.increaseTruckbedAngle(70);
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
        if (checkDistance(other) && getTruckbedAngle() == 0) {
            loadedCars.add(other.getModelName());
        }
        // other.getPosition() = getPosition();

    }

    protected void unloadCarTransporter(){
        if(getTruckbedAngle() == 0){
            loadedCars.remove(loadedCars.size()-1);
        }

    }
}