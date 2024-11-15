import java.util.Map;

public class MoneyFactory {
    private static final Map<Double, Denomination> internalObjectMap;

    static {
        internalObjectMap = Map.of(
                50.0, new Denomination("Fifty-Dollar Note", 50.0, "Bill", "fifty_note.png"),
                10.0, new Denomination("Ten-Dollar Note", 10.0, "Bill", "ten_note.png"),
                5.0, new Denomination("Five-Dollar Note", 5.0, "Bill", "five_note.png"),
                1.0, new Denomination("One-Dollar Note", 1.0, "Bill", "one_note.png"),
                0.25, new Denomination("Quarter", 0.25, "Coin", "quarter.png"),
                0.10, new Denomination("Dime", 0.10, "Coin", "dime.png"),
                0.05, new Denomination("Nickel", 0.05, "Coin", "nickel.png"),
                0.01, new Denomination("Penny", 0.01, "Coin", "penny.png")
        );
    }

    public static Denomination getDenotationOf(double amt) {
        return internalObjectMap.get(amt);
    }
}
