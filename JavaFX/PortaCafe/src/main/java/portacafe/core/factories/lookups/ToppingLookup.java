package portacafe.core.factories.lookups;

import portacafe.core.coffees.abstracts.AbstractTopping;
import portacafe.core.coffees.toppings.CreamTopping;
import portacafe.core.coffees.toppings.MilkTopping;
import portacafe.core.coffees.toppings.SugarTopping;
import portacafe.core.coffees.toppings.WhippedCreamTopping;

public final class ToppingLookup extends LookupSet<AbstractTopping> {
    private static final ToppingLookup instance = new ToppingLookup();

    private ToppingLookup() {
        add(0, SugarTopping.class);
        add(1, MilkTopping.class);
        add(2, CreamTopping.class);
        add(3, WhippedCreamTopping.class);
    }

    public static ToppingLookup set() {
        return instance;
    }
}
