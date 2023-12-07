package src.Model;

import java.awt.*;
import java.awt.geom.Point2D;

public abstract class Vehicle implements Movable, Positionable{

    Direction direction = Direction.E;
    private final int nrDoors;
    private final double enginePower;

    protected double currentSpeed;
    private Color color;
    private final String modelName;

    private Point2D.Double position;


    public Vehicle (int nrDoors, double enginePower, Color color, String modelName, double xPos, double yPos) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
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

    public String getModelName() {
        return modelName;
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
        if (getCurrentSpeed() != 0) {
            currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower());
        }
    }

    protected void decrementSpeed(double amount) {
        if (getCurrentSpeed() != 0) {
            currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
        }
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

    protected void setDirection(Direction dir) {
        direction = dir;
    }

    public Direction getDirection() {
        return direction;
    }

    public void move(){
        double xPosition = getPosition().x;
        double yPosition = getPosition().y;
        switch (this.direction){
            case N:
                yPosition += getCurrentSpeed();
                break;
            case E:
                xPosition += getCurrentSpeed();
                break;
            case S:
                yPosition -= getCurrentSpeed();
                break;
            case W:
                xPosition -= getCurrentSpeed();
                break;
        }
        position.setLocation(xPosition, yPosition);
    }

    public void turnLeft() {
        this.direction = direction.goLeft();
    }

    public void turnRight() {
        this.direction = direction.goRight();
    }
}