package portacafe.core.coffees.toppings;

import portacafe.core.coffees.abstracts.AbstractCoffee;
import portacafe.core.coffees.abstracts.AbstractTopping;

public class CreamTopping extends AbstractTopping {
    public static final int ID = 2;

    public CreamTopping(AbstractCoffee coffee) {
        super(coffee);
    }

    @Override
    public String getToppingName() {
        return "Tejszín";
    }
    @Override
    public int getToppingPrice() {
        return 40;
    }
}
