package portacafe.core.coffees.abstracts;

import java.util.List;

public abstract class AbstractTopping extends AbstractCoffee {
    private final AbstractCoffee coffee;

    public AbstractTopping(AbstractCoffee coffee) {
        this.coffee = coffee;
    }

    public abstract String getToppingName();
    public abstract int getToppingPrice();

    public abstract int getDBToppingType();

    @Override
    public final void fetchToppingsIntoList(List<Integer> output) {
        output.add(getDBToppingType());
        coffee.fetchToppingsIntoList(output);
    }


    @Override
    protected final int getCoffeeRoastIndex() {
        return coffee.getCoffeeRoastIndex();
    }
    @Override
    protected final int getCoffeeTypeIndex() {
        return coffee.getCoffeeTypeIndex();
    }

    @Override
    public final String getCoffeeName() {
        return coffee.getCoffeeName();
    }
    @Override
    public final String getCoffeeDescription() {
        return coffee.getCoffeeDescription();
    }
    @Override
    public final int getTotalPrice() {
        return coffee.getTotalPrice() + getToppingPrice();
    }

    @Override
    public final int getOrderedCoffeeID() {
        return coffee.getOrderedCoffeeID();
    }
}
