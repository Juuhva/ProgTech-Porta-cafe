package portacafe.core.coffees.roasts.dark;

import portacafe.core.coffees.roasts.DarkCoffee;

public class SumatraCoffee extends DarkCoffee {

    @Override
    public String getCoffeeName() {
        return "Sumatra";
    }

    @Override
    public String getCoffeeDescription() {
        return "Telt, vajasan testes kávé, szinte savasság nélkül, így az intenzitása és ízvilága szinte táncra perdül az ember nyelvén. Ne értsd félre, ez tényleg egy szürcsölhető kávé. A koncentrált gyógyfüves jellege és föld közeli aromája azonnal felismerhetővé teszi ezt a speciális kávét, amely azonnal nyomot hagy a szívünkben és a pólónkon.";
    }

    @Override
    public int getTotalPrice() {
        return 1290;
    }
}
