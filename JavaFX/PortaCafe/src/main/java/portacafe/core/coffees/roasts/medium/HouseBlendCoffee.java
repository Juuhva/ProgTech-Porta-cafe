package portacafe.core.coffees.roasts.medium;

import portacafe.core.coffees.roasts.MediumCoffee;

public class HouseBlendCoffee extends MediumCoffee {
    protected HouseBlendCoffee(int orderedCoffeeID) {
        super(orderedCoffeeID);
    }

    @Override
    protected int getCoffeeTypeIndex() {
        return 3;
    }

    @Override
    public String getCoffeeName() {
        return "House Blend";
    }

    @Override
    public String getCoffeeDescription() {
        return "Megtévesztően egyszerű. Latin-amerikai bab keveréke, amely csillogó, sötét gesztenye színűre pörkölt. Ízekkel teli, kiegyensúlyozó dió és kakaó ízek, csak egy kis édesség a sültből. Aroma, test és íz egyensúlyban van.";
    }

    @Override
    public int getTotalPrice() {
        return 1190;
    }
}
