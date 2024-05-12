package portacafe.core.coffees.roasts.light;

import portacafe.core.coffees.roasts.LightCoffee;

public class BlondeEspressoCoffee extends LightCoffee {
    public static final int ID = 0;

    @Override
    public String getCoffeeName() {
        return "Blonde Espresso Roast";
    }

    @Override
    public String getCoffeeDescription() {
        return "Hihetetlenül sima és finoman édes, krémes szájízt hagyva maga után. Ez a világosabb pörkölés egyedi ízt kölcsönöz eszpresszóinknak. Ezt az egyedülálló keveréket oly módon személyre szabtuk, hogy kiemelje az eszpresszó világosabb oldalát, hogy krémes testet és édes citrusos jegyeket kaphass.";
    }

    @Override
    public int getTotalPrice() {
        return 1290;
    }
}
