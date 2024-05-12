package portacafe.core.exceptions;

public class LookupEntryNotFoundException extends PortaCafeException {
    public LookupEntryNotFoundException() {
        super("Nem található ilyen azonosítójú, vagy osztályú elem a kikeresőben.");
    }
}
