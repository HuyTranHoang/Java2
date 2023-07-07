module vn.bookobjectfile {
    requires javafx.controls;
    requires javafx.fxml;

    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;

    opens vn.bookobjectfile to javafx.fxml;
    exports vn.bookobjectfile;
}