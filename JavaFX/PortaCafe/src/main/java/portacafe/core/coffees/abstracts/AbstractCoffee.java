package portacafe.core.coffees.abstracts;

import java.util.List;

public abstract class AbstractCoffee {
    private static final int MAX_COFFEES_PER_ROAST_CATEGORY = 100;

    protected abstract int getCoffeeRoastIndex();
    protected abstract int getCoffeeTypeIndex();
    public final int getDBCoffeeType() {
        return MAX_COFFEES_PER_ROAST_CATEGORY * getCoffeeRoastIndex()
                + getCoffeeTypeIndex();
    }
    public abstract String getCoffeeName();
    public abstract String getCoffeeDescription();
    public abstract int getTotalPrice();

    public abstract int getOrderedCoffeeID();
    public abstract void setOrderedCoffeeID(int value);
    public void fetchToppingsIntoList(List<Integer> output) {}
}
