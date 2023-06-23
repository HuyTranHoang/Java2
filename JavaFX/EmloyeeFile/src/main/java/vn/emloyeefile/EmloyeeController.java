package vn.emloyeefile;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmloyeeController extends ArrayList<Emloyee> {

    @FXML
    private Button btnAdd;

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
    private TableView<Emloyee> tvEmloyee;

    @FXML
    private TextField txtCode;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtSalary;

    public void initialize() {
        readFile();
        addDataToTableview();
    }

    @FXML
    void readFile() {
        InputStream inputStream = getClass().getResourceAsStream("emloyee.txt");
        if (inputStream == null) return;
        String details;
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            while ((details = bufferedReader.readLine()) != null) {
                List<String> items = Arrays.asList(details.split(","));
                int code = Integer.parseInt(items.get(0));
                String name = items.get(1);
                double salary = Double.parseDouble(items.get(2));

                System.out.println(code);
                System.out.println(name);
                System.out.println(salary);

                Emloyee emloyee = new Emloyee(code, name, salary);
                System.out.println(emloyee);
                this.add(emloyee);
            }
            bufferedReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void addDataToTableview() {
        colCode.setCellValueFactory(new PropertyValueFactory<Emloyee, Integer>("Code"));
        colName.setCellValueFactory(new PropertyValueFactory<Emloyee, String>("Name"));
        colSalary.setCellValueFactory(new PropertyValueFactory<Emloyee, Double>("Salary"));

        ObservableList<Emloyee> observableList = FXCollections.observableArrayList(this);

        tvEmloyee.setItems(observableList);
    }
}