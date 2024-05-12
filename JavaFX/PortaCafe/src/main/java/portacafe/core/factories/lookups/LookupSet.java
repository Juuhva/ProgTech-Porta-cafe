package portacafe.core.factories.lookups;

import portacafe.core.exceptions.LookupEntryNotFoundException;

import java.util.HashMap;
import java.util.Map;

public class LookupSet<T> {
    private Map<Integer, Class<? extends T>>
            mapById = new HashMap<>();
    private Map<Class<? extends T>, Integer>
            mapByType = new HashMap<>();

    protected void add(int id, Class<? extends T> type) {
        mapById.put(id, type);
        mapByType.put(type, id);
    }

    public Class<? extends T> getType(int id)
            throws LookupEntryNotFoundException {
        if(!mapById.containsKey(id))
            throw new LookupEntryNotFoundException();
        return mapById.get(id);
    }
    public int getID(Class<? extends T> type)
            throws LookupEntryNotFoundException {
        if(!mapByType.containsKey(type))
            throw new LookupEntryNotFoundException();
        return mapByType.get(type);
    }
}
