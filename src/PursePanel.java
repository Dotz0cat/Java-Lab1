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

        //this.setLayout(new GridBagLayout());
        this.setBackground(Color.gray);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (purse == null) {
            return;
        }

        ArrayList<BufferedImage> imgs = new ArrayList<BufferedImage>();
        ArrayList<Integer> amounts = new ArrayList<Integer>();
        ArrayList<Boolean> bill = new ArrayList<Boolean>();

        for (Map.Entry<Denomination, Integer> entry: purse.cash.entrySet()) {
           try {
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

           Iterator<BufferedImage> imgsIter = imgs.iterator();
           Iterator<Boolean> billIter = bill.iterator();
           Iterator<Integer> amountsIter = amounts.iterator();

           int currentX = 0;
           int currentY = 0;
           int amountToChangeXBy = 0;

           while(imgsIter.hasNext()) {
               //do this multiple times
               BufferedImage image = imgsIter.next();
               boolean billForm = billIter.next();
               int amount = amountsIter.next();
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
