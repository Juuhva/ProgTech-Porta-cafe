package portacafe.core.coffees;

import portacafe.core.coffees.abstracts.AbstractCoffee;
import portacafe.core.factories.lookups.CoffeeLookup;

public abstract class Coffee extends AbstractCoffee {

    private int orderedCoffeeID;

    @Override
    public final int getDBCoffeeType() {
        return CoffeeLookup.set().getID(this.getClass());
    }

    @Override
    public int getOrderedCoffeeID() {
        return orderedCoffeeID;
    }

    @Override
    public void setOrderedCoffeeID(int value) {
        orderedCoffeeID = value;
    }
}
