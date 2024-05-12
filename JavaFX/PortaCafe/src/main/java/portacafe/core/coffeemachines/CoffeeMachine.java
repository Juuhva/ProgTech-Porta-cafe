package portacafe.core.coffeemachines;

import portacafe.core.coffeemachines.strategy.CoffeeStrategy;
import portacafe.core.coffeemachines.strategy.LightCoffeeStrategy;
import portacafe.core.coffees.abstracts.AbstractCoffee;
import portacafe.core.coffees.abstracts.AbstractTopping;
import portacafe.core.coffees.roasts.LightCoffee;
import portacafe.core.coffees.toppings.CreamTopping;
import portacafe.core.exceptions.CantBrewCoffeeException;

import java.util.Objects;
import java.util.function.Function;
import java.util.function.Supplier;

public class CoffeeMachine {

    private CoffeeStrategy strategy;
    private AbstractCoffee brewedCoffee;

    public CoffeeMachine(CoffeeStrategy strategy) {
        this.strategy = strategy;
    }

    public void brewCoffee(Class<? extends AbstractCoffee> coffeeClass) throws CantBrewCoffeeException {
        if (!canBrewCoffee(coffeeClass)) {
            throw new CantBrewCoffeeException();
        }
        brewedCoffee = strategy.makeCoffee(coffeeClass);
    }

    private boolean canBrewCoffee(Class<? extends AbstractCoffee> coffeeClass){
        return strategy.canMakeCoffee(coffeeClass);
    }

    public<T extends AbstractTopping> void addTopping(Function<AbstractCoffee, T> constructor){
        brewedCoffee = constructor.apply(brewedCoffee);
    }

    public AbstractCoffee getBrewedCoffee() {
        AbstractCoffee temp = brewedCoffee;
        brewedCoffee = null;
        return temp;
    }


}
