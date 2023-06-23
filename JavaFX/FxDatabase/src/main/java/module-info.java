module vn.fxdatabase {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires MaterialFX;
    requires de.jensd.fx.glyphs.fontawesome;

    opens vn.fxdatabase to javafx.fxml;
    exports vn.fxdatabase;
}