import java.awt.*;
import java.awt.geom.Point2D;

public class Car{
    public int nrDoors; // Number of doors on the car
    public double enginePower; // Engine power of the car
    public double currentSpeed; // The current speed of the car
    public Color color; // Color of the car
    public String modelName; // The car model name
    public int xPosition; // The car x-position
    public int yPosition; // The car y-position
    public char direction; // The direction of the car
    public double position; // The position of the car

     private class Position implements Movable {
         public void move() {
            position = getPosition();
            direction = getDirection();
            switch (direction) {
                case 'N':
                    yPosition += getCurrentSpeed();
                    break;
                case 'S':
                    yPosition -= getCurrentSpeed();
                    break;
                case 'W':
                    xPosition -= getCurrentSpeed();
                    break;
                case 'E':
                    xPosition += getCurrentSpeed();
                    break;
            }
         }

         public void turnLeft() {
             switch (direction) {
                 case 'N':
                     direction = 'W';
                     break;
                 case 'W':
                     direction = 'S';
                     break;
                 case 'S':
                     direction = 'E';
                     break;
                 case 'E':
                     direction = 'N';
                     break;
         }

         public void turnRight(){
                 switch (direction) {
                     case 'N':
                         direction = 'E';
                         break;
                     case 'E':
                         direction = 'S';
                         break;
                     case 'S':
                         direction = 'W';
                         break;
                     case 'W':
                         direction = 'N';
                         break;

    // TODO add methods getPosition, getDirection

    public double getPosition() {
        return position;
     }

     public double setPosition() {
         Point2D.Double position = new Point2D.Double(xPosition, yPosition);
     }
     public char getDirection() {
       return direction;
     }

    public int getNrDoors(){
        return nrDoors;
    }
    public double getEnginePower(){
        return enginePower;
    }

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color clr){
        color = clr;
    }

    public void startEngine(){
        currentSpeed = 0.1;
    }

    public void stopEngine(){
        currentSpeed = 0;
    }


    public double speedFactor(){
        return 1.0; // Todo
    }
    public void incrementSpeed(double amount){
    }

    public void decrementSpeed(double amount){
    }

    // TODO fix this method according to lab pm
    public void gas(double amount){
        incrementSpeed(amount);
    }

    // TODO fix this method according to lab pm
    public void brake(double amount){
        decrementSpeed(amount);
    }
}
