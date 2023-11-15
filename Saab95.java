import java.awt.*;
import java.awt.geom.Point2D;

public class Saab95 extends Vehicle{

    private boolean turboOn;

    public Saab95 (int nrDoors, double enginePower, Color color, String modelName, int direction, double xPos, double yPos) {

        super(nrDoors, enginePower, color, modelName, direction, xPos, yPos);
        setPosition(xPos,yPos);
        turboOn = false;
        currentSpeed = 1;
    }

    protected void setTurboOn(){
	    turboOn = true;
    }

    protected void setTurboOff(){
	    turboOn = false;
    }

    @Override
    protected double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }
    @Override
    protected void incrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() + speedFactor() * amount;
    }
    @Override
    protected void decrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() - speedFactor() * amount;
    }
}
