import java.awt.*;

public class Scania extends Truck{

    public Scania(int nrDoors,
                  double enginePower,
                  Color color,
                  String modelName,
                  int direction,
                  double xPos,
                  double yPos,
                  int currentTruckbedAngle) {

        super(nrDoors, enginePower, color, modelName, direction, xPos, yPos, currentTruckbedAngle);
        stopEngine();
    }
}




