package portacafe.core.coffees.roasts;

import portacafe.core.coffees.abstracts.AbstractCoffee;

public abstract class MediumCoffee extends AbstractCoffee {

    private final int orderedCoffeeID;

    protected MediumCoffee(int orderedCoffeeID) {
        this.orderedCoffeeID = orderedCoffeeID;
    }

    @Override
    protected int getCoffeeRoastIndex() {
        return 1;
    }

    @Override
    public int getOrderedCoffeeID() {
        return orderedCoffeeID;
    }
}
