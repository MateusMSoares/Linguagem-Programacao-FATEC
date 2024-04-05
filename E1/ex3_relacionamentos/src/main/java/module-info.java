module com.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;

    opens com.example to javafx.fxml;
    opens com.example.controller to javafx.fxml;
    opens com.example.model to javafx.base;
    opens com.example.service to javafx.base;

    exports com.example;
}
