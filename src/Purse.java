import java.util.HashMap;
import java.util.Map;

public class Purse {
    Map<Denomination, Integer> cash;

    Purse() {
        this.cash = new HashMap<Denomination, Integer>();
    }

    public void add(Denomination type, int num) {
        cash.put(type, num);
    }

    public double remove(Denomination type, int num) {
        if (cash.get(type) != 0) {
            cash.replace(type, (cash.get(type) - num));
        }

        return this.getValue();
    }

    public double getValue() {
        double sum = 0.0;

        if (cash.isEmpty()) {
            return 0.0;
        }

        for (Map.Entry<Denomination, Integer> entry : this.cash.entrySet()) {
            sum = sum + entry.getKey().amt() * entry.getValue();
        }

        return sum;
    }

    public String toString() {
        StringBuilder str = new StringBuilder();

        double amt = this.getValue();
        str.append(amt);

        if (amt == 0.0) {
            str.append("\t\t\t\t");
            str.append("Empty Purse\n");
            return str.toString();
        }

        for (Map.Entry<Denomination, Integer> entry : this.cash.entrySet()) {
            str.append("\t\t\t\t");
            str.append(entry.getValue());
            str.append(' ');
            str.append(entry.getKey().name());
            str.append('\n');
        }

        return str.toString();
    }
}
