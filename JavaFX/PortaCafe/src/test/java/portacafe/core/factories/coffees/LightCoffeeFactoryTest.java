package portacafe.core.factories.coffees;

import org.junit.jupiter.api.Test;
import portacafe.core.coffees.Coffee;
import portacafe.core.coffees.roasts.light.BlondeEspressoCoffee;
import portacafe.core.coffees.roasts.medium.KenyaCoffee;
import portacafe.core.exceptions.CantBrewCoffeeException;
import portacafe.core.factories.lookups.CoffeeLookup;

import static org.junit.jupiter.api.Assertions.*;

class LightCoffeeFactoryTest {


    @Test
    void testCreateCoffeeWithClassType() {
        LightCoffeeFactory factory = new LightCoffeeFactory();
        Coffee coffee = factory.createCoffee(BlondeEspressoCoffee.class);
        assertNotNull(coffee);
        assertTrue(coffee instanceof BlondeEspressoCoffee);
    }

    @Test
    void testCreateCoffeeWithInvalidType() {
        LightCoffeeFactory factory = new LightCoffeeFactory();
        assertThrows(CantBrewCoffeeException.class, () -> factory.createCoffee(KenyaCoffee.class));
    }


}