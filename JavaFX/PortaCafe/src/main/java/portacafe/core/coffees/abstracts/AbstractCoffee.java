package portacafe.core.coffees.abstracts;

import java.util.List;

public abstract class AbstractCoffee {
    public abstract int getDBCoffeeType();

    public abstract String getCoffeeName();
    public abstract String getCoffeeDescription();
    public abstract int getTotalPrice();

    public abstract int getOrderedCoffeeID();
    public abstract void setOrderedCoffeeID(int value);
    public void fetchToppingsIntoList(List<Integer> output) {}
}
