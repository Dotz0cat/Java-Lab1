import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public record Denomination(
        String name,
        double amt,
        String form,
        String img
) implements hasImage {

    public BufferedImage getImage() {
        try {
            return ImageIO.read(Objects.requireNonNull(this.getClass().getResource(this.img())));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
