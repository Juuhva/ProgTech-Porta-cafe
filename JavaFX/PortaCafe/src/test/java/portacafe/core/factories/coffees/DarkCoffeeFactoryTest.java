package portacafe.core.factories.coffees;

import org.junit.jupiter.api.Test;
import portacafe.core.coffees.Coffee;
import portacafe.core.coffees.abstracts.AbstractCoffee;
import portacafe.core.coffees.roasts.LightCoffee;
import portacafe.core.coffees.roasts.dark.CaffeVeronaCoffee;
import portacafe.core.coffees.roasts.dark.EspressoRoastCoffee;
import portacafe.core.coffees.roasts.dark.SumatraCoffee;
import portacafe.core.coffees.roasts.light.BlondeEspressoCoffee;
import portacafe.core.exceptions.CantBrewCoffeeException;

import static org.junit.jupiter.api.Assertions.*;

class DarkCoffeeFactoryTest {

    @Test
    void testCreateCaffeVeronaCoffee() {
        DarkCoffeeFactory factory = new DarkCoffeeFactory();
        AbstractCoffee coffee = factory.createCoffee(CaffeVeronaCoffee.class);
        assertNotNull(coffee);
        assertTrue(coffee instanceof CaffeVeronaCoffee);
    }

    @Test
    void testCreateEspressoRoastCoffee() {
        DarkCoffeeFactory factory = new DarkCoffeeFactory();
        AbstractCoffee coffee = factory.createCoffee(EspressoRoastCoffee.class);
        assertNotNull(coffee);
        assertTrue(coffee instanceof EspressoRoastCoffee);
    }

    @Test
    void testCreateSumatraCoffee() {
        DarkCoffeeFactory factory = new DarkCoffeeFactory();
        AbstractCoffee coffee = factory.createCoffee(SumatraCoffee.class);
        assertNotNull(coffee);
        assertTrue(coffee instanceof SumatraCoffee);
    }

    @Test
    void testCreateCoffeeWithInvalidType() {
        DarkCoffeeFactory factory = new DarkCoffeeFactory();
        assertThrows(CantBrewCoffeeException.class, () -> factory.createCoffee(BlondeEspressoCoffee.class));
    }
}