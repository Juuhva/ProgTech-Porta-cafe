package portacafe.core.kiosk;

import portacafe.core.coffees.abstracts.AbstractCoffee;
import portacafe.core.factories.coffees.AllInOneCoffeeFactory;
import portacafe.core.factories.coffees.DarkCoffeeFactory;
import portacafe.core.factories.coffees.LightCoffeeFactory;
import portacafe.core.factories.coffees.MediumCoffeeFactory;
import portacafe.core.factories.toppings.ToppingFactory;
import portacafe.database.SqliteConnection;
import portacafe.database.commands.ListCartContentCommand;
import portacafe.database.commands.SqliteQueryCommand;
import portacafe.database.datastructures.OrderedCoffeeEntry;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Kiosk {
    private volatile CoffeeMachine[] machines = new CoffeeMachine[] {
            new CoffeeMachine(new LightCoffeeFactory(), new ToppingFactory(), 100),
            new CoffeeMachine(new MediumCoffeeFactory(), new ToppingFactory(), 150),
            new CoffeeMachine(new DarkCoffeeFactory(), new ToppingFactory(), 200),
            new CoffeeMachine(new LightCoffeeFactory(), new ToppingFactory(), 200),
            new CoffeeMachine(new DarkCoffeeFactory(), new ToppingFactory(), 300),
            new CoffeeMachine(new AllInOneCoffeeFactory(), new ToppingFactory(), 450)
    };
    public int orderID = -1;
/*
    public synchronized List<AbstractCoffee> brewAllCoffeesInOrder() throws InterruptedException {
        List<AbstractCoffee> madeCoffees = new ArrayList<>();
        List<OrderedCoffeeEntry> pendingCoffees;

        try{
            SqliteQueryCommand<OrderedCoffeeEntry> cmd =
                    new ListCartContentCommand();
            cmd.execute(SqliteConnection.getConnection());
            pendingCoffees = cmd.getQueryResults();
        }
        catch(SQLException ex) {
            pendingCoffees = new ArrayList<>();
        }

        while(!pendingCoffees.isEmpty()) {
            for (int i = 0; i < pendingCoffees.size(); i++) {
                AbstractCoffee madeCoffee =
                        createCoffee(pendingCoffees.get(i));
                if(madeCoffee != null) {
                    madeCoffees.add(madeCoffee);
                    pendingCoffees.remove(i);
                    i--; continue;
                }
            }
            wait();
        }

        return madeCoffees;
    }
    private synchronized AbstractCoffee createCoffee(OrderedCoffeeEntry entry) {
        CoffeeMachine machine;
        for (int i = 0; i < machines.length; i++) {
            machines
        }
    }*/

    public int getLastOrderID() {
        return orderID;
    }
}
