package src;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/* Each step the TimerListener moves all the cars in the list and tells the view to update its images.*/
class TimerListener implements ActionListener {
    private final CarController carController;

    public TimerListener(CarController carController) {
        this.carController = carController;
    }

    public void actionPerformed(ActionEvent e) {
        for (Vehicle car : carController.cars) {
            CarController.reverseCarAtWindowEdge(car);
            car.move();
            // repaint() calls the paintComponent method of the panel
            frame.drawPanel.repaint();
        }
    }
}
