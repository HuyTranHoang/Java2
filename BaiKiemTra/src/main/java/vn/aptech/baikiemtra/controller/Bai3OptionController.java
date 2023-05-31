package vn.aptech.baikiemtra.controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import vn.aptech.baikiemtra.utils.BaiKiemTraUtils;

public class Bai3OptionController extends BaiKiemTraUtils {

    @FXML
    private Button btnOptionOk;

    @FXML
    private ComboBox<String> cbbColor;

    @FXML
    private RadioButton rdbElipse;

    @FXML
    private RadioButton rdbRect;

    @FXML
    private RadioButton rdbTriangle;

    @FXML
    private ToggleGroup tggShape;

    @FXML
    private AnchorPane root;

    public void setShapeRoot(AnchorPane root) {
        this.root = root;
    }

    public void initialize() {
        addDataToComboBox();
    }

    private void addDataToComboBox() {
        cbbColor.getItems().addAll("Red", "Green", "Blue","Yellow","Pink");
    }

    public void optionConfirm() {
        String selectedRadioValue = getSelectedRadio();

        int selectedColorIndex = cbbColor.getSelectionModel().getSelectedIndex();

        if (selectedRadioValue == null) {
            showErrorAlert("Hình vẽ không hợp lệ", "Bạn chưa chọn hình vẽ");
            return;
        }

        if (selectedColorIndex < 0) {
            showErrorAlert("Màu vẽ không hợp lệ", "Bạn chưa chọn màu cho hình vẽ");
            return;
        }

        Shape shapeObject = createShape(selectedRadioValue);

        if (shapeObject != null) {
            shapeObject.setStrokeWidth(2);
            shapeObject.setStroke(Color.BLACK);
            shapeObject.setStrokeType(StrokeType.INSIDE);

            setRandomAnimation(shapeObject);

            shapeObject.setFill(Color.web(cbbColor.getValue()));

            double randomX = Math.random() * (root.getWidth() - shapeObject.getBoundsInLocal().getWidth() - 50);
            double randomY = Math.random() * (root.getHeight() - shapeObject.getBoundsInLocal().getHeight() - 50);
            shapeObject.setTranslateX(randomX);
            shapeObject.setTranslateY(randomY);

            root.getChildren().add(shapeObject);
        }

        Stage stage = (Stage) cbbColor.getScene().getWindow();
        stage.close();
    }

    private Shape createShape(String selectedShape) {
        return switch (selectedShape) {
            case "Rectangle" -> new Rectangle(50, 50, 100, 75);
            case "Triangle" -> new Polygon(50, 50, 100, 100, 150, 50);
            default -> new Ellipse(100, 75, 50, 25);
        };
    }

    private String getSelectedRadio() {
        return tggShape.getToggles()
                .stream()
                .map(RadioButton.class::cast)
                .filter(RadioButton::isSelected)
                .findFirst()
                .map(RadioButton::getText)
                .orElse(null);
    }


}