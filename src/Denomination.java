import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public record Denomination(
        String name,
        double amt,
        String form,
        String img
) {

    public static Denomination of(double amt)  {
        if (amt == 50.0) {
            return new Denomination("Fifty-Dollar Note", amt, "Bill", "fifty_note.png");
        } else if (amt == 10.0) {
            return new Denomination("Ten-Dollar Note", amt, "Bill", "ten_note.png");
        } else if (amt == 5.0) {
            return new Denomination("Five-Dollar Note", amt, "Bill", "five_note.png");
        } else if (amt == 1.0) {
            return new Denomination("One-Dollar Note", amt, "Bill", "one_note.png");
        } else if (amt == 0.25) {
            return new Denomination("Quarter", amt, "Coin", "quarter.png");
        } else if (amt == 0.10) {
            return new Denomination("Dime", amt, "Coin", "dime.png");
        } else if (amt == 0.05) {
            return new Denomination("Nickle", amt, "Coin", "nickel.png");
        } else if (amt == 0.01) {
            return new Denomination("Penny", amt, "Coin", "penny.png");
        } else {
            return new Denomination("", 0.0, "", "");
        }
    }

    public BufferedImage getImage() throws IOException {
        return ImageIO.read(Objects.requireNonNull(this.getClass().getResource(this.img())));
    }
}
