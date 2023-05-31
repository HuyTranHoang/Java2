package vn.aptech.baikiemtra.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import vn.aptech.baikiemtra.*;
import vn.aptech.baikiemtra.utils.BaiKiemTraUtils;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Bai3Controller extends BaiKiemTraUtils implements BaseController {

    @FXML
    public ToggleGroup tggShape;

    @FXML
    private MenuItem menuBackToMainMenu;

    @FXML
    private MenuItem menuClearAll;

    @FXML
    private MenuItem menuExit;

    @FXML
    private MenuItem menuOption;

    @FXML
    private AnchorPane root;

    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void switchToMenu(ActionEvent event) throws IOException {
        switchToScene("menu.fxml", "Menu", BaiKiemTraController.class, stage);
    }

    public void initialize() {
        initDefaultShape();
    }

    public void initDefaultShape() {
        List<Color> fillColors = Arrays.asList(Color.RED, Color.BLUE, Color.PINK, Color.YELLOW, Color.GREEN);

        for (int i = 0; i < 3; i++) {
            Shape shapeObject;
            switch (getRandomNumber(3)) {
                case 0 -> shapeObject = new Rectangle(50, 50, 100, 75);
                case 1 -> shapeObject = new Polygon(50, 50, 100, 100, 150, 50);
                default -> shapeObject = new Ellipse(100, 75, 50, 25);
            }
            shapeObject.setStrokeWidth(2);
            shapeObject.setStroke(Color.BLACK);
            shapeObject.setStrokeType(StrokeType.INSIDE);

            setRandomAnimation(shapeObject);

            int randomIndex = getRandomNumber(5);
            shapeObject.setFill(fillColors.get(randomIndex));

            shapeObject.setTranslateX(i*150);
            shapeObject.setTranslateY(getRandomNumber(150));

            root.getChildren().add(shapeObject);
        }
    }

    public void openOption() throws IOException {
        Stage optionStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(BaiKiemTra.class.getResource("bai3-option.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Bai3OptionController controller = fxmlLoader.getController();
        controller.setShapeRoot(root);
        optionStage.setScene(scene);
        optionStage.setTitle("Option menu");
        optionStage.initModality(Modality.APPLICATION_MODAL);
        optionStage.initOwner(this.stage);
        optionStage.getIcons().add(new Image(BaiKiemTra.class.getResourceAsStream("asset/GuraIcon.jpg")));
        optionStage.setResizable(false);
        optionStage.show();
    }

    public void clearAll() {
        root.getChildren().clear();
    }

    public void exit() {
        this.stage.close();
    }
}
