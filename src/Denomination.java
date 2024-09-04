public record Denomination(
        String name,
        double amt,
        String form,
        String img
) {

    public static Denomination of(double amt)  {
        if (amt == 50.0) {
            return new Denomination("Fifty-Dollar Note", amt, "Bill", "dummy string");
        } else if (amt == 10.0) {
            return new Denomination("Ten-Dollar Note", amt, "Bill", "dummy string");
        } else if (amt == 5.0) {
            return new Denomination("Five-Dollar Note", amt, "Bill", "dummy string");
        } else if (amt == 1.0) {
            return new Denomination("One-Dollar Note", amt, "Bill", "dummy string");
        } else if (amt == 0.25) {
            return new Denomination("Quarter", amt, "Coin", "dummy string");
        } else if (amt == 0.10) {
            return new Denomination("Dime", amt, "Coin", "dummy string");
        } else if (amt == 0.05) {
            return new Denomination("Nickle", amt, "Coin", "dummy string");
        } else if (amt == 0.01) {
            return new Denomination("Penny", amt, "Coin", "dummy string");
        } else {
            System.err.printf("%f is not available\n", amt);
            return new Denomination("", 0.0, "", "");
        }
    }
}
