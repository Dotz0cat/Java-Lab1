import java.util.Scanner;

public class Register {

    Register() {

    }

    public static void main(String[] argv) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter an amount\n");
        double amt = scan.nextDouble();
        Register reg = new Register();
        System.out.print(reg.makeChange(amt).toString());
    }

    public Purse makeChange(double amt) {
        Denomination[] values = {
                Denomination.of(50.0),
                Denomination.of(10.0),
                Denomination.of(5.0),
                Denomination.of(1.0),
                Denomination.of(0.25),
                Denomination.of(0.10),
                Denomination.of(0.05),
                Denomination.of(0.01)
        };

        double left = amt;
        Purse change = new Purse();

        for (Denomination value : values) {
            if (left < value.amt()) continue;
            double numNeeded = (left - (left % value.amt())) / value.amt();
            left = left - (left % value.amt());
            change.add(value, (int) numNeeded);
        }

        return change;

    }
}
