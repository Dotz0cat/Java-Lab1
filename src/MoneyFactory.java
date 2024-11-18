import java.util.Collection;

public interface MoneyFactory {
    public Denomination getDenotationOf(double amt);
    public Collection<Denomination> getAllDenotations();
}
