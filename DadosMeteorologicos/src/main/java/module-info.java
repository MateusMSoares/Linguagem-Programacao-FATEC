module com.example.dadosmeteorologicos {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires com.almasb.fxgl.all;
    requires com.opencsv;

    opens com.example.dadosmeteorologicos to javafx.fxml;
    exports com.example.dadosmeteorologicos;
}