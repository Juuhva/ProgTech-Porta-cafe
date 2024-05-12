package portacafe.core.factories;

import portacafe.core.coffees.Coffee;
import portacafe.core.coffees.abstracts.AbstractCoffee;

public abstract class AbstractCoffeeFactory {

    public abstract AbstractCoffee createCoffee(int typeID);
    public abstract AbstractCoffee createCoffee(Class<? extends Coffee> type);
}
