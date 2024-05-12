package portacafe.core.coffeemachines.strategy;

import portacafe.core.coffees.abstracts.AbstractCoffee;

public interface CoffeeStrategy {

    public AbstractCoffee makeCoffee(Class<? extends AbstractCoffee> coffeeClass);
    public boolean canMakeCoffee(Class<? extends AbstractCoffee> coffeeClass);
}
