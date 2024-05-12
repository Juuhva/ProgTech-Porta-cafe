package portacafe.core.coffees.abstracts;

import portacafe.core.factories.lookups.ToppingLookup;

import java.util.List;

public abstract class AbstractTopping extends AbstractCoffee {
    private final AbstractCoffee coffee;

    public AbstractTopping(AbstractCoffee coffee) {
        this.coffee = coffee;
    }

    public abstract String getToppingName();
    public abstract int getToppingPrice();

    public final int getDBToppingType() {
        return ToppingLookup.set().getID(this.getClass());
    }

    @Override
    public final void fetchToppingsIntoList(List<Integer> output) {
        output.add(getDBToppingType());
        coffee.fetchToppingsIntoList(output);
    }


    @Override
    public final int getDBCoffeeType() {
        return coffee.getDBCoffeeType();
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
    @Override
    public final void setOrderedCoffeeID(int value) {
        coffee.setOrderedCoffeeID(value);
    }
}
