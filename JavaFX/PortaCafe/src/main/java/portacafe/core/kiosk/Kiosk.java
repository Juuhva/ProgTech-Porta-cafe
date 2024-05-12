package portacafe.core.kiosk;

import portacafe.core.coffees.abstracts.AbstractCoffee;
import portacafe.core.factories.coffees.AllInOneCoffeeFactory;
import portacafe.core.factories.coffees.DarkCoffeeFactory;
import portacafe.core.factories.coffees.LightCoffeeFactory;
import portacafe.core.factories.coffees.MediumCoffeeFactory;
import portacafe.core.factories.toppings.ToppingFactory;
import portacafe.database.SqliteConnection;
import portacafe.database.commands.ListCartContentCommand;
import portacafe.database.commands.MakeMyOrderCommand;
import portacafe.database.commands.SqliteInsertCommand;
import portacafe.database.commands.SqliteQueryCommand;
import portacafe.database.datastructures.OrderedCoffeeEntry;
import portacafe.database.exceptions.CartIsEmptyException;
import portacafe.dialogs.MessageDialog;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Kiosk {
    private CoffeeMachine[] machines = new CoffeeMachine[] {
            new CoffeeMachine(new LightCoffeeFactory(), new ToppingFactory(), 100),
            new CoffeeMachine(new MediumCoffeeFactory(), new ToppingFactory(), 150),
            new CoffeeMachine(new DarkCoffeeFactory(), new ToppingFactory(), 200),
            new CoffeeMachine(new LightCoffeeFactory(), new ToppingFactory(), 200),
            new CoffeeMachine(new DarkCoffeeFactory(), new ToppingFactory(), 300),
            new CoffeeMachine(new AllInOneCoffeeFactory(), new ToppingFactory(), 450)
    };

    private final List<AbstractCoffee> madeCoffees = new ArrayList<>();
    public int orderID = -1;

    public void brewAllCoffeesInOrder() throws InterruptedException {
        Connection connection;
        try {
            connection = SqliteConnection.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        madeCoffees.clear();
        orderID = -1;
        List<OrderedCoffeeEntry> pendingCoffees;

        SqliteQueryCommand<OrderedCoffeeEntry> cmd =
                new ListCartContentCommand();
        cmd.execute(connection);
        pendingCoffees = cmd.getQueryResults();

        synchronized (madeCoffees) {
            while(!pendingCoffees.isEmpty() || machinesAreStillWorking()) {
                for (int i = 0; i < pendingCoffees.size(); i++) {
                    if(tryCreateCoffee(pendingCoffees.get(i))) {
                        pendingCoffees.remove(i);
                        i--;
                    }
                }

                if(!pendingCoffees.isEmpty() || machinesAreStillWorking())
                    madeCoffees.wait();
            }
        }

        try {
            SqliteInsertCommand<Integer> orderCmd =
                    new MakeMyOrderCommand();
            orderCmd.execute(connection);
            orderID = orderCmd.getID();
        } catch(CartIsEmptyException e) {
            MessageDialog.showError("A kosár üres; nincs mit főzni.");
        }
    }
    private boolean machinesAreStillWorking() {
        for (int i = 0; i < machines.length; i++) {
            if(machines[i].isOccupied())
                return true;
        }
        return false;
    }
    private boolean tryCreateCoffee(OrderedCoffeeEntry entry) throws InterruptedException {
        CoffeeMachine machine = null;
        for (int i = 0; i < machines.length; i++) {
            if(!machines[i].isOccupied() && machines[i].tryBrewCoffee(entry.coffeeType)) {
                machine = machines[i];
                break;
            }
        }
        if(machine == null)
            return false;

        new Thread(createCoffeeRunnable(machine, entry)).start();
        return true;
    }
    private Runnable createCoffeeRunnable(CoffeeMachine machine, OrderedCoffeeEntry entry) {
        return () -> {
            synchronized (madeCoffees) {
                try {
                    for (Integer id : entry.toppings.keySet()) {
                        for(int i = 0; i < entry.toppings.get(id); i++) {
                            machine.putToppingOnCoffee(id);
                        }
                    }
                } catch(Exception ex) {
                    throw new RuntimeException(ex);
                }
                madeCoffees.add(machine.getBrewedCoffee());
                madeCoffees.notifyAll();
            }
        };
    }

    public List<AbstractCoffee> getLastOrderCoffees() {
        return madeCoffees;
    }
    public int getLastOrderID() {
        return orderID;
    }


    public static void main(String[] args) throws InterruptedException {
        Kiosk kiosk = new Kiosk();
        kiosk.brewAllCoffeesInOrder();
    }
}
