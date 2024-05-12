package portacafe.core.factories.coffees;

import portacafe.core.coffees.Coffee;
import portacafe.core.coffees.roasts.medium.*;
import portacafe.core.exceptions.CantBrewCoffeeException;
import portacafe.core.factories.AbstractCoffeeFactory;
import portacafe.core.factories.lookups.CoffeeLookup;

public class MediumCoffeeFactory extends AbstractCoffeeFactory {
    @Override
    public Coffee createCoffee(int typeId) {
        return createCoffee(CoffeeLookup.set().getType(typeId));

    }

    @Override
    public Coffee createCoffee(Class<? extends Coffee> type) {
        if (type == ColombiaCoffee.class) {
            return new ColombiaCoffee();
        }
        if (type == EthiopiaCoffee.class) {
            return new EthiopiaCoffee();
        }
        if (type == GuatemalaAntiguaCoffee.class) {
            return new GuatemalaAntiguaCoffee();
        }
        if (type == HouseBlendCoffee.class) {
            return new HouseBlendCoffee();
        }
        if (type == KenyaCoffee.class) {
            return new KenyaCoffee();
        }
        if (type == PikePlaceRoastCoffee.class){
            return new PikePlaceRoastCoffee();
        }
        throw new CantBrewCoffeeException();
    }
}
