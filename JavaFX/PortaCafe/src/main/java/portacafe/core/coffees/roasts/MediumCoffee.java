package portacafe.core.coffees.roasts;

import portacafe.core.coffees.Coffee;
import portacafe.core.coffees.abstracts.AbstractCoffee;

public abstract class MediumCoffee extends Coffee {

    @Override
    protected int getCoffeeRoastIndex() {
        return 1;
    }

}
