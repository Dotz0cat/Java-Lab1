import java.util.Collection;

public interface ChangeMaker {
    public Purse makeChange(double amt, Collection<Denomination> denominationCollection);
}
