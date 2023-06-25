package vn.employeefile;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import net.synedra.validatorfx.Validator;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmloyeeController extends ArrayList<Emloyee> {

    @FXML
    private AnchorPane apPromote;

    @FXML
    private AnchorPane apTableView;

    @FXML
    private Button btnConfirm;

    @FXML
    private TableColumn<Emloyee, Integer> colCode;

    @FXML
    private TableColumn<Emloyee, String> colName;

    @FXML
    private TableColumn<Emloyee, Double> colSalary;

    @FXML
    private Label lblCode;

    @FXML
    private Label lblName;

    @FXML
    private Label lblOldSalary;

    @FXML
    private TableView<Emloyee> tvEmloyee;

    @FXML
    private TextField txtCode;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtNewSalary;

    @FXML
    private TextField txtSalary;

    private Validator validator = new Validator();

    private boolean codeIsDirty = false;
    private boolean nameIsDirty = false;
    private boolean salaryIsDirty = false;

    private ObservableList<Emloyee> observableList;

    public void initialize() {
        readFile();
        addDataToTableview();
        validator();

        txtCode.setOnKeyPressed(keyEvent -> codeIsDirty = true);
        txtName.setOnKeyPressed(keyEvent -> nameIsDirty = true);
        txtSalary.setOnKeyPressed(keyEvent -> salaryIsDirty = true);
//        validator();
//        resize(svgAdd, 50, 30);
    }

//    private void resize(SVGPath svg, double width, double height) {
//
//        double originalWidth = svg.prefWidth(-1);
//        double originalHeight = svg.prefHeight(originalWidth);
//
//        double scaleX = width / originalWidth;
//        double scaleY = height / originalHeight;
//
//        svg.setScaleX(scaleX);
//        svg.setScaleY(scaleY);
//    }

    @FXML
    void validator() {
        validator.createCheck()
                .dependsOn("Name", txtName.textProperty())
                .withMethod(context -> {
                    String name = context.get("Name");
                    if (!nameIsDirty) return;
                    if (name.isEmpty())
                        context.error("Name input is required");
                })
                .decorates(txtName)
                .immediate();

        validator.createCheck()
                .dependsOn("Code", txtCode.textProperty())
                .withMethod(context -> {
                    String code = context.get("Code");
                    if (!codeIsDirty) return;
                    if (code.isEmpty())
                        context.error("Code input is required");
                    else if (!isNumberic(code))
                        context.error("Code must be number");
                    else if (Integer.parseInt(code) < 0)
                        context.error(("Code must be greater than zero"));
                })
                .decorates(txtCode)
                .immediate();

        validator.createCheck()
                .dependsOn("Salary", txtSalary.textProperty())
                .withMethod(context -> {
                    String salary = context.get("Salary");
                    if (!salaryIsDirty) return;
                    if (salary.isEmpty())
                        context.error("Salary input is required");
                    else if (!isNumberic(salary))
                        context.error("Salary must be number");
                    else if (Double.parseDouble(salary) <= 0)
                        context.error("Salary must greater than zero");
                })
                .decorates(txtSalary)
                .immediate();
    }

    private boolean isNumberic(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    @FXML
    void readFile() {
        InputStream inputStream = getClass().getResourceAsStream("employee.txt");
        if (inputStream == null) {
            System.out.println("The file is not exist");
            return;
        }
        String details;
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        try {
            while ((details = bufferedReader.readLine()) != null) {
                List<String> items = Arrays.asList(details.split(","));

                int code = Integer.parseInt(items.get(0));
                String name = items.get(1);
                double salary = Double.parseDouble(items.get(2));

                Emloyee emloyee = new Emloyee(code, name, salary);
                this.add(emloyee);
            }
            bufferedReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void saveToFile() {
        String filePath = "employee.txt";
        URL resourceUrl = getClass().getResource(filePath);
        if (resourceUrl != null) {
            String fileAbsolutePath = resourceUrl.getFile();
            try {
                FileWriter fileWriter = new FileWriter(fileAbsolutePath);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

                for (Emloyee emloyee: this) {
                    String s = emloyee.getCode() + ","
                            + emloyee.getName()  + ","
                            + emloyee.getSalary();
                    bufferedWriter.write(s);
                    bufferedWriter.newLine();
                }

                alertSuccess("Save to file successfully!!!");
                bufferedWriter.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            alertError("File not found.");
        }

    }

    @FXML
    void addToList() {
        if (validator.validate()) {
            int code = Integer.parseInt(txtCode.getText());
            String name = txtName.getText();
            double salary = Double.parseDouble(txtSalary.getText());

            Emloyee emloyee = new Emloyee(code, name, salary);
            this.add(emloyee);

            observableList = FXCollections.observableArrayList(this);
            tvEmloyee.setItems(observableList);
        }
    }

    @FXML
    void removeFromList() {
        int index = tvEmloyee.getSelectionModel().getSelectedIndex();

        if (index == -1) {
            alertError("Please select employee to remove!!!");
            return;
        }

        this.remove(index);

        observableList.setAll(this);
        tvEmloyee.setItems(observableList);
    }

    @FXML
    void promotingSalary() {
        int index = tvEmloyee.getSelectionModel().getSelectedIndex();

        if (index == -1) {
            alertError("Please select employee to promoting!!!");
            return;
        }

        apTableView.setVisible(false);
        apPromote.setVisible(true);

        Emloyee emloyee = this.get(index);

        lblCode.setText(String.valueOf(emloyee.getCode()));
        lblName.setText(emloyee.getName());
        lblOldSalary.setText(String.valueOf(emloyee.getSalary()));

        btnConfirm.setOnAction(actionEvent -> confirmSalary(emloyee));
    }

    private void confirmSalary(Emloyee emloyee) {
        double salary = Double.parseDouble(txtNewSalary.getText());

        if (emloyee.getSalary() > salary) {
            alertError("New salary must greater than old salary!!!");
            return;
        }

        emloyee.setSalary(salary);

        alertSuccess("Promoting salary successfully!!!");

        txtNewSalary.setText("");
        backToView();

        observableList.setAll(this);
        tvEmloyee.setItems(observableList);
    }
    
    @FXML
    void backToView() {
        apTableView.setVisible(true);
        apPromote.setVisible(false);
    }

    private void addDataToTableview() {
        colCode.setCellValueFactory(new PropertyValueFactory<>("code"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));

        colCode.setResizable(false);
        colName.setResizable(false);
        colSalary.setResizable(false);

        observableList = FXCollections.observableArrayList(this);
        tvEmloyee.setItems(observableList);
    }

    private void alertError(String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    private void alertSuccess(String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Successfully");
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}