module vn.aptech.baikiemtra {
    requires javafx.controls;
    requires javafx.fxml;


    opens vn.aptech.baikiemtra to javafx.fxml;
    exports vn.aptech.baikiemtra;
    opens vn.aptech.baikiemtra.controller to javafx.fxml;
    exports vn.aptech.baikiemtra.controller;
    exports vn.aptech.baikiemtra.utils;
    opens vn.aptech.baikiemtra.utils to javafx.fxml;
}