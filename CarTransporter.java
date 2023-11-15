import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;

public class CarTransporter extends Truck{

    protected ArrayList<String> loadedCars = new ArrayList<>(6);

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

 /*   @Override
    public void startEngine() {
        if (getTruckbedAngle() == 0) {
            currentSpeed = 0.1;
        }
    }*/

    public boolean checkDistance(Car other) {
        double distance = Point2D.distance(getXPosition(), getYPosition(),
                other.getXPosition(), other.getYPosition());
        if (distance <= 2) {
            return true;
        }
        else {return false;}
    }

    protected void loadCarTransporter(Car other) {
        if (checkDistance(other) && getTruckbedAngle() == 0) {
            loadedCars.add(other.getModelName());
        }
       other.getPosition() = getPosition();
    }

    protected void unloadCarTransporter(){
        if(getTruckbedAngle() == 0){
            loadedCars.remove(loadedCars.size()-1);
            loadedCars.get(loadedCars.size() - 1);
        }

    }
}