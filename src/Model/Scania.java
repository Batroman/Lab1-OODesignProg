package src.Model;

import java.awt.*;

public class Scania extends Truck{
    private Truckbed parent;
    public Scania(int nrDoors,
                  double enginePower,
                  Color color,
                  String modelName,
                  double xPos,
                  double yPos) {

        super(nrDoors, enginePower, color, modelName, xPos, yPos);
        stopEngine();
        this.parent = new Truckbed();
    }
    @Override
    public int getTruckbedAngle() {
        return parent.getTruckbedAngle();
    }

    public void lowerTruckbed(int angle) {
        if (getCurrentSpeed() == 0 && angle > 0) {
            parent.lower(angle);
        }
    }
    public void raiseTruckbed(int angle) {
        if (getCurrentSpeed() == 0 && angle > 0) {
            parent.raise(angle);
        }
    }

    @Override
    public void startEngine() {
        if (getTruckbedAngle() == 0) {
            currentSpeed = 0.1;
        }
    }
}




