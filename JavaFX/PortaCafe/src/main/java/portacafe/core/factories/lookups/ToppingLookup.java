package portacafe.core.factories.lookups;

import portacafe.core.coffees.abstracts.AbstractTopping;
import portacafe.core.coffees.toppings.CreamTopping;
import portacafe.core.coffees.toppings.MilkTopping;
import portacafe.core.coffees.toppings.SugarTopping;
import portacafe.core.coffees.toppings.WhippedCreamTopping;

public final class ToppingLookup extends LookupSet<AbstractTopping> {
    private static final ToppingLookup instance = new ToppingLookup();

    private ToppingLookup() {
        add(SugarTopping.ID, SugarTopping.class);
        add(MilkTopping.ID, MilkTopping.class);
        add(CreamTopping.ID, CreamTopping.class);
        add(WhippedCreamTopping.ID, WhippedCreamTopping.class);
    }

    public static ToppingLookup set() {
        return instance;
    }
}
