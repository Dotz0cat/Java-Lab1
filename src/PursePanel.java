import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class PursePanel extends JPanel {
    Purse purse;

    PursePanel() {
        super();

        this.setBackground(Color.gray);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        //if null no need to draw anything
        if (purse == null) {
            return;
        }

        //arraylists to hold the images, amounts, and if it is a bill
        ArrayList<BufferedImage> imgs = new ArrayList<BufferedImage>();
        ArrayList<Integer> amounts = new ArrayList<Integer>();
        ArrayList<Boolean> bill = new ArrayList<Boolean>();

        for (Map.Entry<Denomination, Integer> entry: purse.cash.entrySet()) {
           try {
               //try to load the image from resources
               imgs.add(ImageIO.read(this.getClass().getResource(entry.getKey().img())));
               if (entry.getKey().form().equals("Bill")) {
                   bill.add(true);
               }
               else {
                   bill.add(false);
               }
               amounts.add(entry.getValue());
           } catch (Exception e) {
               System.err.printf("Opps can't read: %s\n", entry.getKey().img());
           }

           //get iterators for the arraylists
           Iterator<BufferedImage> imgsIter = imgs.iterator();
           Iterator<Boolean> billIter = bill.iterator();
           Iterator<Integer> amountsIter = amounts.iterator();

           int currentX = 0;
           int currentY = 0;
           int amountToChangeXBy = 0;

           //iterate over the arraylists to handle drawing
           while(imgsIter.hasNext()) {

               BufferedImage image = imgsIter.next();
               boolean billForm = billIter.next();
               int amount = amountsIter.next();

               //for when there is multiple needed to make change
               for (int i = 0; i < amount; i++) {

                   if (billForm) {
                       g.drawImage(image, currentX, currentY, 100, 50, this);
                       amountToChangeXBy = 120;
                       currentY += 40;
                   } else {
                       g.drawImage(image, currentX, currentY, 50, 50, this);
                       amountToChangeXBy = 70;
                       currentY += 40;
                   }


               }
               currentX += amountToChangeXBy;
               currentY = 0;
           }
        }
    }
}
