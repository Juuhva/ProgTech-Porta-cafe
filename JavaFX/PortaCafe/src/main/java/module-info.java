module portacafe.portacafe {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires jdk.compiler;
    requires java.sql;
    requires org.apache.logging.log4j.core;
    requires org.apache.logging.log4j;


    opens portacafe.portacafe to javafx.fxml;
    exports portacafe.portacafe;
}