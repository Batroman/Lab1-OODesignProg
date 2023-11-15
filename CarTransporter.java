import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;

public class CarTransporter extends Truck{

    public int maxLoadingCapacity = 6;
    public ArrayList<String> loadedCars = new ArrayList<String>();

    public CarTransporter(int nrDoors,
                          double enginePower,
                          Color color,
                          String modelName,
                          int direction,
                          double xPos,
                          double yPos){

        super(nrDoors, enginePower, color, modelName, direction, xPos, yPos);
        currentTruckbedAngle = 0;
    }

    @Override
    public void reduceTruckbedAngle() {
        if (getCurrentSpeed() == 0) {
            currentTruckbedAngle = 0;
        }
        
    }

    @Override
    public void increaseTruckbedAngle() {
        if (getCurrentSpeed() == 0) {
            currentTruckbedAngle = 70;
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
            loadedCars.add(other.getModelName());
        }
    }
    
}