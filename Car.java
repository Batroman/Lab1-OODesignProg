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

    public Car() {
        position = new Point2D.Double(0, 0);
        direction = 0;
    }

    public int getNrDoors() {
        return nrDoors;
    }

    public double getEnginePower() {
        return enginePower;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color clr) {
        color = clr;
    }

    public void startEngine() {
        currentSpeed = 0.1;
    }
    // Bör vara public för att användaren kan starta/stänga av motorn
    public void stopEngine() {
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
    public void gas(double amount) {
        if (amount >= 0 && amount <= 1) {
            incrementSpeed(amount);
        }
    }
    public void brake(double amount) {
        if (amount >= 0 && amount <= 1) {
            decrementSpeed(amount);
        }
    }
    public Point2D.Double getPosition() {
        return position;
    }
    public void setDirection(int angle) {
        direction = angle;
    }
    public int getDirection() {
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