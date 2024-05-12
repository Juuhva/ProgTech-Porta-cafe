package portacafe.core.coffees.roasts.medium;

import portacafe.core.coffees.roasts.MediumCoffee;

public class PikePlaceRoastCoffee extends MediumCoffee {
    protected PikePlaceRoastCoffee(int orderedCoffeeID) {
        super(orderedCoffeeID);
    }

    @Override
    protected int getCoffeeTypeIndex() {
        return 5;
    }

    @Override
    public String getCoffeeName() {
        return "Pike Place Roast";
    }

    @Override
    public String getCoffeeDescription() {
        return "A Pike Place® Roast éppúgy ünnepli büszke történelmünket a piacon, mint egy szívből jövő koccintás igényes vásárlóinknak. Akár feketén, akár tejszínnel és cukorral kiegészítve szereti, egy merész, kielégítő csészét ígérünk, amely gazdag ízű, mégis kellően kiegyensúlyozott ahhoz, hogy mindennap élvezd.";
    }

    @Override
    public int getTotalPrice() {
        return 1390;
    }
}
