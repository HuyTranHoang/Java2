module vn.emloyeefile {
    requires javafx.controls;
    requires javafx.fxml;


    opens vn.employeefile to javafx.fxml;
    exports vn.employeefile;
}