package vn.aptech.baikiemtra.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import vn.aptech.baikiemtra.utils.BaiKiemTraUtils;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.stream.IntStream;

public class Bai1Controller extends BaiKiemTraUtils implements BaseController {

    @FXML
    private BarChart<String,Integer> barChart;

    @FXML
    private Button btnMenu;

    @FXML
    private Button btnFileChooser;

    @FXML
    private CategoryAxis categoryAxis;

    private Stage stage;
    private FileChooser fileChooser;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void switchToMenu(ActionEvent event) throws IOException {
        switchToScene("menu.fxml", "Menu", BaiKiemTraController.class, stage);
    }

    public void initialize() {
        categoryAxis.setAnimated(false);
        initOpenFile();
    }

    public void addDataToBarChart(String[] data) {
        barChart.getData().clear();
        XYChart.Series<String, Integer> series = new XYChart.Series<>();
        series.setName("2022");
        IntStream.range(0, data.length)
                .forEach(i -> series.getData().add(new XYChart.Data<>(String.valueOf(i + 1), Integer.parseInt(data[i]))));
        barChart.getData().add(series);
    }

    public void initOpenFile() {
        fileChooser = new FileChooser();
        btnFileChooser.setOnAction(event -> {
            File file = fileChooser.showOpenDialog(this.stage);
            if (file != null) {
                String fileName = file.getName();
                if (fileName.endsWith(".txt")) {
                    try {
                        String content = Files.readString(file.toPath());
                        String[] data = content.split(" ");
                        addDataToBarChart(data);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                } else {
                    showErrorAlert("Sai định dạng file", "Vui lòng chọn file .txt");
                }
            }
        });
    }

}
