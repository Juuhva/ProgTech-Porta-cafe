package portacafe.core.coffeemachines.strategy;

import portacafe.core.coffees.Coffee;
import portacafe.core.coffees.abstracts.AbstractCoffee;

public interface CoffeeStrategy {

    public boolean canMakeCoffee(Class<? extends Coffee> coffeeClass);
}
