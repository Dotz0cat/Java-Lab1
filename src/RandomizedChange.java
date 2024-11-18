import java.util.*;

public class RandomizedChange implements ChangeMaker {
    @Override
    public Purse makeChange(double amt, Collection<Denomination> denominationCollection) {
        final long[] left = {Math.round(amt * 100)}; // Amount in cents
        Purse change = new Purse();

        // Shuffle denominations for random selection
        List<Denomination> shuffledDenominations = new ArrayList<>(denominationCollection);
        Collections.shuffle(shuffledDenominations);

        for (Denomination value : shuffledDenominations) {
            long valueInCents = Math.round(value.amt() * 100); // Denomination in cents
            if (left[0] >= valueInCents) {
                long numNeeded = left[0] / valueInCents;
                left[0] %= valueInCents;

                change.add(value, (int) numNeeded);
            }
        }

        return change;
    }
}
