package portacafe.core.factories.coffees;

import portacafe.core.coffees.Coffee;
import portacafe.core.coffees.roasts.light.BlondeEspressoCoffee;
import portacafe.core.exceptions.CantBrewCoffeeException;
import portacafe.core.factories.AbstractCoffeeFactory;
import portacafe.core.factories.lookups.CoffeeLookup;

public class LightCoffeeFactory extends AbstractCoffeeFactory {
    @Override
    public Coffee createCoffee(int typeId) {
        return createCoffee(CoffeeLookup.set().getType(typeId));
    }

    @Override
    public Coffee createCoffee(Class<? extends Coffee> type) {
        if (type == BlondeEspressoCoffee.class) {
            return new BlondeEspressoCoffee();
        }
        throw new CantBrewCoffeeException();
    }
}
