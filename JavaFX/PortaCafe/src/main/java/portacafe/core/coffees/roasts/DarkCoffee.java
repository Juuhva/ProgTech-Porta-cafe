package portacafe.core.coffees.roasts;

import portacafe.core.coffees.abstracts.AbstractCoffee;

public abstract class DarkCoffee extends AbstractCoffee {

    private final int orderedCoffeeID;

    protected DarkCoffee(int orderedCoffeeID) {
        this.orderedCoffeeID = orderedCoffeeID;
    }


    @Override
    protected int getCoffeeRoastIndex() {
        return 2;
    }

    @Override
    public int getOrderedCoffeeID() {
        return orderedCoffeeID;
    }
}
