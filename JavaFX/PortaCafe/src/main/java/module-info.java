module portacafe.portacafe {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens portacafe.portacafe to javafx.fxml;
    exports portacafe.portacafe;
}