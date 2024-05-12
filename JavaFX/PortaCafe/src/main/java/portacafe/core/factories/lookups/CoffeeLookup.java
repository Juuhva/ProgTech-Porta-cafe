package portacafe.core.factories.lookups;

import portacafe.core.coffees.Coffee;
import portacafe.core.coffees.roasts.dark.CaffeVeronaCoffee;
import portacafe.core.coffees.roasts.dark.EspressoRoastCoffee;
import portacafe.core.coffees.roasts.dark.SumatraCoffee;
import portacafe.core.coffees.roasts.light.BlondeEspressoCoffee;
import portacafe.core.coffees.roasts.medium.*;

public final class CoffeeLookup extends LookupSet<Coffee> {
    private static final CoffeeLookup instance = new CoffeeLookup();

    private CoffeeLookup() {
        add(0, BlondeEspressoCoffee.class);

        add(100, ColombiaCoffee.class);
        add(101, EthiopiaCoffee.class);
        add(102, GuatemalaAntiguaCoffee.class);
        add(103, HouseBlendCoffee.class);
        add(104, KenyaCoffee.class);
        add(105, PikePlaceRoastCoffee.class);

        add(200, CaffeVeronaCoffee.class);
        add(201, EspressoRoastCoffee.class);
        add(202, SumatraCoffee.class);
    }

    public static CoffeeLookup set() {
        return instance;
    }
}
