package src;

import java.awt.*;

public class Volvo240 extends Cars {

    private final static double trimFactor = 1.25;

    public Volvo240(int nrDoors, double enginePower, Color color, String modelName, String direction, double xPos, double yPos) {

        super(nrDoors, enginePower, color, modelName, direction, xPos, yPos);
        setPosition(xPos,yPos);
    }
    @Override
    protected double speedFactor() {
        return getEnginePower() * 0.01 * trimFactor;
    }
    @Override
    protected void incrementSpeed(double amount) {
        if (getCurrentSpeed() != 0) {
            currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower());
        }

    }
    @Override
    protected void decrementSpeed(double amount) {
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
    }


}


