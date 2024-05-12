package portacafe.core.coffees.toppings;

import portacafe.core.coffees.abstracts.AbstractCoffee;
import portacafe.core.coffees.abstracts.AbstractTopping;

public class SugarTopping extends AbstractTopping {
    public static final int ID = 0;

    public SugarTopping(AbstractCoffee coffee) {
        super(coffee);
    }

    @Override
    public String getToppingName() {
        return "Cukor";
    }
    @Override
    public int getToppingPrice() {
        return 5;
    }
}
