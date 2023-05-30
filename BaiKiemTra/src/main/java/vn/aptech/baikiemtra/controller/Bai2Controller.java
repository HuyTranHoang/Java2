package vn.aptech.baikiemtra.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import vn.aptech.baikiemtra.utils.BaiKiemTraUtils;

import java.io.IOException;

public class Bai2Controller extends BaiKiemTraUtils implements BaseController {
    @FXML
    public Button btnMenu;

    @FXML
    private Button btnMBI;

    @FXML
    private ComboBox<String> cbbEvaluation;

    @FXML
    private Label lblResult;

    @FXML
    private Label lblErrHeight;

    @FXML
    private Label lblErrWeight;

    @FXML
    private TextField txtHeight;

    @FXML
    private TextField txtWeight;
    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void switchToMenu(ActionEvent event) throws IOException {
        switchToScene("menu.fxml", "Menu", BaiKiemTraController.class, stage);
    }

    public void initialize() {
        addDataToComboBox();
    }

    public void addDataToComboBox() {
        cbbEvaluation.getItems().addAll("WHO","IDI & WPRO BMI");
        cbbEvaluation.getSelectionModel().selectFirst();
    }

    private float getWeight() {
        try {
            float weight = Float.parseFloat(txtWeight.getText());
            if (weight > 0) {
                lblErrWeight.setText("");
                return weight;
            }
            lblErrWeight.setText("*Không thể nhập số âm hoặc 0");
            return -1;
        } catch (NumberFormatException e) {
            lblErrWeight.setText("*Chỉ có thể nhập số thực");
            if (txtWeight.getText().trim().isEmpty()){
                lblErrWeight.setText("*Cần phải nhập cân nặng");
            }
            return -1;
        }
    }

    private float getHeight() {
        try {
            float height = Float.parseFloat(txtHeight.getText());
            if (height > 0) {
                lblErrHeight.setText("");
                return height;
            }
            lblErrHeight.setText("Không thể nhập số âm hoặc 0");
            return -1;
        } catch (NumberFormatException e) {
            lblErrHeight.setText("*Chỉ có thể nhập số thực");
            if (txtHeight.getText().trim().isEmpty()){
                lblErrHeight.setText("*Cần phải nhập chiều cao");
            }
            return -1;
        }
    }

    public void calculatedMBI() {
        float weight = getWeight();
        float height = getHeight();
        if (weight != -1 && height != -1) {
            height /= 100;
            float MBI = weight/(height*height);
            int index = cbbEvaluation.getSelectionModel().getSelectedIndex();
            String result;
            if (index == 0) {
                if (MBI < 18.5) {
                    result = "Bạn cân nặng thấp (gầy)";
                } else if (MBI <= 24.9) {
                    result = "Bạn bình thường";
                }  else if (MBI == 25) {
                    result = "Bạn thừa cân";
                } else if (MBI <= 29.9) {
                    result = "Bạn tiền béo phì";
                } else if (MBI <= 34.9) {
                    result = "Bạn béo phì độ I";
                } else if (MBI <= 39.9) {
                    result = "Bạn béo phì độ II";
                } else {
                    result = "Bạn béo phì độ III";
                }
            } else {
                if (MBI < 18.5) {
                    result = "Bạn cân nặng thấp (gầy)";
                } else if (MBI <= 22.9) {
                    result = "Bạn bình thường";
                } else if (MBI == 23) {
                    result = "Bạn thừa cân";
                } else if (MBI <= 24.9) {
                    result = "Bạn tiền béo phì";
                } else if (MBI <= 29.9) {
                    result = "Bạn béo phì độ I";
                } else if (MBI <= 30) {
                    result = "Bạn béo phì độ II";
                } else {
                    result = "Bạn béo phì độ III";
                }
            }
            lblResult.setText(result);
        } else {
            lblResult.setText("");
        }
    }
}
