import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{
    HashMap<Vehicle, BufferedImage> imageMap = new HashMap<>();

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, ArrayList<Vehicle> cars) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);

        // Print an error message in case file is not found with a try/catch block
        try {
            for (Vehicle car: cars){
                String vehicleName = car.getModelName();
                String picName = "pics/" + vehicleName + ".jpg";
                imageMap.put(car, ImageIO.read(DrawPanel.class.getResourceAsStream(picName)));
            }
        } catch (IOException ex) {ex.printStackTrace();}
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Vehicle car : imageMap.keySet()) {
            g.drawImage(imageMap.get(car), (int) Math.round(car.getXPosition()), (int) Math.round(car.getYPosition()), null);
        }
    }
}

