import java.util.Scanner;

public class Register {

    ChangeMaker method;
    MoneyFactory moneyFactory;

    Register() {
        this.method = new LeastChange();
        this.moneyFactory = new USMoneyFactory();
    }

    Register(ChangeMaker method) {
        this.method = method;
        this.moneyFactory = new USMoneyFactory();
    }

    Register(MoneyFactory moneyFactory) {
        this.method = new LeastChange();
        this.moneyFactory = moneyFactory;
    }

    Register(ChangeMaker method, MoneyFactory moneyFactory) {
        this.method = method;
        this.moneyFactory = moneyFactory;
    }

    public static void main(String[] argv) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter an amount\n");
        double amt = scan.nextDouble();
        Register reg = new Register();
        System.out.print(reg.makeChange(amt).toString());
    }

    public Purse makeChange(double amt) {
        return method.makeChange(amt, moneyFactory.getAllDenotations());
    }
}
