package portacafe.core.coffees.roasts.dark;

import portacafe.core.coffees.roasts.DarkCoffee;

public class CaffeVeronaCoffee extends DarkCoffee {
    @Override
    protected int getCoffeeTypeIndex() {
        return 0;
    }

    @Override
    public String getCoffeeName() {
        return "Caffè Verona";
    }

    @Override
    public String getCoffeeDescription() {
        return "A Caffè Verona® egy csábító keverék latin-amerikai és indonéziai kávébabokból, enyhe Italian Roast érintéssel, mély, lélekemelő édességgel. Mivel ez az élvezetes kombináció kiválóan illik a csokoládéhoz, Valentin-napi kedvenc lett - és az a kávé, amelyet leginkább a romantikához kötünk. Bella, Bella!";
    }

    @Override
    public int getTotalPrice() {
        return 1190;
    }
}
