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
        add(BlondeEspressoCoffee.ID, BlondeEspressoCoffee.class);

        add(ColombiaCoffee.ID, ColombiaCoffee.class);
        add(EthiopiaCoffee.ID, EthiopiaCoffee.class);
        add(GuatemalaAntiguaCoffee.ID, GuatemalaAntiguaCoffee.class);
        add(HouseBlendCoffee.ID, HouseBlendCoffee.class);
        add(KenyaCoffee.ID, KenyaCoffee.class);
        add(PikePlaceRoastCoffee.ID, PikePlaceRoastCoffee.class);

        add(CaffeVeronaCoffee.ID, CaffeVeronaCoffee.class);
        add(EspressoRoastCoffee.ID, EspressoRoastCoffee.class);
        add(SumatraCoffee.ID, SumatraCoffee.class);
    }

    public static CoffeeLookup set() {
        return instance;
    }
}
