
CREATE TABLE Orders (
    ID INTEGER PRIMARY KEY AUTOINCREMENT,
    OrderedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    Completed BOOLEAN DEFAULT FALSE
);

CREATE TABLE OrderedCoffees (
    ID INTEGER PRIMARY KEY AUTOINCREMENT,
    CoffeeType INTEGER NOT NULL
);

CREATE TABLE ToppingsOnOrderedCoffee (
    OrderedCoffeeID INTEGER NOT NULL,
    ToppingTypeID INTEGER NOT NULL,
    ToppingCount INTEGER NOT NULL,

    PRIMARY KEY (OrderedCoffeeID, ToppingTypeID),
    FOREIGN KEY (OrderedCoffeeID) REFERENCES  OrderedCoffees(ID)
);

CREATE TABLE Cart (
    OrderedCoffeeID INTEGER PRIMARY KEY,

    FOREIGN KEY (OrderedCoffeeID) REFERENCES OrderedCoffees(ID)
);

CREATE TABLE CoffeesInOrder (
    OrderID INTEGER NOT NULL,
    OrderedCoffeeID INTEGER NOT NULL,

    PRIMARY KEY (OrderID, OrderedCoffeeID),
    FOREIGN KEY (OrderID) REFERENCES Orders(ID),
    FOREIGN KEY (OrderedCoffeeID) REFERENCES OrderedCoffees(ID)
);


CREATE TRIGGER ToppingsOnOrderedCoffee_CountIsZeroOrLess
    AFTER UPDATE
    ON ToppingsOnOrderedCoffee
    BEGIN
        DELETE FROM ToppingsOnOrderedCoffee
        WHERE ToppingCount <= 0;
    end;