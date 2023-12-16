module com.example.unitconverter {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.unitconverter to javafx.fxml;
    exports com.example.unitconverter;
}