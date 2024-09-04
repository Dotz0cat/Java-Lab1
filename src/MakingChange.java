import javax.swing.*;

public class MakingChange {
    public static void main(String[] argv) {
        System.out.printf("I a graphical\n");
        JFrame frame = new JFrame();
        RegisterPanel reg = new RegisterPanel();
        frame.getContentPane().add(reg);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
