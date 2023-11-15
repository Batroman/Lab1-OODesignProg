import java.awt.*;

public class Scania extends Truck{

    public Scania(int nrDoors,
                  double enginePower,
                  Color color,
                  String modelName,
                  int direction,
                  double xPos,
                  double yPos) {

        super(nrDoors, enginePower, color, modelName, direction, xPos, yPos);
        stopEngine();
    }

    public void reduceTruckbedAngle(int angle) {
        if (getCurrentSpeed() == 0 && angle > 0) {
            currentTruckbedAngle = Math.max(currentTruckbedAngle - angle, 0);
        }
    }


    public void increaseTruckbedAngle(int angle) {
        if (getCurrentSpeed() == 0 && angle > 0) {
            currentTruckbedAngle = Math.min(currentTruckbedAngle + angle, 70);
        }
    }

    @Override
    public void startEngine() {
        if (getTruckbedAngle() == 0) {
            currentSpeed = 0.1;
        }
    }
}




