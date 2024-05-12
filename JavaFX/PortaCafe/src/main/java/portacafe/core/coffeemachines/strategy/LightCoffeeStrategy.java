package portacafe.core.coffeemachines.strategy;

import portacafe.core.coffees.Coffee;
import portacafe.core.coffees.abstracts.AbstractCoffee;
import portacafe.core.coffees.roasts.LightCoffee;

public class LightCoffeeStrategy implements CoffeeStrategy {

    @Override
    public boolean canMakeCoffee(Class<? extends Coffee> coffeeClass) {
        return coffeeClass.isAssignableFrom(LightCoffee.class);
    }
}
