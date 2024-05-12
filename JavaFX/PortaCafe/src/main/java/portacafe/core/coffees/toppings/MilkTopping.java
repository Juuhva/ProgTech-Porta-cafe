package portacafe.core.coffees.toppings;

import portacafe.core.coffees.abstracts.AbstractCoffee;
import portacafe.core.coffees.abstracts.AbstractTopping;

public class MilkTopping extends AbstractTopping {
    public static final int ID = 1;

    public MilkTopping(AbstractCoffee coffee) {
        super(coffee);
    }

    @Override
    public String getToppingName() {
        return "Tej";
    }
    @Override
    public int getToppingPrice() {
        return 20;
    }
}
