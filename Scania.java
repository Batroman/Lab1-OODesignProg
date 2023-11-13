import java.awt.*;

public class Scania extends Car {
    private double currentTruckbedAngle;

    protected Scania() {
        super(2, 250, Color.green, "ScaniaTruck", 0, 0, 0);
        stopEngine();
        currentTruckbedAngle = 0;

    }

    protected double getTruckbedAngle() {
        return currentTruckbedAngle;
    }

    protected void reduceTruckbedAngle(double angle) {
        if (getCurrentSpeed() == 0 && angle > 0) {
            currentTruckbedAngle = Math.max(currentTruckbedAngle - angle, 0);
        }
    }


    protected void increaseTruckbedAngle(double angle) {
        if (getCurrentSpeed() == 0 && angle > 0) {
            currentTruckbedAngle = Math.min(currentTruckbedAngle - angle, 70);
        }
    }

    @Override
    public void startEngine() {
        if (getTruckbedAngle() == 0) {
            currentSpeed = 0.1;
        }
    }
}




