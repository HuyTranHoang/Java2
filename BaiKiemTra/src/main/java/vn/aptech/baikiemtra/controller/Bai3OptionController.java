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
        Toggle selectedToggle = tggShape.getSelectedToggle();
        int selectedColorIndex = cbbColor.getSelectionModel().getSelectedIndex();

        if (selectedToggle == null) {
            showErrorAlert("Hình vẽ không hợp lệ", "Bạn chưa chọn hình vẽ");
            return;
        }

        if (selectedColorIndex < 0) {
            showErrorAlert("Chưa chọn màu", "Bạn chưa chọn màu cho hình vẽ");
            return;
        }

        RadioButton selectedRadioButton = (RadioButton) selectedToggle;
        String selectedShape = selectedRadioButton.getText();
        Shape shapeObject = createShape(selectedShape);

        if (shapeObject != null) {
            shapeObject.setStrokeWidth(2);
            shapeObject.setStroke(Color.BLACK);
            shapeObject.setStrokeType(StrokeType.INSIDE);

            setRandomAnimation(shapeObject);

            shapeObject.setFill(Color.web(cbbColor.getValue()));

            double randomX = Math.random() * (root.getWidth() - shapeObject.getBoundsInLocal().getWidth());
            double randomY = Math.random() * (root.getHeight() - shapeObject.getBoundsInLocal().getHeight());
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


}
