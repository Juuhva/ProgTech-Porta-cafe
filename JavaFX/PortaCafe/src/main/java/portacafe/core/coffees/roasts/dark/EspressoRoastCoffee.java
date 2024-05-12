package portacafe.core.coffees.roasts.dark;

import portacafe.core.coffees.roasts.DarkCoffee;

public class EspressoRoastCoffee extends DarkCoffee {
    @Override
    protected int getCoffeeTypeIndex() {
        return 1;
    }

    @Override
    public String getCoffeeName() {
        return "Espresso Roast";
    }

    @Override
    public String getCoffeeDescription() {
        return "Speciális keverék latin-amerikai és ázsiai fekete pörkölt kávébabokból, gazdag és karamellás ízzel. Mivel ennek a sűrű, testes főzött kávénak telt íze van, amely jól kivehető a tej íze mellett, ezért tökéletes alapot jelent egy latte vagy cappuccino elkészítéséhez otthon.";
    }

    @Override
    public int getTotalPrice() {
        return 1390;
    }
}
