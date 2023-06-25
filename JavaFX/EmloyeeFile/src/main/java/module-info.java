module vn.emloyeefile {
    requires javafx.controls;
    requires javafx.fxml;
    requires net.synedra.validatorfx;


    opens vn.employeefile to javafx.fxml;
    exports vn.employeefile;
}