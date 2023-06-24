package vn.employeefile;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

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
    private Button btnAdd;

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnConfirm;

    @FXML
    private Button btnPromoting;

    @FXML
    private Button btnRemove;

    @FXML
    private Button btnSave;

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

    private ObservableList<Emloyee> observableList;

    public void initialize() {
        readFile();
        addDataToTableview();
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
        if (txtName.getText().isEmpty() || txtCode.getText().isEmpty() || txtSalary.getText().isEmpty()) {
            alertError("Some input is empty, please fill it!!!");
            return;
        }

        int code = Integer.parseInt(txtCode.getText());
        String name = txtName.getText();
        double salary = Double.parseDouble(txtSalary.getText());

        Emloyee emloyee = new Emloyee(code, name, salary);
        this.add(emloyee);

        observableList = FXCollections.observableArrayList(this);
        tvEmloyee.setItems(observableList);
    }

    @FXML
    void removeFromList() {
        int index = tvEmloyee.getSelectionModel().getSelectedIndex();
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