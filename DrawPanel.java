import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Objects;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{
    BufferedImage carImage;
    ArrayList<BufferedImage> allCarImages = new ArrayList<>();

    // To keep track of a single cars position
    Point carPoint = new Point();

    // TODO: Make this general for all cars
    void moveit(int x, int y){
        /*carPoint.x = x;
        carPoint.y = y;*/
    }

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
                //System.out.println("name: " + picName);
                carImage = ImageIO.read(DrawPanel.class.getResourceAsStream(picName));
                allCarImages.add(carImage);
            }

        } catch (IOException ex)
        {
            ex.printStackTrace();
        }

    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (BufferedImage image: allCarImages) {
            g.drawImage(image, carPoint.x, carPoint.y, null);
        }

        //g.drawImage(carImage, carPoint.x, carPoint.y, null); // see javadoc for more info on the parameters
    }
}
