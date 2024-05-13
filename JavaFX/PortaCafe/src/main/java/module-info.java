module portacafe.portacafe {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires jdk.compiler;
    requires java.sql;
    requires org.apache.logging.log4j.core;
    requires org.apache.logging.log4j;
    requires org.xerial.sqlitejdbc;


    opens portacafe.portacafe to javafx.fxml;
    opens portacafe.core.coffees.abstracts to javafx.base;
    opens portacafe.core.coffees.roasts.medium to javafx.base;
    opens portacafe.core.coffees to javafx.base;
    opens portacafe.core.coffees.roasts.light to javafx.base;
    opens portacafe.core.coffees.roasts.dark to javafx.base;
    exports portacafe.portacafe;
}