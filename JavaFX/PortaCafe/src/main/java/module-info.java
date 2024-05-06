module portacafe.portacafe {
    requires javafx.controls;
    requires javafx.fxml;


    opens portacafe.portacafe to javafx.fxml;
    exports portacafe.portacafe;
}