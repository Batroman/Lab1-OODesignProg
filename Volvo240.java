import java.awt.*;
import java.awt.geom.Point2D;

public class Volvo240 extends Car {

    private final static double trimFactor = 1.25;

    public Volvo240() {
        nrDoors = 4;
        color = Color.black;
        enginePower = 100;
        modelName = "Volvo240";
        stopEngine();

        xPosition = 5;
        yPosition = 1;
        direction = 0;

        Point2D.Double position = new Point2D.Double(xPosition, yPosition);
    }


    @Override
    public double speedFactor() {
        return enginePower * 0.01 * trimFactor;
    }

    @Override
    public void incrementSpeed(double amount) {
        // 1+amount, else will decrease speed??
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * (1+amount), enginePower);
    }

    @Override
    public void decrementSpeed(double amount) {
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
    }
}


