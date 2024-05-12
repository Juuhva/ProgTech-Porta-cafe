package portacafe.core.factories.coffees;

import portacafe.core.coffees.Coffee;
import portacafe.core.coffees.abstracts.AbstractCoffee;
import portacafe.core.exceptions.CantBrewCoffeeException;
import portacafe.core.factories.AbstractCoffeeFactory;
import portacafe.core.factories.lookups.CoffeeLookup;

public class AllInOneCoffeeFactory extends AbstractCoffeeFactory {
    private AbstractCoffeeFactory[] factories = new AbstractCoffeeFactory[] {
            new LightCoffeeFactory(),
            new MediumCoffeeFactory(),
            new DarkCoffeeFactory()
    };

    @Override
    public AbstractCoffee createCoffee(int typeID) {
        for (int i = 0; i < factories.length; i++) {
            AbstractCoffee coffee = tryMakeCoffee(factories[i], typeID);
            if(coffee != null)
                return coffee;
        }
        throw new CantBrewCoffeeException();
    }
    @Override
    public AbstractCoffee createCoffee(Class<? extends Coffee> type) {
        return createCoffee(CoffeeLookup.set().getID(type));
    }

    private AbstractCoffee tryMakeCoffee(AbstractCoffeeFactory factory, int typeID) {
        try{
            return factory.createCoffee(typeID);
        } catch(CantBrewCoffeeException ex) {
            return null;
        }
    }
}
