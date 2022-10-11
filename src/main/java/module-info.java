module com.example.krydsogbolle {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;


    opens com.example.krydsogbolle to javafx.fxml;
    exports com.example.krydsogbolle;
}