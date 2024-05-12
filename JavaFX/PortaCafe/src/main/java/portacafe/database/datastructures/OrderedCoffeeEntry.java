package portacafe.database.datastructures;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class OrderedCoffeeEntry {
    public int orderedCoffeeId;
    public int coffeeType;
    public Map<Integer, Integer> toppings
            = new HashMap<>();
}
