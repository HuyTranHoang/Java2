package vn.aptech.baikiemtra.utils;

import javafx.animation.FadeTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import javafx.util.Duration;
import vn.aptech.baikiemtra.BaiKiemTra;
import vn.aptech.baikiemtra.controller.BaseController;

import java.io.IOException;
import java.util.Random;

public class BaiKiemTraUtils {

    protected void scaleAnimation(Shape shape) {
        ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(1), shape);
        scaleTransition.setFromX(1.0);
        scaleTransition.setToX(1.25);
        scaleTransition.setFromY(1.0);
        scaleTransition.setToY(1.25);
        scaleTransition.setCycleCount(ScaleTransition.INDEFINITE);
        scaleTransition.setAutoReverse(true);
        scaleTransition.play();
    }

    protected void rotateAnimation(Shape shape) {
        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(1), shape);
        rotateTransition.setByAngle(360);
        rotateTransition.setCycleCount(RotateTransition.INDEFINITE);
        rotateTransition.setAutoReverse(true);
        rotateTransition.play();
    }

    protected void fadeAnimation(Shape shape) {
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), shape);
        fadeTransition.setFromValue(1.0);
        fadeTransition.setToValue(0.0);
        fadeTransition.setCycleCount(FadeTransition.INDEFINITE);
        fadeTransition.setAutoReverse(true);
        fadeTransition.play();
    }

    protected void setRandomAnimation(Shape shape) {
        switch (getRandomNumber(3)) {
            case 0 -> scaleAnimation(shape);
            case 1 -> rotateAnimation(shape);
            default -> fadeAnimation(shape);
        }
    }

    protected int getRandomNumber(int n) {
        Random random = new Random();
        return random.nextInt(n);
    }

    protected void showErrorAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(title);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public <T extends BaseController> void switchToScene(String fxmlFile, String title, Class<T> controllerClass, Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(BaiKiemTra.class.getResource(fxmlFile));
        Scene scene = new Scene(fxmlLoader.load());
        T controller = fxmlLoader.getController();
        controller.setStage(stage);
        stage.setTitle("Bài kiểm tra - " + title);
        stage.setResizable(false);
        stage.setScene(scene);
    }
}
