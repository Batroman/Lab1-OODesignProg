import java.awt.*;
import java.awt.geom.Point2D;

public class Car implements Movable {
    protected int nrDoors; // Number of doors on the car
    protected double enginePower; // Engine power of the car
    protected double currentSpeed; // The current speed of the car
    protected Color color; // Color of the car
    protected String modelName; // The car model name
    protected int direction;
    protected Point2D.Double position; // The position of the car

    protected Car() {
        position = new Point2D.Double(0, 0);
        direction = 0;
    }

    protected int getNrDoors() {
        return nrDoors;
    }

    protected double getEnginePower() {
        return enginePower;
    }

    protected double getCurrentSpeed() {
        return currentSpeed;
    }

    protected Color getColor() {
        return color;
    }

    protected void setColor(Color clr) {
        color = clr;
    }

    protected void startEngine() {
        currentSpeed = 0.1;
    }

    protected void stopEngine() {
        currentSpeed = 0;
    }

    protected double speedFactor() {
       return 1;
    }

    protected void incrementSpeed(double amount) {
       currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower());
    }
    protected void decrementSpeed(double amount) {
       currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
    }
    protected void gas(double amount) {
        if (amount >= 0 && amount <= 1) {
            incrementSpeed(amount);
        }
    }
    protected void brake(double amount) {
        if (amount >= 0 && amount <= 1) {
            decrementSpeed(amount);
        }
    }
    protected Point2D.Double getPosition() {
        return position;
    }
    protected void setDirection(int angle) {
        direction = angle;
    }
    protected int getDirection() {
        return direction;
    }
    public void move() {
        position = getPosition();
        double xPosition = position.getX();
        double yPosition = position.getY();
        switch (getDirection()) {
            case 0:
                yPosition += getCurrentSpeed();
                break;
            case 180:
                yPosition -= getCurrentSpeed();
                break;
            case 90:
                xPosition += getCurrentSpeed();
                break;
            case 270:
                xPosition -= getCurrentSpeed();
                break;
        }
        position.setLocation(xPosition, yPosition);
    }

    public void turnLeft() {
        direction = (getDirection() + 270) % 360;
    }

    public void turnRight() {
        direction = (getDirection() + 90) % 360;
    }
}