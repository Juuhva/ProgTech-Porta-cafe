package portacafe.core.coffees.toppings;

import portacafe.core.coffees.abstracts.AbstractCoffee;
import portacafe.core.coffees.abstracts.AbstractTopping;

public class WhippedCreamTopping extends AbstractTopping {
    public WhippedCreamTopping(AbstractCoffee coffee) {
        super(coffee);
    }

    @Override
    public String getToppingName() {
        return "Tejszínhab";
    }
    @Override
    public int getToppingPrice() {
        return 100;
    }
}
