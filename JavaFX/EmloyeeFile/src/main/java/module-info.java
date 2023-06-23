module vn.emloyeefile {
    requires javafx.controls;
    requires javafx.fxml;


    opens vn.emloyeefile to javafx.fxml;
    exports vn.emloyeefile;
}