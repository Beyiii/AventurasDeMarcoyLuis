module com.example.aventurasdemarcoyluis {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.aventurasdemarcoyluis to javafx.fxml;
    exports com.example.aventurasdemarcoyluis;
    exports com.example.aventurasdemarcoyluis.Player;
    opens com.example.aventurasdemarcoyluis.Player to javafx.fxml;
    exports com.example.aventurasdemarcoyluis.Enemy;
    opens com.example.aventurasdemarcoyluis.Enemy to javafx.fxml;
    exports com.example.aventurasdemarcoyluis.Items;
    opens com.example.aventurasdemarcoyluis.Items to javafx.fxml;
    exports com.example.aventurasdemarcoyluis.Controller;
    opens com.example.aventurasdemarcoyluis.Controller to javafx.fxml;
}