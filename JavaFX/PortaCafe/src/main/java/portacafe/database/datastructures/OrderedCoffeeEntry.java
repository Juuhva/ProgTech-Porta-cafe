package portacafe.database.datastructures;

import java.util.LinkedHashMap;

public class OrderedCoffeeEntry {
    public int orderedCoffeeId;
    public LinkedHashMap<Integer, Integer> toppings
            = new LinkedHashMap<>();
}
