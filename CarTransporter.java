import java.awt.*;
import java.awt.geom.Point2D;

public class CarTransporter extends Truck{

    protected List loadedCars = new List(6);

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

    public boolean checkDistance(Car other) {
        double distance = Point2D.distance(getXPosition(), getYPosition(),
                other.getXPosition(), other.getYPosition());
        if (getTruckbedAngle() == 0 && distance <= 2) {
            return true;
        }
        else {return false;}
    }

    protected void loadCarTransporter(Car other) {
        if (checkDistance(other)) {
            loadedCars.add(other.getModelName());
            System.out.println(other.getModelName());
        }
    }
    
}