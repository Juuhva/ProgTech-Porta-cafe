package portacafe.core.coffeemachines;

import portacafe.core.coffeemachines.strategy.CoffeeStrategy;
import portacafe.core.coffeemachines.strategy.LightCoffeeStrategy;
import portacafe.core.coffees.Coffee;
import portacafe.core.coffees.abstracts.AbstractCoffee;
import portacafe.core.coffees.abstracts.AbstractTopping;
import portacafe.core.coffees.roasts.LightCoffee;
import portacafe.core.coffees.toppings.CreamTopping;
import portacafe.core.exceptions.CantBrewCoffeeException;
import portacafe.core.factories.AbstractCoffeeFactory;

import java.util.Objects;
import java.util.function.Function;
import java.util.function.Supplier;

public class CoffeeMachine {

    private CoffeeStrategy strategy;
    private AbstractCoffee brewedCoffee;
    private AbstractCoffeeFactory coffeeFactory;

    public CoffeeMachine(AbstractCoffeeFactory factory, CoffeeStrategy strategy) {
        this.coffeeFactory = factory;
        this.strategy = strategy;
    }

    public void brewCoffee(Coffee coffee) throws CantBrewCoffeeException {
        if (!canBrewCoffee(coffee)) {
            throw new CantBrewCoffeeException();
        }
        brewedCoffee = coffee;
    }

    public boolean canBrewCoffee(Coffee coffee){
        return strategy.canMakeCoffee(coffee.getClass());
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
