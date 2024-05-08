module portacafe.portacafe {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires jdk.compiler;


    opens portacafe.portacafe to javafx.fxml;
    exports portacafe.portacafe;
}