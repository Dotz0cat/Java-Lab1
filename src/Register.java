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
                MoneyFactory.getDenotationOf(50.0),
                MoneyFactory.getDenotationOf(10.0),
                MoneyFactory.getDenotationOf(5.0),
                MoneyFactory.getDenotationOf(1.0),
                MoneyFactory.getDenotationOf(0.25),
                MoneyFactory.getDenotationOf(0.10),
                MoneyFactory.getDenotationOf(0.05),
                MoneyFactory.getDenotationOf(0.01)
        };

        long left = Math.round(amt * 100);  // amt should be in dollars, now we work in cents
        Purse change = new Purse();

        for (Denomination value : values) {
            long valueInCents = Math.round(value.amt() * 100);  // Convert denomination to cents
            if (left < valueInCents) continue;

            long numNeeded = left / valueInCents;  // How many of this denomination
            left = left % valueInCents;  // Remaining amount

            change.add(value, (int) numNeeded);  // Add to the purse, casting numNeeded to an int
        }

        return change;

    }
}
