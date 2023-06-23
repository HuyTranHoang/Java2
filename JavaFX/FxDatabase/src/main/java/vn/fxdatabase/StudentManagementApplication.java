package vn.fxdatabase;

import io.github.palexdev.materialfx.css.themes.MFXThemeManager;
import io.github.palexdev.materialfx.css.themes.Themes;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class StudentManagementApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(StudentManagementApplication.class.getResource("student-management.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
//        StudentController studentController = fxmlLoader.getController();
//        studentController.setStage(stage);
        MFXThemeManager.addOn(scene, Themes.DEFAULT, Themes.LEGACY);
        scene.setFill(Color.TRANSPARENT);
        stage.setResizable(false);
        stage.setTitle("Student Management Application!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}