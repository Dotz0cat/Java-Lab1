import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public record Denomination(
        String name,
        double amt,
        String form,
        String img
) implements hasImage, Comparable<Denomination> {

    public BufferedImage getImage() {
        try {
            BufferedImage img1 = ImageIO.read(Objects.requireNonNull(this.getClass().getResource(this.img())));
            return img1;
        } catch (IOException e) {
            System.err.print(this);
            throw new RuntimeException(e);
        }
    }

    @Override
    public int compareTo(Denomination denomination) {
        return Double.compare(amt, denomination.amt);
    }
}
