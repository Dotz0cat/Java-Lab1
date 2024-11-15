import javax.swing.*;
import java.awt.*;

public class MakingChange {
    public static void main(String[] argv) {
        JFrame frame = new JFrame();
        frame.setPreferredSize(new Dimension(500, 500));
        RegisterPanel reg = new RegisterPanel();
        frame.getContentPane().add(reg);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
