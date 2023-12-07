package src.Model;

import java.awt.*;

public abstract class Cars extends Vehicle{

    public Cars(int nrDoors, double enginePower, Color color, String modelName, double xPos, double yPos) {
        super(nrDoors, enginePower, color, modelName, xPos, yPos);
    }
}
