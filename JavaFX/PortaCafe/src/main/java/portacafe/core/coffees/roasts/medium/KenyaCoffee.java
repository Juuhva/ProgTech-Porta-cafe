package portacafe.core.coffees.roasts.medium;

import portacafe.core.coffees.roasts.MediumCoffee;

public class KenyaCoffee extends MediumCoffee {
    protected KenyaCoffee(int orderedCoffeeID) {
        super(orderedCoffeeID);
    }

    @Override
    protected int getCoffeeTypeIndex() {
        return 4;
    }

    @Override
    public String getCoffeeName() {
        return "Kenya";
    }

    @Override
    public String getCoffeeDescription() {
        return "Ragyogó, lédús savakkal, alacsony boros jegyekkel és gyümölcsös ízekkel – a fekete ribizlitől és szedertől a fanyar grapefruitig, más eredetű, összetéveszthetetlen jegyekkel –, amelyek a kávé lehűlésével egyre hangsúlyosabbá válnak. A Kenya kávé mennyei jégen tálalva, és jegeskávé keverékeink fontos összetevője.";
    }

    @Override
    public int getTotalPrice() {
        return 1090;
    }
}
