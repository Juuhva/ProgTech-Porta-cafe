package portacafe.database.datastructures;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class OrderedCoffeeEntry {
    public int orderedCoffeeId;
    public int coffeeType;
    public Map<Integer, Integer> toppings
            = new HashMap<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderedCoffeeEntry that)) return false;
        return orderedCoffeeId == that.orderedCoffeeId;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(orderedCoffeeId);
    }
}
