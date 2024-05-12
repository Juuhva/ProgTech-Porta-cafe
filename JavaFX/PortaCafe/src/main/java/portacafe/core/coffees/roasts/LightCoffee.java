package portacafe.core.coffees.roasts;

import portacafe.core.coffees.Coffee;
import portacafe.core.coffees.abstracts.AbstractCoffee;

public abstract class LightCoffee extends Coffee {


    @Override
    protected int getCoffeeRoastIndex() {
        return 0;
    }
}
