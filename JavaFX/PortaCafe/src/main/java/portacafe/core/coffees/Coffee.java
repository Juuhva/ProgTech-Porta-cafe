package portacafe.core.coffees;

import portacafe.core.coffees.abstracts.AbstractCoffee;

public abstract class Coffee extends AbstractCoffee {

    private int orderedCoffeeID;

    @Override
    public int getOrderedCoffeeID() {
        return orderedCoffeeID;
    }

    @Override
    public void setOrderedCoffeeID(int value) {
        orderedCoffeeID = value;
    }
}
