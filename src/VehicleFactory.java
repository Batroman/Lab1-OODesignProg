package src;

import java.awt.*;

public class VehicleFactory {
    public static Vehicle createVolvo240(int nrDoors, double enginePower, Color color, String modelName, String direction, double xPos, double yPos) {
        Vehicle obj = new Volvo240(nrDoors, enginePower, color, modelName, direction, xPos, yPos);
        return obj;
    }

    public static Vehicle createSaab95(int nrDoors, double enginePower, Color color, String modelName, String direction, double xPos, double yPos) {
        Vehicle obj = new Saab95(nrDoors, enginePower, color, modelName, direction, xPos, yPos);
        return obj;
    }

    public static Vehicle createScania(int nrDoors, double enginePower, Color color, String modelName, String direction, double xPos, double yPos) {
        Vehicle obj = new Scania(nrDoors, enginePower, color, modelName, direction, xPos, yPos);
        return obj;
    }
}
