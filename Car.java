import java.awt.*;
import java.awt.geom.Point2D;

public class Car implements Movable {
    private int nrDoors;
    private final double enginePower;
    protected double currentSpeed;
    private Color color;
    private String modelName;
    private int direction;
    private double xPos;
    private double yPos;
    private Point2D.Double position; // The position of the car

    public Car (int nrDoors, double enginePower, Color color, String modelName, int direction, double xPos, double yPos) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        this.direction = direction;
        this.xPos = xPos;
        this.yPos = yPos;
        this.position = new Point2D.Double(xPos, yPos);
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

    protected void setPosition(double x, double y) {
        position.setLocation(x,y);
    }

    public Point2D.Double getPosition() {
        return position;
    }

    public double getXPosition() {
        return position.getX();
    }

    public double getYPosition() {
        return position.getY();
    }
    protected void setDirection(int angle) {
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
    public void move(double angle) {
        double xDelta = position.getX() + getCurrentSpeed()*Math.cos(angle);
        double yDelta = position.getY() + getCurrentSpeed()*Math.sin(angle);
        System.out.println(xDelta + " " + 1.0f/2.0f);
        System.out.println(yDelta + " " + Math.sqrt(3)/2);
        position.setLocation(xDelta, yDelta);
    }

    public void turnLeft() {
        direction = (getDirection() + 270) % 360;
    }

    public void turnRight() {
        direction = (getDirection() + 90) % 360;
    }
}