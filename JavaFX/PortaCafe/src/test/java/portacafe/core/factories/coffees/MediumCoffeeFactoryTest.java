package portacafe.core.factories.coffees;

import org.junit.jupiter.api.Test;
import portacafe.core.coffees.Coffee;
import portacafe.core.coffees.roasts.dark.SumatraCoffee;
import portacafe.core.coffees.roasts.medium.*;
import portacafe.core.exceptions.CantBrewCoffeeException;

import static org.junit.jupiter.api.Assertions.*;

class MediumCoffeeFactoryTest {

    @Test
    void testCreateColombiaCoffee() {
        MediumCoffeeFactory factory = new MediumCoffeeFactory();
        Coffee coffee = factory.createCoffee(ColombiaCoffee.class);
        assertNotNull(coffee);
        assertTrue(coffee instanceof ColombiaCoffee);
    }

    @Test
    void testCreateEthiopiaCoffee() {
        MediumCoffeeFactory factory = new MediumCoffeeFactory();
        Coffee coffee = factory.createCoffee(EthiopiaCoffee.class);
        assertNotNull(coffee);
        assertTrue(coffee instanceof EthiopiaCoffee);
    }

    @Test
    void testCreateGuatemalaAntiguaCoffee() {
        MediumCoffeeFactory factory = new MediumCoffeeFactory();
        Coffee coffee = factory.createCoffee(GuatemalaAntiguaCoffee.class);
        assertNotNull(coffee);
        assertTrue(coffee instanceof GuatemalaAntiguaCoffee);
    }

    @Test
    void testCreateHouseBlendCoffee() {
        MediumCoffeeFactory factory = new MediumCoffeeFactory();
        Coffee coffee = factory.createCoffee(HouseBlendCoffee.class);
        assertNotNull(coffee);
        assertTrue(coffee instanceof HouseBlendCoffee);
    }

    @Test
    void testCreateKenyaCoffee() {
        MediumCoffeeFactory factory = new MediumCoffeeFactory();
        Coffee coffee = factory.createCoffee(KenyaCoffee.class);
        assertNotNull(coffee);
        assertTrue(coffee instanceof KenyaCoffee);
    }

    @Test
    void testCreatePikePlaceRoastCoffee() {
        MediumCoffeeFactory factory = new MediumCoffeeFactory();
        Coffee coffee = factory.createCoffee(PikePlaceRoastCoffee.class);
        assertNotNull(coffee);
        assertTrue(coffee instanceof PikePlaceRoastCoffee);
    }
    @Test
    void testCreateCoffeeWithInvalidType() {
        MediumCoffeeFactory factory = new MediumCoffeeFactory();
        assertThrows(CantBrewCoffeeException.class, () -> factory.createCoffee(SumatraCoffee.class));
    }

}
