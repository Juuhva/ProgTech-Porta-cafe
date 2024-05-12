package portacafe.core.kiosk;
import portacafe.core.coffees.Coffee;
import portacafe.core.coffees.abstracts.AbstractCoffee;
import portacafe.core.coffees.abstracts.AbstractTopping;
import portacafe.core.exceptions.CantBrewCoffeeException;
import portacafe.core.factories.AbstractCoffeeFactory;
import portacafe.core.factories.AbstractToppingFactory;
import portacafe.core.factories.lookups.CoffeeLookup;
import portacafe.core.factories.lookups.ToppingLookup;

public class CoffeeMachine {
    private AbstractCoffee brewedCoffee = null;

    private AbstractCoffeeFactory coffeeFactory;
    private AbstractToppingFactory toppingFactory;
    private int timeForEachTask;

    public CoffeeMachine(AbstractCoffeeFactory coffeeFactory, AbstractToppingFactory toppingFactory, int timeForEachTask) {
        this.coffeeFactory = coffeeFactory;
        this.toppingFactory = toppingFactory;
        this.timeForEachTask = timeForEachTask;
    }

    public boolean tryBrewCoffee(int typeId) throws InterruptedException {
        return tryBrewCoffee(CoffeeLookup.set().getType(typeId));
    }
    public boolean tryBrewCoffee(Class<? extends Coffee> coffee) throws InterruptedException {
        try {
            brewedCoffee = coffeeFactory.createCoffee(coffee);
            Thread.sleep(timeForEachTask);
            return true;
        } catch (CantBrewCoffeeException ex) {
            return false;
        }
    }

    public void putToppingOnCoffee(int typeId) throws InterruptedException {
        putToppingOnCoffee(ToppingLookup.set().getType(typeId));
    }
    public void putToppingOnCoffee(Class<? extends AbstractTopping> topping) throws InterruptedException {
        Thread.sleep(timeForEachTask);
        brewedCoffee = toppingFactory.makeTopping(brewedCoffee, topping);
    }

    public AbstractCoffee getBrewedCoffee() {
        AbstractCoffee temp = brewedCoffee;
        brewedCoffee = null;

        return temp;
    }

    public boolean isOccupied() {
        return brewedCoffee != null;
    }
}
