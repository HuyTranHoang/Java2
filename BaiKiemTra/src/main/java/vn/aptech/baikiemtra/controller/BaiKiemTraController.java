package vn.aptech.baikiemtra.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import vn.aptech.baikiemtra.utils.BaiKiemTraUtils;

import java.io.IOException;

public class BaiKiemTraController extends BaiKiemTraUtils implements BaseController {

    @FXML
    private Button btnBai1;

    @FXML
    private Button btnBai2;

    @FXML
    private Button btnBai3;

    @FXML
    private Button btnExit;

    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void switchToScene1() throws IOException {
        switchToScene("bai1.fxml", "Bài 1", Bai1Controller.class, stage);
    }

    public void switchToScene2() throws IOException {
        switchToScene("bai2.fxml", "Bài 2", Bai2Controller.class, stage);
    }

    public void switchToScene3() throws IOException {
        switchToScene("bai3.fxml", "Bài 3", Bai3Controller.class, stage);

    }

    public void exit() {
        this.stage.close();
    }
}