package portacafe.core.factories.coffees;


import portacafe.core.coffees.Coffee;
import portacafe.core.coffees.abstracts.AbstractCoffee;
import portacafe.core.coffees.roasts.dark.CaffeVeronaCoffee;
import portacafe.core.coffees.roasts.dark.EspressoRoastCoffee;
import portacafe.core.coffees.roasts.dark.SumatraCoffee;
import portacafe.core.exceptions.CantBrewCoffeeException;
import portacafe.core.factories.AbstractCoffeeFactory;
import portacafe.core.factories.lookups.CoffeeLookup;

public class DarkCoffeeFactory extends AbstractCoffeeFactory {
    @Override
    public AbstractCoffee createCoffee(int typeId) {
        return createCoffee(CoffeeLookup.set().getType(typeId));

    }

    @Override
    public AbstractCoffee createCoffee(Class<? extends Coffee> type) {
        if (type == CaffeVeronaCoffee.class) {
            return new CaffeVeronaCoffee();
        }
        if (type == EspressoRoastCoffee.class) {
            return new EspressoRoastCoffee();
        }
        if (type == SumatraCoffee.class) {
            return new SumatraCoffee();
        }
        throw new CantBrewCoffeeException();
    }
}
