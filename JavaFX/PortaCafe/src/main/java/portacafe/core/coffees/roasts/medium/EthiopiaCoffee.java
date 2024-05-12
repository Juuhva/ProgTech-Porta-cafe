package portacafe.core.coffees.roasts.medium;

import portacafe.core.coffees.roasts.MediumCoffee;

public class EthiopiaCoffee extends MediumCoffee {
    protected EthiopiaCoffee(int orderedCoffeeID) {
        super(orderedCoffeeID);
    }

    @Override
    protected int getCoffeeTypeIndex() {
        return 1;
    }

    @Override
    public String getCoffeeName() {
        return "Ethiopia";
    }

    @Override
    public String getCoffeeDescription() {
        return "Kiváló keverék a kávé rituáléjának hódolva, tiszteletben tartva Etiópia bőséges örökségét. Bársonyosan lágy textúrájával és virágos, borsos fűszerjegyeivel tisztelegünk a kávé szülőhelye előtt.";
    }

    @Override
    public int getTotalPrice() {
        return 990;
    }
}
