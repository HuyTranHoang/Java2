module vn.emloyeefile {
    requires javafx.controls;
    requires javafx.fxml;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.core;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.ikonli.fontawesome5;


    opens vn.employeefile to javafx.fxml;
    exports vn.employeefile;
}