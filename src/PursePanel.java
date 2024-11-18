import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class PursePanel extends JPanel {
    private Purse purse;

    private static final int BILL_SIZE = 100;
    private static final int COIN_SIZE = 50;
    private static final int SIDE_LENGTH = 20;
    private static final int DOWN_LENGTH = 40;
    private static final int ITEM_SIZE = 50;

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

        int currentX = 0;

        int panelHeight = this.getHeight();

        for (Denomination denomination : purse.getDenominations()) {
            int currentY = 0;
            BufferedImage image = denomination.getImage();
            for (int i = 0; i < purse.getAmount(denomination); i++) {
                if (currentY > panelHeight) break;
                g.drawImage(image, currentX, currentY, denomination.form().equals("Bill") ? BILL_SIZE : COIN_SIZE, ITEM_SIZE, this);
                currentY += DOWN_LENGTH;
            }
            currentX += SIDE_LENGTH + (denomination.form().equals("Bill") ? BILL_SIZE : COIN_SIZE);
        }
    }

    public void setPurse(Purse purse) {
        this.purse = purse;
    }
}
