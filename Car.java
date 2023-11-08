import java.awt.*;
import java.awt.geom.Point2D;

public class Car {
    public int nrDoors; // Number of doors on the car
    public double enginePower; // Engine power of the car
    public double currentSpeed; // The current speed of the car
    public Color color; // Color of the car
    public String modelName; // The car model name
    public double xPosition; // The car x-position
    public double yPosition; // The car y-position
    public int direction; // The direction of the car
    public Point2D.Double position; // The position of the car

    private class Position implements Movable {
        public void move() {
            position = getPosition();
            xPosition = position.getX();
            yPosition = position.getY();
            switch (getDirection()) {
                case 0:
                    yPosition += getCurrentSpeed();
                    break;
                case 90:
                    yPosition -= getCurrentSpeed();
                    break;
                case 180:
                    xPosition -= getCurrentSpeed();
                    break;
                case 270:
                    xPosition += getCurrentSpeed();
                    break;
            }
            setPosition(xPosition, yPosition);
        }

        public void turnLeft() {
            direction = (getDirection() + 90) % 360;
        }

        public void turnRight() {
            direction = (getDirection() - 90) % 360;
        }

        public Point2D.Double getPosition() {
            return position;
        }

        public void setPosition(double xPosition, double yPosition) {
            position.setLocation(xPosition, yPosition);
        }

        public int getDirection() {
            return direction;
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


        public double speedFactor() {
            return 1.0; // Todo
        }

        public void incrementSpeed(double amount) {
        }

        public void decrementSpeed(double amount) {
        }

        // TODO fix this method according to lab pm
        public void gas(double amount) {
            incrementSpeed(amount);
        }

        // TODO fix this method according to lab pm
        public void brake(double amount) {
            decrementSpeed(amount);
        }
    }
}