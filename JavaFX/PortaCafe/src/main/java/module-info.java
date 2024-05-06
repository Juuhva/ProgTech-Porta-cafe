module beadando.portacafe {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens beadando.portacafe to javafx.fxml;
    exports beadando.portacafe;
}