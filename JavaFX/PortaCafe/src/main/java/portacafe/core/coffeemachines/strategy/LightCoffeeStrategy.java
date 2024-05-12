package portacafe.core.coffeemachines.strategy;

import portacafe.core.coffees.abstracts.AbstractCoffee;
import portacafe.core.coffees.roasts.LightCoffee;

public class LightCoffeeStrategy implements CoffeeStrategy {

    @Override
    public AbstractCoffee makeCoffee(Class<? extends AbstractCoffee> coffeeClass) {
        
    }

    @Override
    public boolean canMakeCoffee(Class<? extends AbstractCoffee> coffeeClass) {
        return coffeeClass.isAssignableFrom(LightCoffee.class);
    }
}
