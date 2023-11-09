import java.awt.*;
import java.awt.geom.Point2D;

public class Saab95 extends Car{

    private boolean turboOn;

    public Saab95(){
        nrDoors = 2;
        color = Color.red;
        enginePower = 125;
	    turboOn = false;
        modelName = "Saab95";
        stopEngine();

        xPosition = 1;
        yPosition = 1;
        //direction = 0;

        //Point2D.Double position = new Point2D.Double(xPosition, yPosition);

        carPosition = new Position();
        carPosition.setPosition(xPosition, yPosition);
        carPosition.setDirection(0);
        //carPosition.move();

    }

    public void setTurboOn(){
	    turboOn = true;
    }

    public void setTurboOff(){
	    turboOn = false;
    }

    @Override
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }
    @Override
    public void incrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() + speedFactor() * amount;
    }
    @Override
    public void decrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() - speedFactor() * amount;
    }


}
