package portacafe.core.coffees.roasts.medium;

import portacafe.core.coffees.roasts.MediumCoffee;

public class GuatemalaAntiguaCoffee extends MediumCoffee {
    public static final int ID = 102;

    @Override
    public String getCoffeeName() {
        return "Guatemala Antigua";
    }

    @Override
    public String getCoffeeDescription() {
        return "Elegáns és kifinomult, kibontakozó ízrétegekkel – a citrom, a csokoládé és a lágy fűszer jegyei. A guatemalai Antigua-völgyet 100 éves farmjairól, tápanyagban gazdag vulkáni talajáról és a minőség próbakövének számító kávéjáról őrzik.";
    }

    @Override
    public int getTotalPrice() {
        return 1290;
    }
}
