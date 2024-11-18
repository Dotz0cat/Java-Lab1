import java.util.Collection;
import java.util.Comparator;

public class MostCoins implements ChangeMaker {
    @Override
    public Purse makeChange(double amt, Collection<Denomination> denominationCollection) {
        final long[] left = {Math.round(amt * 100)};  // amt should be in dollars, now we work in cents
        Purse change = new Purse();

        denominationCollection.stream()
                .sorted((d1, d2) -> Double.compare(d1.amt(), d2.amt()))
                .forEachOrdered(value -> {
                    long valueInCents = Math.round(value.amt() * 100);  // Convert denomination to cents
                    if (left[0] > valueInCents) {
                        long numNeeded = left[0] / valueInCents;  // How many of this denomination
                        left[0] = left[0] % valueInCents;  // Remaining amount

                        change.add(value, (int) numNeeded);
                    }
                });
        return change;
    }
}
