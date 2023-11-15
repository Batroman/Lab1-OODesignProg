import java.awt.*;

public class CarTransporter extends Truck{

    public CarTransporter(int nrDoors, double enginePower, Color color, String modelName, int direction, double xPos, double yPos){
        super(nrDoors, enginePower, color, modelName, direction, xPos, yPos);
        currentTruckbedAngle = 0;
    }

    @Override
    public void reduceTruckbedAngle() {
        if (getCurrentSpeed() == 0) {
            currentTruckbedAngle = 0;
        }
        
    }

    @Override
    public void increaseTruckbedAngle() {
        if (getCurrentSpeed() == 0) {
            currentTruckbedAngle = 70;
        }
    }

    @Override
    public void startEngine() {
        if (getTruckbedAngle() == 0) {
            currentSpeed = 0.1;
        }
    }
    
}