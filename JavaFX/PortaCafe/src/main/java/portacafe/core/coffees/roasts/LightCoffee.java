package portacafe.core.coffees.roasts;

import portacafe.core.coffees.abstracts.AbstractCoffee;

public abstract class LightCoffee extends AbstractCoffee {

    private final int orderedCoffeeID;

    @Override
    protected int getCoffeeRoastIndex() {
        return 0;
    }

    @Override
    public int getOrderedCoffeeID() {
        return orderedCoffeeID;
    }

    public LightCoffee(int orderedCoffeeID) {
        this.orderedCoffeeID = orderedCoffeeID;
    }
}
