package portacafe.core.factories;

import portacafe.core.coffees.Coffee;
import portacafe.core.coffees.abstracts.AbstractCoffee;
import portacafe.core.coffees.abstracts.AbstractTopping;

public abstract class AbstractToppingFactory {
        public abstract AbstractCoffee makeTopping(AbstractCoffee wrappee, int typeID);
        public abstract AbstractCoffee makeTopping(AbstractCoffee wrappee, Class<? extends AbstractTopping> type);
}
