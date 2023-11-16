public class Truckbed {
    private int currentTruckbedAngle;
    protected double getTruckbedAngle() {
        return currentTruckbedAngle;
    }
    public void reduceTruckbedAngle(int angle) {
        if (angle > 0) {
            currentTruckbedAngle = Math.max(currentTruckbedAngle - angle, 0);
        }
    }
    public void increaseTruckbedAngle(int angle) {
        if (angle > 0) {
            currentTruckbedAngle = Math.min(currentTruckbedAngle + angle, 70);
        }
    }
}
