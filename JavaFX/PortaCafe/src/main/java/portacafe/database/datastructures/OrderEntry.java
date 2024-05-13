package portacafe.database.datastructures;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class OrderEntry {
    public int orderId;
    public Timestamp orderedAt;
    public boolean completed;
    public List<OrderedCoffeeEntry> orderedCoffees =
            new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderEntry that)) return false;
        return orderId == that.orderId;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(orderId);
    }
}
