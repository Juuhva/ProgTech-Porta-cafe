package portacafe.database.datastructures;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class OrderEntry {
    public int orderId;
    public Timestamp orderedAt;
    public boolean completed;
    public List<OrderedCoffeeEntry> orderedCoffees =
            new ArrayList<>();
}
