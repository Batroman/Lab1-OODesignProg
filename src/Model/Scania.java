package src.Model;

import java.awt.*;

public class Scania extends Vehicle{
    private Truckbed parent;
    public Scania(int nrDoors,
                  double enginePower,
                  Color color,
                  String modelName,
                  String direction,
                  double xPos,
                  double yPos) {

        super(nrDoors, enginePower, color, modelName, direction, xPos, yPos);
        stopEngine();
        this.parent = new Truckbed();
    }
    public int getTruckbedAngle() {
        return parent.getTruckbedAngle();
    }
    public void reduceTruckbedAngle(int angle) {
        if (getCurrentSpeed() == 0 && angle > 0) {
            parent.reduceTruckbedAngle(angle);
        }
    }

    public void increaseTruckbedAngle(int angle) {
        if (getCurrentSpeed() == 0 && angle > 0) {
            parent.increaseTruckbedAngle(angle);
        }
    }

    @Override
    public void startEngine() {
        if (getTruckbedAngle() == 0) {
            currentSpeed = 0.1;
        }
    }
}




