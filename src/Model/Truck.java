package src.Model;
import java.awt.*;

public abstract class Truck extends Vehicle{

    protected int currentTruckbedAngle;

    public Truck(int nrDoors,
                 double enginePower,
                 Color color,
                 String modelName,
                 double xPos,
                 double yPos) {

        super(nrDoors, enginePower, color, modelName, xPos, yPos);

    }

    public int getTruckbedAngle() {
        return currentTruckbedAngle;
    }

    @Override
    public void startEngine() {
        if (getTruckbedAngle() == 0) {
            currentSpeed = 0.1;
        }
    }

}
