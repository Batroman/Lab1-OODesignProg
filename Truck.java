import java.awt.*;

public abstract class Truck extends Car{

    protected int currentTruckbedAngle;

    public Truck(int nrDoors,
                 double enginePower,
                 Color color,
                 String modelName,
                 int direction,
                 double xPos,
                 double yPos) {

        super(nrDoors, enginePower, color, modelName, direction, xPos, yPos);
        currentTruckbedAngle = 0;
    }

    public double getTruckbedAngle() {
        return currentTruckbedAngle;
    }

    public void reduceTruckbedAngle(int angle){}

    public void reduceTruckbedAngle(){}

    public void increaseTruckbedAngle(int angle){}

    public void increaseTruckbedAngle(){}

    @Override
    public void startEngine() {
        if (getTruckbedAngle() == 0) {
            currentSpeed = 0.1;
        }
    }

}
