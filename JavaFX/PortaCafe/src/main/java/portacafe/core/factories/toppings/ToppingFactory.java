package portacafe.core.factories.toppings;

import portacafe.core.coffees.abstracts.AbstractCoffee;
import portacafe.core.coffees.abstracts.AbstractTopping;
import portacafe.core.coffees.toppings.CreamTopping;
import portacafe.core.coffees.toppings.MilkTopping;
import portacafe.core.coffees.toppings.SugarTopping;
import portacafe.core.coffees.toppings.WhippedCreamTopping;
import portacafe.core.exceptions.CantAddToppingException;
import portacafe.core.factories.AbstractToppingFactory;
import portacafe.core.factories.lookups.CoffeeLookup;
import portacafe.core.factories.lookups.ToppingLookup;

public class ToppingFactory extends AbstractToppingFactory {
    @Override
    public AbstractCoffee makeTopping(AbstractCoffee wrappee, int typeID) {
        return makeTopping(wrappee, ToppingLookup.set().getType(typeID));
    }

    @Override
    public AbstractCoffee makeTopping(AbstractCoffee wrappee, Class<? extends AbstractTopping> type) {
        if (type == SugarTopping.class){
            return new SugarTopping(wrappee);
        }
        if (type == MilkTopping.class){
            return new MilkTopping(wrappee);
        }
        if (type == CreamTopping.class){
            return new CreamTopping(wrappee);
        }
        if (type == WhippedCreamTopping.class){
            return new WhippedCreamTopping(wrappee);
        }
        throw new CantAddToppingException();
    }
}
