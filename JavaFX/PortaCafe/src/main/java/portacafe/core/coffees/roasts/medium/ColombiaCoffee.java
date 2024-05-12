package portacafe.core.coffees.roasts.medium;

import portacafe.core.coffees.roasts.MediumCoffee;

public class ColombiaCoffee extends MediumCoffee {
    @Override
    protected int getCoffeeTypeIndex() {
        return 0;
    }

    @Override
    public String getCoffeeName() {
        return "Colombia";
    }

    @Override
    public String getCoffeeDescription() {
        return "A Colombia Nariño lédús érzetet kelt és gyógynövényes ízjegyekkel rendelkezik, ami a vulkanikus talajok tápláló gazdagságáról tanúskodik. A 7500 méteres magasságban, a gyönyörű és jellegzetes kolumbiai vidék között elhelyezkedő farmok ennek a csodálatos kávénak a legjavát állítják elő. Figyelemre méltó és jellegzetes íze a kávé szerelmeseinek hűséges követőit teremti meg.";
    }

    @Override
    public int getTotalPrice() {
        return 1190;
    }
}
